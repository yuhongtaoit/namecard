package com.zhongwei.namecard.entity;

import java.io.Serializable;

public class Resource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String url;
	
	private String resourceName;
	
	private boolean flag = false;
	
	private String type;

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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (!id.equals(resource.id)) return false;
        return resourceName.equals(resource.resourceName) && url.equals(resource.url) && type.equals(resource.type);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + resourceName.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

}
