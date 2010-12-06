package com.usemodj.jpetstore.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Account;
import com.usemodj.jpetstore.domain.Signon;
import com.usemodj.jpetstore.mappers.AccountMapper;
import com.usemodj.jpetstore.mappers.SignonMapper;

public class AccountService {
	private static Logger logger = Logger.getLogger( AccountService.class);
	
	public Account selectAccount(SqlSession openSession, String userid) throws Exception {
		try {
			AccountMapper mapper = openSession.getMapper(AccountMapper.class);
			Account account = mapper.selectAccount(userid);
			if( logger.isDebugEnabled()) {
				if( null != account) logger.debug(" -- Account.userid = " + account.getUserid()+ " , email = "+ account.getEmail());
				else logger.debug(" --AccountService.selectAccount(): Account is null! --");
			}
			return account;
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(" selectAccount() Exception: " + e.getMessage());
			throw new Exception( " selectAccount() Exception: "+ e.getMessage());
		} finally {
			openSession.close();
		}
	}

	public void insertAccount(SqlSession openSession, Account account) throws Exception {
		try {
			AccountMapper mapper = openSession.getMapper(AccountMapper.class);
			mapper.insertAccount(account);
			openSession.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			openSession.rollback();
			logger.error(" insertAccount() Exception: " + e.getMessage());
			throw new Exception( " insertAccount() Exception: "+ e.getMessage());
		} finally {
			openSession.close();
		}
		
	}
	
	public void updateAccount(SqlSession openSession, Account account) throws Exception {
		try {
			AccountMapper mapper = openSession.getMapper(AccountMapper.class);
			mapper.updateAccount(account);
			openSession.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			openSession.rollback();
			logger.error(" updateAccount() Exception: " + e.getMessage());
			throw new Exception( " updateAccount() Exception: "+ e.getMessage());
		} finally {
			openSession.close();
		}
		
	}

}
