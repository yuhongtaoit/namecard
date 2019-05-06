package com.zhongwei.namecard.miniapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.dao.AccountWxappMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.dao.SetFxMapper;
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.dao.ShopsOrderMapper;
import com.zhongwei.namecard.dao.ShopsSpecMapper;
import com.zhongwei.namecard.dao.PaySetMapper;
import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.SetFx;
import com.zhongwei.namecard.entity.SetFxExample;
import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;
import com.zhongwei.namecard.entity.ShopsOrder;
import com.zhongwei.namecard.entity.ShopsOrderExample;
import com.zhongwei.namecard.entity.ShopsSpec;
import com.zhongwei.namecard.entity.PaySet;
import com.zhongwei.namecard.entity.PaySetExample;
import com.zhongwei.namecard.utils.DateUtils;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class ShopsConTroller {
	
	@Autowired
	private CardShopsMapper cardShopsMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private ShopsSpecMapper shopsSpecMapper;
	
	@Autowired
	private ShopsOrderMapper shopsOrderMapper;
	
	@Autowired
	private ShopsCategoryMapper categoryMapper;
	
//	@Autowired
	private WxPayService wxPayService;
	
	@Autowired
	private SetFxMapper setFxMapper;
	
	@Autowired
	private AccountWxappMapper accountMapper;
	
	@Autowired
	private PaySetMapper paySetMapper;
	
	private int pageSize = 8;//每页大小
	
	private int pageNo = 1;//第几页，初始值为1
	
//	@Autowired
//	public ShopsConTroller(WxPayService wxPayService) {
//	    this.wxPayService = wxPayService;
//	}
//	
	@RequestMapping("/shopsDetail")
	public Map<String, Object> shopsDetail(int uniacid, Integer shops_id, Integer card_id,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		int isAuthorize = 0;
		if(shops_id == null) 
			shops_id = 0;
		if(card_id == null) 
			card_id = 0;
		
		CardMember cardMember = new CardMember();
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		String nickname = user.getNickname();
		List<CardMember> memberList = new ArrayList<CardMember>();
		if(!StringUtils.hasText(openId) || !StringUtils.hasText(nickname)) {
			isAuthorize = 0;
		}else {
			isAuthorize = 1;
			CardMemberExample memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andAidEqualTo(card_id);
			memberList = cardMemberMapper.selectByExample(memberExample);
			cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
		}
		
		List<CardShopsWithBLOBs> shopsList = new ArrayList<CardShopsWithBLOBs>();
		CardShopsWithBLOBs shops = new CardShopsWithBLOBs(); 
		CardShopsExample shopsExample = new CardShopsExample();
		shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1).andIdEqualTo(shops_id);
		shopsList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
		Map<String, Object> shopMap = new HashMap<String, Object>();
		if(shopsList.size() > 0) {
			shops = shopsList.get(0);
			shopMap = shops.shopsToMap(shops);
			shopMap.put("gimg", ImageUrlUtils.getAbsolutelyURL(shops.getGimg()));
			ShopsSpec shopsSpec = shopsSpecMapper.selectByPrimaryKey(shops.getSpecid());
			if(shopsSpec != null) {
				Map<String, Object> specMap = shopsSpec.specToMap(shopsSpec);
				String[] contents = ImageUrlUtils.unserialize(shopsSpec.getSpecContent());
				specMap.put("specContent", contents);
				List<Map<String, Object>> newSpec = new ArrayList<Map<String, Object>>();
				if(StringUtils.hasText(shopsSpec.getSpecContent())) {
					for(String str : contents) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("specContent", str);
						newSpec.add(map);
					}
				}
				specMap.put("newSpec", newSpec);
				shopMap.put("spec", specMap);
			}
			if(StringUtils.hasText(shops.getCpBsImg())) {
				String[] imgArray = ImageUrlUtils.unserialize(shops.getCpBsImg());
				if(imgArray.length > 0) {
					for(int i = 0; i< imgArray.length; i++) {
						imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
					}
				}
				shopMap.put("cpBsImg", imgArray);
			}
			if(StringUtils.hasText(shops.getTopPic())) {
				String[] imgArray = ImageUrlUtils.unserialize(shops.getTopPic());
				if(imgArray.length > 0) {
					for(int i = 0; i< imgArray.length; i++) {
						imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
					}
				}
				shopMap.put("topPic", imgArray);
			}
		}
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		card.setCardLogo(ImageUrlUtils.getAbsolutelyURL(card.getCardLogo()));
		int showUser = 0;
		if(memberList.size() > 0) {
			showUser = 0;
		}else {
			showUser = 1;
		}
		
		data.put("message", message);
		data.put("errno", errno);
		data.put("isAuthorize", isAuthorize);
		data.put("showUser", showUser);
		data.put("shops", shopMap);
		data.put("member", cardMember);
		data.put("card", card);
		data.put("openid", openId);
		data.put("userinfo", user);
		
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/getMoreshops")
	public Map<String, Object> getMoreshops(int uniacid, Integer card_id, Integer classifyCode, Integer pindex,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		if(classifyCode == null) 
			classifyCode = 0;
		if(pindex == null) 
			pindex = 0;
		
		if(pindex<1)
			pindex = pageNo;
		
		List<CardShopsWithBLOBs> shopList = new ArrayList<CardShopsWithBLOBs>();
		CardShopsExample shopsExample = new CardShopsExample();
		Page page = PageHelper.startPage(pindex, pageSize);
		if(classifyCode > 0) {
			shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1).andTypeidEqualTo(classifyCode);
			shopsExample.setOrderByClause("sort DESC");
			shopList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
		}else {
			shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1);
			shopsExample.setOrderByClause("sort DESC");
			shopList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
		}
		List<Map<String, Object>> shopsMapList = new ArrayList<Map<String, Object>>();
		if(shopList.size() > 0) {
			Map<String, Object> map = null;
			for(CardShopsWithBLOBs shop : shopList) {
				map = new HashMap<String, Object>();
				map = shop.shopsToMap(shop);
				map.put("gimg", ImageUrlUtils.getAbsolutelyURL(shop.getGimg()));
				if(StringUtils.hasText(shop.getCpBsImg())) {
					String[] imgArray = ImageUrlUtils.unserialize(shop.getCpBsImg());
					if(imgArray.length > 0) {
						for(int i = 0; i< imgArray.length; i++) {
							imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
						}
					}
					map.put("cpBsImg", imgArray);
				}
				if(StringUtils.hasText(shop.getTopPic())) {
					String[] imgArray = ImageUrlUtils.unserialize(shop.getTopPic());
					if(imgArray.length > 0) {
						for(int i = 0; i< imgArray.length; i++) {
							imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
						}
					}
					map.put("topPic", imgArray);
				}
				shopsMapList.add(map);
			}
		}
		
		data.put("shops", shopsMapList);
		data.put("total", page.getTotal());
		result.put("data", data);
		return result;
	}
	@RequestMapping("/shopsGetClass")
	public Map<String, Object> shopsGetClass(int uniacid, Integer card_id, Integer classifyCode, 
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		if(classifyCode == null) 
			classifyCode = 0;
		
		List<CardShopsWithBLOBs> shopList = new ArrayList<CardShopsWithBLOBs>();
		CardShopsExample shopsExample = new CardShopsExample();
		PageHelper.startPage(pageNo, pageSize);
		if(classifyCode > 0) {
			shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1).andTypeidEqualTo(classifyCode);
			shopsExample.setOrderByClause("sort DESC");
			shopList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
		}else {
			shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1);
			shopsExample.setOrderByClause("sort DESC");
			shopList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
		}
		List<Map<String, Object>> shopsMapList = new ArrayList<Map<String, Object>>();
		if(shopList.size() > 0) {
			Map<String, Object> map = null;
			for(CardShopsWithBLOBs shop : shopList) {
				map = new HashMap<String, Object>();
				map = shop.shopsToMap(shop);
				map.put("gimg", ImageUrlUtils.getAbsolutelyURL(shop.getGimg()));
				if(StringUtils.hasText(shop.getCpBsImg())) {
					String[] imgArray = ImageUrlUtils.unserialize(shop.getCpBsImg());
					if(imgArray.length > 0) {
						for(int i = 0; i< imgArray.length; i++) {
							imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
						}
					}
					map.put("cpBsImg", imgArray);
				}
				if(StringUtils.hasText(shop.getTopPic())) {
					String[] imgArray = ImageUrlUtils.unserialize(shop.getTopPic());
					if(imgArray.length > 0) {
						for(int i = 0; i< imgArray.length; i++) {
							imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
						}
					}
					map.put("topPic", imgArray);
				}
				shopsMapList.add(map);
			}
		}
		
		data.put("shops", shopsMapList);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/shopsTopay")
	public Map<String, Object> shopsTopay(int uniacid, String phone, String name, String address, Integer card_id,
			Integer shops_id,Integer shops_num, String new_spec,String sessionId, HttpServletRequest request) throws WxPayException{
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		data.put("error", errno);
		if(shops_id == null) {
			data.put("message", "缺少商品id");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(card_id == null) 
			card_id = 0;
		if(shops_num == null) 
			shops_num = 0;
		CardShopsWithBLOBs shopInfo = cardShopsMapper.selectByPrimaryKey(shops_id);
		if(shopInfo == null) {
			data.put("message", "不存在的商品");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(shopInfo.getShopsNum() <= 0) {
			data.put("message", "无库存");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(shopInfo.getIsShow() < 1) {
			data.put("message", "商品已经下架");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(shops_num == 0) {
			data.put("message", "购买数量不能为空");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(!StringUtils.hasText(address)) {
			data.put("message", "请填写地址");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(!StringUtils.hasText(name)) {
			data.put("message", "请填写姓名");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(!StringUtils.hasText(phone)) {
			data.put("message", "请填写电话");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		BigDecimal b = new BigDecimal (0);
		if(shopInfo.getPrice().compareTo(b) == -1) {
			data.put("message", "金额不得少于0.01");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		if(card_id == 0) {
			data.put("message", "缺少名片id");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		
		String orderId= "nicecard"+ DateUtils.getCurrTime();
		//******未完待续
		WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
		orderRequest.setBody("微信支付");
		orderRequest.setAttach("众维广告有限公司");
		orderRequest.setOutTradeNo(orderId);
		orderRequest.setOpenid(openId);//trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。
		BigDecimal shopNum = new BigDecimal(shops_num);
//		orderRequest.setTotalFee(shopInfo.getPrice().multiply(shopNum));
		orderRequest.setTotalFee(BaseWxPayRequest.yuanToFen(shopInfo.getPrice().multiply(shopNum).toString()));
		orderRequest.setSpbillCreateIp(request.getRemoteAddr());///******必填 APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
		orderRequest.setSignType("MD5");
		orderRequest.setDeviceInfo("WEB");
		orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
		orderRequest.setNotifyUrl("http://192.168.43.210:8080/miniapp/payResult");//******接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
//		orderRequest.setSubOpenid(openId);//trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。
		wxPayService = getWxService(uniacid);
		WxPayMpOrderResult payResult = wxPayService.createOrder(orderRequest);
		data.put("timeStamp", payResult.getTimeStamp());
		data.put("nonceStr", payResult.getNonceStr());
		data.put("package", payResult.getPackageValue());
		data.put("paySign", payResult.getPaySign());
		
		ShopsOrder order = new ShopsOrder();
		order.setPrice(shopInfo.getPrice());
		order.setAllPrice(shopInfo.getPrice().multiply(new BigDecimal(shops_num)));
		order.setUniacid(uniacid);
		order.setShopName(shopInfo.getShopName());
		order.setFromUser(openId);
		order.setName(name);
		order.setPhone(phone);
		order.setShopsId(shopInfo.getId());
		order.setShopsNum(shops_num);
		order.setAddress(address);
		order.setCardId(card_id);
		order.setNewSpec(new_spec);
		order.setAddtime(String.valueOf(System.currentTimeMillis()));
		order.setOrderid(orderId);
		order.setStaffid(0);
		order.setTransactionId("");
		order.setPaid(0);
		order.setNickname(user.getNickname());
		order.setTpText("");
		order.setShareid(0);
		order.setTid(0);
		order.setHxstatus(0);
		order.setHxname("0");
		order.setAvatar(user.getAvatar());
		int insert = shopsOrderMapper.insert(order);
		if(insert == 0) {
			data.put("message", "数据录入失败");
			data.put("error", 1);
			result.put("data", data);
			return result;
		}
		data.put("orderid", orderId);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/payResult")
	public void payResult(@RequestBody String xmlData,HttpServletRequest request, String return_code,Map<String, Object> resultMap) throws WxPayException {
//		wxPayService = getWxService(uniacid); ****** 判断wxPayService是否有值
		WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(xmlData);
		System.out.println(notifyResult);
		if(return_code.equals("SUCCESS")) {
			String orderId = (String) resultMap.get("out_trade_no");
			String openId = (String) resultMap.get("openid");
			List<ShopsOrder> orderList = new ArrayList<ShopsOrder>();
			ShopsOrderExample orderExample = new ShopsOrderExample();
			orderExample.createCriteria().andOrderidEqualTo(orderId).andPaidEqualTo(0).andFromUserEqualTo(openId);
			orderList = shopsOrderMapper.selectByExampleWithBLOBs(orderExample);
			if(orderList.size() > 0) {
				ShopsOrder order = orderList.get(0);
				order.setPaid(1);
				order.setTransactionId((String) resultMap.get("transaction_id"));
				shopsOrderMapper.updateByPrimaryKey(order);
				CardShopsWithBLOBs cardShop = cardShopsMapper.selectByPrimaryKey(order.getShopsId());
				cardShop.setShopsNum(cardShop.getShopsNum() - order.getShopsNum());
				if(cardShop.getFxType() == 2) {
					if(cardShop.getPrice().multiply(new BigDecimal(100)).compareTo(new BigDecimal(1)) != -1) {
						CardMemberExample cardMemberExample = new CardMemberExample();
						cardMemberExample.createCriteria().andAidEqualTo(order.getCardId()).andOpenidEqualTo(openId);
						List<CardMember> memberList = cardMemberMapper.selectByExample(cardMemberExample);
						if(memberList.size() > 0) {
							CardMember cardMember = memberList.get(0);
							if(cardMember.getHmdStatus() == 0) {
								if(cardMember.getSourceId() > 0) {
									CardMember member = cardMemberMapper.selectByPrimaryKey(cardMember.getSourceId());
									if(member != null) {
										member.setNotInAccount(member.getNotInAccount().add(cardShop.getFxPrice()));
										cardMemberMapper.updateByPrimaryKey(member);
									}
								}
							}
						}
					}
				}else if(cardShop.getFxType() == 1) {
					SetFxExample fxExample = new SetFxExample();
					fxExample.createCriteria().andUniacidEqualTo(cardShop.getUniacid());
					List<SetFx> fxList = setFxMapper.selectByExample(fxExample);
					if(fxList.size() > 0) {
						SetFx setFx = fxList.get(0);
						if(setFx.getOpenFx() > 0) {
							if(setFx.getFxPrice().multiply(new BigDecimal(100)).compareTo(new BigDecimal(1)) != -1) {
								CardMemberExample cardMemberExample = new CardMemberExample();
								cardMemberExample.createCriteria().andAidEqualTo(order.getCardId()).andOpenidEqualTo(openId);
								List<CardMember> memberList = cardMemberMapper.selectByExample(cardMemberExample);
								if(memberList.size() > 0) {
									CardMember cardMember = memberList.get(0);
									if(cardMember.getHmdStatus() == 0) {
										if(cardMember.getSourceId() > 0) {
											CardMember member = cardMemberMapper.selectByPrimaryKey(cardMember.getSourceId());
											if(member != null) {
												member.setNotInAccount(member.getNotInAccount().add(new BigDecimal(setFx.getOpenFx())));
												cardMemberMapper.updateByPrimaryKey(member);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@RequestMapping("/shopsOrderList")
	public Map<String, Object> shopsOrderList(int uniacid, Integer card_id,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("error", 1);
		
		if(card_id == null) {
			data.put("message", "缺少名片id");
			data.put("errno", 1);
			result.put("data", data);
			return result;
		}
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		List<ShopsOrder> orderList = new ArrayList<ShopsOrder>();
		ShopsOrderExample orderExample = new ShopsOrderExample();
		orderExample.createCriteria().andUniacidEqualTo(uniacid).andCardIdEqualTo(card_id).andPaidEqualTo(1).andFromUserEqualTo(openId);
		orderExample.setOrderByClause("id DESC");
		orderList = shopsOrderMapper.selectByExampleWithBLOBs(orderExample);
		if(orderList.size() > 0) {
			for(ShopsOrder order : orderList) {
				CardShopsWithBLOBs shops = cardShopsMapper.selectByPrimaryKey(order.getCardId());
				order.setShops(shops);
				shops.setGimg(ImageUrlUtils.getAbsolutelyURL(order.getShops().getGimg()));
				order.setDateline(DateUtils.millisToString(new Long(order.getAddtime())));
			}
		}
		result.put("data", orderList);
		return result;
	}
	
	@RequestMapping("/shopsAllClass")
	public Map<String, Object> shopsAllClass(int uniacid, Integer card_id,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		List<Map<String, Object>> dataAll = new ArrayList<Map<String, Object>>();
		List<ShopsCategory> titles = new ArrayList<ShopsCategory>();
		ShopsCategoryExample categoryExample = new ShopsCategoryExample();
		categoryExample.createCriteria().andUniacidEqualTo(uniacid).andParentidEqualTo(0).andEnabledEqualTo(1);
		categoryExample.setOrderByClause("sort DESC");
		titles = categoryMapper.selectByExample(categoryExample);
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("title", "全部产品");
		map0.put("id", 0);
		List<CardShopsWithBLOBs> shops = new ArrayList<CardShopsWithBLOBs>();
		CardShopsExample cardShopsExample = new CardShopsExample();
		cardShopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1);
		cardShopsExample.setOrderByClause("sort DESC");
		shops = cardShopsMapper.selectByExampleWithBLOBs(cardShopsExample);
		if(shops.size() > 0) {
			for(CardShopsWithBLOBs shop : shops) {
				shop.setGimg(ImageUrlUtils.getAbsolutelyURL(shop.getGimg()));
			}
		}
		map0.put("childClassify", shops);
		dataAll.add(map0);
		
		if(titles.size() > 0) {
			for(int i = 0; i < titles.size(); i++) {
				List<CardShopsWithBLOBs> shops2 = new ArrayList<CardShopsWithBLOBs>();
				CardShopsExample cardShopsExample2 = new CardShopsExample();
				cardShopsExample2.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1).andTypeidEqualTo(titles.get(i).getId());
				cardShopsExample2.setOrderByClause("sort DESC");
				shops2 = cardShopsMapper.selectByExampleWithBLOBs(cardShopsExample2);
				if(shops2.size() > 0) {
					for(CardShopsWithBLOBs shop : shops2) {
						shop.setGimg(ImageUrlUtils.getAbsolutelyURL(shop.getGimg()));
					}
				}
				map0 = new HashMap<String, Object>();
				map0.put("title", titles.get(i).getTitle());
				map0.put("id", titles.get(i).getId());
				map0.put("childClassify", shops2);
				dataAll.add(map0);
			}
		}
		data.put("data_all", dataAll);
		data.put("card_id", card_id);
		result.put("data", data);
		return result;
	}
	
	private WxPayService getWxService( int uniacid) {
        WxPayConfig payConfig = new WxPayConfig();
        AccountWxapp account = accountMapper.selectByPrimaryKey(uniacid);
        String appid = account.getKey();
        List<PaySet> setList = new ArrayList<PaySet>();
        PaySetExample paySetExample = new PaySetExample();
        paySetExample.createCriteria().andUniacidEqualTo(uniacid);
        setList = paySetMapper.selectByExample(paySetExample);
        PaySet paySet = setList.size() > 0 ? setList.get(0) : new PaySet();
        payConfig.setAppId(org.apache.commons.lang3.StringUtils.trimToNull(appid));
        payConfig.setMchId(org.apache.commons.lang3.StringUtils.trimToNull(paySet.getMchid()));
        payConfig.setMchKey(org.apache.commons.lang3.StringUtils.trimToNull(paySet.getMchkey()));
//        payConfig.setSubAppId(org.apache.commons.lang3.StringUtils.trimToNull(paySet.getSubappid()));
//        payConfig.setSubMchId(org.apache.commons.lang3.StringUtils.trimToNull(paySet.getSubmchid()));
        payConfig.setKeyPath(org.apache.commons.lang3.StringUtils.trimToNull(ImageUrlUtils.getAbsolutelyURL(paySet.getCertpath())));

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

}
