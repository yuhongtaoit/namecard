package com.zhongwei.namecard.entity;

import java.util.List;

public class CardFriend {
    private Integer id;

    private Integer uniacid;

    private Integer cardId;

    private int isCard;

    private String title;

    private Integer time;
    
    private String timeStr;

    private String headImg;

    private Integer sort;
    
    private int isup;
    
    private List<CardZan> ups;
    
    private List<CardPl> replies;
    
    private String[] allImgarr;

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

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public int getIsCard() {
        return isCard;
    }

    public void setIsCard(int isCard) {
        this.isCard = isCard;
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

	public List<CardZan> getUps() {
		return ups;
	}

	public void setUps(List<CardZan> ups) {
		this.ups = ups;
	}

	public List<CardPl> getReplies() {
		return replies;
	}

	public void setReplies(List<CardPl> replies) {
		this.replies = replies;
	}
    
	public int getIsup() {
		return isup;
	}
	
    public void setIsup(int isup) {
		this.isup = isup;
	}
    
    public String[] getAllImgarr() {
		return allImgarr;
	}
    
    public void setAllImgarr(String[] strings) {
		this.allImgarr = strings;
	}
    
    public String getTimeStr() {
		return timeStr;
	}
    
    public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
}