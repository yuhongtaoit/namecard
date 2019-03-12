package com.zhongwei.namecard.miniapp.model;

public class CardProduct {
    private Integer id;

    private Integer uniacid;

    private String cpBsName;

    private String cpBsPrice;

    private Integer sort;

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

    public String getCpBsName() {
        return cpBsName;
    }

    public void setCpBsName(String cpBsName) {
        this.cpBsName = cpBsName == null ? null : cpBsName.trim();
    }

    public String getCpBsPrice() {
        return cpBsPrice;
    }

    public void setCpBsPrice(String cpBsPrice) {
        this.cpBsPrice = cpBsPrice == null ? null : cpBsPrice.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}