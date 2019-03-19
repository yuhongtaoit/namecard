package com.zhongwei.namecard.miniapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.CardChatMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardChat;
import com.zhongwei.namecard.entity.CardChatExample;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class ChatController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardChatMapper cardChatMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@RequestMapping("/chatDetail")
	public Map<String, Object> chatDetail(int uniacid, String sessionId, Integer card_id, Integer fromid,
			HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		if(fromid == null) 
			fromid = 0;
		
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		AuthUser user  = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(!StringUtils.hasText(openId)) {
			result.put("data", data);
			return result;
		}
		List<CardMember> memberList = new ArrayList<CardMember>();
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andAidEqualTo(card_id);
		memberList = cardMemberMapper.selectByExample(memberExample);
		CardMember cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
		List<CardChat> chatList = new ArrayList<CardChat>();
		CardChatExample chatExample = new CardChatExample();
		chatExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andTypeEqualTo(0).andCardIdEqualTo(card_id);
		chatExample.setOrderByClause("addtime asc");
		chatList = cardChatMapper.selectByExample(chatExample);
		CardChat info = new CardChat();
		if(chatList.size() > 0) {
			info = chatList.get(0);
			info.setType(1);
			cardChatMapper.updateByPrimaryKey(info);
			if(cardMember.getPbStatus() == 0) {
				QySendUtils.qySend(card.getUserid(), "对方已经查看了:" + info.getMsg());
			}
		}
		
		card.setAvatarUrl(user.getAvatarurl());
		data.put("card_info", info);
		data.putAll(info.cardChatToMap(info));
		result.put("data", data);
		return result;
	}
	@RequestMapping("/chatDetailH")
	public Map<String, Object> chatDetailH(int uniacid, String sessionId, Integer card_id,
			HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		AuthUser user  = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(!StringUtils.hasText(openId)) {
			result.put("data", data);
			return result;
		}
		List<CardChat> msg = new ArrayList<CardChat>();
		CardChatExample chatExample = new CardChatExample();
		chatExample.createCriteria().andUniacidEqualTo(uniacid).
		andOpenidEqualTo(openId).andTypeEqualTo(1).andCardIdEqualTo(card_id)
		.andAddtimeGreaterThanOrEqualTo(String.valueOf(System.currentTimeMillis()-(24 * 3600 * 100)));
		msg = cardChatMapper.selectByExample(chatExample);
		
		card.setCardLogo(ImageUrlUtils.getAbsolutelyURL(card.getCardLogo()));
		card.setAvatarUrl(user.getAvatarurl());
		data.put("card", card);
		data.put("msg", msg);
		result.put("data", data);
		return result;
	}

}
