package com.zhongwei.namecard.miniapp.model;

import java.util.HashMap;
import java.util.Map;

public class CardWeb {
    private Integer id;

    private Integer uniacid;

    private String video;

    private String images;

    private int txVideo;

    private String cpBsContent;
    
    public Map<String, Object> cardWebToMap(CardWeb web){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("id", web.getId());
    	result.put("uniacid", web.getUniacid());
    	result.put("video", web.getVideo());
    	result.put("images", web.getImages());
    	result.put("txVideo", web.getTxVideo());
    	result.put("cpBsContent", web.getCpBsContent());
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public int getTxVideo() {
        return txVideo;
    }

    public void setTxVideo(int txVideo) {
        this.txVideo = txVideo;
    }

    public String getCpBsContent() {
        return cpBsContent;
    }

    public void setCpBsContent(String cpBsContent) {
        this.cpBsContent = cpBsContent == null ? null : cpBsContent.trim();
    }
}