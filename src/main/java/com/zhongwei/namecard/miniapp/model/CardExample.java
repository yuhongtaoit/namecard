package com.zhongwei.namecard.miniapp.model;

import java.util.ArrayList;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUniacidIsNull() {
            addCriterion("uniacid is null");
            return (Criteria) this;
        }

        public Criteria andUniacidIsNotNull() {
            addCriterion("uniacid is not null");
            return (Criteria) this;
        }

        public Criteria andUniacidEqualTo(Integer value) {
            addCriterion("uniacid =", value, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidNotEqualTo(Integer value) {
            addCriterion("uniacid <>", value, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidGreaterThan(Integer value) {
            addCriterion("uniacid >", value, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uniacid >=", value, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidLessThan(Integer value) {
            addCriterion("uniacid <", value, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidLessThanOrEqualTo(Integer value) {
            addCriterion("uniacid <=", value, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidIn(List<Integer> values) {
            addCriterion("uniacid in", values, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidNotIn(List<Integer> values) {
            addCriterion("uniacid not in", values, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidBetween(Integer value1, Integer value2) {
            addCriterion("uniacid between", value1, value2, "uniacid");
            return (Criteria) this;
        }

        public Criteria andUniacidNotBetween(Integer value1, Integer value2) {
            addCriterion("uniacid not between", value1, value2, "uniacid");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNull() {
            addCriterion("identify is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNotNull() {
            addCriterion("identify is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyEqualTo(String value) {
            addCriterion("identify =", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotEqualTo(String value) {
            addCriterion("identify <>", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThan(String value) {
            addCriterion("identify >", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("identify >=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThan(String value) {
            addCriterion("identify <", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThanOrEqualTo(String value) {
            addCriterion("identify <=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLike(String value) {
            addCriterion("identify like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotLike(String value) {
            addCriterion("identify not like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyIn(List<String> values) {
            addCriterion("identify in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotIn(List<String> values) {
            addCriterion("identify not in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyBetween(String value1, String value2) {
            addCriterion("identify between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotBetween(String value1, String value2) {
            addCriterion("identify not between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andCardLogoIsNull() {
            addCriterion("card_logo is null");
            return (Criteria) this;
        }

        public Criteria andCardLogoIsNotNull() {
            addCriterion("card_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCardLogoEqualTo(String value) {
            addCriterion("card_logo =", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoNotEqualTo(String value) {
            addCriterion("card_logo <>", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoGreaterThan(String value) {
            addCriterion("card_logo >", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoGreaterThanOrEqualTo(String value) {
            addCriterion("card_logo >=", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoLessThan(String value) {
            addCriterion("card_logo <", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoLessThanOrEqualTo(String value) {
            addCriterion("card_logo <=", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoLike(String value) {
            addCriterion("card_logo like", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoNotLike(String value) {
            addCriterion("card_logo not like", value, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoIn(List<String> values) {
            addCriterion("card_logo in", values, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoNotIn(List<String> values) {
            addCriterion("card_logo not in", values, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoBetween(String value1, String value2) {
            addCriterion("card_logo between", value1, value2, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andCardLogoNotBetween(String value1, String value2) {
            addCriterion("card_logo not between", value1, value2, "cardLogo");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNull() {
            addCriterion("card_name is null");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNotNull() {
            addCriterion("card_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardNameEqualTo(String value) {
            addCriterion("card_name =", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotEqualTo(String value) {
            addCriterion("card_name <>", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThan(String value) {
            addCriterion("card_name >", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("card_name >=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThan(String value) {
            addCriterion("card_name <", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThanOrEqualTo(String value) {
            addCriterion("card_name <=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLike(String value) {
            addCriterion("card_name like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotLike(String value) {
            addCriterion("card_name not like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameIn(List<String> values) {
            addCriterion("card_name in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotIn(List<String> values) {
            addCriterion("card_name not in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameBetween(String value1, String value2) {
            addCriterion("card_name between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotBetween(String value1, String value2) {
            addCriterion("card_name not between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andErrmsgIsNull() {
            addCriterion("errmsg is null");
            return (Criteria) this;
        }

        public Criteria andErrmsgIsNotNull() {
            addCriterion("errmsg is not null");
            return (Criteria) this;
        }

        public Criteria andErrmsgEqualTo(String value) {
            addCriterion("errmsg =", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotEqualTo(String value) {
            addCriterion("errmsg <>", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgGreaterThan(String value) {
            addCriterion("errmsg >", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgGreaterThanOrEqualTo(String value) {
            addCriterion("errmsg >=", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLessThan(String value) {
            addCriterion("errmsg <", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLessThanOrEqualTo(String value) {
            addCriterion("errmsg <=", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLike(String value) {
            addCriterion("errmsg like", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotLike(String value) {
            addCriterion("errmsg not like", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgIn(List<String> values) {
            addCriterion("errmsg in", values, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotIn(List<String> values) {
            addCriterion("errmsg not in", values, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgBetween(String value1, String value2) {
            addCriterion("errmsg between", value1, value2, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotBetween(String value1, String value2) {
            addCriterion("errmsg not between", value1, value2, "errmsg");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andWeixinidIsNull() {
            addCriterion("weixinid is null");
            return (Criteria) this;
        }

        public Criteria andWeixinidIsNotNull() {
            addCriterion("weixinid is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinidEqualTo(String value) {
            addCriterion("weixinid =", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidNotEqualTo(String value) {
            addCriterion("weixinid <>", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidGreaterThan(String value) {
            addCriterion("weixinid >", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidGreaterThanOrEqualTo(String value) {
            addCriterion("weixinid >=", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidLessThan(String value) {
            addCriterion("weixinid <", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidLessThanOrEqualTo(String value) {
            addCriterion("weixinid <=", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidLike(String value) {
            addCriterion("weixinid like", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidNotLike(String value) {
            addCriterion("weixinid not like", value, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidIn(List<String> values) {
            addCriterion("weixinid in", values, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidNotIn(List<String> values) {
            addCriterion("weixinid not in", values, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidBetween(String value1, String value2) {
            addCriterion("weixinid between", value1, value2, "weixinid");
            return (Criteria) this;
        }

        public Criteria andWeixinidNotBetween(String value1, String value2) {
            addCriterion("weixinid not between", value1, value2, "weixinid");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Boolean value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Boolean value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Boolean value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Boolean value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Boolean value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Boolean> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Boolean> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Boolean value1, Boolean value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNull() {
            addCriterion("template_type is null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNotNull() {
            addCriterion("template_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeEqualTo(Boolean value) {
            addCriterion("template_type =", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotEqualTo(Boolean value) {
            addCriterion("template_type <>", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThan(Boolean value) {
            addCriterion("template_type >", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("template_type >=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThan(Boolean value) {
            addCriterion("template_type <", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("template_type <=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIn(List<Boolean> values) {
            addCriterion("template_type in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotIn(List<Boolean> values) {
            addCriterion("template_type not in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("template_type between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("template_type not between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusIsNull() {
            addCriterion("card_forward_status is null");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusIsNotNull() {
            addCriterion("card_forward_status is not null");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusEqualTo(Boolean value) {
            addCriterion("card_forward_status =", value, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusNotEqualTo(Boolean value) {
            addCriterion("card_forward_status <>", value, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusGreaterThan(Boolean value) {
            addCriterion("card_forward_status >", value, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("card_forward_status >=", value, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusLessThan(Boolean value) {
            addCriterion("card_forward_status <", value, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("card_forward_status <=", value, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusIn(List<Boolean> values) {
            addCriterion("card_forward_status in", values, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusNotIn(List<Boolean> values) {
            addCriterion("card_forward_status not in", values, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("card_forward_status between", value1, value2, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andCardForwardStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("card_forward_status not between", value1, value2, "cardForwardStatus");
            return (Criteria) this;
        }

        public Criteria andSeeNumIsNull() {
            addCriterion("see_num is null");
            return (Criteria) this;
        }

        public Criteria andSeeNumIsNotNull() {
            addCriterion("see_num is not null");
            return (Criteria) this;
        }

        public Criteria andSeeNumEqualTo(Integer value) {
            addCriterion("see_num =", value, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumNotEqualTo(Integer value) {
            addCriterion("see_num <>", value, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumGreaterThan(Integer value) {
            addCriterion("see_num >", value, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("see_num >=", value, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumLessThan(Integer value) {
            addCriterion("see_num <", value, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumLessThanOrEqualTo(Integer value) {
            addCriterion("see_num <=", value, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumIn(List<Integer> values) {
            addCriterion("see_num in", values, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumNotIn(List<Integer> values) {
            addCriterion("see_num not in", values, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumBetween(Integer value1, Integer value2) {
            addCriterion("see_num between", value1, value2, "seeNum");
            return (Criteria) this;
        }

        public Criteria andSeeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("see_num not between", value1, value2, "seeNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumIsNull() {
            addCriterion("browse_headimg_num is null");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumIsNotNull() {
            addCriterion("browse_headimg_num is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumEqualTo(Integer value) {
            addCriterion("browse_headimg_num =", value, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumNotEqualTo(Integer value) {
            addCriterion("browse_headimg_num <>", value, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumGreaterThan(Integer value) {
            addCriterion("browse_headimg_num >", value, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_headimg_num >=", value, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumLessThan(Integer value) {
            addCriterion("browse_headimg_num <", value, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumLessThanOrEqualTo(Integer value) {
            addCriterion("browse_headimg_num <=", value, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumIn(List<Integer> values) {
            addCriterion("browse_headimg_num in", values, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumNotIn(List<Integer> values) {
            addCriterion("browse_headimg_num not in", values, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumBetween(Integer value1, Integer value2) {
            addCriterion("browse_headimg_num between", value1, value2, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andBrowseHeadimgNumNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_headimg_num not between", value1, value2, "browseHeadimgNum");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSignatureCountIsNull() {
            addCriterion("signature_count is null");
            return (Criteria) this;
        }

        public Criteria andSignatureCountIsNotNull() {
            addCriterion("signature_count is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureCountEqualTo(Integer value) {
            addCriterion("signature_count =", value, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountNotEqualTo(Integer value) {
            addCriterion("signature_count <>", value, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountGreaterThan(Integer value) {
            addCriterion("signature_count >", value, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("signature_count >=", value, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountLessThan(Integer value) {
            addCriterion("signature_count <", value, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountLessThanOrEqualTo(Integer value) {
            addCriterion("signature_count <=", value, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountIn(List<Integer> values) {
            addCriterion("signature_count in", values, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountNotIn(List<Integer> values) {
            addCriterion("signature_count not in", values, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountBetween(Integer value1, Integer value2) {
            addCriterion("signature_count between", value1, value2, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andSignatureCountNotBetween(Integer value1, Integer value2) {
            addCriterion("signature_count not between", value1, value2, "signatureCount");
            return (Criteria) this;
        }

        public Criteria andShareNumIsNull() {
            addCriterion("share_num is null");
            return (Criteria) this;
        }

        public Criteria andShareNumIsNotNull() {
            addCriterion("share_num is not null");
            return (Criteria) this;
        }

        public Criteria andShareNumEqualTo(Integer value) {
            addCriterion("share_num =", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotEqualTo(Integer value) {
            addCriterion("share_num <>", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumGreaterThan(Integer value) {
            addCriterion("share_num >", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_num >=", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumLessThan(Integer value) {
            addCriterion("share_num <", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumLessThanOrEqualTo(Integer value) {
            addCriterion("share_num <=", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumIn(List<Integer> values) {
            addCriterion("share_num in", values, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotIn(List<Integer> values) {
            addCriterion("share_num not in", values, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumBetween(Integer value1, Integer value2) {
            addCriterion("share_num between", value1, value2, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotBetween(Integer value1, Integer value2) {
            addCriterion("share_num not between", value1, value2, "shareNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumIsNull() {
            addCriterion("total_pic_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumIsNotNull() {
            addCriterion("total_pic_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumEqualTo(Integer value) {
            addCriterion("total_pic_num =", value, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumNotEqualTo(Integer value) {
            addCriterion("total_pic_num <>", value, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumGreaterThan(Integer value) {
            addCriterion("total_pic_num >", value, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_pic_num >=", value, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumLessThan(Integer value) {
            addCriterion("total_pic_num <", value, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_pic_num <=", value, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumIn(List<Integer> values) {
            addCriterion("total_pic_num in", values, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumNotIn(List<Integer> values) {
            addCriterion("total_pic_num not in", values, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumBetween(Integer value1, Integer value2) {
            addCriterion("total_pic_num between", value1, value2, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andTotalPicNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_pic_num not between", value1, value2, "totalPicNum");
            return (Criteria) this;
        }

        public Criteria andIshideIsNull() {
            addCriterion("ishide is null");
            return (Criteria) this;
        }

        public Criteria andIshideIsNotNull() {
            addCriterion("ishide is not null");
            return (Criteria) this;
        }

        public Criteria andIshideEqualTo(Boolean value) {
            addCriterion("ishide =", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotEqualTo(Boolean value) {
            addCriterion("ishide <>", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideGreaterThan(Boolean value) {
            addCriterion("ishide >", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ishide >=", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLessThan(Boolean value) {
            addCriterion("ishide <", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLessThanOrEqualTo(Boolean value) {
            addCriterion("ishide <=", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideIn(List<Boolean> values) {
            addCriterion("ishide in", values, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotIn(List<Boolean> values) {
            addCriterion("ishide not in", values, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideBetween(Boolean value1, Boolean value2) {
            addCriterion("ishide between", value1, value2, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ishide not between", value1, value2, "ishide");
            return (Criteria) this;
        }

        public Criteria andThumbsNumIsNull() {
            addCriterion("thumbs_num is null");
            return (Criteria) this;
        }

        public Criteria andThumbsNumIsNotNull() {
            addCriterion("thumbs_num is not null");
            return (Criteria) this;
        }

        public Criteria andThumbsNumEqualTo(Integer value) {
            addCriterion("thumbs_num =", value, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumNotEqualTo(Integer value) {
            addCriterion("thumbs_num <>", value, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumGreaterThan(Integer value) {
            addCriterion("thumbs_num >", value, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("thumbs_num >=", value, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumLessThan(Integer value) {
            addCriterion("thumbs_num <", value, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumLessThanOrEqualTo(Integer value) {
            addCriterion("thumbs_num <=", value, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumIn(List<Integer> values) {
            addCriterion("thumbs_num in", values, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumNotIn(List<Integer> values) {
            addCriterion("thumbs_num not in", values, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumBetween(Integer value1, Integer value2) {
            addCriterion("thumbs_num between", value1, value2, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andThumbsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("thumbs_num not between", value1, value2, "thumbsNum");
            return (Criteria) this;
        }

        public Criteria andMrtypeIsNull() {
            addCriterion("mrtype is null");
            return (Criteria) this;
        }

        public Criteria andMrtypeIsNotNull() {
            addCriterion("mrtype is not null");
            return (Criteria) this;
        }

        public Criteria andMrtypeEqualTo(int value) {
            addCriterion("mrtype =", value, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeNotEqualTo(Boolean value) {
            addCriterion("mrtype <>", value, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeGreaterThan(Boolean value) {
            addCriterion("mrtype >", value, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("mrtype >=", value, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeLessThan(Boolean value) {
            addCriterion("mrtype <", value, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeLessThanOrEqualTo(Boolean value) {
            addCriterion("mrtype <=", value, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeIn(List<Boolean> values) {
            addCriterion("mrtype in", values, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeNotIn(List<Boolean> values) {
            addCriterion("mrtype not in", values, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeBetween(Boolean value1, Boolean value2) {
            addCriterion("mrtype between", value1, value2, "mrtype");
            return (Criteria) this;
        }

        public Criteria andMrtypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("mrtype not between", value1, value2, "mrtype");
            return (Criteria) this;
        }

        public Criteria andCardLevelIsNull() {
            addCriterion("card_level is null");
            return (Criteria) this;
        }

        public Criteria andCardLevelIsNotNull() {
            addCriterion("card_level is not null");
            return (Criteria) this;
        }

        public Criteria andCardLevelEqualTo(Boolean value) {
            addCriterion("card_level =", value, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelNotEqualTo(Boolean value) {
            addCriterion("card_level <>", value, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelGreaterThan(Boolean value) {
            addCriterion("card_level >", value, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("card_level >=", value, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelLessThan(Boolean value) {
            addCriterion("card_level <", value, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelLessThanOrEqualTo(Boolean value) {
            addCriterion("card_level <=", value, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelIn(List<Boolean> values) {
            addCriterion("card_level in", values, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelNotIn(List<Boolean> values) {
            addCriterion("card_level not in", values, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelBetween(Boolean value1, Boolean value2) {
            addCriterion("card_level between", value1, value2, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andCardLevelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("card_level not between", value1, value2, "cardLevel");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeIsNull() {
            addCriterion("last_update_star_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeIsNotNull() {
            addCriterion("last_update_star_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeEqualTo(String value) {
            addCriterion("last_update_star_time =", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeNotEqualTo(String value) {
            addCriterion("last_update_star_time <>", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeGreaterThan(String value) {
            addCriterion("last_update_star_time >", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_star_time >=", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeLessThan(String value) {
            addCriterion("last_update_star_time <", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeLessThanOrEqualTo(String value) {
            addCriterion("last_update_star_time <=", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeLike(String value) {
            addCriterion("last_update_star_time like", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeNotLike(String value) {
            addCriterion("last_update_star_time not like", value, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeIn(List<String> values) {
            addCriterion("last_update_star_time in", values, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeNotIn(List<String> values) {
            addCriterion("last_update_star_time not in", values, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeBetween(String value1, String value2) {
            addCriterion("last_update_star_time between", value1, value2, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateStarTimeNotBetween(String value1, String value2) {
            addCriterion("last_update_star_time not between", value1, value2, "lastUpdateStarTime");
            return (Criteria) this;
        }

        public Criteria andCardTelIsNull() {
            addCriterion("card_tel is null");
            return (Criteria) this;
        }

        public Criteria andCardTelIsNotNull() {
            addCriterion("card_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCardTelEqualTo(String value) {
            addCriterion("card_tel =", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelNotEqualTo(String value) {
            addCriterion("card_tel <>", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelGreaterThan(String value) {
            addCriterion("card_tel >", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelGreaterThanOrEqualTo(String value) {
            addCriterion("card_tel >=", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelLessThan(String value) {
            addCriterion("card_tel <", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelLessThanOrEqualTo(String value) {
            addCriterion("card_tel <=", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelLike(String value) {
            addCriterion("card_tel like", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelNotLike(String value) {
            addCriterion("card_tel not like", value, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelIn(List<String> values) {
            addCriterion("card_tel in", values, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelNotIn(List<String> values) {
            addCriterion("card_tel not in", values, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelBetween(String value1, String value2) {
            addCriterion("card_tel between", value1, value2, "cardTel");
            return (Criteria) this;
        }

        public Criteria andCardTelNotBetween(String value1, String value2) {
            addCriterion("card_tel not between", value1, value2, "cardTel");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andHidePropertyIsNull() {
            addCriterion("hide_property is null");
            return (Criteria) this;
        }

        public Criteria andHidePropertyIsNotNull() {
            addCriterion("hide_property is not null");
            return (Criteria) this;
        }

        public Criteria andHidePropertyEqualTo(Boolean value) {
            addCriterion("hide_property =", value, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyNotEqualTo(Boolean value) {
            addCriterion("hide_property <>", value, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyGreaterThan(Boolean value) {
            addCriterion("hide_property >", value, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hide_property >=", value, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyLessThan(Boolean value) {
            addCriterion("hide_property <", value, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyLessThanOrEqualTo(Boolean value) {
            addCriterion("hide_property <=", value, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyIn(List<Boolean> values) {
            addCriterion("hide_property in", values, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyNotIn(List<Boolean> values) {
            addCriterion("hide_property not in", values, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_property between", value1, value2, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andHidePropertyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_property not between", value1, value2, "hideProperty");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbIsNull() {
            addCriterion("customer_disturb is null");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbIsNotNull() {
            addCriterion("customer_disturb is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbEqualTo(Boolean value) {
            addCriterion("customer_disturb =", value, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbNotEqualTo(Boolean value) {
            addCriterion("customer_disturb <>", value, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbGreaterThan(Boolean value) {
            addCriterion("customer_disturb >", value, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbGreaterThanOrEqualTo(Boolean value) {
            addCriterion("customer_disturb >=", value, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbLessThan(Boolean value) {
            addCriterion("customer_disturb <", value, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbLessThanOrEqualTo(Boolean value) {
            addCriterion("customer_disturb <=", value, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbIn(List<Boolean> values) {
            addCriterion("customer_disturb in", values, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbNotIn(List<Boolean> values) {
            addCriterion("customer_disturb not in", values, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbBetween(Boolean value1, Boolean value2) {
            addCriterion("customer_disturb between", value1, value2, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andCustomerDisturbNotBetween(Boolean value1, Boolean value2) {
            addCriterion("customer_disturb not between", value1, value2, "customerDisturb");
            return (Criteria) this;
        }

        public Criteria andOpenBossIsNull() {
            addCriterion("open_boss is null");
            return (Criteria) this;
        }

        public Criteria andOpenBossIsNotNull() {
            addCriterion("open_boss is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBossEqualTo(Byte value) {
            addCriterion("open_boss =", value, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossNotEqualTo(Byte value) {
            addCriterion("open_boss <>", value, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossGreaterThan(Byte value) {
            addCriterion("open_boss >", value, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossGreaterThanOrEqualTo(Byte value) {
            addCriterion("open_boss >=", value, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossLessThan(Byte value) {
            addCriterion("open_boss <", value, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossLessThanOrEqualTo(Byte value) {
            addCriterion("open_boss <=", value, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossIn(List<Byte> values) {
            addCriterion("open_boss in", values, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossNotIn(List<Byte> values) {
            addCriterion("open_boss not in", values, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossBetween(Byte value1, Byte value2) {
            addCriterion("open_boss between", value1, value2, "openBoss");
            return (Criteria) this;
        }

        public Criteria andOpenBossNotBetween(Byte value1, Byte value2) {
            addCriterion("open_boss not between", value1, value2, "openBoss");
            return (Criteria) this;
        }

        public Criteria andZdMsgIsNull() {
            addCriterion("zd_msg is null");
            return (Criteria) this;
        }

        public Criteria andZdMsgIsNotNull() {
            addCriterion("zd_msg is not null");
            return (Criteria) this;
        }

        public Criteria andZdMsgEqualTo(String value) {
            addCriterion("zd_msg =", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgNotEqualTo(String value) {
            addCriterion("zd_msg <>", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgGreaterThan(String value) {
            addCriterion("zd_msg >", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgGreaterThanOrEqualTo(String value) {
            addCriterion("zd_msg >=", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgLessThan(String value) {
            addCriterion("zd_msg <", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgLessThanOrEqualTo(String value) {
            addCriterion("zd_msg <=", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgLike(String value) {
            addCriterion("zd_msg like", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgNotLike(String value) {
            addCriterion("zd_msg not like", value, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgIn(List<String> values) {
            addCriterion("zd_msg in", values, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgNotIn(List<String> values) {
            addCriterion("zd_msg not in", values, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgBetween(String value1, String value2) {
            addCriterion("zd_msg between", value1, value2, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andZdMsgNotBetween(String value1, String value2) {
            addCriterion("zd_msg not between", value1, value2, "zdMsg");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andTemplateImgIsNull() {
            addCriterion("template_img is null");
            return (Criteria) this;
        }

        public Criteria andTemplateImgIsNotNull() {
            addCriterion("template_img is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateImgEqualTo(String value) {
            addCriterion("template_img =", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgNotEqualTo(String value) {
            addCriterion("template_img <>", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgGreaterThan(String value) {
            addCriterion("template_img >", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgGreaterThanOrEqualTo(String value) {
            addCriterion("template_img >=", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgLessThan(String value) {
            addCriterion("template_img <", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgLessThanOrEqualTo(String value) {
            addCriterion("template_img <=", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgLike(String value) {
            addCriterion("template_img like", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgNotLike(String value) {
            addCriterion("template_img not like", value, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgIn(List<String> values) {
            addCriterion("template_img in", values, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgNotIn(List<String> values) {
            addCriterion("template_img not in", values, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgBetween(String value1, String value2) {
            addCriterion("template_img between", value1, value2, "templateImg");
            return (Criteria) this;
        }

        public Criteria andTemplateImgNotBetween(String value1, String value2) {
            addCriterion("template_img not between", value1, value2, "templateImg");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNull() {
            addCriterion("share_img is null");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNotNull() {
            addCriterion("share_img is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgEqualTo(String value) {
            addCriterion("share_img =", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotEqualTo(String value) {
            addCriterion("share_img <>", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThan(String value) {
            addCriterion("share_img >", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThanOrEqualTo(String value) {
            addCriterion("share_img >=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThan(String value) {
            addCriterion("share_img <", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThanOrEqualTo(String value) {
            addCriterion("share_img <=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLike(String value) {
            addCriterion("share_img like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotLike(String value) {
            addCriterion("share_img not like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgIn(List<String> values) {
            addCriterion("share_img in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotIn(List<String> values) {
            addCriterion("share_img not in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgBetween(String value1, String value2) {
            addCriterion("share_img between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotBetween(String value1, String value2) {
            addCriterion("share_img not between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNull() {
            addCriterion("share_title is null");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNotNull() {
            addCriterion("share_title is not null");
            return (Criteria) this;
        }

        public Criteria andShareTitleEqualTo(String value) {
            addCriterion("share_title =", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotEqualTo(String value) {
            addCriterion("share_title <>", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThan(String value) {
            addCriterion("share_title >", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("share_title >=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThan(String value) {
            addCriterion("share_title <", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThanOrEqualTo(String value) {
            addCriterion("share_title <=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLike(String value) {
            addCriterion("share_title like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotLike(String value) {
            addCriterion("share_title not like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleIn(List<String> values) {
            addCriterion("share_title in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotIn(List<String> values) {
            addCriterion("share_title not in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleBetween(String value1, String value2) {
            addCriterion("share_title between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotBetween(String value1, String value2) {
            addCriterion("share_title not between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdIsNull() {
            addCriterion("is_sendcard_id is null");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdIsNotNull() {
            addCriterion("is_sendcard_id is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdEqualTo(Integer value) {
            addCriterion("is_sendcard_id =", value, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdNotEqualTo(Integer value) {
            addCriterion("is_sendcard_id <>", value, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdGreaterThan(Integer value) {
            addCriterion("is_sendcard_id >", value, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sendcard_id >=", value, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdLessThan(Integer value) {
            addCriterion("is_sendcard_id <", value, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdLessThanOrEqualTo(Integer value) {
            addCriterion("is_sendcard_id <=", value, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdIn(List<Integer> values) {
            addCriterion("is_sendcard_id in", values, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdNotIn(List<Integer> values) {
            addCriterion("is_sendcard_id not in", values, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdBetween(Integer value1, Integer value2) {
            addCriterion("is_sendcard_id between", value1, value2, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sendcard_id not between", value1, value2, "isSendcardId");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIsNull() {
            addCriterion("is_sendcard is null");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIsNotNull() {
            addCriterion("is_sendcard is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendcardEqualTo(int value) {
            addCriterion("is_sendcard =", value, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardNotEqualTo(Boolean value) {
            addCriterion("is_sendcard <>", value, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardGreaterThan(Boolean value) {
            addCriterion("is_sendcard >", value, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_sendcard >=", value, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardLessThan(Boolean value) {
            addCriterion("is_sendcard <", value, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardLessThanOrEqualTo(Boolean value) {
            addCriterion("is_sendcard <=", value, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardIn(List<Boolean> values) {
            addCriterion("is_sendcard in", values, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardNotIn(List<Boolean> values) {
            addCriterion("is_sendcard not in", values, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sendcard between", value1, value2, "isSendcard");
            return (Criteria) this;
        }

        public Criteria andIsSendcardNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sendcard not between", value1, value2, "isSendcard");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}