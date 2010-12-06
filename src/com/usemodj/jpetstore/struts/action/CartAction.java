package com.usemodj.jpetstore.struts.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Cart;
import com.usemodj.jpetstore.domain.CartItem;
import com.usemodj.jpetstore.domain.Category;
import com.usemodj.jpetstore.domain.Item;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.service.CartService;
import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class CartAction extends BaseAction {
	private static Logger logger = Logger.getLogger(CartAction.class);
	private CartService cartService = new CartService();
	private Cart cart = null;
	private String itemId = null;
	private int quantity = 0;
	private String url = null;
	
	public String execute() throws Exception{
		getCart();
		return SUCCESS;
	}
	
	public String input() throws Exception {
		return INPUT;
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String save(){
		Signon signon = (Signon)this.getSession(LOGIN);
		if( null == signon){
			this.addActionMessage( getText("login.required"));
			return LOGIN;
		}
		Cart _cart = getCart();
		if( null == _cart || _cart.getNumberOfItems() < 1)
			return INPUT;
		SqlSession sqlSession = this.getSqlSessionFactory().openSession();
		try {
			logger.debug(" -- userId= "+ signon.getUsername() +", item size="+ _cart.getNumberOfItems());
			cartService.saveCart( sqlSession, _cart, signon.getUsername());
			sqlSession.commit();
		} catch (Exception e) {
			logger.info("CartAction.save() CartService.saveCart() Exception: " + e.getMessage());
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return INPUT;
	}
	public String addItemToCart(){
		Cart _cart = getCart();
		logger.info("-- url=" + url);
		logger.debug(" -- itemId="+ itemId + ", cart item count="+ cart.getNumberOfItems());
		if( _cart.containsItemId(itemId)){
			_cart.incrementQuantityByItemId(itemId);
		}else{
			SqlSession sqlSession = this.getSqlSessionFactory().openSession();
			try {
				boolean isInStock = cartService.isItemInStock(sqlSession, itemId);
				Item item = cartService.getItem(sqlSession, itemId);
				_cart.addItem(item,getQuantity(), isInStock);
				
				
			} catch (Exception e) {
				logger.info(" addItemToCart() Exception : "+ e.getMessage());
			} finally {
				sqlSession.close();
			}
		}
		return INPUT;
	}
	
	public String removeItemFromCart(){
		logger.debug(" removeItemFromCart() itemId= "+ itemId);
		getCart().removeItemById(itemId);
		return INPUT;
	}
	public String updateCartQuantities(){
		//Map paramMap = request.getParameterMap();
		
		//Collection<CartItem> cartItems = getCart().getCartItemList();
		Iterator<CartItem> cartItems = getCart().getCartItems();
		if( null == cartItems){
			logger.debug("--updateCartQuantities() cartItems is null or size 0");
			return INPUT;
		}
		while(cartItems.hasNext()){
			CartItem cartItem = (CartItem)cartItems.next();
			String itemId = cartItem.getItem().getItemId();
			try {
				logger.debug(" itemId="+ itemId + ", param itemId value= "+ 
						request.getParameter(itemId));
				int quantity = Integer.parseInt( (String)request.getParameter(itemId));
				if( quantity < 1){
					cartItems.remove();
					continue;
				}
				getCart().setQuantityByItemId(itemId, quantity);
			} catch (NumberFormatException e) {
				// ignore parse exception on purpose
				logger.info(" CartAction.updateCartQuantities() NumberFormatException : " + e.getMessage());
			}
		}
		//this.setSession( Constants.CART, this.cart);
		return INPUT;
	}
	
	public String checkout(){
		this.getCart();
		return Constants.CHECKOUT;
	}
	public Cart getCart() {
		if( null == this.cart){
			logger.debug(" -- if( null == this.cart)...");
			this.cart = (Cart)this.getSession( Constants.CART);
			if( null != this.cart){
				logger.debug(" -- cart.getMumberOfItems= " +this.cart.getNumberOfItems());
				logger.debug("--cart.getCartItemList.size="+this.cart.getCartItemList().size());
			}
		}
		Signon signon = (Signon)this.getSession(LOGIN);
		if( null == this.cart && null != signon){
			logger.debug(" --if( null == this.cart && null != signon)..." );
			SqlSession sqlSession = null;
			try {
				sqlSession = this.getSqlSessionFactory().openSession();
				Cart _cart = cartService.selectCart(sqlSession, signon.getUsername());
				setCart( _cart);
			} catch (Exception e) {
				logger.info("-- getCart() Exception: " + e.getMessage());
			} finally {
				sqlSession.close();
			}
		}
		if(null == this.cart) {
			logger.debug(" -- if( null == this.cart) set new Cart()...");
			setCart( new Cart());
		}
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
		this.setSession( Constants.CART, this.cart);
	}
	public void clear() {
		this.cart = new Cart();
		this.removeSession( Constants.CART);
	}
	
}
