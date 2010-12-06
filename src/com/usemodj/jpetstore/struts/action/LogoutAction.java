package com.usemodj.jpetstore.struts.action;

import org.apache.log4j.Logger;

import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class LogoutAction extends BaseAction {
	private static Logger logger = Logger.getLogger( LogoutAction.class);
	private String url = null;
	
    public String execute() throws Exception {
    	logout();
    	//url = request.getParameter( Constants.URL);
    	if( null == url) {
    		url = (String)request.getAttribute( Constants.URL);
    	}
    	if( null != url) return Constants.REDIRECT;
        return SUCCESS;
    }

    public String input() throws Exception {
        return INPUT;
    }
    
    public void logout() throws Exception {
    	logger.debug(" -- logout method called!!");
    	this.removeSession( this.LOGIN);
    	//return Constants.LOGOUT;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
