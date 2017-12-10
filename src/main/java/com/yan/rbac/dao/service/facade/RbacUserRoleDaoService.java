package com.yan.rbac.dao.service.facade;

import java.util.List;
import java.util.Map;

import com.yan.rbac.model.RbacUserRole;

public interface RbacUserRoleDaoService {

public final static String MAPPER_NAME_SPACE ="com.yan.rbac.mapping.RbacUserRoleMapper";
	
	/**
	 * 根据数据库主键id查找唯一用户权限
	 * @param userRoleId
	 * @return
	 */
	RbacUserRole getUserRoleByUserIdAndRoleId(Map<String, String> map);

	/**
	 * 根据业务键userRoleId查找唯一用户权限
	 * @param id
	 * @return
	 */
	RbacUserRole getUserRoleById(String id);

	/**
	 * 根据条件查询符合条件用户权限的数目
	 * @param condition
	 * @return
	 */
	int getCountByCondition(Map<String, Object> condition);
	
	/**
	 * 根据条件查询符合条件用户权限
	 * @param condition
	 * @return
	 */
	List<RbacUserRole> getUserRolesByCondition(Map<String, Object> condition);
	
	/**
	 * 新增用户权限
	 * @param userRole
	 * @return
	 */
	String insertUserRole(RbacUserRole userRole);
	
	/**
	 * 修改用户权限
	 * @param userRole
	 */
	void updateUserRoleById(RbacUserRole userRole);
	
	/**
	 * 修改用户权限
	 * @param userRole
	 */
	void updateUserRoleByUserIdAndRoleId(RbacUserRole userRole);
	
	/**
	 * 修改用户权限的有效状态
	 * @param userRole
	 */
	void updateUserRoleValidStatusByUserIdAndRoleId(RbacUserRole userRole);
	
}
