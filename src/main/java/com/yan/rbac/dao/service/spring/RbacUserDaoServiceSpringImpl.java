package com.yan.rbac.dao.service.spring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yan.common.dao.service.facade.SequenceDaoService;
import com.yan.common.dao.service.spring.SequenceDaoServiceSpringImpl;
import com.yan.common.jdbc.JdbcUtil;
import com.yan.common.util.ConstantUtil;
import com.yan.rbac.dao.service.facade.RbacUserDaoService;
import com.yan.rbac.model.RbacUser;

public class RbacUserDaoServiceSpringImpl implements RbacUserDaoService{

	private SequenceDaoService sequenceDaoService = new SequenceDaoServiceSpringImpl();
	
	@Override
	public RbacUser getUserByUserId(String userId) {
		RbacUser user = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getMenuByPK";
		user = sqlSession.selectOne(statement, userId);
		
		sqlSession.close();
		return user;
	}

	@Override
	public RbacUser getUserById(String id) {
		RbacUser user = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getMenuByPK";
		user = sqlSession.selectOne(statement, id);
		
		sqlSession.close();
		return user;
	}

	@Override
	public int getCountByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getCountByCondition";
		int totalCount = sqlSession.selectOne(statement, condition);
		
		sqlSession.close();
		return totalCount;
	}

	@Override
	public List<RbacUser> getUsersByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUsersByCondition";
		List<RbacUser> users = sqlSession.selectList(statement, condition);
		
		sqlSession.close();
		return users;
	}

	@Override
	public String insertUser(RbacUser user) {
		long num = sequenceDaoService.nextVal(ConstantUtil.RBAC_USER_SEQ_NAME);

		num = num % 10000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String id = "USER-" + sdf.format(new Date()) + String.format("%04d", num);
		
		user.setId(id);;
		
		user.setInsertTime(new Date());
		user.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		
		String statement = MAPPER_NAME_SPACE + "." + "insertUser";
		sqlSession.insert(statement, user);
		
		sqlSession.close();
		
		return id;
	}

	@Override
	public void updateUserById(RbacUser user) {
		user.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserById";
		
		sqlSession.insert(statement, user);
		
		sqlSession.close();
	}
	
	@Override
	public void updateUserByUserId(RbacUser user) {
		user.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserByUserId";
		
		sqlSession.insert(statement, user);
		
		sqlSession.close();
	}

	@Override
	public void updateUserValidStatusByUserId(RbacUser user) {
		user.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserValidStatusByUserId";
		
		sqlSession.insert(statement, user);
		
		sqlSession.close();
	}

	
}
