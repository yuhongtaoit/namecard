package com.zhongwei.namecard.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.miniapp.dao.AuthUserMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.AuthUserExample;

@Component
public class UserUtils {
	
	private static AuthUserMapper authUserMapper;
	
	@Autowired
	public void setAuthUserMapper(AuthUserMapper authUserMapper) {
		UserUtils.authUserMapper = authUserMapper;
	}
	
	public static AuthUser getUserInfo(HttpServletRequest request,String sessionIdMD5) {
		AuthUser authUser = new AuthUser();
    	Object userinfoObj = request.getSession().getAttribute("userinfo");
    	if(userinfoObj != null) {
    		authUser = (AuthUser) userinfoObj;
    	}else {
    		AuthUserExample authUserExample = new AuthUserExample();
    		authUserExample.createCriteria().andSessionidEqualTo(sessionIdMD5);
    		List<AuthUser> userList = authUserMapper.selectByExample(authUserExample);
    		if(userList !=null && userList.size() > 0) {
    			authUser = userList.get(0);
    		}
    	}
		return authUser;
	}
	

}
