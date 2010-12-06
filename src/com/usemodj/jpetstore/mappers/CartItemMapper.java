package com.usemodj.jpetstore.mappers;

import java.util.List;

import com.usemodj.jpetstore.domain.CartItem;

public interface CartItemMapper {

	public void deleteCartItemByUserId(String userId);

	public void insertCartItem(CartItem cItem);

	public List<CartItem> selectCartItemList(String userId);

}
