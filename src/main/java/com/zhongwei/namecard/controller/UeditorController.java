package com.zhongwei.namecard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.utils.PublicMsg;

@Controller
@Transactional
public class UeditorController {
	@RequestMapping("/config")
	@ResponseBody
	public String getConfigInfo(HttpServletRequest request,HttpServletResponse response){
		return PublicMsg.UEDITOR_CONFIG;
	}
}
