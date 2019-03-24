package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
	
	@RequestMapping(value= {"/save"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage saveCard(
			@RequestParam(name="logoimageKey",required=false) MultipartFile logoimage, 
			@RequestParam(name="shareimageKey",required=false) MultipartFile shareimage,
			@RequestParam(name="style2bgimageKey",required=false) MultipartFile style2bgimage,
			@RequestParam(name="filesKey",required=false) MultipartFile[] personalimage,
			HttpServletRequest request, HttpServletResponse response, CardWithBLOBs card){
		CommonMessage message = new CommonMessage();
		if(card!=null && card.getId()!=null && card.getId()>0) {
			CardWithBLOBs oldCard = cardMapper.selectByPrimaryKey(card.getId());
			if(oldCard!=null && oldCard.getId()!=0) {
				this.setCardDefaultValue(card);
				if(logoimage==null && !StringUtils.isEmpty(card.getCardLogo())) {
					card.setCardLogo(oldCard.getCardLogo());
				}else {
					this.fileUploadService.deleteFile(oldCard.getCardLogo());
					card.setCardLogo(this.fileUploadService.uploadForSingleFile(request, response, logoimage));
				}
				if(shareimage==null && !StringUtils.isEmpty(card.getShareImg())) {
					card.setShareImg(oldCard.getShareImg());
				}else {
					this.fileUploadService.deleteFile(oldCard.getShareImg());
					card.setShareImg(this.fileUploadService.uploadForSingleFile(request, response, shareimage));
				}
				if(style2bgimage==null && !StringUtils.isEmpty(card.getTemplateImg())) {
					card.setTemplateImg(oldCard.getTemplateImg());
				}else {
					this.fileUploadService.deleteFile(oldCard.getTemplateImg());
					card.setTemplateImg(this.fileUploadService.uploadForSingleFile(request, response, style2bgimage));
				}
				if(personalimage==null || personalimage.length<=0) {
					card.setPhoto(oldCard.getPhoto());
					String photo = card.getPhoto();
					photo.substring(photo.indexOf("[")+1, photo.lastIndexOf("]"));
				}else {
					String photo = card.getPhoto();
					photo.substring(photo.indexOf("["), photo.lastIndexOf("]"));
					String oldPhoto = oldCard.getPhoto();
				}
				this.cardMapper.updateByPrimaryKey(card);
			}
		}
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