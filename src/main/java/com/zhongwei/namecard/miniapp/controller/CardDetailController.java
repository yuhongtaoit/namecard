package com.zhongwei.namecard.miniapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.zhongwei.namecard.dao.CardAdvMapper;
import com.zhongwei.namecard.dao.CardChatMapper;
import com.zhongwei.namecard.dao.CardFooterMapper;
import com.zhongwei.namecard.dao.CardFriendMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardNavMapper;
import com.zhongwei.namecard.dao.CardNewsMapper;
import com.zhongwei.namecard.dao.CardPlMapper;
import com.zhongwei.namecard.dao.CardProductMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.dao.CardShopsMapper;
import com.zhongwei.namecard.dao.CardWebMapper;
import com.zhongwei.namecard.dao.CardZanMapper;
import com.zhongwei.namecard.dao.MemberMapper;
import com.zhongwei.namecard.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardAdv;
import com.zhongwei.namecard.entity.CardAdvExample;
import com.zhongwei.namecard.entity.CardChat;
import com.zhongwei.namecard.entity.CardChatExample;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardFooter;
import com.zhongwei.namecard.entity.CardFooterExample;
import com.zhongwei.namecard.entity.CardFriendExample;
import com.zhongwei.namecard.entity.CardFriendExample.Criteria;
import com.zhongwei.namecard.entity.CardFriendWithBLOBs;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardNav;
import com.zhongwei.namecard.entity.CardNavExample;
import com.zhongwei.namecard.entity.CardNews;
import com.zhongwei.namecard.entity.CardNewsExample;
import com.zhongwei.namecard.entity.CardPl;
import com.zhongwei.namecard.entity.CardPlExample;
import com.zhongwei.namecard.entity.CardProductExample;
import com.zhongwei.namecard.entity.CardProductWithBLOBs;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;
import com.zhongwei.namecard.entity.CardWeb;
import com.zhongwei.namecard.entity.CardWebExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.entity.CardZan;
import com.zhongwei.namecard.entity.CardZanExample;
import com.zhongwei.namecard.entity.Member;
import com.zhongwei.namecard.entity.MemberExample;
import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;
import com.zhongwei.namecard.utils.DateUtils;
import com.zhongwei.namecard.utils.ImageUrlUtils;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.SendCashUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class CardDetailController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@Autowired
	private CardSetMapper cardSetMapper;
	
	@Autowired
	private CardZanMapper cardZanMapper;
	
	@Autowired
	private CardChatMapper cardChatMapper;
	
	@Autowired
	private CardWebMapper cardWebMapper;
	
	@Autowired
	private CardAdvMapper cardAdvMapper;
	
	@Autowired
	private CardNewsMapper cardNewsMapper;
	
	@Autowired
	private CardNavMapper cardNavMapper;
	
	@Autowired
	private CardShopsMapper cardShopsMapper;
	
	@Autowired
	private ShopsCategoryMapper shopsCategoryMapper;
	
	@Autowired
	private CardFriendMapper cardFriendMapper;
	
	@Autowired
	private CardPlMapper cardPlMapper;
	
	@Autowired
	private CardProductMapper cardProductMapper;
	
	@Autowired
	private CardFooterMapper cardFooterMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
