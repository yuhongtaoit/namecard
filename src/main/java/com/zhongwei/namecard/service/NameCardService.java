package com.zhongwei.namecard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.utils.QySendUtils;

@Service
public class NameCardService {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private AccountWxappMapper accountMapper;
	
	@Autowired
	private MiniQrService miniQrService;
	
	@Transactional
	public CommonMessage createNameCard(MultipartFile logoimage, MultipartFile video, MultipartFile shareimage,MultipartFile style2bgimage,MultipartFile[] personalimage,
			HttpServletRequest request, HttpServletResponse response, CardWithBLOBs card) {
		CommonMessage message = new CommonMessage();
		String logoImagePath = fileUploadService.uploadForSingleFile(request, response, logoimage);
		String videoPath = "";
		if(video!=null) {
			videoPath = fileUploadService.uploadForSingleFile(request, response, video);
		}
		String shareImagePath = fileUploadService.uploadForSingleFile(request, response, shareimage);
		String style2bgImagePath = fileUploadService.uploadForSingleFile(request, response, style2bgimage);
		List<String> personalImagePaths = fileUploadService.uploadForMultiFile(request, response, personalimage);
		this.setCardDefaultValue(card);
		card.setCardLogo(logoImagePath);
		card.setVedio(videoPath);
		card.setShareImg(shareImagePath);
		card.setTemplateImg(style2bgImagePath);
		card.setPhoto(personalImagePaths.toString());
		card.setTotalPicNum(personalimage.length+3);
		try {
			cardMapper.insert(card);
			AccountWxapp account = accountMapper.selectByPrimaryKey(card.getUniacid());
			String accessToken = QySendUtils.getAccountToken(account.getKey(), account.getSecret(), card.getUniacid());
			this.miniQrService.getMiniQr("uniacid="+card.getUniacid()+"&card_id="+card.getId(), accessToken, card.getUniacid(), card.getId());
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(style2bgImagePath);
			fileUploadService.deleteFile(shareImagePath);
			fileUploadService.deleteFile(logoImagePath);
			fileUploadService.deleteFile(videoPath);
			for(String path : personalImagePaths) {
				fileUploadService.deleteFile(path);
			}
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	public CommonMessage updateNameCard(MultipartFile logoimage, MultipartFile video, MultipartFile shareimage,MultipartFile style2bgimage,MultipartFile[] personalimage,
			HttpServletRequest request, HttpServletResponse response, CardWithBLOBs card, CardWithBLOBs oldCard) {
		CommonMessage message = new CommonMessage();
		try {
			this.setCardDefaultValue(card);
			if(logoimage==null && !StringUtils.isEmpty(card.getCardLogo())) {
				card.setCardLogo(oldCard.getCardLogo());
			}else {
				this.fileUploadService.deleteFile(oldCard.getCardLogo());
				card.setCardLogo(this.fileUploadService.uploadForSingleFile(request, response, logoimage));
			}
			if(video==null && !StringUtils.isEmpty(card.getVedio())) {
				card.setVedio(oldCard.getVedio());
			}else {
				if(oldCard.getVedio()!=null) {
					this.fileUploadService.deleteFile(oldCard.getVedio());
				}
				card.setVedio(this.fileUploadService.uploadForSingleFile(request, response, video));
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
			List<String> photoList = Arrays.asList(this.toArray(card.getPhoto()));
			List<String> oldPhotoList = Arrays.asList(this.toArray(oldCard.getPhoto()));
			if(personalimage==null || personalimage.length<=0) {
				this.removeNotExistFile(photoList, oldPhotoList);
			}else {
				List<String> newPhotoPaths = new ArrayList<String>();
				this.removeNotExistFile(photoList, oldPhotoList);
				List<String> newPersonalImagePaths = this.fileUploadService.uploadForMultiFile(request, response, personalimage);
				for(String photo : photoList) {
					newPhotoPaths.add(photo);
				}
				newPhotoPaths.addAll(newPersonalImagePaths);
				card.setPhoto(newPhotoPaths.toString());
			}
			this.cardMapper.updateByPrimaryKeyWithBLOBs(card);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private String[] toArray(String value) {
		if(value.startsWith("[")) {
			return value.substring(value.indexOf("[")+1, value.lastIndexOf("]")).split(",");
		}else {
			return value.split(",");
		}
	}
	
	private List<String> removeNotExistFile(List<String> files,List<String> oldFiles) {
		for(String oldFile : oldFiles) {
			if(!files.contains(oldFile)) {
				this.fileUploadService.deleteFile(oldFile.trim());
			}
		}
		return files;
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
		card.setUniacid(card.getUniacid()==null?2:card.getUniacid());
		card.setUserid(card.getUserid()==null?"":card.getUserid());
		card.setWeixinid(card.getWeixinid()==null?"":card.getWeixinid());
		card.setZdMsg(card.getZdMsg()==null?"":card.getZdMsg());
		return card;
	}
}
