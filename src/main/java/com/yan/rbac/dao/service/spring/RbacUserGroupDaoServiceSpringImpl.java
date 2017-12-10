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
import com.yan.rbac.dao.service.facade.RbacUserGroupDaoService;
import com.yan.rbac.model.RbacUserGroup;

public class RbacUserGroupDaoServiceSpringImpl implements RbacUserGroupDaoService{

	private SequenceDaoService sequenceDaoService = new SequenceDaoServiceSpringImpl();
	
	@Override
	public RbacUserGroup getUserGroupByUserIdAndGroupId(Map<String, String> map) {
		RbacUserGroup userGroup = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUserGroupByUserIdAndGroupId";
		userGroup = sqlSession.selectOne(statement, map);
		
		sqlSession.close();
		return userGroup;
	}

	@Override
	public RbacUserGroup getUserGroupById(String id) {
		RbacUserGroup userGroup = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUserGroupById";
		userGroup = sqlSession.selectOne(statement, id);
		
		sqlSession.close();
		return userGroup;
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
	public List<RbacUserGroup> getUserGroupsByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUserGroupsByCondition";
		List<RbacUserGroup> userGroups = sqlSession.selectList(statement, condition);
		
		sqlSession.close();
		return userGroups;
	}

	@Override
	public String insertUserGroup(RbacUserGroup userGroup) {
		long num = sequenceDaoService.nextVal(ConstantUtil.RBAC_USER_GROUP_SEQ_NAME);

		num = num % 10000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String id = "URGP-" + sdf.format(new Date()) + String.format("%04d", num);
		
		userGroup.setId(id);;
		
		userGroup.setInsertTime(new Date());
		userGroup.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		
		String statement = MAPPER_NAME_SPACE + "." + "insertUserGroup";
		sqlSession.insert(statement, userGroup);
		
		sqlSession.close();
		
		return id;
	}

	@Override
	public void updateUserGroupById(RbacUserGroup userGroup) {
		userGroup.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserGroupById";
		
		sqlSession.insert(statement, userGroup);
		
		sqlSession.close();
	}
	
	@Override
	public void updateUserGroupByUserIdAndGroupId(RbacUserGroup userGroup) {
		userGroup.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserGroupByUserIdAndGroupId";
		
		sqlSession.insert(statement, userGroup);
		
		sqlSession.close();
	}

	@Override
	public void updateUserGroupValidStatusByUserIdAndGroupId(RbacUserGroup userGroup) {
		userGroup.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserGroupValidStatusByUserIdAndGroupId";
		
		sqlSession.insert(statement, userGroup);
		
		sqlSession.close();
	}

	
}
