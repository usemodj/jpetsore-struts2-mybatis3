package com.usemodj.jpetstore.service;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.usemodj.blog.domain.Author;
import com.usemodj.blog.mappers.AuthorMapper;
import com.usemodj.jpetstore.domain.Account;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.mappers.SignonMapper;
import com.usemodj.mybatis.builder.MybatisConfig;

public class SignonServiceTest {
	  private static SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
	    sqlSessionFactory = new MybatisConfig().getSqlSessionFactory();
	}

	@Test
	public void testSelectSignon() {
		SignonService service = new SignonService();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			String username = "j2ee";
			Signon signon = service.selectSignon(session, username);
			System.out.println(" username : " + signon.getUsername());
			System.out.println(" password : " + signon.getPassword());
			System.out.println( signon.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Test
	public void testInsertSignon() {
		SqlSession session = sqlSessionFactory.openSession();
		SignonService service = new SignonService();
		try {
			Signon signon = new Signon("usemodj2", "usemodj2");
			service.insertSignon(session, signon);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	@Test
	public void testCreateSignonAndAccount() {
		SqlSession session = sqlSessionFactory.openSession();
		SignonService service = new SignonService();
		try {
			Signon signon = new Signon("usemodj3", "usemodj3");
			Account account = new Account("usemodj3");
			account.setEmail("usemodj@gmail.com");
			account.setFirstname("홍길동");
			service.createSignonAndAccount(session, signon, account);
			//session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//session.rollback();
		} finally {
			//session.close();
		}
	}
	@Test
	public void testUpdatePassword(){
		SqlSession session = sqlSessionFactory.openSession();
		SignonService service = new SignonService();
		try {
			Signon signon = new Signon("usemodj3", "usemodj4");
			service.updatePassword(session, signon);
			//session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
