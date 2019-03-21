package com.zhurong.db.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbBookInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbBookInfoExample() {
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

        public Criteria andCategoryCodeIsNull() {
            addCriterion("CATEGORY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNotNull() {
            addCriterion("CATEGORY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeEqualTo(String value) {
            addCriterion("CATEGORY_CODE =", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotEqualTo(String value) {
            addCriterion("CATEGORY_CODE <>", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThan(String value) {
            addCriterion("CATEGORY_CODE >", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_CODE >=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThan(String value) {
            addCriterion("CATEGORY_CODE <", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_CODE <=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLike(String value) {
            addCriterion("CATEGORY_CODE like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotLike(String value) {
            addCriterion("CATEGORY_CODE not like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIn(List<String> values) {
            addCriterion("CATEGORY_CODE in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotIn(List<String> values) {
            addCriterion("CATEGORY_CODE not in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeBetween(String value1, String value2) {
            addCriterion("CATEGORY_CODE between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_CODE not between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("BOOK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("BOOK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("BOOK_NAME =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("BOOK_NAME <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("BOOK_NAME >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_NAME >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("BOOK_NAME <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("BOOK_NAME <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("BOOK_NAME like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("BOOK_NAME not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("BOOK_NAME in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("BOOK_NAME not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("BOOK_NAME between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("BOOK_NAME not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andBookWriterIsNull() {
            addCriterion("BOOK_WRITER is null");
            return (Criteria) this;
        }

        public Criteria andBookWriterIsNotNull() {
            addCriterion("BOOK_WRITER is not null");
            return (Criteria) this;
        }

        public Criteria andBookWriterEqualTo(String value) {
            addCriterion("BOOK_WRITER =", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterNotEqualTo(String value) {
            addCriterion("BOOK_WRITER <>", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterGreaterThan(String value) {
            addCriterion("BOOK_WRITER >", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_WRITER >=", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterLessThan(String value) {
            addCriterion("BOOK_WRITER <", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterLessThanOrEqualTo(String value) {
            addCriterion("BOOK_WRITER <=", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterLike(String value) {
            addCriterion("BOOK_WRITER like", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterNotLike(String value) {
            addCriterion("BOOK_WRITER not like", value, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterIn(List<String> values) {
            addCriterion("BOOK_WRITER in", values, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterNotIn(List<String> values) {
            addCriterion("BOOK_WRITER not in", values, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterBetween(String value1, String value2) {
            addCriterion("BOOK_WRITER between", value1, value2, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookWriterNotBetween(String value1, String value2) {
            addCriterion("BOOK_WRITER not between", value1, value2, "bookWriter");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorIsNull() {
            addCriterion("BOOK_TRANSLATOR is null");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorIsNotNull() {
            addCriterion("BOOK_TRANSLATOR is not null");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorEqualTo(String value) {
            addCriterion("BOOK_TRANSLATOR =", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorNotEqualTo(String value) {
            addCriterion("BOOK_TRANSLATOR <>", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorGreaterThan(String value) {
            addCriterion("BOOK_TRANSLATOR >", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_TRANSLATOR >=", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorLessThan(String value) {
            addCriterion("BOOK_TRANSLATOR <", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorLessThanOrEqualTo(String value) {
            addCriterion("BOOK_TRANSLATOR <=", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorLike(String value) {
            addCriterion("BOOK_TRANSLATOR like", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorNotLike(String value) {
            addCriterion("BOOK_TRANSLATOR not like", value, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorIn(List<String> values) {
            addCriterion("BOOK_TRANSLATOR in", values, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorNotIn(List<String> values) {
            addCriterion("BOOK_TRANSLATOR not in", values, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorBetween(String value1, String value2) {
            addCriterion("BOOK_TRANSLATOR between", value1, value2, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookTranslatorNotBetween(String value1, String value2) {
            addCriterion("BOOK_TRANSLATOR not between", value1, value2, "bookTranslator");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNull() {
            addCriterion("BOOK_PRESS is null");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNotNull() {
            addCriterion("BOOK_PRESS is not null");
            return (Criteria) this;
        }

        public Criteria andBookPressEqualTo(String value) {
            addCriterion("BOOK_PRESS =", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotEqualTo(String value) {
            addCriterion("BOOK_PRESS <>", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThan(String value) {
            addCriterion("BOOK_PRESS >", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_PRESS >=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThan(String value) {
            addCriterion("BOOK_PRESS <", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThanOrEqualTo(String value) {
            addCriterion("BOOK_PRESS <=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLike(String value) {
            addCriterion("BOOK_PRESS like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotLike(String value) {
            addCriterion("BOOK_PRESS not like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressIn(List<String> values) {
            addCriterion("BOOK_PRESS in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotIn(List<String> values) {
            addCriterion("BOOK_PRESS not in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressBetween(String value1, String value2) {
            addCriterion("BOOK_PRESS between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotBetween(String value1, String value2) {
            addCriterion("BOOK_PRESS not between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNull() {
            addCriterion("BOOK_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNotNull() {
            addCriterion("BOOK_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBookPriceEqualTo(Float value) {
            addCriterion("BOOK_PRICE =", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotEqualTo(Float value) {
            addCriterion("BOOK_PRICE <>", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThan(Float value) {
            addCriterion("BOOK_PRICE >", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("BOOK_PRICE >=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThan(Float value) {
            addCriterion("BOOK_PRICE <", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThanOrEqualTo(Float value) {
            addCriterion("BOOK_PRICE <=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceIn(List<Float> values) {
            addCriterion("BOOK_PRICE in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotIn(List<Float> values) {
            addCriterion("BOOK_PRICE not in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceBetween(Float value1, Float value2) {
            addCriterion("BOOK_PRICE between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotBetween(Float value1, Float value2) {
            addCriterion("BOOK_PRICE not between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("PUBLISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("PUBLISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterionForJDBCDate("PUBLISH_DATE in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PUBLISH_DATE not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUBLISH_DATE between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUBLISH_DATE not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathIsNull() {
            addCriterion("COVER_PIC_PATH is null");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathIsNotNull() {
            addCriterion("COVER_PIC_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathEqualTo(String value) {
            addCriterion("COVER_PIC_PATH =", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathNotEqualTo(String value) {
            addCriterion("COVER_PIC_PATH <>", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathGreaterThan(String value) {
            addCriterion("COVER_PIC_PATH >", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("COVER_PIC_PATH >=", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathLessThan(String value) {
            addCriterion("COVER_PIC_PATH <", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathLessThanOrEqualTo(String value) {
            addCriterion("COVER_PIC_PATH <=", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathLike(String value) {
            addCriterion("COVER_PIC_PATH like", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathNotLike(String value) {
            addCriterion("COVER_PIC_PATH not like", value, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathIn(List<String> values) {
            addCriterion("COVER_PIC_PATH in", values, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathNotIn(List<String> values) {
            addCriterion("COVER_PIC_PATH not in", values, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathBetween(String value1, String value2) {
            addCriterion("COVER_PIC_PATH between", value1, value2, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicPathNotBetween(String value1, String value2) {
            addCriterion("COVER_PIC_PATH not between", value1, value2, "coverPicPath");
            return (Criteria) this;
        }

        public Criteria andContentBriefIsNull() {
            addCriterion("CONTENT_BRIEF is null");
            return (Criteria) this;
        }

        public Criteria andContentBriefIsNotNull() {
            addCriterion("CONTENT_BRIEF is not null");
            return (Criteria) this;
        }

        public Criteria andContentBriefEqualTo(String value) {
            addCriterion("CONTENT_BRIEF =", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefNotEqualTo(String value) {
            addCriterion("CONTENT_BRIEF <>", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefGreaterThan(String value) {
            addCriterion("CONTENT_BRIEF >", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT_BRIEF >=", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefLessThan(String value) {
            addCriterion("CONTENT_BRIEF <", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefLessThanOrEqualTo(String value) {
            addCriterion("CONTENT_BRIEF <=", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefLike(String value) {
            addCriterion("CONTENT_BRIEF like", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefNotLike(String value) {
            addCriterion("CONTENT_BRIEF not like", value, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefIn(List<String> values) {
            addCriterion("CONTENT_BRIEF in", values, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefNotIn(List<String> values) {
            addCriterion("CONTENT_BRIEF not in", values, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefBetween(String value1, String value2) {
            addCriterion("CONTENT_BRIEF between", value1, value2, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andContentBriefNotBetween(String value1, String value2) {
            addCriterion("CONTENT_BRIEF not between", value1, value2, "contentBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefIsNull() {
            addCriterion("WRITER_BRIEF is null");
            return (Criteria) this;
        }

        public Criteria andWriterBriefIsNotNull() {
            addCriterion("WRITER_BRIEF is not null");
            return (Criteria) this;
        }

        public Criteria andWriterBriefEqualTo(String value) {
            addCriterion("WRITER_BRIEF =", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefNotEqualTo(String value) {
            addCriterion("WRITER_BRIEF <>", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefGreaterThan(String value) {
            addCriterion("WRITER_BRIEF >", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefGreaterThanOrEqualTo(String value) {
            addCriterion("WRITER_BRIEF >=", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefLessThan(String value) {
            addCriterion("WRITER_BRIEF <", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefLessThanOrEqualTo(String value) {
            addCriterion("WRITER_BRIEF <=", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefLike(String value) {
            addCriterion("WRITER_BRIEF like", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefNotLike(String value) {
            addCriterion("WRITER_BRIEF not like", value, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefIn(List<String> values) {
            addCriterion("WRITER_BRIEF in", values, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefNotIn(List<String> values) {
            addCriterion("WRITER_BRIEF not in", values, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefBetween(String value1, String value2) {
            addCriterion("WRITER_BRIEF between", value1, value2, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andWriterBriefNotBetween(String value1, String value2) {
            addCriterion("WRITER_BRIEF not between", value1, value2, "writerBrief");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIsNull() {
            addCriterion("BOOK_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIsNotNull() {
            addCriterion("BOOK_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andBookCatalogEqualTo(String value) {
            addCriterion("BOOK_CATALOG =", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogNotEqualTo(String value) {
            addCriterion("BOOK_CATALOG <>", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogGreaterThan(String value) {
            addCriterion("BOOK_CATALOG >", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_CATALOG >=", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogLessThan(String value) {
            addCriterion("BOOK_CATALOG <", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogLessThanOrEqualTo(String value) {
            addCriterion("BOOK_CATALOG <=", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogLike(String value) {
            addCriterion("BOOK_CATALOG like", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogNotLike(String value) {
            addCriterion("BOOK_CATALOG not like", value, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIn(List<String> values) {
            addCriterion("BOOK_CATALOG in", values, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogNotIn(List<String> values) {
            addCriterion("BOOK_CATALOG not in", values, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogBetween(String value1, String value2) {
            addCriterion("BOOK_CATALOG between", value1, value2, "bookCatalog");
            return (Criteria) this;
        }

        public Criteria andBookCatalogNotBetween(String value1, String value2) {
            addCriterion("BOOK_CATALOG not between", value1, value2, "bookCatalog");
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