package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.MemberMapper;
import com.zhongwei.namecard.dao.ShopsAddressMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.Member;
import com.zhongwei.namecard.entity.MemberExample;
import com.zhongwei.namecard.entity.ShopsAddress;
import com.zhongwei.namecard.entity.ShopsAddressExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Controller
@RequestMapping("/clientManage")
public class ClientManageController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private ShopsAddressMapper addressMapper;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "clientindex";
	}
	
	@RequestMapping("/getMemberList")
	public String getMemberList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		MemberExample memberExample = new MemberExample();
		memberExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<Member> memberList = this.memberMapper.selectByExample(memberExample);
		model.addAttribute("memberList", memberList);
		return "memberlist";
	}
	
	@RequestMapping(value="/deleteMember")
    @Transactional
    public @ResponseBody CommonMessage deleteMember(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			this.memberMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	@RequestMapping("/getCardMemberList")
	public String getCardMemberList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		CardMemberExample cardMemberExample = new CardMemberExample();
		cardMemberExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<CardMember> cardMemberList = this.cardMemberMapper.selectByExample(cardMemberExample);
		model.addAttribute("cardMemberList", cardMemberList);
		return "cardmemberlist";
	}
	
	@RequestMapping(value="/getCardMemberDetail")
    @Transactional
    public String getCardMemberDetail(Model model, Integer id, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		if(id!=null && id>0){
			CardMember cardMemberDetail = this.cardMemberMapper.selectByPrimaryKey(id);
			model.addAttribute("cardMemberDetail", cardMemberDetail);
			if(cardMemberDetail!=null && cardMemberDetail.getSourceId()!=null && cardMemberDetail.getSourceId()>0) {
				CardMemberExample cardMemberExample = new CardMemberExample();
				cardMemberExample.createCriteria().andIdEqualTo(cardMemberDetail.getSourceId()).andUniacidEqualTo(user.getUniacid());
				List<CardMember> sourceCardMemberList = this.cardMemberMapper.selectByExample(cardMemberExample);
				if(sourceCardMemberList!=null && sourceCardMemberList.size()>0) {
					model.addAttribute("sourceCardMember", sourceCardMemberList.get(0));
				}else {
					model.addAttribute("sourceCardMember", new CardMember());
				}
			}else {
				model.addAttribute("sourceCardMember", new CardMember());
			}
			CardExample cardExample = new CardExample();
			cardExample.createCriteria().andUniacidEqualTo(user.getUniacid()).andIdEqualTo(cardMemberDetail.getSourceId());
			List<CardWithBLOBs> cardList = this.cardMapper.selectByExampleWithBLOBs(cardExample);
			if(cardList!=null && cardList.size()>0) {
				model.addAttribute("card", cardList.get(0));
			}else {
				model.addAttribute("card", new Card());
			}
			ShopsAddressExample shopsAddressExample = new ShopsAddressExample();
			shopsAddressExample.createCriteria().andUniacidEqualTo(user.getUniacid()).andOpenidEqualTo(cardMemberDetail.getOpenid());
			List<ShopsAddress> shopsAddressList = this.addressMapper.selectByExample(shopsAddressExample);
			if(shopsAddressList!=null && shopsAddressList.size()>0) {
				model.addAttribute("shopsAddressList", shopsAddressList);
			}else {
				model.addAttribute("shopsAddressList", new ArrayList<ShopsAddress>());
			}
		}
		return "cardmemberdetail";
    }
}