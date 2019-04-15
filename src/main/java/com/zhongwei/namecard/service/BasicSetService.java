package com.zhongwei.namecard.service;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.CardSet;

@Service
public class BasicSetService {
	
	@Autowired
	private CardSetMapper cardSetMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Transactional
	public CommonMessage updateBasicSet(MultipartFile logoimage, MultipartFile shopBgImage, HttpServletRequest request,
			HttpServletResponse response, CardSet cardSet, CardSet oldCardSet) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setBasicSetDefaultValue(cardSet);
			if(logoimage==null && !StringUtils.isEmpty(cardSet.getCompanyLogo())) {
				cardSet.setCompanyLogo(oldCardSet.getCompanyLogo());
			}else {
				this.fileUploadService.deleteFile(oldCardSet.getCompanyLogo());
				cardSet.setCompanyLogo(this.fileUploadService.uploadForSingleFile(request, response, logoimage));
			}
			if(shopBgImage==null && !StringUtils.isEmpty(cardSet.getShopBg())) {
				cardSet.setShopBg(oldCardSet.getShopBg());
			}else {
				this.fileUploadService.deleteFile(oldCardSet.getShopBg());
				cardSet.setShopBg(this.fileUploadService.uploadForSingleFile(request, response, shopBgImage));
			}
			this.cardSetMapper.updateByPrimaryKey(cardSet);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}

	@Transactional
	public CommonMessage createBasicSet(MultipartFile logoimage, MultipartFile shopBgImage, HttpServletRequest request,
			HttpServletResponse response, CardSet cardSet) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		String logoImagePath = fileUploadService.uploadForSingleFile(request, response, logoimage);
		String shopBgImagePath = fileUploadService.uploadForSingleFile(request, response, shopBgImage);
		this.setBasicSetDefaultValue(cardSet);
		cardSet.setCompanyLogo(logoImagePath);
		cardSet.setShopBg(shopBgImagePath);
		try {
			cardSetMapper.insert(cardSet);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(shopBgImagePath);
			fileUploadService.deleteFile(logoImagePath);
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private CardSet setBasicSetDefaultValue(CardSet cardSet) {
		cardSet.setCompanyAddr(cardSet.getCompanyAddr()==null?"":cardSet.getCompanyAddr());
		cardSet.setCompanyLogo(cardSet.getCompanyLogo()==null?"":cardSet.getCompanyLogo());
		cardSet.setCompanyName(cardSet.getCompanyName()==null?"":cardSet.getCompanyName());
		cardSet.setCompanyTel(cardSet.getCompanyTel()==null?"":cardSet.getCompanyTel());
		cardSet.setLat(cardSet.getLat()==null?"":cardSet.getLat());
		cardSet.setLng(cardSet.getLng()==null?"":cardSet.getLng());
		cardSet.setNum(cardSet.getNum()==null?0:cardSet.getNum());
		cardSet.setOpenRedpack(cardSet.getOpenRedpack()==null?0:cardSet.getOpenRedpack());
		cardSet.setRedpackMax(cardSet.getRedpackMax()==null?BigDecimal.ZERO:cardSet.getRedpackMax());
		cardSet.setRedpackMin(cardSet.getRedpackMin()==null?BigDecimal.ZERO:cardSet.getRedpackMin());
		cardSet.setShopBg(cardSet.getShopBg()==null?"":cardSet.getShopBg());
		cardSet.setTemplateId(cardSet.getTemplateId()==null?"":cardSet.getTemplateId());
		cardSet.setUniacid(cardSet.getUniacid()==null?0:cardSet.getUniacid());
		return cardSet;
	}
	
}
