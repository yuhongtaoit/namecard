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
import com.zhongwei.namecard.dao.CardProductMapper;
import com.zhongwei.namecard.entity.CardProductExample;
import com.zhongwei.namecard.entity.CardProductWithBLOBs;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.ProductService;

@Controller
@RequestMapping("/product")
public class CardProductController {
	
	@Autowired
	private CardProductMapper productMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getProductList")
	public String getShops(Model model) {
		List<CardProductWithBLOBs> productList = productMapper.selectByExampleWithBLOBs(new CardProductExample());
		model.addAttribute("products", productList);
		return "productlist";
	}
	
	@RequestMapping("/edit")
	public String editShop(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardProductWithBLOBs product = productMapper.selectByPrimaryKey(id);
			List<String> cpBsImgList = Arrays.asList(this.toArray(product.getCpBsImg()));
			List<String> cpBsContentList = Arrays.asList(this.toArray(product.getCpBsContent()));
			model.addAttribute("product", product);
			model.addAttribute("cpBsImgs", cpBsImgList);
			model.addAttribute("cpBsContents", cpBsContentList);
		}else {
			model.addAttribute("shop", new CardProductWithBLOBs());
		}
		return "productedit";
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveShop(
			@RequestParam(name="cpBsImgFilesKey",required=false) MultipartFile[] cpBsImg,
			@RequestParam(name="cpBsContentFilesKey",required=false) MultipartFile[] cpBsContent,
			HttpServletRequest request, HttpServletResponse response, CardProductWithBLOBs product){
		if(product!=null && product.getId()!=null && product.getId()>0) {
			CardProductWithBLOBs oldProduct = productMapper.selectByPrimaryKey(product.getId());
			if(oldProduct!=null && oldProduct.getId()!=0) {
				return this.productService.updateProduct(cpBsImg, cpBsContent, request, response, product, oldProduct);
			}
		}
		return this.productService.createProduct(cpBsImg, cpBsContent, request, response, product);
	}
	
	@RequestMapping(value="/delete")
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardProductWithBLOBs product = productMapper.selectByPrimaryKey(id);
			String[] cpBsImgPaths = this.toArray(product.getCpBsImg());
			for(String cpBsImg : cpBsImgPaths) {
				this.fileUploadService.deleteFile(cpBsImg.trim());
			}
			String[] cpBsContentPaths = this.toArray(product.getCpBsContent());
			for(String cpBsContent : cpBsContentPaths) {
				this.fileUploadService.deleteFile(cpBsContent.trim());
			}
			productMapper.deleteByPrimaryKey(id);
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