package com.zhongwei.namecard.miniapp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CardShopsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardShopsExample() {
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

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andSpecidIsNull() {
            addCriterion("specid is null");
            return (Criteria) this;
        }

        public Criteria andSpecidIsNotNull() {
            addCriterion("specid is not null");
            return (Criteria) this;
        }

        public Criteria andSpecidEqualTo(Integer value) {
            addCriterion("specid =", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidNotEqualTo(Integer value) {
            addCriterion("specid <>", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidGreaterThan(Integer value) {
            addCriterion("specid >", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidGreaterThanOrEqualTo(Integer value) {
            addCriterion("specid >=", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidLessThan(Integer value) {
            addCriterion("specid <", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidLessThanOrEqualTo(Integer value) {
            addCriterion("specid <=", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidIn(List<Integer> values) {
            addCriterion("specid in", values, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidNotIn(List<Integer> values) {
            addCriterion("specid not in", values, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidBetween(Integer value1, Integer value2) {
            addCriterion("specid between", value1, value2, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidNotBetween(Integer value1, Integer value2) {
            addCriterion("specid not between", value1, value2, "specid");
            return (Criteria) this;
        }

        public Criteria andSaleNumIsNull() {
            addCriterion("sale_num is null");
            return (Criteria) this;
        }

        public Criteria andSaleNumIsNotNull() {
            addCriterion("sale_num is not null");
            return (Criteria) this;
        }

        public Criteria andSaleNumEqualTo(Integer value) {
            addCriterion("sale_num =", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumNotEqualTo(Integer value) {
            addCriterion("sale_num <>", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumGreaterThan(Integer value) {
            addCriterion("sale_num >", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_num >=", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumLessThan(Integer value) {
            addCriterion("sale_num <", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumLessThanOrEqualTo(Integer value) {
            addCriterion("sale_num <=", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumIn(List<Integer> values) {
            addCriterion("sale_num in", values, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumNotIn(List<Integer> values) {
            addCriterion("sale_num not in", values, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumBetween(Integer value1, Integer value2) {
            addCriterion("sale_num between", value1, value2, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_num not between", value1, value2, "saleNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumIsNull() {
            addCriterion("shops_num is null");
            return (Criteria) this;
        }

        public Criteria andShopsNumIsNotNull() {
            addCriterion("shops_num is not null");
            return (Criteria) this;
        }

        public Criteria andShopsNumEqualTo(Integer value) {
            addCriterion("shops_num =", value, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumNotEqualTo(Integer value) {
            addCriterion("shops_num <>", value, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumGreaterThan(Integer value) {
            addCriterion("shops_num >", value, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("shops_num >=", value, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumLessThan(Integer value) {
            addCriterion("shops_num <", value, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumLessThanOrEqualTo(Integer value) {
            addCriterion("shops_num <=", value, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumIn(List<Integer> values) {
            addCriterion("shops_num in", values, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumNotIn(List<Integer> values) {
            addCriterion("shops_num not in", values, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumBetween(Integer value1, Integer value2) {
            addCriterion("shops_num between", value1, value2, "shopsNum");
            return (Criteria) this;
        }

        public Criteria andShopsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("shops_num not between", value1, value2, "shopsNum");
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

        public Criteria andShopSpecIsNull() {
            addCriterion("shop_spec is null");
            return (Criteria) this;
        }

        public Criteria andShopSpecIsNotNull() {
            addCriterion("shop_spec is not null");
            return (Criteria) this;
        }

        public Criteria andShopSpecEqualTo(Boolean value) {
            addCriterion("shop_spec =", value, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecNotEqualTo(Boolean value) {
            addCriterion("shop_spec <>", value, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecGreaterThan(Boolean value) {
            addCriterion("shop_spec >", value, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shop_spec >=", value, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecLessThan(Boolean value) {
            addCriterion("shop_spec <", value, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecLessThanOrEqualTo(Boolean value) {
            addCriterion("shop_spec <=", value, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecIn(List<Boolean> values) {
            addCriterion("shop_spec in", values, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecNotIn(List<Boolean> values) {
            addCriterion("shop_spec not in", values, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecBetween(Boolean value1, Boolean value2) {
            addCriterion("shop_spec between", value1, value2, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andShopSpecNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shop_spec not between", value1, value2, "shopSpec");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(int value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(int value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Boolean value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Boolean value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Boolean value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Boolean> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Boolean> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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

        public Criteria andGimgIsNull() {
            addCriterion("gimg is null");
            return (Criteria) this;
        }

        public Criteria andGimgIsNotNull() {
            addCriterion("gimg is not null");
            return (Criteria) this;
        }

        public Criteria andGimgEqualTo(String value) {
            addCriterion("gimg =", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgNotEqualTo(String value) {
            addCriterion("gimg <>", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgGreaterThan(String value) {
            addCriterion("gimg >", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgGreaterThanOrEqualTo(String value) {
            addCriterion("gimg >=", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgLessThan(String value) {
            addCriterion("gimg <", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgLessThanOrEqualTo(String value) {
            addCriterion("gimg <=", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgLike(String value) {
            addCriterion("gimg like", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgNotLike(String value) {
            addCriterion("gimg not like", value, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgIn(List<String> values) {
            addCriterion("gimg in", values, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgNotIn(List<String> values) {
            addCriterion("gimg not in", values, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgBetween(String value1, String value2) {
            addCriterion("gimg between", value1, value2, "gimg");
            return (Criteria) this;
        }

        public Criteria andGimgNotBetween(String value1, String value2) {
            addCriterion("gimg not between", value1, value2, "gimg");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andFxTypeIsNull() {
            addCriterion("fx_type is null");
            return (Criteria) this;
        }

        public Criteria andFxTypeIsNotNull() {
            addCriterion("fx_type is not null");
            return (Criteria) this;
        }

        public Criteria andFxTypeEqualTo(Byte value) {
            addCriterion("fx_type =", value, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeNotEqualTo(Byte value) {
            addCriterion("fx_type <>", value, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeGreaterThan(Byte value) {
            addCriterion("fx_type >", value, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("fx_type >=", value, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeLessThan(Byte value) {
            addCriterion("fx_type <", value, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeLessThanOrEqualTo(Byte value) {
            addCriterion("fx_type <=", value, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeIn(List<Byte> values) {
            addCriterion("fx_type in", values, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeNotIn(List<Byte> values) {
            addCriterion("fx_type not in", values, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeBetween(Byte value1, Byte value2) {
            addCriterion("fx_type between", value1, value2, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("fx_type not between", value1, value2, "fxType");
            return (Criteria) this;
        }

        public Criteria andFxPriceIsNull() {
            addCriterion("fx_price is null");
            return (Criteria) this;
        }

        public Criteria andFxPriceIsNotNull() {
            addCriterion("fx_price is not null");
            return (Criteria) this;
        }

        public Criteria andFxPriceEqualTo(BigDecimal value) {
            addCriterion("fx_price =", value, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceNotEqualTo(BigDecimal value) {
            addCriterion("fx_price <>", value, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceGreaterThan(BigDecimal value) {
            addCriterion("fx_price >", value, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fx_price >=", value, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceLessThan(BigDecimal value) {
            addCriterion("fx_price <", value, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fx_price <=", value, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceIn(List<BigDecimal> values) {
            addCriterion("fx_price in", values, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceNotIn(List<BigDecimal> values) {
            addCriterion("fx_price not in", values, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fx_price between", value1, value2, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andFxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fx_price not between", value1, value2, "fxPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceIsNull() {
            addCriterion("no_show_price is null");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceIsNotNull() {
            addCriterion("no_show_price is not null");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceEqualTo(Boolean value) {
            addCriterion("no_show_price =", value, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceNotEqualTo(Boolean value) {
            addCriterion("no_show_price <>", value, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceGreaterThan(Boolean value) {
            addCriterion("no_show_price >", value, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceGreaterThanOrEqualTo(Boolean value) {
            addCriterion("no_show_price >=", value, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceLessThan(Boolean value) {
            addCriterion("no_show_price <", value, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceLessThanOrEqualTo(Boolean value) {
            addCriterion("no_show_price <=", value, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceIn(List<Boolean> values) {
            addCriterion("no_show_price in", values, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceNotIn(List<Boolean> values) {
            addCriterion("no_show_price not in", values, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceBetween(Boolean value1, Boolean value2) {
            addCriterion("no_show_price between", value1, value2, "noShowPrice");
            return (Criteria) this;
        }

        public Criteria andNoShowPriceNotBetween(Boolean value1, Boolean value2) {
            addCriterion("no_show_price not between", value1, value2, "noShowPrice");
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