package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.Role;

@Mapper
public interface RoleMapper {
	
	List<Role> getAll();
	
	List<Role> getAllForRoleList();
	
	List<Role> getByUniacid(Integer uniacid);
	
	List<Role> getByIds(List<Integer> roleIds);
	
	Role getOne(Integer id);
	
	Role getByRoleName(String roleName);

	void insert(Role role);

	void update(Role role);

	void delete(Integer id);

}