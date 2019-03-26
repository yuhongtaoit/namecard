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
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.NameCardService;

@Controller
@RequestMapping("/namecard")
public class NameCardController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private NameCardService nameCardService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/getNamecardList")
	public String getUsers(Model model) {
		List<Card> cardList = cardMapper.selectByExample(new CardExample());
		model.addAttribute("cards", cardList);
		return "cardlist";
	}
	
	@RequestMapping("/edit")
	public String editCard(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardWithBLOBs card = cardMapper.selectByPrimaryKey(id);
			List<String> photoList = Arrays.asList(this.toArray(card.getPhoto()));
			model.addAttribute("card", card);
			model.addAttribute("photos", photoList);
		}
		return "cardedit";
	}
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveCard(
			@RequestParam(name="logoimageKey",required=false) MultipartFile logoimage, 
			@RequestParam(name="shareimageKey",required=false) MultipartFile shareimage,
			@RequestParam(name="style2bgimageKey",required=false) MultipartFile style2bgimage,
			@RequestParam(name="filesKey",required=false) MultipartFile[] personalimage,
			HttpServletRequest request, HttpServletResponse response, CardWithBLOBs card){
		if(card!=null && card.getId()!=null && card.getId()>0) {
			CardWithBLOBs oldCard = cardMapper.selectByPrimaryKey(card.getId());
			if(oldCard!=null && oldCard.getId()!=0) {
				return this.nameCardService.updateNameCard(logoimage, shareimage, style2bgimage, personalimage, request, response, card, oldCard);
			}
		}
		return this.nameCardService.createNameCard(logoimage, shareimage, style2bgimage, personalimage, request, response, card);
	}
	
	@RequestMapping(value="/delete")
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardWithBLOBs card = cardMapper.selectByPrimaryKey(id);
			String[] photoPaths = this.toArray(card.getPhoto());
			for(String photo : photoPaths) {
				this.fileUploadService.deleteFile(photo.trim());
			}
			this.fileUploadService.deleteFile(card.getCardLogo().trim());
			this.fileUploadService.deleteFile(card.getShareImg().trim());
			this.fileUploadService.deleteFile(card.getTemplateImg().trim());
			cardMapper.deleteByPrimaryKey(id);
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