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
@RequestMapping("/interact")
public class InteractController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private ActReportMapper actReportMapper;
	
	@RequestMapping("/interact")
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
		return "qyWX/interact";
	}
	
	@RequestMapping("/getInteract")
	public @ResponseBody Map<String, Object> getInteract(HttpServletRequest request, HttpServletResponse response,
			String startTime, String endTime) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String message = "返回消息";
		int error = 0;
		result.put("message", message);
		result.put("error", error);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("message", "请先登录企业微信");
			result.put("error", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int page = Integer.valueOf(request.getParameter("page"));
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("请在企业微信打开");
			result.put("message", "请在企业微信打开");
			result.put("error", 1);
			return result;
		}
		if(status == -2) {
			logger.info("没有绑定对应的名片");
			result.put("message", "没有绑定对应的名片");
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
		int psize = 10;
		if(StringUtils.hasText(startTime) && StringUtils.hasText(endTime)) {
			//******
		}else {
			startTime = String.valueOf(System.currentTimeMillis() - 7 * 24 *60 * 60 * 1000);
			endTime = String.valueOf(System.currentTimeMillis());
		}
		Page pages = PageHelper.startPage(page-1, psize);
		List<Map<String, Object>> reportList = actReportMapper.selectReportAct(startTime, endTime, cardInfo.getId(), uniacid);
		if(pages.getPageNum() < page) {
			reportList = null;
		}
		result.put("Data", reportList);
		return result;
	}
	
	@RequestMapping("/getInteractChart")
	public @ResponseBody Map<String, Object> getInteractChart(HttpServletRequest request, HttpServletResponse response,
			String startTime, String endTime, String openId) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String message = "返回消息";
		int error = 0;
		result.put("message", message);
		result.put("error", error);
		Object uniacidObj = request.getParameter("uniacid");
		if(uniacidObj == null || !StringUtils.hasText(uniacidObj.toString())) {
			result.put("message", "请先登录企业微信");
			result.put("error", 1);
			return result;
		}
		Integer uniacid = Integer.valueOf(uniacidObj.toString());
		int status = QyUtils.checkQyLogin(request, response);
		
		if(status == -1) {
			logger.info("请在企业微信打开");
			result.put("message", "请在企业微信打开");
			result.put("error", 1);
			return result;
		}
		if(status == -2) {
			logger.info("没有绑定对应的名片");
			result.put("message", "没有绑定对应的名片");
			result.put("error", 1);
			return result;
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
		if(!StringUtils.hasText(openId)) {
			result.put("message", "没有绑定对应客户");
			result.put("error", 1);
			return result;
		}
		ActReportExample reportExample = new ActReportExample();
		reportExample.createCriteria().andUniacidEqualTo(uniacid).andAddtimeBetween(startTime, endTime).andOpenidEqualTo(openId).andCardIdEqualTo(cardInfo.getId());
		reportExample.setOrderByClause(" addtime DESC");
		List<ActReport> reportList = actReportMapper.selectByExample(reportExample);
		for(ActReport report : reportList) {
			switch(report.getActId()) {
				case 654:
					report.setType(5);
					break;
				case 655:
					if ("wxid".equals(report.getCopytype())) {
						report.setType(2);
					}
					break;
				case 657:
					if (report.getFootertype().endsWith("0")) {
						report.setType(3);
					} else if (report.getFootertype().endsWith("1")) {
						report.setType(0);
					} else if (report.getFootertype().endsWith("2")) {
						report.setType(4);
					} else if (report.getFootertype().endsWith("3")) {
						report.setType(1);
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
		result.put("Data", reportList);
		return result;
	}
	
}
