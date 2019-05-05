package com.zhongwei.namecard.entity;

import java.util.ArrayList;
import java.util.List;

public class PaySetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaySetExample() {
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

        public Criteria andMchidIsNull() {
            addCriterion("mchId is null");
            return (Criteria) this;
        }

        public Criteria andMchidIsNotNull() {
            addCriterion("mchId is not null");
            return (Criteria) this;
        }

        public Criteria andMchidEqualTo(String value) {
            addCriterion("mchId =", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotEqualTo(String value) {
            addCriterion("mchId <>", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidGreaterThan(String value) {
            addCriterion("mchId >", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidGreaterThanOrEqualTo(String value) {
            addCriterion("mchId >=", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLessThan(String value) {
            addCriterion("mchId <", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLessThanOrEqualTo(String value) {
            addCriterion("mchId <=", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLike(String value) {
            addCriterion("mchId like", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotLike(String value) {
            addCriterion("mchId not like", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidIn(List<String> values) {
            addCriterion("mchId in", values, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotIn(List<String> values) {
            addCriterion("mchId not in", values, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidBetween(String value1, String value2) {
            addCriterion("mchId between", value1, value2, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotBetween(String value1, String value2) {
            addCriterion("mchId not between", value1, value2, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchkeyIsNull() {
            addCriterion("mchKey is null");
            return (Criteria) this;
        }

        public Criteria andMchkeyIsNotNull() {
            addCriterion("mchKey is not null");
            return (Criteria) this;
        }

        public Criteria andMchkeyEqualTo(String value) {
            addCriterion("mchKey =", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyNotEqualTo(String value) {
            addCriterion("mchKey <>", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyGreaterThan(String value) {
            addCriterion("mchKey >", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyGreaterThanOrEqualTo(String value) {
            addCriterion("mchKey >=", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyLessThan(String value) {
            addCriterion("mchKey <", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyLessThanOrEqualTo(String value) {
            addCriterion("mchKey <=", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyLike(String value) {
            addCriterion("mchKey like", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyNotLike(String value) {
            addCriterion("mchKey not like", value, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyIn(List<String> values) {
            addCriterion("mchKey in", values, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyNotIn(List<String> values) {
            addCriterion("mchKey not in", values, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyBetween(String value1, String value2) {
            addCriterion("mchKey between", value1, value2, "mchkey");
            return (Criteria) this;
        }

        public Criteria andMchkeyNotBetween(String value1, String value2) {
            addCriterion("mchKey not between", value1, value2, "mchkey");
            return (Criteria) this;
        }

        public Criteria andSubappidIsNull() {
            addCriterion("subAppId is null");
            return (Criteria) this;
        }

        public Criteria andSubappidIsNotNull() {
            addCriterion("subAppId is not null");
            return (Criteria) this;
        }

        public Criteria andSubappidEqualTo(String value) {
            addCriterion("subAppId =", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidNotEqualTo(String value) {
            addCriterion("subAppId <>", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidGreaterThan(String value) {
            addCriterion("subAppId >", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidGreaterThanOrEqualTo(String value) {
            addCriterion("subAppId >=", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidLessThan(String value) {
            addCriterion("subAppId <", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidLessThanOrEqualTo(String value) {
            addCriterion("subAppId <=", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidLike(String value) {
            addCriterion("subAppId like", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidNotLike(String value) {
            addCriterion("subAppId not like", value, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidIn(List<String> values) {
            addCriterion("subAppId in", values, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidNotIn(List<String> values) {
            addCriterion("subAppId not in", values, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidBetween(String value1, String value2) {
            addCriterion("subAppId between", value1, value2, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubappidNotBetween(String value1, String value2) {
            addCriterion("subAppId not between", value1, value2, "subappid");
            return (Criteria) this;
        }

        public Criteria andSubmchidIsNull() {
            addCriterion("subMchId is null");
            return (Criteria) this;
        }

        public Criteria andSubmchidIsNotNull() {
            addCriterion("subMchId is not null");
            return (Criteria) this;
        }

        public Criteria andSubmchidEqualTo(String value) {
            addCriterion("subMchId =", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidNotEqualTo(String value) {
            addCriterion("subMchId <>", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidGreaterThan(String value) {
            addCriterion("subMchId >", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidGreaterThanOrEqualTo(String value) {
            addCriterion("subMchId >=", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidLessThan(String value) {
            addCriterion("subMchId <", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidLessThanOrEqualTo(String value) {
            addCriterion("subMchId <=", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidLike(String value) {
            addCriterion("subMchId like", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidNotLike(String value) {
            addCriterion("subMchId not like", value, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidIn(List<String> values) {
            addCriterion("subMchId in", values, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidNotIn(List<String> values) {
            addCriterion("subMchId not in", values, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidBetween(String value1, String value2) {
            addCriterion("subMchId between", value1, value2, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchidNotBetween(String value1, String value2) {
            addCriterion("subMchId not between", value1, value2, "submchid");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyIsNull() {
            addCriterion("subMchKey is null");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyIsNotNull() {
            addCriterion("subMchKey is not null");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyEqualTo(String value) {
            addCriterion("subMchKey =", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyNotEqualTo(String value) {
            addCriterion("subMchKey <>", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyGreaterThan(String value) {
            addCriterion("subMchKey >", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyGreaterThanOrEqualTo(String value) {
            addCriterion("subMchKey >=", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyLessThan(String value) {
            addCriterion("subMchKey <", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyLessThanOrEqualTo(String value) {
            addCriterion("subMchKey <=", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyLike(String value) {
            addCriterion("subMchKey like", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyNotLike(String value) {
            addCriterion("subMchKey not like", value, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyIn(List<String> values) {
            addCriterion("subMchKey in", values, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyNotIn(List<String> values) {
            addCriterion("subMchKey not in", values, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyBetween(String value1, String value2) {
            addCriterion("subMchKey between", value1, value2, "submchkey");
            return (Criteria) this;
        }

        public Criteria andSubmchkeyNotBetween(String value1, String value2) {
            addCriterion("subMchKey not between", value1, value2, "submchkey");
            return (Criteria) this;
        }

        public Criteria andCertpathIsNull() {
            addCriterion("certpath is null");
            return (Criteria) this;
        }

        public Criteria andCertpathIsNotNull() {
            addCriterion("certpath is not null");
            return (Criteria) this;
        }

        public Criteria andCertpathEqualTo(String value) {
            addCriterion("certpath =", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathNotEqualTo(String value) {
            addCriterion("certpath <>", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathGreaterThan(String value) {
            addCriterion("certpath >", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathGreaterThanOrEqualTo(String value) {
            addCriterion("certpath >=", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathLessThan(String value) {
            addCriterion("certpath <", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathLessThanOrEqualTo(String value) {
            addCriterion("certpath <=", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathLike(String value) {
            addCriterion("certpath like", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathNotLike(String value) {
            addCriterion("certpath not like", value, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathIn(List<String> values) {
            addCriterion("certpath in", values, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathNotIn(List<String> values) {
            addCriterion("certpath not in", values, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathBetween(String value1, String value2) {
            addCriterion("certpath between", value1, value2, "certpath");
            return (Criteria) this;
        }

        public Criteria andCertpathNotBetween(String value1, String value2) {
            addCriterion("certpath not between", value1, value2, "certpath");
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