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

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardAdvMapper;
import com.zhongwei.namecard.dao.CardNavMapper;
import com.zhongwei.namecard.dao.CardNewsMapper;
import com.zhongwei.namecard.dao.CardWebMapper;
import com.zhongwei.namecard.entity.CardAdv;
import com.zhongwei.namecard.entity.CardAdvExample;
import com.zhongwei.namecard.entity.CardNav;
import com.zhongwei.namecard.entity.CardNavExample;
import com.zhongwei.namecard.entity.CardNews;
import com.zhongwei.namecard.entity.CardNewsExample;
import com.zhongwei.namecard.entity.CardWeb;
import com.zhongwei.namecard.entity.CardWebExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.WebSiteService;

@Controller
@RequestMapping("/website")
public class WebSiteManageController {
	
	@Autowired
	private CardWebMapper cardWebMapper;
	
	@Autowired
	private CardAdvMapper cardAdvMapper;
	
	@Autowired
	private CardNavMapper cardNavMapper;
	
	@Autowired
	private CardNewsMapper cardNewsMapper;
	
	@Autowired
	private WebSiteService webSiteService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "websiteindex";
	}
	
	@RequestMapping("/getBasicSet")
	public String getBasicSet(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardWebExample cardWebExample = new CardWebExample();
		cardWebExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardWeb> cardWebList = this.cardWebMapper.selectByExampleWithBLOBs(cardWebExample);
		if(cardWebList!=null && cardWebList.size()>0) {
			CardWeb cardWeb = cardWebList.get(0);
			model.addAttribute("cardWeb", cardWeb);
			List<String> cpBsImgsList = Arrays.asList(this.toArray(cardWeb.getCpBsContent()));
			List<String> realCpBsImgsList = new ArrayList<String>();
			for(String cpBsImg : cpBsImgsList) {
				if(!"".equals(cpBsImg)) {
					realCpBsImgsList.add(cpBsImg);
				}
			}
			model.addAttribute("cpBsImgs", realCpBsImgsList);
		}
		return "webbasicset";
	}
	
	@RequestMapping("/getAdvList")
	public String getAdvList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardAdvExample cardAdvExample = new CardAdvExample();
		cardAdvExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardAdv> cardAdvList = cardAdvMapper.selectByExample(cardAdvExample);
		model.addAttribute("cardAdvList", cardAdvList);
		return "websiteadvlist";
	}
	
	@RequestMapping("/advEdit")
	public String advEdit(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardAdv cardAdv = cardAdvMapper.selectByPrimaryKey(id);
			model.addAttribute("cardAdv", cardAdv);
		}else {
			model.addAttribute("cardAdv", new CardAdv());
		}
		return "websiteadvedit";
	}
	
	@RequestMapping(value= {"/advSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage advSave(
			@RequestParam(name="gimageKey",required=false) MultipartFile gimage, 
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardAdv cardAdv){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		cardAdv.setUniacid(user.getUniacid());
		if(cardAdv!=null && cardAdv.getId()!=null && cardAdv.getId()>0) {
			CardAdv oldCardAdv = cardAdvMapper.selectByPrimaryKey(cardAdv.getId());
			if(oldCardAdv!=null && oldCardAdv.getId()!=0) {
				return this.webSiteService.updateAdv(gimage, request, response, cardAdv, oldCardAdv);
			}
		}
		return this.webSiteService.createAdv(gimage, request, response, cardAdv);
	}
	
	@RequestMapping(value="/advDelete")
    @Transactional
    public @ResponseBody CommonMessage advDelete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardAdv cardAdv = this.cardAdvMapper.selectByPrimaryKey(id);
			this.fileUploadService.deleteFile(cardAdv.getImages().trim());
			this.cardAdvMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	@RequestMapping("/getNavList")
	public String getNavList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardNavExample cardNavExample = new CardNavExample();
		cardNavExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardNav> cardNavList = cardNavMapper.selectByExample(cardNavExample);
		model.addAttribute("cardNavList", cardNavList);
		return "websitenavlist";
	}
	
	@RequestMapping("/navEdit")
	public String navEdit(HttpServletRequest request, Principal principal, Authentication authentication, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardNewsExample cardNewsExample = new CardNewsExample();
		cardNewsExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardNews> cardNews = this.cardNewsMapper.selectByExampleWithBLOBs(cardNewsExample);
		model.addAttribute("cardNews", cardNews);
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardNav cardNav = cardNavMapper.selectByPrimaryKey(id);
			model.addAttribute("cardNav", cardNav);
		}else {
			model.addAttribute("cardNav", new CardNav());
		}
		return "websitenavedit";
	}
	
	@RequestMapping(value= {"/navSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage navSave(
			@RequestParam(name="gimageKey",required=false) MultipartFile gimage, 
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardNav cardNav){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		cardNav.setUniacid(user.getUniacid());
		if(cardNav!=null && cardNav.getId()!=null && cardNav.getId()>0) {
			CardNav oldCardNav = cardNavMapper.selectByPrimaryKey(cardNav.getId());
			if(oldCardNav!=null && oldCardNav.getId()!=0) {
				return this.webSiteService.updateNav(gimage, request, response, cardNav, oldCardNav);
			}
		}
		return this.webSiteService.createNav(gimage, request, response, cardNav);
	}
	
	@RequestMapping(value="/navDelete")
    @Transactional
    public @ResponseBody CommonMessage navDelete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardNav cardNav = this.cardNavMapper.selectByPrimaryKey(id);
			this.fileUploadService.deleteFile(cardNav.getImages().trim());
			this.cardNavMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	@RequestMapping("/getNewsList")
	public String getNewsList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardNewsExample cardNewsExample = new CardNewsExample();
		cardNewsExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardNews> cardNewsList = cardNewsMapper.selectByExample(cardNewsExample);
		model.addAttribute("cardNewsList", cardNewsList);
		return "websitenewslist";
	}
	
	@RequestMapping("/newsEdit")
	public String newsEdit(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardNews cardNews = cardNewsMapper.selectByPrimaryKey(id);
			model.addAttribute("cardNews", cardNews);
		}else {
			model.addAttribute("cardNews", new CardNews());
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "websitenewsedit";
	}
	
	@RequestMapping(value= {"/newsSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage newsSave(
			@RequestParam(name="gimageKey",required=false) MultipartFile gimage, 
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardNews cardNews){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		cardNews.setUniacid(user.getUniacid());
		if(cardNews!=null && cardNews.getId()!=null && cardNews.getId()>0) {
			CardNews oldCardNews = cardNewsMapper.selectByPrimaryKey(cardNews.getId());
			if(oldCardNews!=null && oldCardNews.getId()!=0) {
				return this.webSiteService.updateNews(gimage, request, response, cardNews, oldCardNews);
			}
		}
		return this.webSiteService.createNews(gimage, request, response, cardNews);
	}
	
	@RequestMapping(value="/newsDelete")
    @Transactional
    public @ResponseBody CommonMessage newsDelete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardNews cardNews = this.cardNewsMapper.selectByPrimaryKey(id);
			this.fileUploadService.deleteFile(cardNews.getHeadImg().trim());
			this.cardNewsMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	@RequestMapping(value= {"/basicSetSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage basicSetSave(
			@RequestParam(name="videoKey",required=false) MultipartFile video, 
			@RequestParam(name="imagesKey",required=false) MultipartFile images, 
			@RequestParam(name="cpBsFilesKey",required=false) MultipartFile[] cpBsImage,
			Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardWeb cardWeb){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		cardWeb.setUniacid(user.getUniacid());
		if(cardWeb!=null && cardWeb.getId()!=null && cardWeb.getId()>0) {
			CardWeb oldCardWeb = cardWebMapper.selectByPrimaryKey(cardWeb.getId());
			if(oldCardWeb!=null && oldCardWeb.getId()!=0) {
				return this.webSiteService.updateWebBasicSet(video, images, cpBsImage, request, response, cardWeb, oldCardWeb);
			}
		}
		return this.webSiteService.createWebBasicSet(video, images, cpBsImage, request, response, cardWeb);
	}
	
	private String[] toArray(String value) {
		if(value.startsWith("[")) {
			return value.substring(value.indexOf("[")+1, value.lastIndexOf("]")).split(",");
		}else {
			return value.split(",");
		}
	}
	
}