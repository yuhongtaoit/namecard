package com.zhongwei.namecard.miniapp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardMemberExample() {
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

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(String value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(String value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(String value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(String value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(String value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLike(String value) {
            addCriterion("addtime like", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotLike(String value) {
            addCriterion("addtime not like", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<String> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<String> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(String value1, String value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(String value1, String value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updatetime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updatetime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andShowZanIsNull() {
            addCriterion("show_zan is null");
            return (Criteria) this;
        }

        public Criteria andShowZanIsNotNull() {
            addCriterion("show_zan is not null");
            return (Criteria) this;
        }

        public Criteria andShowZanEqualTo(Byte value) {
            addCriterion("show_zan =", value, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanNotEqualTo(Byte value) {
            addCriterion("show_zan <>", value, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanGreaterThan(Byte value) {
            addCriterion("show_zan >", value, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_zan >=", value, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanLessThan(Byte value) {
            addCriterion("show_zan <", value, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanLessThanOrEqualTo(Byte value) {
            addCriterion("show_zan <=", value, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanIn(List<Byte> values) {
            addCriterion("show_zan in", values, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanNotIn(List<Byte> values) {
            addCriterion("show_zan not in", values, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanBetween(Byte value1, Byte value2) {
            addCriterion("show_zan between", value1, value2, "showZan");
            return (Criteria) this;
        }

        public Criteria andShowZanNotBetween(Byte value1, Byte value2) {
            addCriterion("show_zan not between", value1, value2, "showZan");
            return (Criteria) this;
        }

        public Criteria andIsPopCardIsNull() {
            addCriterion("is_pop_card is null");
            return (Criteria) this;
        }

        public Criteria andIsPopCardIsNotNull() {
            addCriterion("is_pop_card is not null");
            return (Criteria) this;
        }

        public Criteria andIsPopCardEqualTo(Byte value) {
            addCriterion("is_pop_card =", value, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardNotEqualTo(Byte value) {
            addCriterion("is_pop_card <>", value, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardGreaterThan(Byte value) {
            addCriterion("is_pop_card >", value, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_pop_card >=", value, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardLessThan(Byte value) {
            addCriterion("is_pop_card <", value, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardLessThanOrEqualTo(Byte value) {
            addCriterion("is_pop_card <=", value, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardIn(List<Byte> values) {
            addCriterion("is_pop_card in", values, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardNotIn(List<Byte> values) {
            addCriterion("is_pop_card not in", values, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardBetween(Byte value1, Byte value2) {
            addCriterion("is_pop_card between", value1, value2, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andIsPopCardNotBetween(Byte value1, Byte value2) {
            addCriterion("is_pop_card not between", value1, value2, "isPopCard");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNull() {
            addCriterion("avatar_url is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNotNull() {
            addCriterion("avatar_url is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlEqualTo(String value) {
            addCriterion("avatar_url =", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotEqualTo(String value) {
            addCriterion("avatar_url <>", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThan(String value) {
            addCriterion("avatar_url >", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_url >=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThan(String value) {
            addCriterion("avatar_url <", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThanOrEqualTo(String value) {
            addCriterion("avatar_url <=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLike(String value) {
            addCriterion("avatar_url like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotLike(String value) {
            addCriterion("avatar_url not like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIn(List<String> values) {
            addCriterion("avatar_url in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotIn(List<String> values) {
            addCriterion("avatar_url not in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlBetween(String value1, String value2) {
            addCriterion("avatar_url between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotBetween(String value1, String value2) {
            addCriterion("avatar_url not between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andGailvIsNull() {
            addCriterion("gailv is null");
            return (Criteria) this;
        }

        public Criteria andGailvIsNotNull() {
            addCriterion("gailv is not null");
            return (Criteria) this;
        }

        public Criteria andGailvEqualTo(Byte value) {
            addCriterion("gailv =", value, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvNotEqualTo(Byte value) {
            addCriterion("gailv <>", value, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvGreaterThan(Byte value) {
            addCriterion("gailv >", value, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvGreaterThanOrEqualTo(Byte value) {
            addCriterion("gailv >=", value, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvLessThan(Byte value) {
            addCriterion("gailv <", value, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvLessThanOrEqualTo(Byte value) {
            addCriterion("gailv <=", value, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvIn(List<Byte> values) {
            addCriterion("gailv in", values, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvNotIn(List<Byte> values) {
            addCriterion("gailv not in", values, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvBetween(Byte value1, Byte value2) {
            addCriterion("gailv between", value1, value2, "gailv");
            return (Criteria) this;
        }

        public Criteria andGailvNotBetween(Byte value1, Byte value2) {
            addCriterion("gailv not between", value1, value2, "gailv");
            return (Criteria) this;
        }

        public Criteria andHmdStatusIsNull() {
            addCriterion("hmd_status is null");
            return (Criteria) this;
        }

        public Criteria andHmdStatusIsNotNull() {
            addCriterion("hmd_status is not null");
            return (Criteria) this;
        }

        public Criteria andHmdStatusEqualTo(Byte value) {
            addCriterion("hmd_status =", value, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusNotEqualTo(Byte value) {
            addCriterion("hmd_status <>", value, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusGreaterThan(Byte value) {
            addCriterion("hmd_status >", value, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("hmd_status >=", value, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusLessThan(Byte value) {
            addCriterion("hmd_status <", value, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusLessThanOrEqualTo(Byte value) {
            addCriterion("hmd_status <=", value, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusIn(List<Byte> values) {
            addCriterion("hmd_status in", values, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusNotIn(List<Byte> values) {
            addCriterion("hmd_status not in", values, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusBetween(Byte value1, Byte value2) {
            addCriterion("hmd_status between", value1, value2, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andHmdStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("hmd_status not between", value1, value2, "hmdStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusIsNull() {
            addCriterion("pb_status is null");
            return (Criteria) this;
        }

        public Criteria andPbStatusIsNotNull() {
            addCriterion("pb_status is not null");
            return (Criteria) this;
        }

        public Criteria andPbStatusEqualTo(Byte value) {
            addCriterion("pb_status =", value, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusNotEqualTo(Byte value) {
            addCriterion("pb_status <>", value, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusGreaterThan(Byte value) {
            addCriterion("pb_status >", value, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("pb_status >=", value, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusLessThan(Byte value) {
            addCriterion("pb_status <", value, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusLessThanOrEqualTo(Byte value) {
            addCriterion("pb_status <=", value, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusIn(List<Byte> values) {
            addCriterion("pb_status in", values, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusNotIn(List<Byte> values) {
            addCriterion("pb_status not in", values, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusBetween(Byte value1, Byte value2) {
            addCriterion("pb_status between", value1, value2, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andPbStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("pb_status not between", value1, value2, "pbStatus");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andCanTakeIsNull() {
            addCriterion("can_take is null");
            return (Criteria) this;
        }

        public Criteria andCanTakeIsNotNull() {
            addCriterion("can_take is not null");
            return (Criteria) this;
        }

        public Criteria andCanTakeEqualTo(BigDecimal value) {
            addCriterion("can_take =", value, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeNotEqualTo(BigDecimal value) {
            addCriterion("can_take <>", value, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeGreaterThan(BigDecimal value) {
            addCriterion("can_take >", value, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("can_take >=", value, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeLessThan(BigDecimal value) {
            addCriterion("can_take <", value, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("can_take <=", value, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeIn(List<BigDecimal> values) {
            addCriterion("can_take in", values, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeNotIn(List<BigDecimal> values) {
            addCriterion("can_take not in", values, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("can_take between", value1, value2, "canTake");
            return (Criteria) this;
        }

        public Criteria andCanTakeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("can_take not between", value1, value2, "canTake");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerIsNull() {
            addCriterion("total_broker is null");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerIsNotNull() {
            addCriterion("total_broker is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerEqualTo(BigDecimal value) {
            addCriterion("total_broker =", value, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerNotEqualTo(BigDecimal value) {
            addCriterion("total_broker <>", value, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerGreaterThan(BigDecimal value) {
            addCriterion("total_broker >", value, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_broker >=", value, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerLessThan(BigDecimal value) {
            addCriterion("total_broker <", value, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_broker <=", value, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerIn(List<BigDecimal> values) {
            addCriterion("total_broker in", values, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerNotIn(List<BigDecimal> values) {
            addCriterion("total_broker not in", values, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_broker between", value1, value2, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andTotalBrokerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_broker not between", value1, value2, "totalBroker");
            return (Criteria) this;
        }

        public Criteria andHasTakenIsNull() {
            addCriterion("has_taken is null");
            return (Criteria) this;
        }

        public Criteria andHasTakenIsNotNull() {
            addCriterion("has_taken is not null");
            return (Criteria) this;
        }

        public Criteria andHasTakenEqualTo(BigDecimal value) {
            addCriterion("has_taken =", value, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenNotEqualTo(BigDecimal value) {
            addCriterion("has_taken <>", value, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenGreaterThan(BigDecimal value) {
            addCriterion("has_taken >", value, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("has_taken >=", value, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenLessThan(BigDecimal value) {
            addCriterion("has_taken <", value, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("has_taken <=", value, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenIn(List<BigDecimal> values) {
            addCriterion("has_taken in", values, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenNotIn(List<BigDecimal> values) {
            addCriterion("has_taken not in", values, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("has_taken between", value1, value2, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andHasTakenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("has_taken not between", value1, value2, "hasTaken");
            return (Criteria) this;
        }

        public Criteria andInTakingIsNull() {
            addCriterion("in_taking is null");
            return (Criteria) this;
        }

        public Criteria andInTakingIsNotNull() {
            addCriterion("in_taking is not null");
            return (Criteria) this;
        }

        public Criteria andInTakingEqualTo(BigDecimal value) {
            addCriterion("in_taking =", value, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingNotEqualTo(BigDecimal value) {
            addCriterion("in_taking <>", value, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingGreaterThan(BigDecimal value) {
            addCriterion("in_taking >", value, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("in_taking >=", value, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingLessThan(BigDecimal value) {
            addCriterion("in_taking <", value, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("in_taking <=", value, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingIn(List<BigDecimal> values) {
            addCriterion("in_taking in", values, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingNotIn(List<BigDecimal> values) {
            addCriterion("in_taking not in", values, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_taking between", value1, value2, "inTaking");
            return (Criteria) this;
        }

        public Criteria andInTakingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_taking not between", value1, value2, "inTaking");
            return (Criteria) this;
        }

        public Criteria andNotInAccountIsNull() {
            addCriterion("not_in_account is null");
            return (Criteria) this;
        }

        public Criteria andNotInAccountIsNotNull() {
            addCriterion("not_in_account is not null");
            return (Criteria) this;
        }

        public Criteria andNotInAccountEqualTo(BigDecimal value) {
            addCriterion("not_in_account =", value, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountNotEqualTo(BigDecimal value) {
            addCriterion("not_in_account <>", value, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountGreaterThan(BigDecimal value) {
            addCriterion("not_in_account >", value, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("not_in_account >=", value, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountLessThan(BigDecimal value) {
            addCriterion("not_in_account <", value, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("not_in_account <=", value, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountIn(List<BigDecimal> values) {
            addCriterion("not_in_account in", values, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountNotIn(List<BigDecimal> values) {
            addCriterion("not_in_account not in", values, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_in_account between", value1, value2, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andNotInAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("not_in_account not between", value1, value2, "notInAccount");
            return (Criteria) this;
        }

        public Criteria andSendCardidIsNull() {
            addCriterion("send_cardid is null");
            return (Criteria) this;
        }

        public Criteria andSendCardidIsNotNull() {
            addCriterion("send_cardid is not null");
            return (Criteria) this;
        }

        public Criteria andSendCardidEqualTo(Integer value) {
            addCriterion("send_cardid =", value, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidNotEqualTo(Integer value) {
            addCriterion("send_cardid <>", value, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidGreaterThan(Integer value) {
            addCriterion("send_cardid >", value, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_cardid >=", value, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidLessThan(Integer value) {
            addCriterion("send_cardid <", value, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidLessThanOrEqualTo(Integer value) {
            addCriterion("send_cardid <=", value, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidIn(List<Integer> values) {
            addCriterion("send_cardid in", values, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidNotIn(List<Integer> values) {
            addCriterion("send_cardid not in", values, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidBetween(Integer value1, Integer value2) {
            addCriterion("send_cardid between", value1, value2, "sendCardid");
            return (Criteria) this;
        }

        public Criteria andSendCardidNotBetween(Integer value1, Integer value2) {
            addCriterion("send_cardid not between", value1, value2, "sendCardid");
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