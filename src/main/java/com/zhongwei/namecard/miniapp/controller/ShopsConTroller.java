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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.dao.ShopsOrderMapper;
import com.zhongwei.namecard.dao.ShopsSpecMapper;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;
import com.zhongwei.namecard.entity.ShopsOrder;
import com.zhongwei.namecard.entity.ShopsOrderExample;
import com.zhongwei.namecard.entity.ShopsSpec;
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.utils.DataUtils;
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
	private WxMaProperties wxMaProperties;
	
	private int pageSize = 8;//每页大小
	
	private int pageNo = 1;//第几页，初始值为1
	
	@Autowired
	public ShopsConTroller(WxPayService wxPayService) {
	    this.wxPayService = wxPayService;
	}
	
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
		Map<String, Object> shopMap = shops.shopsToMap(shops);
		if(shopsList.size() > 0) {
			shops = shopsList.get(0);
			shopMap.put("gimg", ImageUrlUtils.getAbsolutelyURL(shops.getGimg()));
			ShopsSpec shopsSpec = shopsSpecMapper.selectByPrimaryKey(shops.getSpecid());
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
		PageHelper.startPage(pindex, pageSize);
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
		
		shopsExample = new CardShopsExample();
		shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1);
		int total = cardShopsMapper.countByExample(shopsExample);
		data.put("shops", shopsMapList);
		data.put("total", total);
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
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		//******未完待续
		WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
		orderRequest.setBody("支付内容的说明");
		orderRequest.setAttach("众维广告有限公司");
		orderRequest.setOutTradeNo("nicecard"+ DataUtils.getCurrTime());
		orderRequest.setOpenid(openId);
		BigDecimal shopNum = new BigDecimal(shops_num);
//		orderRequest.setTotalFee(shopInfo.getPrice().multiply(shopNum));
		orderRequest.setTotalFee(BaseWxPayRequest.yuanToFen(shopInfo.getPrice().multiply(shopNum).toString()));
		orderRequest.setSpbillCreateIp("197.32.4.9");///******必填 APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
		orderRequest.setSignType("MD5");
		orderRequest.setDeviceInfo("WEB");
		orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
		orderRequest.setNotifyUrl("");//******接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
//		orderRequest.setSubOpenid("");//trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。
		Object obj = wxPayService.createOrder(orderRequest);
		result.put("data", data);
		return result;
	}
	
	public void receivePayCallBack() {
		
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
				shops.setGimg(ImageUrlUtils.getAbsolutelyURL(order.getShops().getGimg()));
				order.setShops(shops);
				order.setDateline(DataUtils.millisToString(order.getAddtime()));
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
				shops2 = cardShopsMapper.selectByExampleWithBLOBs(cardShopsExample);
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

}
