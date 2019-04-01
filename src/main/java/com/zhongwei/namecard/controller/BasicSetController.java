package com.zhongwei.namecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongwei.namecard.dao.CardSetMapper;
import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;

@Controller
@RequestMapping("/basic")
public class BasicSetController {
	
	@Autowired
	private CardSetMapper cardSetMapper;
	
	@RequestMapping("/index")
	public String getIndex(Model model) {
		return "basicsetindex";
	}
	
	@RequestMapping("/getBasicSet")
	public String getBasicSet(Model model) {
		List<CardSet> cardSetList = this.cardSetMapper.selectByExample(new CardSetExample());
		if(cardSetList!=null && cardSetList.size()>0) {
			CardSet cardSet = cardSetList.get(0);
			model.addAttribute("cardSet", cardSet);
		}
		return "basicset";
	}
	
	@RequestMapping("/updateBottomDH")
	public String updateBottomDH(Model model) {
		return "test";
	}
	
}