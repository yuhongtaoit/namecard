package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.dao.SetFxMapper;
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.dao.ShopsSpecMapper;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;
import com.zhongwei.namecard.entity.SetFx;
import com.zhongwei.namecard.entity.SetFxExample;
import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;
import com.zhongwei.namecard.entity.ShopsSpec;
import com.zhongwei.namecard.entity.ShopsSpecExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;
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
	private SetFxMapper fxMapper;
	
	@Autowired
	private ShopService shopService;
	
	private int pageSize = 2;//每页大小
	
	private int pageNo = 1;//第几页，初始值为1
	
	@RequestMapping("/getShopList")
	public String getShops(Model model, Integer pindex, Principal principal, Authentication authentication) {
		if(pindex == null) 
			pindex = 0;
		
		if(pindex<1) {
			pindex = pageNo;
		}
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardShopsExample cardShopsExample = new CardShopsExample();
		PageHelper.startPage(pindex, pageSize);
		cardShopsExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardShopsWithBLOBs> shopList = shopMapper.selectByExampleWithBLOBs(cardShopsExample);
		for(CardShopsWithBLOBs shop : shopList) {
			ShopsCategory category = this.categoryMapper.selectByPrimaryKey(shop.getTypeid());
			shop.setTypeName(category==null?"":category.getTitle());
		}
		model.addAttribute("shops", shopList);
		return "shoplist";
	}
	
	@RequestMapping("/getShopTotal")
	public @ResponseBody CommonMessage getShopTotal(Model model, Principal principal, Authentication authentication) {
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardShopsExample cardShopsExample = new CardShopsExample();
		cardShopsExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		int total = shopMapper.countByExample(cardShopsExample);
		if(total == 0) {
			total=1;
		}
		message.setSuccess(true);
		message.setMessage(String.valueOf(total%pageSize==0?total/pageSize:total/pageSize+1));
		return message;
	}
	
	@RequestMapping("/getFxSet")
	public String getFxSet(Model model, Integer pindex, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		SetFxExample fxExample = new SetFxExample();
		fxExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<SetFx> setFxList = this.fxMapper.selectByExample(fxExample);
		if(setFxList!=null && setFxList.size()>0) {
			model.addAttribute("fxSet", setFxList.get(0));
		}else {
			model.addAttribute("fxSet", new SetFx());
		}
		return "fxset";
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
			List<String> realTopPicsList = new ArrayList<String>();
			for(String topPic : topPicsList) {
				if(!"".equals(topPic)) {
					realTopPicsList.add(topPic);
				}
			}
			List<String> cpBsImgsList = Arrays.asList(this.toArray(shop.getCpBsImg()));
			List<String> realCpBsImgsList = new ArrayList<String>();
			for(String cpBsImg : cpBsImgsList) {
				if(!"".equals(cpBsImg)) {
					realCpBsImgsList.add(cpBsImg);
				}
			}
			model.addAttribute("shop", shop);
			model.addAttribute("topPics", realTopPicsList);
			model.addAttribute("cpBsImgs", realCpBsImgsList);
			model.addAttribute("categorys", categorys);
			model.addAttribute("propertys", propertys);
		}else {
			model.addAttribute("shop", new CardShopsWithBLOBs());
			model.addAttribute("categorys", categorys);
			model.addAttribute("propertys", propertys);
		}
		return "shopedit";
	}
	
	@RequestMapping(value= {"/fxSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage fxSave(
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, SetFx setFx){
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		setFx.setUniacid(user.getUniacid());
		if(setFx!=null && setFx.getId()!=null && setFx.getId()>0) {
			SetFx oldSetFx = this.fxMapper.selectByPrimaryKey(setFx.getId());
			if(oldSetFx!=null && oldSetFx.getId()!=0) {
				message.setSuccess(true);
				message.setMessage("保存成功！");
				this.fxMapper.updateByPrimaryKey(setFx);
				return message;
			}
		}
		this.fxMapper.insert(setFx);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveShop(
			@RequestParam(name="gimageKey",required=false) MultipartFile gimage, 
			@RequestParam(name="topPicFilesKey",required=false) MultipartFile[] topPicImage,
			@RequestParam(name="cpBsFilesKey",required=false) MultipartFile[] cpBsImage,
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardShopsWithBLOBs shop){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		shop.setUniacid(user.getUniacid());
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