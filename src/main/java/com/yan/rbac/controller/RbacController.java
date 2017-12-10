package com.yan.rbac.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yan.rbac.dao.service.facade.RbacUserGroupDaoService;
import com.yan.rbac.dao.service.spring.RbacUserGroupDaoServiceSpringImpl;
import com.yan.rbac.model.RbacUserGroup;
import com.yan.rbac.vo.UserDataRightVo;

@CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,  
        RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,  
        RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")  
@RestController
public class RbacController {
	
	/**
	 * 根据userId查询这个用户的数据权限
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/findUserDataRight")
    public UserDataRightVo findUserDataRight(@RequestParam Map<String, Object> map) {
    	UserDataRightVo userDataRightVo = new UserDataRightVo();
    	
    	//userId是必传的
    	String userId = (String)map.get("userId");
    	
    	if(userId != null && !"".equals(userId.trim())) {
    		List<String> users = new ArrayList<>();
    		users.add(userId);
    		
    		List<String> groups = new ArrayList<>(0);
    		
    		RbacUserGroupDaoService rbacUserGroupDaoService = new RbacUserGroupDaoServiceSpringImpl();
    		Map<String, Object> condition = new HashMap<>();
    		condition.put("userId", userId);
    		
    		List<RbacUserGroup> userGroups = rbacUserGroupDaoService.getUserGroupsByCondition(condition);
    		if(userGroups != null && userGroups.size() > 0) {
    			for(RbacUserGroup userGroup : userGroups) {
    				groups.add(userGroup.getGroupId());
    			}
    		}
    		
    		userDataRightVo.setGroups(groups);
    		userDataRightVo.setUsers(users);
    		
    		userDataRightVo.setSuccess(true);
    		userDataRightVo.setErrorMsg(null);
    	}else {
    		
    		userDataRightVo.setGroups(null);
    		userDataRightVo.setUsers(null);
    		
    		userDataRightVo.setSuccess(false);
    		userDataRightVo.setErrorMsg("缺少必要参数userId！");
    	}

        return userDataRightVo;
    }
	
}