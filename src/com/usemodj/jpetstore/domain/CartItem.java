package com.usemodj.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class CartItem implements Serializable {

	private String userId;
	private String itemId;
	private int quantity;
	private boolean inStock;
	private BigDecimal total;
	private Date	createOn;
	private Item item;
  
  
  public String getItemId() {
	return itemId;
}

public void setItemId(String itemId) {
	this.itemId = itemId;
}

public Date getCreateOn() {
	return createOn;
}

public void setCreateOn(Date createOn) {
	this.createOn = createOn;
}

  public boolean isInStock() {
    return inStock;
  }

  public void setInStock(boolean inStock) {
    this.inStock = inStock;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
    calculateTotal();
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
    calculateTotal();
  }
  

  public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public void setTotal(BigDecimal total) {
	this.total = total;
}

public void incrementQuantity() {
    quantity++;
    calculateTotal();
  }

  private void calculateTotal() {
    if (item != null && item.getListPrice() != null) {
      total = item.getListPrice().multiply(new BigDecimal(quantity));
    } else {
      total = null;
    }
  }

}
