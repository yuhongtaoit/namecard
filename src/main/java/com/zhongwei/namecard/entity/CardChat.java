package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.Map;

public class CardChat {
    private Integer id;

    private Integer uniacid;

    private Integer fid;

    private String openid;

    private String nickname;

    private String name;

    private String phone;

    private String addtime;

    private String updatetime;

    private Integer cardId;

    private int status;

    private int isSend;

    private int type;

    private int stype;

    private int gender;

    private int sendFromid;

    private String city;

    private String language;

    private String avatarurl;

    private String formid;

    private String msg;

    private String province;

    private String avatar;
    
    public Map<String, Object> cardChatToMap(CardChat cardChat){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("id", cardChat.getId());
    	result.put("uniacid", cardChat.getUniacid());
    	result.put("fid", cardChat.getFid());
    	result.put("openid", cardChat.getOpenid());
    	result.put("nickname", cardChat.getNickname());
    	result.put("name", cardChat.getName());
    	result.put("phone", cardChat.getPhone());
    	result.put("addtime", cardChat.getAddtime());
    	result.put("updatetime", cardChat.getUpdatetime());
    	result.put("cardId", cardChat.getCardId());
    	result.put("status", cardChat.getStatus());
    	result.put("isSend", cardChat.getIsSend());
    	result.put("type", cardChat.getType());
    	result.put("stype", cardChat.getStype());
    	result.put("gender", cardChat.getGender());
    	result.put("sendFromid", cardChat.getSendFromid());
    	result.put("city", cardChat.getCity());
    	result.put("language", cardChat.getLanguage());
    	result.put("avatarurl", cardChat.getAvatarurl());
    	result.put("formid", cardChat.getFormid());
    	result.put("msg", cardChat.getMsg());
    	result.put("province", cardChat.getProvince());
    	result.put("avatar", cardChat.getAvatar());
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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStype() {
        return stype;
    }

    public void setStype(int stype) {
        this.stype = stype;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getSendFromid() {
        return sendFromid;
    }

    public void setSendFromid(int sendFromid) {
        this.sendFromid = sendFromid;
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

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid == null ? null : formid.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
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
}