package com.zhongwei.namecard.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsEntity implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
    private String passWord;
    
    private Integer uniacid;
    
    private List<Role> roles;
    
    private List<Resource> resources;
 
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
 
    public UserDetailsEntity() {
    	
    }
 
    public UserDetailsEntity(User user) {
        this.userName = user.getUserName();
        this.passWord = user.getPassWord();
    }
 
    public UserDetailsEntity(User user, List<Role> roles, List<Resource> resources) {
        this.userName = user.getUserName();
        this.passWord = user.getPassWord();
        this.uniacid = user.getUniacid();
        this.roles = roles;
        this.resources = resources;
    }
 
    public List<Role> getRoles() {
        return roles;
    }

	public List<Resource> getResources() {
		return resources;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(roles!=null && roles.size()>0) {
			for(Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
		}
        return authorities;
	}

	@Override
	public String getPassword() {
		return passWord;
	}
	
	public Integer getUniacid() {
		return uniacid;
	}

	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
