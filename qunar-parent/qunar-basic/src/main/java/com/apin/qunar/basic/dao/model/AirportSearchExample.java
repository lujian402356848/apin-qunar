package com.apin.qunar.basic.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirportSearchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public AirportSearchExample() {
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

    /**
     * @param mysqlOffset 指定返回记录行的偏移量<br> mysqlOffset= 5,mysqlLength=10;  // 检索记录行 6-15
     */
    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset = mysqlOffset;
    }

    public Integer getMysqlOffset() {
        return mysqlOffset;
    }

    /**
     * @param mysqlLength 指定返回记录行的最大数目<br> mysqlOffset= 5,mysqlLength=10;  // 检索记录行 6-15
     */
    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }

    public Integer getMysqlLength() {
        return mysqlLength;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAirportCodeIsNull() {
            addCriterion("airport_code is null");
            return (Criteria) this;
        }

        public Criteria andAirportCodeIsNotNull() {
            addCriterion("airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andAirportCodeEqualTo(String value) {
            addCriterion("airport_code =", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeNotEqualTo(String value) {
            addCriterion("airport_code <>", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeGreaterThan(String value) {
            addCriterion("airport_code >", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("airport_code >=", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeLessThan(String value) {
            addCriterion("airport_code <", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("airport_code <=", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeLike(String value) {
            addCriterion("airport_code like", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeNotLike(String value) {
            addCriterion("airport_code not like", value, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeIn(List<String> values) {
            addCriterion("airport_code in", values, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeNotIn(List<String> values) {
            addCriterion("airport_code not in", values, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeBetween(String value1, String value2) {
            addCriterion("airport_code between", value1, value2, "airportCode");
            return (Criteria) this;
        }

        public Criteria andAirportCodeNotBetween(String value1, String value2) {
            addCriterion("airport_code not between", value1, value2, "airportCode");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordIsNull() {
            addCriterion("search_keyword is null");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordIsNotNull() {
            addCriterion("search_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordEqualTo(String value) {
            addCriterion("search_keyword =", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotEqualTo(String value) {
            addCriterion("search_keyword <>", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordGreaterThan(String value) {
            addCriterion("search_keyword >", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("search_keyword >=", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLessThan(String value) {
            addCriterion("search_keyword <", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLessThanOrEqualTo(String value) {
            addCriterion("search_keyword <=", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLike(String value) {
            addCriterion("search_keyword like", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotLike(String value) {
            addCriterion("search_keyword not like", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordIn(List<String> values) {
            addCriterion("search_keyword in", values, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotIn(List<String> values) {
            addCriterion("search_keyword not in", values, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordBetween(String value1, String value2) {
            addCriterion("search_keyword between", value1, value2, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotBetween(String value1, String value2) {
            addCriterion("search_keyword not between", value1, value2, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andAirportCodeLikeInsensitive(String value) {
            addCriterion("upper(airport_code) like", value.toUpperCase(), "airportCode");
            return this;
        }

        public Criteria andSearchKeywordLikeInsensitive(String value) {
            addCriterion("upper(search_keyword) like", value.toUpperCase(), "searchKeyword");
            return this;
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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}