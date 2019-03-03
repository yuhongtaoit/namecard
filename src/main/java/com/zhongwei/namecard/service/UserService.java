package com.zhongwei.namecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zhongwei.namecard.dao.UserDao;
import com.zhongwei.namecard.entity.RoleEntity;
import com.zhongwei.namecard.entity.UserDetailsEntity;
import com.zhongwei.namecard.entity.UserEntity;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("查找用户：" + username);
        UserEntity user = userDao.getByUserName(username).get(0);
        if(user == null)
        {
            throw new UsernameNotFoundException("没有该用户");
        }
        List<RoleEntity> roles = roleService.getRolesByUserId(user.getId());
        return new UserDetailsEntity(user, roles);
	}

}
