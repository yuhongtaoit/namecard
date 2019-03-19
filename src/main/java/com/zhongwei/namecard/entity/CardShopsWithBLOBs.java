package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.Map;

public class CardShopsWithBLOBs extends CardShops {
    private String cpBsImg;

    private String topPic;

    private String shopName;

    private String cpBsContent;
    
    public Map<String, Object> shopsToMap(CardShopsWithBLOBs shops){
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	map.put("addtime", shops.getAddtime());
    	map.put("cpBsContent", shops.getCpBsContent());
    	map.put("cpBsImg", shops.getCpBsImg());
    	map.put("cpBsName", shops.getCpBsName());
    	map.put("fxPrice", shops.getFxPrice());
    	map.put("fxType", shops.getFxType());
    	map.put("gimg", shops.getGimg());
    	map.put("id", shops.getId());
    	map.put("isShow", shops.getIsShow());
    	map.put("noShowPrice", shops.getNoShowPrice());
    	map.put("price", shops.getPrice());
    	map.put("saleNum", shops.getSaleNum());
    	map.put("shopName", shops.getShopName());
    	map.put("shopsNum", shops.getShopsNum());
    	map.put("shopSpec", shops.getShopSpec());
    	map.put("sort", shops.getSort());
    	map.put("spec", shops.getSpec());
    	map.put("specid", shops.getSpecid());
    	map.put("topPic", shops.getTopPic());
    	map.put("typeid", shops.getTypeid());
    	map.put("uniacid", shops.getUniacid());
    	return map;
    }

    public String getCpBsImg() {
        return cpBsImg;
    }

    public void setCpBsImg(String cpBsImg) {
        this.cpBsImg = cpBsImg == null ? null : cpBsImg.trim();
    }

    public String getTopPic() {
        return topPic;
    }

    public void setTopPic(String topPic) {
        this.topPic = topPic == null ? null : topPic.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getCpBsContent() {
        return cpBsContent;
    }

    public void setCpBsContent(String cpBsContent) {
        this.cpBsContent = cpBsContent == null ? null : cpBsContent.trim();
    }
}