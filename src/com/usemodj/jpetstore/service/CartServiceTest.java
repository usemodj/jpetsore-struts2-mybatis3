package com.usemodj.jpetstore.service;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.usemodj.jpetstore.domain.Cart;
import com.usemodj.jpetstore.domain.CartItem;
import com.usemodj.mybatis.builder.MybatisConfig;

public class CartServiceTest {
	private static Logger logger = Logger.getLogger( CartServiceTest.class);
	private static SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
	    sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
	}

	@Test
	public void testSelectCart() {
		String userId = "j2ee";
		CartService service = new CartService();
		Cart cart = service.selectCart(sqlSessionFactory.openSession(), userId);
		for( CartItem cartItem : cart.getCartItemList()){
			logger.debug("-- cartItem.itemId=" + cartItem.getItemId());
			logger.debug("-- cartItem.quantity=" + cartItem.getQuantity());
			logger.debug("-- cartItem.userId=" + cartItem.getUserId());
			logger.debug("-- cartItem.item.itemId=" + cartItem.getItem().getItemId());
			
		}
	}

}
