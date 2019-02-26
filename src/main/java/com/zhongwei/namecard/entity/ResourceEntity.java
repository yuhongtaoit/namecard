package com.zhongwei.namecard.entity;

import java.io.Serializable;

public class ResourceEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String url;
	
	private String resourceName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
