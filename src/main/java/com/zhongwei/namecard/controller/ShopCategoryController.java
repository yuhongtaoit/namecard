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
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.ShopCategoryService;

@Controller
@RequestMapping("/shopCategory")
public class ShopCategoryController {
	
	@Autowired
	private ShopsCategoryMapper shopsCategoryMapper;
	
	@Autowired
	private ShopCategoryService categoryService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/getCategoryList")
	public String getCategoryList(Model model) {
		List<ShopsCategory> shopCategoryList = shopsCategoryMapper.selectByExample(new ShopsCategoryExample());
		model.addAttribute("categorys", shopCategoryList);
		return "shopcategorylist";
	}
	
	@RequestMapping("/edit")
	public String editShopCategory(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			ShopsCategory shopCategory = shopsCategoryMapper.selectByPrimaryKey(id);
			model.addAttribute("category", shopCategory);
		}
		return "shopcategoryedit";
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveCategory(
			@RequestParam(name="thumbimageKey",required=false) MultipartFile thumbimage, 
			HttpServletRequest request, HttpServletResponse response, ShopsCategory category){
		if(category!=null && category.getId()!=null && category.getId()>0) {
			ShopsCategory oldCategory = shopsCategoryMapper.selectByPrimaryKey(category.getId());
			if(oldCategory!=null && oldCategory.getId()!=0) {
				return this.categoryService.updateShop(thumbimage, request, response, category, oldCategory);
			}
		}
		return this.categoryService.createShop(thumbimage, request, response, category);
	}
	
	@RequestMapping(value="/delete")
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			ShopsCategory category = shopsCategoryMapper.selectByPrimaryKey(id);
			this.fileUploadService.deleteFile(category.getThumb().trim());
			shopsCategoryMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
}