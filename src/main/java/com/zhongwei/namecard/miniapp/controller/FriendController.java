package com.zhongwei.namecard.miniapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.CardFriendMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.CardFriendWithBLOBs;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.utils.DateUtils;
import com.zhongwei.namecard.utils.ImageUrlUtils;

@RestController
@RequestMapping("/miniapp")

public class FriendController {
	
	@Autowired
	private CardFriendMapper cardFriendMapper;
	
	@Autowired
	private CardMapper cardMapper;
	
	@RequestMapping("/friendDetail")
	public Map<String, Object> friendDetail(int uniacid, Integer friend_id, Integer card_id,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		if(friend_id == null) 
			friend_id = 0;
		
		CardFriendWithBLOBs info = cardFriendMapper.selectByPrimaryKey(friend_id);
		info.setHeadImg(ImageUrlUtils.getAbsolutelyURL(info.getHeadImg()));
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		card.setCardLogo(ImageUrlUtils.getAbsolutelyURL(card.getCardLogo()));
		
		data.putAll(info.friendToMap(info));
		data.put("card", card);
		data.put("card_id", card_id);
		data.put("time", DateUtils.millisToString(info.getTime()));
		info.setAllImgarr(info.getAllImg().split(","));
//		if (!empty($info["all_img"])) {   ******
//			$info["all_imgarr"] = explode(",", $info["all_img"]);
//		}
		result.put("data", data);
		return result;
	}

}
