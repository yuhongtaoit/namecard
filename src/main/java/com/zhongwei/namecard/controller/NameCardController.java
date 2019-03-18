package com.zhongwei.namecard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardMapper;
import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;

@Controller
@RequestMapping("/namecard")
public class NameCardController {
	
	@Autowired
	private CardMapper cardMapper;
	
	@RequestMapping("/getNamecardList")
	public String getUsers(Model model) {
		List<Card> cardList = cardMapper.selectByExample(new CardExample());
		model.addAttribute("cards", cardList);
		return "cardlist";
	}
	
	@RequestMapping("/edit")
	public String editCard(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			Card card = cardMapper.selectByPrimaryKey(id);
			model.addAttribute("card", card);
		}
		return "cardedit";
	}
	
	@RequestMapping("/save")
	@Transactional
	public @ResponseBody CommonMessage saveCard(HttpServletRequest request, HttpServletResponse response, CardWithBLOBs card,
			@RequestParam("logoimage") MultipartFile logoimage, 
			@RequestParam("shareimage") MultipartFile shareimage,
			@RequestParam("style2bgimage") MultipartFile style2bgimage,
			@RequestParam("files") MultipartFile[] personalimage){
		CommonMessage message = new CommonMessage();
		Date date = new Date();
		try {
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			if(!path.exists()) path = new File("");
			String fileName = logoimage.getOriginalFilename();
			@SuppressWarnings("deprecation")
			File tempFile = new File(path.getAbsolutePath(),"static/attachment/"+date.getYear()+"/"+date.getMonth()+"/"+date.getDay()+"/"+date.getTime() + String.valueOf(fileName));
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdir();
			}
			if (!tempFile.exists()) {
				try {
					tempFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				logoimage.transferTo(tempFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        
		if(card!=null && card.getId()!=null){
			Card oldCard = cardMapper.selectByPrimaryKey(card.getId());
			if(oldCard!=null && oldCard.getId()!=0){
//				this.userDao.update(user);
				message.setSuccess(true);
				message.setMessage("保存成功！");
				return message;
			}else{
				message.setSuccess(false);
				message.setMessage("保存失败！");
				return message;
			}
		}
//		this.userDao.insert(user);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
}