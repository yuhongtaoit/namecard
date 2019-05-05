package com.zhongwei.namecard.entity;

public class PaySet {
    private Integer id;

    private Integer uniacid;

    private String mchid;

    private String mchkey;

    private String subappid;

    private String submchid;

    private String submchkey;

    private String certpath;

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

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid == null ? null : mchid.trim();
    }

    public String getMchkey() {
        return mchkey;
    }

    public void setMchkey(String mchkey) {
        this.mchkey = mchkey == null ? null : mchkey.trim();
    }

    public String getSubappid() {
        return subappid;
    }

    public void setSubappid(String subappid) {
        this.subappid = subappid == null ? null : subappid.trim();
    }

    public String getSubmchid() {
        return submchid;
    }

    public void setSubmchid(String submchid) {
        this.submchid = submchid == null ? null : submchid.trim();
    }

    public String getSubmchkey() {
        return submchkey;
    }

    public void setSubmchkey(String submchkey) {
        this.submchkey = submchkey == null ? null : submchkey.trim();
    }

    public String getCertpath() {
        return certpath;
    }

    public void setCertpath(String certpath) {
        this.certpath = certpath == null ? null : certpath.trim();
    }
}