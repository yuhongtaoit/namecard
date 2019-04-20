package com.zhongwei.namecard.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.AccessTokenMapper;
import com.zhongwei.namecard.dao.AccountTokenMapper;
import com.zhongwei.namecard.dao.CardTicketMapper;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.AccessToken;
import com.zhongwei.namecard.entity.AccountToken;
import com.zhongwei.namecard.entity.CardTicket;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;

import net.sf.json.JSONObject;

@Service
public class QySendUtils {
	
	private static Logger log = LoggerFactory.getLogger(QySendUtils.class);
	
	@Autowired
	private SetQYMapper qYMapper;
	
	@Autowired
	private  AccessTokenMapper tokenMapper;
	
	@Autowired
	private AccountTokenMapper atMapper;
	
	@Autowired
	private CardTicketMapper cardTicketMapper;
	
	private static SetQYMapper setQYMapper;
	
	private static AccessTokenMapper accessTokenMapper;
	
	private static AccountTokenMapper accountTokenMapper;
	
	private static CardTicketMapper ticketMapper;
	
	@PostConstruct
    public void init() {
		setQYMapper = qYMapper;
		accessTokenMapper = tokenMapper;
		accountTokenMapper = atMapper;
		ticketMapper = cardTicketMapper;
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
		
		String token = getAccessToken(setQy.getCorpid(), setQy.getSecret(), setQy.getUniacid());
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
	
	/**
	 * CorpID是企业号的标识，每个企业号拥有一个唯一的CorpID；Secret是管理组凭证密钥。
	 * @param corpid
	 * @param secret
	 * @return
	 */
	public static String getAccessToken(String corpid, String secret,int uniacid) {
		AccessToken token = accessTokenMapper.selectByPrimaryKey(secret);
		if(token == null) {
			token = new AccessToken();
			token.setCorpid(corpid);
			String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
			String accessToken = "";
			JSONObject json = HttpClientUtils.get(url);
			accessToken = json.getString("access_token");
			token.setAccessToken(accessToken);
			token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
			token.setSecret(secret);
			token.setUniacid(uniacid);
			accessTokenMapper.insert(token);
			return accessToken;
		}
		if(Long.valueOf(token.getValidTime()) > System.currentTimeMillis()) {
			return token.getAccessToken();
		}
		ticketMapper.deleteByPrimaryKey(token.getAccessToken());
		token.setCorpid(corpid);
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
		String accessToken = "";
		JSONObject json = HttpClientUtils.get(url);
		accessToken = json.getString("access_token");
		token.setAccessToken(accessToken);
		token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
		accessTokenMapper.updateByPrimaryKey(token);
		return accessToken;
	}
	
	/**
	 * appid小程序唯一凭证，每个企业号拥有一个唯一的appid；Secret小程序唯一凭证密钥，即 AppSecret，获取方式同 appid
	 * @param appid 小程序唯一凭证，即 AppID，可在「微信公众平台 - 设置 - 开发设置」页中获得
	 * @param secret
	 * @return
	 */
	public static String getAccountToken(String appid, String secret,int uniacid) {
		AccountToken token = accountTokenMapper.selectByPrimaryKey(secret);
		if(token == null) {
			token = new AccountToken();
			token.setAppid(appid);
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
			String accessToken = "";
			JSONObject json = HttpClientUtils.get(url);
			accessToken = json.getString("access_token");
			token.setAccessToken(accessToken);
			token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
			token.setSecret(secret);
			token.setUniacid(uniacid);
			accountTokenMapper.insert(token);
			return accessToken;
		}
		if(Long.valueOf(token.getValidTime()) > System.currentTimeMillis()) {
			return token.getAccessToken();
		}
		token.setAppid(appid);
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
		String accessToken = "";
		JSONObject json = HttpClientUtils.get(url);
		accessToken = json.getString("access_token");
		token.setAccessToken(accessToken);
		token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
		accountTokenMapper.updateByPrimaryKey(token);
		return accessToken;
	}
	
	public static String getqyJsapiTicket(String corpid, String secret, String accessToken,int uniacid) {
		CardTicket ticket = ticketMapper.selectByPrimaryKey(accessToken);
		if(ticket == null) {
			ticket = new CardTicket();
			ticket.setUniacid(uniacid);
			ticket.setAccessToken(accessToken);
			ticket.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
			String url = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=" + accessToken;
			String ticketStr = "";
			JSONObject json = HttpClientUtils.get(url);
			try {
				ticketStr = json.getString("ticket");
			} catch (Exception e) {
				ticketMapper.deleteByPrimaryKey(accessToken);
				AccessToken token = accessTokenMapper.selectByPrimaryKey(secret);
				token.setCorpid(corpid);
				String u1 = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
				String aToken = "";
				json = HttpClientUtils.get(u1);
				accessToken = json.getString("access_token");
				token.setAccessToken(aToken);
				token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
				accessTokenMapper.updateByPrimaryKey(token);
				url = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=" + accessToken;
				ticketStr = "";
				json = HttpClientUtils.get(url);
				ticketStr = json.getString("ticket");
			}
			ticket.setTicket(ticketStr);
			ticketMapper.insert(ticket);
			return ticketStr;
		}
		if(Long.valueOf(ticket.getValidTime()) > System.currentTimeMillis()) {
			return ticket.getTicket();
		}
		ticket.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
		String url = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=" + accessToken;
		String ticketStr = "";
		JSONObject json = HttpClientUtils.get(url);//******待校验
		try {
			//token 失效，重新获取
			ticketStr = json.getString("ticket");
		} catch (Exception e) {
			ticketMapper.deleteByPrimaryKey(accessToken);
			AccessToken token = accessTokenMapper.selectByPrimaryKey(secret);
			token.setCorpid(corpid);
			String u1 = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
			String aToken = "";
			json = HttpClientUtils.get(u1);
			accessToken = json.getString("access_token");
			token.setAccessToken(aToken);
			token.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
			accessTokenMapper.updateByPrimaryKey(token);
			url = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=" + accessToken;
			ticketStr = "";
			json = HttpClientUtils.get(url);
			ticketStr = json.getString("ticket");
			
			ticket = new CardTicket();
			ticket.setUniacid(uniacid);
			ticket.setAccessToken(accessToken);
			ticket.setValidTime(String.valueOf(System.currentTimeMillis() + 7000*1000));
			ticket.setTicket(ticketStr);
			ticketMapper.insert(ticket);
			return null;
		}
		ticket.setTicket(ticketStr);
		ticketMapper.updateByPrimaryKey(ticket);
		return null;
	}
	
	public static Map<String, Object> addSign(String corpid, String ticket, String url){
		Map<String, Object> result = new HashMap<String, Object>();
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String nonce_str =  UUID.randomUUID().toString();
		String string1;
		String signature = "";
		string1 = "jsapi_ticket=" + ticket +
					"&noncestr=" + nonce_str +
					"&timestamp=" + timestamp +
					"&url=" + url;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("url", url);
		result.put("nonceStr", nonce_str);
		result.put("timestamp", timestamp);
		result.put("signature", signature);
		result.put("appId", corpid);
		return result;
	}
	

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash){
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	
}
