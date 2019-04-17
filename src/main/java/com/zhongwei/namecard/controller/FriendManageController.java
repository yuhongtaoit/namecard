package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardFriendMapper;
import com.zhongwei.namecard.dao.CardPlMapper;
import com.zhongwei.namecard.entity.CardFriendExample;
import com.zhongwei.namecard.entity.CardFriendWithBLOBs;
import com.zhongwei.namecard.entity.CardPl;
import com.zhongwei.namecard.entity.CardPlExample;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.service.FriendService;

@Controller
@RequestMapping("/friendManage")
public class FriendManageController {
	
	@Autowired
	private CardFriendMapper friendMapper;
	
	@Autowired
	private CardPlMapper cardPlMapper;
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "friendindex";
	}
	
	@RequestMapping("/getDynamicList")
	public String getDynamicList(Model model) {
		List<CardFriendWithBLOBs> friendList = this.friendMapper.selectByExampleWithBLOBs(new CardFriendExample());
		model.addAttribute("friendList", friendList);
		return "dynamiclist";
	}
	
	@RequestMapping("/dynamicEdit")
	public String newsEdit(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			CardFriendWithBLOBs friend = this.friendMapper.selectByPrimaryKey(id);
			model.addAttribute("friend", friend);
		}else {
			model.addAttribute("friend", new CardFriendWithBLOBs());
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "dynamicedit";
	}
	
	@RequestMapping(value= {"/dynamicSave"},consumes= {"multipart/form-data" })
	@Transactional
	public @ResponseBody CommonMessage newsSave(
			@RequestParam(name="gimageKey",required=false) MultipartFile gimage, 
			HttpServletRequest request, HttpServletResponse response, CardFriendWithBLOBs friend){
		if(friend!=null && friend.getId()!=null && friend.getId()>0) {
			CardFriendWithBLOBs oldFriend = friendMapper.selectByPrimaryKey(friend.getId());
			if(oldFriend!=null && oldFriend.getId()!=0) {
				return this.friendService.updateDynamic(gimage, request, response, friend, oldFriend);
			}
		}
		return this.friendService.createDynamic(gimage, request, response, friend);
	}
	
	@RequestMapping(value="/dynamicDelete")
    @Transactional
    public @ResponseBody CommonMessage dynamicDelete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			CardFriendWithBLOBs friend = this.friendMapper.selectByPrimaryKey(id);
			this.fileUploadService.deleteFile(friend.getHeadImg().trim());
			this.friendMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	@RequestMapping("/getReviewList")
	public String getReviewList(Model model) {
		List<CardPl> cardPlList = this.cardPlMapper.selectByExample(new CardPlExample());
		model.addAttribute("cardPlList", cardPlList);
		return "cardpllist";
	}
	
	@RequestMapping(value="/reviewDelete")
    @Transactional
    public @ResponseBody CommonMessage reviewDelete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			this.cardPlMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
}