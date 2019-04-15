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

import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.Constants;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.QyUtils;


@Controller
@RequestMapping("/home")
public class HomeQyController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardSetMapper setMapper;
	
	@Autowired
	private SetQYMapper qyMapper;
	
	
	@RequestMapping("/home")
	public String friend(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		int status = QyUtils.checkQyLogin(request, response);
		Integer uniacid = Constants.UNIACID;
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
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(cardList.size() == 0) {
			model.addAttribute("message", "没有找到对应的名片");
			return "qyWX/error";
		}
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		cardInfo.setCardLogo(ImageUrlUtils.getAbsolutelyURL(cardInfo.getCardLogo()));
		model.addAttribute("card_info", cardInfo);
		return "qyWX/home";
	}
	@RequestMapping("/myEdit")
	public String myEdit(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		int status = QyUtils.checkQyLogin(request, response);
		if(status == -1) {
			model.addAttribute("message", "请在企业微信打开");
			return "qyWX/error";
		}
		if(status == -2) {
			model.addAttribute("message", "没有绑定对应的名片");
			return "qyWX/error";
		}
		Integer uniacid = Constants.UNIACID;
		CardSetExample setExample = new CardSetExample();
		setExample.createCriteria().andUniacidEqualTo(uniacid);
		List<CardSet> setList = setMapper.selectByExample(setExample);
		CardSet cardSet = setList.size() > 0 ? setList.get(0) : new CardSet();
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<CardWithBLOBs> cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		CardWithBLOBs cardInfo = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		if(cardList.size() == 0) {
			model.addAttribute("message", "没有找到对应的名片");
			return "qyWX/error";
		}
		cardInfo.setCardLogo(ImageUrlUtils.getAbsolutelyURL(cardInfo.getCardLogo()));
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("card_info", cardInfo);
		model.addAttribute("base", cardSet);
		return "qyWX/myEdit";
	}
	
	@RequestMapping("/myEwm")
	public String myEwm(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		int status = QyUtils.checkQyLogin(request, response);
		if(status == -1) {
			model.addAttribute("message", "请在企业微信打开");
			return "qyWX/error";
		}
		if(status == -2) {
			model.addAttribute("message", "没有绑定对应的名片");
			return "qyWX/error";
		}
		Integer uniacid = Constants.UNIACID;
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<CardWithBLOBs> cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		if(cardList.size() == 0) {
			model.addAttribute("message", "没有找到对应的名片");
			return "qyWX/error";
		}
		String wx_png = "";//********二维码位置
		model.addAttribute("wx_png", wx_png);
		return "qyWX/myEwm";
	}
	
	@RequestMapping("/myPhoto")
	public String myPhoto(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		int status = QyUtils.checkQyLogin(request, response);
		if(status == -1) {
			model.addAttribute("message", "请在企业微信打开");
			return "qyWX/error";
		}
		if(status == -2) {
			model.addAttribute("message", "没有绑定对应的名片");
			return "qyWX/error";
		}
		Integer uniacid = Constants.UNIACID;
		SetQYExample qyExample = new SetQYExample();
		qyExample.createCriteria().andUniacidEqualTo(uniacid);
		List<SetQY> qyList = qyMapper.selectByExample(qyExample);
		SetQY setQY = qyList.size() > 0 ? qyList.get(0) : new SetQY();
		String accessToken = QySendUtils.getAccessToken(setQY.getCorpid(), setQY.getSecret(), uniacid);
		String ticket = QySendUtils.getqyJsapiTicket(accessToken, uniacid);
		String http_type = "";
		String refererURL = request.getHeader("https-tag");
		if(StringUtils.hasText(refererURL)){
			http_type = refererURL.toLowerCase() + "://";
		}else {
			http_type = "http://";
		}
		String url = http_type + request.getServerName() + ":" + request.getServerPort() + "/home/myPhoto";
		Map<String, Object> Sign = QySendUtils.addSign(setQY.getCorpid(), ticket, url);
		model.addAttribute("Sign", Sign);
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		return "qyWX/myPhoto";
	}
	
	
	@RequestMapping("/mySaveCard")
	public @ResponseBody Map<String, Object> mySaveCard(HttpServletRequest request, HttpServletResponse response,
			String email, String mobile, String zd_msg, String wxid, String content) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Integer uniacid = Constants.UNIACID;
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
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<CardWithBLOBs> cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		CardWithBLOBs cardInfo = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		if(cardList.size() == 0) {
			result.put("msg", "没有找到对应的名片");
			result.put("Code", 1);
			return result;
		}
		
		if(!StringUtils.hasText(email)) {
			result.put("msg", "请填写邮箱");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(mobile)) {
			result.put("msg", "请填写手号机");
			result.put("Code", 1);
			return result;
		}
		cardInfo.setCardTel(mobile);
		cardInfo.setCardInstr(content);
		cardInfo.setZdMsg(zd_msg);
		cardInfo.setWeixinid(wxid);
		cardInfo.setEmail(email);
		int update = cardMapper.updateByPrimaryKeyWithBLOBs(cardInfo);
		if(update == 0) {
			result.put("msg", "保存失败");
			result.put("Code", 1);
			return result;
		}
		return result;
	}
	
	@RequestMapping("/myPhotoGet")
	public @ResponseBody Map<String, Object> myPhotoGet(HttpServletRequest request, HttpServletResponse response, 
			Integer fid) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Integer uniacid = Constants.UNIACID;
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			result.put("msg", "错误1");
			result.put("Code", 1);
			return result;
		}
		if(status == -2) {
			result.put("msg", "错误2");
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
		List<String> photo = new ArrayList<String>();
		if(StringUtils.hasText(cardInfo.getPhoto())) {
			String[] newphoto = ImageUrlUtils.unserialize(cardInfo.getPhoto());
			for(String str : newphoto) {
//				photo.add(ImageUrlUtils.getAbsolutelyURL(str));
				photo.add(str.trim());
			}
		}
		
		result.put("Code", 0);
		result.put("Imgs", photo);
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
		Integer uniacid = Constants.UNIACID;
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
		String Data = QyUtils.downloadImage(media_id, cardInfo.getId());
		result.put("Code", 0);
		result.put("Data", Data);
		return result;
	}
	
	@RequestMapping("/myPhotoSave")
	public @ResponseBody Map<String, Object> myPhotoSave(HttpServletRequest request, HttpServletResponse response, 
			String imgs) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Integer uniacid = Constants.UNIACID;
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
			result.put("msg", "请上传图片");
			result.put("Code", 1);
			return result;
		}
		String old_photo = cardInfo.getPhoto();
		if(!StringUtils.hasText(old_photo)) {
			result.put("msg", "请上传图片");
			result.put("Code", 1);
			return result;
		}
		String photo[] = imgs.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(photo));
		cardInfo.setPhoto(list.toString());
		int update = cardMapper.updateByPrimaryKeyWithBLOBs(cardInfo);
		result.put("Code", 0);
		if(update == 0) {
			result.put("msg", "更新失败");
			result.put("Code", 1);
			return result;
		}
		return result;
	}
	
	

}
