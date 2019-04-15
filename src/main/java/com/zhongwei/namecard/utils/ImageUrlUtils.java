package com.zhongwei.namecard.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zhongwei.namecard.miniapp.config.WxMaProperties;

@Service
public class ImageUrlUtils {
	
	@Autowired
	private WxMaProperties properties;
	
	@Autowired
	private static WxMaProperties wxMaProperties;
	
	
	@PostConstruct
    public void init() {
		wxMaProperties = properties;
    }
	
//	public static final String URL_PREFIX = "http://localhost:8080/";
	
	public static String getAbsolutelyURL(String relativeUrl) {
		
		return wxMaProperties.getProjectRootPath() + relativeUrl.trim();
	}
	
	public static String[] unserialize(String str) {
		if(str.startsWith("[")) {
			str.replaceAll("\\[", "").replaceAll("\\]", "");
		}
		if(!StringUtils.hasText(str)) {
			return new String[0];
		}
		str = str.substring(1, str.length() -1);
		String arr[] = str.split(",");
		String arr2[] = new String[arr.length];
		for(int i = 0; i< arr.length; i++) {
			arr2[i] = arr[i].trim();
		}
		return arr2;
	}

}
