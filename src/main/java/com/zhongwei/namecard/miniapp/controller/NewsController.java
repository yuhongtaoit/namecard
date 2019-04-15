package com.zhongwei.namecard.miniapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.CardNewsMapper;
import com.zhongwei.namecard.entity.CardNews;

@RestController
@RequestMapping("/miniapp")
public class NewsController {
	
	@Autowired
	private CardNewsMapper cardNewsMapper;
	
	@RequestMapping("/newsDetail")
	public Map<String, Object> newsDetail(int uniacid, String sessionId, Integer news_id, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		if(news_id == null) 
			news_id = 0;
		
		CardNews cardNews = cardNewsMapper.selectByPrimaryKey(news_id);
		data.putAll(cardNews.cardNewsToMap(cardNews));
		result.put("data", data);
		return result;
	}
}
