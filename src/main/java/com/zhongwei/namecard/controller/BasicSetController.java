package com.zhongwei.namecard.controller;

import java.security.Principal;
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
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;
import com.zhongwei.namecard.service.BasicSetService;

@Controller
@RequestMapping("/basic")
public class BasicSetController {
	
	@Autowired
	private CardSetMapper cardSetMapper;
	
	@Autowired
	private BasicSetService basicSetService;
	
	@RequestMapping("/index")
	public String getIndex(Model model) {
		return "basicsetindex";
	}
	
	@RequestMapping("/getBasicSet")
	public String getBasicSet(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardSetExample cardSetExample = new CardSetExample();
		cardSetExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardSet> cardSetList = this.cardSetMapper.selectByExample(cardSetExample);
		if(cardSetList!=null && cardSetList.size()>0) {
			CardSet cardSet = cardSetList.get(0);
			model.addAttribute("cardSet", cardSet);
		}
		return "basicset";
	}
	
	@RequestMapping(value= {"/basicSetSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage basicSetSave(
			@RequestParam(name="logoimageKey",required=false) MultipartFile logoimage, 
			@RequestParam(name="shopBgImageKey",required=false) MultipartFile shopBgImage,
			 Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response, CardSet cardSet){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		cardSet.setUniacid(user.getUniacid());
		if(cardSet!=null && cardSet.getId()!=null && cardSet.getId()>0) {
			CardSet oldCardSet = cardSetMapper.selectByPrimaryKey(cardSet.getId());
			if(oldCardSet!=null && oldCardSet.getId()!=0) {
				return this.basicSetService.updateBasicSet(logoimage, shopBgImage, request, response, cardSet, oldCardSet);
			}
		}
		return this.basicSetService.createBasicSet(logoimage, shopBgImage, request, response, cardSet);
	}
	
	@RequestMapping("/updateBottomDH")
	public String updateBottomDH(Model model) {
		return "test";
	}
	
}