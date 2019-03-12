package com.zhongwei.namecard.utils;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StrUtils {
	
	public static String cutStr(String str, int length, boolean havedot) {
		
		if(StringUtils.hasText(str)) {
			return "";
		}
		if(str.length() <= length) {
			return str;
		}
		
		if(havedot) {
			return str.substring(0, length) + "...";
		}
		return str.substring(0, length);
	}

}
