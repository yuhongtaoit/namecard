package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.RoleDao;
import com.zhongwei.namecard.dao.UserDao;
import com.zhongwei.namecard.dao.UserRoleDao;
import com.zhongwei.namecard.entity.RoleEntity;
import com.zhongwei.namecard.entity.UserEntity;
import com.zhongwei.namecard.service.RoleService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getUserList")
	public String getUsers(Model model) {
		List<UserEntity> users=userDao.getAll();
		model.addAttribute("users", users);
		return "userlist";
	}
	
	@RequestMapping("/getRoles")
	public String getRoles(HttpServletRequest request, HttpServletResponse response, Model model, Integer userId){
		List<RoleEntity> roles = roleDao.getAll();
		List<RoleEntity> userRoles = roleService.getRolesByUserId(userId);
		if(roles!=null && roles.size()>0) {
			for(RoleEntity role : roles) {
				if(userRoles!=null && userRoles.size()>0) {
					for(RoleEntity userRole : userRoles) {
						if(role.getId()==userRole.getId()) {
							role.setFlag(true);
						}
					}
				}
			}
		}
		model.addAttribute("roles", roles);
		model.addAttribute("userId", userId);
		return "selectroles";
	}
	
	@RequestMapping("/saveRoles")
	public @ResponseBody CommonMessage saveRoles(HttpServletRequest request, HttpServletResponse response, 
			Model model, Integer userId, 
			@RequestParam(required = false, value = "roleIds[]") List<Integer> roleIds){
		CommonMessage message = new CommonMessage();
		try {
			roleService.updateUserRoles(userId, roleIds);
			message.setSuccess(true);
			message.setMessage("保存成功");
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage(e.getMessage());
		}
		return message;
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
	@Transactional
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
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			userDao.delete(id);
			userRoleDao.deleteByUserId(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
    
    
}