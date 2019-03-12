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

import com.zhongwei.namecard.miniapp.dao.CardBankMapper;
import com.zhongwei.namecard.miniapp.dao.CardMemberMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.CardBank;
import com.zhongwei.namecard.miniapp.model.CardBankExample;
import com.zhongwei.namecard.miniapp.model.CardMember;
import com.zhongwei.namecard.miniapp.model.CardMemberExample;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class WithdrawController {
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	@Autowired
	private CardBankMapper bankMapper;
	
	
	@RequestMapping("/withdrawBroker")
	public Map<String, Object> withdrawBroker(int uniacid, String sessionId, Integer card_id, HttpServletRequest request){
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
		data.putAll(cardMember.cardMemberToMap(cardMember));
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/withdrawBank")
	public Map<String, Object> withdrawBank(int uniacid, String sessionId, Integer card_id, HttpServletRequest request){
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
		
		List<CardBank> bankList = new ArrayList<CardBank>();
		CardBankExample bankExample = new CardBankExample();
		bankExample.createCriteria().andUniacidEqualTo(uniacid).andOpenIdEqualTo(openId);
		bankList = bankMapper.selectByExampleWithBLOBs(bankExample);
		CardBank bank = bankList.size() > 0 ? bankList.get(0) : new CardBank();
		
		data.put("name", bank.getName());
		data.put("phone", bank.getPhone());
		data.put("bankCard", bank.getBankCard());
		data.put("card_id", card_id);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/withdrawBankAdd")
	public Map<String, Object> withdrawBankAdd(int uniacid, String sessionId, String bankCard, String realname, 
			String phone, Integer card_id, HttpServletRequest request){
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
		
		CardBank band = new CardBank();
		band.setUniacid(uniacid);
		band.setOpenId(openId);
		band.setNickname(user.getNickname() == null ? "" : user.getNickname());
		band.setPhone(phone);
		band.setGender(user.getGender());
		band.setName(realname);
		band.setCity(user.getCity() == null ? "" : user.getCity());
		band.setProvince(user.getProvince() == null ? "" : user.getProvince());
		band.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
		band.setAvatarUrl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
		band.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
		band.setBankCard(bankCard);
		
		List<CardBank> list = new ArrayList<CardBank>();
		CardBankExample bankExample = new CardBankExample();
		bankExample.createCriteria().andUniacidEqualTo(uniacid).andOpenIdEqualTo(openId);
		list = bankMapper.selectByExampleWithBLOBs(bankExample);
		int upd = 0;
		if(list.size() > 0) {
			band.setId(list.get(0).getId());
			band.setAddtime(StringUtils.hasText(list.get(0).getAddtime()) ? list.get(0).getAddtime() : String.valueOf(System.currentTimeMillis()));
			band.setUpdatetime(String.valueOf(System.currentTimeMillis()));
			upd = bankMapper.updateByPrimaryKey(band);
		}else {
			band.setAddtime(String.valueOf(System.currentTimeMillis()));
			band.setUpdatetime("");
			upd = bankMapper.insert(band);
		}
		if(upd > 0) {
			data.put("error", 0);
		}else {
			data.put("error", 1);
		}
		result.put("data", data);
		return result;
	}

}
