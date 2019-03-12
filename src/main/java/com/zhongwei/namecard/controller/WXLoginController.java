package com.zhongwei.namecard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WXLoginController {

	@RequestMapping("/auth/session/openid")
	public String AuthGetOpenId() {
		System.out.println(11111);
		
		
		return "login html";
	}
}
