package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongwei.namecard.dao.RoleMapper;
import com.zhongwei.namecard.dao.RoleResourceMapper;
import com.zhongwei.namecard.dao.UserRoleMapper;
import com.zhongwei.namecard.entity.Role;
import com.zhongwei.namecard.entity.UserRole;

@Service
public class RoleService {
	
	@Autowired
	private UserRoleMapper userRoleDao;
	
	@Autowired
	private RoleMapper roleDao;
	
	@Autowired
	private RoleResourceMapper roleResourceDao;

	public List<Role> getRolesByUserId(Integer userId){
		List<Integer> roleIds = userRoleDao.getRoleIdsByUserId(userId);
		List<Role> roles = null;
		if(roleIds!=null && roleIds.size()>0) {
			roles = roleDao.getByIds(roleIds);
		}
		return roles;
	}
	
	public List<Role> getRolesByResourceId(Integer resourceId){
		List<Integer> roleIds = roleResourceDao.getRoleIdsByResourceId(resourceId);
		List<Role> roles = null;
		if(roleIds!=null && roleIds.size()>0) {
			roles = roleDao.getByIds(roleIds);
		}
		return roles;
	}
	
	@Transactional
	public void updateUserRoles(Integer userId, List<Integer> roleIds) {
		if(userId!=null && userId>0) {
			userRoleDao.deleteByUserId(userId);
		}
		if(roleIds!=null && roleIds.size()>0) {
			for(Integer roleId : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);
				userRoleDao.insert(userRole);
			}
		}
	}
}