//	@Autowired
//	private UserUtils userUtils;
//	
//	@Autowired
//	private DateUtils dateUtils;
	
	@RequestMapping("/getCardDetail")
	public Map<String, Object> getCardDetail(String formId,String sessionId, int uniacid, Integer send_cardid,
			Integer share_id, Integer card_id, Integer fid, Integer type, String content, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		int isAuthorize = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == 0) {
			data.put("is_send_status", 1);
			result.put("data", data);
			return result;
		}
		
		CardWithBLOBs infoFind = null;
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(card_id);
		List<CardWithBLOBs> list = cardMapper.selectByExampleWithBLOBs(cardExample);
		if(list.size() == 0) {
			data.put("is_send_status", 2);
			result.put("data", data);
			return result;
		}
		infoFind = list.get(0);
		if(infoFind.getIsSendcard() > 0) {
			data.put("is_send_status", 3);
			result.put("data", data);
			return result;
		}
		if(send_cardid == null) {
			send_cardid = 0;
		}
		if(share_id == null) {
			share_id = 0;
		}
		if(card_id == null) {
			card_id = 0;
		}
		if(fid == null) {
			fid = 0;
		}
		if(type == null) {
			type = 0;
		}
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(type == 1 && fid > 0) {
			if(StringUtils.hasText(openId)) {
				CardZan zanInfo = new CardZan();
				List<CardZan> zanList = new ArrayList<CardZan>();
				CardZanExample zanExample = new CardZanExample();
				zanExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andFidEqualTo(fid);
				zanList = cardZanMapper.selectByExample(zanExample);
				if(zanList.size() > 0) {
					zanInfo = zanList.get(0);
				}
				
				CardZan zanUser = new CardZan();
				zanUser.setUniacid(uniacid);
				zanUser.setOpenid(openId);
				zanUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
				zanUser.setPhone("");// php中取值$data["purePhoneNumber"];未找到data中的数据是什么时候放进去的 ******
				zanUser.setName("");
				zanUser.setAid(1);
				zanUser.setGender(user.getGender());
				zanUser.setCity(user.getCity() == null ? "" : user.getCity());
				zanUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
				zanUser.setFid(fid);
				zanUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
				zanUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
				zanUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
				if(zanList.size() == 0) {
					zanUser.setAddtime(String.valueOf(System.currentTimeMillis()));
					zanUser.setStatus(1);
					zanUser.setUpdatetime("");
					cardZanMapper.insert(zanUser);
				}else {
					zanUser.setAddtime(StringUtils.hasText(zanInfo.getAddtime()) ? zanInfo.getAddtime() : String.valueOf(System.currentTimeMillis()));
					zanUser.setUpdatetime(String.valueOf(System.currentTimeMillis()));
					if(zanInfo.getStatus() > 0) {
						zanUser.setStatus(0);
					}else {
						zanUser.setStatus(1);
					}
					zanUser.setId(zanInfo.getId());
					cardZanMapper.updateByPrimaryKey(zanUser);
				}
			}
		}
		if(type == 2 && fid > 0) {
			if(StringUtils.hasText(openId)) {
				CardPl plUser = new CardPl();
				plUser.setUniacid(uniacid);
				plUser.setOpenid(openId);
				plUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
				plUser.setPhone("");// php中取值$data["purePhoneNumber"];未找到data中的数据是什么时候放进去的 ******
				plUser.setGender(user.getGender());
				plUser.setName("");
				plUser.setAid(1);
				plUser.setCity(user.getCity() == null ? "" : user.getCity());
				plUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
				plUser.setFid(fid);
				plUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
				plUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
				plUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
				plUser.setAddtime(String.valueOf(System.currentTimeMillis()));
				plUser.setUpdatetime("");
				plUser.setContent(content);
				cardPlMapper.insert(plUser);
			}
		}
		
		if(StringUtils.hasText(openId) && card_id > 0) {
			CardMember cardMember = new CardMember();
			List<CardMember> memberList = new ArrayList<CardMember>();
			CardMemberExample memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
			memberList = cardMemberMapper.selectByExample(memberExample);
			if(memberList.size() > 0) {
				cardMember = memberList.get(0);
			}else {
				CardMember memUser = new CardMember();
				memUser.setUniacid(uniacid);
				memUser.setOpenid(openId);
				memUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
				memUser.setAid(card_id);
				memUser.setPhone("");// 
				memUser.setGender(user.getGender());
				memUser.setName("");
				memUser.setCity(user.getCity() == null ? "" : user.getCity());
				memUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
				memUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
				memUser.setAvatarUrl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
				memUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
				memUser.setAddtime(String.valueOf(System.currentTimeMillis()));
				memUser.setUpdatetime("");
				memUser.setSourceId(share_id);
				memUser.setSendCardid(send_cardid);
				memUser.setCanTake(new BigDecimal("0.00"));
				memUser.setTotalBroker(new BigDecimal("0.00"));
				memUser.setHasTaken(new BigDecimal("0.00"));
				memUser.setInTaking(new BigDecimal("0.00"));
				memUser.setNotInAccount(new BigDecimal("0.00"));
				
				int insertMem = cardMemberMapper.insert(memUser);
				if(insertMem > 0) {
					if(share_id > 0) {
						memberExample = new CardMemberExample();
						memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
						memberList = cardMemberMapper.selectByExample(memberExample);
						if(memberList.size() > 0) {
							cardMember = memberList.get(0);
							SendCashUtils.sendCash(cardMember);//******
						}
					}
					if(StringUtils.hasText(infoFind.getZdMsg())) {
						CardChat chatUser = new CardChat();
						chatUser.setUniacid(uniacid);
						chatUser.setOpenid(openId);
						chatUser.setCardId(card_id);
						chatUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
						chatUser.setPhone("");
						chatUser.setGender(user.getGender());
						chatUser.setName("");
						chatUser.setCity(user.getCity() == null ? "" : user.getCity());
						chatUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
						chatUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
						chatUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
						chatUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
						chatUser.setAddtime(String.valueOf(System.currentTimeMillis()));
						chatUser.setUpdatetime("");
						chatUser.setMsg(infoFind.getZdMsg());
						chatUser.setFormid("");
						chatUser.setType(0);
						chatUser.setIsSend(1);
						chatUser.setStype(1);
						chatUser.setFid(0);
						cardChatMapper.insert(chatUser);
						
					}
				}
			}
			
		}
		
		CardMember cardMember = new CardMember();
		List<CardMember> memberList = new ArrayList<CardMember>();
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
		memberList = cardMemberMapper.selectByExample(memberExample);
		if(memberList.size() > 0) {
			cardMember = memberList.get(0);
		}
		CardWithBLOBs infoCard = infoFind;
		if(type == 2 && card_id > 0) {
			if(StringUtils.hasText(openId)) {
				if(cardMember.getShowZan() > 0) {
					cardMember.setShowZan(0);
					cardMemberMapper.updateByPrimaryKey(cardMember);
					infoCard.setThumbsNum(infoCard.getThumbsNum() - 1);
					infoCard.setUniacid(uniacid);
					cardMapper.updateByPrimaryKey(infoCard);
				}else {
					cardMember.setShowZan(1);
					cardMemberMapper.updateByPrimaryKey(cardMember);
					infoCard.setThumbsNum(infoCard.getThumbsNum() + 1);
					infoCard.setUniacid(uniacid);
					cardMapper.updateByPrimaryKey(infoCard);
				}
			}
		}
		
		List<CardWithBLOBs> cardList = new ArrayList<CardWithBLOBs>();
		List<CardSet> setList = new ArrayList<CardSet>();
		List<CardWeb> webList = new ArrayList<CardWeb>();
		List<CardAdv> advList = new ArrayList<CardAdv>();
		List<CardNews> newsList = new ArrayList<CardNews>();
		List<CardNav> navList = new ArrayList<CardNav>();
		List<CardShopsWithBLOBs> shopsList = new ArrayList<CardShopsWithBLOBs>();
		List<ShopsCategory> titles = new ArrayList<ShopsCategory>();
		List<CardFriendWithBLOBs> dynamicList = new ArrayList<CardFriendWithBLOBs>();
		CardWithBLOBs info = null;
		CardSet cardSet = null;
		CardWeb cardWeb = null;
		cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(card_id).andIsSendcardEqualTo(0);
		cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		info = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		CardSetExample cardSetExample = new CardSetExample();
		cardSetExample.createCriteria().andUniacidEqualTo(uniacid);
		setList = cardSetMapper.selectByExample(cardSetExample);
		cardSet = setList.size() > 0 ? setList.get(0) : new CardSet();
		CardWebExample cardWebExample = new CardWebExample();
		cardWebExample.createCriteria().andUniacidEqualTo(uniacid);
		webList = cardWebMapper.selectByExample(cardWebExample);
		cardWeb = webList.size() > 0 ? webList.get(0) : new CardWeb();
		CardAdvExample advExample = new CardAdvExample();
		advExample.createCriteria().andUniacidEqualTo(uniacid);
		advList = cardAdvMapper.selectByExample(advExample);
		CardNewsExample newsExample = new CardNewsExample();
		newsExample.createCriteria().andUniacidEqualTo(uniacid);
		newsExample.setOrderByClause("sort DESC");
		newsList = cardNewsMapper.selectByExample(newsExample);
		CardNavExample navExample = new CardNavExample();
		navExample.createCriteria().andUniacidEqualTo(uniacid);
		navList = cardNavMapper.selectByExample(navExample);
		CardShopsExample shopsExample = new CardShopsExample();
		shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIsShowEqualTo(1);
		shopsExample.setOrderByClause("sort DESC");
		PageHelper.startPage(0, 8);
		shopsList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
		ShopsCategoryExample categoryExample = new ShopsCategoryExample();
		categoryExample.createCriteria().andUniacidEqualTo(uniacid).andParentidEqualTo(0).andEnabledEqualTo(1);
		categoryExample.setOrderByClause("sort DESC");
		titles = shopsCategoryMapper.selectByExample(categoryExample);
		CardFriendExample friendExample = new CardFriendExample();
		Criteria criteria1 =friendExample.createCriteria();
		criteria1.andUniacidEqualTo(uniacid).andIsCardEqualTo(0);
		Criteria criteria2 =friendExample.createCriteria();
		criteria2.andUniacidEqualTo(uniacid).andIsCardEqualTo(1).andCardIdEqualTo(info.getId());
		friendExample.setOrderByClause("time DESC");
		friendExample.or(criteria2);
		dynamicList = cardFriendMapper.selectByExampleWithBLOBs(friendExample);
		if(dynamicList.size() > 0) {
			for(CardFriendWithBLOBs friend : dynamicList) {
				CardZanExample zanExample = new CardZanExample();
				zanExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(friend.getId()).andStatusEqualTo(1);
				friend.setUps(cardZanMapper.selectByExample(zanExample));
				CardPlExample plExample = new CardPlExample();
				plExample.createCriteria().andUniacidEqualTo(uniacid).andFidEqualTo(friend.getId());
				friend.setReplies(cardPlMapper.selectByExample(plExample));
				if(StringUtils.hasText(openId)) {
					List<CardZan> zanL = new ArrayList<CardZan>();
					zanExample = new CardZanExample();
					zanExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andFidEqualTo(friend.getId());
					zanL = cardZanMapper.selectByExample(zanExample);
					CardZan isupinfo = new CardZan();
					if(zanL.size() > 0) {
						isupinfo = zanL.get(0);
					}
					friend.setIsup(isupinfo.getStatus());
				}
				if(StringUtils.hasText(friend.getAllImg())) {
					String arr[] = ImageUrlUtils.unserialize(friend.getAllImg());
					String arr1[] = new String[arr.length];
					for(int i = 0; i<arr.length ; i++ ) {
						arr1[i] = ImageUrlUtils.getAbsolutelyURL(arr[i]);
					}
					friend.setAllImgarr(arr1);
				}
				friend.setTimeStr(DateUtils.millisToString(Long.valueOf(friend.getTime()*Long.valueOf(1000))));
				friend.setHeadImg(ImageUrlUtils.getAbsolutelyURL(friend.getHeadImg()));
			}
		}
		
		List<CardProductWithBLOBs> productList = new ArrayList<CardProductWithBLOBs>();
		CardProductExample productExample = new CardProductExample();
		productExample.createCriteria().andUniacidEqualTo(uniacid);
		productExample.setOrderByClause("sort DESC");
		productList = cardProductMapper.selectByExampleWithBLOBs(productExample);
		List<Map<String, Object>> productMapList = new ArrayList<Map<String, Object>>();
		if(productList.size() > 0) {
			Map<String, Object> map = null;
			for(CardProductWithBLOBs product : productList) {
				map = new HashMap<String, Object>();
				map = product.CardProductToMap(product);
				if(StringUtils.hasText(product.getCpBsImg())) {
					String[] imgArray = ImageUrlUtils.unserialize(product.getCpBsImg());
					if(imgArray.length > 0) {
						for(int i = 0; i< imgArray.length; i++) {
							imgArray[i] = ImageUrlUtils.getAbsolutelyURL(imgArray[i]);
						}
					}
					map.put("cpBsImg", imgArray);
				}
				if(StringUtils.hasText(product.getCpBsContent())) {
					String[] contentArray = ImageUrlUtils.unserialize(product.getCpBsContent());
					if(contentArray.length > 0) {
						for(int i = 0; i< contentArray.length; i++) {
							contentArray[i] = ImageUrlUtils.getAbsolutelyURL(contentArray[i]);
						}
					}
					map.put("cpBsContent", contentArray);
				}
				productMapList.add(map);
			}
		}
		List<Map<String, Object>> shopsMapList = new ArrayList<Map<String, Object>>();
		if(shopsList.size() > 0) {
			Map<String, Object> map = null;
			for(CardShopsWithBLOBs shop : shopsList) {
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
		
		if(newsList.size() > 0) {
			for(CardNews news : newsList) {
				news.setTimeStr(DateUtils.millisToString(news.getTime()));
				news.setHeadImg(ImageUrlUtils.getAbsolutelyURL(news.getHeadImg()));
			}
		}
		if(navList.size() > 0) {
			for(CardNav cardNav : navList) {
				cardNav.setImages(ImageUrlUtils.getAbsolutelyURL(cardNav.getImages()));
			}
		}
		if(advList.size() > 0) {
			for(CardAdv adv : advList) {
				adv.setImages(ImageUrlUtils.getAbsolutelyURL(adv.getImages()));
			}
		}
		cardWeb.setVideo(ImageUrlUtils.getAbsolutelyURL(cardWeb.getVideo()));
		cardWeb.setImages(ImageUrlUtils.getAbsolutelyURL(cardWeb.getImages()));
		List<String> jPhoto = new ArrayList<String>();
		if(StringUtils.hasText(cardWeb.getCpBsContent())) {
			String[] contents = ImageUrlUtils.unserialize(cardWeb.getCpBsContent());
			for(String str : contents) {
				jPhoto.add(ImageUrlUtils.getAbsolutelyURL(str));
			}
		}
		
		data.put("web", cardWeb);
		data.put("adv", advList);
		data.put("j_photo", jPhoto);
		data.put("news", newsList);
		data.put("shops", shopsMapList);
		data.put("nav", navList);
		data.put("dynamic_list", dynamicList);
		data.put("product", productMapList);
		List<String> photo = new ArrayList<String>();
		if(StringUtils.hasText(info.getPhoto())) {
			String[] newphoto = ImageUrlUtils.unserialize(info.getPhoto());
			for(String str : newphoto) {
				photo.add(ImageUrlUtils.getAbsolutelyURL(str));
			}
		}
		data.put("newphoto", photo);
		data.put("video", StringUtils.hasText(info.getVedio()) ? ImageUrlUtils.getAbsolutelyURL(info.getVedio()) : null);
		List<CardMember> cardAllmembr = new ArrayList<CardMember>();
		CardMemberExample memberExample2 = new CardMemberExample();
		memberExample2.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id);
		memberExample2.setOrderByClause("id desc");
		cardAllmembr = cardMemberMapper.selectByExample(memberExample2);
		int totle = cardAllmembr.size();
		data.put("card_allmembr", cardAllmembr);
		data.put("cardAllmembr", cardAllmembr);
		data.put("totle", totle);
		CardMemberExample memberExample3 = new CardMemberExample();
		memberExample3.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
		List<CardMember> members = new ArrayList<CardMember>();
		CardMember member = new CardMember();
		members = cardMemberMapper.selectByExample(memberExample3);
		if(members.size() > 0) {
			member = members.get(0);
		}
		data.put("card_membr", member);
		data.put("cardMembr", member);
		String nickName = user.getNickname();
		int getCustomMobile = 0;
		if(!StringUtils.hasText(openId) || !StringUtils.hasText(nickName)) {
			isAuthorize = 0;
		}else {
			isAuthorize = 1;
			MemberExample memberExample4 = new MemberExample();
			memberExample4.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId);
			List<Member> members2 = new ArrayList<Member>();
			Member GetPhone = new Member();
			members2 = memberMapper.selectByExample(memberExample4);
			if(members.size() > 0) {
				getCustomMobile = 1;
			}
		}
		List<CardFooter> footerList = new ArrayList<CardFooter>();
		CardFooter footer = new CardFooter();
		CardFooterExample footerExample = new CardFooterExample();
		footerExample.createCriteria().andUniacidEqualTo(uniacid);
		footerList = cardFooterMapper.selectByExample(footerExample);
		if(footerList.size() > 0) {
			footer = footerList.get(0);
		}
		footer.setCardName(StringUtils.hasText(footer.getCardName()) ? footer.getCardName() : "名片");
		footer.setShopName(StringUtils.hasText(footer.getShopName()) ? footer.getShopName() : "商城");
		footer.setFriendName(StringUtils.hasText(footer.getFriendName()) ? footer.getFriendName() : "动态");
		footer.setWebName(StringUtils.hasText(footer.getWebName()) ? footer.getWebName() : "官网");
		List<String> footerNavList = new ArrayList<String>();
		footerNavList.add(footer.getCardName());
		footerNavList.add(footer.getShopName());
		footerNavList.add(footer.getFriendName());
		footerNavList.add(footer.getWebName());
		
		footer.setCardImg(StringUtils.hasText(footer.getCardImg()) ? ImageUrlUtils.getAbsolutelyURL(footer.getCardImg()) : "../../images/card/01_2x.png");
		footer.setCardImgNo(StringUtils.hasText(footer.getCardImgNo()) ? ImageUrlUtils.getAbsolutelyURL(footer.getCardImgNo()) : "../../images/card/01_2x_n.png");
		footer.setShopImg(StringUtils.hasText(footer.getShopImg()) ? ImageUrlUtils.getAbsolutelyURL(footer.getShopImg()) : "../../images/card/02_x.png");
		footer.setShopImgNo(StringUtils.hasText(footer.getShopImgNo()) ? ImageUrlUtils.getAbsolutelyURL(footer.getShopImgNo()) : "../../images/card/02_x_n.png");
		footer.setFriendImg(StringUtils.hasText(footer.getFriendImg()) ? ImageUrlUtils.getAbsolutelyURL(footer.getFriendImg()) : "../../images/card/03_x.png");
		footer.setFriendImgNo(StringUtils.hasText(footer.getFriendImgNo()) ? ImageUrlUtils.getAbsolutelyURL(footer.getFriendImgNo()) : "../../images/card/03_x_n.png");
		footer.setWebImg(StringUtils.hasText(footer.getWebImg()) ? ImageUrlUtils.getAbsolutelyURL(footer.getWebImg()) : "../../images/card/04_x.png");
		footer.setWebImgNo(StringUtils.hasText(footer.getWebImgNo()) ? ImageUrlUtils.getAbsolutelyURL(footer.getWebImgNo()) : "../../images/card/04_x_n.png");
		Map<String, Object> map0 = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		List<Map<String, Object>> navFooterList = new ArrayList<Map<String, Object>>();
		
		map0.put("name", footer.getCardName());
		map0.put("icon", footer.getCardImgNo());
		map0.put("selectIcon", footer.getCardImg());
		map0.put("card_type", footer.getCardType());
		map0.put("card_appid", footer.getCardAppid());
		map0.put("card_url", "");
		map0.put("card_path", footer.getCardPath());
		
		map1.put("name", footer.getShopName());
		map1.put("icon", footer.getShopImgNo());
		map1.put("selectIcon", footer.getShopImg());
		map1.put("shop_type", footer.getShopType());
		map1.put("shop_appid", footer.getShopAppid());
		map1.put("shop_url", footer.getShopUrl());
		map1.put("shop_path", footer.getShopPath());
		
		map2.put("name", footer.getFriendName());
		map2.put("icon", footer.getFriendImgNo());
		map2.put("selectIcon", footer.getFriendImg());
		map2.put("friend_type", footer.getFriendType());
		map2.put("friend_appid", footer.getFriendAppid());
		map2.put("friend_url", footer.getFriendUrl());
		map2.put("friend_path", footer.getFriendPath());
		
		map3.put("name", footer.getWebName());
		map3.put("icon", footer.getWebImgNo());
		map3.put("selectIcon", footer.getWebImg());
		map3.put("web_type", footer.getWebType());
		map3.put("web_appid", footer.getWebAppid());
		map3.put("web_url", footer.getWebUrl());
		map3.put("web_path", footer.getWebPath());
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("name", "我的");
		map4.put("icon", footer.getWebImgNo());
		map4.put("selectIcon", footer.getWebImg());
		map4.put("web_type", footer.getWebType());
		map4.put("web_appid", footer.getWebAppid());
		map4.put("web_url", footer.getWebUrl());
		map4.put("web_path", footer.getWebPath());
		
		navFooterList.add(map0);
		navFooterList.add(map1);
		navFooterList.add(map2);
		navFooterList.add(map3);
