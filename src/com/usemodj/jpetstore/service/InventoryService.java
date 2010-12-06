package com.usemodj.jpetstore.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Inventory;
import com.usemodj.jpetstore.domain.LineItem;
import com.usemodj.jpetstore.domain.Order;
import com.usemodj.jpetstore.mappers.InventoryMapper;

public class InventoryService {
	private static Logger logger = Logger.getLogger(InventoryService.class);

	public void updateQuantity(SqlSession sqlSession, Order order) {
		InventoryMapper iMapper = sqlSession.getMapper( InventoryMapper.class);
		for(LineItem lineItem : order.getLineItems()){
			Inventory inventory = new Inventory( lineItem.getItemId(), lineItem.getQuantity());
			//update inventory's qty
			iMapper.updateQuantity( inventory);
		}
	}
	
	
}
