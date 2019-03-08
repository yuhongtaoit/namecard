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

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.ResourceDao;
import com.zhongwei.namecard.dao.RoleDao;
import com.zhongwei.namecard.dao.RoleResourceDao;
import com.zhongwei.namecard.dao.UserRoleDao;
import com.zhongwei.namecard.entity.ResourceEntity;
import com.zhongwei.namecard.entity.RoleEntity;
import com.zhongwei.namecard.service.ResourceService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/getRoleList")
	public String getUsers(Model model) {
		List<RoleEntity> roles = roleDao.getAll();
		model.addAttribute("roles", roles);
		return "rolelist";
	}
	
	@RequestMapping("/getResources")
	public String getResources(HttpServletRequest request, HttpServletResponse response, Model model, Integer roleId){
		List<ResourceEntity> resources = resourceDao.getAll();
		List<ResourceEntity> roleResources = resourceService.getResourcesByRoleId(roleId);
		if(resources!=null && resources.size()>0) {
			for(ResourceEntity resource : resources) {
				if(roleResources!=null && roleResources.size()>0) {
					for(ResourceEntity roleResource : roleResources) {
						if(resource.getId()==roleResource.getId()) {
							resource.setFlag(true);
						}
					}
				}
			}
		}
		model.addAttribute("resources", resources);
		model.addAttribute("roleId", roleId);
		return "selectresources";
	}
	
	@RequestMapping("/saveResources")
	public @ResponseBody CommonMessage saveResources(HttpServletRequest request, HttpServletResponse response, 
			Model model, Integer roleId, 
			@RequestParam(required = false, value = "resourceIds[]") List<Integer> resourceIds){
		CommonMessage message = new CommonMessage();
		try {
			resourceService.updateRoleResources(roleId, resourceIds);
			message.setSuccess(true);
			message.setMessage("保存成功");
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage(e.toString());
			return message;
		}
		return message;
	}
	
	@RequestMapping("/edit")
	public String editRole(HttpServletRequest request, HttpServletResponse response, Model model){
		String idStr = request.getParameter("id");
		if(idStr!=null && idStr.trim().length()>0){
			int id = Integer.valueOf(idStr);
			RoleEntity role = this.roleDao.getOne(id);
			model.addAttribute("role", role);
		}
		return "roleedit";
	}
	
	@RequestMapping("/save")
	@Transactional
	public @ResponseBody CommonMessage saveRole(HttpServletRequest request, HttpServletResponse response, RoleEntity role){
		CommonMessage message = new CommonMessage();
		if(role!=null && role.getId()!=null){
			RoleEntity oldRole = this.roleDao.getOne(role.getId());
			if(oldRole!=null && oldRole.getId()!=0){
				this.roleDao.update(role);
				message.setSuccess(true);
				message.setMessage("保存成功！");
				return message;
			}else{
				message.setSuccess(false);
				message.setMessage("保存失败！");
				return message;
			}
		}
		this.roleDao.insert(role);
		message.setSuccess(true);
		message.setMessage("保存成功！");
		return message;
	}
	
    @RequestMapping(value="/delete")
    @Transactional
    public @ResponseBody CommonMessage delete(Integer id) {
		CommonMessage message = new CommonMessage();
		if(id!=null && id>0){
			this.roleDao.delete(id);
			this.userRoleDao.deleteByRoleId(id);
			this.roleResourceDao.deleteByRoleId(id);
			message.setSuccess(true);
			message.setMessage("删除成功！");
		}else{
			message.setSuccess(false);
			message.setMessage("删除失败！");
		}
		return message;
    }
    
    
}