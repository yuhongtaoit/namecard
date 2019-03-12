package com.zhongwei.namecard.miniapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.miniapp.dao.ShopsAddressMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.ShopsAddress;
import com.zhongwei.namecard.miniapp.model.ShopsAddressExample;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class AddressController {

	@Autowired
	private ShopsAddressMapper addressMapper;
	
	@RequestMapping("/addressList")
	public Map<String, Object> addressList(int uniacid, String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		
		List<ShopsAddress> list = new ArrayList<ShopsAddress>();
		ShopsAddressExample addressExample = new ShopsAddressExample();
		addressExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId);
		addressExample.setOrderByClause("id DESC");
		list = addressMapper.selectByExampleWithBLOBs(addressExample);
		result.put("data", list);
		return result;
	}
	
	@RequestMapping("/setAddress")
	public Map<String, Object> setAddress(int uniacid, String sessionId,Integer address_id, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		int error = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		if(address_id == null) {
			data.put("errno", errno);
			result.put("data", data);
			return result;
		}
		int update = 0;
		ShopsAddress find = addressMapper.selectByPrimaryKey(address_id);
		if(find.getIsStatus() > 0) {
			find.setIsStatus(0);
			update = addressMapper.updateByPrimaryKey(find);
		}else {
			find.setIsStatus(1);
			update = addressMapper.updateByPrimaryKey(find);
		}
		if(update > 0) {
			error = 0;
		}else {
			error = 1;
		}
		data.put("info", find);
		data.put("info_is_status", find.getIsStatus());
		data.put("error", error);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/delAddress")
	public Map<String, Object> delAddress(int uniacid, String sessionId, Integer address_id, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(address_id == null) {
			data.put("errno", errno);
			result.put("data", data);
			return result;
		}
		
		int del = addressMapper.deleteByPrimaryKey(address_id);
		if(del > 0) {
			errno = 0;
		}else {
			errno = 1;
		}
		data.put("errno", errno);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/addAddress")
	public Map<String, Object> addAddress(int uniacid, String sessionId ,String userName, String telNumber, String provinceName,
			String cityName, String countyName, String detailInfo, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		ShopsAddress address = new ShopsAddress();
		address.setUniacid(uniacid);
		address.setOpenid(user.getOpenid());
		address.setNickname(user.getNickname() == null ? "" : user.getNickname());
		address.setPhone("");
		address.setGender(user.getGender());
		address.setName("");
		address.setCity(user.getCity() == null ? "" : user.getCity());
		address.setProvince(user.getProvince() == null ? "" : user.getProvince());
		address.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
		address.setAvatarUrl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
		address.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
		address.setAddtime(String.valueOf(System.currentTimeMillis()));
		address.setUpdatetime("");
		address.setUsername(userName);
		address.setTelNumber(telNumber);
		address.setProvinceName(provinceName);
		address.setCityName(cityName);
		address.setDetailInfo(detailInfo);
		int insert = addressMapper.insert(address);
		if(insert > 0) {
			data.put("error", 0);
		}else {
			data.put("error", address);
		}
		result.put("data", data);
		return result;
	}
}
