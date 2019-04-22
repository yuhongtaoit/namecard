package com.zhongwei.namecard.controller;

import java.security.Principal;
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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardProductMapper;
import com.zhongwei.namecard.entity.CardProductExample;
import com.zhongwei.namecard.entity.CardProductWithBLOBs;
import com.zhongwei.namecard.entity.UserDetailsEntity;
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
	
	private int pageSize = 2;//每页大小
	
	private int pageNo = 1;//第几页，初始值为1
	
	@RequestMapping("/getProductList")
	public String getProducts(Model model, Integer pindex, Principal principal, Authentication authentication) {
		if(pindex == null) 
			pindex = 0;
		
		if(pindex<1) {
			pindex = pageNo;
		}
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardProductExample cardProductExample = new CardProductExample();
		Page<CardProductWithBLOBs> page = PageHelper.startPage(pindex, pageSize);
		cardProductExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardProductWithBLOBs> productList = productMapper.selectByExampleWithBLOBs(cardProductExample);
		model.addAttribute("products", productList);
		return "productlist";
	}
	
	@RequestMapping("/getProductTotal")
	public @ResponseBody CommonMessage getProductTotal(Model model, Principal principal, Authentication authentication) {
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardProductExample cardProductExample = new CardProductExample();
		cardProductExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		int total = productMapper.countByExample(cardProductExample);
		message.setSuccess(true);
		message.setMessage(String.valueOf(total%pageSize==0?total/pageSize:total/pageSize+1));
		return message;
	}
	
	@RequestMapping("/edit")
	public String editProduct(HttpServletRequest request, HttpServletResponse response, Model model){
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
			model.addAttribute("product", new CardProductWithBLOBs());
		}
		return "productedit";
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveProduct(
			@RequestParam(name="cpBsImgFilesKey",required=false) MultipartFile[] cpBsImg,
			@RequestParam(name="cpBsContentFilesKey",required=false) MultipartFile[] cpBsContent,
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardProductWithBLOBs product){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		product.setUniacid(user.getUniacid());
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