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
import com.zhongwei.namecard.miniapp.config.WxMaProperties;
import com.zhongwei.namecard.miniapp.dao.CardMapper;
import com.zhongwei.namecard.miniapp.dao.CardMemberMapper;
import com.zhongwei.namecard.miniapp.dao.CardShopsMapper;
import com.zhongwei.namecard.miniapp.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.miniapp.dao.ShopsOrderMapper;
import com.zhongwei.namecard.miniapp.dao.ShopsSpecMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.CardMember;
import com.zhongwei.namecard.miniapp.model.CardMemberExample;
import com.zhongwei.namecard.miniapp.model.CardShopsExample;
import com.zhongwei.namecard.miniapp.model.CardShopsWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardWithBLOBs;
import com.zhongwei.namecard.miniapp.model.ShopsCategory;
import com.zhongwei.namecard.miniapp.model.ShopsCategoryExample;
import com.zhongwei.namecard.miniapp.model.ShopsOrder;
import com.zhongwei.namecard.miniapp.model.ShopsOrderExample;
import com.zhongwei.namecard.miniapp.model.ShopsSpec;
import com.zhongwei.namecard.utils.DataUtils;
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
		if(shopsList.size() > 0) {
			shops = shopsList.get(0);
//			$shops["gimg"] = tomedia($shops["gimg"]);******
			ShopsSpec shopsSpec = shopsSpecMapper.selectByPrimaryKey(shops.getSpecid());
//			$spec["spec_content"] = unserialize($spec["spec_content"]); ******
//			if (!empty($spec["spec_content"])) {
//				foreach ($spec["spec_content"] as $key => $val) {
//					$spec["new_spec"][$key]["spec_content"] = $val;
//				}
//			}
			shops.setSpec(shopsSpec);
//			if ($shops["cp_bs_img"]) {
//				$shops["cp_bs_img"] = unserialize($shops["cp_bs_img"]);
//				if (!empty($shops["cp_bs_img"])) {
//					foreach ($shops["cp_bs_img"] as $key => $val) {
//						$shops["cp_bs_img"][$key] = tomedia($val);
//					}
//				}
//			}
//			if ($shops["top_pic"]) {
//				$shops["top_pic"] = unserialize($shops["top_pic"]);
//				if (!empty($shops["top_pic"])) {
//					foreach ($shops["top_pic"] as $key => $val) {
//						$shops["top_pic"][$key] = tomedia($val);
//					}
//				}
//			}
		}
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
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
		data.put("shops", shops);
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
		if(shopList.size() > 0) {
			//****** 反序列化及图片位置处理
//			$shops[$k]["gimg"] = tomedia($v["gimg"]);
//			if ($v["cp_bs_img"]) {
//				$shops[$k]["cp_bs_img"] = unserialize($v["cp_bs_img"]);
//				if (!empty($shops[$k]["cp_bs_img"])) {
//					foreach ($shops[$k]["cp_bs_img"] as $key => $val) {
//						$shops[$k]["cp_bs_img"][$key] = tomedia($val);
//					}
//				}
//			}
//			if ($v["top_pic"]) {
//				$shops[$k]["top_pic"] = unserialize($v["top_pic"]);
//				if (!empty($shops[$k]["top_pic"])) {
//					foreach ($shops[$k]["top_pic"] as $key => $val) {
//						$shops[$k]["top_pic"][$key] = tomedia($val);
//					}
//				}
//			}
		}
		
		shopsExample = new CardShopsExample();
		shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1);
		int total = cardShopsMapper.countByExample(shopsExample);
		data.put("shops", shopList);
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
		if(shopList.size() > 0) {
			//****** 反序列化及图片位置处理
//			$shops[$k]["gimg"] = tomedia($v["gimg"]);
//			if ($v["cp_bs_img"]) {
//				$shops[$k]["cp_bs_img"] = unserialize($v["cp_bs_img"]);
//				if (!empty($shops[$k]["cp_bs_img"])) {
//					foreach ($shops[$k]["cp_bs_img"] as $key => $val) {
//						$shops[$k]["cp_bs_img"][$key] = tomedia($val);
//					}
//				}
//			}
//			if ($v["top_pic"]) {
//				$shops[$k]["top_pic"] = unserialize($v["top_pic"]);
//				if (!empty($shops[$k]["top_pic"])) {
//					foreach ($shops[$k]["top_pic"] as $key => $val) {
//						$shops[$k]["top_pic"][$key] = tomedia($val);
//					}
//				}
//			}
		}
		
		data.put("shops", shopList);
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
				order.setDateline(DataUtils.millisToString(order.getAddtime()));
//				$order_list[$k]["shops"] = pdo_fetch("SELECT * FROM " . tablename("dbs_masclwlcard_shops") . " WHERE uniacid =:uniacid and id=:id  ", array(":uniacid" => $_W["uniacid"], ":id" => $v["shops_id"]));
//				$order_list[$k]["shops"]["g_img"] = tomedia($order_list[$k]["shops"]["gimg"]);
//				$order_list[$k]["dateline"] = date("Y-m-d H:i:s", $v["addtime"]);
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
//			foreach ($shops as $key => $val) {
//				$shops[$key]["gimg"] = tomedia($val["gimg"]);
//			}
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
//					foreach ($shops as $key => $val) {
//						$shops[$key]["gimg"] = tomedia($val["gimg"]);
//					}
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
