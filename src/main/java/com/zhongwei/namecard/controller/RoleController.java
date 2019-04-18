package com.zhongwei.namecard.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.ResourceMapper;
import com.zhongwei.namecard.dao.RoleMapper;
import com.zhongwei.namecard.dao.RoleResourceMapper;
import com.zhongwei.namecard.dao.UserRoleMapper;
import com.zhongwei.namecard.entity.Resource;
import com.zhongwei.namecard.entity.Role;
import com.zhongwei.namecard.entity.UserDetailsEntity;
import com.zhongwei.namecard.service.ResourceService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleMapper roleDao;
	
	@Autowired
	private ResourceMapper resourceDao;
	
	@Autowired
	private UserRoleMapper userRoleDao;
	
	@Autowired
	private RoleResourceMapper roleResourceDao;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/getRoleList")
	public String getRoleList(Model model, Principal principal, Authentication authentication) {
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		List<Role> roles = roleDao.getByUniacid(user.getUniacid());
		model.addAttribute("roles", roles);
		return "rolelist";
	}
	
	@RequestMapping("/getResources")
	public String getResources(HttpServletRequest request, HttpServletResponse response, Model model, Principal principal, Authentication authentication, Integer roleId){
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		List<Resource> interfaceResources = new ArrayList<>();
		List<Resource> menuResources = new ArrayList<>();
		if(hasAdminRole(user.getRoles())) {
			interfaceResources = resourceDao.getByType("interface");
			menuResources = resourceDao.getByType("menu");
		}else {
			List<Resource> grantResources = user.getResources();
			for(Resource resource : grantResources) {
				if("interface".equals(resource.getType()) && !interfaceResources.contains(resource)) {
					interfaceResources.add(resource);
				}
				if("menu".equals(resource.getType()) && !menuResources.contains(resource)) {
					menuResources.add(resource);
				}
			}
		}
		List<Resource> roleResources = resourceService.getResourcesByRoleId(roleId);
		if(interfaceResources!=null && interfaceResources.size()>0) {
			for(Resource resource : interfaceResources) {
				if(roleResources!=null && roleResources.size()>0) {
					for(Resource roleResource : roleResources) {
						if(resource.getId()==roleResource.getId()) {
							resource.setFlag(true);
						}
					}
				}
			}
		}
		if(menuResources!=null && menuResources.size()>0) {
			for(Resource resource : menuResources) {
				if(roleResources!=null && roleResources.size()>0) {
					for(Resource roleResource : roleResources) {
						if(resource.getId()==roleResource.getId()) {
							resource.setFlag(true);
						}
					}
				}
			}
		}
		model.addAttribute("interfaceResources", interfaceResources);
		model.addAttribute("menuResources", menuResources);
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
			Role role = this.roleDao.getOne(id);
			model.addAttribute("role", role);
		}
		return "roleedit";
	}
	
	@RequestMapping("/save")
	@Transactional
	public @ResponseBody CommonMessage saveRole(HttpServletRequest request, HttpServletResponse response, Role role, Principal principal, Authentication authentication){
		CommonMessage message = new CommonMessage();
		UserDetailsEntity user = (UserDetailsEntity) authentication.getPrincipal();
		role.setUniacid(user.getUniacid());
		Role repeatTest = this.roleDao.getByRoleName(role.getRoleName());
		if(role!=null && role.getId()!=null){
			Role oldRole = this.roleDao.getOne(role.getId());
			if(oldRole!=null && oldRole.getId()!=0){
				if(!oldRole.getRoleName().equals(role.getRoleName()) && repeatTest!=null) {
					message.setSuccess(false);
					message.setMessage("角色名重复！");
					return message;
				}
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
		if(repeatTest!=null) {
			message.setSuccess(false);
			message.setMessage("角色名重复！");
			return message;
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
    
    private boolean hasAdminRole(List<Role> roles) {
		for(Role role : roles) {
			if("ROLE_ADMIN".equals(role.getRoleName())) {
				return true;
			}
		}
		return false;
	}
    
}