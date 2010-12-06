package com.usemodj.jpetstore.mappers;

import com.usemodj.jpetstore.domain.Inventory;

public interface InventoryMapper {

	public int selectQtyByItemId(String itemId);

	public void updateQuantity(Inventory inventory);

}
