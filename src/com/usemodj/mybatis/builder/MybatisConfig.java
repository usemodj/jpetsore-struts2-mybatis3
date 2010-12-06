package com.usemodj.mybatis.builder;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MybatisConfig {
	private static Logger logger = Logger.getLogger(MybatisConfig.class);
	static String RESOURCE = "MapperConfig.xml";   

	public SqlSessionFactory getSqlSessionFactory() {
		try {
			Reader reader = Resources.getResourceAsReader(RESOURCE);          
			//SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//SqlSessionFactory factory = builder.build(reader);
			return new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			logger.error("reading error : " + RESOURCE, e);
		    throw new RuntimeException("Error initializing SqlSessionFactory. Cause: " + e, e);
		}
	}
}
