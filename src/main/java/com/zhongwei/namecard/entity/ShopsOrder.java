package com.zhongwei.namecard.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShopsOrder {
    private Integer id;

    private Integer uniacid;

    private String fromUser;

    private String orderid;

    private Integer staffid;

    private Integer shopsId;

    private Integer cardId;

    private Integer shareid;

    private Integer tid;

    private String transactionId;

    private BigDecimal price;

    private BigDecimal allPrice;

    private Integer addtime;

    private Integer shopsNum;

    private Boolean paid;

    private Boolean hxstatus;

    private String hxname;

    private String nickname;

    private String shopName;

    private String name;

    private String phone;

    private String newSpec;

    private String avatar;

    private String address;

    private String tpText;
    
    private CardShopsWithBLOBs shops;
    
    private String dateline;
    
//    public Map<String, Object> shopsOrderToMap(ShopsOrder shopsOrder){
//    	Map<String, Object> result = new HashMap<String, Object>();
//    	
//    	return result;
//    }

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

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser == null ? null : fromUser.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getShopsId() {
        return shopsId;
    }

    public void setShopsId(Integer shopsId) {
        this.shopsId = shopsId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getShareid() {
        return shareid;
    }

    public void setShareid(Integer shareid) {
        this.shareid = shareid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getShopsNum() {
        return shopsNum;
    }

    public void setShopsNum(Integer shopsNum) {
        this.shopsNum = shopsNum;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getHxstatus() {
        return hxstatus;
    }

    public void setHxstatus(Boolean hxstatus) {
        this.hxstatus = hxstatus;
    }

    public String getHxname() {
        return hxname;
    }

    public void setHxname(String hxname) {
        this.hxname = hxname == null ? null : hxname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getNewSpec() {
        return newSpec;
    }

    public void setNewSpec(String newSpec) {
        this.newSpec = newSpec == null ? null : newSpec.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTpText() {
        return tpText;
    }

    public void setTpText(String tpText) {
        this.tpText = tpText == null ? null : tpText.trim();
    }
    
    public CardShopsWithBLOBs getShops() {
		return shops;
	}
    
    public void setShops(CardShopsWithBLOBs shops) {
		this.shops = shops;
	}
    
    public String getDateline() {
		return dateline;
	}
    
    public void setDateline(String dateline) {
		this.dateline = dateline;
	}
}