package com.zhongwei.namecard.miniapp.model;

import java.util.HashMap;
import java.util.Map;

public class AuthUser {
    private Integer id;

    private String sessionid;

    private Integer uniacid;

    private String unionid;

    private String openid;

    private String nickname;

    private String phone;

    private int gender;

    private String city;

    private String language;

    private String avatarurl;

    private String province;

    private String country;

    private String avatar;
    
    public Map<String, Object> userToMap(AuthUser user){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("id", user.getId());
    	result.put("uniacid", user.getUniacid());
    	result.put("unionid", user.getUnionid());
    	result.put("nickname", user.getNickname());
    	result.put("phone", user.getPhone());
    	result.put("gender", user.getGender());
    	result.put("city", user.getCity());
    	result.put("language", user.getLanguage());
    	result.put("avatarurl", user.getAvatarurl());
    	result.put("province", user.getProvince());
    	result.put("country", user.getCountry());
    	result.put("avatar", user.getAvatar());
    	return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? null : sessionid.trim();
    }

    public Integer getUniacid() {
        return uniacid;
    }

    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}