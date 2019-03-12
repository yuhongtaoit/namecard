package com.zhongwei.namecard.miniapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.ShopsAddressMapper;
import com.zhongwei.namecard.entity.ShopsAddress;
import com.zhongwei.namecard.entity.ShopsAddressExample;

@RestController
@RequestMapping("/miniapp")
public class FriendAddressController {
	
	@Autowired
	private ShopsAddressMapper shopsAddressMapper;
	
	@RequestMapping("/defaultAddress")
	public Map<String, Object> defaultAddress(int uniacid, String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		ShopsAddressExample shopsAddressExample = new ShopsAddressExample();
		shopsAddressExample.createCriteria().andUniacidEqualTo(uniacid);
		List<ShopsAddress> list = new ArrayList<ShopsAddress>();
		ShopsAddress shopsAddress = new ShopsAddress();
		list = shopsAddressMapper.selectByExampleWithBLOBs(shopsAddressExample);
		if(list.size() > 0) {
			shopsAddress = list.get(0);
			data.put("error", 0);
		}else {
			data.put("error", 1);
		}
		data.put("info", shopsAddress);
		result.put("data", data);
		return result;
	}
	

}
