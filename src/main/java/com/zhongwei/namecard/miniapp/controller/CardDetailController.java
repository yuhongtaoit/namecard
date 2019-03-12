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
import com.zhongwei.namecard.miniapp.dao.CardAdvMapper;
import com.zhongwei.namecard.miniapp.dao.CardChatMapper;
import com.zhongwei.namecard.miniapp.dao.CardFooterMapper;
import com.zhongwei.namecard.miniapp.dao.CardFriendMapper;
import com.zhongwei.namecard.miniapp.dao.CardMapper;
import com.zhongwei.namecard.miniapp.dao.CardMemberMapper;
import com.zhongwei.namecard.miniapp.dao.CardNavMapper;
import com.zhongwei.namecard.miniapp.dao.CardNewsMapper;
import com.zhongwei.namecard.miniapp.dao.CardPlMapper;
import com.zhongwei.namecard.miniapp.dao.CardProductMapper;
import com.zhongwei.namecard.miniapp.dao.CardSetMapper;
import com.zhongwei.namecard.miniapp.dao.CardShopsMapper;
import com.zhongwei.namecard.miniapp.dao.CardWebMapper;
import com.zhongwei.namecard.miniapp.dao.CardZanMapper;
import com.zhongwei.namecard.miniapp.dao.MemberMapper;
import com.zhongwei.namecard.miniapp.dao.ShopsCategoryMapper;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.CardAdv;
import com.zhongwei.namecard.miniapp.model.CardAdvExample;
import com.zhongwei.namecard.miniapp.model.CardChat;
import com.zhongwei.namecard.miniapp.model.CardChatExample;
import com.zhongwei.namecard.miniapp.model.CardExample;
import com.zhongwei.namecard.miniapp.model.CardFooter;
import com.zhongwei.namecard.miniapp.model.CardFooterExample;
import com.zhongwei.namecard.miniapp.model.CardFriendExample;
import com.zhongwei.namecard.miniapp.model.CardFriendWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardMember;
import com.zhongwei.namecard.miniapp.model.CardMemberExample;
import com.zhongwei.namecard.miniapp.model.CardNav;
import com.zhongwei.namecard.miniapp.model.CardNavExample;
import com.zhongwei.namecard.miniapp.model.CardNews;
import com.zhongwei.namecard.miniapp.model.CardNewsExample;
import com.zhongwei.namecard.miniapp.model.CardPl;
import com.zhongwei.namecard.miniapp.model.CardPlExample;
import com.zhongwei.namecard.miniapp.model.CardProductExample;
import com.zhongwei.namecard.miniapp.model.CardProductWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardSet;
import com.zhongwei.namecard.miniapp.model.CardSetExample;
import com.zhongwei.namecard.miniapp.model.CardShopsExample;
import com.zhongwei.namecard.miniapp.model.CardShopsWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardWeb;
import com.zhongwei.namecard.miniapp.model.CardWebExample;
import com.zhongwei.namecard.miniapp.model.CardWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardZan;
import com.zhongwei.namecard.miniapp.model.CardZanExample;
import com.zhongwei.namecard.miniapp.model.Member;
import com.zhongwei.namecard.miniapp.model.MemberExample;
import com.zhongwei.namecard.miniapp.model.ShopsCategory;
import com.zhongwei.namecard.miniapp.model.ShopsCategoryExample;
import com.zhongwei.namecard.miniapp.model.CardFriendExample.Criteria;
import com.zhongwei.namecard.utils.DataUtils;
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
				memUser.setSourceId(share_id);///intval($_GPC["share_id"]) ? intval($_GPC["share_id"]) : 0;******
				memUser.setSendCardid(send_cardid);// intval($_GPC["send_cardid"]) ? intval($_GPC["send_cardid"]) : 0; 888888
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
					friend.setAllImgarr(friend.getAllImg().split(","));
				}
				friend.setTimeStr(DataUtils.millisToString(friend.getTime()));
			}
		}
		
		List<CardProductWithBLOBs> productList = new ArrayList<CardProductWithBLOBs>();
		CardProductExample productExample = new CardProductExample();
		productExample.createCriteria().andUniacidEqualTo(uniacid);
		productExample.setOrderByClause("sort DESC");
		productList = cardProductMapper.selectByExampleWithBLOBs(productExample);
		if(productList.size() > 0) {
			for(CardProductWithBLOBs product : productList) {
				if(StringUtils.hasText(product.getCpBsImg())) {
					//******暂不知该如何处理
				}
				if(StringUtils.hasText(product.getCpBsContent())) {
					//******暂不知该如何处理
//					$product[$k]["cp_bs_content"] = unserialize($v["cp_bs_content"]);
//					if (!empty($product[$k]["cp_bs_content"])) {
//						foreach ($product[$k]["cp_bs_content"] as $key => $val) {
//							$product[$k]["cp_bs_content"][$key] = tomedia($val);
//						}
//					}
				}
			}
		}
		if(shopsList.size() > 0) {
			for(CardShopsWithBLOBs shop : shopsList) {
				// ******暂不知该如何处理
//				$shops[$k]["gimg"] = tomedia($v["gimg"]);
//				if ($v["cp_bs_img"]) {
//					$shops[$k]["cp_bs_img"] = unserialize($v["cp_bs_img"]);
//					if (!empty($shops[$k]["cp_bs_img"])) {
//						foreach ($shops[$k]["cp_bs_img"] as $key => $val) {
//							$shops[$k]["cp_bs_img"][$key] = tomedia($val);
//						}
//					}
//				}
//				if ($v["top_pic"]) {
//					$shops[$k]["top_pic"] = unserialize($v["top_pic"]);
//					if (!empty($shops[$k]["top_pic"])) {
//						foreach ($shops[$k]["top_pic"] as $key => $val) {
//							$shops[$k]["top_pic"][$key] = tomedia($val);
//						}
//					}
//				}
			}
		}
		
		if(newsList.size() > 0) {
			for(CardNews news : newsList) {
				news.setTimeStr(DataUtils.millisToString(news.getTime()));
//				$news[$k]["head_img"] = tomedia($v["head_img"]);
			}
		}
		// ******
