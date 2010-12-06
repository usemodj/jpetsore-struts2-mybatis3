package com.usemodj.jpetstore.struts.action;

import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Order;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class ShippingAction extends BaseAction {
	private static Logger logger = Logger.getLogger( ShippingAction.class);
	private Order order = null;
	private String url = null;
	
	@Override
	public String execute() throws Exception {
		logger.debug(" -- ShippingAction::execute() is called!! ");
		Signon signon = getSignon();
		if( null == signon){
			this.addActionMessage( getText("login.required"));
			url = request.getContextPath()+"/login_input?url="+ getText("hostname")+ request.getRequestURI();
			return Constants.REDIRECT;
		}
		if( null == order){
			this.addActionMessage( getText("order.shipping.information.required"));
			return INPUT;
		}
		//TODO: Order is saved at session
		order.setUsername( signon.getUsername());
		this.setSession( Constants.ORDER, order);
		
		return SUCCESS;
	}
	
	@Override
	public String input() throws Exception {
		Signon signon = getSignon();
		if( null == signon){
			this.addActionMessage( getText("login.required"));
			url = request.getContextPath()+"/login_input?url="+ getText("hostname")+ request.getRequestURI();
			//request.setAttribute( Constants.URL, url);
			return Constants.REDIRECT;
		}
		this.order = new Order();
		this.order.setUsername( signon.getUsername());
		return INPUT;
	}
	
	public Signon getSignon(){
		return (Signon)this.getSession(LOGIN);
	}
	
	// --- getter/setter ---
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
