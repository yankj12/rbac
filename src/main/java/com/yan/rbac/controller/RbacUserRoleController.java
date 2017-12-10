package com.yan.rbac.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yan.rbac.dao.service.facade.RbacUserRoleDaoService;
import com.yan.rbac.dao.service.spring.RbacUserRoleDaoServiceSpringImpl;
import com.yan.rbac.model.RbacUserRole;
import com.yan.rbac.vo.ResultVo;

@CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,  
        RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,  
        RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")  
@RestController
public class RbacUserRoleController {

    @RequestMapping(value="/findUserRoles")
    public ResultVo findUserRoles(@RequestParam Map<String, Object> map) {
    	ResultVo queryResultVo = new ResultVo();
    	
    	//根据条件查询总条数
    	long total = 0;
    	List<RbacUserRole> userRoles = null;
    	//查询结果
    	
    	String page = (String)map.get("page");
		String r = (String)map.get("rows");
		
		//日期格式
		String pattern = "yyyy-MM-dd hh:mm:ss";
		
		//下面的开始时间和结束时间，用来查找一段时间内创建的用户权限
		//开始时间
		Date startTime = getDateTimeFromRequest(map, pattern, "startTime");
		map.put("startTime", startTime);
		
		//结束时间
		Date endTime = getDateTimeFromRequest(map, pattern, "endTime");
		map.put("endTime", endTime);
		
		//记录有效状态
		String validStatus = (String)map.get("validStatus");
		map.put("validStatus", validStatus);
		
		String userId = (String)map.get("userId");
		map.put("userId", userId);
		
		String roleId = (String)map.get("roleId");
		map.put("roleId", roleId);
		
		String userName = (String)map.get("userName");
		map.put("userName", userName);
		
		String roleName = (String)map.get("roleName");
		map.put("roleName", roleName);
		
		//因为只有分页中会传入这两个参数，所以这两个参数并不总是有值，需要非空判断
		int pageNo = 1;
		if(page != null && !"".equals(page.trim())){
			pageNo = Integer.parseInt(page);
		}
		int pageSize = 10;
		if(r != null && !"".equals(r.trim())){
			pageSize = Integer.parseInt(r);
		}
		
		if(pageNo < 1){
			pageNo = 1;
		}
		if(pageSize <= 0){
			pageSize = 10;
		}
		int offset = (pageNo-1)*pageSize;
		
		//第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。初始记录行的偏移量是 0(而不是 1)
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		
		RbacUserRoleDaoService rbacUserRoleDaoService = new RbacUserRoleDaoServiceSpringImpl();
		total = rbacUserRoleDaoService.getCountByCondition(map);
		userRoles = rbacUserRoleDaoService.getUserRolesByCondition(map);
		
		//下面这两个变量在这个方法中并不是必须的
		queryResultVo.setTotal(total);
		queryResultVo.setRows(userRoles);
		queryResultVo.setSuccess(true);
		queryResultVo.setErrorMsg(null);

        return queryResultVo;
    }
 
    @RequestMapping(value="/insertUserRole")
    public ResultVo insertUserRole(@RequestParam Map<String, Object> map) {
    	ResultVo queryResultVo = new ResultVo();
    	
    	if(map != null && map.size() > 0) {
    		String id = (String)map.get("id");
    		
    		String userId = (String)map.get("userId");
    		String roleId = (String)map.get("roleId");
    		String userName = (String)map.get("userName");
    		String roleName = (String)map.get("roleName");
    		
    		String validStatus = "1";
    		
    		RbacUserRole userRole = new RbacUserRole();
    		userRole.setId(id);
    		userRole.setUserId(userId);
    		userRole.setUserName(userName);
    		userRole.setRoleId(roleId);
    		userRole.setRoleName(roleName);
    		
    		userRole.setValidStatus(validStatus);
    		
    		RbacUserRoleDaoService rbacUserRoleDaoService = new RbacUserRoleDaoServiceSpringImpl();
			userRole.setInsertTime(new Date());
			userRole.setUpdateTime(new Date());
			rbacUserRoleDaoService.insertUserRole(userRole);
    		
    		queryResultVo.setObject(userRole);
    		queryResultVo.setSuccess(true);
    		queryResultVo.setErrorMsg(null);
    	}else {
    		queryResultVo.setObject(null);
    		queryResultVo.setSuccess(false);
    		queryResultVo.setErrorMsg("必要参数不全，请检查参数！");
    	}

        return queryResultVo;
    }
    
