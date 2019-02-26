package com.zhongwei.namecard.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zhongwei.namecard.service.RoleService;

public class UserDetailsEntity implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String userName;
    private String passWord;
    //包含着用户对应的所有Role，在使用时调用者给对象注入roles
    private List<RoleEntity> roles;
 
    @Autowired
    private RoleService roleService;
 
    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
 
    //无参构造
    public UserDetailsEntity() {
    }
 
    //用User构造
    public UserDetailsEntity(UserEntity user) {
        this.userName = user.getUserName();
        this.passWord = user.getPassWord();
    }
 
    //用User和List<Role>构造
    public UserDetailsEntity(UserEntity user, List<RoleEntity> roles) {
        this.userName = user.getUserName();
        this.passWord = user.getPassWord();
        this.roles = roles;
    }
 
    public List<RoleEntity> getRoles()
    {
        return roles;
    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
