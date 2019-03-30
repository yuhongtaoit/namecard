package com.zhongwei.namecard.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.AccessTokenMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.AccessToken;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@Service
public class QySendUtils {
	
	private static Logger log = LoggerFactory.getLogger(QySendUtils.class);
	
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
	
	/**
	 * 微信企业号向指定成员发送消息。
	 * @param toUser
	 * @param content
	 */
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
			String accessToken = "";
			JSONObject json = HttpClientUtils.get(url);//******待校验
			accessToken = json.getString("accessToken");
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
		String accessToken = "";
		JSONObject json = HttpClientUtils.get(url);//******待校验
		accessToken = json.getString("accessToken");
		token.setAccessToken(accessToken);
		token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
		accessTokenMapper.updateByPrimaryKey(token);
		return accessToken;
	}
	
//	/**
//	 * 获取接口访问凭证
//	 * 
//	 * @param corpid 凭证
//	 * @param corpsecret 密钥
//	 * @return
//	 */
//	public static String getAccessToken(String corpid, String corpsecret) {
//		String access_token = "";
//		String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + corpsecret;
//		// 发起GET请求获取凭证
//		JSONObject jsonObject = HttpClientUtils.httpsRequest(requestUrl, "GET", null);
// 
//		if (null != jsonObject) {
//			try {
//				access_token = jsonObject.getString("access_token");
//			} catch (JSONException e) {
//				access_token = null;
//				// 获取token失败
//				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
//			}
//		}
//		return access_token;
//	}
	

}
