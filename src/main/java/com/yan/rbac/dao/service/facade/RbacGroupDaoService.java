package com.yan.rbac.dao.service.facade;

import java.util.List;
import java.util.Map;

import com.yan.rbac.model.RbacGroup;

public interface RbacGroupDaoService {

public final static String MAPPER_NAME_SPACE ="com.yan.rbac.mapping.RbacGroupMapper";
	
	/**
	 * 根据数据库主键id查找唯一组
	 * @param groupId
	 * @return
	 */
	RbacGroup getGroupByGroupId(String groupId);

	/**
	 * 根据业务键groupId查找唯一组
	 * @param id
	 * @return
	 */
	RbacGroup getGroupById(String id);

	/**
	 * 根据条件查询符合条件组的数目
	 * @param condition
	 * @return
	 */
	int getCountByCondition(Map<String, Object> condition);
	
	/**
	 * 根据条件查询符合条件组
	 * @param condition
	 * @return
	 */
	List<RbacGroup> getGroupsByCondition(Map<String, Object> condition);
	
	/**
	 * 新增组
	 * @param group
	 * @return
	 */
	String insertGroup(RbacGroup group);
	
	/**
	 * 修改组
	 * @param group
	 */
	void updateGroupById(RbacGroup group);
	
	/**
	 * 修改组
	 * @param group
	 */
	void updateGroupByGroupId(RbacGroup group);
	
	/**
	 * 修改组的有效状态
	 * @param group
	 */
	void updateGroupValidStatusByGroupId(RbacGroup group);
	
}
