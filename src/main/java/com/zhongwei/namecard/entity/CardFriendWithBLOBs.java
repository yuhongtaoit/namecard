package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.Map;

public class CardFriendWithBLOBs extends CardFriend {
    private String allImg;

    private String contentCard;

    private String content;
    
    public Map<String, Object> friendToMap(CardFriendWithBLOBs card){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("allImg", card.getAllImg());
    	result.put("allImgarr", card.getAllImgarr());
    	result.put("cardId", card.getCardId());
    	result.put("content", card.getContent());
    	result.put("contentCard", card.getContentCard());
    	result.put("headImg", card.getHeadImg());
    	result.put("id", card.getId());
    	result.put("isCard", card.getIsCard());
    	result.put("isup", card.getIsup());
    	result.put("replies", card.getReplies());
    	result.put("sort", card.getSort());
    	result.put("time", card.getTime());
    	result.put("timeStr", card.getTimeStr());
    	result.put("title", card.getTitle());
    	result.put("uniacid", card.getUniacid());
    	result.put("ups", card.getUps());
    	return result;
    }

    public String getAllImg() {
        return allImg;
    }

    public void setAllImg(String allImg) {
        this.allImg = allImg == null ? null : allImg.trim();
    }

    public String getContentCard() {
        return contentCard;
    }

    public void setContentCard(String contentCard) {
        this.contentCard = contentCard == null ? null : contentCard.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}