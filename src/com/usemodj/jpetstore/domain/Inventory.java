package com.usemodj.jpetstore.domain;

import java.io.Serializable;

public class Inventory implements Serializable {
	private String itemId;
	private int qty;
	public Inventory(){
		this.itemId = null;
		this.qty = 0;
	}
	public Inventory( String itemId, int qty){
		this.itemId = itemId;
		this.qty = qty;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
