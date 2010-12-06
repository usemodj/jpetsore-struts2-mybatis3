package com.usemodj.blog.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.usemodj.blog.domain.Blog;
import com.usemodj.blog.mappers.BlogMapper;

public class BlogService {
	public List selectBlogList(SqlSession session, RowBounds rowBounds) {
		//TODO:
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		//mapper.
		return null;
	}
}
