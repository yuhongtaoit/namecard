package com.zhongwei.namecard.miniapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class HomeController {
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@RequestMapping("/home")
	public Map<String, Object> home(int uniacid, Integer card_id,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) {
			data.put("message", "缺少名片id");
			data.put("errno", 1);
			result.put("data", data);
			return result;
		}
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		
		List<CardMember> memberList = new ArrayList<CardMember>();
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
		memberList = cardMemberMapper.selectByExample(memberExample);
		CardMember cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
		data.putAll(user.userToMap(user));
		data.put("card_id", card_id);
		data.put("member_card", cardMember);
		result.put("data", data);
		return result;
	}

}