//		if (!empty($nav)) {
//			foreach ($nav as $k => $v) {
//				$nav[$k]["images"] = tomedia($v["images"]);
//			}
//		}
//		if (!empty($adv)) {
//			foreach ($adv as $k => $v) {
//				$adv[$k]["images"] = tomedia($v["images"]);
//			}
//		}
//		$web["video"] = tomedia($web["video"]);
//		$web["images"] = tomedia($web["images"]);
		
//		$j_photo = array();
//		if (!empty($web["cp_bs_content"])) {
//			$js_photo = unserialize($web["cp_bs_content"]);
//			foreach ($js_photo as $k => $v) {
//				$j_photo[] = tomedia($v);
//			}
//		}
		
		data.put("web", cardWeb);
		data.put("adv", advList);
		data.put("j_photo", "j_photo");// ******
		data.put("news", newsList);
		data.put("shops", shopsList.size() > 0 ? shopsList : "");
		data.put("nav", navList);
		data.put("dynamic_list", dynamicList);
		data.put("product", productList);
//		$photo = array();******
//		if (!empty($info["photo"])) {
//			$newphoto = unserialize($info["photo"]);
//			if (!empty($newphoto)) {
//				foreach ($newphoto as $k => $v) {
//					$photo[] = tomedia($v);
//				}
//			}
//		}
		data.put("newphoto", info.getPhoto());//******待转换
		
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
		
		footer.setCardImg(StringUtils.hasText(footer.getCardImg()) ? footer.getCardImg() : "../../images/card/01_2x.png");
		footer.setCardImgNo(StringUtils.hasText(footer.getCardImgNo()) ? footer.getCardImgNo() : "../../images/card/01_2x_n.png");
		footer.setShopImg(StringUtils.hasText(footer.getShopImg()) ? footer.getShopImg() : "../../images/card/02_x.png");
		footer.setShopImgNo(StringUtils.hasText(footer.getShopImgNo()) ? footer.getShopImgNo() : "../../images/card/02_x_n.png");
		footer.setFriendImg(StringUtils.hasText(footer.getFriendImg()) ? footer.getFriendImg() : "../../images/card/03_x.png");
		footer.setFriendImgNo(StringUtils.hasText(footer.getFriendImgNo()) ? footer.getFriendImgNo() : "../../images/card/03_x_n.png");
		footer.setWebImg(StringUtils.hasText(footer.getWebImg()) ? footer.getWebImg() : "../../images/card/04_x.png");
		footer.setWebImgNo(StringUtils.hasText(footer.getWebImgNo()) ? footer.getWebImgNo() : "../../images/card/04_x_n.png");
		Map<String, Object> map0 = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
//		Map<Integer, Object> navFooter = new HashMap<Integer, Object>();
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
		
		navFooterList.add(map0);
		navFooterList.add(map1);
		navFooterList.add(map2);
		navFooterList.add(map3);
		
		data.put("nav_footer", navFooterList);
		data.put("footer_nav", footerNavList);
		data.put("isAuthorize", isAuthorize);
		data.put("GetCustomMobile", getCustomMobile);
		data.put("titles", titles);
		data.put("hmd_status", member.getHmdStatus());
		data.put("share_id", share_id);//****** intval($_GPC["share_id"]) ? intval($_GPC["share_id"]) : 0;
		data.put("card_logo", "");//******
		data.put("template_img", "");
		data.put("share_img", "");
		data.put("card", cardSet);
		data.putAll(info.cardToMap(info));
		
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
				memUser.setSourceId(share_id);///******intval($_GPC["share_id"]) ? intval($_GPC["share_id"]) : 0;******
				memUser.setSendCardid(send_cardid);// intval($_GPC["send_cardid"]) ? intval($_GPC["send_cardid"]) : 0; 888888
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
