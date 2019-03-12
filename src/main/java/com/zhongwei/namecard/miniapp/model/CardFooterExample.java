package com.zhongwei.namecard.miniapp.model;

import java.util.ArrayList;
import java.util.List;

public class CardFooterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardFooterExample() {
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

        public Criteria andCardImgIsNull() {
            addCriterion("card_img is null");
            return (Criteria) this;
        }

        public Criteria andCardImgIsNotNull() {
            addCriterion("card_img is not null");
            return (Criteria) this;
        }

        public Criteria andCardImgEqualTo(String value) {
            addCriterion("card_img =", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgNotEqualTo(String value) {
            addCriterion("card_img <>", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgGreaterThan(String value) {
            addCriterion("card_img >", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgGreaterThanOrEqualTo(String value) {
            addCriterion("card_img >=", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgLessThan(String value) {
            addCriterion("card_img <", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgLessThanOrEqualTo(String value) {
            addCriterion("card_img <=", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgLike(String value) {
            addCriterion("card_img like", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgNotLike(String value) {
            addCriterion("card_img not like", value, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgIn(List<String> values) {
            addCriterion("card_img in", values, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgNotIn(List<String> values) {
            addCriterion("card_img not in", values, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgBetween(String value1, String value2) {
            addCriterion("card_img between", value1, value2, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgNotBetween(String value1, String value2) {
            addCriterion("card_img not between", value1, value2, "cardImg");
            return (Criteria) this;
        }

        public Criteria andCardImgNoIsNull() {
            addCriterion("card_img_no is null");
            return (Criteria) this;
        }

        public Criteria andCardImgNoIsNotNull() {
            addCriterion("card_img_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardImgNoEqualTo(String value) {
            addCriterion("card_img_no =", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoNotEqualTo(String value) {
            addCriterion("card_img_no <>", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoGreaterThan(String value) {
            addCriterion("card_img_no >", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_img_no >=", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoLessThan(String value) {
            addCriterion("card_img_no <", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoLessThanOrEqualTo(String value) {
            addCriterion("card_img_no <=", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoLike(String value) {
            addCriterion("card_img_no like", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoNotLike(String value) {
            addCriterion("card_img_no not like", value, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoIn(List<String> values) {
            addCriterion("card_img_no in", values, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoNotIn(List<String> values) {
            addCriterion("card_img_no not in", values, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoBetween(String value1, String value2) {
            addCriterion("card_img_no between", value1, value2, "cardImgNo");
            return (Criteria) this;
        }

        public Criteria andCardImgNoNotBetween(String value1, String value2) {
            addCriterion("card_img_no not between", value1, value2, "cardImgNo");
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNull() {
            addCriterion("friend_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNotNull() {
            addCriterion("friend_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNameEqualTo(String value) {
            addCriterion("friend_name =", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotEqualTo(String value) {
            addCriterion("friend_name <>", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThan(String value) {
            addCriterion("friend_name >", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_name >=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThan(String value) {
            addCriterion("friend_name <", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThanOrEqualTo(String value) {
            addCriterion("friend_name <=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLike(String value) {
            addCriterion("friend_name like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotLike(String value) {
            addCriterion("friend_name not like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIn(List<String> values) {
            addCriterion("friend_name in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotIn(List<String> values) {
            addCriterion("friend_name not in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameBetween(String value1, String value2) {
            addCriterion("friend_name between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotBetween(String value1, String value2) {
            addCriterion("friend_name not between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNull() {
            addCriterion("web_name is null");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNotNull() {
            addCriterion("web_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebNameEqualTo(String value) {
            addCriterion("web_name =", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotEqualTo(String value) {
            addCriterion("web_name <>", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThan(String value) {
            addCriterion("web_name >", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_name >=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThan(String value) {
            addCriterion("web_name <", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThanOrEqualTo(String value) {
            addCriterion("web_name <=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLike(String value) {
            addCriterion("web_name like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotLike(String value) {
            addCriterion("web_name not like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameIn(List<String> values) {
            addCriterion("web_name in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotIn(List<String> values) {
            addCriterion("web_name not in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameBetween(String value1, String value2) {
            addCriterion("web_name between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotBetween(String value1, String value2) {
            addCriterion("web_name not between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andShopImgIsNull() {
            addCriterion("shop_img is null");
            return (Criteria) this;
        }

        public Criteria andShopImgIsNotNull() {
            addCriterion("shop_img is not null");
            return (Criteria) this;
        }

        public Criteria andShopImgEqualTo(String value) {
            addCriterion("shop_img =", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotEqualTo(String value) {
            addCriterion("shop_img <>", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgGreaterThan(String value) {
            addCriterion("shop_img >", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgGreaterThanOrEqualTo(String value) {
            addCriterion("shop_img >=", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLessThan(String value) {
            addCriterion("shop_img <", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLessThanOrEqualTo(String value) {
            addCriterion("shop_img <=", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLike(String value) {
            addCriterion("shop_img like", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotLike(String value) {
            addCriterion("shop_img not like", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgIn(List<String> values) {
            addCriterion("shop_img in", values, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotIn(List<String> values) {
            addCriterion("shop_img not in", values, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgBetween(String value1, String value2) {
            addCriterion("shop_img between", value1, value2, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotBetween(String value1, String value2) {
            addCriterion("shop_img not between", value1, value2, "shopImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgIsNull() {
            addCriterion("friend_img is null");
            return (Criteria) this;
        }

        public Criteria andFriendImgIsNotNull() {
            addCriterion("friend_img is not null");
            return (Criteria) this;
        }

        public Criteria andFriendImgEqualTo(String value) {
            addCriterion("friend_img =", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgNotEqualTo(String value) {
            addCriterion("friend_img <>", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgGreaterThan(String value) {
            addCriterion("friend_img >", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgGreaterThanOrEqualTo(String value) {
            addCriterion("friend_img >=", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgLessThan(String value) {
            addCriterion("friend_img <", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgLessThanOrEqualTo(String value) {
            addCriterion("friend_img <=", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgLike(String value) {
            addCriterion("friend_img like", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgNotLike(String value) {
            addCriterion("friend_img not like", value, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgIn(List<String> values) {
            addCriterion("friend_img in", values, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgNotIn(List<String> values) {
            addCriterion("friend_img not in", values, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgBetween(String value1, String value2) {
            addCriterion("friend_img between", value1, value2, "friendImg");
            return (Criteria) this;
        }

        public Criteria andFriendImgNotBetween(String value1, String value2) {
            addCriterion("friend_img not between", value1, value2, "friendImg");
            return (Criteria) this;
        }

        public Criteria andWebImgIsNull() {
            addCriterion("web_img is null");
            return (Criteria) this;
        }

        public Criteria andWebImgIsNotNull() {
            addCriterion("web_img is not null");
            return (Criteria) this;
        }

        public Criteria andWebImgEqualTo(String value) {
            addCriterion("web_img =", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgNotEqualTo(String value) {
            addCriterion("web_img <>", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgGreaterThan(String value) {
            addCriterion("web_img >", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgGreaterThanOrEqualTo(String value) {
            addCriterion("web_img >=", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgLessThan(String value) {
            addCriterion("web_img <", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgLessThanOrEqualTo(String value) {
            addCriterion("web_img <=", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgLike(String value) {
            addCriterion("web_img like", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgNotLike(String value) {
            addCriterion("web_img not like", value, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgIn(List<String> values) {
            addCriterion("web_img in", values, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgNotIn(List<String> values) {
            addCriterion("web_img not in", values, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgBetween(String value1, String value2) {
            addCriterion("web_img between", value1, value2, "webImg");
            return (Criteria) this;
        }

        public Criteria andWebImgNotBetween(String value1, String value2) {
            addCriterion("web_img not between", value1, value2, "webImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNoIsNull() {
            addCriterion("shop_img_no is null");
            return (Criteria) this;
        }

        public Criteria andShopImgNoIsNotNull() {
            addCriterion("shop_img_no is not null");
            return (Criteria) this;
        }

        public Criteria andShopImgNoEqualTo(String value) {
            addCriterion("shop_img_no =", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoNotEqualTo(String value) {
            addCriterion("shop_img_no <>", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoGreaterThan(String value) {
            addCriterion("shop_img_no >", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoGreaterThanOrEqualTo(String value) {
            addCriterion("shop_img_no >=", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoLessThan(String value) {
            addCriterion("shop_img_no <", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoLessThanOrEqualTo(String value) {
            addCriterion("shop_img_no <=", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoLike(String value) {
            addCriterion("shop_img_no like", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoNotLike(String value) {
            addCriterion("shop_img_no not like", value, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoIn(List<String> values) {
            addCriterion("shop_img_no in", values, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoNotIn(List<String> values) {
            addCriterion("shop_img_no not in", values, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoBetween(String value1, String value2) {
            addCriterion("shop_img_no between", value1, value2, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andShopImgNoNotBetween(String value1, String value2) {
            addCriterion("shop_img_no not between", value1, value2, "shopImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoIsNull() {
            addCriterion("friend_img_no is null");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoIsNotNull() {
            addCriterion("friend_img_no is not null");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoEqualTo(String value) {
            addCriterion("friend_img_no =", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoNotEqualTo(String value) {
            addCriterion("friend_img_no <>", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoGreaterThan(String value) {
            addCriterion("friend_img_no >", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoGreaterThanOrEqualTo(String value) {
            addCriterion("friend_img_no >=", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoLessThan(String value) {
            addCriterion("friend_img_no <", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoLessThanOrEqualTo(String value) {
            addCriterion("friend_img_no <=", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoLike(String value) {
            addCriterion("friend_img_no like", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoNotLike(String value) {
            addCriterion("friend_img_no not like", value, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoIn(List<String> values) {
            addCriterion("friend_img_no in", values, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoNotIn(List<String> values) {
            addCriterion("friend_img_no not in", values, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoBetween(String value1, String value2) {
            addCriterion("friend_img_no between", value1, value2, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andFriendImgNoNotBetween(String value1, String value2) {
            addCriterion("friend_img_no not between", value1, value2, "friendImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoIsNull() {
            addCriterion("web_img_no is null");
            return (Criteria) this;
        }

        public Criteria andWebImgNoIsNotNull() {
            addCriterion("web_img_no is not null");
            return (Criteria) this;
        }

        public Criteria andWebImgNoEqualTo(String value) {
            addCriterion("web_img_no =", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoNotEqualTo(String value) {
            addCriterion("web_img_no <>", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoGreaterThan(String value) {
            addCriterion("web_img_no >", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoGreaterThanOrEqualTo(String value) {
            addCriterion("web_img_no >=", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoLessThan(String value) {
            addCriterion("web_img_no <", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoLessThanOrEqualTo(String value) {
            addCriterion("web_img_no <=", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoLike(String value) {
            addCriterion("web_img_no like", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoNotLike(String value) {
            addCriterion("web_img_no not like", value, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoIn(List<String> values) {
            addCriterion("web_img_no in", values, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoNotIn(List<String> values) {
            addCriterion("web_img_no not in", values, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoBetween(String value1, String value2) {
            addCriterion("web_img_no between", value1, value2, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andWebImgNoNotBetween(String value1, String value2) {
            addCriterion("web_img_no not between", value1, value2, "webImgNo");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(Boolean value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(Boolean value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(Boolean value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(Boolean value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<Boolean> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<Boolean> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIsNull() {
            addCriterion("friend_type is null");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIsNotNull() {
            addCriterion("friend_type is not null");
            return (Criteria) this;
        }

        public Criteria andFriendTypeEqualTo(Boolean value) {
            addCriterion("friend_type =", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotEqualTo(Boolean value) {
            addCriterion("friend_type <>", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeGreaterThan(Boolean value) {
            addCriterion("friend_type >", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("friend_type >=", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLessThan(Boolean value) {
            addCriterion("friend_type <", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("friend_type <=", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIn(List<Boolean> values) {
            addCriterion("friend_type in", values, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotIn(List<Boolean> values) {
            addCriterion("friend_type not in", values, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("friend_type between", value1, value2, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("friend_type not between", value1, value2, "friendType");
            return (Criteria) this;
        }

        public Criteria andWebTypeIsNull() {
            addCriterion("web_type is null");
            return (Criteria) this;
        }

        public Criteria andWebTypeIsNotNull() {
            addCriterion("web_type is not null");
            return (Criteria) this;
        }

        public Criteria andWebTypeEqualTo(Boolean value) {
            addCriterion("web_type =", value, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeNotEqualTo(Boolean value) {
            addCriterion("web_type <>", value, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeGreaterThan(Boolean value) {
            addCriterion("web_type >", value, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("web_type >=", value, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeLessThan(Boolean value) {
            addCriterion("web_type <", value, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("web_type <=", value, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeIn(List<Boolean> values) {
            addCriterion("web_type in", values, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeNotIn(List<Boolean> values) {
            addCriterion("web_type not in", values, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("web_type between", value1, value2, "webType");
            return (Criteria) this;
        }

        public Criteria andWebTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("web_type not between", value1, value2, "webType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Boolean value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Boolean value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Boolean value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Boolean value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Boolean> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Boolean> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andShopUrlIsNull() {
            addCriterion("shop_url is null");
            return (Criteria) this;
        }

        public Criteria andShopUrlIsNotNull() {
            addCriterion("shop_url is not null");
            return (Criteria) this;
        }

        public Criteria andShopUrlEqualTo(String value) {
            addCriterion("shop_url =", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotEqualTo(String value) {
            addCriterion("shop_url <>", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlGreaterThan(String value) {
            addCriterion("shop_url >", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlGreaterThanOrEqualTo(String value) {
            addCriterion("shop_url >=", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLessThan(String value) {
            addCriterion("shop_url <", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLessThanOrEqualTo(String value) {
            addCriterion("shop_url <=", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLike(String value) {
            addCriterion("shop_url like", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotLike(String value) {
            addCriterion("shop_url not like", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlIn(List<String> values) {
            addCriterion("shop_url in", values, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotIn(List<String> values) {
            addCriterion("shop_url not in", values, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlBetween(String value1, String value2) {
            addCriterion("shop_url between", value1, value2, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotBetween(String value1, String value2) {
            addCriterion("shop_url not between", value1, value2, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopPathIsNull() {
            addCriterion("shop_path is null");
            return (Criteria) this;
        }

        public Criteria andShopPathIsNotNull() {
            addCriterion("shop_path is not null");
            return (Criteria) this;
        }

        public Criteria andShopPathEqualTo(String value) {
            addCriterion("shop_path =", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathNotEqualTo(String value) {
            addCriterion("shop_path <>", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathGreaterThan(String value) {
            addCriterion("shop_path >", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathGreaterThanOrEqualTo(String value) {
            addCriterion("shop_path >=", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathLessThan(String value) {
            addCriterion("shop_path <", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathLessThanOrEqualTo(String value) {
            addCriterion("shop_path <=", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathLike(String value) {
            addCriterion("shop_path like", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathNotLike(String value) {
            addCriterion("shop_path not like", value, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathIn(List<String> values) {
            addCriterion("shop_path in", values, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathNotIn(List<String> values) {
            addCriterion("shop_path not in", values, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathBetween(String value1, String value2) {
            addCriterion("shop_path between", value1, value2, "shopPath");
            return (Criteria) this;
        }

        public Criteria andShopPathNotBetween(String value1, String value2) {
            addCriterion("shop_path not between", value1, value2, "shopPath");
            return (Criteria) this;
        }

        public Criteria andCardPathIsNull() {
            addCriterion("card_path is null");
            return (Criteria) this;
        }

        public Criteria andCardPathIsNotNull() {
            addCriterion("card_path is not null");
            return (Criteria) this;
        }

        public Criteria andCardPathEqualTo(String value) {
            addCriterion("card_path =", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathNotEqualTo(String value) {
            addCriterion("card_path <>", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathGreaterThan(String value) {
            addCriterion("card_path >", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathGreaterThanOrEqualTo(String value) {
            addCriterion("card_path >=", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathLessThan(String value) {
            addCriterion("card_path <", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathLessThanOrEqualTo(String value) {
            addCriterion("card_path <=", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathLike(String value) {
            addCriterion("card_path like", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathNotLike(String value) {
            addCriterion("card_path not like", value, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathIn(List<String> values) {
            addCriterion("card_path in", values, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathNotIn(List<String> values) {
            addCriterion("card_path not in", values, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathBetween(String value1, String value2) {
            addCriterion("card_path between", value1, value2, "cardPath");
            return (Criteria) this;
        }

        public Criteria andCardPathNotBetween(String value1, String value2) {
            addCriterion("card_path not between", value1, value2, "cardPath");
            return (Criteria) this;
        }

        public Criteria andWebPathIsNull() {
            addCriterion("web_path is null");
            return (Criteria) this;
        }

        public Criteria andWebPathIsNotNull() {
            addCriterion("web_path is not null");
            return (Criteria) this;
        }

        public Criteria andWebPathEqualTo(String value) {
            addCriterion("web_path =", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathNotEqualTo(String value) {
            addCriterion("web_path <>", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathGreaterThan(String value) {
            addCriterion("web_path >", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathGreaterThanOrEqualTo(String value) {
            addCriterion("web_path >=", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathLessThan(String value) {
            addCriterion("web_path <", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathLessThanOrEqualTo(String value) {
            addCriterion("web_path <=", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathLike(String value) {
            addCriterion("web_path like", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathNotLike(String value) {
            addCriterion("web_path not like", value, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathIn(List<String> values) {
            addCriterion("web_path in", values, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathNotIn(List<String> values) {
            addCriterion("web_path not in", values, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathBetween(String value1, String value2) {
            addCriterion("web_path between", value1, value2, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebPathNotBetween(String value1, String value2) {
            addCriterion("web_path not between", value1, value2, "webPath");
            return (Criteria) this;
        }

        public Criteria andWebAppidIsNull() {
            addCriterion("web_appid is null");
            return (Criteria) this;
        }

        public Criteria andWebAppidIsNotNull() {
            addCriterion("web_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWebAppidEqualTo(String value) {
            addCriterion("web_appid =", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidNotEqualTo(String value) {
            addCriterion("web_appid <>", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidGreaterThan(String value) {
            addCriterion("web_appid >", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidGreaterThanOrEqualTo(String value) {
            addCriterion("web_appid >=", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidLessThan(String value) {
            addCriterion("web_appid <", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidLessThanOrEqualTo(String value) {
            addCriterion("web_appid <=", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidLike(String value) {
            addCriterion("web_appid like", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidNotLike(String value) {
            addCriterion("web_appid not like", value, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidIn(List<String> values) {
            addCriterion("web_appid in", values, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidNotIn(List<String> values) {
            addCriterion("web_appid not in", values, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidBetween(String value1, String value2) {
            addCriterion("web_appid between", value1, value2, "webAppid");
            return (Criteria) this;
        }

        public Criteria andWebAppidNotBetween(String value1, String value2) {
            addCriterion("web_appid not between", value1, value2, "webAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidIsNull() {
            addCriterion("card_appid is null");
            return (Criteria) this;
        }

        public Criteria andCardAppidIsNotNull() {
            addCriterion("card_appid is not null");
            return (Criteria) this;
        }

        public Criteria andCardAppidEqualTo(String value) {
            addCriterion("card_appid =", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidNotEqualTo(String value) {
            addCriterion("card_appid <>", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidGreaterThan(String value) {
            addCriterion("card_appid >", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidGreaterThanOrEqualTo(String value) {
            addCriterion("card_appid >=", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidLessThan(String value) {
            addCriterion("card_appid <", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidLessThanOrEqualTo(String value) {
            addCriterion("card_appid <=", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidLike(String value) {
            addCriterion("card_appid like", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidNotLike(String value) {
            addCriterion("card_appid not like", value, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidIn(List<String> values) {
            addCriterion("card_appid in", values, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidNotIn(List<String> values) {
            addCriterion("card_appid not in", values, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidBetween(String value1, String value2) {
            addCriterion("card_appid between", value1, value2, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andCardAppidNotBetween(String value1, String value2) {
            addCriterion("card_appid not between", value1, value2, "cardAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidIsNull() {
            addCriterion("friend_appid is null");
            return (Criteria) this;
        }

        public Criteria andFriendAppidIsNotNull() {
            addCriterion("friend_appid is not null");
            return (Criteria) this;
        }

        public Criteria andFriendAppidEqualTo(String value) {
            addCriterion("friend_appid =", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidNotEqualTo(String value) {
            addCriterion("friend_appid <>", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidGreaterThan(String value) {
            addCriterion("friend_appid >", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidGreaterThanOrEqualTo(String value) {
            addCriterion("friend_appid >=", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidLessThan(String value) {
            addCriterion("friend_appid <", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidLessThanOrEqualTo(String value) {
            addCriterion("friend_appid <=", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidLike(String value) {
            addCriterion("friend_appid like", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidNotLike(String value) {
            addCriterion("friend_appid not like", value, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidIn(List<String> values) {
            addCriterion("friend_appid in", values, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidNotIn(List<String> values) {
            addCriterion("friend_appid not in", values, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidBetween(String value1, String value2) {
            addCriterion("friend_appid between", value1, value2, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendAppidNotBetween(String value1, String value2) {
            addCriterion("friend_appid not between", value1, value2, "friendAppid");
            return (Criteria) this;
        }

        public Criteria andFriendPathIsNull() {
            addCriterion("friend_path is null");
            return (Criteria) this;
        }

        public Criteria andFriendPathIsNotNull() {
            addCriterion("friend_path is not null");
            return (Criteria) this;
        }

        public Criteria andFriendPathEqualTo(String value) {
            addCriterion("friend_path =", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathNotEqualTo(String value) {
            addCriterion("friend_path <>", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathGreaterThan(String value) {
            addCriterion("friend_path >", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathGreaterThanOrEqualTo(String value) {
            addCriterion("friend_path >=", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathLessThan(String value) {
            addCriterion("friend_path <", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathLessThanOrEqualTo(String value) {
            addCriterion("friend_path <=", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathLike(String value) {
            addCriterion("friend_path like", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathNotLike(String value) {
            addCriterion("friend_path not like", value, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathIn(List<String> values) {
            addCriterion("friend_path in", values, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathNotIn(List<String> values) {
            addCriterion("friend_path not in", values, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathBetween(String value1, String value2) {
            addCriterion("friend_path between", value1, value2, "friendPath");
            return (Criteria) this;
        }

        public Criteria andFriendPathNotBetween(String value1, String value2) {
            addCriterion("friend_path not between", value1, value2, "friendPath");
            return (Criteria) this;
        }

        public Criteria andShopAppidIsNull() {
            addCriterion("shop_appid is null");
            return (Criteria) this;
        }

        public Criteria andShopAppidIsNotNull() {
            addCriterion("shop_appid is not null");
            return (Criteria) this;
        }

        public Criteria andShopAppidEqualTo(String value) {
            addCriterion("shop_appid =", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidNotEqualTo(String value) {
            addCriterion("shop_appid <>", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidGreaterThan(String value) {
            addCriterion("shop_appid >", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidGreaterThanOrEqualTo(String value) {
            addCriterion("shop_appid >=", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidLessThan(String value) {
            addCriterion("shop_appid <", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidLessThanOrEqualTo(String value) {
            addCriterion("shop_appid <=", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidLike(String value) {
            addCriterion("shop_appid like", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidNotLike(String value) {
            addCriterion("shop_appid not like", value, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidIn(List<String> values) {
            addCriterion("shop_appid in", values, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidNotIn(List<String> values) {
            addCriterion("shop_appid not in", values, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidBetween(String value1, String value2) {
            addCriterion("shop_appid between", value1, value2, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andShopAppidNotBetween(String value1, String value2) {
            addCriterion("shop_appid not between", value1, value2, "shopAppid");
            return (Criteria) this;
        }

        public Criteria andFriendUrlIsNull() {
            addCriterion("friend_url is null");
            return (Criteria) this;
        }

        public Criteria andFriendUrlIsNotNull() {
            addCriterion("friend_url is not null");
            return (Criteria) this;
        }

        public Criteria andFriendUrlEqualTo(String value) {
            addCriterion("friend_url =", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlNotEqualTo(String value) {
            addCriterion("friend_url <>", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlGreaterThan(String value) {
            addCriterion("friend_url >", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlGreaterThanOrEqualTo(String value) {
            addCriterion("friend_url >=", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLessThan(String value) {
            addCriterion("friend_url <", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLessThanOrEqualTo(String value) {
            addCriterion("friend_url <=", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlLike(String value) {
            addCriterion("friend_url like", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlNotLike(String value) {
            addCriterion("friend_url not like", value, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlIn(List<String> values) {
            addCriterion("friend_url in", values, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlNotIn(List<String> values) {
            addCriterion("friend_url not in", values, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlBetween(String value1, String value2) {
            addCriterion("friend_url between", value1, value2, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andFriendUrlNotBetween(String value1, String value2) {
            addCriterion("friend_url not between", value1, value2, "friendUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNull() {
            addCriterion("web_url is null");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNotNull() {
            addCriterion("web_url is not null");
            return (Criteria) this;
        }

        public Criteria andWebUrlEqualTo(String value) {
            addCriterion("web_url =", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotEqualTo(String value) {
            addCriterion("web_url <>", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThan(String value) {
            addCriterion("web_url >", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThanOrEqualTo(String value) {
            addCriterion("web_url >=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThan(String value) {
            addCriterion("web_url <", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThanOrEqualTo(String value) {
            addCriterion("web_url <=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLike(String value) {
            addCriterion("web_url like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotLike(String value) {
            addCriterion("web_url not like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIn(List<String> values) {
            addCriterion("web_url in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotIn(List<String> values) {
            addCriterion("web_url not in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlBetween(String value1, String value2) {
            addCriterion("web_url between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotBetween(String value1, String value2) {
            addCriterion("web_url not between", value1, value2, "webUrl");
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