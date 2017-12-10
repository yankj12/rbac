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
import com.yan.rbac.dao.service.facade.RbacGroupDaoService;
import com.yan.rbac.model.RbacGroup;

public class RbacGroupDaoServiceSpringImpl implements RbacGroupDaoService{

	private SequenceDaoService sequenceDaoService = new SequenceDaoServiceSpringImpl();
	
	@Override
	public RbacGroup getGroupByGroupId(String groupId) {
		RbacGroup group = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getGroupByGroupId";
		group = sqlSession.selectOne(statement, groupId);
		
		sqlSession.close();
		return group;
	}

	@Override
	public RbacGroup getGroupById(String id) {
		RbacGroup group = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getGroupById";
		group = sqlSession.selectOne(statement, id);
		
		sqlSession.close();
		return group;
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
	public List<RbacGroup> getGroupsByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getGroupsByCondition";
		List<RbacGroup> groups = sqlSession.selectList(statement, condition);
		
		sqlSession.close();
		return groups;
	}

	@Override
	public String insertGroup(RbacGroup group) {
		long num = sequenceDaoService.nextVal(ConstantUtil.RBAC_GROUP_SEQ_NAME);

		num = num % 10000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String id = "GROP-" + sdf.format(new Date()) + String.format("%04d", num);
		
		group.setId(id);;
		
		group.setInsertTime(new Date());
		group.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		
		String statement = MAPPER_NAME_SPACE + "." + "insertGroup";
		sqlSession.insert(statement, group);
		
		sqlSession.close();
		
		return id;
	}

	@Override
	public void updateGroupById(RbacGroup group) {
		group.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateGroupById";
		
		sqlSession.insert(statement, group);
		
		sqlSession.close();
	}
	
	@Override
	public void updateGroupByGroupId(RbacGroup group) {
		group.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateGroupByGroupId";
		
		sqlSession.insert(statement, group);
		
		sqlSession.close();
	}

	@Override
	public void updateGroupValidStatusByGroupId(RbacGroup group) {
		group.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateGroupValidStatusByGroupId";
		
		sqlSession.insert(statement, group);
		
		sqlSession.close();
	}

	
}
