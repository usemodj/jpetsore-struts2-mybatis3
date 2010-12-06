package com.usemodj.jpetstore.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.usemodj.jpetstore.domain.Category;

public interface CategoryMapper {

	List<Category> selectCategoryList(RowBounds rowBounds) throws Exception;

}
