package com.zhongwei.namecard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.entity.ShopsCategory;

@Service
public class ShopCategoryService {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private ShopsCategoryMapper shopsCategoryMapper;
	
	@Transactional
	public CommonMessage updateShop(MultipartFile thumbimage, 
			HttpServletRequest request, HttpServletResponse response, ShopsCategory category,
			ShopsCategory oldCategory) {
		CommonMessage message = new CommonMessage();
		try {
			this.setCategoryDefaultValue(category);
			if(thumbimage==null && !StringUtils.isEmpty(category.getThumb())) {
				category.setThumb(oldCategory.getThumb());
			}else {
				this.fileUploadService.deleteFile(oldCategory.getThumb());
				category.setThumb(this.fileUploadService.uploadForSingleFile(request, response, thumbimage));
			}
			this.shopsCategoryMapper.updateByPrimaryKey(category);
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
	public CommonMessage createShop(MultipartFile thumbimage, 
			HttpServletRequest request, HttpServletResponse response, ShopsCategory category) {
		CommonMessage message = new CommonMessage();
		String thumbimagePath = fileUploadService.uploadForSingleFile(request, response, thumbimage);
		this.setCategoryDefaultValue(category);
		category.setThumb(thumbimagePath);
		try {
			this.shopsCategoryMapper.insert(category);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(thumbimagePath);
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private ShopsCategory setCategoryDefaultValue(ShopsCategory category) {
		category.setEnabled(category.getEnabled()==null?false:category.getEnabled());
		category.setNum(category.getNum()==null?0:category.getNum());
		category.setParentid(category.getParentid()==null?0:category.getParentid());
		category.setSort(category.getSort()==null?0:category.getSort());
		category.setThumb(category.getThumb()==null?"":category.getThumb());
		category.setTitle(category.getTitle()==null?"":category.getTitle());
		category.setUniacid(category.getUniacid()==null?2:category.getUniacid());
		return category;
	}
}
