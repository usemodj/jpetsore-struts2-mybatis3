package com.usemodj.jpetstore.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Category;
import com.usemodj.jpetstore.mappers.CategoryMapper;

public class CategoryService {
	private static Logger logger = Logger.getLogger( CategoryService.class);

	public List<Category> selectCategoryList(SqlSession openSession,
			RowBounds rowBounds) throws Exception {
		List<Category> catList = null;
		try {
			CategoryMapper cMapper = openSession.getMapper( CategoryMapper.class);
			catList = cMapper.selectCategoryList( rowBounds);
		} catch (Exception e) {
			logger.error( " selectCategoryList() Exception : " + e.getMessage());
			throw e;
		} finally {
			openSession.close();
		}
		return catList;
	}
	
}
