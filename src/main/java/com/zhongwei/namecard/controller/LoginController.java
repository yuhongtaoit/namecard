package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AccountWxappExample;
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
}
