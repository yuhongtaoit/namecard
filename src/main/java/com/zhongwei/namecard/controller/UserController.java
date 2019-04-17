package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.RoleMapper;
import com.zhongwei.namecard.dao.UserMapper;
import com.zhongwei.namecard.dao.UserRoleMapper;
import com.zhongwei.namecard.entity.Role;
import com.zhongwei.namecard.entity.User;
import com.zhongwei.namecard.entity.UserDetailsEntity;
import com.zhongwei.namecard.service.RoleService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private RoleMapper roleDao;
	
	@Autowired
	private UserRoleMapper userRoleDao;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getUserList")
	public String getUsers(Model model) {
		List<User> users=userDao.getAll();
		model.addAttribute("users", users);
		return "userlist";
	}
	
	@RequestMapping("/getRoles")
	public String getRoles(HttpServletRequest request, HttpServletResponse response, Model model, Integer userId){
		List<Role> roles = roleDao.getAll();
		List<Role> userRoles = roleService.getRolesByUserId(userId);
		if(roles!=null && roles.size()>0) {
			for(Role role : roles) {
				if(userRoles!=null && userRoles.size()>0) {
					for(Role userRole : userRoles) {
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
			User user = this.userDao.getOne(id);
			model.addAttribute("user", user);
		}
		return "useredit";
	}
	
	@RequestMapping("/save")
	@Transactional
	public @ResponseBody CommonMessage saveUser(HttpServletRequest request, HttpServletResponse response, Authentication authentication, User user){
		CommonMessage message = new CommonMessage();
		UserDetailsEntity userDetailsEntity = (UserDetailsEntity)authentication.getPrincipal();
		User testUser = this.userDao.getByUserName(user.getUserName());
		if(user!=null && user.getId()!=null){
			User oldUser = this.userDao.getOne(user.getId());
			if(oldUser!=null && oldUser.getId()!=0){
				if(testUser!=null && testUser.getId()!=oldUser.getId()) {
					message.setSuccess(false);
					message.setMessage("用户名已存在！");
					return message;
				}
				user.setUniacid(userDetailsEntity.getUniacid());
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
		if(testUser!=null) {
			message.setSuccess(false);
			message.setMessage("用户名已存在！");
			return message;
		}
		user.setPassWord(BCrypt.hashpw("123456", BCrypt.gensalt()));
		user.setUniacid(userDetailsEntity.getUniacid());
		this.userDao.insert(user);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
	@RequestMapping("/toUpdatePassword")
	public String toUpdatePassword(HttpServletRequest request, HttpServletResponse response, Model model, Principal principal){
		return "editpassword";
	}
	
	@RequestMapping("/updatePassword")
	public @ResponseBody CommonMessage updatePassword(HttpServletRequest request, HttpServletResponse response, String password, Model model, Principal principal){
		CommonMessage message = new CommonMessage();
		User user = this.userDao.getByUserName(principal.getName());
		try {
			if(user!=null) {
				user.setPassWord(BCrypt.hashpw(password, BCrypt.gensalt()));
				this.userDao.update(user);
				message.setSuccess(true);
				message.setMessage("密码修改成功！");
				return message;
			}else {
				message.setSuccess(true);
				message.setMessage("用户未登录！");
				return message;
			}
		} catch (Exception e) {
			// TODO: handle exception
			message.setSuccess(false);
			message.setMessage("密码修改失败！");
			return message;
		}
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