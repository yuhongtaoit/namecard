package com.zhongwei.namecard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardFriendMapper;
import com.zhongwei.namecard.entity.CardFriendWithBLOBs;

@Service
public class FriendService {
	
	@Autowired
	private CardFriendMapper friendMapper;
	
	@Autowired
	private FileUploadService fileUploadService;

	private CardFriendWithBLOBs setDynamicDefaultValue(CardFriendWithBLOBs friend) {
		friend.setAllImg(friend.getAllImg()==null?"":friend.getAllImg());
		friend.setContent(friend.getContent()==null?"":friend.getContent());
		friend.setHeadImg(friend.getHeadImg()==null?"":friend.getHeadImg());
		friend.setCardId(friend.getCardId()==null?0:friend.getCardId());
		friend.setContentCard(friend.getContentCard()==null?"":friend.getContentCard());
		friend.setTime(friend.getTime()==null?0:friend.getTime());
		friend.setTitle(friend.getTitle()==null?"":friend.getTitle());
		friend.setUniacid(friend.getUniacid()==null?0:friend.getUniacid());
		return friend;
	}

	@Transactional
	public CommonMessage updateDynamic(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardFriendWithBLOBs friend, CardFriendWithBLOBs oldFriend) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setDynamicDefaultValue(friend);
			if(gimage==null && !StringUtils.isEmpty(friend.getHeadImg())) {
				friend.setHeadImg(oldFriend.getHeadImg());
			}else {
				this.fileUploadService.deleteFile(oldFriend.getHeadImg());
				friend.setHeadImg(this.fileUploadService.uploadForSingleFile(request, response, gimage));
			}
			this.friendMapper.updateByPrimaryKeyWithBLOBs(friend);
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
	public CommonMessage createDynamic(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardFriendWithBLOBs friend) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		String imagePath = fileUploadService.uploadForSingleFile(request, response, gimage);
		this.setDynamicDefaultValue(friend);
		friend.setHeadImg(imagePath);
		try {
			this.friendMapper.insert(friend);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(imagePath);
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}

}
