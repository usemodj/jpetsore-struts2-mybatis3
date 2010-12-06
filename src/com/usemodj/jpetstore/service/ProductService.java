package com.usemodj.jpetstore.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Product;
import com.usemodj.jpetstore.mappers.ProductMapper;

public class ProductService {
	private static Logger logger = Logger.getLogger( ProductService.class);
	
	public List<Product> selectProductList(SqlSession openSession,
			String categoryId, RowBounds rowBounds) throws Exception {
		List<Product> proList = null;
		try {
			//proList = openSession.selectList("selectProductList", categoryId, rowBounds);
			ProductMapper pMapper = openSession.getMapper( ProductMapper.class);
			proList = pMapper.selectProductList( categoryId, rowBounds);
		} catch (Exception e) {
			logger.error( " selectProductList() Exception : " + e.getMessage());
			throw e;
		}
		return proList;
	}

}
