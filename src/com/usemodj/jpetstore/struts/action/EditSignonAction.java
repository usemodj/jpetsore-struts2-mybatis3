package com.usemodj.jpetstore.struts.action;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Account;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.service.AccountService;
import com.usemodj.jpetstore.service.SignonService;
import com.usemodj.struts.action.BaseAction;

public class EditSignonAction extends BaseAction {
	private static Logger logger = Logger.getLogger( EditSignonAction.class);
	
	private Signon signon;
	private Account account;
	SignonService signonService = new SignonService();
	AccountService accountService = new AccountService();
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	
    /**
     * A default implementation that does nothing an returns "success".
     * <p/>
     * Subclasses should override this method to provide their business logic.
     * <p/>
     * See also {@link com.opensymphony.xwork2.Action#execute()}.
     *
     * @return returns {@link #SUCCESS}
     * @throws Exception can be thrown by subclasses.
     */
    public String execute() throws Exception {
    	this.signon = (Signon)this.getSession(LOGIN);
    	if( null == this.signon) {
    		this.addActionMessage(this.getText("login.required"));
    		return this.LOGIN;
    	}
    	
    	SqlSessionFactory factory = this.getSqlSessionFactory();
    	this.account.setUserid(this.signon.getUsername());
    	Account _account = accountService.selectAccount(factory.openSession(), this.signon.getUsername());
        if( null == _account) {
        	logger.debug(" -- There is no account information!! and then create the account");
        	accountService.insertAccount( factory.openSession(), this.account);
        } else { 
        	logger.debug(" -- Update Account Information...");
        	accountService.updateAccount( factory.openSession(), this.account);
        }
        return SUCCESS;
    }

    public String input() throws Exception {
    	this.signon = (Signon)this.getSession(LOGIN);
    	if( null == this.signon) {
    		this.addActionMessage( getText("login.required"));
    		return this.LOGIN;
    	}
    	
    	SqlSessionFactory factory = this.getSqlSessionFactory();
    	Account _account = accountService.selectAccount(factory.openSession(), this.signon.getUsername());
        if( null == _account) 
        	this.account = new Account(this.signon.getUsername());
         else 
        	this.account = _account;

        return INPUT;
    }

}
