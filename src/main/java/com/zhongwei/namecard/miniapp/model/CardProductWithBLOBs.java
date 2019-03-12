package com.zhongwei.namecard.miniapp.model;

import java.util.HashMap;
import java.util.Map;

public class CardProductWithBLOBs extends CardProduct {
    private String cpBsImg;

    private String cpBsContent;
    
    public Map<String, Object> CardProductToMap(CardProductWithBLOBs product) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("id", product.getId());
    	result.put("cpBsName", product.getCpBsName());
    	result.put("cpBsPrice", product.getCpBsPrice());
    	result.put("sort", product.getSort());
    	result.put("uniacid", product.getUniacid());
    	result.put("cpBsImg", product.getCpBsImg());
    	result.put("cpBsContent", product.getCpBsContent());
    	
    	return result;
    }

    public String getCpBsImg() {
        return cpBsImg;
    }

    public void setCpBsImg(String cpBsImg) {
        this.cpBsImg = cpBsImg == null ? null : cpBsImg.trim();
    }

    public String getCpBsContent() {
        return cpBsContent;
    }

    public void setCpBsContent(String cpBsContent) {
        this.cpBsContent = cpBsContent == null ? null : cpBsContent.trim();
    }
}