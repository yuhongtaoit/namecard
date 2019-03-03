package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.UserEntity;

@Mapper
public interface UserDao {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);
	
	List<UserEntity> getByUserName(String userName);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}