package com.zhongwei.namecard.miniapp.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CardMember {
    private Integer id;

    private Integer uniacid;

    private String openid;

    private String nickname;

    private String name;

    private String phone;

    private String addtime;

    private String updatetime;

    private Integer aid;

    private int showZan;

    private int isPopCard;

    private int gender;

    private String city;

    private String language;

    private String avatarUrl;

    private String province;

    private String avatar;

    private int gailv;

    private int hmdStatus;

    private int pbStatus;

    private Integer sourceId;

    private BigDecimal canTake;

    private BigDecimal totalBroker;

    private BigDecimal hasTaken;

    private BigDecimal inTaking;

    private BigDecimal notInAccount;

    private Integer sendCardid;
    
    public Map<String, Object> cardMemberToMap(CardMember cardMember){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("id", cardMember.getId());
    	result.put("uniacid", cardMember.getUniacid());
    	result.put("nickname", cardMember.getNickname());
    	result.put("name", cardMember.getName());
    	result.put("phone", cardMember.getPhone());
    	result.put("addtime", cardMember.getAddtime());
    	result.put("updatetime", cardMember.getUpdatetime());
    	result.put("aid", cardMember.getAid());
    	result.put("showZan", cardMember.getShowZan());
    	result.put("isPopCard", cardMember.getIsPopCard());
    	result.put("gender", cardMember.getGender());
    	result.put("city", cardMember.getCity());
    	result.put("language", cardMember.getLanguage());
    	result.put("avatarUrl", cardMember.getAvatarUrl());
    	result.put("province", cardMember.getProvince());
    	result.put("avatar", cardMember.getAvatar());
    	result.put("gailv", cardMember.getGailv());
    	result.put("hmdStatus", cardMember.getHmdStatus());
    	result.put("pbStatus", cardMember.getPbStatus());
    	result.put("sourceId", cardMember.getSourceId());
    	result.put("canTake", cardMember.getCanTake());
    	result.put("totalBroker", cardMember.getTotalBroker());
    	result.put("hasTaken", cardMember.getHasTaken());
    	result.put("inTaking", cardMember.getInTaking());
    	result.put("notInAccount", cardMember.getNotInAccount());
    	result.put("sendCardid", cardMember.getSendCardid());
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
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

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public int getShowZan() {
        return showZan;
    }

    public void setShowZan(int showZan) {
        this.showZan = showZan;
    }

    public int getIsPopCard() {
        return isPopCard;
    }

    public void setIsPopCard(int isPopCard) {
        this.isPopCard = isPopCard;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public int getGailv() {
        return gailv;
    }

    public void setGailv(int gailv) {
        this.gailv = gailv;
    }

    public int getHmdStatus() {
        return hmdStatus;
    }

    public void setHmdStatus(int hmdStatus) {
        this.hmdStatus = hmdStatus;
    }

    public int getPbStatus() {
        return pbStatus;
    }

    public void setPbStatus(int pbStatus) {
        this.pbStatus = pbStatus;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public BigDecimal getCanTake() {
        return canTake;
    }

    public void setCanTake(BigDecimal canTake) {
        this.canTake = canTake;
    }

    public BigDecimal getTotalBroker() {
        return totalBroker;
    }

    public void setTotalBroker(BigDecimal totalBroker) {
        this.totalBroker = totalBroker;
    }

    public BigDecimal getHasTaken() {
        return hasTaken;
    }

    public void setHasTaken(BigDecimal hasTaken) {
        this.hasTaken = hasTaken;
    }

    public BigDecimal getInTaking() {
        return inTaking;
    }

    public void setInTaking(BigDecimal inTaking) {
        this.inTaking = inTaking;
    }

    public BigDecimal getNotInAccount() {
        return notInAccount;
    }

    public void setNotInAccount(BigDecimal notInAccount) {
        this.notInAccount = notInAccount;
    }

    public Integer getSendCardid() {
        return sendCardid;
    }

    public void setSendCardid(Integer sendCardid) {
        this.sendCardid = sendCardid;
    }
}