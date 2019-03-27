package com.zhongwei.namecard.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;

@Service
public class ShopService {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private CardShopsMapper shopMapper;
	
	@Transactional
	public CommonMessage updateShop(MultipartFile gimage, MultipartFile[] topPicImage, MultipartFile[] cpBsImage,
			HttpServletRequest request, HttpServletResponse response, CardShopsWithBLOBs shop,
			CardShopsWithBLOBs oldShop) {
		CommonMessage message = new CommonMessage();
		try {
			this.setShopDefaultValue(shop);
			if(gimage==null && !StringUtils.isEmpty(shop.getGimg())) {
				shop.setGimg(oldShop.getGimg());
			}else {
				this.fileUploadService.deleteFile(oldShop.getGimg());
				shop.setGimg(this.fileUploadService.uploadForSingleFile(request, response, gimage));
			}
			List<String> topPicList = Arrays.asList(this.toArray(shop.getTopPic()));
			List<String> oldTopPicList = Arrays.asList(this.toArray(oldShop.getTopPic()));
			if(topPicImage==null || topPicImage.length<=0) {
				this.removeNotExistFile(topPicList, oldTopPicList);
			}else {
				List<String> newTopPicPaths = new ArrayList<String>();
				this.removeNotExistFile(topPicList, oldTopPicList);
				List<String> newTopPicImagePaths = this.fileUploadService.uploadForMultiFile(request, response, topPicImage);
				for(String topPic : topPicList) {
					newTopPicPaths.add(topPic);
				}
				newTopPicPaths.addAll(newTopPicImagePaths);
				shop.setTopPic(newTopPicPaths.toString());
			}
			List<String> cpBsList = Arrays.asList(this.toArray(shop.getCpBsImg()));
			List<String> oldCpBsList = Arrays.asList(this.toArray(oldShop.getCpBsImg()));
			if(cpBsImage==null || cpBsImage.length<=0) {
				this.removeNotExistFile(cpBsList, oldCpBsList);
			}else {
				List<String> newCpBsPaths = new ArrayList<String>();
				this.removeNotExistFile(cpBsList, oldCpBsList);
				List<String> newCpBsImagePaths = this.fileUploadService.uploadForMultiFile(request, response, cpBsImage);
				for(String cpBs : cpBsList) {
					newCpBsPaths.add(cpBs);
				}
				newCpBsPaths.addAll(newCpBsImagePaths);
				shop.setTopPic(newCpBsPaths.toString());
			}
			this.shopMapper.updateByPrimaryKeyWithBLOBs(shop);
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
	public CommonMessage createShop(MultipartFile gimage, MultipartFile[] topPicImage, MultipartFile[] cpBsImage,
			HttpServletRequest request, HttpServletResponse response, CardShopsWithBLOBs shop) {
		CommonMessage message = new CommonMessage();
		String gimagePath = fileUploadService.uploadForSingleFile(request, response, gimage);
		List<String> topPicImagePaths = fileUploadService.uploadForMultiFile(request, response, topPicImage);
		List<String> cpBsImagePaths = fileUploadService.uploadForMultiFile(request, response, cpBsImage);
		this.setShopDefaultValue(shop);
		shop.setGimg(gimagePath);
		shop.setTopPic(topPicImagePaths.toString());
		shop.setCpBsImg(cpBsImagePaths.toString());
		try {
			shopMapper.insert(shop);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(gimagePath);
			for(String path : topPicImagePaths) {
				fileUploadService.deleteFile(path);
			}
			for(String path : cpBsImagePaths) {
				fileUploadService.deleteFile(path);
			}
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
	
	private CardShopsWithBLOBs setShopDefaultValue(CardShopsWithBLOBs shop) {
		shop.setAddtime(shop.getAddtime()==null?"":shop.getAddtime());
		shop.setCpBsContent(shop.getCpBsContent()==null?"":shop.getCpBsContent());
		shop.setCpBsImg(shop.getCpBsImg()==null?"":shop.getCpBsImg());
		shop.setCpBsName(shop.getCpBsName()==null?"":shop.getCpBsName());
		shop.setFxPrice(shop.getFxPrice()==null?BigDecimal.ZERO:shop.getFxPrice());
		shop.setGimg(shop.getGimg()==null?"":shop.getGimg());
		shop.setPrice(shop.getPrice()==null?BigDecimal.ZERO:shop.getPrice());
		shop.setSaleNum(shop.getSaleNum()==null?0:shop.getSaleNum());
		shop.setShopName(shop.getShopName()==null?"":shop.getShopName());
		shop.setShopsNum(shop.getShopsNum()==null?0:shop.getShopsNum());
		shop.setSort(shop.getSort()==null?0:shop.getSort());
		shop.setSpec(shop.getSpec()==null?new HashMap<String, Object>():shop.getSpec());
		shop.setSpecid(shop.getSpecid()==null?0:shop.getSpecid());
		shop.setTopPic(shop.getTopPic()==null?"":shop.getTopPic());
		shop.setTypeid(shop.getTypeid()==null?0:shop.getTypeid());
		shop.setUniacid(shop.getUniacid()==null?2:shop.getUniacid());
		return shop;
	}
}
