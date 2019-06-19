package com.zhongwei.namecard.qyWX.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.zhongwei.namecard.dao.CardFriendMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardPlMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.dao.CardZanMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardFriendExample;
import com.zhongwei.namecard.entity.CardFriendWithBLOBs;
import com.zhongwei.namecard.entity.CardPl;
import com.zhongwei.namecard.entity.CardPlExample;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.CardZan;
import com.zhongwei.namecard.entity.CardZanExample;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.DateUtils;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.QyUtils;


@Controller
@RequestMapping("/friend")
public class FriendQYController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardSetMapper setMapper;
	
	@Autowired
	private CardFriendMapper friendMapper;
	
	@Autowired
	private CardPlMapper plMapper;
	
	@Autowired
	private CardZanMapper zanMapper;
	
	@Autowired
	private SetQYMapper qyMapper;
	
	
	@RequestMapping("/friend")
	public String friend(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
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
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		return "qyWX/friendIndex";
	}
	@RequestMapping("/friendEditor")
	public String friendEditor(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
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
		SetQYExample qyExample = new SetQYExample();
		qyExample.createCriteria().andUniacidEqualTo(uniacid);
		List<SetQY> qyList = qyMapper.selectByExample(qyExample);
		SetQY setQY = qyList.size() > 0 ? qyList.get(0) : new SetQY(); 
		String accessToken = QySendUtils.getAccessToken(setQY.getCorpid(), setQY.getSecret(), uniacid);
		String ticket = QySendUtils.getqyJsapiTicket(setQY.getCorpid(), setQY.getSecret(), accessToken, uniacid);
		String http_type = "";
		String refererURL = request.getHeader("https-tag");
		if(StringUtils.hasText(refererURL)){
			http_type = refererURL.toLowerCase() + "://";
		}else {
			http_type = "https://";
		}
		String url = http_type + request.getServerName() + "/friend/friendEditor?uniacid=" + uniacid;
		Map<String, Object> Sign = QySendUtils.addSign(setQY.getCorpid(), ticket, url);
		model.addAttribute("Sign", Sign);
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		return "qyWX/friendEditor";
	}
	
	
	@RequestMapping("/getFriendlist")
	public @ResponseBody Map<String, Object> getFriendlist(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			result.put("msg", "没有找到对应的名片");
			result.put("error", 1);
			return result;
		}
		if(page < 1) {
			page = 1;
		}
		int psize = 20;
		Page pages = PageHelper.startPage(page, psize);
		
		CardFriendExample friendExample = new CardFriendExample();
		friendExample.createCriteria().andUniacidEqualTo(uniacid);
		friendExample.setOrderByClause(" time DESC");
		List<CardFriendWithBLOBs> Data = friendMapper.selectByExampleWithBLOBs(friendExample);
		for(CardFriendWithBLOBs friend : Data) {
			friend.setTimeStr(DateUtils.millisToString(Long.valueOf(friend.getTime())*Long.valueOf(1000)));
			if(friend.getCardId() == cardInfo.getId()) {
				friend.setIs_my("1");
			}else {
				friend.setIs_my("0");
			}
			if(friend.getCardId() > 0) {
				CardWithBLOBs card = cardMapper.selectByPrimaryKey(friend.getCardId());
				card.setCardLogo(ImageUrlUtils.getAbsolutelyURL(card.getCardLogo()));
				friend.setCard_info(card);
			}else {
				friend.setHeadImg(ImageUrlUtils.getAbsolutelyURL(friend.getHeadImg()));
				CardSetExample setExample = new CardSetExample();
				setExample.createCriteria().andUniacidEqualTo(uniacid);
				List<CardSet> setList = setMapper.selectByExample(setExample);
				CardSet cardset = setList.size() > 0 ? setList.get(0) : new CardSet();
				cardset.setCompanyLogo(ImageUrlUtils.getAbsolutelyURL(cardset.getCompanyLogo()));
				friend.setBase_set(cardset);
				
			}
			
			CardPlExample plExample = new CardPlExample();
			plExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(friend.getId());
			List<CardPl> plList = plMapper.selectByExample(plExample);
			friend.setPl_list(plList);
			
			CardZanExample zanExample = new CardZanExample();
			zanExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(friend.getId()).andStatusEqualTo(1);
			List<CardZan> zList = zanMapper.selectByExample(zanExample);
			friend.setZ_list(zList);
			
			friend.setAllImgarr(ImageUrlUtils.unserialize(friend.getAllImg())); // ********s
			
		}
		if(pages.getPageNum() < page) {
			Data = null;
		}
		result.put("Data", Data);
		return result;
	}
	
	@RequestMapping("/addPl")
	public @ResponseBody Map<String, Object> addPl(HttpServletRequest request, HttpServletResponse response, 
			Integer fid, String content) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("Code", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("不存在的参数-1");
			result.put("msg", "不存在的参数-1");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			logger.info("不存在的参数-2");
			result.put("msg", "不存在的参数-2");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			result.put("msg", "不存在的参数-3");
			result.put("Code", 1);
			return result;
		}
		if(fid == null) {
			result.put("msg", "不存在的参数-4");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(content)) {
			result.put("msg", "不存在的参数-5");
			result.put("Code", 1);
			return result;
		}
		CardPl pl = new CardPl();
		pl.setUniacid(uniacid);
		pl.setAddtime(String.valueOf(System.currentTimeMillis()));
		pl.setFid(fid);
		pl.setNickname(cardInfo.getCardName());
		pl.setOpenid(cardInfo.getId()+"");
		pl.setContent(content);
		pl.setName("");
		pl.setPhone("");
		pl.setUpdatetime("");
		pl.setCity("1");
		pl.setAid(1);
		pl.setAvatar("");
		pl.setAvatarurl("1");
		pl.setGender(1);
		pl.setLanguage("1");
		pl.setProvince("1");
		int insert = plMapper.insert(pl);
		if(insert == 0) {
			result.put("msg", "失败-7");
			result.put("Code", 1);
			return result;
		}
		CardFriendWithBLOBs friend = friendMapper.selectByPrimaryKey(fid);
		if(friend == null) {
			result.put("msg", "失败-6");
			result.put("Code", 1);
			return result;
		}
		int is_my = 1;
		if(friend.getCardId() != cardInfo.getId()) {
			is_my = 0;
		}else {
			is_my = 1;
		}
		CardPlExample plExample = new CardPlExample();
		plExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(friend.getId());
		List<CardPl> plList = plMapper.selectByExample(plExample);
		
		result.put("Code", 0);
		result.put("Data", plList);
		result.put("is_my", is_my);
		return result;
	}
	@RequestMapping("/addZan")
	public @ResponseBody Map<String, Object> addZan(HttpServletRequest request, HttpServletResponse response, 
			Integer fid) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("Code", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("不存在的参数-1");
			result.put("msg", "不存在的参数-1");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			logger.info("不存在的参数-2");
			result.put("msg", "不存在的参数-2");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			result.put("msg", "不存在的参数-3");
			result.put("Code", 1);
			return result;
		}
		if(fid == null) {
			result.put("msg", "不存在的参数-4");
			result.put("Code", 1);
			return result;
		}
		
		CardZanExample zanExample = new CardZanExample();
		zanExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(fid).andOpenidEqualTo(cardInfo.getId()+"");
		List<CardZan> zanList = zanMapper.selectByExample(zanExample);
		CardZan zan = zanList.size() > 0 ? zanList.get(0) : new CardZan();
		int insertOrUpdate = 0;
		zan.setUniacid(uniacid);
		zan.setOpenid(cardInfo.getId()+"");
		zan.setNickname(cardInfo.getCardName());
		zan.setFid(fid);
		zan.setAvatar("");
		zan.setAvatarurl("");
		zan.setAid(1);
		zan.setCity("1");
		zan.setGender(1);
		zan.setLanguage("1");
		zan.setName("");
		zan.setPhone("");
		zan.setProvince("1");
		if(zanList.size() == 0) {
			zan.setAddtime(String.valueOf(System.currentTimeMillis()));
			zan.setStatus(1);
			zan.setUpdatetime("");
			insertOrUpdate = zanMapper.insert(zan);
		}else {
			zan.setAddtime(StringUtils.hasText(zan.getAddtime()) ? zan.getAddtime() : String.valueOf(System.currentTimeMillis()));
			zan.setUpdatetime(String.valueOf(System.currentTimeMillis()));
			if(zan.getStatus() == 1) {
				zan.setStatus(0);
			}else {
				zan.setStatus(1);
			}
			insertOrUpdate = zanMapper.updateByPrimaryKey(zan);
		}
		if(insertOrUpdate == 0) {
			result.put("msg", "失败-5");
			result.put("Code", 1);
			return result;
		}
		zanExample = new CardZanExample();
		zanExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(fid).andStatusEqualTo(1);
		List<CardZan> zList = zanMapper.selectByExample(zanExample);
		result.put("Code", 0);
		result.put("Data", zList);
		return result;
	}
	@RequestMapping("/deleteDt")
	public @ResponseBody Map<String, Object> deleteDt(HttpServletRequest request, HttpServletResponse response, 
			Integer fid) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("Code", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("不存在的参数-1");
			result.put("msg", "不存在的参数-1");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			logger.info("不存在的参数-2");
			result.put("msg", "不存在的参数-2");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		if(cardList.size() == 0) {
			result.put("msg", "不存在的参数-3");
			result.put("Code", 1);
			return result;
		}
		if(fid == null) {
			result.put("msg", "不存在的参数-4");
			result.put("Code", 1);
			return result;
		}
		int delete = friendMapper.deleteByPrimaryKey(fid);
		if(delete == 0) {
			result.put("msg", "删除失败-5");
			result.put("Code", 1);
			return result;
		}
		CardPlExample plExample = new CardPlExample();
		plExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(fid);
		plMapper.deleteByExample(plExample);
		CardZanExample zanExample = new CardZanExample();
		zanExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(fid);
		zanMapper.deleteByExample(zanExample);
		
		result.put("Code", 0);
		return result;
	}
	
	@RequestMapping("/deletePl")
	public @ResponseBody Map<String, Object> deletePl(HttpServletRequest request, HttpServletResponse response, 
			Integer fid) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("Code", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("不存在的参数-1");
			result.put("msg", "不存在的参数-1");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			logger.info("不存在的参数-2");
			result.put("msg", "不存在的参数-2");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		if(cardList.size() == 0) {
			result.put("msg", "不存在的参数-3");
			result.put("Code", 1);
			return result;
		}
		if(fid == null) {
			result.put("msg", "不存在的参数-4");
			result.put("Code", 1);
			return result;
		}
		plMapper.deleteByPrimaryKey(fid);
		
		result.put("Code", 0);
		return result;
	}
	
	@RequestMapping("/friendDownload")
	public @ResponseBody Map<String, Object> friendDownload(HttpServletRequest request, HttpServletResponse response, 
			String media_id) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("Code", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			result.put("msg", "请在企业微信打开");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			result.put("msg", "没有绑定对应的名片");
			result.put("Code", 1);
			return result;
		}
		if(media_id == null) {
			result.put("msg", "参数错误");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<CardWithBLOBs> cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		CardWithBLOBs cardInfo = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		if(cardList.size() == 0) {
			result.put("msg", "错误3");
			result.put("Code", 1);
			return result;
		}
		String Data = QyUtils.downloadImage(uniacid, media_id, cardInfo.getId());
		result.put("Code", 0);
		result.put("Data", Data);
		return result;
	}
	
	@RequestMapping("/friendSave")
	public @ResponseBody Map<String, Object> friendSave(HttpServletRequest request, HttpServletResponse response, 
			String imgs, String content) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("msg", "请先登录企业微信");
			result.put("Code", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			result.put("msg", "请在企业微信打开");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			result.put("msg", "没有绑定对应的名片");
			result.put("Code", 1);
			return result;
		}
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<CardWithBLOBs> cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		CardWithBLOBs cardInfo = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		if(cardList.size() == 0) {
			result.put("msg", "没有绑定对应的名片");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(content)) {
			result.put("msg", "请填写内容");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(imgs)) {
			result.put("msg", "请上传图片");
			result.put("Code", 1);
			return result;
		}
		String photo[] = imgs.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(photo));
		CardFriendWithBLOBs record = new CardFriendWithBLOBs();
		record.setUniacid(uniacid);
		record.setTime(Integer.valueOf(Long.toString(System.currentTimeMillis()/1000)));
		record.setAllImg(list.toString());
		record.setIsCard(1);
		record.setCardId(cardInfo.getId());
		record.setContentCard(content);
		record.setTitle("");
		record.setHeadImg("");
		record.setContent("");
		record.setSort(0);
		int insert = friendMapper.insert(record);
		result.put("Code", 0);
		if(insert == 0) {
			result.put("msg", "保存失败");
			result.put("Code", 1);
			return result;
		}
		return result;
	}

}
