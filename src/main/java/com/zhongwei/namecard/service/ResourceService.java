package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhongwei.namecard.dao.ResourceDao;
import com.zhongwei.namecard.dao.RoleResourceDao;
import com.zhongwei.namecard.entity.ResourceEntity;

public class ResourceService {
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	@Autowired
	private ResourceDao resourceDao;

	List<ResourceEntity> getResourcesByRoleId(Integer roleId){
		List<Integer> resourceIds = roleResourceDao.getResourceIdsByRoleId(roleId);
		List<ResourceEntity> resources = resourceDao.getResourcesByIds(resourceIds);
		return resources;
	}
}
