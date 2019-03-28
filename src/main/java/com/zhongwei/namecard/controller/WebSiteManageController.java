package com.zhongwei.namecard.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.dao.ShopsSpecMapper;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;
import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;
import com.zhongwei.namecard.entity.ShopsSpec;
import com.zhongwei.namecard.entity.ShopsSpecExample;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.ShopService;

@Controller
@RequestMapping("/website")
public class WebSiteManageController {
	
	@RequestMapping("/getBasicSet")
	public String getBasicSet(Model model) {
		return "webbasicset";
	}
	
}