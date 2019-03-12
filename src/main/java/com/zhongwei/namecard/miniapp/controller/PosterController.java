package com.zhongwei.namecard.miniapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;

@RestController
@RequestMapping("/miniapp")
public class PosterController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private CardSetMapper setMapper;
	
	@RequestMapping("/cardPoster")
	public Map<String, Object> cardPoster(int uniacid, String sessionId, Integer card_id, HttpServletRequest request){
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> result = new HashMap<>();
		String message = "返回消息";
		int errno = 0;
		data.put("message", message);
		data.put("errno", errno);
		
		CardWithBLOBs card = cardMapper.selectByPrimaryKey(card_id);
		data.putAll(card.cardToMap(card));
//		data.put("", value)
//		$info["card_logo"] = tomedia($info["card_logo"]);
		
		List<CardSet> list = new ArrayList<CardSet>();
		CardSetExample setExample = new CardSetExample();
		setExample.createCriteria().andUniacidEqualTo(uniacid);
		list = setMapper.selectByExample(setExample);
		CardSet cardSet = list.size() > 0 ? list.get(0) : new CardSet();
		data.put("base", cardSet);
		data.put("card_logo", cardSet);
		data.put("card_logo", cardSet);
		
//		$info["base"]["company_logo"] = tomedia($info["base"]["company_logo"]); *******
//		$info["codepng"] = tomedia("addons/dbs_masclwlcard/sea/" . $_W["uniacid"] . "/" . $info["id"] . ".png");
//		$info["codepng"] = str_replace("http://", "https://", $info["codepng"]);
//		$info["card_logo"] = str_replace("http://", "https://", $info["card_logo"]);
//		$info["base"]["company_logo"] = str_replace("http://", "https://", $info["base"]["company_logo"]);
		
		result.put("data", data);
		return result;
	}

}
