package com.usemodj.jpetstore.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.usemodj.jpetstore.domain.Item;

public interface ItemMapper {

	public List<Item> selectItemList(String productId, RowBounds rowBounds) throws Exception;

	public Item selectItem(String itemId);

}
