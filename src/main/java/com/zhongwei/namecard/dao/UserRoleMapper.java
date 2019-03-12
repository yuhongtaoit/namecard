package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.UserRole;

@Mapper
public interface UserRoleMapper {
	
	List<UserRole> getAll();
	
	UserRole getOne(Integer id);
	
	List<Integer> getRoleIdsByUserId(Integer userId);

	void insert(UserRole userRole);

	void update(UserRole userRole);

	void delete(Integer id);
	
	void deleteByUserId(Integer userId);
	
	void deleteByRoleId(Integer roleId);

}