package com.usemodj.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Cart implements Serializable {
	// key itemId String, value CartItem
  private final Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
  //private final List<CartItem> itemList = new ArrayList<CartItem>();

  public Iterator<CartItem> getCartItems() {
    //return itemList.iterator();
	  return itemMap.values().iterator();
  }

  public Collection<CartItem> getCartItemList() {
    //return itemList;
	  return itemMap.values();
  }

  public int getNumberOfItems() {
    //return itemList.size();
	  return itemMap.size();
  }

  public boolean containsItemId(String itemId) {
    return itemMap.containsKey(itemId);
  }

  public void addItem(Item item, int quantity, boolean isInStock) {
    CartItem cartItem = itemMap.get(item.getItemId());
    if (cartItem == null) {
      cartItem = new CartItem();
      cartItem.setItem(item);
      cartItem.setQuantity( quantity);
      cartItem.setInStock(isInStock);
      itemMap.put(item.getItemId(), cartItem);
    }
    else cartItem.incrementQuantity();
  }

  public void addCartItem( String itemId, CartItem cartItem){
	  itemMap.put(itemId, cartItem);
  }
  public Item removeItemById(String itemId) {
    CartItem cartItem = itemMap.remove(itemId);
    if (cartItem == null) {
      return null;
    } else {
      //itemList.remove(cartItem);
      return cartItem.getItem();
    }
  }

  public void incrementQuantityByItemId(String itemId) {
    CartItem cartItem = itemMap.get(itemId);
    cartItem.incrementQuantity();
  }

  public void setQuantityByItemId(String itemId, int quantity) {
    CartItem cartItem = itemMap.get(itemId);
    cartItem.setQuantity(quantity); //calculateTotal() called
  }

  public BigDecimal getSubTotal() {
    BigDecimal subTotal = new BigDecimal("0");
    Iterator<CartItem> items = getCartItems();
    while (items.hasNext()) {
      CartItem cartItem = items.next();
      Item item = cartItem.getItem();
      BigDecimal listPrice = item.getListPrice();
      BigDecimal quantity = new BigDecimal( cartItem.getQuantity());
      subTotal = subTotal.add(listPrice.multiply(quantity));
    }
    return subTotal;
  }

}
