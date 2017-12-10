package com.yan.rbac.dao.service.facade;

import java.util.List;
import java.util.Map;

import com.yan.rbac.model.RbacRole;

public interface RbacRoleDaoService {

public final static String MAPPER_NAME_SPACE ="com.yan.rbac.mapping.RbacRoleMapper";
	
	/**
	 * 根据数据库主键id查找唯一角色
	 * @param roleId
	 * @return
	 */
	RbacRole getRoleByRoleId(String roleId);

	/**
	 * 根据业务键roleId查找唯一角色
	 * @param id
	 * @return
	 */
	RbacRole getRoleById(String id);

	/**
	 * 根据条件查询符合条件角色的数目
	 * @param condition
	 * @return
	 */
	int getCountByCondition(Map<String, Object> condition);
	
	/**
	 * 根据条件查询符合条件角色
	 * @param condition
	 * @return
	 */
	List<RbacRole> getRolesByCondition(Map<String, Object> condition);
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	String insertRole(RbacRole role);
	
	/**
	 * 修改角色
	 * @param role
	 */
	void updateRoleById(RbacRole role);
	
	/**
	 * 修改角色
	 * @param role
	 */
	void updateRoleByRoleId(RbacRole role);
	
	/**
	 * 修改角色的有效状态
	 * @param role
	 */
	void updateRoleValidStatusByRoleId(RbacRole role);
	
}
