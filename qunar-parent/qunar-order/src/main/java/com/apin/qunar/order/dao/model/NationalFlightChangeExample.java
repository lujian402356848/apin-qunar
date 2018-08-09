package com.apin.qunar.order.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NationalFlightChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public NationalFlightChangeExample() {
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

        public Criteria andMerchantNoIsNull() {
            addCriterion("merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("merchant_no =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("merchant_no <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("merchant_no >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_no >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("merchant_no <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_no <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("merchant_no like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("merchant_no not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("merchant_no in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("merchant_no not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("merchant_no between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("merchant_no not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoIsNull() {
            addCriterion("flight_no is null");
            return (Criteria) this;
        }

        public Criteria andFlightNoIsNotNull() {
            addCriterion("flight_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlightNoEqualTo(String value) {
            addCriterion("flight_no =", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotEqualTo(String value) {
            addCriterion("flight_no <>", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoGreaterThan(String value) {
            addCriterion("flight_no >", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoGreaterThanOrEqualTo(String value) {
            addCriterion("flight_no >=", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoLessThan(String value) {
            addCriterion("flight_no <", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoLessThanOrEqualTo(String value) {
            addCriterion("flight_no <=", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoLike(String value) {
            addCriterion("flight_no like", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotLike(String value) {
            addCriterion("flight_no not like", value, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoIn(List<String> values) {
            addCriterion("flight_no in", values, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotIn(List<String> values) {
            addCriterion("flight_no not in", values, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoBetween(String value1, String value2) {
            addCriterion("flight_no between", value1, value2, "flightNo");
            return (Criteria) this;
        }

        public Criteria andFlightNoNotBetween(String value1, String value2) {
            addCriterion("flight_no not between", value1, value2, "flightNo");
            return (Criteria) this;
        }

        public Criteria andDptDateIsNull() {
            addCriterion("dpt_date is null");
            return (Criteria) this;
        }

        public Criteria andDptDateIsNotNull() {
            addCriterion("dpt_date is not null");
            return (Criteria) this;
        }

        public Criteria andDptDateEqualTo(String value) {
            addCriterion("dpt_date =", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateNotEqualTo(String value) {
            addCriterion("dpt_date <>", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateGreaterThan(String value) {
            addCriterion("dpt_date >", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateGreaterThanOrEqualTo(String value) {
            addCriterion("dpt_date >=", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateLessThan(String value) {
            addCriterion("dpt_date <", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateLessThanOrEqualTo(String value) {
            addCriterion("dpt_date <=", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateLike(String value) {
            addCriterion("dpt_date like", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateNotLike(String value) {
            addCriterion("dpt_date not like", value, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateIn(List<String> values) {
            addCriterion("dpt_date in", values, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateNotIn(List<String> values) {
            addCriterion("dpt_date not in", values, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateBetween(String value1, String value2) {
            addCriterion("dpt_date between", value1, value2, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptDateNotBetween(String value1, String value2) {
            addCriterion("dpt_date not between", value1, value2, "dptDate");
            return (Criteria) this;
        }

        public Criteria andDptTimeIsNull() {
            addCriterion("dpt_time is null");
            return (Criteria) this;
        }

        public Criteria andDptTimeIsNotNull() {
            addCriterion("dpt_time is not null");
            return (Criteria) this;
        }

        public Criteria andDptTimeEqualTo(String value) {
            addCriterion("dpt_time =", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeNotEqualTo(String value) {
            addCriterion("dpt_time <>", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeGreaterThan(String value) {
            addCriterion("dpt_time >", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("dpt_time >=", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeLessThan(String value) {
            addCriterion("dpt_time <", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeLessThanOrEqualTo(String value) {
            addCriterion("dpt_time <=", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeLike(String value) {
            addCriterion("dpt_time like", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeNotLike(String value) {
            addCriterion("dpt_time not like", value, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeIn(List<String> values) {
            addCriterion("dpt_time in", values, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeNotIn(List<String> values) {
            addCriterion("dpt_time not in", values, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeBetween(String value1, String value2) {
            addCriterion("dpt_time between", value1, value2, "dptTime");
            return (Criteria) this;
        }

        public Criteria andDptTimeNotBetween(String value1, String value2) {
            addCriterion("dpt_time not between", value1, value2, "dptTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeIsNull() {
            addCriterion("arr_time is null");
            return (Criteria) this;
        }

        public Criteria andArrTimeIsNotNull() {
            addCriterion("arr_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrTimeEqualTo(String value) {
            addCriterion("arr_time =", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotEqualTo(String value) {
            addCriterion("arr_time <>", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeGreaterThan(String value) {
            addCriterion("arr_time >", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeGreaterThanOrEqualTo(String value) {
            addCriterion("arr_time >=", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLessThan(String value) {
            addCriterion("arr_time <", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLessThanOrEqualTo(String value) {
            addCriterion("arr_time <=", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLike(String value) {
            addCriterion("arr_time like", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotLike(String value) {
            addCriterion("arr_time not like", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeIn(List<String> values) {
            addCriterion("arr_time in", values, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotIn(List<String> values) {
            addCriterion("arr_time not in", values, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeBetween(String value1, String value2) {
            addCriterion("arr_time between", value1, value2, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotBetween(String value1, String value2) {
            addCriterion("arr_time not between", value1, value2, "arrTime");
            return (Criteria) this;
        }

        public Criteria andDptAirportIsNull() {
            addCriterion("dpt_airport is null");
            return (Criteria) this;
        }

        public Criteria andDptAirportIsNotNull() {
            addCriterion("dpt_airport is not null");
            return (Criteria) this;
        }

        public Criteria andDptAirportEqualTo(String value) {
            addCriterion("dpt_airport =", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportNotEqualTo(String value) {
            addCriterion("dpt_airport <>", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportGreaterThan(String value) {
            addCriterion("dpt_airport >", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportGreaterThanOrEqualTo(String value) {
            addCriterion("dpt_airport >=", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportLessThan(String value) {
            addCriterion("dpt_airport <", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportLessThanOrEqualTo(String value) {
            addCriterion("dpt_airport <=", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportLike(String value) {
            addCriterion("dpt_airport like", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportNotLike(String value) {
            addCriterion("dpt_airport not like", value, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportIn(List<String> values) {
            addCriterion("dpt_airport in", values, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportNotIn(List<String> values) {
            addCriterion("dpt_airport not in", values, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportBetween(String value1, String value2) {
            addCriterion("dpt_airport between", value1, value2, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andDptAirportNotBetween(String value1, String value2) {
            addCriterion("dpt_airport not between", value1, value2, "dptAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportIsNull() {
            addCriterion("arr_airport is null");
            return (Criteria) this;
        }

        public Criteria andArrAirportIsNotNull() {
            addCriterion("arr_airport is not null");
            return (Criteria) this;
        }

        public Criteria andArrAirportEqualTo(String value) {
            addCriterion("arr_airport =", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotEqualTo(String value) {
            addCriterion("arr_airport <>", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportGreaterThan(String value) {
            addCriterion("arr_airport >", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportGreaterThanOrEqualTo(String value) {
            addCriterion("arr_airport >=", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportLessThan(String value) {
            addCriterion("arr_airport <", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportLessThanOrEqualTo(String value) {
            addCriterion("arr_airport <=", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportLike(String value) {
            addCriterion("arr_airport like", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotLike(String value) {
            addCriterion("arr_airport not like", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportIn(List<String> values) {
            addCriterion("arr_airport in", values, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotIn(List<String> values) {
            addCriterion("arr_airport not in", values, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportBetween(String value1, String value2) {
            addCriterion("arr_airport between", value1, value2, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotBetween(String value1, String value2) {
            addCriterion("arr_airport not between", value1, value2, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoIsNull() {
            addCriterion("fol_flight_no is null");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoIsNotNull() {
            addCriterion("fol_flight_no is not null");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoEqualTo(String value) {
            addCriterion("fol_flight_no =", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoNotEqualTo(String value) {
            addCriterion("fol_flight_no <>", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoGreaterThan(String value) {
            addCriterion("fol_flight_no >", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoGreaterThanOrEqualTo(String value) {
            addCriterion("fol_flight_no >=", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoLessThan(String value) {
            addCriterion("fol_flight_no <", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoLessThanOrEqualTo(String value) {
            addCriterion("fol_flight_no <=", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoLike(String value) {
            addCriterion("fol_flight_no like", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoNotLike(String value) {
            addCriterion("fol_flight_no not like", value, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoIn(List<String> values) {
            addCriterion("fol_flight_no in", values, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoNotIn(List<String> values) {
            addCriterion("fol_flight_no not in", values, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoBetween(String value1, String value2) {
            addCriterion("fol_flight_no between", value1, value2, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolFlightNoNotBetween(String value1, String value2) {
            addCriterion("fol_flight_no not between", value1, value2, "folFlightNo");
            return (Criteria) this;
        }

        public Criteria andFolDptDateIsNull() {
            addCriterion("fol_dpt_date is null");
            return (Criteria) this;
        }

        public Criteria andFolDptDateIsNotNull() {
            addCriterion("fol_dpt_date is not null");
            return (Criteria) this;
        }

        public Criteria andFolDptDateEqualTo(String value) {
            addCriterion("fol_dpt_date =", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateNotEqualTo(String value) {
            addCriterion("fol_dpt_date <>", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateGreaterThan(String value) {
            addCriterion("fol_dpt_date >", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateGreaterThanOrEqualTo(String value) {
            addCriterion("fol_dpt_date >=", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateLessThan(String value) {
            addCriterion("fol_dpt_date <", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateLessThanOrEqualTo(String value) {
            addCriterion("fol_dpt_date <=", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateLike(String value) {
            addCriterion("fol_dpt_date like", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateNotLike(String value) {
            addCriterion("fol_dpt_date not like", value, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateIn(List<String> values) {
            addCriterion("fol_dpt_date in", values, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateNotIn(List<String> values) {
            addCriterion("fol_dpt_date not in", values, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateBetween(String value1, String value2) {
            addCriterion("fol_dpt_date between", value1, value2, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptDateNotBetween(String value1, String value2) {
            addCriterion("fol_dpt_date not between", value1, value2, "folDptDate");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeIsNull() {
            addCriterion("fol_dpt_time is null");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeIsNotNull() {
            addCriterion("fol_dpt_time is not null");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeEqualTo(String value) {
            addCriterion("fol_dpt_time =", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeNotEqualTo(String value) {
            addCriterion("fol_dpt_time <>", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeGreaterThan(String value) {
            addCriterion("fol_dpt_time >", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("fol_dpt_time >=", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeLessThan(String value) {
            addCriterion("fol_dpt_time <", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeLessThanOrEqualTo(String value) {
            addCriterion("fol_dpt_time <=", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeLike(String value) {
            addCriterion("fol_dpt_time like", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeNotLike(String value) {
            addCriterion("fol_dpt_time not like", value, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeIn(List<String> values) {
            addCriterion("fol_dpt_time in", values, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeNotIn(List<String> values) {
            addCriterion("fol_dpt_time not in", values, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeBetween(String value1, String value2) {
            addCriterion("fol_dpt_time between", value1, value2, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolDptTimeNotBetween(String value1, String value2) {
            addCriterion("fol_dpt_time not between", value1, value2, "folDptTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeIsNull() {
            addCriterion("fol_arr_time is null");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeIsNotNull() {
            addCriterion("fol_arr_time is not null");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeEqualTo(String value) {
            addCriterion("fol_arr_time =", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeNotEqualTo(String value) {
            addCriterion("fol_arr_time <>", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeGreaterThan(String value) {
            addCriterion("fol_arr_time >", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeGreaterThanOrEqualTo(String value) {
            addCriterion("fol_arr_time >=", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeLessThan(String value) {
            addCriterion("fol_arr_time <", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeLessThanOrEqualTo(String value) {
            addCriterion("fol_arr_time <=", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeLike(String value) {
            addCriterion("fol_arr_time like", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeNotLike(String value) {
            addCriterion("fol_arr_time not like", value, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeIn(List<String> values) {
            addCriterion("fol_arr_time in", values, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeNotIn(List<String> values) {
            addCriterion("fol_arr_time not in", values, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeBetween(String value1, String value2) {
            addCriterion("fol_arr_time between", value1, value2, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolArrTimeNotBetween(String value1, String value2) {
            addCriterion("fol_arr_time not between", value1, value2, "folArrTime");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportIsNull() {
            addCriterion("fol_dpt_airport is null");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportIsNotNull() {
            addCriterion("fol_dpt_airport is not null");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportEqualTo(String value) {
            addCriterion("fol_dpt_airport =", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportNotEqualTo(String value) {
            addCriterion("fol_dpt_airport <>", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportGreaterThan(String value) {
            addCriterion("fol_dpt_airport >", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportGreaterThanOrEqualTo(String value) {
            addCriterion("fol_dpt_airport >=", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportLessThan(String value) {
            addCriterion("fol_dpt_airport <", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportLessThanOrEqualTo(String value) {
            addCriterion("fol_dpt_airport <=", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportLike(String value) {
            addCriterion("fol_dpt_airport like", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportNotLike(String value) {
            addCriterion("fol_dpt_airport not like", value, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportIn(List<String> values) {
            addCriterion("fol_dpt_airport in", values, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportNotIn(List<String> values) {
            addCriterion("fol_dpt_airport not in", values, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportBetween(String value1, String value2) {
            addCriterion("fol_dpt_airport between", value1, value2, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolDptAirportNotBetween(String value1, String value2) {
            addCriterion("fol_dpt_airport not between", value1, value2, "folDptAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportIsNull() {
            addCriterion("fol_arr_airport is null");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportIsNotNull() {
            addCriterion("fol_arr_airport is not null");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportEqualTo(String value) {
            addCriterion("fol_arr_airport =", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportNotEqualTo(String value) {
            addCriterion("fol_arr_airport <>", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportGreaterThan(String value) {
            addCriterion("fol_arr_airport >", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportGreaterThanOrEqualTo(String value) {
            addCriterion("fol_arr_airport >=", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportLessThan(String value) {
            addCriterion("fol_arr_airport <", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportLessThanOrEqualTo(String value) {
            addCriterion("fol_arr_airport <=", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportLike(String value) {
            addCriterion("fol_arr_airport like", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportNotLike(String value) {
            addCriterion("fol_arr_airport not like", value, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportIn(List<String> values) {
            addCriterion("fol_arr_airport in", values, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportNotIn(List<String> values) {
            addCriterion("fol_arr_airport not in", values, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportBetween(String value1, String value2) {
            addCriterion("fol_arr_airport between", value1, value2, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andFolArrAirportNotBetween(String value1, String value2) {
            addCriterion("fol_arr_airport not between", value1, value2, "folArrAirport");
            return (Criteria) this;
        }

        public Criteria andChangeStatusIsNull() {
            addCriterion("change_status is null");
            return (Criteria) this;
        }

        public Criteria andChangeStatusIsNotNull() {
            addCriterion("change_status is not null");
            return (Criteria) this;
        }

        public Criteria andChangeStatusEqualTo(String value) {
            addCriterion("change_status =", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotEqualTo(String value) {
            addCriterion("change_status <>", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusGreaterThan(String value) {
            addCriterion("change_status >", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("change_status >=", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusLessThan(String value) {
            addCriterion("change_status <", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusLessThanOrEqualTo(String value) {
            addCriterion("change_status <=", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusLike(String value) {
            addCriterion("change_status like", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotLike(String value) {
            addCriterion("change_status not like", value, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusIn(List<String> values) {
            addCriterion("change_status in", values, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotIn(List<String> values) {
            addCriterion("change_status not in", values, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusBetween(String value1, String value2) {
            addCriterion("change_status between", value1, value2, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andChangeStatusNotBetween(String value1, String value2) {
            addCriterion("change_status not between", value1, value2, "changeStatus");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsIsNull() {
            addCriterion("has_send_sms is null");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsIsNotNull() {
            addCriterion("has_send_sms is not null");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsEqualTo(Integer value) {
            addCriterion("has_send_sms =", value, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsNotEqualTo(Integer value) {
            addCriterion("has_send_sms <>", value, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsGreaterThan(Integer value) {
            addCriterion("has_send_sms >", value, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_send_sms >=", value, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsLessThan(Integer value) {
            addCriterion("has_send_sms <", value, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsLessThanOrEqualTo(Integer value) {
            addCriterion("has_send_sms <=", value, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsIn(List<Integer> values) {
            addCriterion("has_send_sms in", values, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsNotIn(List<Integer> values) {
            addCriterion("has_send_sms not in", values, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsBetween(Integer value1, Integer value2) {
            addCriterion("has_send_sms between", value1, value2, "hasSendSms");
            return (Criteria) this;
        }

        public Criteria andHasSendSmsNotBetween(Integer value1, Integer value2) {
            addCriterion("has_send_sms not between", value1, value2, "hasSendSms");
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

        public Criteria andMerchantNoLikeInsensitive(String value) {
            addCriterion("upper(merchant_no) like", value.toUpperCase(), "merchantNo");
            return this;
        }

        public Criteria andOrderNoLikeInsensitive(String value) {
            addCriterion("upper(order_no) like", value.toUpperCase(), "orderNo");
            return this;
        }

        public Criteria andFlightNoLikeInsensitive(String value) {
            addCriterion("upper(flight_no) like", value.toUpperCase(), "flightNo");
            return this;
        }

        public Criteria andDptDateLikeInsensitive(String value) {
            addCriterion("upper(dpt_date) like", value.toUpperCase(), "dptDate");
            return this;
        }

        public Criteria andDptTimeLikeInsensitive(String value) {
            addCriterion("upper(dpt_time) like", value.toUpperCase(), "dptTime");
            return this;
        }

        public Criteria andArrTimeLikeInsensitive(String value) {
            addCriterion("upper(arr_time) like", value.toUpperCase(), "arrTime");
            return this;
        }

        public Criteria andDptAirportLikeInsensitive(String value) {
            addCriterion("upper(dpt_airport) like", value.toUpperCase(), "dptAirport");
            return this;
        }

        public Criteria andArrAirportLikeInsensitive(String value) {
            addCriterion("upper(arr_airport) like", value.toUpperCase(), "arrAirport");
            return this;
        }

        public Criteria andFolFlightNoLikeInsensitive(String value) {
            addCriterion("upper(fol_flight_no) like", value.toUpperCase(), "folFlightNo");
            return this;
        }

        public Criteria andFolDptDateLikeInsensitive(String value) {
            addCriterion("upper(fol_dpt_date) like", value.toUpperCase(), "folDptDate");
            return this;
        }

        public Criteria andFolDptTimeLikeInsensitive(String value) {
            addCriterion("upper(fol_dpt_time) like", value.toUpperCase(), "folDptTime");
            return this;
        }

        public Criteria andFolArrTimeLikeInsensitive(String value) {
            addCriterion("upper(fol_arr_time) like", value.toUpperCase(), "folArrTime");
            return this;
        }

        public Criteria andFolDptAirportLikeInsensitive(String value) {
            addCriterion("upper(fol_dpt_airport) like", value.toUpperCase(), "folDptAirport");
            return this;
        }

        public Criteria andFolArrAirportLikeInsensitive(String value) {
            addCriterion("upper(fol_arr_airport) like", value.toUpperCase(), "folArrAirport");
            return this;
        }

        public Criteria andChangeStatusLikeInsensitive(String value) {
            addCriterion("upper(change_status) like", value.toUpperCase(), "changeStatus");
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