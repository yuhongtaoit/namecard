package com.zhongwei.namecard.miniapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.miniapp.dao.AuthUserMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.AuthUserExample;

@RestController
@RequestMapping("/auth/session")
public class TestController {
	
	@Autowired
	private AuthUserMapper userMapper;
	
	@RequestMapping("/test")
	public Map<String, Object> test(Integer aa, Integer bb){
		Map<String, Object> result = new HashMap<>();
//		PageHelper.startPage(0, 8);
//		List<AuthUser> userList = userMapper.selectByExample(new AuthUserExample());
//		result.put("userList", userList);
		System.out.println("aa===" + aa);
		System.out.println("bb===" + bb);
		return result;
	}

}