//		navFooterList.add(map4);
		
		data.putAll(info.cardToMap(info));
		data.put("nav_footer", navFooterList);
		data.put("footer_nav", footerNavList);
		data.put("isAuthorize", isAuthorize);
		data.put("GetCustomMobile", getCustomMobile);
		data.put("titles", titles);
		data.put("hmd_status", member.getHmdStatus());
		data.put("share_id", share_id);
		data.put("cardLogo", ImageUrlUtils.getAbsolutelyURL(info.getCardLogo()));
		data.put("templateImg", ImageUrlUtils.getAbsolutelyURL(info.getTemplateImg()));
		data.put("shareImg", ImageUrlUtils.getAbsolutelyURL(info.getShareImg()));
		if(StringUtils.hasText(cardSet.getCompanyLogo())) {
			cardSet.setCompanyLogo(ImageUrlUtils.getAbsolutelyURL(cardSet.getCompanyLogo()));
			cardSet.setShopBg(ImageUrlUtils.getAbsolutelyURL(cardSet.getShopBg()));
		}
		data.put("card", cardSet);
		
		data.put("message", message);
		data.put("errno", errno);
		result.put("data", data);
		return result;
	}
	
	
	@RequestMapping("/offline")
	public Map<String, Object> offline(int uniacid, Integer card_id, String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(!StringUtils.hasText(openId)) {
			result.put("data", data);
			return result;
		}
		
		CardChatExample chatExample = new CardChatExample();
		chatExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andTypeEqualTo(0).andCardIdEqualTo(card_id);
		int count = cardChatMapper.countByExample(chatExample);
		result.put("data", count);
		return result;
	}
	
	@RequestMapping("/getphonenum")
	public Map<String, Object> getphonenum(int uniacid, Integer card_id, String encryptedData,String iv,
			String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		int isAuthorize = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		if(card_id == null) 
			card_id = 0;
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(!StringUtils.hasText(sessionId) || !StringUtils.hasText(encryptedData) || !StringUtils.hasText(iv)) {
			message = "请先登录";
		}else {
			CardWithBLOBs card = null;
			CardExample cardExample = new CardExample();
			cardExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(card_id);
			List<CardWithBLOBs> cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
			card = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
			
			CardMember cardMember = new CardMember();
			List<CardMember> memberList = new ArrayList<CardMember>();
			CardMemberExample memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
			memberList = cardMemberMapper.selectByExample(memberExample);
			cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
			
			MemberExample memberEpl = new MemberExample();
			memberEpl.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId);
			List<Member> intoList = new ArrayList<Member>();
			intoList = memberMapper.selectByExample(memberEpl);
			Member info = intoList.size() > 0 ? intoList.get(0) : new Member();
			
			Member memberUser = new Member();
			memberUser.setUniacid(uniacid);
			memberUser.setOpenid(openId);
			memberUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
			memberUser.setPhone(user.getPhone() == null ? "" : user.getPhone());
			memberUser.setGender(user.getGender());
			memberUser.setName("");
			memberUser.setCity(user.getCity() == null ? "" : user.getCity());
			memberUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
			memberUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
			memberUser.setAvatarUrl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
			memberUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
			
			if(intoList.size() == 0) {
				memberUser.setAddtime(String.valueOf(System.currentTimeMillis()));
				memberUser.setUpdatetime("");
				memberMapper.insert(memberUser);
				String content = "请尽快联系客户: " + memberUser.getNickname() + " 电话:" + user.getPhone();
				String subject = "客户留言";
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
			}else {
				memberUser.setAddtime(StringUtils.hasText(info.getAddtime()) ? info.getAddtime() : String.valueOf(System.currentTimeMillis()));
				memberUser.setUpdatetime(String.valueOf(System.currentTimeMillis()));
				memberUser.setId(info.getId());
				memberMapper.updateByPrimaryKey(memberUser);
				String content = "请尽快联系客户: " + memberUser.getNickname() + " 电话:" + user.getPhone();
				String subject = "客户留言";
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
			}
 		}
		
		if(!StringUtils.hasText(sessionId)) {
			isAuthorize = 0;
		}else {
			isAuthorize = 1;
		}
		data.put("isAuthorize", isAuthorize);
		
		result.put("data", data);
		return result;
	}
	
	@RequestMapping("/addCardId")
	public Map<String, Object> addCardId(int uniacid, Integer card_id, Integer share_id, Integer send_cardid,
			 String sessionId, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		if(card_id == null) 
			card_id = 0;
		if(share_id == null) 
			share_id = 0;
		if(send_cardid == null) 
			send_cardid = 0;
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		
		List<CardWithBLOBs> cardList = new ArrayList<CardWithBLOBs>();
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(card_id);
		cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		CardWithBLOBs info = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		
		if(StringUtils.hasText(openId) && card_id > 0) {
			CardMember cardMember = new CardMember();
			List<CardMember> memberList = new ArrayList<CardMember>();
			CardMemberExample memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
			memberList = cardMemberMapper.selectByExample(memberExample);
			if(memberList.size() == 0) {
				CardMember memUser = new CardMember();
				memUser.setUniacid(uniacid);
				memUser.setOpenid(openId);
				memUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
				memUser.setAid(card_id);
				memUser.setPhone("");// 
				memUser.setGender(user.getGender());
				memUser.setName("");
				memUser.setCity(user.getCity() == null ? "" : user.getCity());
				memUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
				memUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
				memUser.setAvatarUrl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
				memUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
				memUser.setAddtime(String.valueOf(System.currentTimeMillis()));
				memUser.setUpdatetime("");
				memUser.setSourceId(share_id);
				memUser.setSendCardid(send_cardid);
				memUser.setCanTake(new BigDecimal("0.00"));
				memUser.setTotalBroker(new BigDecimal("0.00"));
				memUser.setHasTaken(new BigDecimal("0.00"));
				memUser.setInTaking(new BigDecimal("0.00"));
				memUser.setNotInAccount(new BigDecimal("0.00"));
				
				int res_one = cardMemberMapper.insert(memUser);
				if(res_one > 0) {
					if(share_id > 0) {
						CardMember cardMember2 = new CardMember();
						List<CardMember> memberList2 = new ArrayList<CardMember>();
						CardMemberExample memberExample2 = new CardMemberExample();
						memberExample2.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
						memberList2 = cardMemberMapper.selectByExample(memberExample2);
						if(memberList2.size() > 0) {
							SendCashUtils.sendCash(memberList2.get(0));
						}
					}
					if(StringUtils.hasText(info.getZdMsg())) {
						CardChat chatUser = new CardChat();
						chatUser.setUniacid(uniacid);
						chatUser.setOpenid(openId);
						chatUser.setCardId(card_id);
						chatUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
						chatUser.setPhone("");
						chatUser.setGender(user.getGender());
						chatUser.setName("");
						chatUser.setCity(user.getCity() == null ? "" : user.getCity());
						chatUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
						chatUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
						chatUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
						chatUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
						chatUser.setAddtime(String.valueOf(System.currentTimeMillis()));
						chatUser.setUpdatetime("");
						chatUser.setMsg(info.getZdMsg());
						chatUser.setFormid("");
						chatUser.setType(0);
						chatUser.setIsSend(1);
						chatUser.setStype(1);
						cardChatMapper.insert(chatUser);
						
					}
				}
			}
			
		}
		CardMember cardMember = null ;
		List<CardMember> memberList = new ArrayList<CardMember>();
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
		memberList = cardMemberMapper.selectByExample(memberExample);
		cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
		data.put("id", cardMember.getId());
		result.put("data", data);
		return result;
	}

}
