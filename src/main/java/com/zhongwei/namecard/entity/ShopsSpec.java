package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.Map;

public class ShopsSpec {
    private Integer id;

    private Integer uniacid;

    private String title;

    private Integer sort;

    private Boolean enabled;

    private String specContent;
    
    public Map<String, Object> specToMap(ShopsSpec spec){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("enabled", spec.getEnabled());
    	result.put("id", spec.getId());
    	result.put("sort", spec.getSort());
    	result.put("specContent", spec.getSpecContent());
    	result.put("title", spec.getTitle());
    	result.put("uniacid", spec.getUniacid());
    	return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniacid() {
        return uniacid;
    }

    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSpecContent() {
        return specContent;
    }

    public void setSpecContent(String specContent) {
        this.specContent = specContent == null ? null : specContent.trim();
    }
}