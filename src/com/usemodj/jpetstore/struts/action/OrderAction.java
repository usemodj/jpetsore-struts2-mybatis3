package com.usemodj.jpetstore.struts.action;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Cart;
import com.usemodj.jpetstore.domain.Order;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.service.CartService;
import com.usemodj.jpetstore.service.InventoryService;
import com.usemodj.jpetstore.service.OrderService;
import com.usemodj.jpetstore.service.SequenceService;
import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class OrderAction extends BaseAction {
	private static Logger logger = Logger.getLogger( OrderAction.class);
	SequenceService sequenceService = new SequenceService();
	InventoryService inventoryService = new InventoryService();
	OrderService 	orderService = new OrderService();
	CartService 	cartService = new CartService();
	Cart cart = null;
	Order order = null;
	List<Order> orderList = null;
	
	@Override
	public String execute() throws Exception {
		Signon signon = (Signon) this.getSession(LOGIN);
		this.cart = getCart();
		this.order = getOrder();
		if(null == signon) {
			this.addActionMessage( getText("login.required"));
			request.setAttribute(Constants.URL, "/shop/order_input");
			return LOGIN;
		}
		if( null == cart || cart.getNumberOfItems()<1){
			this.addActionMessage( getText("cart.empty"));
			return Constants.CART;
		}
		if( null == order){
			this.addActionMessage( getText("order.empty"));
			return Constants.CART;
		}
		order.initOrder( signon.getUsername(), cart);
		//get Order Sequence
		int orderId = getOrderId();
		order.setOrderId(orderId);
		SqlSession sqlSession = this.getSqlSessionFactory().openSession();
		try {
			inventoryService.updateQuantity( sqlSession, order);
			orderService.insertOrder(sqlSession, order);
			sqlSession.commit();
		} catch (Exception e) {
			logger.error(" OrderAction.execute(): " + e.getMessage());
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		removeCartAndOrder();
		
		return SUCCESS;
	}
	@Override
	public String input() throws Exception {
		this.cart = getCart();
		this.order = getOrder();
		//TODO: if cart == null || order == null
		return INPUT;
	}
	public String list() throws Exception {
		Signon signon = (Signon) this.getSession(LOGIN);
		if(null == signon) {
			this.addActionMessage( getText("login.required"));
			request.setAttribute(Constants.URL, "/shop/order_list");
			
			return LOGIN;
		}
		RowBounds rowBounds = new RowBounds(0, 50);
		SqlSession sqlSession = this.getSqlSessionFactory().openSession();
		orderList = orderService.selectOrderListByUserId( sqlSession, signon.getUsername(), rowBounds);
		logger.debug(" -- orderList size: "+ orderList.size());
		if( logger.isDebugEnabled()){
			for(Order order : orderList){
				logger.debug(" -- orderId: "+ order.getOrderId());
				logger.debug("  userId: " + order.getUsername());
				logger.debug("  lineItem size: " + order.getLineItems().size());
				logger.debug("  orderStatus size: " + order.getOrderStatuses().size());
			}
		}
		return Constants.LIST;
	}
	
	public Cart getCart(){
		return (Cart)this.getSession( Constants.CART);
	}
	public Order getOrder(){
		return (Order)this.getSession( Constants.ORDER);
	}
	public int getOrderId() throws Exception{
		SqlSession sqlSession = this.getSqlSessionFactory().openSession();
		int orderId = 0;
		try {
			orderId = sequenceService.getNextId( sqlSession, Constants.SEQUENCE_ORD);
			sqlSession.commit();
		} catch (Exception e) {
			logger.error(" OrderAction.execute() Exception: " + e.getMessage());
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return orderId;
	}
	
	public void removeCartAndOrder(){
		Signon signon = (Signon) this.getSession(LOGIN);
		SqlSession sqlSession = null;
		try {
			sqlSession = this.getSqlSessionFactory().openSession();
			cartService.removeCartItem( sqlSession, signon.getUsername());
			logger.info( "CartService.removeCartItem() called...userid="+ signon.getUsername());
			sqlSession.commit();
		} catch (Exception e) {
			logger.error( "OrderAction cartService.removeCartItem() Exception: "+ e.getMessage());
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		this.removeSession( Constants.CART);
		this.removeSession( Constants.ORDER);
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
}
