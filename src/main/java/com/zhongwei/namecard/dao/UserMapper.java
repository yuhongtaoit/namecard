package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.User;

@Mapper
public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Integer id);
	
	User getByUserName(String userName);

	void insert(User user);

	void update(User user);

	void delete(Integer id);

}