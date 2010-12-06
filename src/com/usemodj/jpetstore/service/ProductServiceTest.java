package com.usemodj.jpetstore.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.usemodj.jpetstore.domain.Product;
import com.usemodj.mybatis.builder.MybatisConfig;

public class ProductServiceTest {
	private static Logger logger = Logger.getLogger( ProductService.class);
	private static SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
	    sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
	}

	@Test
	public void testSelectProductList() {
		
		ProductService pService = new ProductService();
		String categoryId= "DOGS";
		RowBounds rowBounds = new RowBounds(0, 3);
		List<Product> pList = null;
		try {
			pList = pService.selectProductList(sqlSessionFactory.openSession(), categoryId, rowBounds);
			for( Product p: pList){
				logger.debug(" CategoryId: " + p.getCategoryId() + ", Name: "+ p.getName()
						+ ", productId: " + p.getProductId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error(" testSelectProductList() Exception :" + e.getMessage());
		}
		
	}

}
