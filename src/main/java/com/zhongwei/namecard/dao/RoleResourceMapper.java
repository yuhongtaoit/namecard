package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.RoleResource;

@Mapper
public interface RoleResourceMapper {
	
	List<RoleResource> getAll();
	
	RoleResource getOne(Integer id);
	
	List<Integer> getResourceIdsByRoleId(Integer roleId);
	
	List<Integer> getRoleIdsByResourceId(Integer resourceId);

	void insert(RoleResource roleResource);

	void update(RoleResource roleResource);

	void delete(Integer id);
	
	void deleteByRoleId(Integer roleId);

}