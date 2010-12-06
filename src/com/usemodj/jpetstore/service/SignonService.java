package com.usemodj.jpetstore.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Account;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.mappers.AccountMapper;
import com.usemodj.jpetstore.mappers.SignonMapper;
import com.usemodj.struts.CreateAccountException;
import com.usemodj.struts.UpdatePasswordException;

public class SignonService {
	private static Logger logger = Logger.getLogger(SignonService.class);
	
	public Signon selectSignon(SqlSession openSession, String username) throws Exception {
		try {
			SignonMapper mapper = openSession.getMapper(SignonMapper.class);
			Signon signon = mapper.selectSignon(username);
			if( null != signon) logger.debug(" -- Signon username = " + signon.getUsername()+ " , password = "+ signon.getPassword());
			else logger.debug(" --SignonService.selectSignon(): Signon is null! --");
			return signon;
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(" selectSignon() Exception: " + e.getMessage());
			throw new Exception( " selectSigon() Exception: "+ e.getMessage());
		} finally {
			openSession.close();
		}
	}

	public void insertSignon(SqlSession openSession, Signon signon) throws Exception {
		try {
			SignonMapper mapper = openSession.getMapper(SignonMapper.class);
			mapper.insertSignon(signon);
			openSession.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			openSession.rollback();
			logger.error(" insertSignon() Exception: " + e.getMessage());
			throw new Exception( " insertSigon() Exception: "+ e.getMessage());
		} finally {
			openSession.close();
		}
	}
	public void insertSignon2(SqlSession openSession, String username, String password, String role) throws Exception {
		try {
			SignonMapper mapper = openSession.getMapper(SignonMapper.class);
			mapper.insertSignon2(username, password, role);
			openSession.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			openSession.rollback();
			logger.error(" insertSignon() Exception: " + e.getMessage());
			throw new Exception( " insertSigon() Exception: "+ e.getMessage());
		} finally {
			openSession.close();
		}
	}

	public void createSignonAndAccount(SqlSession openSession, Signon signon,
			Account account) throws CreateAccountException {
		try {
			SignonMapper sMapper = openSession.getMapper(SignonMapper.class);
			AccountMapper aMapper = openSession.getMapper(AccountMapper.class);
			sMapper.insertSignon(signon);
			aMapper.insertAccount(account);
			openSession.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			openSession.rollback();
			logger.error( " createSignonAndAccount() Exception: " + e.getMessage());
			throw new CreateAccountException(e.getMessage());
		} finally {
			openSession.close();
		}
	}

	public void updatePassword(SqlSession openSession, Signon signon) throws UpdatePasswordException {
		try {
			SignonMapper sMapper = openSession.getMapper(SignonMapper.class);
			logger.debug("..Signon  username= " + signon.getUsername()+ ", password="+ signon.getPassword());
			
			sMapper.updatePassword( signon);
			openSession.commit();
			logger.debug(".. SignonMapper.updatePassword() is called..");
		} catch (Exception e) {
			//e.printStackTrace();
			openSession.rollback();
			logger.error(" updatePassword() Exception : " + e.getMessage());
			throw new UpdatePasswordException( e.getMessage());
		} finally {
			openSession.close();
		}
	}
}
