package com.zhongwei.namecard.miniapp.model;

public class ShopsSpec {
    private Integer id;

    private Integer uniacid;

    private String title;

    private Integer sort;

    private Boolean enabled;

    private String specContent;

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