package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongwei.namecard.dao.ResourceDao;
import com.zhongwei.namecard.dao.RoleResourceDao;
import com.zhongwei.namecard.entity.ResourceEntity;
import com.zhongwei.namecard.entity.RoleResourceEntity;

@Service
public class ResourceService {
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	@Autowired
	private ResourceDao resourceDao;

	public List<ResourceEntity> getResourcesByRoleId(Integer roleId){
		List<Integer> resourceIds = roleResourceDao.getResourceIdsByRoleId(roleId);
		List<ResourceEntity> resources = null;
		if(resourceIds!=null && resourceIds.size()>0) {
			resources = resourceDao.getResourcesByIds(resourceIds);
		}
		return resources;
	}

	public ResourceEntity getResourceByUrl(String requestUrl) {
		return resourceDao.getResourceByUrl(requestUrl);
	}
	
	@Transactional
	public void updateRoleResources(Integer roleId, List<Integer> resourceIds) {
		if(roleId!=null && roleId>0) {
			roleResourceDao.deleteByRoleId(roleId);
		}
		if(resourceIds!=null && resourceIds.size()>0) {
			for(Integer resourceId : resourceIds) {
				RoleResourceEntity roleResource = new RoleResourceEntity();
				roleResource.setResourceId(resourceId);
				roleResource.setRoleId(roleId);
				roleResourceDao.insert(roleResource);
			}
		}
	}
}
