package com.zhongwei.namecard.miniapp.model;

public class CardNav {
    private Integer id;

    private Integer uniacid;

    private String images;

    private String path;

    private String title;

    private String newid;

    private String linktype;

    private String appid;

    private String pathWeb;

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNewid() {
        return newid;
    }

    public void setNewid(String newid) {
        this.newid = newid == null ? null : newid.trim();
    }

    public String getLinktype() {
        return linktype;
    }

    public void setLinktype(String linktype) {
        this.linktype = linktype == null ? null : linktype.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getPathWeb() {
        return pathWeb;
    }

    public void setPathWeb(String pathWeb) {
        this.pathWeb = pathWeb == null ? null : pathWeb.trim();
    }
}