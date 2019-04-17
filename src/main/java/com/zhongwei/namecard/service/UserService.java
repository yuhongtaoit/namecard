package com.zhongwei.namecard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.UserMapper;
import com.zhongwei.namecard.entity.Resource;
import com.zhongwei.namecard.entity.Role;
import com.zhongwei.namecard.entity.User;
import com.zhongwei.namecard.entity.UserDetailsEntity;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("查找用户：" + username);
        User user = userDao.getByUserName(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("没有该用户");
        }
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        List<Resource> resources = new ArrayList<>();
        if(roles!=null && roles.size()>0) {
        	for(Role role : roles) {
        		List<Resource> roleResources = this.resourceService.getResourcesByRoleId(role.getId());
        		if(roleResources!=null && roleResources.size()>0) {
        			resources.addAll(roleResources);
        		}
        	}
        }
        return new UserDetailsEntity(user, roles, resources);
	}

}
