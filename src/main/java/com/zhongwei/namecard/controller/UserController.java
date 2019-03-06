package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongwei.namecard.dao.UserDao;
import com.zhongwei.namecard.entity.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/getUserList")
	public String getUsers(Model model) {
		List<UserEntity> users=userDao.getAll();
		model.addAttribute("users", users);
		return "userlist";
	}
	
	@RequestMapping("/edit")
	public String editUser(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			UserEntity user = this.userDao.getOne(id);
			model.addAttribute("user", user);
		}
		return "useredit";
	}
	
    @RequestMapping("/getUser/{id}")
    public UserEntity getUser(@PathVariable("id") Integer id) {
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