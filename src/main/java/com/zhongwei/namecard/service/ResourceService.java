package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongwei.namecard.dao.ResourceMapper;
import com.zhongwei.namecard.dao.RoleResourceMapper;
import com.zhongwei.namecard.entity.Resource;
import com.zhongwei.namecard.entity.RoleResource;

@Service
public class ResourceService {
	
	@Autowired
	private RoleResourceMapper roleResourceDao;
	
	@Autowired
	private ResourceMapper resourceDao;

	public List<Resource> getResourcesByRoleId(Integer roleId){
		List<Integer> resourceIds = roleResourceDao.getResourceIdsByRoleId(roleId);
		List<Resource> resources = null;
		if(resourceIds!=null && resourceIds.size()>0) {
			resources = resourceDao.getResourcesByIds(resourceIds);
		}
		return resources;
	}

	public Resource getResourceByUrl(String requestUrl) {
		return resourceDao.getResourceByUrl(requestUrl);
	}
	
	@Transactional
	public void updateRoleResources(Integer roleId, List<Integer> resourceIds) {
		if(roleId!=null && roleId>0) {
			roleResourceDao.deleteByRoleId(roleId);
		}
		if(resourceIds!=null && resourceIds.size()>0) {
			for(Integer resourceId : resourceIds) {
				RoleResource roleResource = new RoleResource();
				roleResource.setResourceId(resourceId);
				roleResource.setRoleId(roleId);
				roleResourceDao.insert(roleResource);
			}
		}
	}
}
