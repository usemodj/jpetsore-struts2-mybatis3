package com.usemodj.jpetstore.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.usemodj.jpetstore.domain.Sequence;
import com.usemodj.jpetstore.mappers.SequenceMapper;

public class SequenceService {
	private static Logger logger = Logger.getLogger( SequenceService.class);
	
	public synchronized int getNextId(SqlSession sqlSession, String name) {
		SequenceMapper sMapper = sqlSession.getMapper( SequenceMapper.class);
		Integer nextId = null;
		try {
			nextId = sMapper.selectNextId( name);
			if( null == nextId){
				nextId = new Integer(1000); //initial value
				Sequence sequence = new Sequence( name, nextId.intValue());
				sMapper.insertSequence( sequence);
			}else {
				//Update Sequence nextid column
				sMapper.updateSequence( new Sequence(name, nextId.intValue() + 1));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("SequenceService.getNextId() Exception: " + e.getMessage());
		}
		
		return nextId;
	}

}
