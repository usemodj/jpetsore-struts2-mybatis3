package com.usemodj.jpetstore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Cart;
import com.usemodj.jpetstore.domain.CartItem;
import com.usemodj.jpetstore.domain.Item;
import com.usemodj.jpetstore.mappers.CartItemMapper;
import com.usemodj.jpetstore.mappers.InventoryMapper;
import com.usemodj.jpetstore.mappers.ItemMapper;

public class CartService {
	private static Logger logger = Logger.getLogger( CartService.class);

	public boolean isItemInStock(SqlSession sqlSession, String itemId) {
		int qty =0;
		try {
			InventoryMapper iMapper = sqlSession.getMapper( InventoryMapper.class);
			qty = iMapper.selectQtyByItemId( itemId);
		} catch (Exception e) {
			logger.info(" CartService.isItemInStock() Exception : " + e.getMessage());
		}
		return (qty > 0);
	}

	public Item getItem(SqlSession sqlSession, String itemId) {
		ItemMapper iMapper = sqlSession.getMapper( ItemMapper.class);
		return iMapper.selectItem( itemId);
	}

	public void saveCart(SqlSession sqlSession, Cart cart, String userId) {
		CartItemMapper cMapper =  sqlSession.getMapper( CartItemMapper.class);
		cMapper.deleteCartItemByUserId( userId);
		for( CartItem cartItem : cart.getCartItemList()){
			cartItem.setUserId(userId);
			Item item = cartItem.getItem();
			cartItem.setItemId( item.getItemId());
			logger.debug(" -- CartItem itemId="+ cartItem.getItemId() + ", userId="+ cartItem.getUserId());
			cMapper.insertCartItem( cartItem);
		}
		
	}

	public Cart selectCart(SqlSession sqlSession, String userId) {
		CartItemMapper cMapper = sqlSession.getMapper( CartItemMapper.class);
		List<CartItem> cList = cMapper.selectCartItemList( userId);
		Cart cart = new Cart();
		for( CartItem cartItem : cList){
			cart.addCartItem(cartItem.getItem().getItemId(), cartItem);
		}
		return cart;
	}

	public void removeCartItem(SqlSession openSession, String userId) {
		CartItemMapper cMapper = openSession.getMapper( CartItemMapper.class);
		cMapper.deleteCartItemByUserId(userId);
	}

}
