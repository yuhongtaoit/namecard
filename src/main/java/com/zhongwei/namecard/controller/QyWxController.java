package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.SetQYMapper;
import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;

@Controller
@RequestMapping("/qywx")
public class QyWxController {
	
	@Autowired
	private SetQYMapper setQyMapper;
	
	@RequestMapping("/index")
	public String getIndex(Model model) {
		return "qywxindex";
	}
	
	@RequestMapping("/getBasicSet")
	public String getBasicSet(Model model) {
		List<SetQY> setQyList = this.setQyMapper.selectByExample(new SetQYExample());
		if(setQyList!=null && setQyList.size()>0) {
			SetQY setQy = setQyList.get(0);
			model.addAttribute("setQy", setQy);
		}
		return "qywxbasicset";
	}
	
	@RequestMapping("/basicSetSave")
	@Transactional
	public @ResponseBody CommonMessage basicSetSave(HttpServletRequest request, HttpServletResponse response, SetQY setQy){
		CommonMessage message = new CommonMessage();
		this.setQyDefaultValue(setQy);
		if(setQy!=null && setQy.getId()!=null){
			SetQY oldSetQy = this.setQyMapper.selectByPrimaryKey(setQy.getId());
			if(oldSetQy!=null && oldSetQy.getId()!=0){
				this.setQyMapper.updateByPrimaryKey(setQy);
				message.setSuccess(true);
				message.setMessage("保存成功！");
				return message;
			}else{
				message.setSuccess(false);
				message.setMessage("保存失败！");
				return message;
			}
		}
		this.setQyMapper.insert(setQy);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
	private SetQY setQyDefaultValue(SetQY setQy) {
		setQy.setAgentid(setQy.getAgentid()==null?"":setQy.getAgentid());
		setQy.setCorpid(setQy.getCorpid()==null?"":setQy.getCorpid());
		setQy.setSecret(setQy.getSecret()==null?"":setQy.getSecret());
		setQy.setSecret1(setQy.getSecret1()==null?"":setQy.getSecret1());
		setQy.setStatus(setQy.getStatus()==null?0:setQy.getStatus());
		setQy.setUniacid(setQy.getUniacid()==null?0:setQy.getUniacid());
		return setQy;
	}
	
}