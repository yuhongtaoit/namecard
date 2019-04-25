package com.zhongwei.namecard.entity;

import java.util.HashMap;
import java.util.Map;

public class CardWithBLOBs extends Card {
    private String cardInstr;

    private String photo;

    public String getCardInstr() {
        return cardInstr;
    }

    public void setCardInstr(String cardInstr) {
        this.cardInstr = cardInstr == null ? null : cardInstr.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
    
    public Map<String, Object> cardToMap(CardWithBLOBs card){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("address", card.getAddress());
		result.put("browseHeadimgNum", card.getBrowseHeadimgNum());
		result.put("cardForwardStatus", card.getCardForwardStatus());
		result.put("cardId", card.getCardId());
		result.put("cardInstr", card.getCardInstr());
		result.put("cardLevel", card.getCardLevel());
		result.put("cardLogo", card.getCardLogo());
		result.put("cardName", card.getCardName());
		result.put("cardTel", card.getCardTel());
		result.put("companyName", card.getCompanyName());
		result.put("customerDisturb", card.getCustomerDisturb());
		result.put("detailedAddress", card.getDetailedAddress());
		result.put("email", card.getEmail());
		result.put("errmsg", card.getErrmsg());
		result.put("hideProperty", card.getHideProperty());
		result.put("id", card.getId());
		result.put("identify", card.getIdentify());
		result.put("ishide", card.getIshide());
		result.put("isSendcard", card.getIsSendcard());
		result.put("isSendcardId", card.getIsSendcardId());
		result.put("lastUpdateStarTime", card.getLastUpdateStarTime());
		result.put("mrtype", card.getMrtype());
		result.put("openBoss", card.getOpenBoss());
		result.put("phone", card.getPhone());
		result.put("photo", card.getPhoto());
		result.put("roleName", card.getRoleName());
		result.put("seeNum", card.getSeeNum());
		result.put("sex", card.getSex());
		result.put("shareImg", card.getShareImg());
		result.put("shareNum", card.getShareNum());
		result.put("shareTitle", card.getShareTitle());
		result.put("signatureCount", card.getSignatureCount());
		result.put("sort", card.getSort());
		result.put("sourceName", card.getSourceName());
		result.put("status", card.getStatus());
		result.put("templateImg", card.getTemplateImg());
		result.put("templateType", card.getTemplateType());
		result.put("thumbsNum", card.getThumbsNum());
		result.put("totalPicNum", card.getTotalPicNum());
		result.put("uniacid", card.getUniacid());
		result.put("userid", card.getUserid());
		result.put("weixinid", card.getWeixinid());
		result.put("zdMsg", card.getZdMsg());
		result.put("vedio", card.getVedio());
		return result;
	}
}