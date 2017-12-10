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
import com.yan.rbac.dao.service.facade.RbacRoleDaoService;
import com.yan.rbac.model.RbacRole;

public class RbacRoleDaoServiceSpringImpl implements RbacRoleDaoService{

	private SequenceDaoService sequenceDaoService = new SequenceDaoServiceSpringImpl();
	
	@Override
	public RbacRole getRoleByRoleId(String roleId) {
		RbacRole role = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getRoleByRoleId";
		role = sqlSession.selectOne(statement, roleId);
		
		sqlSession.close();
		return role;
	}

	@Override
	public RbacRole getRoleById(String id) {
		RbacRole role = null;
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getRoleById";
		role = sqlSession.selectOne(statement, id);
		
		sqlSession.close();
		return role;
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
	public List<RbacRole> getRolesByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "getRolesByCondition";
		List<RbacRole> roles = sqlSession.selectList(statement, condition);
		
		sqlSession.close();
		return roles;
	}

	@Override
	public String insertRole(RbacRole role) {
		long num = sequenceDaoService.nextVal(ConstantUtil.RBAC_ROLE_SEQ_NAME);

		num = num % 10000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String id = "ROLE-" + sdf.format(new Date()) + String.format("%04d", num);
		
		role.setId(id);;
		
		role.setInsertTime(new Date());
		role.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		
		String statement = MAPPER_NAME_SPACE + "." + "insertRole";
		sqlSession.insert(statement, role);
		
		sqlSession.close();
		
		return id;
	}

	@Override
	public void updateRoleById(RbacRole role) {
		role.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateRoleById";
		
		sqlSession.insert(statement, role);
		
		sqlSession.close();
	}
	
	@Override
	public void updateRoleByRoleId(RbacRole role) {
		role.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateRoleByRoleId";
		
		sqlSession.insert(statement, role);
		
		sqlSession.close();
	}

	@Override
	public void updateRoleValidStatusByRoleId(RbacRole role) {
		role.setUpdateTime(new Date());
		
		SqlSession sqlSession = JdbcUtil.getSqlSession(true);
		String statement = MAPPER_NAME_SPACE + "." + "updateRoleValidStatusByRoleId";
		
		sqlSession.insert(statement, role);
		
		sqlSession.close();
	}

	
}
