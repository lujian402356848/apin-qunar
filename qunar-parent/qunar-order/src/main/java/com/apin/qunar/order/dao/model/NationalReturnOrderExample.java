package com.apin.qunar.order.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NationalReturnOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public NationalReturnOrderExample() {
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

        public Criteria andTicketNoIsNull() {
            addCriterion("ticket_no is null");
            return (Criteria) this;
        }

        public Criteria andTicketNoIsNotNull() {
            addCriterion("ticket_no is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNoEqualTo(String value) {
            addCriterion("ticket_no =", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotEqualTo(String value) {
            addCriterion("ticket_no <>", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoGreaterThan(String value) {
            addCriterion("ticket_no >", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_no >=", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoLessThan(String value) {
            addCriterion("ticket_no <", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoLessThanOrEqualTo(String value) {
            addCriterion("ticket_no <=", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoLike(String value) {
            addCriterion("ticket_no like", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotLike(String value) {
            addCriterion("ticket_no not like", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoIn(List<String> values) {
            addCriterion("ticket_no in", values, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotIn(List<String> values) {
            addCriterion("ticket_no not in", values, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoBetween(String value1, String value2) {
            addCriterion("ticket_no between", value1, value2, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotBetween(String value1, String value2) {
            addCriterion("ticket_no not between", value1, value2, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andFlightNumIsNull() {
            addCriterion("flight_num is null");
            return (Criteria) this;
        }

        public Criteria andFlightNumIsNotNull() {
            addCriterion("flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andFlightNumEqualTo(String value) {
            addCriterion("flight_num =", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotEqualTo(String value) {
            addCriterion("flight_num <>", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumGreaterThan(String value) {
            addCriterion("flight_num >", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("flight_num >=", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumLessThan(String value) {
            addCriterion("flight_num <", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumLessThanOrEqualTo(String value) {
            addCriterion("flight_num <=", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumLike(String value) {
            addCriterion("flight_num like", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotLike(String value) {
            addCriterion("flight_num not like", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumIn(List<String> values) {
            addCriterion("flight_num in", values, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotIn(List<String> values) {
            addCriterion("flight_num not in", values, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumBetween(String value1, String value2) {
            addCriterion("flight_num between", value1, value2, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotBetween(String value1, String value2) {
            addCriterion("flight_num not between", value1, value2, "flightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumIsNull() {
            addCriterion("act_flight_num is null");
            return (Criteria) this;
        }

        public Criteria andActFlightNumIsNotNull() {
            addCriterion("act_flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andActFlightNumEqualTo(String value) {
            addCriterion("act_flight_num =", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumNotEqualTo(String value) {
            addCriterion("act_flight_num <>", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumGreaterThan(String value) {
            addCriterion("act_flight_num >", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("act_flight_num >=", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumLessThan(String value) {
            addCriterion("act_flight_num <", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumLessThanOrEqualTo(String value) {
            addCriterion("act_flight_num <=", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumLike(String value) {
            addCriterion("act_flight_num like", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumNotLike(String value) {
            addCriterion("act_flight_num not like", value, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumIn(List<String> values) {
            addCriterion("act_flight_num in", values, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumNotIn(List<String> values) {
            addCriterion("act_flight_num not in", values, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumBetween(String value1, String value2) {
            addCriterion("act_flight_num between", value1, value2, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andActFlightNumNotBetween(String value1, String value2) {
            addCriterion("act_flight_num not between", value1, value2, "actFlightNum");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeIsNull() {
            addCriterion("carrier_code is null");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeIsNotNull() {
            addCriterion("carrier_code is not null");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeEqualTo(String value) {
            addCriterion("carrier_code =", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeNotEqualTo(String value) {
            addCriterion("carrier_code <>", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeGreaterThan(String value) {
            addCriterion("carrier_code >", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("carrier_code >=", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeLessThan(String value) {
            addCriterion("carrier_code <", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeLessThanOrEqualTo(String value) {
            addCriterion("carrier_code <=", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeLike(String value) {
            addCriterion("carrier_code like", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeNotLike(String value) {
            addCriterion("carrier_code not like", value, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeIn(List<String> values) {
            addCriterion("carrier_code in", values, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeNotIn(List<String> values) {
            addCriterion("carrier_code not in", values, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeBetween(String value1, String value2) {
            addCriterion("carrier_code between", value1, value2, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierCodeNotBetween(String value1, String value2) {
            addCriterion("carrier_code not between", value1, value2, "carrierCode");
            return (Criteria) this;
        }

        public Criteria andCarrierNameIsNull() {
            addCriterion("carrier_name is null");
            return (Criteria) this;
        }

        public Criteria andCarrierNameIsNotNull() {
            addCriterion("carrier_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarrierNameEqualTo(String value) {
            addCriterion("carrier_name =", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotEqualTo(String value) {
            addCriterion("carrier_name <>", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameGreaterThan(String value) {
            addCriterion("carrier_name >", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameGreaterThanOrEqualTo(String value) {
            addCriterion("carrier_name >=", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameLessThan(String value) {
            addCriterion("carrier_name <", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameLessThanOrEqualTo(String value) {
            addCriterion("carrier_name <=", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameLike(String value) {
            addCriterion("carrier_name like", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotLike(String value) {
            addCriterion("carrier_name not like", value, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameIn(List<String> values) {
            addCriterion("carrier_name in", values, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotIn(List<String> values) {
            addCriterion("carrier_name not in", values, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameBetween(String value1, String value2) {
            addCriterion("carrier_name between", value1, value2, "carrierName");
            return (Criteria) this;
        }

        public Criteria andCarrierNameNotBetween(String value1, String value2) {
            addCriterion("carrier_name not between", value1, value2, "carrierName");
            return (Criteria) this;
        }

        public Criteria andDeptCityIsNull() {
            addCriterion("dept_city is null");
            return (Criteria) this;
        }

        public Criteria andDeptCityIsNotNull() {
            addCriterion("dept_city is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCityEqualTo(String value) {
            addCriterion("dept_city =", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityNotEqualTo(String value) {
            addCriterion("dept_city <>", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityGreaterThan(String value) {
            addCriterion("dept_city >", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityGreaterThanOrEqualTo(String value) {
            addCriterion("dept_city >=", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityLessThan(String value) {
            addCriterion("dept_city <", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityLessThanOrEqualTo(String value) {
            addCriterion("dept_city <=", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityLike(String value) {
            addCriterion("dept_city like", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityNotLike(String value) {
            addCriterion("dept_city not like", value, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityIn(List<String> values) {
            addCriterion("dept_city in", values, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityNotIn(List<String> values) {
            addCriterion("dept_city not in", values, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityBetween(String value1, String value2) {
            addCriterion("dept_city between", value1, value2, "deptCity");
            return (Criteria) this;
        }

        public Criteria andDeptCityNotBetween(String value1, String value2) {
            addCriterion("dept_city not between", value1, value2, "deptCity");
            return (Criteria) this;
        }

        public Criteria andArriCityIsNull() {
            addCriterion("arri_city is null");
            return (Criteria) this;
        }

        public Criteria andArriCityIsNotNull() {
            addCriterion("arri_city is not null");
            return (Criteria) this;
        }

        public Criteria andArriCityEqualTo(String value) {
            addCriterion("arri_city =", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityNotEqualTo(String value) {
            addCriterion("arri_city <>", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityGreaterThan(String value) {
            addCriterion("arri_city >", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityGreaterThanOrEqualTo(String value) {
            addCriterion("arri_city >=", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityLessThan(String value) {
            addCriterion("arri_city <", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityLessThanOrEqualTo(String value) {
            addCriterion("arri_city <=", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityLike(String value) {
            addCriterion("arri_city like", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityNotLike(String value) {
            addCriterion("arri_city not like", value, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityIn(List<String> values) {
            addCriterion("arri_city in", values, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityNotIn(List<String> values) {
            addCriterion("arri_city not in", values, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityBetween(String value1, String value2) {
            addCriterion("arri_city between", value1, value2, "arriCity");
            return (Criteria) this;
        }

        public Criteria andArriCityNotBetween(String value1, String value2) {
            addCriterion("arri_city not between", value1, value2, "arriCity");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameIsNull() {
            addCriterion("dept_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameIsNotNull() {
            addCriterion("dept_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameEqualTo(String value) {
            addCriterion("dept_airport_name =", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameNotEqualTo(String value) {
            addCriterion("dept_airport_name <>", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameGreaterThan(String value) {
            addCriterion("dept_airport_name >", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_airport_name >=", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameLessThan(String value) {
            addCriterion("dept_airport_name <", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameLessThanOrEqualTo(String value) {
            addCriterion("dept_airport_name <=", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameLike(String value) {
            addCriterion("dept_airport_name like", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameNotLike(String value) {
            addCriterion("dept_airport_name not like", value, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameIn(List<String> values) {
            addCriterion("dept_airport_name in", values, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameNotIn(List<String> values) {
            addCriterion("dept_airport_name not in", values, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameBetween(String value1, String value2) {
            addCriterion("dept_airport_name between", value1, value2, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptAirportNameNotBetween(String value1, String value2) {
            addCriterion("dept_airport_name not between", value1, value2, "deptAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameIsNull() {
            addCriterion("arri_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameIsNotNull() {
            addCriterion("arri_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameEqualTo(String value) {
            addCriterion("arri_airport_name =", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameNotEqualTo(String value) {
            addCriterion("arri_airport_name <>", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameGreaterThan(String value) {
            addCriterion("arri_airport_name >", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("arri_airport_name >=", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameLessThan(String value) {
            addCriterion("arri_airport_name <", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameLessThanOrEqualTo(String value) {
            addCriterion("arri_airport_name <=", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameLike(String value) {
            addCriterion("arri_airport_name like", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameNotLike(String value) {
            addCriterion("arri_airport_name not like", value, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameIn(List<String> values) {
            addCriterion("arri_airport_name in", values, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameNotIn(List<String> values) {
            addCriterion("arri_airport_name not in", values, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameBetween(String value1, String value2) {
            addCriterion("arri_airport_name between", value1, value2, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andArriAirportNameNotBetween(String value1, String value2) {
            addCriterion("arri_airport_name not between", value1, value2, "arriAirportName");
            return (Criteria) this;
        }

        public Criteria andDeptDateIsNull() {
            addCriterion("dept_date is null");
            return (Criteria) this;
        }

        public Criteria andDeptDateIsNotNull() {
            addCriterion("dept_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeptDateEqualTo(String value) {
            addCriterion("dept_date =", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateNotEqualTo(String value) {
            addCriterion("dept_date <>", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateGreaterThan(String value) {
            addCriterion("dept_date >", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateGreaterThanOrEqualTo(String value) {
            addCriterion("dept_date >=", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateLessThan(String value) {
            addCriterion("dept_date <", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateLessThanOrEqualTo(String value) {
            addCriterion("dept_date <=", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateLike(String value) {
            addCriterion("dept_date like", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateNotLike(String value) {
            addCriterion("dept_date not like", value, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateIn(List<String> values) {
            addCriterion("dept_date in", values, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateNotIn(List<String> values) {
            addCriterion("dept_date not in", values, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateBetween(String value1, String value2) {
            addCriterion("dept_date between", value1, value2, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptDateNotBetween(String value1, String value2) {
            addCriterion("dept_date not between", value1, value2, "deptDate");
            return (Criteria) this;
        }

        public Criteria andDeptTimeIsNull() {
            addCriterion("dept_time is null");
            return (Criteria) this;
        }

        public Criteria andDeptTimeIsNotNull() {
            addCriterion("dept_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeptTimeEqualTo(String value) {
            addCriterion("dept_time =", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeNotEqualTo(String value) {
            addCriterion("dept_time <>", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeGreaterThan(String value) {
            addCriterion("dept_time >", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_time >=", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeLessThan(String value) {
            addCriterion("dept_time <", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeLessThanOrEqualTo(String value) {
            addCriterion("dept_time <=", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeLike(String value) {
            addCriterion("dept_time like", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeNotLike(String value) {
            addCriterion("dept_time not like", value, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeIn(List<String> values) {
            addCriterion("dept_time in", values, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeNotIn(List<String> values) {
            addCriterion("dept_time not in", values, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeBetween(String value1, String value2) {
            addCriterion("dept_time between", value1, value2, "deptTime");
            return (Criteria) this;
        }

        public Criteria andDeptTimeNotBetween(String value1, String value2) {
            addCriterion("dept_time not between", value1, value2, "deptTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeIsNull() {
            addCriterion("arri_time is null");
            return (Criteria) this;
        }

        public Criteria andArriTimeIsNotNull() {
            addCriterion("arri_time is not null");
            return (Criteria) this;
        }

        public Criteria andArriTimeEqualTo(String value) {
            addCriterion("arri_time =", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeNotEqualTo(String value) {
            addCriterion("arri_time <>", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeGreaterThan(String value) {
            addCriterion("arri_time >", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeGreaterThanOrEqualTo(String value) {
            addCriterion("arri_time >=", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeLessThan(String value) {
            addCriterion("arri_time <", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeLessThanOrEqualTo(String value) {
            addCriterion("arri_time <=", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeLike(String value) {
            addCriterion("arri_time like", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeNotLike(String value) {
            addCriterion("arri_time not like", value, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeIn(List<String> values) {
            addCriterion("arri_time in", values, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeNotIn(List<String> values) {
            addCriterion("arri_time not in", values, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeBetween(String value1, String value2) {
            addCriterion("arri_time between", value1, value2, "arriTime");
            return (Criteria) this;
        }

        public Criteria andArriTimeNotBetween(String value1, String value2) {
            addCriterion("arri_time not between", value1, value2, "arriTime");
            return (Criteria) this;
        }

        public Criteria andReteunCodeIsNull() {
            addCriterion("reteun_code is null");
            return (Criteria) this;
        }

        public Criteria andReteunCodeIsNotNull() {
            addCriterion("reteun_code is not null");
            return (Criteria) this;
        }

        public Criteria andReteunCodeEqualTo(Integer value) {
            addCriterion("reteun_code =", value, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeNotEqualTo(Integer value) {
            addCriterion("reteun_code <>", value, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeGreaterThan(Integer value) {
            addCriterion("reteun_code >", value, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reteun_code >=", value, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeLessThan(Integer value) {
            addCriterion("reteun_code <", value, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeLessThanOrEqualTo(Integer value) {
            addCriterion("reteun_code <=", value, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeIn(List<Integer> values) {
            addCriterion("reteun_code in", values, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeNotIn(List<Integer> values) {
            addCriterion("reteun_code not in", values, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeBetween(Integer value1, Integer value2) {
            addCriterion("reteun_code between", value1, value2, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andReteunCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("reteun_code not between", value1, value2, "reteunCode");
            return (Criteria) this;
        }

        public Criteria andHasDisabledIsNull() {
            addCriterion("has_disabled is null");
            return (Criteria) this;
        }

        public Criteria andHasDisabledIsNotNull() {
            addCriterion("has_disabled is not null");
            return (Criteria) this;
        }

        public Criteria andHasDisabledEqualTo(Integer value) {
            addCriterion("has_disabled =", value, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledNotEqualTo(Integer value) {
            addCriterion("has_disabled <>", value, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledGreaterThan(Integer value) {
            addCriterion("has_disabled >", value, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_disabled >=", value, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledLessThan(Integer value) {
            addCriterion("has_disabled <", value, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledLessThanOrEqualTo(Integer value) {
            addCriterion("has_disabled <=", value, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledIn(List<Integer> values) {
            addCriterion("has_disabled in", values, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledNotIn(List<Integer> values) {
            addCriterion("has_disabled not in", values, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledBetween(Integer value1, Integer value2) {
            addCriterion("has_disabled between", value1, value2, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andHasDisabledNotBetween(Integer value1, Integer value2) {
            addCriterion("has_disabled not between", value1, value2, "hasDisabled");
            return (Criteria) this;
        }

        public Criteria andDisableReasonIsNull() {
            addCriterion("disable_reason is null");
            return (Criteria) this;
        }

        public Criteria andDisableReasonIsNotNull() {
            addCriterion("disable_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDisableReasonEqualTo(String value) {
            addCriterion("disable_reason =", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonNotEqualTo(String value) {
            addCriterion("disable_reason <>", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonGreaterThan(String value) {
            addCriterion("disable_reason >", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonGreaterThanOrEqualTo(String value) {
            addCriterion("disable_reason >=", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonLessThan(String value) {
            addCriterion("disable_reason <", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonLessThanOrEqualTo(String value) {
            addCriterion("disable_reason <=", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonLike(String value) {
            addCriterion("disable_reason like", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonNotLike(String value) {
            addCriterion("disable_reason not like", value, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonIn(List<String> values) {
            addCriterion("disable_reason in", values, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonNotIn(List<String> values) {
            addCriterion("disable_reason not in", values, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonBetween(String value1, String value2) {
            addCriterion("disable_reason between", value1, value2, "disableReason");
            return (Criteria) this;
        }

        public Criteria andDisableReasonNotBetween(String value1, String value2) {
            addCriterion("disable_reason not between", value1, value2, "disableReason");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNull() {
            addCriterion("return_status is null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNotNull() {
            addCriterion("return_status is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusEqualTo(Integer value) {
            addCriterion("return_status =", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotEqualTo(Integer value) {
            addCriterion("return_status <>", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThan(Integer value) {
            addCriterion("return_status >", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_status >=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThan(Integer value) {
            addCriterion("return_status <", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("return_status <=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIn(List<Integer> values) {
            addCriterion("return_status in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotIn(List<Integer> values) {
            addCriterion("return_status not in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusBetween(Integer value1, Integer value2) {
            addCriterion("return_status between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("return_status not between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNull() {
            addCriterion("return_time is null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNotNull() {
            addCriterion("return_time is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeEqualTo(String value) {
            addCriterion("return_time =", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotEqualTo(String value) {
            addCriterion("return_time <>", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThan(String value) {
            addCriterion("return_time >", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThanOrEqualTo(String value) {
            addCriterion("return_time >=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThan(String value) {
            addCriterion("return_time <", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThanOrEqualTo(String value) {
            addCriterion("return_time <=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLike(String value) {
            addCriterion("return_time like", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotLike(String value) {
            addCriterion("return_time not like", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIn(List<String> values) {
            addCriterion("return_time in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotIn(List<String> values) {
            addCriterion("return_time not in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeBetween(String value1, String value2) {
            addCriterion("return_time between", value1, value2, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotBetween(String value1, String value2) {
            addCriterion("return_time not between", value1, value2, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnFeeIsNull() {
            addCriterion("return_fee is null");
            return (Criteria) this;
        }

        public Criteria andReturnFeeIsNotNull() {
            addCriterion("return_fee is not null");
            return (Criteria) this;
        }

        public Criteria andReturnFeeEqualTo(Integer value) {
            addCriterion("return_fee =", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeNotEqualTo(Integer value) {
            addCriterion("return_fee <>", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeGreaterThan(Integer value) {
            addCriterion("return_fee >", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_fee >=", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeLessThan(Integer value) {
            addCriterion("return_fee <", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeLessThanOrEqualTo(Integer value) {
            addCriterion("return_fee <=", value, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeIn(List<Integer> values) {
            addCriterion("return_fee in", values, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeNotIn(List<Integer> values) {
            addCriterion("return_fee not in", values, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeBetween(Integer value1, Integer value2) {
            addCriterion("return_fee between", value1, value2, "returnFee");
            return (Criteria) this;
        }

        public Criteria andReturnFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("return_fee not between", value1, value2, "returnFee");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNull() {
            addCriterion("contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNotNull() {
            addCriterion("contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andContactMobileEqualTo(String value) {
            addCriterion("contact_mobile =", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotEqualTo(String value) {
            addCriterion("contact_mobile <>", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThan(String value) {
            addCriterion("contact_mobile >", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("contact_mobile >=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThan(String value) {
            addCriterion("contact_mobile <", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThanOrEqualTo(String value) {
            addCriterion("contact_mobile <=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLike(String value) {
            addCriterion("contact_mobile like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotLike(String value) {
            addCriterion("contact_mobile not like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileIn(List<String> values) {
            addCriterion("contact_mobile in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotIn(List<String> values) {
            addCriterion("contact_mobile not in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileBetween(String value1, String value2) {
            addCriterion("contact_mobile between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotBetween(String value1, String value2) {
            addCriterion("contact_mobile not between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNull() {
            addCriterion("contact_email is null");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNotNull() {
            addCriterion("contact_email is not null");
            return (Criteria) this;
        }

        public Criteria andContactEmailEqualTo(String value) {
            addCriterion("contact_email =", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotEqualTo(String value) {
            addCriterion("contact_email <>", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThan(String value) {
            addCriterion("contact_email >", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThanOrEqualTo(String value) {
            addCriterion("contact_email >=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThan(String value) {
            addCriterion("contact_email <", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThanOrEqualTo(String value) {
            addCriterion("contact_email <=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLike(String value) {
            addCriterion("contact_email like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotLike(String value) {
            addCriterion("contact_email not like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailIn(List<String> values) {
            addCriterion("contact_email in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotIn(List<String> values) {
            addCriterion("contact_email not in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailBetween(String value1, String value2) {
            addCriterion("contact_email between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotBetween(String value1, String value2) {
            addCriterion("contact_email not between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andTicketNoLikeInsensitive(String value) {
            addCriterion("upper(ticket_no) like", value.toUpperCase(), "ticketNo");
            return this;
        }

        public Criteria andFlightNumLikeInsensitive(String value) {
            addCriterion("upper(flight_num) like", value.toUpperCase(), "flightNum");
            return this;
        }

        public Criteria andActFlightNumLikeInsensitive(String value) {
            addCriterion("upper(act_flight_num) like", value.toUpperCase(), "actFlightNum");
            return this;
        }

        public Criteria andCarrierCodeLikeInsensitive(String value) {
            addCriterion("upper(carrier_code) like", value.toUpperCase(), "carrierCode");
            return this;
        }

        public Criteria andCarrierNameLikeInsensitive(String value) {
            addCriterion("upper(carrier_name) like", value.toUpperCase(), "carrierName");
            return this;
        }

        public Criteria andDeptCityLikeInsensitive(String value) {
            addCriterion("upper(dept_city) like", value.toUpperCase(), "deptCity");
            return this;
        }

        public Criteria andArriCityLikeInsensitive(String value) {
            addCriterion("upper(arri_city) like", value.toUpperCase(), "arriCity");
            return this;
        }

        public Criteria andDeptAirportNameLikeInsensitive(String value) {
            addCriterion("upper(dept_airport_name) like", value.toUpperCase(), "deptAirportName");
            return this;
        }

        public Criteria andArriAirportNameLikeInsensitive(String value) {
            addCriterion("upper(arri_airport_name) like", value.toUpperCase(), "arriAirportName");
            return this;
        }

        public Criteria andDeptDateLikeInsensitive(String value) {
            addCriterion("upper(dept_date) like", value.toUpperCase(), "deptDate");
            return this;
        }

        public Criteria andDeptTimeLikeInsensitive(String value) {
            addCriterion("upper(dept_time) like", value.toUpperCase(), "deptTime");
            return this;
        }

        public Criteria andArriTimeLikeInsensitive(String value) {
            addCriterion("upper(arri_time) like", value.toUpperCase(), "arriTime");
            return this;
        }

        public Criteria andDisableReasonLikeInsensitive(String value) {
            addCriterion("upper(disable_reason) like", value.toUpperCase(), "disableReason");
            return this;
        }

        public Criteria andReturnTimeLikeInsensitive(String value) {
            addCriterion("upper(return_time) like", value.toUpperCase(), "returnTime");
            return this;
        }

        public Criteria andContactNameLikeInsensitive(String value) {
            addCriterion("upper(contact_name) like", value.toUpperCase(), "contactName");
            return this;
        }

        public Criteria andContactMobileLikeInsensitive(String value) {
            addCriterion("upper(contact_mobile) like", value.toUpperCase(), "contactMobile");
            return this;
        }

        public Criteria andContactEmailLikeInsensitive(String value) {
            addCriterion("upper(contact_email) like", value.toUpperCase(), "contactEmail");
            return this;
        }

        public Criteria andOperatorLikeInsensitive(String value) {
            addCriterion("upper(operator) like", value.toUpperCase(), "operator");
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