package com.zhongwei.namecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongwei.namecard.dao.ResourceDao;
import com.zhongwei.namecard.dao.RoleDao;
import com.zhongwei.namecard.dao.RoleResourceDao;
import com.zhongwei.namecard.dao.UserRoleDao;
import com.zhongwei.namecard.entity.RoleEntity;
import com.zhongwei.namecard.service.ResourceService;

@Controller
@RequestMapping("/namecard")
public class NameCardController {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/getCardList")
	public String getUsers(Model model) {
		List<RoleEntity> roles = roleDao.getAllForRoleList();
		model.addAttribute("roles", roles);
		return "rolelist";
	}
	
}