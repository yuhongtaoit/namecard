package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AccountWxappExample;
import com.zhongwei.namecard.entity.Resource;
import com.zhongwei.namecard.entity.Role;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Controller
public class LoginController {
	
	@Autowired
	private AccountWxappMapper accountMapper;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String index(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity)authentication.getPrincipal();
		List<Resource> resources = user.getResources();
		if(resources!=null && resources.size()>0) {
			List<String> menuResources = new ArrayList<>();
			for(Resource resource : resources) {
				if("menu".equals(resource.getType()) && !menuResources.contains(resource.getUrl())) {
					menuResources.add(resource.getUrl());
				}
			}
			model.addAttribute("menuResources", menuResources.toString());
		}
		List<Role> roles = user.getRoles();
		if(hasAdminRole(roles)) {
			model.addAttribute("hasRoleAdmin", true);
		}
		AccountWxappExample accountExample = new AccountWxappExample();
		accountExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<AccountWxapp> accounts = accountMapper.selectByExample(accountExample);
		if(accounts!=null && accounts.size()>0) {
			AccountWxapp account = accounts.get(0);
			model.addAttribute("accountName", account.getName());
		}
		model.addAttribute("userName", principal.getName());
		return "index";
	}
	
	@RequestMapping("/toChangeAccount")
	public String toChangeAccount(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity)authentication.getPrincipal();
		List<AccountWxapp> accountList = this.accountMapper.selectByExample(new AccountWxappExample());
		model.addAttribute("accountList", accountList);
		model.addAttribute("uniacid", user.getUniacid());
		return "changeaccount";
	}
	
	@RequestMapping("/changeAccount")
	public @ResponseBody CommonMessage changeAccount(HttpServletRequest request, HttpServletResponse response, Principal principal, Authentication authentication, Model model, Integer acid) {
		CommonMessage message = new CommonMessage();
		AccountWxapp account = this.accountMapper.selectByPrimaryKey(acid);
		UserDetailsEntity user = (UserDetailsEntity)authentication.getPrincipal();
		user.setUniacid(account.getUniacid());
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials());
		auth.setDetails(authentication.getDetails());
		securityContextImpl.setAuthentication(auth);
		message.setSuccess(true);
		message.setMessage("切换机构成功");
		return message;
	}
	
	private boolean hasAdminRole(List<Role> roles) {
		for(Role role : roles) {
			if("ROLE_ADMIN".equals(role.getRoleName())) {
				return true;
			}
		}
		return false;
	}
}
