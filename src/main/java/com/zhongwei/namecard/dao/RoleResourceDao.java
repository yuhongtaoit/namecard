package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.RoleResourceEntity;

@Mapper
public interface RoleResourceDao {
	
	List<RoleResourceEntity> getAll();
	
	RoleResourceEntity getOne(Integer id);
	
	List<Integer> getResourceIdsByRoleId(Integer roleId);
	
	List<Integer> getRoleIdsByResourceId(Integer resourceId);

	void insert(RoleResourceEntity roleResource);

	void update(RoleResourceEntity roleResource);

	void delete(Integer id);
	
	void deleteByRoleId(Integer roleId);

}