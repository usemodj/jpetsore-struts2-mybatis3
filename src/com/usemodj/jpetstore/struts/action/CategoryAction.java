package com.usemodj.jpetstore.struts.action;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Category;
import com.usemodj.jpetstore.service.CategoryService;
import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class CategoryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(CategoryAction.class);
	private CategoryService categoryService = new CategoryService();
	private List<Category> categoryList;
	
	public String execute() throws Exception{
		
		return SUCCESS;
	}
	
	public String input() throws Exception {
		return INPUT;
	}
	public String list() throws Exception {
		int offset = RowBounds.NO_ROW_OFFSET;
		int limit = RowBounds.NO_ROW_LIMIT;
		RowBounds rowBounds = new RowBounds();
		List<Category> categoryList = categoryService.selectCategoryList(this.getSqlSessionFactory().openSession(), rowBounds);
		this.setCategoryList(categoryList);
		
		return Constants.LIST;
	}
	// -- getter/setter --
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}


}
