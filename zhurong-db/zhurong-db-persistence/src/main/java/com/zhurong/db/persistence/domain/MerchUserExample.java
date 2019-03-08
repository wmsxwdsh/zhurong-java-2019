package com.zhurong.db.persistence.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MerchUserExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    protected Long offset;

    protected Long limit;

    protected Long end;

    public MerchUserExample() {
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

    public void setPagination(long offset, long limit) {
        this.offset = offset;
        this.limit = limit;
        this.end = offset + limit;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMerchUserIdIsNull() {
            addCriterion("MERCH_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdIsNotNull() {
            addCriterion("MERCH_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdEqualTo(String value) {
            addCriterion("MERCH_USER_ID =", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdNotEqualTo(String value) {
            addCriterion("MERCH_USER_ID <>", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdGreaterThan(String value) {
            addCriterion("MERCH_USER_ID >", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_ID >=", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdLessThan(String value) {
            addCriterion("MERCH_USER_ID <", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdLessThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_ID <=", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdLike(String value) {
            addCriterion("MERCH_USER_ID like", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdNotLike(String value) {
            addCriterion("MERCH_USER_ID not like", value, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdIn(List<String> values) {
            addCriterion("MERCH_USER_ID in", values, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdNotIn(List<String> values) {
            addCriterion("MERCH_USER_ID not in", values, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdBetween(String value1, String value2) {
            addCriterion("MERCH_USER_ID between", value1, value2, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchUserIdNotBetween(String value1, String value2) {
            addCriterion("MERCH_USER_ID not between", value1, value2, "merchUserId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNull() {
            addCriterion("MERCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNotNull() {
            addCriterion("MERCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchIdEqualTo(String value) {
            addCriterion("MERCH_ID =", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotEqualTo(String value) {
            addCriterion("MERCH_ID <>", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThan(String value) {
            addCriterion("MERCH_ID >", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_ID >=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThan(String value) {
            addCriterion("MERCH_ID <", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThanOrEqualTo(String value) {
            addCriterion("MERCH_ID <=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLike(String value) {
            addCriterion("MERCH_ID like", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotLike(String value) {
            addCriterion("MERCH_ID not like", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIn(List<String> values) {
            addCriterion("MERCH_ID in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotIn(List<String> values) {
            addCriterion("MERCH_ID not in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdBetween(String value1, String value2) {
            addCriterion("MERCH_ID between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotBetween(String value1, String value2) {
            addCriterion("MERCH_ID not between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameIsNull() {
            addCriterion("MERCH_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameIsNotNull() {
            addCriterion("MERCH_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameEqualTo(String value) {
            addCriterion("MERCH_USER_NAME =", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameNotEqualTo(String value) {
            addCriterion("MERCH_USER_NAME <>", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameGreaterThan(String value) {
            addCriterion("MERCH_USER_NAME >", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_NAME >=", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameLessThan(String value) {
            addCriterion("MERCH_USER_NAME <", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameLessThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_NAME <=", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameLike(String value) {
            addCriterion("MERCH_USER_NAME like", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameNotLike(String value) {
            addCriterion("MERCH_USER_NAME not like", value, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameIn(List<String> values) {
            addCriterion("MERCH_USER_NAME in", values, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameNotIn(List<String> values) {
            addCriterion("MERCH_USER_NAME not in", values, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameBetween(String value1, String value2) {
            addCriterion("MERCH_USER_NAME between", value1, value2, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andMerchUserNameNotBetween(String value1, String value2) {
            addCriterion("MERCH_USER_NAME not between", value1, value2, "merchUserName");
            return (Criteria) this;
        }

        public Criteria andAccountPwdIsNull() {
            addCriterion("ACCOUNT_PWD is null");
            return (Criteria) this;
        }

        public Criteria andAccountPwdIsNotNull() {
            addCriterion("ACCOUNT_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPwdEqualTo(String value) {
            addCriterion("ACCOUNT_PWD =", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdNotEqualTo(String value) {
            addCriterion("ACCOUNT_PWD <>", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdGreaterThan(String value) {
            addCriterion("ACCOUNT_PWD >", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PWD >=", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdLessThan(String value) {
            addCriterion("ACCOUNT_PWD <", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PWD <=", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdLike(String value) {
            addCriterion("ACCOUNT_PWD like", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdNotLike(String value) {
            addCriterion("ACCOUNT_PWD not like", value, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdIn(List<String> values) {
            addCriterion("ACCOUNT_PWD in", values, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdNotIn(List<String> values) {
            addCriterion("ACCOUNT_PWD not in", values, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PWD between", value1, value2, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andAccountPwdNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PWD not between", value1, value2, "accountPwd");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("USER_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("USER_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("USER_BIRTHDAY in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("USER_BIRTHDAY not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("USER_BIRTHDAY between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("USER_BIRTHDAY not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNull() {
            addCriterion("BIRTHPLACE is null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNotNull() {
            addCriterion("BIRTHPLACE is not null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceEqualTo(String value) {
            addCriterion("BIRTHPLACE =", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotEqualTo(String value) {
            addCriterion("BIRTHPLACE <>", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThan(String value) {
            addCriterion("BIRTHPLACE >", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHPLACE >=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThan(String value) {
            addCriterion("BIRTHPLACE <", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThanOrEqualTo(String value) {
            addCriterion("BIRTHPLACE <=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLike(String value) {
            addCriterion("BIRTHPLACE like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotLike(String value) {
            addCriterion("BIRTHPLACE not like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIn(List<String> values) {
            addCriterion("BIRTHPLACE in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotIn(List<String> values) {
            addCriterion("BIRTHPLACE not in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceBetween(String value1, String value2) {
            addCriterion("BIRTHPLACE between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotBetween(String value1, String value2) {
            addCriterion("BIRTHPLACE not between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("GENDER like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("GENDER not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailIsNull() {
            addCriterion("MERCH_USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailIsNotNull() {
            addCriterion("MERCH_USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL =", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailNotEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL <>", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailGreaterThan(String value) {
            addCriterion("MERCH_USER_EMAIL >", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL >=", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailLessThan(String value) {
            addCriterion("MERCH_USER_EMAIL <", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailLessThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL <=", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailLike(String value) {
            addCriterion("MERCH_USER_EMAIL like", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailNotLike(String value) {
            addCriterion("MERCH_USER_EMAIL not like", value, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailIn(List<String> values) {
            addCriterion("MERCH_USER_EMAIL in", values, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailNotIn(List<String> values) {
            addCriterion("MERCH_USER_EMAIL not in", values, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailBetween(String value1, String value2) {
            addCriterion("MERCH_USER_EMAIL between", value1, value2, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailNotBetween(String value1, String value2) {
            addCriterion("MERCH_USER_EMAIL not between", value1, value2, "merchUserEmail");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthIsNull() {
            addCriterion("MERCH_USER_EMAIL_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthIsNotNull() {
            addCriterion("MERCH_USER_EMAIL_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH =", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthNotEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH <>", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthGreaterThan(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH >", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH >=", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthLessThan(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH <", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthLessThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH <=", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthLike(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH like", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthNotLike(String value) {
            addCriterion("MERCH_USER_EMAIL_AUTH not like", value, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthIn(List<String> values) {
            addCriterion("MERCH_USER_EMAIL_AUTH in", values, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthNotIn(List<String> values) {
            addCriterion("MERCH_USER_EMAIL_AUTH not in", values, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthBetween(String value1, String value2) {
            addCriterion("MERCH_USER_EMAIL_AUTH between", value1, value2, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserEmailAuthNotBetween(String value1, String value2) {
            addCriterion("MERCH_USER_EMAIL_AUTH not between", value1, value2, "merchUserEmailAuth");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginIsNull() {
            addCriterion("ALLOW_EMAIL_LOGIN is null");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginIsNotNull() {
            addCriterion("ALLOW_EMAIL_LOGIN is not null");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginEqualTo(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN =", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginNotEqualTo(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN <>", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginGreaterThan(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN >", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginGreaterThanOrEqualTo(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN >=", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginLessThan(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN <", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginLessThanOrEqualTo(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN <=", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginLike(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN like", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginNotLike(String value) {
            addCriterion("ALLOW_EMAIL_LOGIN not like", value, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginIn(List<String> values) {
            addCriterion("ALLOW_EMAIL_LOGIN in", values, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginNotIn(List<String> values) {
            addCriterion("ALLOW_EMAIL_LOGIN not in", values, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginBetween(String value1, String value2) {
            addCriterion("ALLOW_EMAIL_LOGIN between", value1, value2, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andAllowEmailLoginNotBetween(String value1, String value2) {
            addCriterion("ALLOW_EMAIL_LOGIN not between", value1, value2, "allowEmailLogin");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileIsNull() {
            addCriterion("MERCH_USER_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileIsNotNull() {
            addCriterion("MERCH_USER_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE =", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileNotEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE <>", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileGreaterThan(String value) {
            addCriterion("MERCH_USER_MOBILE >", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE >=", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileLessThan(String value) {
            addCriterion("MERCH_USER_MOBILE <", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileLessThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE <=", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileLike(String value) {
            addCriterion("MERCH_USER_MOBILE like", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileNotLike(String value) {
            addCriterion("MERCH_USER_MOBILE not like", value, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileIn(List<String> values) {
            addCriterion("MERCH_USER_MOBILE in", values, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileNotIn(List<String> values) {
            addCriterion("MERCH_USER_MOBILE not in", values, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileBetween(String value1, String value2) {
            addCriterion("MERCH_USER_MOBILE between", value1, value2, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileNotBetween(String value1, String value2) {
            addCriterion("MERCH_USER_MOBILE not between", value1, value2, "merchUserMobile");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthIsNull() {
            addCriterion("MERCH_USER_MOBILE_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthIsNotNull() {
            addCriterion("MERCH_USER_MOBILE_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH =", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthNotEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH <>", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthGreaterThan(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH >", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthGreaterThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH >=", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthLessThan(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH <", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthLessThanOrEqualTo(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH <=", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthLike(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH like", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthNotLike(String value) {
            addCriterion("MERCH_USER_MOBILE_AUTH not like", value, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthIn(List<String> values) {
            addCriterion("MERCH_USER_MOBILE_AUTH in", values, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthNotIn(List<String> values) {
            addCriterion("MERCH_USER_MOBILE_AUTH not in", values, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthBetween(String value1, String value2) {
            addCriterion("MERCH_USER_MOBILE_AUTH between", value1, value2, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andMerchUserMobileAuthNotBetween(String value1, String value2) {
            addCriterion("MERCH_USER_MOBILE_AUTH not between", value1, value2, "merchUserMobileAuth");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginIsNull() {
            addCriterion("ALLOW_MOBILE_LOGIN is null");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginIsNotNull() {
            addCriterion("ALLOW_MOBILE_LOGIN is not null");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginEqualTo(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN =", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginNotEqualTo(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN <>", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginGreaterThan(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN >", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginGreaterThanOrEqualTo(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN >=", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginLessThan(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN <", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginLessThanOrEqualTo(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN <=", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginLike(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN like", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginNotLike(String value) {
            addCriterion("ALLOW_MOBILE_LOGIN not like", value, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginIn(List<String> values) {
            addCriterion("ALLOW_MOBILE_LOGIN in", values, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginNotIn(List<String> values) {
            addCriterion("ALLOW_MOBILE_LOGIN not in", values, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginBetween(String value1, String value2) {
            addCriterion("ALLOW_MOBILE_LOGIN between", value1, value2, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAllowMobileLoginNotBetween(String value1, String value2) {
            addCriterion("ALLOW_MOBILE_LOGIN not between", value1, value2, "allowMobileLogin");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("ACCOUNT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("ACCOUNT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(String value) {
            addCriterion("ACCOUNT_STATUS =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(String value) {
            addCriterion("ACCOUNT_STATUS <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(String value) {
            addCriterion("ACCOUNT_STATUS >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_STATUS >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(String value) {
            addCriterion("ACCOUNT_STATUS <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_STATUS <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLike(String value) {
            addCriterion("ACCOUNT_STATUS like", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotLike(String value) {
            addCriterion("ACCOUNT_STATUS not like", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<String> values) {
            addCriterion("ACCOUNT_STATUS in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<String> values) {
            addCriterion("ACCOUNT_STATUS not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(String value1, String value2) {
            addCriterion("ACCOUNT_STATUS between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_STATUS not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("ROLE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("ROLE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("ROLE_CODE =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("ROLE_CODE <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("ROLE_CODE >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_CODE >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("ROLE_CODE <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_CODE <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("ROLE_CODE like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("ROLE_CODE not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("ROLE_CODE in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("ROLE_CODE not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("ROLE_CODE between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("ROLE_CODE not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginIsNull() {
            addCriterion("IS_FIRST_LOGIN is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginIsNotNull() {
            addCriterion("IS_FIRST_LOGIN is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginEqualTo(String value) {
            addCriterion("IS_FIRST_LOGIN =", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotEqualTo(String value) {
            addCriterion("IS_FIRST_LOGIN <>", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginGreaterThan(String value) {
            addCriterion("IS_FIRST_LOGIN >", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FIRST_LOGIN >=", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginLessThan(String value) {
            addCriterion("IS_FIRST_LOGIN <", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginLessThanOrEqualTo(String value) {
            addCriterion("IS_FIRST_LOGIN <=", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginLike(String value) {
            addCriterion("IS_FIRST_LOGIN like", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotLike(String value) {
            addCriterion("IS_FIRST_LOGIN not like", value, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginIn(List<String> values) {
            addCriterion("IS_FIRST_LOGIN in", values, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotIn(List<String> values) {
            addCriterion("IS_FIRST_LOGIN not in", values, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginBetween(String value1, String value2) {
            addCriterion("IS_FIRST_LOGIN between", value1, value2, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andIsFirstLoginNotBetween(String value1, String value2) {
            addCriterion("IS_FIRST_LOGIN not between", value1, value2, "isFirstLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesIsNull() {
            addCriterion("LAST_FAIL_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesIsNotNull() {
            addCriterion("LAST_FAIL_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesEqualTo(Integer value) {
            addCriterion("LAST_FAIL_TIMES =", value, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesNotEqualTo(Integer value) {
            addCriterion("LAST_FAIL_TIMES <>", value, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesGreaterThan(Integer value) {
            addCriterion("LAST_FAIL_TIMES >", value, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("LAST_FAIL_TIMES >=", value, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesLessThan(Integer value) {
            addCriterion("LAST_FAIL_TIMES <", value, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesLessThanOrEqualTo(Integer value) {
            addCriterion("LAST_FAIL_TIMES <=", value, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesIn(List<Integer> values) {
            addCriterion("LAST_FAIL_TIMES in", values, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesNotIn(List<Integer> values) {
            addCriterion("LAST_FAIL_TIMES not in", values, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesBetween(Integer value1, Integer value2) {
            addCriterion("LAST_FAIL_TIMES between", value1, value2, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andLastFailTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("LAST_FAIL_TIMES not between", value1, value2, "lastFailTimes");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagIsNull() {
            addCriterion("RESET_PWD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagIsNotNull() {
            addCriterion("RESET_PWD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagEqualTo(String value) {
            addCriterion("RESET_PWD_FLAG =", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagNotEqualTo(String value) {
            addCriterion("RESET_PWD_FLAG <>", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagGreaterThan(String value) {
            addCriterion("RESET_PWD_FLAG >", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagGreaterThanOrEqualTo(String value) {
            addCriterion("RESET_PWD_FLAG >=", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagLessThan(String value) {
            addCriterion("RESET_PWD_FLAG <", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagLessThanOrEqualTo(String value) {
            addCriterion("RESET_PWD_FLAG <=", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagLike(String value) {
            addCriterion("RESET_PWD_FLAG like", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagNotLike(String value) {
            addCriterion("RESET_PWD_FLAG not like", value, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagIn(List<String> values) {
            addCriterion("RESET_PWD_FLAG in", values, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagNotIn(List<String> values) {
            addCriterion("RESET_PWD_FLAG not in", values, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagBetween(String value1, String value2) {
            addCriterion("RESET_PWD_FLAG between", value1, value2, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andResetPwdFlagNotBetween(String value1, String value2) {
            addCriterion("RESET_PWD_FLAG not between", value1, value2, "resetPwdFlag");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathIsNull() {
            addCriterion("ID_FRONT_FACE_PIC_PATH is null");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathIsNotNull() {
            addCriterion("ID_FRONT_FACE_PIC_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathEqualTo(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH =", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathNotEqualTo(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH <>", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathGreaterThan(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH >", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathGreaterThanOrEqualTo(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH >=", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathLessThan(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH <", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathLessThanOrEqualTo(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH <=", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathLike(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH like", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathNotLike(String value) {
            addCriterion("ID_FRONT_FACE_PIC_PATH not like", value, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathIn(List<String> values) {
            addCriterion("ID_FRONT_FACE_PIC_PATH in", values, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathNotIn(List<String> values) {
            addCriterion("ID_FRONT_FACE_PIC_PATH not in", values, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathBetween(String value1, String value2) {
            addCriterion("ID_FRONT_FACE_PIC_PATH between", value1, value2, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdFrontFacePicPathNotBetween(String value1, String value2) {
            addCriterion("ID_FRONT_FACE_PIC_PATH not between", value1, value2, "idFrontFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathIsNull() {
            addCriterion("ID_BACK_FACE_PIC_PATH is null");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathIsNotNull() {
            addCriterion("ID_BACK_FACE_PIC_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathEqualTo(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH =", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathNotEqualTo(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH <>", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathGreaterThan(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH >", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathGreaterThanOrEqualTo(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH >=", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathLessThan(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH <", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathLessThanOrEqualTo(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH <=", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathLike(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH like", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathNotLike(String value) {
            addCriterion("ID_BACK_FACE_PIC_PATH not like", value, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathIn(List<String> values) {
            addCriterion("ID_BACK_FACE_PIC_PATH in", values, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathNotIn(List<String> values) {
            addCriterion("ID_BACK_FACE_PIC_PATH not in", values, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathBetween(String value1, String value2) {
            addCriterion("ID_BACK_FACE_PIC_PATH between", value1, value2, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdBackFacePicPathNotBetween(String value1, String value2) {
            addCriterion("ID_BACK_FACE_PIC_PATH not between", value1, value2, "idBackFacePicPath");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagIsNull() {
            addCriterion("ID_AUTH_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagIsNotNull() {
            addCriterion("ID_AUTH_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagEqualTo(String value) {
            addCriterion("ID_AUTH_FLAG =", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagNotEqualTo(String value) {
            addCriterion("ID_AUTH_FLAG <>", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagGreaterThan(String value) {
            addCriterion("ID_AUTH_FLAG >", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ID_AUTH_FLAG >=", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagLessThan(String value) {
            addCriterion("ID_AUTH_FLAG <", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagLessThanOrEqualTo(String value) {
            addCriterion("ID_AUTH_FLAG <=", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagLike(String value) {
            addCriterion("ID_AUTH_FLAG like", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagNotLike(String value) {
            addCriterion("ID_AUTH_FLAG not like", value, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagIn(List<String> values) {
            addCriterion("ID_AUTH_FLAG in", values, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagNotIn(List<String> values) {
            addCriterion("ID_AUTH_FLAG not in", values, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagBetween(String value1, String value2) {
            addCriterion("ID_AUTH_FLAG between", value1, value2, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIdAuthFlagNotBetween(String value1, String value2) {
            addCriterion("ID_AUTH_FLAG not between", value1, value2, "idAuthFlag");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("IS_VIP is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("IS_VIP is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(String value) {
            addCriterion("IS_VIP =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(String value) {
            addCriterion("IS_VIP <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(String value) {
            addCriterion("IS_VIP >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(String value) {
            addCriterion("IS_VIP >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(String value) {
            addCriterion("IS_VIP <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(String value) {
            addCriterion("IS_VIP <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLike(String value) {
            addCriterion("IS_VIP like", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotLike(String value) {
            addCriterion("IS_VIP not like", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<String> values) {
            addCriterion("IS_VIP in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<String> values) {
            addCriterion("IS_VIP not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(String value1, String value2) {
            addCriterion("IS_VIP between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(String value1, String value2) {
            addCriterion("IS_VIP not between", value1, value2, "isVip");
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

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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