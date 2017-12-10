package com.yan.rbac.vo;

import java.io.Serializable;
import java.util.List;

public class UserDataRightVo implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean success;
	
	private String errorMsg;
	/**
	 * 可以访问哪些组的数据
	 */
	private List<String> groups;
	
	/**
	 * 可以访问哪些用户的数据
	 */
	private List<String> users;

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
