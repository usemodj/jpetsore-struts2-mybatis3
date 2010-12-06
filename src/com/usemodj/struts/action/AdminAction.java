package com.usemodj.struts.action;

import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.struts.Constants;
import com.usemodj.struts.Role;

public class AdminAction extends BaseAction {
	private static Logger logger = Logger.getLogger(AdminAction.class);
	protected String url = null;
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
    	if( !isAdmin()){
        	this.addActionMessage(getText("admin.login.required"));
    		this.url = request.getContextPath()+"?"+ request.getQueryString();
    		return Constants.REDIRECT;
    	}
		return SUCCESS;
    }

    public String input() throws Exception {
        return INPUT;
    }
    
    protected boolean isAdmin(){
    	Signon signon = (Signon)this.getSession( this.LOGIN);
    	logger.debug("--isAdmin: role: "+ Role.ADMIN + ". Signon.role: "+ signon.getRole());
    	return (null != signon) && Role.ADMIN.equals(signon.getRole());
    }
    protected boolean isManager(){
    	Signon signon = (Signon)this.getSession( this.LOGIN);
    	logger.debug("--isManager: role: "+ Role.MANAGER + ". Signon.role: "+ signon.getRole());
    	return (null != signon) && Role.MANAGER.equals(signon.getRole());
    }
    protected boolean isGeneral(){
    	Signon signon = (Signon)this.getSession( this.LOGIN);
    	logger.debug("--isGeneral: role: "+ Role.GENERAL + ". Signon.role: "+ signon.getRole());
    	return (null != signon) && Role.GENERAL.equals(signon.getRole());
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
}
