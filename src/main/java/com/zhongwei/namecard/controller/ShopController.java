package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private CardShopsMapper shopMapper;
	
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
	
	private String[] toArray(String value) {
		if(value.startsWith("[")) {
			return value.substring(value.indexOf("[")+1, value.lastIndexOf("]")).split(",");
		}else {
			return value.split(",");
		}
	}
	
}