    @RequestMapping(value="/updateUserRole")
    public ResultVo updateUserRole(@RequestParam Map<String, Object> map) {
    	ResultVo queryResultVo = new ResultVo();
    	
    	if(map != null && map.size() > 0) {
    		String id = (String)map.get("id");
    		
    		String userId = (String)map.get("userId");
    		String roleId = (String)map.get("roleId");
    		String userName = (String)map.get("userName");
    		String roleName = (String)map.get("roleName");
    		
    		String validStatus = "1";
    		
    		RbacUserRole userRole = new RbacUserRole();
    		userRole.setId(id);
    		userRole.setUserId(userId);
    		userRole.setUserName(userName);
    		userRole.setRoleId(roleId);
    		userRole.setRoleName(roleName);
    		
    		userRole.setValidStatus(validStatus);
    		
    		RbacUserRoleDaoService rbacUserRoleDaoService = new RbacUserRoleDaoServiceSpringImpl();
    		
    		if(id != null && !"".equals(id.trim())) {
    			//修改
    			userRole.setUpdateTime(new Date());
    			rbacUserRoleDaoService.updateUserRoleById(userRole);
    		}
    		
    		queryResultVo.setObject(userRole);
    		queryResultVo.setSuccess(true);
    		queryResultVo.setErrorMsg(null);
    	}else {
    		queryResultVo.setObject(null);
    		queryResultVo.setSuccess(false);
    		queryResultVo.setErrorMsg("必要参数不全，请检查参数！");
    	}

        return queryResultVo;
    }
    
    @RequestMapping(value="/deleteUserRole")
    public ResultVo deleteUserRole(@RequestParam Map<String, Object> map) {
    	ResultVo queryResultVo = new ResultVo();
    	
    	if(map != null && map.size() > 0) {
    		String id = (String)map.get("id");
    		
    		String userId = (String)map.get("userId");
    		String roleId = (String)map.get("roleId");
    		String userName = (String)map.get("userName");
    		String roleName = (String)map.get("roleName");
    		
    		//通过软删除的方式删除用户权限
    		String validStatus = "0";
    		
    		RbacUserRole userRole = new RbacUserRole();
    		userRole.setId(id);
    		userRole.setUserId(userId);
    		userRole.setUserName(userName);
    		userRole.setRoleId(roleId);
    		userRole.setRoleName(roleName);
    		
    		userRole.setValidStatus(validStatus);
    		
    		RbacUserRoleDaoService rbacUserRoleDaoService = new RbacUserRoleDaoServiceSpringImpl();
    		
    		if(id != null && !"".equals(id.trim())) {
    			//修改
    			userRole.setUpdateTime(new Date());
    			rbacUserRoleDaoService.updateUserRoleValidStatusByUserIdAndRoleId(userRole);
    		}
    		
    		queryResultVo.setObject(userRole);
    		queryResultVo.setSuccess(true);
    		queryResultVo.setErrorMsg(null);
    	}else {
    		queryResultVo.setObject(null);
    		queryResultVo.setSuccess(false);
    		queryResultVo.setErrorMsg("必要参数不全，请检查参数！");
    	}

        return queryResultVo;
    }
    
    /**
	 * 根据参数名称从request中获取并组装对象
	 * 
	 * @param map
	 * @param pattern
	 * @param parameterName
	 * @return 如果日期为空，返回null
	 * 如果不符合日期格式，返回null
	 */
	public static Date getDateTimeFromRequest(Map<String, Object> map, String pattern, String parameterName){
		Date date = null;
		
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(pattern);
		
		String dateTimeStr = (String)map.get(parameterName);
		
		if(dateTimeStr != null && !"".equals(dateTimeStr.trim())){
			try {
				date = dateTimeFormat.parse(dateTimeStr.trim());
			} catch (ParseException e) {
				e.printStackTrace();
				date = null;
			}
		}
		return date;
	}
	
}