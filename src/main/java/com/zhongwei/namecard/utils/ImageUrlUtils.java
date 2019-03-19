package com.zhongwei.namecard.utils;

public class ImageUrlUtils {
	
	public static final String URL_PREFIX = "";
	
	public static String getAbsolutelyURL(String relativeUrl) {
		
		return URL_PREFIX + relativeUrl;
	}
	
	public static String[] unserialize(String str) {
		return str.split(",");
	}

}
