package com.usemodj.blog.struts.action;

import com.usemodj.blog.service.BlogService;
import com.usemodj.struts.action.BaseAction;

public class BlogAction extends BaseAction {

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
    	//TODO: Blog execute() method
    	BlogService blog = new BlogService();
    	//blog.
        return SUCCESS;
    }

    public String input() throws Exception {
    	//TODO: 
        return INPUT;
    }

}
