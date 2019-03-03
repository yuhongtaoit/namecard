package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.RoleDao;
import com.zhongwei.namecard.dao.UserRoleDao;
import com.zhongwei.namecard.entity.RoleEntity;

@Service
public class RoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleDao roleDao;

	List<RoleEntity> getRolesByUserId(Integer userId){
		List<Integer> roleIds = userRoleDao.getRoleIdsByUserId(userId);
		List<RoleEntity> roles = roleDao.getByIds(roleIds);
		return roles;
	}
}
