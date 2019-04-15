package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardFriendWithBLOBs extends CardFriend {
    private String allImg;

    private String contentCard;

    private String content;
    
    private String is_my;
    
    private CardWithBLOBs card_info;
    
    private CardSet base_set;
    
    private List<CardPl> pl_list;
    
    private List<CardZan> z_list;
    
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
    
    public String getIs_my() {
		return is_my;
	}
    
    public void setIs_my(String is_my) {
		this.is_my = is_my;
	}
    
    public CardWithBLOBs getCard_info() {
		return card_info;
	}
    
    public void setCard_info(CardWithBLOBs card_info) {
		this.card_info = card_info;
	}
    
    public CardSet getBase_set() {
		return base_set;
	}
    
    public void setBase_set(CardSet base_set) {
		this.base_set = base_set;
	}
    
    public List<CardPl> getPl_list() {
		return pl_list;
	}
    
    public void setPl_list(List<CardPl> pl_list) {
		this.pl_list = pl_list;
	}
    
    public List<CardZan> getZ_list() {
		return z_list;
	}
    
    public void setZ_list(List<CardZan> z_list) {
		this.z_list = z_list;
	}
}