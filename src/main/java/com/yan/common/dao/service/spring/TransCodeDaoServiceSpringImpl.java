package com.yan.common.dao.service.spring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yan.common.dao.service.facade.TransCodeDaoService;
import com.yan.common.jdbc.JdbcUtil;
import com.yan.common.model.TransCode;

public class TransCodeDaoServiceSpringImpl implements TransCodeDaoService{

	public List<TransCode> getTransCodeListByCodeType(String appCode, String codeType) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appCode", appCode);
		map.put("codeType", codeType);
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getTransCodeListByCodeType";
		
		List<TransCode> transCodes = sqlSession.selectList(statement, map);
		sqlSession.close();
		return transCodes;
	}

	public TransCode getTransCodeByCodeTypeAndCodeCode(String appCode, String codeType,
			String codeCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appCode", appCode);
		map.put("codeType", codeType);
		map.put("codeCode", codeCode);
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getTransCodeByCodeTypeAndCodeCode";
		
		TransCode transCode = sqlSession.selectOne(statement, map);
		sqlSession.close();
		return transCode;
	}

	public void insertTransCode(TransCode transCode) {
		transCode.setInsertTime(new Date());
		transCode.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "insertTransCode";
		
		sqlSession.insert(statement, transCode);
		sqlSession.close();
		
	}

	public void updateTransCodeByCodeTypeAndCodeCode(TransCode transCode) {
		
		transCode.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateTransCodeByCodeTypeAndCodeCode";
		
		sqlSession.update(statement, transCode);
		sqlSession.close();
		
	}

	public void updateTransCodeValidStatus(TransCode transCode) {
		transCode.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateTransCodeValidStatus";
		
		sqlSession.update(statement, transCode);
		sqlSession.close();
		
	}

	
}
