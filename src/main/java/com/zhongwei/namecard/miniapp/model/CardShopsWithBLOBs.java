package com.zhongwei.namecard.miniapp.model;

public class CardShopsWithBLOBs extends CardShops {
    private String cpBsImg;

    private String topPic;

    private String shopName;

    private String cpBsContent;

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