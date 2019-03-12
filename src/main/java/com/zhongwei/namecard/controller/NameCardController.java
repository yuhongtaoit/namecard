package com.zhongwei.namecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongwei.namecard.dao.ResourceMapper;
import com.zhongwei.namecard.dao.RoleMapper;
import com.zhongwei.namecard.dao.RoleResourceMapper;
import com.zhongwei.namecard.dao.UserRoleMapper;
import com.zhongwei.namecard.entity.Role;
import com.zhongwei.namecard.service.ResourceService;

@Controller
@RequestMapping("/namecard")
public class NameCardController {
	
	@Autowired
	private RoleMapper roleDao;
	
	@Autowired
	private ResourceMapper resourceDao;
	
	@Autowired
	private UserRoleMapper userRoleDao;
	
	@Autowired
	private RoleResourceMapper roleResourceDao;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/getCardList")
	public String getUsers(Model model) {
		List<Role> roles = roleDao.getAllForRoleList();
		model.addAttribute("roles", roles);
		return "rolelist";
	}
	
}