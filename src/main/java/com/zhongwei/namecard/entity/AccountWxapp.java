package com.zhongwei.namecard.entity;

public class AccountWxapp {
    private Integer acid;

    private Integer uniacid;

    private String token;

    private String encodingaeskey;

    private Byte level;

    private String account;

    private String original;

    private String key;

    private String secret;

    private String name;

    private String appdomain;

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public Integer getUniacid() {
        return uniacid;
    }

    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getEncodingaeskey() {
        return encodingaeskey;
    }

    public void setEncodingaeskey(String encodingaeskey) {
        this.encodingaeskey = encodingaeskey == null ? null : encodingaeskey.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original == null ? null : original.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAppdomain() {
        return appdomain;
    }

    public void setAppdomain(String appdomain) {
        this.appdomain = appdomain == null ? null : appdomain.trim();
    }
}