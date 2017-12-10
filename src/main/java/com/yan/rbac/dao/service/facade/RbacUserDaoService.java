package com.yan.rbac.dao.service.facade;

import java.util.List;
import java.util.Map;

import com.yan.rbac.model.RbacUser;

public interface RbacUserDaoService {

public final static String MAPPER_NAME_SPACE ="com.yan.rbac.mapping.RbacUserMapper";
	
	/**
	 * 根据数据库主键id查找唯一用户
	 * @param userId
	 * @return
	 */
	RbacUser getUserByUserId(String userId);

	/**
	 * 根据业务键userId查找唯一用户
	 * @param id
	 * @return
	 */
	RbacUser getUserById(String id);

	/**
	 * 根据条件查询符合条件用户的数目
	 * @param condition
	 * @return
	 */
	int getCountByCondition(Map<String, Object> condition);
	
	/**
	 * 根据条件查询符合条件用户
	 * @param condition
	 * @return
	 */
	List<RbacUser> getUsersByCondition(Map<String, Object> condition);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	String insertUser(RbacUser user);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUserById(RbacUser user);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUserByUserId(RbacUser user);
	
	/**
	 * 修改用户的有效状态
	 * @param user
	 */
	void updateUserValidStatusByUserId(RbacUser user);
	
}
