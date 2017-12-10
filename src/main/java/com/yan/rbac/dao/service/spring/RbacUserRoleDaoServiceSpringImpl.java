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
import com.yan.rbac.dao.service.facade.RbacUserRoleDaoService;
import com.yan.rbac.model.RbacUserRole;

public class RbacUserRoleDaoServiceSpringImpl implements RbacUserRoleDaoService{

	private SequenceDaoService sequenceDaoService = new SequenceDaoServiceSpringImpl();
	
	@Override
	public RbacUserRole getUserRoleByUserIdAndRoleId(Map<String, String> map) {
		RbacUserRole userRole = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUserRoleByUserIdAndRoleId";
		userRole = sqlSession.selectOne(statement, map);
		
		sqlSession.close();
		return userRole;
	}

	@Override
	public RbacUserRole getUserRoleById(String id) {
		RbacUserRole userRole = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUserRoleById";
		userRole = sqlSession.selectOne(statement, id);
		
		sqlSession.close();
		return userRole;
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
	public List<RbacUserRole> getUserRolesByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getUserRolesByCondition";
		List<RbacUserRole> userRoles = sqlSession.selectList(statement, condition);
		
		sqlSession.close();
		return userRoles;
	}

	@Override
	public String insertUserRole(RbacUserRole userRole) {
		long num = sequenceDaoService.nextVal(ConstantUtil.RBAC_USER_ROLE_SEQ_NAME);

		num = num % 10000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String id = "URRL-" + sdf.format(new Date()) + String.format("%04d", num);
		
		userRole.setId(id);;
		
		userRole.setInsertTime(new Date());
		userRole.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		
		String statement = MAPPER_NAME_SPACE + "." + "insertUserRole";
		sqlSession.insert(statement, userRole);
		
		sqlSession.close();
		
		return id;
	}

	@Override
	public void updateUserRoleById(RbacUserRole userRole) {
		userRole.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserRoleById";
		
		sqlSession.insert(statement, userRole);
		
		sqlSession.close();
	}
	
	@Override
	public void updateUserRoleByUserIdAndRoleId(RbacUserRole userRole) {
		userRole.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserRoleByUserIdAndRoleId";
		
		sqlSession.insert(statement, userRole);
		
		sqlSession.close();
	}

	@Override
	public void updateUserRoleValidStatusByUserIdAndRoleId(RbacUserRole userRole) {
		userRole.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateUserRoleValidStatusByUserIdAndRoleId";
		
		sqlSession.insert(statement, userRole);
		
		sqlSession.close();
	}

	
}
