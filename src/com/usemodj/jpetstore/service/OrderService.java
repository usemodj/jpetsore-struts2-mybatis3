package com.usemodj.jpetstore.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.LineItem;
import com.usemodj.jpetstore.domain.Order;
import com.usemodj.jpetstore.domain.OrderStatus;
import com.usemodj.jpetstore.mappers.LineItemMapper;
import com.usemodj.jpetstore.mappers.OrderMapper;

public class OrderService {
	private static Logger logger = Logger.getLogger( OrderService.class);
	
	public void insertOrder(SqlSession sqlSession, Order order) {
		OrderMapper oMapper = sqlSession.getMapper( OrderMapper.class);
		LineItemMapper lMapper = sqlSession.getMapper( LineItemMapper.class);
		
		oMapper.insertOrderShippingAddr( order);
		
		for(LineItem lineItem : order.getLineItems()){
			lineItem.setOrderId( order.getOrderId());
			//Insert LineItem
			lMapper.insertLineItem( lineItem);
			//Insert OrderStatus
			OrderStatus oStatus = new OrderStatus(order.getOrderId(), lineItem.getLineNumber(),
										order.getOrderDate(), order.getStatus());
			oMapper.insertOrderStatus( oStatus);
		}
	}

	public List<Order> selectOrderListByUserId(SqlSession sqlSession, String userId,
			RowBounds rowBounds) {
		List<Order> orderList = null;
		OrderMapper oMapper = sqlSession.getMapper( OrderMapper.class);
		orderList = oMapper.selectOrderListByUserId( userId);
		for( Order order : orderList){
			BigDecimal totalPrice = new BigDecimal(0);
			List<LineItem> lineItems = order.getLineItems();
			for(LineItem lineItem: lineItems){
				//logger.debug("-- lineItem.getTotal():"+ lineItem.getTotal());
				totalPrice = totalPrice.add( lineItem.getTotal());
			}
			order.setTotalPrice(totalPrice);
			//logger.debug("==order.totalPrice: " + totalPrice);
		}
		return orderList;
	}

}
