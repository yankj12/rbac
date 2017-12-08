package com.yan.common.dao.service.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yan.common.dao.service.facade.SequenceDaoService;
import com.yan.common.jdbc.JdbcUtil;
import com.yan.common.model.Sequence;

public class SequenceDaoServiceSpringImpl implements SequenceDaoService{

	public void insertSequence(Sequence sequence) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "insertSequence";
		sqlSession.insert(statement, sequence);
	}

	public long setVal(String name, long currentValue) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("currentValue", currentValue);
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "setVal";
		currentValue = sqlSession.selectOne(statement, map);
		return currentValue;
	}

	public long currVal(String name) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "currVal";
		long currentValue = sqlSession.selectOne(statement, name);
		return currentValue;
	}

	public long nextVal(String name) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "nextVal";
		long nextValue = sqlSession.selectOne(statement, name);
		return nextValue;
	}


}
