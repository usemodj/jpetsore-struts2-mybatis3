package com.usemodj.struts.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.usemodj.mybatis.builder.MybatisConfig;
import com.usemodj.struts.Constants;

public class BaseAction extends ActionSupport implements SessionAware,
		ApplicationAware, ServletRequestAware,ServletResponseAware  {

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
        return SUCCESS;
    }

    public String input() throws Exception {
        return INPUT;
    }

    // ---- ApplicationAware ----
    /**
     * <p>Field to store application context or its proxy.</p>
     * <p/>
     * <p>The application context lasts for the life of the application. A
     * reference to the database is stored in the application context at
     * startup.</p>
     */
    private Map<String, Object> application;

    /**
     * <p>Store a new application context.</p>
     *
     * @param value A Map representing application state
     */
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	public void setApplication( String key, Object value){
		this.getApplication().put(key, value);
	}
    /**
     * <p>Provide application context.</p>
     */
    public Map<String, Object> getApplication() {
    	if( null == this.application) this.setApplication( new HashMap<String, Object>());
        return this.application;
    }
    public Object getApplication( String key){
    	return this.getApplication().get(key);
    }
    // ---- SessionAware ----

    /**
     * <p>Field to store session context, or its proxy.</p>
     */
    private Map<String, Object> session;

    /**
     * <p>Store a new session context.</p>
     *
     * @param value A Map representing session state
     */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setSession(String key, Object value){
		this.getSession().put(key, value);
	}
    /**
     * <p>Provide session context.</p>
     *
     * @return session context
     */
    public Map<String, Object> getSession() {
		if( null == this.session) this.setSession(new HashMap<String, Object>());
        return this.session;
    }
    public Object getSession( String key){
    	return this.getSession().get(key);
    }
    public void removeSession( String key){
    	if( this.getSession().containsKey(key))
    		this.getSession().remove(key);
    }
    
    /**
     * MyBatis SqlSessionFactory of Application scope
     */
	public SqlSessionFactory getSqlSessionFactory() {
		Object factory = getApplication(Constants.SQL_SESSION_FACTORY);
		if( null == factory) {
			// create SqlSessionFactory
		    factory = new MybatisConfig().getSqlSessionFactory();
		    setSqlSessionFactory((SqlSessionFactory)factory);
		}
		return (SqlSessionFactory)factory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	    setApplication(Constants.SQL_SESSION_FACTORY, sqlSessionFactory);
	}
	/**
	 * 		-- ServletRequestAware --
	 */
	protected HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	protected HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response){
		this.response = response;
	}
}
