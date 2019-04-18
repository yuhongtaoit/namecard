package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.ShopsSpecMapper;
import com.zhongwei.namecard.entity.ShopsSpec;
import com.zhongwei.namecard.entity.ShopsSpecExample;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Controller
@RequestMapping("/shopProperty")
public class ShopPropertyController {
	
	@Autowired
	private ShopsSpecMapper shopsPropertyMapper;
	
	@RequestMapping("/getPropertyList")
	public String getPropertyList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		ShopsSpecExample shopsSpecExample = new ShopsSpecExample();
		shopsSpecExample.createCriteria().andUniacidEqualTo(user.getUniacid());
		List<ShopsSpec> shopPropertyList = shopsPropertyMapper.selectByExample(shopsSpecExample);
		model.addAttribute("propertys", shopPropertyList);
		return "shoppropertylist";
	}
	
	@RequestMapping("/edit")
	public String editProperty(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			ShopsSpec shopProperty = shopsPropertyMapper.selectByPrimaryKey(id);
			model.addAttribute("property", shopProperty);
		}
		return "shoppropertyedit";
	}
	
	@RequestMapping(value= {"/save"})
	@Transactional
	public @ResponseBody CommonMessage saveProperty(
			HttpServletRequest request, HttpServletResponse response, Principal principal, Authentication authentication, ShopsSpec property){
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		property.setUniacid(user.getUniacid());
		this.setPropertyDefaultValue(property);
		if(property!=null && property.getId()!=null && property.getId()>0) {
			ShopsSpec oldProperty = shopsPropertyMapper.selectByPrimaryKey(property.getId());
			if(oldProperty!=null && oldProperty.getId()!=0) {
				try {
					this.shopsPropertyMapper.updateByPrimaryKey(property);
					message.setSuccess(true);
					message.setMessage("保存成功！");
					return message;
				} catch (Exception e) {
					message.setSuccess(false);
					message.setMessage("保存失败！");
					return message;
				}
			}
		}
		try {
			this.shopsPropertyMapper.insert(property);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	@RequestMapping(value="/delete")
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			shopsPropertyMapper.deleteByPrimaryKey(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
	
	private ShopsSpec setPropertyDefaultValue(ShopsSpec property) {
		property.setEnabled(property.getEnabled()==null?true:property.getEnabled());
		property.setSort(property.getSort()==null?0:property.getSort());
		property.setSpecContent(property.getSpecContent()==null?"":property.getSpecContent());
		property.setTitle(property.getTitle()==null?"":property.getTitle());
		property.setUniacid(property.getUniacid()==null?2:property.getUniacid());
		return property;
	}
}