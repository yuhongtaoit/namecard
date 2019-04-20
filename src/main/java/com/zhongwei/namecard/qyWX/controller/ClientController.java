package com.zhongwei.namecard.qyWX.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.dao.CardCloserMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardCloser;
import com.zhongwei.namecard.entity.CardCloserExample;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.QyUtils;


@Controller
@RequestMapping("/client")
public class ClientController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardMemberMapper memberMapper;
	
	@Autowired
	private CardCloserMapper closerMapper;
	
	@RequestMapping("/client")
	public String stafferIndex(HttpServletRequest request, HttpServletResponse response,Integer type, Model model) throws IOException {
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			model.addAttribute("message", "请先登录企业微信");
			return "qyWX/error";
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		if(status == -1) {
			model.addAttribute("message", "请在企业微信打开");
			logger.info("请在企业微信打开");
			return "qyWX/error";
		}
		if(status == -2) {
			model.addAttribute("message", "没有绑定对应的名片");
			logger.info("没有绑定对应的名片");
			return "qyWX/error";
		}
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("type", type != null ? type : 0);
		model.addAttribute("uniacid", uniacid);
		return "qyWX/clientIndex";
	}
	
	
	@RequestMapping("/clientGetlist")
	public @ResponseBody Map<String, Object> clientGetlist(HttpServletRequest request, HttpServletResponse response,
			Integer type, Integer card_id) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int error = 0;
		result.put("msg", msg);
		result.put("error", error);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("error", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int page = Integer.valueOf(request.getParameter("page"));
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("请在企业微信打开");
			result.put("msg", "请在企业微信打开");
			result.put("error", 1);
			return result;
		}
		if(status == -2) {
			logger.info("没有绑定对应的名片");
			result.put("msg", "没有绑定对应的名片");
			result.put("error", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			result.put("msg", "没有绑定对应的名片");
			result.put("error", 1);
			return result;
		}
		if(page < 1) {
			page = 1;
		}
		int psize = 20;
		Page pages = PageHelper.startPage(page, psize);
		CardMemberExample memberExample = new CardMemberExample();
		if(type == 1) {
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(cardInfo.getId());
			memberExample.setOrderByClause(" addtime DESC");
		}else {
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(cardInfo.getId());
			memberExample.setOrderByClause(" gailv DESC");
		}
		List<CardMember> Data = memberMapper.selectByExample(memberExample); 
		for(CardMember member : Data) {
			member.setNow_status("-1");
			if(Long.valueOf(member.getAddtime()) < System.currentTimeMillis() - 24 * 3600 * 1000) {
				CardCloserExample closerExample = new CardCloserExample();
				closerExample.createCriteria().andUniacidEqualTo(uniacid).andCardMidEqualTo(member.getId()).andCardIdEqualTo(cardInfo.getId());
				closerExample.setOrderByClause(" addtime desc");
				List<CardCloser> closerList = closerMapper.selectByExample(closerExample);
				if(closerList.size() > 0) {
					if(Long.valueOf(closerList.get(0).getAddtime()) >= System.currentTimeMillis() - 24 * 3600 * 1000) {
						member.setNow_status("0");
					}else {
						member.setNow_status("1");
					}
				}else {
					member.setNow_status("-1");
				}
			}else {
				member.setNow_status("-2");
			}
			memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(member.getOpenid());
			List<CardMember> members = memberMapper.selectByExample(memberExample);
			member.setPhone(members.size() > 0 && StringUtils.hasText(members.get(0).getPhone()) ? members.get(0).getPhone() : "暂无");
			if(member.getSourceId() != null && StringUtils.hasText(member.getSourceId().toString())) {
				CardMember source = memberMapper.selectByPrimaryKey(member.getSourceId());
				if(source == null) {
					member.setSource_name("暂无");
				}else {
					member.setSource_name(StringUtils.hasText(source.getName()) ? source.getName() : (StringUtils.hasText(source.getNickname()) ? source.getNickname() : "匿名"));
				}
			}else {
				if(member.getSendCardid() != null) {
					member.setSource_name("来自交接");
				}else {
					member.setSource_name("暂无");
				}
				
			}
			
		}
		
		if(pages.getPageNum() < page) {
			Data = null;
		}
		result.put("Data", Data);
		result.put("ss", card_id);
		return result;
	}
	
}
