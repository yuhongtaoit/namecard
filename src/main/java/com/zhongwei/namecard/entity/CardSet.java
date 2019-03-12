package com.zhongwei.namecard.entity;

import java.math.BigDecimal;

public class CardSet {
    private Integer id;

    private Integer uniacid;

    private String companyName;

    private String lat;

    private String lng;

    private Integer num;

    private String companyAddr;

    private String templateId;

    private Boolean openShop;

    private String companyTel;

    private String companyLogo;

    private String shopBg;

    private Byte openRedpack;

    private BigDecimal redpackMin;

    private BigDecimal redpackMax;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public Boolean getOpenShop() {
        return openShop;
    }

    public void setOpenShop(Boolean openShop) {
        this.openShop = openShop;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.trim();
    }

    public String getShopBg() {
        return shopBg;
    }

    public void setShopBg(String shopBg) {
        this.shopBg = shopBg == null ? null : shopBg.trim();
    }

    public Byte getOpenRedpack() {
        return openRedpack;
    }

    public void setOpenRedpack(Byte openRedpack) {
        this.openRedpack = openRedpack;
    }

    public BigDecimal getRedpackMin() {
        return redpackMin;
    }

    public void setRedpackMin(BigDecimal redpackMin) {
        this.redpackMin = redpackMin;
    }

    public BigDecimal getRedpackMax() {
        return redpackMax;
    }

    public void setRedpackMax(BigDecimal redpackMax) {
        this.redpackMax = redpackMax;
    }
}