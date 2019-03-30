package com.zhongwei.namecard.utils;

import org.springframework.util.StringUtils;

public class ImageUrlUtils {
	
	public static final String URL_PREFIX = "http://localhost:8080/";
	
	public static String getAbsolutelyURL(String relativeUrl) {
		
		return URL_PREFIX + relativeUrl;
	}
	
	public static String[] unserialize(String str) {
		if(str.startsWith("[")) {
			str.replaceAll("\\[", "").replaceAll("\\]", "");
		}
		if(!StringUtils.hasText(str)) {
			return new String[0];
		}
		str = str.substring(1, str.length() -1);
		return str.split(",");
	}

}
