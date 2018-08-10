package com.apin.qunar.statistics.dao.model;

import java.util.ArrayList;
import java.util.List;

public class DayStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public DayStatisticsExample() {
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

        public Criteria andTotalPvIsNull() {
            addCriterion("total_pv is null");
            return (Criteria) this;
        }

        public Criteria andTotalPvIsNotNull() {
            addCriterion("total_pv is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPvEqualTo(Integer value) {
            addCriterion("total_pv =", value, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvNotEqualTo(Integer value) {
            addCriterion("total_pv <>", value, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvGreaterThan(Integer value) {
            addCriterion("total_pv >", value, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_pv >=", value, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvLessThan(Integer value) {
            addCriterion("total_pv <", value, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvLessThanOrEqualTo(Integer value) {
            addCriterion("total_pv <=", value, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvIn(List<Integer> values) {
            addCriterion("total_pv in", values, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvNotIn(List<Integer> values) {
            addCriterion("total_pv not in", values, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvBetween(Integer value1, Integer value2) {
            addCriterion("total_pv between", value1, value2, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalPvNotBetween(Integer value1, Integer value2) {
            addCriterion("total_pv not between", value1, value2, "totalPv");
            return (Criteria) this;
        }

        public Criteria andTotalUvIsNull() {
            addCriterion("total_uv is null");
            return (Criteria) this;
        }

        public Criteria andTotalUvIsNotNull() {
            addCriterion("total_uv is not null");
            return (Criteria) this;
        }

        public Criteria andTotalUvEqualTo(Integer value) {
            addCriterion("total_uv =", value, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvNotEqualTo(Integer value) {
            addCriterion("total_uv <>", value, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvGreaterThan(Integer value) {
            addCriterion("total_uv >", value, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_uv >=", value, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvLessThan(Integer value) {
            addCriterion("total_uv <", value, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvLessThanOrEqualTo(Integer value) {
            addCriterion("total_uv <=", value, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvIn(List<Integer> values) {
            addCriterion("total_uv in", values, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvNotIn(List<Integer> values) {
            addCriterion("total_uv not in", values, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvBetween(Integer value1, Integer value2) {
            addCriterion("total_uv between", value1, value2, "totalUv");
            return (Criteria) this;
        }

        public Criteria andTotalUvNotBetween(Integer value1, Integer value2) {
            addCriterion("total_uv not between", value1, value2, "totalUv");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntIsNull() {
            addCriterion("search_national_flight_cnt is null");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntIsNotNull() {
            addCriterion("search_national_flight_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntEqualTo(Integer value) {
            addCriterion("search_national_flight_cnt =", value, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntNotEqualTo(Integer value) {
            addCriterion("search_national_flight_cnt <>", value, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntGreaterThan(Integer value) {
            addCriterion("search_national_flight_cnt >", value, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_national_flight_cnt >=", value, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntLessThan(Integer value) {
            addCriterion("search_national_flight_cnt <", value, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntLessThanOrEqualTo(Integer value) {
            addCriterion("search_national_flight_cnt <=", value, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntIn(List<Integer> values) {
            addCriterion("search_national_flight_cnt in", values, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntNotIn(List<Integer> values) {
            addCriterion("search_national_flight_cnt not in", values, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntBetween(Integer value1, Integer value2) {
            addCriterion("search_national_flight_cnt between", value1, value2, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchNationalFlightCntNotBetween(Integer value1, Integer value2) {
            addCriterion("search_national_flight_cnt not between", value1, value2, "searchNationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntIsNull() {
            addCriterion("search_international_flight_cnt is null");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntIsNotNull() {
            addCriterion("search_international_flight_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntEqualTo(Integer value) {
            addCriterion("search_international_flight_cnt =", value, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntNotEqualTo(Integer value) {
            addCriterion("search_international_flight_cnt <>", value, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntGreaterThan(Integer value) {
            addCriterion("search_international_flight_cnt >", value, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_international_flight_cnt >=", value, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntLessThan(Integer value) {
            addCriterion("search_international_flight_cnt <", value, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntLessThanOrEqualTo(Integer value) {
            addCriterion("search_international_flight_cnt <=", value, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntIn(List<Integer> values) {
            addCriterion("search_international_flight_cnt in", values, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntNotIn(List<Integer> values) {
            addCriterion("search_international_flight_cnt not in", values, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntBetween(Integer value1, Integer value2) {
            addCriterion("search_international_flight_cnt between", value1, value2, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andSearchInternationalFlightCntNotBetween(Integer value1, Integer value2) {
            addCriterion("search_international_flight_cnt not between", value1, value2, "searchInternationalFlightCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntIsNull() {
            addCriterion("deal_order_cnt is null");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntIsNotNull() {
            addCriterion("deal_order_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntEqualTo(Integer value) {
            addCriterion("deal_order_cnt =", value, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntNotEqualTo(Integer value) {
            addCriterion("deal_order_cnt <>", value, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntGreaterThan(Integer value) {
            addCriterion("deal_order_cnt >", value, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_order_cnt >=", value, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntLessThan(Integer value) {
            addCriterion("deal_order_cnt <", value, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntLessThanOrEqualTo(Integer value) {
            addCriterion("deal_order_cnt <=", value, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntIn(List<Integer> values) {
            addCriterion("deal_order_cnt in", values, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntNotIn(List<Integer> values) {
            addCriterion("deal_order_cnt not in", values, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntBetween(Integer value1, Integer value2) {
            addCriterion("deal_order_cnt between", value1, value2, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealOrderCntNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_order_cnt not between", value1, value2, "dealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountIsNull() {
            addCriterion("deal_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountIsNotNull() {
            addCriterion("deal_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountEqualTo(Integer value) {
            addCriterion("deal_total_amount =", value, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountNotEqualTo(Integer value) {
            addCriterion("deal_total_amount <>", value, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountGreaterThan(Integer value) {
            addCriterion("deal_total_amount >", value, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_total_amount >=", value, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountLessThan(Integer value) {
            addCriterion("deal_total_amount <", value, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("deal_total_amount <=", value, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountIn(List<Integer> values) {
            addCriterion("deal_total_amount in", values, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountNotIn(List<Integer> values) {
            addCriterion("deal_total_amount not in", values, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("deal_total_amount between", value1, value2, "dealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andDealTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_total_amount not between", value1, value2, "dealTotalAmount");
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