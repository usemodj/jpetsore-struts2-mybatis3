package com.usemodj.jpetstore.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.usemodj.jpetstore.domain.Product;

public interface ProductMapper {

	public List<Product> selectProductList(String categoryId,
			RowBounds rowBounds) throws Exception; 

}
