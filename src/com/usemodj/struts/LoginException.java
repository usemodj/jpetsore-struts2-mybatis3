package com.usemodj.struts;

public class LoginException extends Exception {
	private static final long serialVersionUID = 384601361278035675L;

	public LoginException() {
		super("login.exception");
	}

	public LoginException(String message) {
		super(message);
	}

}
