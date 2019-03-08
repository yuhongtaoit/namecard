package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongwei.namecard.dao.RoleDao;
import com.zhongwei.namecard.dao.RoleResourceDao;
import com.zhongwei.namecard.dao.UserRoleDao;
import com.zhongwei.namecard.entity.RoleEntity;
import com.zhongwei.namecard.entity.UserRoleEntity;

@Service
public class RoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleResourceDao roleResourceDao;

	public List<RoleEntity> getRolesByUserId(Integer userId){
		List<Integer> roleIds = userRoleDao.getRoleIdsByUserId(userId);
		List<RoleEntity> roles = null;
		if(roleIds!=null && roleIds.size()>0) {
			roles = roleDao.getByIds(roleIds);
		}
		return roles;
	}
	
	public List<RoleEntity> getRolesByResourceId(Integer resourceId){
		List<Integer> roleIds = roleResourceDao.getRoleIdsByResourceId(resourceId);
		List<RoleEntity> roles = null;
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
				UserRoleEntity userRole = new UserRoleEntity();
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);
				userRoleDao.insert(userRole);
			}
		}
	}
}
