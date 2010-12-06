package com.usemodj.mybatis.builder;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.usemodj.blog.domain.Author;
import com.usemodj.blog.domain.Section;
import com.usemodj.blog.mappers.AuthorMapper;

public class MybatisConfigTest {
	  private static SqlSessionFactory sqlSessionFactory;

	  @BeforeClass
	  public static void setup() throws Exception {
	    sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
	  }
	  
	  @Test
	  public void shouldSelectAuthor(){
		  SqlSession session = sqlSessionFactory.openSession();
		  try {
			  AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			  int id = 101;
			  Author author = mapper.selectAuthor(id);
			  System.out.println(" author id : " + author.getId());
			  System.out.println(" author name : " + author.getUsername());
			  System.out.println( author.toString());
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  } finally {
			  session.close();
		  }
	  }
	  @Test
	  public void shouldSelectAllAuthors(){
		   //sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
		  SqlSession session = sqlSessionFactory.openSession();
		  try {
			  AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			  List<Author> authors = mapper.selectAllAuthors();
			  System.out.println(" author count : " + authors.size());
			  System.out.println(" author name : " + authors.get(0).getUsername());
			  System.out.println( "\n=====\n" + authors.toString());
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  } finally {
			  session.close();
		  }
	  }
	  
	  @Test
	  public void shouldInsertAuthor() {
		  SqlSession session = sqlSessionFactory.openSession();
		  try {
			  Author author = new Author( 103, "usemodj", "1234", "usemodj@gmail.com", "", Section.IMAGES);
			  AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			  mapper.insertAuthor(author);
			  session.commit();
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  session.rollback();
			  e.printStackTrace();
		  } finally {
			  session.close();
		  }
	  }
}
