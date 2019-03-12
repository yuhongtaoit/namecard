package com.zhongwei.namecard.miniapp.controller;

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
import com.zhongwei.namecard.miniapp.dao.ActReportMapper;
import com.zhongwei.namecard.miniapp.dao.CardChatMapper;
import com.zhongwei.namecard.miniapp.dao.CardFooterMapper;
import com.zhongwei.namecard.miniapp.dao.CardFriendMapper;
import com.zhongwei.namecard.miniapp.dao.CardMapper;
import com.zhongwei.namecard.miniapp.dao.CardMemberMapper;
import com.zhongwei.namecard.miniapp.dao.CardShopsMapper;
import com.zhongwei.namecard.miniapp.model.ActReport;
import com.zhongwei.namecard.miniapp.model.ActReportExample;
import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.CardChat;
import com.zhongwei.namecard.miniapp.model.CardChatExample;
import com.zhongwei.namecard.miniapp.model.CardExample;
import com.zhongwei.namecard.miniapp.model.CardFooter;
import com.zhongwei.namecard.miniapp.model.CardFooterExample;
import com.zhongwei.namecard.miniapp.model.CardFriendExample;
import com.zhongwei.namecard.miniapp.model.CardFriendWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardMember;
import com.zhongwei.namecard.miniapp.model.CardMemberExample;
import com.zhongwei.namecard.miniapp.model.CardShopsExample;
import com.zhongwei.namecard.miniapp.model.CardShopsWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardWithBLOBs;
import com.zhongwei.namecard.miniapp.model.CardFriendExample.Criteria;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.StrUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class ReportController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@Autowired
	private CardFooterMapper cardFooterMapper;
	
	@Autowired
	private CardFriendMapper cardFriendMapper;
	
	@Autowired
	private CardShopsMapper cardShopsMapper;
	
	@Autowired
	private ActReportMapper actReportMapper;
	
	@Autowired
	private CardChatMapper cardChatMapper;
	
	@RequestMapping("/report")
	public Map<String, Object> offline(int uniacid, Integer card_id, String sessionId, 
			Integer act_id, Integer copytype, String copytypeStr, String formId,  HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		if(act_id == null) 
			act_id = 0;
		if(copytype == null) 
			copytype = 0;
		
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		
		if(!StringUtils.hasText(openId) || card_id <= 0) {
			result.put("data", data);
			return result;
		}
		List<CardWithBLOBs> cardList = new ArrayList<CardWithBLOBs>();
		CardWithBLOBs card = null;
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(card_id);
		cardList = cardMapper.selectByExampleWithBLOBs(cardExample);
		card = cardList.size() > 0 ? cardList.get(0) : new CardWithBLOBs();
		
//		$url = $_W["siteroot"] . "app/" . $this->createMobileUrl("chat", array("openid" => $userinfo["openId"], "card_id" => $_GPC["card_id"]));
		String url = "";//******调用后台模块chat方法的url，参数为openid和card_id
		CardMember cardMember = new CardMember();
		List<CardMember> memberList = new ArrayList<CardMember>();
		CardMemberExample memberExample = new CardMemberExample();
		memberExample.createCriteria().andUniacidEqualTo(uniacid).andAidEqualTo(card_id).andOpenidEqualTo(openId);
		memberList = cardMemberMapper.selectByExample(memberExample);
		if(memberList.size() > 0) {
			cardMember = memberList.get(0);
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
		String content = "";
		int num = 0;
		switch(card_id) {
			case 101:
				content = user.getNickname() + " 已支付";
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
				break;
			case 102:
				if(copytype > 0) {
					List<CardFriendWithBLOBs> friendList = new ArrayList<CardFriendWithBLOBs>();
					CardFriendExample friendExample = new CardFriendExample();
					Criteria criteria1 =friendExample.createCriteria();
					criteria1.andUniacidEqualTo(uniacid).andIdEqualTo(copytype);
					friendList = cardFriendMapper.selectByExampleWithBLOBs(friendExample);
					CardFriendWithBLOBs wenz = friendList.size() > 0 ? friendList.get(0) : new CardFriendWithBLOBs();
					if(wenz.getIsCard() > 0) {
						content = user.getNickname() + "分享了你的文章:" + StrUtils.cutStr(wenz.getContentCard(), 8, true);
					}else {
						content = user.getNickname() + "分享了公司文章:" + StrUtils.cutStr(wenz.getTitle(), 8, true);
					}
					if(cardMember.getPbStatus() == 0) {
						QySendUtils.qySend(card.getUserid(), content);
					}
				}
				break;
			case 103:
				if(copytype == 0) {
					content = user.getNickname() + "分享了" + footer.getCardName();
				}else if(copytype == 1) {
					content = user.getNickname() + "分享了" + footer.getShopName();
				}else if(copytype == 2) {
					content = user.getNickname() + "分享了" + footer.getFriendName();
				}else if(copytype == 3) {
					content = user.getNickname() + "分享了" + footer.getWebName();
				}
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
				break;
			case 201:
				content = user.getNickname() + " 更新了银行卡信息";
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
				break;
			case 301:
				List<CardShopsWithBLOBs> shopsList = new ArrayList<CardShopsWithBLOBs>();
				CardShopsExample shopsExample = new CardShopsExample();
				shopsExample.createCriteria().andUniacidEqualTo(uniacid).andIdEqualTo(copytype);
				shopsExample.setOrderByClause("sort DESC");
				PageHelper.startPage(0, 8);
				shopsList = cardShopsMapper.selectByExampleWithBLOBs(shopsExample);
				CardShopsWithBLOBs shop = shopsList.size() > 0 ? shopsList.get(0) : new CardShopsWithBLOBs();
				content = user.getNickname() + " 正在浏览 商品:" + shop.getShopName();
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
				break;
			case 653:
				break;
			case 654:
				content = user.getNickname() + "将您信息保存到通讯录";
				cardMember.setIsPopCard(1);
				cardMemberMapper.updateByPrimaryKey(cardMember);
				break;
			case 655:
				if(StringUtils.hasText(copytypeStr)) {
					String str = copytypeStr;
					if(copytypeStr.equals("email")) {
						str = "邮箱信息";
					}else if(copytypeStr.equals("wxid")) {
						str = "微信信息";
					}else if(copytypeStr.equals("company")) {
						str = "公司信息";
					}else if(copytypeStr.equals("addr")) {
						str = "地址信息";
					}
					content = user.getNickname() + "复制了你的" + str;
				}
				break;
			case 656:
				ActReportExample reportExample = new ActReportExample();
				reportExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andCardIdEqualTo(card_id).andActIdEqualTo(656);
				int count = actReportMapper.countByExample(reportExample);
				num = count + 1;
				content = user.getNickname() + "第" + num + "次打开你的名片";
				break;
			case 657:
				String str = "";
				if(copytype == 0) {
					str = "名片";
					content = user.getNickname() + "正在查看" + footer.getCardName();
				}else if(copytype == 1) {
					str = "产品";
					content = user.getNickname() + "正在查看" + footer.getShopName();
				}else if(copytype == 2) {
					str = "公司信息";
					content = user.getNickname() + "正在查看" + footer.getFriendName();
				}else if(copytype == 3) {
					str = "官网";
					content = user.getNickname() + "正在进入" + footer.getWebName();
				}
				break;
			case 658:
				String str1 = "";
				if(copytype == 0) {
					str1 = "名片";
					content = user.getNickname() + "正在返回你的名片首页";
				}else if(copytype == 1) {
					str1 = "产品";
					content = user.getNickname() + "正在进入您的" + footer.getShopName();
				}else if(copytype == 2) {
					str1 = "公司信息";
					content = user.getNickname() + "正在查看您的" + footer.getFriendName();
				}else if(copytype == 3) {
					str1 = "官网";
					content = user.getNickname() + "正在进入您的" + footer.getWebName();
				}break;
			case 659:
				content = user.getNickname() + "生成了您的海报";
				break;
			case 660:
				content = user.getNickname() + "将你的海报保存了";
				break;
			case 701:
				String subject = "客户行为";
				content = user.getNickname() + "正在进入对话框,赶紧去看看吧!\n";;
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), content);
				}
				sendMessage(subject, content, card.getEmail());
				break;
			case 708:
				String subject1 = "客户行为";
				String copyStr =  htmlspecialcharsDecode(copytypeStr);
				if(StringUtils.hasText(copytypeStr)) {
					String qycontent = user.getNickname() + "发来留言:" + copytypeStr + "\n" + "对话详细:<a href=\"" + url + "\">点击对话</a>";
					if(cardMember.getPbStatus() == 0) {
						QySendUtils.qySend(card.getUserid(), content);
					}
					sendMessage(subject1, qycontent, card.getEmail());
					
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
					chatUser.setMsg(copytypeStr);
					chatUser.setFormid(formId);
					chatUser.setType(1);
					chatUser.setStype(0);
					cardChatMapper.insert(chatUser);
					return result;
				}
				break;
			default: 
				return result;
		}
		
		ActReport reportUser = new ActReport();
		reportUser.setUniacid(uniacid);
		if(act_id == 655) {
			reportUser.setCopytype(copytypeStr);
		}
		if(act_id == 310) {
			reportUser.setCopytype(copytypeStr);
		}
		if(act_id == 656) {
			reportUser.setNum(num);
		}
		if(act_id == 657) {
			reportUser.setFootertype(copytypeStr);
		}
		reportUser.setOpenid(openId);
		reportUser.setCardId(card_id);
		reportUser.setActId(act_id);
		reportUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
		reportUser.setPhone("");
		reportUser.setGender(user.getGender());
		reportUser.setName("");
		reportUser.setCity(user.getCity() == null ? "" : user.getCity());
		reportUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
		reportUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
		reportUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
		reportUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
		reportUser.setAddtime(String.valueOf(System.currentTimeMillis()));
		reportUser.setUpdatetime("");
		reportUser.setActContent(content);
		actReportMapper.insert(reportUser);
		
		String rep = "\n" + "立即回复:<a href=\"" + url + "\">点击对话</a>";
		String subject = "客户行为";
		if(cardMember.getPbStatus() == 0) {
			QySendUtils.qySend(card.getUserid(), content+rep);
		}
		
		result.put("data", data);
		return result;
	}
	
	public int sendMessage(String subject, String qyContent, String email) {
		//******
		return 0;
	}
	
	public String htmlspecialcharsDecode(String str) {
		////****** html格式转换
		return str;
	}

}
