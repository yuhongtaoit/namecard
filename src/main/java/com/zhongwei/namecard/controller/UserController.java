package com.zhongwei.namecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.UserDao;
import com.zhongwei.namecard.entity.UserEntity;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userDao.getAll();
		return users;
	}
	
    @RequestMapping("/getUser/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
    	UserEntity user=userDao.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	user.setUserName("admin");
    	user.setNickName("YHT");
    	user.setUserSex("男");
    	user.setPassWord("123456");
    	userDao.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userDao.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userDao.delete(id);
    }
    
    
}