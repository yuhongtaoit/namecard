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
import com.zhongwei.namecard.dao.ActReportMapper;
import com.zhongwei.namecard.dao.CardCloserMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.ActReport;
import com.zhongwei.namecard.entity.ActReportExample;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardCloser;
import com.zhongwei.namecard.entity.CardCloserExample;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.DateUtils;
import com.zhongwei.namecard.utils.QyUtils;


@Controller
@RequestMapping("/staffer/member")
public class StafferMemberController {
	
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
	private CardSetMapper setMapper;
	
	@Autowired
	private CardCloserMapper closerMapper;
	
	@RequestMapping("/clientEdit")
	public String clientEdit(HttpServletRequest request, HttpServletResponse response,String openid, Integer card_id, Model model) throws IOException {
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
			model.addAttribute("uniacid", uniacid);
			model.addAttribute("message", "没有绑定对应的名片");
			model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
			return "qyWX/error1";
		}
		if(!StringUtils.hasText(openid)) {
			model.addAttribute("message", "参数不对-1");
			logger.info("参数不对-1");
			return "qyWX/error";
		}
		if(card_id == null) {
			model.addAttribute("message", "参数不对-1");
			logger.info("参数不对-1");
			return "qyWX/error";
		}
		
		CardSetExample setExample = new CardSetExample();
		setExample.createCriteria().andUniacidEqualTo(uniacid);
		List<CardSet> setList = setMapper.selectByExample(setExample);
		CardSet base = setList.size() > 0 ? setList.get(0) : new CardSet();
		
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			model.addAttribute("message", "没有找到对应的名片-1");
			logger.info("没有找到对应的名片-1");
			return "qyWX/error";
		}
		if(cardInfo.getId() != card_id) {
			model.addAttribute("message", "没有找到对应的名片-2");
			logger.info("没有找到对应的名片-2");
			return "qyWX/error";
		}
		
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openid).andAidEqualTo(card_id);
		List<CardMember> memberList = memberMapper.selectByExample(memberExample);
		CardMember info = memberList.size() > 0 ? memberList.get(0) : new CardMember();
		if(!StringUtils.hasText(info.getPhone())) {
			CardMemberExample memberExample2 = new CardMemberExample();
			memberExample2.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openid);
			List<CardMember> memberList2 = memberMapper.selectByExample(memberExample);
			CardMember get_phone = memberList2.size() > 0 ? memberList2.get(0) : new CardMember();
			if(StringUtils.hasText(get_phone.getPhone())) {
				info.setPhone(get_phone.getPhone());
			}
		}
		
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("info", info);
		model.addAttribute("uniacid", uniacid);
		model.addAttribute("openid", openid);
		model.addAttribute("card_id", card_id);
		return "qyWX/clientEdit";
	}
	
	@RequestMapping("/getMemberFollow")
	public String getMemberFollow(HttpServletRequest request, HttpServletResponse response,
			Integer mid, Integer card_id, Model model) throws IOException {
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
			model.addAttribute("uniacid", uniacid);
			model.addAttribute("message", "没有绑定对应的名片");
			model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
			return "qyWX/error1";
		}
		if(mid == null) {
			model.addAttribute("message", "信息拉取失败-1");
			logger.info("信息拉取失败-1");
			return "qyWX/error";
		}
		if(card_id == null) {
			model.addAttribute("message", "信息拉取失败-2");
			logger.info("信息拉取失败-2");
			return "qyWX/error";
		}
		CardMember memberInfo = memberMapper.selectByPrimaryKey(mid);
		if(memberInfo == null) {
			model.addAttribute("message", "信息拉取失败-4");
			logger.info("信息拉取失败-4");
			return "qyWX/error";
		}
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("member_info", memberInfo);
		model.addAttribute("uniacid", uniacid);
		model.addAttribute("mid", mid);
		model.addAttribute("card_id", card_id);
		return "qyWX/getMemberFollow";
	}
	
	
	@RequestMapping("/getMemberGj")
	public @ResponseBody Map<String, Object> getMemberGj(HttpServletRequest request, HttpServletResponse response, 
			Integer card_mid, Integer card_id) throws IOException {
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
		if(card_mid == null) {
			result.put("msg", "参数错误-1");
			result.put("error", 1);
			return result;
		}
		if(card_id == null) {
			result.put("msg", "参数错误-2");
			result.put("error", 1);
			return result;
		}
		int page = Integer.valueOf(request.getParameter("page"));
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
		if(cardInfo.getId() != card_id) {
			result.put("msg", "参数错误-3");
			result.put("error", 1);
			return result;
		}
		int psize = 10;
		if(page < 1) {
			page = 1;
		}
		Page pages = PageHelper.startPage(page, psize);
		CardCloserExample closerExample = new CardCloserExample();
		closerExample.createCriteria().andUniacidEqualTo(uniacid).andCardIdEqualTo(card_id).andCardMidEqualTo(card_mid);
		closerExample.setOrderByClause(" addtime desc");
		List<CardCloser> closerList = closerMapper.selectByExampleWithBLOBs(closerExample);
		for(CardCloser closer : closerList) {
			closer.setAddtime(DateUtils.StringToFormat(closer.getAddtime()));
		}
		if(pages.getPageNum() < page) {
			closerList = null;
		}
		result.put("Data", closerList);
		return result;
	}
	@RequestMapping("/getMemberCloser")
	public @ResponseBody Map<String, Object> getMemberCloser(HttpServletRequest request, HttpServletResponse response, 
			Integer card_mid, Integer card_id,String content) throws IOException {
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
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("请在企业微信打开");
			result.put("msg", "请在企业微信打开");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			logger.info("没有绑定对应的名片");
			result.put("msg", "没有绑定对应的名片");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(content)) {
			result.put("msg", "请填写内容");
			result.put("Code", 1);
			return result;
		}
		if(card_mid == null) {
			result.put("msg", "参数错误-1");
			result.put("Code", 1);
			return result;
		}
		if(card_id == null) {
			result.put("msg", "参数错误-2");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			result.put("msg", "没有绑定对应的名片");
			result.put("Code", 1);
			return result;
		}
		if(cardInfo.getId() != card_id) {
			result.put("msg", "没有对应的名片-1");
			result.put("Code", 1);
			return result;
		}
		CardCloser closer = new CardCloser();
		closer.setUniacid(uniacid);
		closer.setCardId(card_id);
		closer.setCardMid(card_mid);
		closer.setAddtime(String.valueOf(System.currentTimeMillis()));
		closer.setContent(content);
		int insert = closerMapper.insert(closer);
		if(insert == 0) {
			result.put("msg", "保存失败");
			result.put("Code", 1);
			return result;
		}
		result.put("Code", 0);
		return result;
	}
	
	@RequestMapping("/getAiMsgClient")
	public @ResponseBody Map<String, Object> getAiMsgClient(HttpServletRequest request, HttpServletResponse response, 
			String openid, Integer card_id) throws IOException {
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
		if(card_id == null) {
			result.put("msg", "参数错误-1");
			result.put("error", 1);
			return result;
		}
		if(openid == null) {
			result.put("msg", "参数错误-2");
			result.put("error", 1);
			return result;
		}
		int page = Integer.valueOf(request.getParameter("page"));
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
		if(cardInfo.getId() != card_id) {
			result.put("msg", "参数错误-3");
			result.put("error", 1);
			return result;
		}
		int psize = 20;
		if(page < 1) {
			page = 1;
		}
		Page pages = PageHelper.startPage(page, psize);
		ActReportExample actReportExample = new ActReportExample();
		actReportExample.createCriteria().andUniacidEqualTo(uniacid).andCardIdEqualTo(cardInfo.getId()).andOpenidEqualTo(openid);
		actReportExample.setOrderByClause(" addtime DESC");
		List<ActReport> reportList = actReportMapper.selectByExample(actReportExample);
		if(pages.getPageNum() < page) {
			reportList = null;
		}
		result.put("Data", reportList);
		return result;
	}
	@RequestMapping("/getMemberAidata")
	public @ResponseBody Map<String, Object> getMemberAidata(HttpServletRequest request, HttpServletResponse response, 
			String openid, Integer card_id) throws IOException {
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
		if(card_id == null) {
			result.put("msg", "参数错误-1");
			result.put("error", 1);
			return result;
		}
		if(openid == null) {
			result.put("msg", "参数错误-2");
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
		if(cardInfo.getId() != card_id) {
			result.put("msg", "参数错误-1");
			result.put("error", 1);
			return result;
		}
		String startTime = String.valueOf(System.currentTimeMillis() - 7 * 24 *60 * 60 * 1000);
		String endTime = String.valueOf(System.currentTimeMillis());
		List<Map<String, Object>> reportList = actReportMapper.selectReportAI(startTime, endTime, card_id, uniacid, openid);
		result.put("Data", reportList);
		return result;
	}
	
	@RequestMapping("/getMemberChange")
	public @ResponseBody Map<String, Object> getMemberChange(HttpServletRequest request, HttpServletResponse response, 
			Integer mid, Integer gailv) throws IOException {
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
		if(mid == null) {
			result.put("msg", "信息拉取失败-1");
			result.put("error", 1);
			return result;
		}
		
		CardMember member_info = memberMapper.selectByPrimaryKey(mid);
		if(member_info == null) {
			result.put("msg", "信息拉取失败-4");
			result.put("error", 1);
			return result;
		}
		member_info.setGailv(gailv);
		int update = memberMapper.updateByPrimaryKey(member_info);
		if(update == 0) {
			result.put("msg", "更新失败");
			result.put("error", 1);
			return result;
		}
		result.put("error", 0);
		return result;
	}
	
	@RequestMapping("/clientSave")
	public @ResponseBody Map<String, Object> clientSave(HttpServletRequest request, HttpServletResponse response,
			Integer hmdStatus, Integer pbStatus, String phone, String name, Integer mid, Model model) throws IOException {
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
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("请在企业微信打开");
			result.put("msg", "请在企业微信打开");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			logger.info("没有绑定对应的名片");
			result.put("msg", "没有绑定对应的名片");
			result.put("Code", 1);
			return result;
		}
		if(mid == null) {
			result.put("msg", "参数错误-1");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			result.put("msg", "找不到对应的名片");
			result.put("Code", 1);
			return result;
		}
		CardMember getInfo = memberMapper.selectByPrimaryKey(mid);
		if(getInfo == null) {
			result.put("msg", "不存在" + mid);
			result.put("Code", 1);
			return result;
		}
		getInfo.setPbStatus(pbStatus);
		getInfo.setPhone(phone);
		getInfo.setName(name);
		getInfo.setHmdStatus(hmdStatus);
		int update = memberMapper.updateByPrimaryKey(getInfo);
		if(update == 0) {
			result.put("msg", "保存失败");
			result.put("Code", 1);
			return result;
		}
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		result.put("Code", 0);
		return result;
	}

}
