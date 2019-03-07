package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
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
	
	@RequestMapping("/save")
	public @ResponseBody CommonMessage saveUser(HttpServletRequest request, HttpServletResponse response, UserEntity user){
		CommonMessage message = new CommonMessage();
		if(user!=null && user.getId()!=null){
			UserEntity oldUser = this.userDao.getOne(user.getId());
			if(oldUser!=null && oldUser.getId()!=0){
				this.userDao.update(user);
				message.setSuccess(true);
				message.setMessage("保存成功！");
				return message;
			}else{
				message.setSuccess(false);
				message.setMessage("保存失败！");
				return message;
			}
		}
		user.setPassWord(BCrypt.hashpw("123456", BCrypt.gensalt()));
		this.userDao.insert(user);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
    @RequestMapping(value="/delete")
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			userDao.delete(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
    
    
}