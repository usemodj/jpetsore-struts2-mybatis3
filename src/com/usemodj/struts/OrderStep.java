package com.usemodj.struts;

public enum OrderStep {
	OD("Order","주문"),
	CC("Cancel", "취소"),
	RC("Receipts","입금"),
	SP("Shipping","배송"),
	FS("Finish", "완료"),
	RT("Return","반송");
	
	private String fullName;
	private String koName;
	OrderStep(String fullName, String koName){
		this.fullName = fullName;
		this.koName = koName;
	}
	String fullName(){
		return this.fullName;
	}
	String koName(){
		return this.koName;
	}
}
