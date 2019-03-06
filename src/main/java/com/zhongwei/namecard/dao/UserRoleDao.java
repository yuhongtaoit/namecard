package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.UserRoleEntity;

@Mapper
public interface UserRoleDao {
	
	List<UserRoleEntity> getAll();
	
	UserRoleEntity getOne(Integer id);
	
	List<Integer> getRoleIdsByUserId(Integer userId);

	void insert(UserRoleEntity userRole);

	void update(UserRoleEntity userRole);

	void delete(Long id);

}