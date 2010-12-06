package com.usemodj.jpetstore.struts.action;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Account;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.service.SignonService;
import com.usemodj.struts.CreateAccountException;
import com.usemodj.struts.action.BaseAction;

public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = -524552703410060590L;
	private static Logger logger = Logger.getLogger(RegisterAction.class);
	private SignonService signonService = new SignonService();
	private Signon signon;
	private Account account;
	
	public String execute() throws Exception {
		SqlSessionFactory factory = this.getSqlSessionFactory();
		Signon _signon = signonService.selectSignon(factory.openSession(), signon.getUsername());
		if(null != _signon) {
			this.addActionMessage(getText("using.username"));
		}
		if( !signon.getPassword().equals(signon.getPasswordConfirm())){
			this.addActionMessage(getText("mismatch.password"));
		}
		if( this.hasActionMessages() || this.hasActionErrors()) return INPUT;
		try {
			account.setUserid( signon.getUsername());
			signonService.createSignonAndAccount(factory.openSession(), signon, account);
		} catch (CreateAccountException e) {
			//e.printStackTrace();
			logger.error( getText("error.create.signon.account") + " : " + e.getMessage());
			return INPUT;
		}
		//login session scope
		this.setSession(LOGIN, signon);
		this.addActionMessage(getText("success.create.signon.account"));
		return SUCCESS;
	}
	public String input() throws Exception {
		
		return INPUT;
	}
	
	public Signon getSignon() {
		return signon;
	}
	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
