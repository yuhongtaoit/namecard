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
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private CardShopsMapper shopMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private ShopsCategoryMapper categoryMapper;
	
	@Autowired
	private ShopsSpecMapper propertyMapper;
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/getShopList")
	public String getShops(Model model) {
		List<CardShopsWithBLOBs> shopList = shopMapper.selectByExampleWithBLOBs(new CardShopsExample());
		for(CardShopsWithBLOBs shop : shopList) {
			shop.setTypeName(this.categoryMapper.selectByPrimaryKey(shop.getTypeid()).getTitle());
		}
		model.addAttribute("shops", shopList);
		return "shoplist";
	}
	
	@RequestMapping("/edit")
	public String editShop(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		ShopsCategoryExample categoryExample = new ShopsCategoryExample();
		categoryExample.createCriteria().andEnabledNotEqualTo(false);
		List<ShopsCategory> categorys = this.categoryMapper.selectByExample(categoryExample);
		ShopsSpecExample propertyExample = new ShopsSpecExample();
		propertyExample.createCriteria().andEnabledNotEqualTo(false);
		List<ShopsSpec> propertys = this.propertyMapper.selectByExample(propertyExample);
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardShopsWithBLOBs shop = shopMapper.selectByPrimaryKey(id);
			List<String> topPicsList = Arrays.asList(this.toArray(shop.getTopPic()));
			List<String> cpBsImgsList = Arrays.asList(this.toArray(shop.getCpBsImg()));
			model.addAttribute("shop", shop);
			model.addAttribute("topPics", topPicsList);
			model.addAttribute("cpBsImgs", cpBsImgsList);
			model.addAttribute("categorys", categorys);
			model.addAttribute("propertys", propertys);
		}else {
			model.addAttribute("shop", new CardShopsWithBLOBs());
			model.addAttribute("categorys", categorys);
			model.addAttribute("propertys", propertys);
		}
		return "shopedit";
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveShop(
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
	
	@RequestMapping(value="/delete")
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardShopsWithBLOBs shop = shopMapper.selectByPrimaryKey(id);
			String[] topPicPaths = this.toArray(shop.getTopPic());
			for(String topPic : topPicPaths) {
				this.fileUploadService.deleteFile(topPic.trim());
			}
			String[] cpBsPaths = this.toArray(shop.getCpBsImg());
			for(String cpBs : cpBsPaths) {
				this.fileUploadService.deleteFile(cpBs.trim());
			}
			this.fileUploadService.deleteFile(shop.getGimg().trim());
			shopMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	private String[] toArray(String value) {
		if(value.startsWith("[")) {
			return value.substring(value.indexOf("[")+1, value.lastIndexOf("]")).split(",");
		}else {
			return value.split(",");
		}
	}
	
}