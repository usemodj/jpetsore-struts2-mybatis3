package com.usemodj.jpetstore.struts.action;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Item;
import com.usemodj.jpetstore.service.ItemService;
import com.usemodj.struts.Constants;
import com.usemodj.struts.action.BaseAction;

public class ItemAction extends BaseAction {
	private static Logger logger = Logger.getLogger( ItemAction.class);
	protected ItemService itemService = new ItemService();
	private List<Item> itemList;
	private Item item;
	
	public String execupte() throws Exception {
		return SUCCESS;
	}
	public String input() throws Exception {
		return INPUT;
	}
	public String list() throws Exception {
		String productId = item.getProductId();
		int offset = RowBounds.NO_ROW_OFFSET;
		int limit = RowBounds.NO_ROW_LIMIT;
		RowBounds rowBounds = new RowBounds( offset, limit);
		List<Item> itemList = itemService.selectItemList(this.getSqlSessionFactory().openSession(), productId, rowBounds);
		this.setItemList(itemList);
		
		return Constants.LIST;
	}
	public String view() throws Exception {
		String itemId = item.getItemId();
		Item item = itemService.selectItem(this.getSqlSessionFactory().openSession(), itemId);
		this.setItem(item);
		return Constants.VIEW;
	}
	
	// -- setter/getter --
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	
}
