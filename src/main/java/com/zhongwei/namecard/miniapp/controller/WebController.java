package com.zhongwei.namecard.miniapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.CardWebMapper;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardWeb;
import com.zhongwei.namecard.entity.CardWebExample;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class WebController {
	
	@Autowired
	private CardWebMapper cardWebMapper;
	
	@RequestMapping("/webGet")
	public Map<String, Object> webGet(int uniacid, String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		List<CardWeb> webList = new ArrayList<CardWeb>();
		CardWebExample webExample = new CardWebExample();
		webExample.createCriteria().andUniacidEqualTo(uniacid);
		webList = cardWebMapper.selectByExampleWithBLOBs(webExample);
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(!StringUtils.hasText(openId)) {
			result.put("data", data);
			return result;
		}
		CardWeb web = webList.size() > 0 ? webList.get(0) : new CardWeb();
		if(web.getTxVideo() > 0) {
			web.setVideo(ImageUrlUtils.getAbsolutelyURL(web.getVideo()));
		}
		data.putAll(web.cardWebToMap(web));
		result.put("data", data);
		return result;
	}

}
