package com.yan.rbac.dao.service.facade;

import java.util.List;
import java.util.Map;

import com.yan.rbac.model.RbacUserGroup;

public interface RbacUserGroupDaoService {

public final static String MAPPER_NAME_SPACE ="com.yan.rbac.mapping.RbacUserGroupMapper";
	
	/**
	 * 根据数据库主键id查找唯一用户组
	 * @param userGroupId
	 * @return
	 */
	RbacUserGroup getUserGroupByUserIdAndGroupId(Map<String, String> map);

	/**
	 * 根据业务键userGroupId查找唯一用户组
	 * @param id
	 * @return
	 */
	RbacUserGroup getUserGroupById(String id);

	/**
	 * 根据条件查询符合条件用户组的数目
	 * @param condition
	 * @return
	 */
	int getCountByCondition(Map<String, Object> condition);
	
	/**
	 * 根据条件查询符合条件用户组
	 * @param condition
	 * @return
	 */
	List<RbacUserGroup> getUserGroupsByCondition(Map<String, Object> condition);
	
	/**
	 * 新增用户组
	 * @param userGroup
	 * @return
	 */
	String insertUserGroup(RbacUserGroup userGroup);
	
	/**
	 * 修改用户组
	 * @param userGroup
	 */
	void updateUserGroupById(RbacUserGroup userGroup);
	
	/**
	 * 修改用户组
	 * @param userGroup
	 */
	void updateUserGroupByUserIdAndGroupId(RbacUserGroup userGroup);
	
	/**
	 * 修改用户组的有效状态
	 * @param userGroup
	 */
	void updateUserGroupValidStatusByUserIdAndGroupId(RbacUserGroup userGroup);
	
}
