package com.zhongwei.namecard.component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.zhongwei.namecard.entity.ResourceEntity;
import com.zhongwei.namecard.entity.RoleEntity;
import com.zhongwei.namecard.service.ResourceService;
import com.zhongwei.namecard.service.RoleService;

@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource{

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		//得到用户的请求地址,控制台输出一下
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        System.out.println("用户请求的地址是：" + requestUrl);
 
        //如果登录页面就不需要权限
        if ("/login".equals(requestUrl)) {
            return null;
        }
 
        ResourceEntity resource = resourceService.getResourceByUrl(requestUrl);
 
        Collection<ConfigAttribute> collection = new LinkedList<>();
        //如果没有匹配的url则说明大家都可以访问
        if(resource == null) {
        	ConfigAttribute configAttribute = new SecurityConfig("ROLE_LOGIN");
        	collection.add(configAttribute);
            return collection;
        }
 
        //将resource所需要到的roles按框架要求封装返回（ResourceService里面的getRoles方法是基于RoleRepository实现的）
        List<RoleEntity> roles = roleService.getRolesByResourceId(resource.getId());
        if(roles!=null && roles.size()>0) {
        	for(RoleEntity role : roles) {
        		ConfigAttribute configAttribute = new SecurityConfig(role.getRoleName());
        		collection.add(configAttribute);
        	}
        }else {
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        	if (auth instanceof AnonymousAuthenticationToken) { 
        		ConfigAttribute configAttribute = new SecurityConfig("ROLE_LOGIN");
        		collection.add(configAttribute);
        	}else {
        		ConfigAttribute configAttribute = new SecurityConfig("ROLE_NO_AUTH");
        		collection.add(configAttribute);
        	}
        }
        return collection;

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

}
