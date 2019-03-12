package com.zhongwei.namecard.miniapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.github.binarywang.demo.wx.miniapp.config.WxMaConfiguration;
//import com.github.binarywang.demo.wx.miniapp.utils.JsonUtils;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.miniapp.dao.AuthUserMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;

import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import me.chanjar.weixin.common.error.WxErrorException;

@RestController
@RequestMapping("/auth/session")
public class WxMaUserController {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 private WxMaProperties wxMaProperties;
	 
	 @Autowired
	 private AuthUserMapper authUserMapper;
	 
	 private final WxMaServiceImpl wxMaService = new WxMaServiceImpl();

	    /**
	     * 登陆接口
	     * @throws WxErrorException 
	     */
	    @GetMapping("/login")
	    public Map<String, Object> login(String code, HttpServletRequest request) throws WxErrorException {
	    	Map<String, Object> result = new HashMap<String, Object>();
	        if (!StringUtils.hasText(code)) {
	        	result.put("code", "error");
	        	result.put("msg", "empty jscode");
	            return result;
	        }
	        WxMaInMemoryConfig wxMaInMemoryConfig = new WxMaInMemoryConfig();
	        wxMaInMemoryConfig.setAppid(wxMaProperties.getAppid());
	        wxMaInMemoryConfig.setSecret(wxMaProperties.getSecret());
	        wxMaService.setWxMaConfig(wxMaInMemoryConfig);

	        WxMaJscode2SessionResult jscode2SessionResult = wxMaService.jsCode2SessionInfo(code);
//	        result.put("openid", jscode2SessionResult.getOpenid());
//	        result.put("sessionKey", jscode2SessionResult.getSessionKey());
	        HttpSession session = request.getSession();
	        String sessionId = request.getSession().getId();
	        String sessionKey = jscode2SessionResult.getSessionKey();
	        session.setAttribute("openId", jscode2SessionResult.getOpenid());
	        session.setAttribute("sessionKey", sessionKey);
	        result.put("sessionid", sessionId);
	        return result;
	    }

//	    @GetMapping("/userinfo")
//	    public String info(@PathVariable String appid, String sessionKey,
//	                       String signature, String rawData, String encryptedData, String iv) {
//	        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
//
//	        // 用户信息校验
//	        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
//	            return "user check failed";
//	        }
//
//	        // 解密用户信息
//	        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
//
//	        return JsonUtils.toJson(userInfo);
//	    }

	    /**
	     * <pre>
	     * 获取用户绑定手机号信息
	     * </pre>
	     */
//	    @GetMapping("/userinfo")
	    @PostMapping("/userinfo")
	    public Map<String, Object> getUserInfo(String signature, String rawData, String iv, int uniacid,
	                        String encryptedData,HttpServletRequest request) {
	    	Map<String, Object> result = new HashMap<String, Object>();
	        // 用户信息校验
//	        if (!wxMaService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
//	            return "user check failed";
//	        }
	    	
	    	String sessionid = request.getSession().getId();
	    	String sessionKey = (String) request.getSession().getAttribute("sessionKey");
	    	String openId = (String) request.getSession().getAttribute("openId");

	        // 解密
	        WxMaUserInfo wxMaUserInfo = wxMaService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
	        WxMaPhoneNumberInfo phoneNumberInfo = wxMaService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
	        
	        String sessionMD5 = DigestUtils.md5DigestAsHex((sessionid+sessionKey).getBytes());
        	AuthUser user = new AuthUser();
        	user.setSessionid(sessionMD5);
        	user.setOpenid(openId);
	        user.setUnionid(wxMaUserInfo.getUnionId()==null ? "" :wxMaUserInfo.getUnionId());
        	user.setAvatarurl(wxMaUserInfo.getAvatarUrl());
        	user.setAvatar(wxMaUserInfo.getAvatarUrl());
        	user.setCity(wxMaUserInfo.getCity()==null ? "" :wxMaUserInfo.getCity());
        	user.setCountry(wxMaUserInfo.getCountry()==null ? "" :wxMaUserInfo.getCountry());
        	user.setGender(wxMaUserInfo.getGender() == null ? 0 : Integer.valueOf(wxMaUserInfo.getGender()));
        	user.setLanguage(wxMaUserInfo.getLanguage() == null ? "" : wxMaUserInfo.getLanguage());
        	user.setNickname(wxMaUserInfo.getNickName() == null ? "" : wxMaUserInfo.getNickName());
        	user.setPhone(phoneNumberInfo.getPhoneNumber()==null ? "" :phoneNumberInfo.getPhoneNumber());
        	user.setProvince(wxMaUserInfo.getProvince()==null ? "" :wxMaUserInfo.getProvince());
        	user.setUniacid(uniacid);
        	authUserMapper.insert(user);
	        result.put("data", phoneNumberInfo.getPurePhoneNumber());
	        result.put("sessionid", sessionMD5);
	        System.out.println(phoneNumberInfo.getPhoneNumber()+"--"+sessionMD5);
	        return result;
	    }

}
