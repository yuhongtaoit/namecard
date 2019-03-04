package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.ResourceDao;
import com.zhongwei.namecard.dao.RoleResourceDao;
import com.zhongwei.namecard.entity.ResourceEntity;

@Service
public class ResourceService {
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	@Autowired
	private ResourceDao resourceDao;

	public List<ResourceEntity> getResourcesByRoleId(Integer roleId){
		List<Integer> resourceIds = roleResourceDao.getResourceIdsByRoleId(roleId);
		List<ResourceEntity> resources = resourceDao.getResourcesByIds(resourceIds);
		return resources;
	}

	public ResourceEntity getResourceByUrl(String requestUrl) {
		return resourceDao.getResourceByUrl(requestUrl);
	}
}
