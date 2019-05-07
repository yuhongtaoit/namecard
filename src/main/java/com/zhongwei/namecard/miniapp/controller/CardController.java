package com.zhongwei.namecard.miniapp.controller;

import java.math.BigDecimal;
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
import com.zhongwei.namecard.dao.CardFormMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardChat;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardForm;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.SendCashUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class CardController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@Autowired
	private CardSetMapper cardSetMapper;
	
	@Autowired
	private CardFormMapper cardFormMapper;
	
	@Autowired
	private CardChatMapper cardChatMapper;
	
//	@Autowired
//	private UserUtils userUtils;
	
	
//	private int uniacid = 2;
	
	@RequestMapping("/cardList")
	public Map<String, Object> getCardList(Integer send_card,String sessionId, int uniacid,  HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		List<CardWithBLOBs> info = new ArrayList<CardWithBLOBs>();
		int isAuthorize = 0;
		String message = "返回消息";
		int  errno = 0;
		
		if(send_card == null)
			send_card = 0;
		
		AuthUser authUser = UserUtils.getUserInfo(request, sessionId);
		
		if(StringUtils.hasText(authUser.getOpenid())) {
			
			CardMemberExample cardMemberExample = new CardMemberExample();
			cardMemberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(authUser.getOpenid());
			List<CardMember> cardMamberList = cardMemberMapper.selectByExample(cardMemberExample);
			if(cardMamberList.size() > 0) {
				for(CardMember cardMember : cardMamberList) {
					CardExample example = new CardExample();
					example.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(cardMember.getAid()).andIsSendcardEqualTo(0);
					List<CardWithBLOBs> cardMo = cardMapper.selectByExampleWithBLOBs(example);
					if(cardMo.size() >0) {
						arr.add(cardMember.getAid());
						arr1.add(cardMember.getAid());
					}
				}
			}
		}
		
		
		
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andMrtypeEqualTo(1).andIsSendcardEqualTo(0);
		List<CardWithBLOBs> card_mr = cardMapper.selectByExampleWithBLOBs(cardExample);
		
		if(card_mr != null && card_mr.size() > 0) {
			for(CardWithBLOBs card : card_mr) {
				arr.add(card.getId());
				arr2.add(card.getId());
			}
		}
		if(arr.size() > 0) {
			CardExample cardExample1 = new CardExample();
			cardExample1.createCriteria().andIdIn(arr);
			cardExample1.setOrderByClause("sort DESC");
			info = cardMapper.selectByExampleWithBLOBs(cardExample1);
		}
		CardWithBLOBs findSendCard = new CardWithBLOBs();
		if(send_card > 0) {
			CardExample cardExample2 = new CardExample();
			cardExample2.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(send_card).andIsSendcardEqualTo(1);
			List<CardWithBLOBs> findSend = cardMapper.selectByExampleWithBLOBs(cardExample2);
			if(findSend.size() > 0) {
				findSendCard = findSend.get(0);
				cardExample2 = new CardExample();
				cardExample2.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(findSendCard.getIsSendcardId()).andIsSendcardEqualTo(0);
				List<CardWithBLOBs> findTarg = cardMapper.selectByExampleWithBLOBs(cardExample2);
				int isSend = 0;
				if(findTarg != null) {
					isSend = (arr.contains(findTarg.get(0).getId())) ? 1 : 0;
					findTarg.get(0).setStatus(1);
				}
				if(isSend != 0) {
					info.add(findTarg.get(0));
				}
			}
		}
		
		CardSetExample cardSetExample = new CardSetExample();
		cardSetExample.createCriteria().andUniacidEqualTo(uniacid);
		List<CardSet> cardSetList = cardSetMapper.selectByExample(cardSetExample);
		CardSet cardSet = new CardSet();
		if(cardSetList != null && cardSetList.size() > 0) {
			cardSet = cardSetList.get(0);
		}
		
		if(!StringUtils.hasText(authUser.getOpenid()) || !StringUtils.hasText(authUser.getNickname())) {
			isAuthorize = 0;
		}else {
			isAuthorize = 1;
		}
		
		if(info != null && info.size() >0) {
			for(CardWithBLOBs card : info) {
				card.setCardLogo(ImageUrlUtils.getAbsolutelyURL(card.getCardLogo()));
				int op = 0;
				op = arr1.contains(card.getId()) ? 1 : 0;
				if(card.getStatus() ==1) {
					card.setSourceName("来自" + findSendCard.getCardName() + "的交接");
				}else {
					if(op ==1) {
						List<CardMember> memberInfo = new ArrayList<CardMember>();
						List<CardMember> memberShare = new ArrayList<CardMember>();
						List<CardWithBLOBs> memberSorce = new ArrayList<CardWithBLOBs>();
						
						CardMemberExample cardMemberExample = new CardMemberExample();
						cardMemberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card.getId()).andOpenidEqualTo(authUser.getOpenid());
						memberInfo = cardMemberMapper.selectByExample(cardMemberExample);
						if(memberInfo.size() > 0) {
							cardMemberExample = new CardMemberExample();
							cardMemberExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(memberInfo.get(0).getSourceId());
							memberShare = cardMemberMapper.selectByExample(cardMemberExample);
						}
						if(memberShare.size() > 0) {
							card.setSourceName(StringUtils.hasText(memberShare.get(0).getName())?memberShare.get(0).getName() : memberShare.get(0).getNickname());
						}else {
							if(memberInfo.size() >0 && memberInfo.get(0).getSendCardid() > 0) {
								cardExample = new CardExample();
								cardExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(memberInfo.get(0).getSendCardid());
								memberSorce = cardMapper.selectByExampleWithBLOBs(cardExample);
								if(memberSorce.size() > 0) {
									card.setSourceName("来自" + memberSorce.get(0).getCardName() + "的交接");
								}else {
									card.setSourceName("搜索或扫描");
								}
							}else {
								card.setSourceName("搜索或扫描");
							}
						}
					}else {
						card.setSourceName("搜索或扫描");
					}
				}
			}
			Map<String, Object> data = new HashMap<>();
			data.put("message", message);
			data.put("errno", errno);
			data.put("isAuthorize", isAuthorize);
			data.put("company_logo", ImageUrlUtils.getAbsolutelyURL(cardSet.getCompanyLogo()));
			data.put("company_name", cardSet.getCompanyName());
			data.put("info", info);
			result.put("data", data);
			return result;
		}else {
			Map<String, Object> data = new HashMap<>();
			data.put("message", message);
			data.put("errno", errno);
			data.put("isAuthorize", isAuthorize);
			data.put("info", info);
			result.put("data", data);
			return result;
		}
		
	}
	
	@RequestMapping("/saveForm")
	public void saveForm(String formId,String sessionId, int uniacid, HttpServletRequest request){
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		if(StringUtils.hasText(user.getOpenid())) {
			CardForm cardForm = new CardForm();
			cardForm.setUniacid(uniacid);
			cardForm.setOpenid(user.getOpenid());
			cardForm.setFormid(formId);
			cardForm.setNickname(user.getNickname() == null ? "" : user.getNickname());
			cardForm.setGender(user.getGender());
			cardForm.setCity(user.getCity() == null ? "" : user.getCity());
			cardForm.setProvince(user.getProvince() == null ? "" : user.getProvince());
			cardForm.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
			cardForm.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
			cardForm.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
			cardForm.setStatus(0);
			cardForm.setAddtime(String.valueOf(System.currentTimeMillis()));
			cardForm.setUpdatetime(String.valueOf(System.currentTimeMillis()));
			cardFormMapper.insert(cardForm);
		}
		
	}
	
	@RequestMapping("/addcardId")
	public Map<String, Object> addcardId(int uniacid, Integer card_id, Integer share_id, Integer send_cardid,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		if(card_id == null) 
			card_id = 0;
		if(share_id == null) 
			share_id = 0;
		if(send_cardid == null) 
			send_cardid = 0;
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		
		CardWithBLOBs info = cardMapper.selectByPrimaryKey(card_id);
		if(StringUtils.hasText(openId) && card_id > 0) {
			List<CardMember> memberList = new ArrayList<CardMember>();
			CardMemberExample cardMemberExample = new CardMemberExample();
			cardMemberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andAidEqualTo(card_id);
			memberList = cardMemberMapper.selectByExample(cardMemberExample);
			if(memberList.size() == 0) {
				CardMember memUser = new CardMember();
				memUser.setUniacid(uniacid);
				memUser.setOpenid(openId);
				memUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
				memUser.setAid(card_id);
				memUser.setPhone("");// 
				memUser.setGender(user.getGender());
				memUser.setName("");
				memUser.setCity(user.getCity() == null ? "" : user.getCity());
				memUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
				memUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
				memUser.setAvatarUrl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
				memUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
				memUser.setAddtime(String.valueOf(System.currentTimeMillis()));
				memUser.setUpdatetime("");
				memUser.setSourceId(share_id);
				memUser.setSendCardid(send_cardid);
				memUser.setCanTake(new BigDecimal("0.00"));
				memUser.setTotalBroker(new BigDecimal("0.00"));
				memUser.setHasTaken(new BigDecimal("0.00"));
				memUser.setInTaking(new BigDecimal("0.00"));
				memUser.setNotInAccount(new BigDecimal("0.00"));
				int res_one = cardMemberMapper.insert(memUser);
				if(res_one > 0) {
					if(share_id > 0) {
						CardMember cardMember2 = new CardMember();
						List<CardMember> memberList2 = new ArrayList<CardMember>();
						CardMemberExample memberExample2 = new CardMemberExample();
						memberExample2.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
						memberList2 = cardMemberMapper.selectByExample(memberExample2);
						if(memberList2.size() > 0) {
							SendCashUtils.sendCash(memberList2.get(0));
						}
					}
					if(StringUtils.hasText(info.getZdMsg())) {
						CardChat chatUser = new CardChat();
						chatUser.setUniacid(uniacid);
						chatUser.setOpenid(openId);
						chatUser.setCardId(card_id);
						chatUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
						chatUser.setPhone("");
						chatUser.setGender(user.getGender());
						chatUser.setName("");
						chatUser.setCity(user.getCity() == null ? "" : user.getCity());
						chatUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
						chatUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
						chatUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
						chatUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
						chatUser.setAddtime(String.valueOf(System.currentTimeMillis()));
						chatUser.setUpdatetime("");
						chatUser.setMsg(info.getZdMsg());
						chatUser.setFormid("");
						chatUser.setType(0);
						chatUser.setIsSend(1);
						chatUser.setStype(1);
						cardChatMapper.insert(chatUser);
						
					}
				}
			}
		}
		List<CardMember> memberList = new ArrayList<CardMember>();
		CardMemberExample cardMemberExample = new CardMemberExample();
		cardMemberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andAidEqualTo(card_id);
		memberList = cardMemberMapper.selectByExample(cardMemberExample);
		CardMember cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
		data.put("id", cardMember.getId());
		result.put("data", data);
		return result;
	}
	
}
