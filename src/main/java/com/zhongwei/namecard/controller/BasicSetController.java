package com.zhongwei.namecard.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value(value = "${file.basefilepath}")
	private String baseFilePath;//资源文件绝对地址目录
	
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
	
	@RequestMapping("/getWxPaySet")
	public String getWxPaySet(Model model, Principal principal, Authentication authentication) {
		return "wxpayset";
	}
	
	@RequestMapping(value= {"/wxPaySetSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage wxPaySetSave(
			@RequestParam(name="certFileKey",required=false) MultipartFile certFile, 
			 Principal principal, Authentication authentication,
			HttpServletRequest request, HttpServletResponse response){
		CommonMessage message = new CommonMessage();
		try {
			UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
			File filePath = new File(baseFilePath);
			if (!filePath.exists() && !filePath.isDirectory()) {
				System.out.println("目录不存在，创建目录：" + filePath);
				filePath.mkdir();
			}
			String fileName = "apiclient_cert.p12";
			String returnPath = "attachment/cert/"+user.getUniacid()+"/"+fileName;
			File tempFile = new File(filePath.getAbsolutePath(),returnPath);
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdirs();
			}
			if (!tempFile.exists()) {
				try {
					tempFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				certFile.transferTo(tempFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			message.setSuccess(true);
			message.setMessage("上传成功");
		} catch (Exception e) {
			// TODO: handle exception
			message.setSuccess(false);
			message.setMessage("上传失败");
		}
		return message;
	}
	
	@RequestMapping("/updateBottomDH")
	public String updateBottomDH(Model model) {
		return "test";
	}
	
}