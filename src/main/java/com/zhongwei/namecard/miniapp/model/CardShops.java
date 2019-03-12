package com.zhongwei.namecard.miniapp.model;

import java.math.BigDecimal;

public class CardShops {
    private Integer id;

    private Integer uniacid;

    private Integer typeid;

    private Integer specid;

    private Integer saleNum;

    private Integer shopsNum;

    private Integer sort;

    private int shopSpec;

    private int isShow;

    private String cpBsName;

    private String addtime;

    private String gimg;

    private BigDecimal price;

    private int fxType;

    private BigDecimal fxPrice;

    private int noShowPrice;
    
    private ShopsSpec spec;

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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getSpecid() {
        return specid;
    }

    public void setSpecid(Integer specid) {
        this.specid = specid;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getShopsNum() {
        return shopsNum;
    }

    public void setShopsNum(Integer shopsNum) {
        this.shopsNum = shopsNum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public int getShopSpec() {
        return shopSpec;
    }

    public void setShopSpec(int shopSpec) {
        this.shopSpec = shopSpec;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public String getCpBsName() {
        return cpBsName;
    }

    public void setCpBsName(String cpBsName) {
        this.cpBsName = cpBsName == null ? null : cpBsName.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg == null ? null : gimg.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getFxType() {
        return fxType;
    }

    public void setFxType(int fxType) {
        this.fxType = fxType;
    }

    public BigDecimal getFxPrice() {
        return fxPrice;
    }

    public void setFxPrice(BigDecimal fxPrice) {
        this.fxPrice = fxPrice;
    }

    public int getNoShowPrice() {
        return noShowPrice;
    }

    public void setNoShowPrice(int noShowPrice) {
        this.noShowPrice = noShowPrice;
    }
    
    public ShopsSpec getSpec() {
		return spec;
	}
    
    public void setSpec(ShopsSpec spec) {
		this.spec = spec;
	}
    
}