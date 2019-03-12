package com.zhongwei.namecard.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.AccessTokenMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.AccessToken;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;

@Service
public class QySendUtils {
	
	private static SetQYMapper setQYMapper;
	
	private static AccessTokenMapper accessTokenMapper;
	
	@Autowired
	public void setSetQYMapper(SetQYMapper setQYMapper) {
		QySendUtils.setQYMapper = setQYMapper;
	}
	
	@Autowired
	public static void setAccessTokenMapper(AccessTokenMapper accessTokenMapper) {
		QySendUtils.accessTokenMapper = accessTokenMapper;
	}
	public static void qySend(String toUser, String content) {
		
		
		if(toUser == null || toUser.equals("0")) {
			return;
		}
		
		List<SetQY> list = new ArrayList<SetQY>();
		list = setQYMapper.selectByExample(new SetQYExample());
		SetQY setQy = list.size() > 0 ? list.get(0) : new SetQY();
		
		String token = getAccessToken(setQy.getCorpid(), setQy.getSecret());
		String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + token;
		Map<String, String> param = new HashMap<String, String>();
		Map<String, Object> text = new HashMap<String, Object>();
		text.put("content", content);
		param.put("touser", toUser);
		param.put("msgtype", "text");
		param.put("agentid", setQy.getAgentid());
		param.put("text", text.toString());//******待验证
		HttpClientUtils.postMap(url, param);
		
	}
	
	public static String getAccessToken(String corpid, String secret) {
		AccessToken token = accessTokenMapper.selectByPrimaryKey(secret);
		if(token == null) {
			token.setCorpid(corpid);
			String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
			String accessToken = HttpClientUtils.get(url);//******待校验
			token.setAccessToken(accessToken);
			token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
			token.setSecret(secret);
			accessTokenMapper.insert(token);
			return accessToken;
		}
		if(Long.valueOf(token.getValidTime()) > System.currentTimeMillis()) {
			return token.getAccessToken();
		}
		token.setCorpid(corpid);
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
		String accessToken = HttpClientUtils.get(url);
		token.setAccessToken(accessToken);
		token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
		accessTokenMapper.updateByPrimaryKey(token);
		return accessToken;
	}
	

}
