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
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.service.FileUploadService;

@Controller
@RequestMapping("/namecard")
public class NameCardController {
	
	@Autowired
	private CardMapper cardMapper;
	
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
			Card card = cardMapper.selectByPrimaryKey(id);
			model.addAttribute("card", card);
		}
		return "cardedit";
	}
	
	@RequestMapping("/save")
	@Transactional
	public @ResponseBody CommonMessage saveCard(HttpServletRequest request, HttpServletResponse response, CardWithBLOBs card,
			@RequestParam("logoimage") MultipartFile logoimage, 
			@RequestParam("shareimage") MultipartFile shareimage,
			@RequestParam("style2bgimage") MultipartFile style2bgimage,
			@RequestParam("files") MultipartFile[] personalimage){
		CommonMessage message = new CommonMessage();
		String logoImagePath = fileUploadService.uploadForSingleFile(request, response, logoimage);
		String shareImagePath = fileUploadService.uploadForSingleFile(request, response, shareimage);
		String style2bgImagePath = fileUploadService.uploadForSingleFile(request, response, style2bgimage);
		List<String> personalImagePaths = fileUploadService.uploadForMultiFile(request, response, personalimage);
		this.setCardDefaultValue(card);
		card.setCardLogo(logoImagePath);
		card.setShareImg(shareImagePath);
		card.setTemplateImg(style2bgImagePath);
		card.setPhoto(personalImagePaths.toString());
		card.setTotalPicNum(personalimage.length+3);
		try {
			cardMapper.insert(card);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(style2bgImagePath);
			fileUploadService.deleteFile(shareImagePath);
			fileUploadService.deleteFile(logoImagePath);
			for(String path : personalImagePaths) {
				fileUploadService.deleteFile(path);
			}
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
//		message.setSuccess(true);
//		message.setMessage("保存成功！");
//		return message;
	}
	
	private CardWithBLOBs setCardDefaultValue(CardWithBLOBs card) {
		card.setAddress(card.getAddress()==null?"":card.getAddress());
		card.setAvatarUrl(card.getAvatarUrl()==null?"":card.getAvatarUrl());
		card.setBrowseHeadimgNum(card.getBrowseHeadimgNum()==null?0:card.getBrowseHeadimgNum());
		card.setCardId(card.getCardId()==null?"":card.getCardId());
		card.setCardInstr(card.getCardInstr()==null?"":card.getCardInstr());
		card.setCardLogo(card.getCardLogo()==null?"":card.getCardLogo());
		card.setCardName(card.getCardName()==null?"":card.getCardName());
		card.setCardTel(card.getCardTel()==null?"":card.getCardTel());
		card.setCompanyName(card.getCompanyName()==null?"":card.getCompanyName());
		card.setDetailedAddress(card.getDetailedAddress()==null?"":card.getDetailedAddress());
		card.setEmail(card.getEmail()==null?"":card.getEmail());
		card.setErrmsg(card.getErrmsg()==null?"":card.getErrmsg());
		card.setIdentify(card.getIdentify()==null?"":card.getIdentify());
		card.setIsSendcardId(card.getIsSendcardId()==null?0:card.getIsSendcardId());
		card.setLastUpdateStarTime(card.getLastUpdateStarTime()==null?"":card.getLastUpdateStarTime());
		card.setPhone(card.getPhone()==null?"":card.getPhone());
		card.setPhoto(card.getPhoto()==null?"":card.getPhoto());
		card.setRoleName(card.getRoleName()==null?"":card.getRoleName());
		card.setSeeNum(card.getSeeNum()==null?0:card.getSeeNum());
		card.setShareImg(card.getShareImg()==null?"":card.getShareImg());
		card.setShareNum(card.getShareNum()==null?0:card.getShareNum());
		card.setShareTitle(card.getShareTitle()==null?"":card.getShareTitle());
		card.setSignatureCount(card.getSignatureCount()==null?0:card.getSignatureCount());
		card.setSort(card.getSort()==null?0:card.getSort());
		card.setSourceName(card.getSourceName()==null?"":card.getSourceName());
		card.setTemplateImg(card.getTemplateImg()==null?"":card.getTemplateImg());
		card.setThumbsNum(card.getThumbsNum()==null?0:card.getThumbsNum());
		card.setTotalPicNum(card.getTotalPicNum()==null?0:card.getTotalPicNum());
		card.setUniacid(card.getUniacid()==null?0:card.getUniacid());
		card.setUserid(card.getUserid()==null?"":card.getUserid());
		card.setWeixinid(card.getWeixinid()==null?"":card.getWeixinid());
		card.setZdMsg(card.getZdMsg()==null?"":card.getZdMsg());
		return card;
	}
	
}