package com.usemodj.jpetstore.domain;

import java.io.Serializable;
import java.util.Date;

import com.usemodj.struts.OrderStep;

public class OrderStatus implements Serializable {
	private int orderId;
	private int lineNumber;
	private Date timestamp;
	private OrderStep status;
	
	public OrderStatus() {
		
	}
	public OrderStatus( int orderId, int lineNumber, Date timestamp, OrderStep status){
		this.orderId = orderId;
		this.lineNumber = lineNumber;
		this.timestamp = timestamp;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public OrderStep getStatus() {
		return status;
	}
	public void setStatus(OrderStep status) {
		this.status = status;
	}
	
	
}
