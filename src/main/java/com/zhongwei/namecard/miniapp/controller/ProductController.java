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

import com.zhongwei.namecard.dao.ActReportMapper;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardMemberMapper;
import com.zhongwei.namecard.dao.CardProductMapper;
import com.zhongwei.namecard.entity.ActReport;
import com.zhongwei.namecard.entity.ActReportExample;
import com.zhongwei.namecard.entity.AuthUser;
import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;
import com.zhongwei.namecard.entity.CardProductWithBLOBs;
import com.zhongwei.namecard.entity.CardWithBLOBs;
import com.zhongwei.namecard.utils.QySendUtils;
import com.zhongwei.namecard.utils.UserUtils;

@RestController
@RequestMapping("/miniapp")
public class ProductController {
	
	@Autowired
	private CardProductMapper cardProductMapper;
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private ActReportMapper actReportMapper;
	
	@Autowired
	private CardMemberMapper cardMemberMapper;
	
	@RequestMapping("/productDetail")
	public Map<String, Object> productDetail(int uniacid, String sessionId, Integer card_id, Integer product_id,
			HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		if(card_id == null) 
			card_id = 0;
		if(product_id == null) 
			product_id = 0;
		
		CardProductWithBLOBs info = cardProductMapper.selectByPrimaryKey(product_id);
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		AuthUser user = UserUtils.getUserInfo(request, sessionId);
		String openId = user.getOpenid();
		if(StringUtils.hasText(openId) && card_id > 0 && product_id > 0) {
			List<ActReport> list = new ArrayList<ActReport>();
			ActReport myinfo = new ActReport();
			int num = 0;
			ActReportExample reportExample = new ActReportExample();
			reportExample.createCriteria().andUniacidEqualTo(uniacid).andCardIdEqualTo(card_id).
							andOpenidEqualTo(openId).andActIdEqualTo(568).andPIdEqualTo(product_id);
			list = actReportMapper.selectByExample(reportExample);
			if(list.size() > 0) {
				myinfo = list.get(0);
				num = myinfo.getNum() + 1;
			}else {
				num = 1;
			}
			ActReport reportUser = new ActReport();
			reportUser.setUniacid(uniacid);
			reportUser.setNum(num);
			reportUser.setOpenid(openId);
			reportUser.setCardId(card_id);
			reportUser.setActId(568);
			reportUser.setpId(product_id);
			reportUser.setNickname(user.getNickname() == null ? "" : user.getNickname());
			reportUser.setPhone("");
			reportUser.setGender(user.getGender());
			reportUser.setName("");
			reportUser.setCity(user.getCity() == null ? "" : user.getCity());
			reportUser.setProvince(user.getProvince() == null ? "" : user.getProvince());
			reportUser.setLanguage(user.getLanguage() == null ? "" : user.getLanguage());
			reportUser.setAvatarurl(user.getAvatarurl() == null ? "" : user.getAvatarurl());
			reportUser.setAvatar(user.getAvatar() == null ? "" : user.getAvatar());
//			reportUser.setAddtime(String.valueOf(System.currentTimeMillis()));
//			reportUser.setUpdatetime("");
			String content = info.getCpBsName();
			reportUser.setActContent(content);
			List<CardMember> memberList = new ArrayList<CardMember>();
			CardMemberExample memberExample = new CardMemberExample();
			memberExample.createCriteria().andUniacidEqualTo(uniacid).andOpenidEqualTo(openId).andAidEqualTo(card_id);
			memberList = cardMemberMapper.selectByExample(memberExample);
			CardMember cardMember = memberList.size() > 0 ? memberList.get(0) : new CardMember();
			if(list.size() == 0) {
				reportUser.setAddtime(String.valueOf(System.currentTimeMillis()));
				reportUser.setUpdatetime("");
				actReportMapper.insert(reportUser);
				String subject = "客户行为";
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), user.getNickname()+"第" + num + "次" + "查看了你的产品:" + content);
				}
			}else {
				reportUser.setAddtime(StringUtils.hasText(myinfo.getAddtime()) ? myinfo.getAddtime() : String.valueOf(System.currentTimeMillis()));
				reportUser.setUpdatetime(String.valueOf(System.currentTimeMillis()));
				reportUser.setId(myinfo.getId());
				actReportMapper.updateByPrimaryKey(reportUser);
				if(cardMember.getPbStatus() == 0) {
					QySendUtils.qySend(card.getUserid(), user.getNickname()+"第" + num + "次" + "查看了你的产品:" + content);
				}
			}
		}
//		$card["card_logo"] = tomedia($card["card_logo"]); ********
		
		
		data.putAll(info.CardProductToMap(info));
		data.put("card", card);
		data.put("card_id", card_id);
		
//		$info["cp_bs_img"] = unserialize($info["cp_bs_img"]);
//		if (!empty($info["cp_bs_img"])) {
//			foreach ($info["cp_bs_img"] as $key => $val) {
//				$info["cp_bs_img"][$key] = tomedia($val);
//			}
//		}
//		$info["cp_bs_content"] = unserialize($info["cp_bs_content"]);
//		if (!empty($info["cp_bs_content"])) {
//			foreach ($info["cp_bs_content"] as $key => $val) {
//				$info["cp_bs_content"][$key] = tomedia($val);
//			}
//		}
		result.put("data", data);
		return result;
	}

}
