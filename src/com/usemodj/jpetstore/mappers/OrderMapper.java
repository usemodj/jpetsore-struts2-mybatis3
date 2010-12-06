package com.usemodj.jpetstore.mappers;

import java.util.List;

import com.usemodj.jpetstore.domain.Order;
import com.usemodj.jpetstore.domain.OrderStatus;

public interface OrderMapper {

	void insertOrderShippingAddr(Order order);

	void insertOrderStatus(OrderStatus oStatus);

	List<Order> selectOrderListByUserId(String userId);

}
