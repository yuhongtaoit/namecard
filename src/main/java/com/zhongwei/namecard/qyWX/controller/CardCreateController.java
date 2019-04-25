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

import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.MiniQrService;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.QyUtils;


@Controller
@RequestMapping("/cardCreate")
public class CardCreateController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private SetQYMapper qyMapper;
	@Autowired
	private MiniQrService miniQrService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private AccountWxappMapper accountMapper;
	
	@RequestMapping("/cardCreate")
	public String stafferIndex(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			model.addAttribute("message", "请先登录企业微信");
			return "qyWX/error";
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
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
			http_type = "http://";
		}
		String url = http_type + request.getServerName() + ":" + request.getServerPort() + "/cardCreate/cardCreate?uniacid=" + uniacid;
		Map<String, Object> Sign = QySendUtils.addSign(setQY.getCorpid(), ticket, url);
		model.addAttribute("Sign", Sign);
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		return "qyWX/cardCreate";
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
		String Data = QyUtils.downloadImage(uniacid, media_id, 0);
		result.put("Code", 0);
		result.put("Data", Data);
		return result;
	}
	@RequestMapping("/insert")
	public @ResponseBody Map<String, Object> cardInsert(HttpServletRequest request, HttpServletResponse response, 
			String cardName, String cardTel, String weixinid, Integer thumbsNum, String userid, String email,
			String companyName, Integer gender, Integer mrtype, String phone, String roleName, String detailedAddress,
			String shareTitle, String cardInstr, String cardLogo, String photo, String shareImg) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = "返回消息";
		int Code = 0;
		result.put("msg", msg);
		result.put("Code", Code);
		Object uniacidObj = request.getParameter("uniacid");
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		
		
		
		if(!StringUtils.hasText(cardName)) {
			result.put("msg", "姓名必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(cardTel)) {
			result.put("msg", "个人电话必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(weixinid)) {
			result.put("msg", "微信号必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(userid)) {
			result.put("msg", "企业号账号必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(email)) {
			result.put("msg", "邮箱必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(companyName)) {
			result.put("msg", "公司名称必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(phone)) {
			result.put("msg", "公司电话必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(roleName)) {
			result.put("msg", "公司职位必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(detailedAddress)) {
			result.put("msg", "公司详细地址必输");
			result.put("Code", 1);
			return result;
		}
		if(!StringUtils.hasText(cardInstr)) {
			result.put("msg", "个人简介必输");
			result.put("Code", 1);
			return result;
		}
		CardWithBLOBs card = new CardWithBLOBs();
		card.setAddress("");
		card.setAvatarUrl("");
		card.setBrowseHeadimgNum(0);
		card.setCardForwardStatus(0);
		card.setCardInstr(cardInstr);
		card.setCardLevel(0);
		card.setCardLogo(cardLogo);
		card.setCardName(cardName);
		card.setCardTel(cardTel);
		card.setCompanyName(companyName);
		card.setCustomerDisturb(0);
		card.setDetailedAddress(detailedAddress);
		card.setEmail(email);
		card.setErrmsg("");
		card.setHideProperty(0);
		card.setCardId("");
		card.setIdentify("");
		card.setIshide(0);
		card.setIsSendcard(0);
		card.setIsSendcardId(0);
		card.setLastUpdateStarTime(String.valueOf(System.currentTimeMillis()));
		card.setMrtype(mrtype);
		card.setOpenBoss(0);
		card.setPhone(phone);
		String photos[] = photo.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(photos));
		card.setPhoto(list.toString());
//		card.setPhoto(photo);
		card.setRoleName(roleName);
		card.setSeeNum(0);
		card.setSex(gender);
		card.setShareImg(shareImg);
		card.setShareNum(0);
		card.setShareTitle(shareTitle);
		card.setSignatureCount(0);
		card.setSort(0);
		card.setTemplateImg("");
		card.setTemplateType(0);
		card.setThumbsNum(thumbsNum);
		card.setTotalPicNum(list.size() + (StringUtils.hasText(shareImg) ? 1 : 0) + (StringUtils.hasText(cardLogo) ? 1 : 0));
		card.setUniacid(uniacid);
		card.setUserid(userid);
		card.setWeixinid(weixinid);
		card.setZdMsg("");
		int insert  = 0;
		try {
			insert = cardMapper.insert(card);
			AccountWxapp account = accountMapper.selectByPrimaryKey(card.getUniacid());
			String accessToken = QySendUtils.getAccountToken(account.getKey(), account.getSecret(), card.getUniacid());
			this.miniQrService.getMiniQr("uniacid="+card.getUniacid()+"&card_id="+card.getId()+"&send_cardid=0", accessToken, card.getUniacid(), card.getId());
		} catch (Exception e) {
			fileUploadService.deleteFile(ImageUrlUtils.getAbsolutelyURL(shareImg));
			fileUploadService.deleteFile(ImageUrlUtils.getAbsolutelyURL(cardLogo));
			for(String path : photos) {
				fileUploadService.deleteFile(ImageUrlUtils.getAbsolutelyURL(path));
			}
			insert = 0;
		}
		if(insert == 0) {
			result.put("msg", "保存失败");
			result.put("Code", 1);
			return result;
		}
		result.put("Code", 0);
		return result;
	}
	

}
