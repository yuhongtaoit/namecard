package com.zhongwei.namecard.qyWX.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.dao.ActReportMapper;
import com.zhongwei.namecard.dao.CardChatMapper;
import com.zhongwei.namecard.dao.CardFormMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AccountWxappExample;
import com.zhongwei.namecard.entity.ActReport;
import com.zhongwei.namecard.entity.ActReportExample;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardChat;
import com.zhongwei.namecard.entity.CardChatExample;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardForm;
import com.zhongwei.namecard.entity.CardFormExample;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.HttpClientUtils;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.QyUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/staffer")
public class StafferController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private ActReportMapper actReportMapper;
	
	@Autowired
	private CardMemberMapper memberMapper;
	
	@Autowired
	private CardChatMapper chatMapper;
	
	@Autowired
	private CardSetMapper setMapper;
	
	@Autowired
	private AccountWxappMapper accountWxappMapper;
	
	@Autowired
	private CardFormMapper formMapper;
	
	@RequestMapping("/stafferIndex")
	public String stafferIndex(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
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
		model.addAttribute("uniacid", uniacid);
		return "qyWX/stafferIndex";
	}
	
	
	@RequestMapping("/getAiMsg")
	public @ResponseBody Map<String, Object> getAiMsg(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("error", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		String msg = "返回消息";
		int error = 0;
		result.put("msg", msg);
		result.put("error", error);
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
		if(page < 1) {
			page = 1;
		}
		int psize = 20;
		Page pages = PageHelper.startPage(page, psize);
		ActReportExample actReportExample = new ActReportExample();
		actReportExample.createCriteria().andUniacidEqualTo(uniacid).andCardIdEqualTo(cardInfo.getId());
		actReportExample.setOrderByClause(" addtime DESC");
		List<ActReport> reportList = actReportMapper.selectByExample(actReportExample);
		if(pages.getPageNum() < page) {
			reportList = null;
		}
		result.put("Data", reportList);
		return result;
	}
	
	@RequestMapping("/memberDetail")
	public String memberDetail(HttpServletRequest request, HttpServletResponse response,Integer member_id, Integer card_id, Integer type, Model model) throws IOException {
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
		if(member_id == null) {
			model.addAttribute("message", "信息拉取失败-1");
			logger.info("信息拉取失败-1");
			return "qyWX/error";
		}
		if(card_id == null) {
			model.addAttribute("message", "信息拉取失败-2");
			logger.info("信息拉取失败-2");
			return "qyWX/error";
		}
		CardMember memberInfo = new CardMember();
		ActReport info = new ActReport();
		if(type != null) {
			memberInfo = memberMapper.selectByPrimaryKey(member_id);
		}else {
			info = actReportMapper.selectByPrimaryKey(member_id);
			if(info == null) {
				model.addAttribute("message", "信息拉取失败-3");
				logger.info("信息拉取失败-3");
				return "qyWX/error";
			}
			CardMemberExample memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(info.getOpenid()).andAidEqualTo(card_id);
			List<CardMember> memberList = memberMapper.selectByExample(memberExample);
			if(memberList.size() == 0) {
				model.addAttribute("message", "信息拉取失败-4");
				logger.info("信息拉取失败-4");
				return "qyWX/error";
			}
			memberInfo = memberList.get(0);
		}
		model.addAttribute("member_info", memberInfo);
		model.addAttribute("info", info);
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		model.addAttribute("member_id", member_id);
		model.addAttribute("type", type);
		model.addAttribute("card_id", card_id);
		return "qyWX/memberDetail";
	}
	@RequestMapping("/chat")
	public String chat(HttpServletRequest request, HttpServletResponse response,String openid, Integer card_id, Model model) throws IOException {
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			model.addAttribute("message", "请先登录企业微信");
			return "qyWX/error";
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		List<CardMember> chatList = new ArrayList<CardMember>();
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openid).andAidEqualTo(card_id);
		chatList = memberMapper.selectByExample(memberExample);
		CardMember chatInfo = chatList.size() > 0 ? chatList.get(0) : new CardMember();
		CardChatExample chatExample = new CardChatExample();
		chatExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openid).andStypeEqualTo(1).andCardIdEqualTo(card_id).andAddtimeGreaterThanOrEqualTo(String.valueOf((System.currentTimeMillis()-(24 * 3600 * 1000))));
		List<CardChat> msg = chatMapper.selectByExample(chatExample);
		card.setCardLogo(ImageUrlUtils.getAbsolutelyURL(card.getCardLogo()));
		model.addAttribute("card", card);
		model.addAttribute("chat_info", chatInfo);
		model.addAttribute("msg", msg);
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		model.addAttribute("openid", openid);
		model.addAttribute("card_id", card_id);
		return "qyWX/chat";
	}
	
	@RequestMapping("/dosend")
	public @ResponseBody Map<String, Object> dosend(HttpServletRequest request, HttpServletResponse response,String openid, Integer card_id, String msg, Model model) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("mess", "请先登录企业微信");
			result.put("error", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int error = 0;
		result.put("msg", msg);
		result.put("error", error);
		if(!StringUtils.hasText(msg)) {
			logger.info("请输入内容");
			result.put("mess", "请输入内容");
			result.put("error", 1);
			return result;
		}
		if(!StringUtils.hasText(openid)) {
			logger.info("参数错误");
			result.put("mess", "参数错误");
			result.put("error", 1);
			return result;
		}
		if(card_id == null) {
			logger.info("参数错误");
			result.put("mess", "参数错误");
			result.put("error", 1);
			return result;
		}
		CardChat chatUser = new CardChat();
		chatUser.setUniacid(uniacid);
		chatUser.setOpenid(openid);
		chatUser.setCardId(card_id);
		chatUser.setNickname("");
		chatUser.setPhone("");
		chatUser.setGender(0);
		chatUser.setName("");
		chatUser.setCity("");
		chatUser.setProvince("");
		chatUser.setLanguage("");
		chatUser.setAvatarurl("");
		chatUser.setAvatar("");
		chatUser.setAddtime(String.valueOf(System.currentTimeMillis()));
		chatUser.setUpdatetime("");
		chatUser.setMsg(msg);
		chatUser.setFormid("");
		chatUser.setType(0);
		chatUser.setIsSend(1);
		chatUser.setStype(1);
		chatUser.setFid(0);
		chatUser.setStatus(0);
		int insert = chatMapper.insert(chatUser);
		if(insert > 0) {
			sendPost(openid, card_id, msg, uniacid);
			result.put("mess", "发送成功");
			result.put("error", 0);
			return result;
		}else {
			result.put("mess", "发送失败");
			result.put("error", 1);
			return result;
		}
	}
	@RequestMapping("/getsend")
	public @ResponseBody Map<String, Object> getsend(HttpServletRequest request, HttpServletResponse response,String openid, Integer card_id, Model model) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("mess", "请先登录企业微信");
			result.put("error", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		CardChatExample chatExample = new CardChatExample();
		chatExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openid).andStypeEqualTo(0).andCardIdEqualTo(card_id);
		chatExample.setOrderByClause(" addtime asc");
		List<CardChat> chatList = chatMapper.selectByExample(chatExample);
		CardChat info = chatList.size() > 0 ? chatList.get(0) : new CardChat();
		if(chatList.size() > 0) {
			info.setStype(1);
			chatMapper.updateByPrimaryKey(info);
			result.put("mess", info.getMsg());
			result.put("success", 1);
		}else {
			result.put("mess", "无");
			result.put("success", 0);
		}
		return result;
	}
	
	private JSONObject sendPost(String openid, int card_id, String content, int uniacid) {
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		CardSetExample setExample = new CardSetExample();
		setExample.createCriteria().andUniacidEqualTo(uniacid);
		List<CardSet> setList = setMapper.selectByExample(setExample);
		CardSet cardset = setList.size() > 0 ? setList.get(0) : new  CardSet();
		CardChatExample chatExample = new CardChatExample();
		chatExample.createCriteria().andUniacidEqualTo(uniacid).andIsSendEqualTo(0).andOpenidEqualTo(openid).andCardIdEqualTo(card_id).andSendFromidEqualTo(0).andAddtimeGreaterThanOrEqualTo(String.valueOf((System.currentTimeMillis()-(6 * 24 * 3600 * 1000))));
		chatExample.setOrderByClause(" addtime desc");
		List<CardChat> chatList = chatMapper.selectByExample(chatExample);
		CardChat chat_info = chatList.size() > 0 ? chatList.get(0) : new CardChat();
		AccountWxappExample wxappExample = new AccountWxappExample();
		wxappExample.createCriteria().andUniacidEqualTo(uniacid);
		List<AccountWxapp> wxappList = accountWxappMapper.selectByExample(wxappExample);
		AccountWxapp accountWxapp = wxappList.size() > 0 ? wxappList.get(0) : new AccountWxapp();
		//接口调用凭证
		String token = QySendUtils.getAccountToken(accountWxapp.getKey(), accountWxapp.getSecret(), uniacid);
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + token;
		JSONObject result = null;
		if(chatList.size() > 0 && StringUtils.hasText(chat_info.getFormid())) {
			JSONObject jsonParam = new JSONObject();
			JSONObject data = new JSONObject();
			JSONObject keyword1 = new JSONObject();
			JSONObject keyword2 = new JSONObject();
			JSONObject keyword3 = new JSONObject();
			jsonParam.put("touser", openid);	//接收者（用户）的 openid
			jsonParam.put("template_id", cardset.getTemplateId());	//所需下发的模板消息的id  ********
			jsonParam.put("form_id", chat_info.getFormid());	//表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
			jsonParam.put("page", "dbs_masclwlcard/pages/tab/tab?card_id=" + card_id);	//点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
			keyword1.put("value", content);
			keyword2.put("value", card.getCardName());
			keyword3.put("value", card.getCardTel());
			data.put("keyword1", keyword1);
			data.put("keyword2", keyword2);
			data.put("keyword3", keyword3);
			jsonParam.put("data", data);	//模板内容，不填则下发空模板。具体格式请参考示例。
			
			result = HttpClientUtils.postJson(url, jsonParam.toString());
			chat_info.setSendFromid(1);
			chat_info.setAvatar(chat_info.getFormid() + result.getString("errcode"));
			chatMapper.updateByPrimaryKey(chat_info);
		}else {
			CardFormExample formExample = new CardFormExample();
			formExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openid).andAddtimeGreaterThanOrEqualTo(String.valueOf((System.currentTimeMillis()-(6 * 24 * 3600 * 1000))));
			formExample.setOrderByClause(" addtime desc");
			List<CardForm> fromList = formMapper.selectByExample(formExample);
			CardForm all_formid = fromList.size() > 0 ? fromList.get(0) : new CardForm();
			JSONObject jsonParam = new JSONObject();
			JSONObject data = new JSONObject();
			JSONObject keyword1 = new JSONObject();
			JSONObject keyword2 = new JSONObject();
			JSONObject keyword3 = new JSONObject();
			jsonParam.put("touser", openid);	//接收者（用户）的 openid
			jsonParam.put("template_id", cardset.getTemplateId());	//所需下发的模板消息的id
			jsonParam.put("form_id", all_formid.getFormid());	//表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
			jsonParam.put("page", "dbs_masclwlcard/pages/tab/tab?card_id=" + card_id);	//点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
			keyword1.put("value", content);
			keyword2.put("value", card.getCardName());
			keyword3.put("value", card.getCardTel());
			data.put("keyword1", keyword1);
			data.put("keyword2", keyword2);
			data.put("keyword3", keyword3);
			jsonParam.put("data", data);	//模板内容，不填则下发空模板。具体格式请参考示例。
			
			result = HttpClientUtils.postJson(url, jsonParam.toString());
			formMapper.deleteByPrimaryKey(all_formid.getId());
		}
		return result;
		
	}

}
