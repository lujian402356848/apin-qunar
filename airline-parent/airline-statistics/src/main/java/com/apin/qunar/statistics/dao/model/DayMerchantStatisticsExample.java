package com.apin.qunar.statistics.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DayMerchantStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public DayMerchantStatisticsExample() {
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntIsNull() {
            addCriterion("national_search_flight_cnt is null");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntIsNotNull() {
            addCriterion("national_search_flight_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntEqualTo(Integer value) {
            addCriterion("national_search_flight_cnt =", value, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntNotEqualTo(Integer value) {
            addCriterion("national_search_flight_cnt <>", value, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntGreaterThan(Integer value) {
            addCriterion("national_search_flight_cnt >", value, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("national_search_flight_cnt >=", value, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntLessThan(Integer value) {
            addCriterion("national_search_flight_cnt <", value, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntLessThanOrEqualTo(Integer value) {
            addCriterion("national_search_flight_cnt <=", value, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntIn(List<Integer> values) {
            addCriterion("national_search_flight_cnt in", values, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntNotIn(List<Integer> values) {
            addCriterion("national_search_flight_cnt not in", values, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntBetween(Integer value1, Integer value2) {
            addCriterion("national_search_flight_cnt between", value1, value2, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalSearchFlightCntNotBetween(Integer value1, Integer value2) {
            addCriterion("national_search_flight_cnt not between", value1, value2, "nationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntIsNull() {
            addCriterion("international_search_flight_cnt is null");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntIsNotNull() {
            addCriterion("international_search_flight_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntEqualTo(Integer value) {
            addCriterion("international_search_flight_cnt =", value, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntNotEqualTo(Integer value) {
            addCriterion("international_search_flight_cnt <>", value, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntGreaterThan(Integer value) {
            addCriterion("international_search_flight_cnt >", value, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("international_search_flight_cnt >=", value, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntLessThan(Integer value) {
            addCriterion("international_search_flight_cnt <", value, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntLessThanOrEqualTo(Integer value) {
            addCriterion("international_search_flight_cnt <=", value, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntIn(List<Integer> values) {
            addCriterion("international_search_flight_cnt in", values, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntNotIn(List<Integer> values) {
            addCriterion("international_search_flight_cnt not in", values, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntBetween(Integer value1, Integer value2) {
            addCriterion("international_search_flight_cnt between", value1, value2, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalSearchFlightCntNotBetween(Integer value1, Integer value2) {
            addCriterion("international_search_flight_cnt not between", value1, value2, "internationalSearchFlightCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntIsNull() {
            addCriterion("national_deal_order_cnt is null");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntIsNotNull() {
            addCriterion("national_deal_order_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntEqualTo(Integer value) {
            addCriterion("national_deal_order_cnt =", value, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntNotEqualTo(Integer value) {
            addCriterion("national_deal_order_cnt <>", value, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntGreaterThan(Integer value) {
            addCriterion("national_deal_order_cnt >", value, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("national_deal_order_cnt >=", value, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntLessThan(Integer value) {
            addCriterion("national_deal_order_cnt <", value, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntLessThanOrEqualTo(Integer value) {
            addCriterion("national_deal_order_cnt <=", value, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntIn(List<Integer> values) {
            addCriterion("national_deal_order_cnt in", values, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntNotIn(List<Integer> values) {
            addCriterion("national_deal_order_cnt not in", values, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntBetween(Integer value1, Integer value2) {
            addCriterion("national_deal_order_cnt between", value1, value2, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealOrderCntNotBetween(Integer value1, Integer value2) {
            addCriterion("national_deal_order_cnt not between", value1, value2, "nationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntIsNull() {
            addCriterion("international_deal_order_cnt is null");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntIsNotNull() {
            addCriterion("international_deal_order_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntEqualTo(Integer value) {
            addCriterion("international_deal_order_cnt =", value, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntNotEqualTo(Integer value) {
            addCriterion("international_deal_order_cnt <>", value, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntGreaterThan(Integer value) {
            addCriterion("international_deal_order_cnt >", value, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("international_deal_order_cnt >=", value, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntLessThan(Integer value) {
            addCriterion("international_deal_order_cnt <", value, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntLessThanOrEqualTo(Integer value) {
            addCriterion("international_deal_order_cnt <=", value, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntIn(List<Integer> values) {
            addCriterion("international_deal_order_cnt in", values, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntNotIn(List<Integer> values) {
            addCriterion("international_deal_order_cnt not in", values, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntBetween(Integer value1, Integer value2) {
            addCriterion("international_deal_order_cnt between", value1, value2, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andInternationalDealOrderCntNotBetween(Integer value1, Integer value2) {
            addCriterion("international_deal_order_cnt not between", value1, value2, "internationalDealOrderCnt");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountIsNull() {
            addCriterion("national_deal_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountIsNotNull() {
            addCriterion("national_deal_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountEqualTo(Integer value) {
            addCriterion("national_deal_total_amount =", value, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountNotEqualTo(Integer value) {
            addCriterion("national_deal_total_amount <>", value, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountGreaterThan(Integer value) {
            addCriterion("national_deal_total_amount >", value, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("national_deal_total_amount >=", value, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountLessThan(Integer value) {
            addCriterion("national_deal_total_amount <", value, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("national_deal_total_amount <=", value, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountIn(List<Integer> values) {
            addCriterion("national_deal_total_amount in", values, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountNotIn(List<Integer> values) {
            addCriterion("national_deal_total_amount not in", values, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("national_deal_total_amount between", value1, value2, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andNationalDealTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("national_deal_total_amount not between", value1, value2, "nationalDealTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountIsNull() {
            addCriterion("international_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountIsNotNull() {
            addCriterion("international_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountEqualTo(Integer value) {
            addCriterion("international_total_amount =", value, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountNotEqualTo(Integer value) {
            addCriterion("international_total_amount <>", value, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountGreaterThan(Integer value) {
            addCriterion("international_total_amount >", value, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("international_total_amount >=", value, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountLessThan(Integer value) {
            addCriterion("international_total_amount <", value, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("international_total_amount <=", value, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountIn(List<Integer> values) {
            addCriterion("international_total_amount in", values, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountNotIn(List<Integer> values) {
            addCriterion("international_total_amount not in", values, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("international_total_amount between", value1, value2, "internationalTotalAmount");
            return (Criteria) this;
        }

        public Criteria andInternationalTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("international_total_amount not between", value1, value2, "internationalTotalAmount");
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

        public Criteria andAccountLikeInsensitive(String value) {
            addCriterion("upper(account) like", value.toUpperCase(), "account");
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