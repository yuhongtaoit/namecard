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
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.ActReport;
import com.zhongwei.namecard.entity.ActReportExample;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.QyUtils;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private ActReportMapper actReportMapper;
	
	@RequestMapping("/getMemberAct")
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
			model.addAttribute("uniacid", uniacid);
			model.addAttribute("message", "没有绑定对应的名片");
			model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
			return "qyWX/error1";
		}
		if(type == null) {
			type = 0;
		}
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("type", type);
		model.addAttribute("uniacid", uniacid);
		return "qyWX/getMemberAct";
	}
	
	@RequestMapping("/memberAct")
	public String memberAct(HttpServletRequest request, HttpServletResponse response, Model model,
			String startTime, String endTime) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String message = "返回消息";
		int error = 0;
		result.put("message", message);
		result.put("error", error);
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
		String userId = (String) request.getSession().getAttribute("session_dbs_masclwlcard_usderid");
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andUseridEqualTo(userId);
		List<Card> cardList = cardMapper.selectByExample(cardExample);
		Card cardInfo = cardList.size() > 0 ? cardList.get(0) : new Card();
		if(StringUtils.hasText(startTime) && StringUtils.hasText(endTime)) {
			//******
		}else {
			startTime = String.valueOf(System.currentTimeMillis() - 7 * 24 *60 * 60 * 1000);
			endTime = String.valueOf(System.currentTimeMillis());
		}
		ActReportExample reportExample = new ActReportExample();
		reportExample.createCriteria().andUniacidEqualTo(uniacid).andCardIdEqualTo(cardInfo.getId()).andAddtimeBetween(startTime, endTime);
		reportExample.setOrderByClause(" addtime DESC");
		List<ActReport> reportList = actReportMapper.selectByExample(reportExample);
		int type0Num = 0;
		int type1Num = 0;
		int type2Num = 0;
		int type3Num = 0;
		int type4Num = 0;
		int type5Num = 0;
		int type6Num = 0;
		int type7Num = 0;
		for(ActReport report : reportList) {
			switch(report.getActId()) {
				case 654:
					report.setType(5);
					type7Num = type7Num+1;
					break;
				case 655:
					if("wxid".equals(report.getCopytype())) {
						report.setType(2);
						type2Num = type2Num+1;
					}
					break;
				case 657:
					if("0".endsWith(report.getFootertype())) {
						report.setType(3);
						type4Num = type4Num+1;
					}else if("1".endsWith(report.getFootertype())) {
						report.setType(0);
						type0Num = type0Num+1;
					}else if("2".endsWith(report.getFootertype())) {
						report.setType(4);
						type5Num = type5Num+1;
					}else if("3".endsWith(report.getFootertype())) {
						report.setType(1);
						type1Num = type1Num+1;
					}
					break;
				case 659:
					report.setType(6);
					break;
				case 701:
					report.setType(7);
					break;
				default:
					report.setType(-1);
					break;
			}
			report.setNum(1);
		}
		model.addAttribute("type0_num", type0Num);
		model.addAttribute("type1_num", type1Num);
		model.addAttribute("type2_num", type2Num);
		model.addAttribute("type3_num", type3Num);
		model.addAttribute("type4_num", type4Num);
		model.addAttribute("type5_num", type5Num);
		model.addAttribute("type6_num", type6Num);
		model.addAttribute("type7_num", type7Num);
		result.put("Data", reportList);
		model.addAttribute("projectRootPath", wxMaProperties.getProjectRootPath());
		model.addAttribute("uniacid", uniacid);
		return "qyWX/memberAct";
	}
	
	
	@RequestMapping("/getMemberActiontype")
	public @ResponseBody Map<String, Object> getMemberActiontype(HttpServletRequest request, HttpServletResponse response, 
			String startTime, String endTime, Integer type) throws IOException {
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
		int psize = 20;
		if(page < 1) {
			page = 1;
		}
		if(StringUtils.hasText(startTime) && StringUtils.hasText(endTime)) {
			//******
		}else {
			startTime = String.valueOf(System.currentTimeMillis() - (7 * 24 * 60 * 60 * 1000));
			endTime = String.valueOf(System.currentTimeMillis());
		}
		if(type == null) {
			type = 0;
		}
		String footertype = "0";
		String copytype = "0";
		int act_id = 0;
		switch (type) {
			case 0:
				footertype = "1";
				act_id = 657;
				break;
			case 1:
				footertype = "3";
				act_id = 657;
				break;
			case 2:
				copytype = "wxid";
				act_id = 655;
				break;
			case 4:
				footertype = "0";
				act_id = 657;
				break;
			case 5:
				footertype = "2";
				act_id = 657;
				break;
			case 7:
				act_id = 654;
				break;
			default:
				result.put("msg", "没有对应的");
				result.put("error", 1);
				return result;
		}
		Page pages = PageHelper.startPage(page, psize);
		ActReportExample actReportExample = new ActReportExample();
		if(type == 2) {
			actReportExample.createCriteria().andUniacidEqualTo(uniacid).andAddtimeBetween(startTime, endTime).andActIdEqualTo(act_id).andCopytypeEqualTo(copytype).andCardIdEqualTo(cardInfo.getId());
		}else if(type == 7) {
			actReportExample.createCriteria().andUniacidEqualTo(uniacid).andAddtimeBetween(startTime, endTime).andActIdEqualTo(act_id).andCardIdEqualTo(cardInfo.getId());
		}else{
			actReportExample.createCriteria().andUniacidEqualTo(uniacid).andAddtimeBetween(startTime, endTime).
					andActIdEqualTo(act_id).andCopytypeEqualTo(copytype).andFootertypeEqualTo(footertype).andCardIdEqualTo(cardInfo.getId());
		}
		actReportExample.setOrderByClause(" addtime DESC");
		List<ActReport> Data = actReportMapper.selectByExample(actReportExample);
		if(pages.getPageNum() < page) {
			Data = null;
		}
		result.put("Data", Data);
		result.put("error", 0);
		return result;
	}
	

}
