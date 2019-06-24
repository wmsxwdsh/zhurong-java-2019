package com.zhurong.db.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDictNoIsNull() {
            addCriterion("DICT_NO is null");
            return (Criteria) this;
        }

        public Criteria andDictNoIsNotNull() {
            addCriterion("DICT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDictNoEqualTo(String value) {
            addCriterion("DICT_NO =", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoNotEqualTo(String value) {
            addCriterion("DICT_NO <>", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoGreaterThan(String value) {
            addCriterion("DICT_NO >", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_NO >=", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoLessThan(String value) {
            addCriterion("DICT_NO <", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoLessThanOrEqualTo(String value) {
            addCriterion("DICT_NO <=", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoLike(String value) {
            addCriterion("DICT_NO like", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoNotLike(String value) {
            addCriterion("DICT_NO not like", value, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoIn(List<String> values) {
            addCriterion("DICT_NO in", values, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoNotIn(List<String> values) {
            addCriterion("DICT_NO not in", values, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoBetween(String value1, String value2) {
            addCriterion("DICT_NO between", value1, value2, "dictNo");
            return (Criteria) this;
        }

        public Criteria andDictNoNotBetween(String value1, String value2) {
            addCriterion("DICT_NO not between", value1, value2, "dictNo");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("ITEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("ITEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("ITEM_CODE =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("ITEM_CODE <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("ITEM_CODE >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_CODE >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("ITEM_CODE <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_CODE <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("ITEM_CODE like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("ITEM_CODE not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("ITEM_CODE in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("ITEM_CODE not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("ITEM_CODE between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("ITEM_CODE not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andModelFlagIsNull() {
            addCriterion("MODEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andModelFlagIsNotNull() {
            addCriterion("MODEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andModelFlagEqualTo(String value) {
            addCriterion("MODEL_FLAG =", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotEqualTo(String value) {
            addCriterion("MODEL_FLAG <>", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagGreaterThan(String value) {
            addCriterion("MODEL_FLAG >", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_FLAG >=", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagLessThan(String value) {
            addCriterion("MODEL_FLAG <", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagLessThanOrEqualTo(String value) {
            addCriterion("MODEL_FLAG <=", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagLike(String value) {
            addCriterion("MODEL_FLAG like", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotLike(String value) {
            addCriterion("MODEL_FLAG not like", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagIn(List<String> values) {
            addCriterion("MODEL_FLAG in", values, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotIn(List<String> values) {
            addCriterion("MODEL_FLAG not in", values, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagBetween(String value1, String value2) {
            addCriterion("MODEL_FLAG between", value1, value2, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotBetween(String value1, String value2) {
            addCriterion("MODEL_FLAG not between", value1, value2, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeIsNull() {
            addCriterion("PARENT_ITEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeIsNotNull() {
            addCriterion("PARENT_ITEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeEqualTo(String value) {
            addCriterion("PARENT_ITEM_CODE =", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeNotEqualTo(String value) {
            addCriterion("PARENT_ITEM_CODE <>", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeGreaterThan(String value) {
            addCriterion("PARENT_ITEM_CODE >", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ITEM_CODE >=", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeLessThan(String value) {
            addCriterion("PARENT_ITEM_CODE <", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ITEM_CODE <=", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeLike(String value) {
            addCriterion("PARENT_ITEM_CODE like", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeNotLike(String value) {
            addCriterion("PARENT_ITEM_CODE not like", value, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeIn(List<String> values) {
            addCriterion("PARENT_ITEM_CODE in", values, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeNotIn(List<String> values) {
            addCriterion("PARENT_ITEM_CODE not in", values, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeBetween(String value1, String value2) {
            addCriterion("PARENT_ITEM_CODE between", value1, value2, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentItemCodeNotBetween(String value1, String value2) {
            addCriterion("PARENT_ITEM_CODE not between", value1, value2, "parentItemCode");
            return (Criteria) this;
        }

        public Criteria andParentDictNoIsNull() {
            addCriterion("PARENT_DICT_NO is null");
            return (Criteria) this;
        }

        public Criteria andParentDictNoIsNotNull() {
            addCriterion("PARENT_DICT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andParentDictNoEqualTo(String value) {
            addCriterion("PARENT_DICT_NO =", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoNotEqualTo(String value) {
            addCriterion("PARENT_DICT_NO <>", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoGreaterThan(String value) {
            addCriterion("PARENT_DICT_NO >", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_DICT_NO >=", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoLessThan(String value) {
            addCriterion("PARENT_DICT_NO <", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoLessThanOrEqualTo(String value) {
            addCriterion("PARENT_DICT_NO <=", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoLike(String value) {
            addCriterion("PARENT_DICT_NO like", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoNotLike(String value) {
            addCriterion("PARENT_DICT_NO not like", value, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoIn(List<String> values) {
            addCriterion("PARENT_DICT_NO in", values, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoNotIn(List<String> values) {
            addCriterion("PARENT_DICT_NO not in", values, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoBetween(String value1, String value2) {
            addCriterion("PARENT_DICT_NO between", value1, value2, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andParentDictNoNotBetween(String value1, String value2) {
            addCriterion("PARENT_DICT_NO not between", value1, value2, "parentDictNo");
            return (Criteria) this;
        }

        public Criteria andModelOrderIsNull() {
            addCriterion("MODEL_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andModelOrderIsNotNull() {
            addCriterion("MODEL_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andModelOrderEqualTo(Integer value) {
            addCriterion("MODEL_ORDER =", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderNotEqualTo(Integer value) {
            addCriterion("MODEL_ORDER <>", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderGreaterThan(Integer value) {
            addCriterion("MODEL_ORDER >", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_ORDER >=", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderLessThan(Integer value) {
            addCriterion("MODEL_ORDER <", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_ORDER <=", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderIn(List<Integer> values) {
            addCriterion("MODEL_ORDER in", values, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderNotIn(List<Integer> values) {
            addCriterion("MODEL_ORDER not in", values, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_ORDER between", value1, value2, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_ORDER not between", value1, value2, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andChkStsIsNull() {
            addCriterion("CHK_STS is null");
            return (Criteria) this;
        }

        public Criteria andChkStsIsNotNull() {
            addCriterion("CHK_STS is not null");
            return (Criteria) this;
        }

        public Criteria andChkStsEqualTo(String value) {
            addCriterion("CHK_STS =", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsNotEqualTo(String value) {
            addCriterion("CHK_STS <>", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsGreaterThan(String value) {
            addCriterion("CHK_STS >", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsGreaterThanOrEqualTo(String value) {
            addCriterion("CHK_STS >=", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsLessThan(String value) {
            addCriterion("CHK_STS <", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsLessThanOrEqualTo(String value) {
            addCriterion("CHK_STS <=", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsLike(String value) {
            addCriterion("CHK_STS like", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsNotLike(String value) {
            addCriterion("CHK_STS not like", value, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsIn(List<String> values) {
            addCriterion("CHK_STS in", values, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsNotIn(List<String> values) {
            addCriterion("CHK_STS not in", values, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsBetween(String value1, String value2) {
            addCriterion("CHK_STS between", value1, value2, "chkSts");
            return (Criteria) this;
        }

        public Criteria andChkStsNotBetween(String value1, String value2) {
            addCriterion("CHK_STS not between", value1, value2, "chkSts");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("AUDITOR is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("AUDITOR is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("AUDITOR =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("AUDITOR <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("AUDITOR >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITOR >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("AUDITOR <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("AUDITOR <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("AUDITOR like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("AUDITOR not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("AUDITOR in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("AUDITOR not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("AUDITOR between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("AUDITOR not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIsNull() {
            addCriterion("AUDIT_OPINION is null");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIsNotNull() {
            addCriterion("AUDIT_OPINION is not null");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionEqualTo(String value) {
            addCriterion("AUDIT_OPINION =", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotEqualTo(String value) {
            addCriterion("AUDIT_OPINION <>", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionGreaterThan(String value) {
            addCriterion("AUDIT_OPINION >", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_OPINION >=", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLessThan(String value) {
            addCriterion("AUDIT_OPINION <", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_OPINION <=", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLike(String value) {
            addCriterion("AUDIT_OPINION like", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotLike(String value) {
            addCriterion("AUDIT_OPINION not like", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIn(List<String> values) {
            addCriterion("AUDIT_OPINION in", values, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotIn(List<String> values) {
            addCriterion("AUDIT_OPINION not in", values, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionBetween(String value1, String value2) {
            addCriterion("AUDIT_OPINION between", value1, value2, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotBetween(String value1, String value2) {
            addCriterion("AUDIT_OPINION not between", value1, value2, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("AUDIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("AUDIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("AUDIT_TIME =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("AUDIT_TIME <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("AUDIT_TIME >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDIT_TIME >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("AUDIT_TIME <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("AUDIT_TIME <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("AUDIT_TIME in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("AUDIT_TIME not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("AUDIT_TIME between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("AUDIT_TIME not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("UPDATER is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("UPDATER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("UPDATER =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("UPDATER <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("UPDATER >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATER >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("UPDATER <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("UPDATER <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("UPDATER like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("UPDATER not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("UPDATER in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("UPDATER not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("UPDATER between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("UPDATER not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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