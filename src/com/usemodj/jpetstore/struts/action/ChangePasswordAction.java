package com.usemodj.jpetstore.struts.action;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.service.SignonService;
import com.usemodj.struts.UpdatePasswordException;
import com.usemodj.struts.action.BaseAction;

public class ChangePasswordAction extends BaseAction {
	private static final long serialVersionUID = -122471821572332138L;
	private static Logger logger = Logger.getLogger(ChangePasswordAction.class);
	private Signon signon;
	
	public String execute() throws Exception {
		logger.debug("..ChangePasswordAtion.execute() is called..");
		Signon _signon = (Signon)this.getSession(LOGIN);
		if( null == _signon) {
			logger.debug("..Login Session is null!");
			this.addActionMessage(getText("login.required"));
			return LOGIN;
		}
		if( null == signon || null == signon.getPassword() || null == signon.getPasswordNew()
				|| null == signon.getPasswordConfirm() || signon.getPasswordNew().isEmpty() 
				|| !signon.getPasswordNew().equals(signon.getPasswordConfirm())
				|| !signon.getPassword().equals(_signon.getPassword())){
			this.addActionMessage( getText("password.mismatch"));
			logger.debug("..password mismatch!");
			return INPUT;
		}
		SqlSessionFactory factory = this.getSqlSessionFactory();
		SignonService signonService = new SignonService();
		try {
			logger.debug("..signonService.updatePassword is called....");
			_signon.setPassword( signon.getPasswordNew());
			signonService.updatePassword(factory.openSession(), _signon);
			this.setSession(LOGIN, _signon);
		
		} catch (UpdatePasswordException e) {
			logger.error(getText("update.password.exception")+ ": "+ e.getMessage());
			this.addActionMessage( getText("update.password.exception"));
			return INPUT;
		}catch (Exception e) {
			logger.error( e.getMessage());
			return INPUT;
		}
		this.addActionMessage( getText("change.password.success"));
		return SUCCESS;
	}
	public String input() throws Exception {
		//비밀번호 변경은 로그인 상태에서 가능하다.
		Signon _signon = (Signon)this.getSession(LOGIN);
		if( null == _signon) {
			this.addActionMessage(getText("login.required"));
			return LOGIN;
		}
		return INPUT;
	}
	public Signon getSignon() {
		return signon;
	}
	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
}
