package com.zhongwei.namecard.service;

import java.io.File;
import java.io.IOException;
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
import com.zhongwei.namecard.dao.PaySetMapper;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.PaySet;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Service
public class BasicSetService {
	
	@Autowired
	private CardSetMapper cardSetMapper;
	
	@Autowired
	private PaySetMapper paySetMapper;
	
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
	
	@Transactional
	public CommonMessage createPaySet(MultipartFile certFile, HttpServletRequest request,
			HttpServletResponse response, UserDetailsEntity user, PaySet paySet, String baseFilePath) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		String certPath = this.uploadCert(user, certFile, baseFilePath);
		paySet.setUniacid(user.getUniacid());
		paySet.setCertpath(certPath);
		this.setPaySetDefaultValue(paySet);
		try {
			paySetMapper.insert(paySet);
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
	public CommonMessage updatePaySet(MultipartFile certFile, HttpServletRequest request,
			HttpServletResponse response, PaySet paySet, PaySet oldPaySet, UserDetailsEntity user, String baseFilePath) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setPaySetDefaultValue(paySet);
			if(certFile==null && !StringUtils.isEmpty(paySet.getCertpath())) {
				paySet.setCertpath(oldPaySet.getCertpath());
			}else {
				paySet.setCertpath(this.uploadCert(user, certFile, baseFilePath));
			}
			this.paySetMapper.updateByPrimaryKey(paySet);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private PaySet setPaySetDefaultValue(PaySet paySet) {
		paySet.setCertpath(paySet.getCertpath()==null?"":paySet.getCertpath());
		paySet.setMchid(paySet.getMchid()==null?"":paySet.getMchid());
		paySet.setMchkey(paySet.getMchkey()==null?"":paySet.getMchkey());
		paySet.setSubappid(paySet.getSubappid()==null?"":paySet.getSubappid());
		paySet.setSubmchid(paySet.getSubmchid()==null?"":paySet.getSubmchid());
		paySet.setSubmchkey(paySet.getSubmchkey()==null?"":paySet.getSubmchkey());
		paySet.setUniacid(paySet.getUniacid()==null?0:paySet.getUniacid());
		return paySet;
	}
	
	private String uploadCert(UserDetailsEntity user, MultipartFile certFile, String baseFilePath) {
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
		return returnPath;
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
