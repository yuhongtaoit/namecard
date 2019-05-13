package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.MemberMapper;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.Member;
import com.zhongwei.namecard.entity.MemberExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Controller
@RequestMapping("/clientManage")
public class ClientManageController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
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
    public String getCardMemberDetail(Model model, Integer id) {
		if(id!=null && id>0){
			CardMember cardMemberDetail = this.cardMemberMapper.selectByPrimaryKey(id);
			model.addAttribute("cardMemberDetail", cardMemberDetail);
		}
		return "cardmemberdetail";
    }
}