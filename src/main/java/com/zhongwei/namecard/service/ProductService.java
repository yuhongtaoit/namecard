package com.zhongwei.namecard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardProductMapper;
import com.zhongwei.namecard.entity.CardProductWithBLOBs;

@Service
public class ProductService {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private CardProductMapper productMapper;
	
	@Transactional
	public CommonMessage updateProduct(MultipartFile[] cpBsImg, MultipartFile[] cpBsContent,
			HttpServletRequest request, HttpServletResponse response, CardProductWithBLOBs product,
			CardProductWithBLOBs oldProduct) {
		CommonMessage message = new CommonMessage();
		try {
			this.setProductDefaultValue(product);
			List<String> cpBsImgList = Arrays.asList(this.toArray(product.getCpBsImg()));
			List<String> oldCpBsImgList = Arrays.asList(this.toArray(oldProduct.getCpBsImg()));
			if(cpBsImg==null || cpBsImg.length<=0) {
				this.removeNotExistFile(cpBsImgList, oldCpBsImgList);
			}else {
				List<String> newCpBsPaths = new ArrayList<String>();
				this.removeNotExistFile(cpBsImgList, oldCpBsImgList);
				List<String> newCpBsImagePaths = this.fileUploadService.uploadForMultiFile(request, response, cpBsImg);
				for(String cpBs : cpBsImgList) {
					newCpBsPaths.add(cpBs);
				}
				newCpBsPaths.addAll(newCpBsImagePaths);
				product.setCpBsImg(newCpBsPaths.toString());
			}
			List<String> cpBsContentList = Arrays.asList(this.toArray(product.getCpBsContent()));
			List<String> oldCpBsContentList = Arrays.asList(this.toArray(oldProduct.getCpBsContent()));
			if(cpBsContent==null || cpBsContent.length<=0) {
				this.removeNotExistFile(cpBsContentList, oldCpBsContentList);
			}else {
				List<String> newCpBsContentPaths = new ArrayList<String>();
				this.removeNotExistFile(cpBsContentList, oldCpBsContentList);
				List<String> newCpBsContentImagePaths = this.fileUploadService.uploadForMultiFile(request, response, cpBsContent);
				for(String cpBs : cpBsContentList) {
					newCpBsContentPaths.add(cpBs);
				}
				newCpBsContentPaths.addAll(newCpBsContentImagePaths);
				product.setCpBsContent(newCpBsContentPaths.toString());
			}
			this.productMapper.updateByPrimaryKeyWithBLOBs(product);
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
	public CommonMessage createProduct(MultipartFile[] cpBsImg, MultipartFile[] cpBsContent,
			HttpServletRequest request, HttpServletResponse response, CardProductWithBLOBs product) {
		CommonMessage message = new CommonMessage();
		List<String> cpBsImgPaths = fileUploadService.uploadForMultiFile(request, response, cpBsImg);
		List<String> cpBsContentPaths = fileUploadService.uploadForMultiFile(request, response, cpBsContent);
		this.setProductDefaultValue(product);
		product.setCpBsImg(cpBsImgPaths.toString());
		product.setCpBsContent(cpBsContentPaths.toString());
		try {
			productMapper.insert(product);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			for(String path : cpBsImgPaths) {
				fileUploadService.deleteFile(path);
			}
			for(String path : cpBsContentPaths) {
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
	
	private CardProductWithBLOBs setProductDefaultValue(CardProductWithBLOBs product) {
		product.setCpBsContent(product.getCpBsContent()==null?"":product.getCpBsContent());
		product.setCpBsImg(product.getCpBsImg()==null?"":product.getCpBsImg());
		product.setCpBsName(product.getCpBsName()==null?"":product.getCpBsName());
		product.setCpBsPrice(product.getCpBsPrice()==null?"0.0":product.getCpBsPrice());
		product.setSort(product.getSort()==null?0:product.getSort());
		product.setUniacid(product.getUniacid()==null?2:product.getUniacid());
		return product;
	}
}
