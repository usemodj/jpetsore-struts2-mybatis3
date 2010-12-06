package com.usemodj.struts;

public enum Status {
	AT("Active","활성"),
	IA("Inactive","비활성"),
	DL("Delete","삭제");
	
	private String fullName;
	private String koName;
	Status(String fullName, String koName){
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
