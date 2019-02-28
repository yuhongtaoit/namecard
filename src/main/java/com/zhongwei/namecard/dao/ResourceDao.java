package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.RoleEntity;

@Mapper
public interface ResourceDao {
	
	List<RoleEntity> getAll();
	
	RoleEntity getOne(Long id);

	void insert(RoleEntity role);

	void update(RoleEntity role);

	void delete(Long id);

}