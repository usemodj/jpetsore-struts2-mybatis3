package com.usemodj.jpetstore.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.service.SignonService;
import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class LoginAction extends BaseAction {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	
	private SignonService signonService = new SignonService();
	
	private Signon signon = null;
	private String url = null; //redirect url
	
	public String execute() throws Exception {
		Signon _signon = signonService.selectSignon( this.getSqlSessionFactory().openSession(), signon.getUsername());
		if( null == _signon || !_signon.getPassword().equals(this.signon.getPassword())) {
			this.signon.setPassword("");
			this.addActionError(getText("login.error"));
			return INPUT;
		}
		this.setSignon(_signon);
		this.setSession(this.LOGIN, this.signon);
		
    	//url = request.getParameter( Constants.URL);
    	if( null == url) {
    		url = (String)request.getAttribute( Constants.URL);
    	}
    	if( null != url) return Constants.REDIRECT;
        return SUCCESS;
    }
	/**
	 *  logout action process
	 */
    public String input() throws Exception {
    	//HttpServletRequest request = ServletActionContext.getRequest();
    	String logout = request.getParameter( Constants.LOGOUT);
    	if( null != logout && "true".equals(logout.toLowerCase())) {
    		logout();
    	}
//    	//url = request.getParameter( Constants.URL);
//    	if( null == url) {
//    		url = (String)request.getAttribute( Constants.URL);
//    	}
//    	if( null != url) return Constants.REDIRECT;
    	//this.signon = new Signon();
        return INPUT;
    }
    public void logout() throws Exception {
    	logger.debug(" -- logout method called!!");
    	this.removeSession( this.LOGIN);
    }
    
    // -- getter/setter --
    public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    
}
