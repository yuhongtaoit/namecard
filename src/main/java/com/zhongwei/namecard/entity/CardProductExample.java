package com.zhongwei.namecard.entity;

import java.util.ArrayList;
import java.util.List;

public class CardProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardProductExample() {
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

        public Criteria andCpBsNameIsNull() {
            addCriterion("cp_bs_name is null");
            return (Criteria) this;
        }

        public Criteria andCpBsNameIsNotNull() {
            addCriterion("cp_bs_name is not null");
            return (Criteria) this;
        }

        public Criteria andCpBsNameEqualTo(String value) {
            addCriterion("cp_bs_name =", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameNotEqualTo(String value) {
            addCriterion("cp_bs_name <>", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameGreaterThan(String value) {
            addCriterion("cp_bs_name >", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameGreaterThanOrEqualTo(String value) {
            addCriterion("cp_bs_name >=", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameLessThan(String value) {
            addCriterion("cp_bs_name <", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameLessThanOrEqualTo(String value) {
            addCriterion("cp_bs_name <=", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameLike(String value) {
            addCriterion("cp_bs_name like", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameNotLike(String value) {
            addCriterion("cp_bs_name not like", value, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameIn(List<String> values) {
            addCriterion("cp_bs_name in", values, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameNotIn(List<String> values) {
            addCriterion("cp_bs_name not in", values, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameBetween(String value1, String value2) {
            addCriterion("cp_bs_name between", value1, value2, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsNameNotBetween(String value1, String value2) {
            addCriterion("cp_bs_name not between", value1, value2, "cpBsName");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceIsNull() {
            addCriterion("cp_bs_price is null");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceIsNotNull() {
            addCriterion("cp_bs_price is not null");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceEqualTo(String value) {
            addCriterion("cp_bs_price =", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceNotEqualTo(String value) {
            addCriterion("cp_bs_price <>", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceGreaterThan(String value) {
            addCriterion("cp_bs_price >", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceGreaterThanOrEqualTo(String value) {
            addCriterion("cp_bs_price >=", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceLessThan(String value) {
            addCriterion("cp_bs_price <", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceLessThanOrEqualTo(String value) {
            addCriterion("cp_bs_price <=", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceLike(String value) {
            addCriterion("cp_bs_price like", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceNotLike(String value) {
            addCriterion("cp_bs_price not like", value, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceIn(List<String> values) {
            addCriterion("cp_bs_price in", values, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceNotIn(List<String> values) {
            addCriterion("cp_bs_price not in", values, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceBetween(String value1, String value2) {
            addCriterion("cp_bs_price between", value1, value2, "cpBsPrice");
            return (Criteria) this;
        }

        public Criteria andCpBsPriceNotBetween(String value1, String value2) {
            addCriterion("cp_bs_price not between", value1, value2, "cpBsPrice");
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