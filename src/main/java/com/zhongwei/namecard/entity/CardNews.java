package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.Map;

public class CardNews {
    private Integer id;

    private Integer uniacid;

    private String title;

    private Integer time;
    
    private String timeStr;

    private String headImg;

    private Integer sort;

    private String content;
    
    public Map<String, Object> cardNewsToMap(CardNews cardNews){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("id", cardNews.getId());
    	result.put("uniacid", cardNews.getUniacid());
    	result.put("title", cardNews.getTitle());
    	result.put("time", cardNews.getTime());
    	result.put("timeStr", cardNews.getTimeStr());
    	result.put("headImg", cardNews.getHeadImg());
    	result.put("sort", cardNews.getSort());
    	result.put("content", cardNews.getContent());
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    public String getTimeStr() {
		return timeStr;
	}
    
    public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
}