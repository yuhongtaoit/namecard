package com.zhongwei.namecard.controller;

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
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private CardShopsMapper shopMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/getShopList")
	public String getShops(Model model) {
		List<CardShopsWithBLOBs> shopList = shopMapper.selectByExampleWithBLOBs(new CardShopsExample());
		model.addAttribute("shops", shopList);
		return "shoplist";
	}
	
	@RequestMapping("/edit")
	public String editShop(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardShopsWithBLOBs shop = shopMapper.selectByPrimaryKey(id);
//			List<String> photoList = Arrays.asList(this.toArray(card.getPhoto()));
			model.addAttribute("shop", shop);
//			model.addAttribute("photos", photoList);
		}
		return "shopedit";
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveCard(
			@RequestParam(name="gimageKey",required=false) MultipartFile gimage, 
			@RequestParam(name="topPicFilesKey",required=false) MultipartFile[] topPicImage,
			@RequestParam(name="cpBsFilesKey",required=false) MultipartFile[] cpBsImage,
			HttpServletRequest request, HttpServletResponse response, CardShopsWithBLOBs shop){
		if(shop!=null && shop.getId()!=null && shop.getId()>0) {
			CardShopsWithBLOBs oldShop = shopMapper.selectByPrimaryKey(shop.getId());
			if(oldShop!=null && oldShop.getId()!=0) {
				return this.shopService.updateShop(gimage, topPicImage, cpBsImage, request, response, shop, oldShop);
			}
		}
		return this.shopService.createShop(gimage, topPicImage, cpBsImage, request, response, shop);
	}
	
	private String[] toArray(String value) {
		if(value.startsWith("[")) {
			return value.substring(value.indexOf("[")+1, value.lastIndexOf("]")).split(",");
		}else {
			return value.split(",");
		}
	}
	
}