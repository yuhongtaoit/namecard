package com.zhongwei.namecard.entity;

import java.io.Serializable;

public class RoleEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String roleName;
	
	private String roleNameZh;

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
	
}
