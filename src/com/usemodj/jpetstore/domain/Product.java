package com.usemodj.jpetstore.domain;

import java.io.Serializable;

import com.usemodj.struts.Status;


public class Product implements Serializable {

  private String productId;
  private String categoryId;
  private String name;
  private String description;
  private Status status;
  
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId.trim();
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}

public String toString() {
    return getName();
  }

}
