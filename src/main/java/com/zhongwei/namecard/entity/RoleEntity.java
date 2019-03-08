package com.zhongwei.namecard.entity;

import java.io.Serializable;

public class RoleEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String roleName;
	
	private String roleNameZh;
	
	private boolean flag = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNameZh() {
		return roleNameZh;
	}

	public void setRoleNameZh(String roleNameZh) {
		this.roleNameZh = roleNameZh;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
