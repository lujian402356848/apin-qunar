package com.apin.qunar.order.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InternationalOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public InternationalOrderExample() {
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

        public Criteria andPackNameIsNull() {
            addCriterion("pack_name is null");
            return (Criteria) this;
        }

        public Criteria andPackNameIsNotNull() {
            addCriterion("pack_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackNameEqualTo(String value) {
            addCriterion("pack_name =", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameNotEqualTo(String value) {
            addCriterion("pack_name <>", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameGreaterThan(String value) {
            addCriterion("pack_name >", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameGreaterThanOrEqualTo(String value) {
            addCriterion("pack_name >=", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameLessThan(String value) {
            addCriterion("pack_name <", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameLessThanOrEqualTo(String value) {
            addCriterion("pack_name <=", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameLike(String value) {
            addCriterion("pack_name like", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameNotLike(String value) {
            addCriterion("pack_name not like", value, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameIn(List<String> values) {
            addCriterion("pack_name in", values, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameNotIn(List<String> values) {
            addCriterion("pack_name not in", values, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameBetween(String value1, String value2) {
            addCriterion("pack_name between", value1, value2, "packName");
            return (Criteria) this;
        }

        public Criteria andPackNameNotBetween(String value1, String value2) {
            addCriterion("pack_name not between", value1, value2, "packName");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumIsNull() {
            addCriterion("go_flight_num is null");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumIsNotNull() {
            addCriterion("go_flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumEqualTo(String value) {
            addCriterion("go_flight_num =", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumNotEqualTo(String value) {
            addCriterion("go_flight_num <>", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumGreaterThan(String value) {
            addCriterion("go_flight_num >", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("go_flight_num >=", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumLessThan(String value) {
            addCriterion("go_flight_num <", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumLessThanOrEqualTo(String value) {
            addCriterion("go_flight_num <=", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumLike(String value) {
            addCriterion("go_flight_num like", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumNotLike(String value) {
            addCriterion("go_flight_num not like", value, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumIn(List<String> values) {
            addCriterion("go_flight_num in", values, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumNotIn(List<String> values) {
            addCriterion("go_flight_num not in", values, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumBetween(String value1, String value2) {
            addCriterion("go_flight_num between", value1, value2, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightNumNotBetween(String value1, String value2) {
            addCriterion("go_flight_num not between", value1, value2, "goFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumIsNull() {
            addCriterion("go_act_flight_num is null");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumIsNotNull() {
            addCriterion("go_act_flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumEqualTo(String value) {
            addCriterion("go_act_flight_num =", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumNotEqualTo(String value) {
            addCriterion("go_act_flight_num <>", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumGreaterThan(String value) {
            addCriterion("go_act_flight_num >", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("go_act_flight_num >=", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumLessThan(String value) {
            addCriterion("go_act_flight_num <", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumLessThanOrEqualTo(String value) {
            addCriterion("go_act_flight_num <=", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumLike(String value) {
            addCriterion("go_act_flight_num like", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumNotLike(String value) {
            addCriterion("go_act_flight_num not like", value, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumIn(List<String> values) {
            addCriterion("go_act_flight_num in", values, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumNotIn(List<String> values) {
            addCriterion("go_act_flight_num not in", values, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumBetween(String value1, String value2) {
            addCriterion("go_act_flight_num between", value1, value2, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoActFlightNumNotBetween(String value1, String value2) {
            addCriterion("go_act_flight_num not between", value1, value2, "goActFlightNum");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeIsNull() {
            addCriterion("go_flight_time is null");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeIsNotNull() {
            addCriterion("go_flight_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeEqualTo(String value) {
            addCriterion("go_flight_time =", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeNotEqualTo(String value) {
            addCriterion("go_flight_time <>", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeGreaterThan(String value) {
            addCriterion("go_flight_time >", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeGreaterThanOrEqualTo(String value) {
            addCriterion("go_flight_time >=", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeLessThan(String value) {
            addCriterion("go_flight_time <", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeLessThanOrEqualTo(String value) {
            addCriterion("go_flight_time <=", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeLike(String value) {
            addCriterion("go_flight_time like", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeNotLike(String value) {
            addCriterion("go_flight_time not like", value, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeIn(List<String> values) {
            addCriterion("go_flight_time in", values, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeNotIn(List<String> values) {
            addCriterion("go_flight_time not in", values, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeBetween(String value1, String value2) {
            addCriterion("go_flight_time between", value1, value2, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoFlightTimeNotBetween(String value1, String value2) {
            addCriterion("go_flight_time not between", value1, value2, "goFlightTime");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeIsNull() {
            addCriterion("go_carrier_code is null");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeIsNotNull() {
            addCriterion("go_carrier_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeEqualTo(String value) {
            addCriterion("go_carrier_code =", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeNotEqualTo(String value) {
            addCriterion("go_carrier_code <>", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeGreaterThan(String value) {
            addCriterion("go_carrier_code >", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("go_carrier_code >=", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeLessThan(String value) {
            addCriterion("go_carrier_code <", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeLessThanOrEqualTo(String value) {
            addCriterion("go_carrier_code <=", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeLike(String value) {
            addCriterion("go_carrier_code like", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeNotLike(String value) {
            addCriterion("go_carrier_code not like", value, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeIn(List<String> values) {
            addCriterion("go_carrier_code in", values, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeNotIn(List<String> values) {
            addCriterion("go_carrier_code not in", values, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeBetween(String value1, String value2) {
            addCriterion("go_carrier_code between", value1, value2, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierCodeNotBetween(String value1, String value2) {
            addCriterion("go_carrier_code not between", value1, value2, "goCarrierCode");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameIsNull() {
            addCriterion("go_carrier_name is null");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameIsNotNull() {
            addCriterion("go_carrier_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameEqualTo(String value) {
            addCriterion("go_carrier_name =", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameNotEqualTo(String value) {
            addCriterion("go_carrier_name <>", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameGreaterThan(String value) {
            addCriterion("go_carrier_name >", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameGreaterThanOrEqualTo(String value) {
            addCriterion("go_carrier_name >=", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameLessThan(String value) {
            addCriterion("go_carrier_name <", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameLessThanOrEqualTo(String value) {
            addCriterion("go_carrier_name <=", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameLike(String value) {
            addCriterion("go_carrier_name like", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameNotLike(String value) {
            addCriterion("go_carrier_name not like", value, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameIn(List<String> values) {
            addCriterion("go_carrier_name in", values, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameNotIn(List<String> values) {
            addCriterion("go_carrier_name not in", values, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameBetween(String value1, String value2) {
            addCriterion("go_carrier_name between", value1, value2, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoCarrierNameNotBetween(String value1, String value2) {
            addCriterion("go_carrier_name not between", value1, value2, "goCarrierName");
            return (Criteria) this;
        }

        public Criteria andGoStopCntIsNull() {
            addCriterion("go_stop_cnt is null");
            return (Criteria) this;
        }

        public Criteria andGoStopCntIsNotNull() {
            addCriterion("go_stop_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andGoStopCntEqualTo(Integer value) {
            addCriterion("go_stop_cnt =", value, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntNotEqualTo(Integer value) {
            addCriterion("go_stop_cnt <>", value, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntGreaterThan(Integer value) {
            addCriterion("go_stop_cnt >", value, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("go_stop_cnt >=", value, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntLessThan(Integer value) {
            addCriterion("go_stop_cnt <", value, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntLessThanOrEqualTo(Integer value) {
            addCriterion("go_stop_cnt <=", value, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntIn(List<Integer> values) {
            addCriterion("go_stop_cnt in", values, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntNotIn(List<Integer> values) {
            addCriterion("go_stop_cnt not in", values, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntBetween(Integer value1, Integer value2) {
            addCriterion("go_stop_cnt between", value1, value2, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoStopCntNotBetween(Integer value1, Integer value2) {
            addCriterion("go_stop_cnt not between", value1, value2, "goStopCnt");
            return (Criteria) this;
        }

        public Criteria andGoCabinIsNull() {
            addCriterion("go_cabin is null");
            return (Criteria) this;
        }

        public Criteria andGoCabinIsNotNull() {
            addCriterion("go_cabin is not null");
            return (Criteria) this;
        }

        public Criteria andGoCabinEqualTo(String value) {
            addCriterion("go_cabin =", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinNotEqualTo(String value) {
            addCriterion("go_cabin <>", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinGreaterThan(String value) {
            addCriterion("go_cabin >", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinGreaterThanOrEqualTo(String value) {
            addCriterion("go_cabin >=", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinLessThan(String value) {
            addCriterion("go_cabin <", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinLessThanOrEqualTo(String value) {
            addCriterion("go_cabin <=", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinLike(String value) {
            addCriterion("go_cabin like", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinNotLike(String value) {
            addCriterion("go_cabin not like", value, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinIn(List<String> values) {
            addCriterion("go_cabin in", values, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinNotIn(List<String> values) {
            addCriterion("go_cabin not in", values, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinBetween(String value1, String value2) {
            addCriterion("go_cabin between", value1, value2, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoCabinNotBetween(String value1, String value2) {
            addCriterion("go_cabin not between", value1, value2, "goCabin");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityIsNull() {
            addCriterion("go_dept_city is null");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityIsNotNull() {
            addCriterion("go_dept_city is not null");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityEqualTo(String value) {
            addCriterion("go_dept_city =", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityNotEqualTo(String value) {
            addCriterion("go_dept_city <>", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityGreaterThan(String value) {
            addCriterion("go_dept_city >", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityGreaterThanOrEqualTo(String value) {
            addCriterion("go_dept_city >=", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityLessThan(String value) {
            addCriterion("go_dept_city <", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityLessThanOrEqualTo(String value) {
            addCriterion("go_dept_city <=", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityLike(String value) {
            addCriterion("go_dept_city like", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityNotLike(String value) {
            addCriterion("go_dept_city not like", value, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityIn(List<String> values) {
            addCriterion("go_dept_city in", values, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityNotIn(List<String> values) {
            addCriterion("go_dept_city not in", values, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityBetween(String value1, String value2) {
            addCriterion("go_dept_city between", value1, value2, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptCityNotBetween(String value1, String value2) {
            addCriterion("go_dept_city not between", value1, value2, "goDeptCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityIsNull() {
            addCriterion("go_arri_city is null");
            return (Criteria) this;
        }

        public Criteria andGoArriCityIsNotNull() {
            addCriterion("go_arri_city is not null");
            return (Criteria) this;
        }

        public Criteria andGoArriCityEqualTo(String value) {
            addCriterion("go_arri_city =", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityNotEqualTo(String value) {
            addCriterion("go_arri_city <>", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityGreaterThan(String value) {
            addCriterion("go_arri_city >", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityGreaterThanOrEqualTo(String value) {
            addCriterion("go_arri_city >=", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityLessThan(String value) {
            addCriterion("go_arri_city <", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityLessThanOrEqualTo(String value) {
            addCriterion("go_arri_city <=", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityLike(String value) {
            addCriterion("go_arri_city like", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityNotLike(String value) {
            addCriterion("go_arri_city not like", value, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityIn(List<String> values) {
            addCriterion("go_arri_city in", values, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityNotIn(List<String> values) {
            addCriterion("go_arri_city not in", values, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityBetween(String value1, String value2) {
            addCriterion("go_arri_city between", value1, value2, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoArriCityNotBetween(String value1, String value2) {
            addCriterion("go_arri_city not between", value1, value2, "goArriCity");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeIsNull() {
            addCriterion("go_dept_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeIsNotNull() {
            addCriterion("go_dept_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeEqualTo(String value) {
            addCriterion("go_dept_airport_code =", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeNotEqualTo(String value) {
            addCriterion("go_dept_airport_code <>", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeGreaterThan(String value) {
            addCriterion("go_dept_airport_code >", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("go_dept_airport_code >=", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeLessThan(String value) {
            addCriterion("go_dept_airport_code <", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("go_dept_airport_code <=", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeLike(String value) {
            addCriterion("go_dept_airport_code like", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeNotLike(String value) {
            addCriterion("go_dept_airport_code not like", value, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeIn(List<String> values) {
            addCriterion("go_dept_airport_code in", values, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeNotIn(List<String> values) {
            addCriterion("go_dept_airport_code not in", values, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeBetween(String value1, String value2) {
            addCriterion("go_dept_airport_code between", value1, value2, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportCodeNotBetween(String value1, String value2) {
            addCriterion("go_dept_airport_code not between", value1, value2, "goDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeIsNull() {
            addCriterion("go_arri_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeIsNotNull() {
            addCriterion("go_arri_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeEqualTo(String value) {
            addCriterion("go_arri_airport_code =", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeNotEqualTo(String value) {
            addCriterion("go_arri_airport_code <>", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeGreaterThan(String value) {
            addCriterion("go_arri_airport_code >", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("go_arri_airport_code >=", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeLessThan(String value) {
            addCriterion("go_arri_airport_code <", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("go_arri_airport_code <=", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeLike(String value) {
            addCriterion("go_arri_airport_code like", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeNotLike(String value) {
            addCriterion("go_arri_airport_code not like", value, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeIn(List<String> values) {
            addCriterion("go_arri_airport_code in", values, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeNotIn(List<String> values) {
            addCriterion("go_arri_airport_code not in", values, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeBetween(String value1, String value2) {
            addCriterion("go_arri_airport_code between", value1, value2, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportCodeNotBetween(String value1, String value2) {
            addCriterion("go_arri_airport_code not between", value1, value2, "goArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameIsNull() {
            addCriterion("go_dept_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameIsNotNull() {
            addCriterion("go_dept_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameEqualTo(String value) {
            addCriterion("go_dept_airport_name =", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameNotEqualTo(String value) {
            addCriterion("go_dept_airport_name <>", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameGreaterThan(String value) {
            addCriterion("go_dept_airport_name >", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("go_dept_airport_name >=", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameLessThan(String value) {
            addCriterion("go_dept_airport_name <", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameLessThanOrEqualTo(String value) {
            addCriterion("go_dept_airport_name <=", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameLike(String value) {
            addCriterion("go_dept_airport_name like", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameNotLike(String value) {
            addCriterion("go_dept_airport_name not like", value, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameIn(List<String> values) {
            addCriterion("go_dept_airport_name in", values, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameNotIn(List<String> values) {
            addCriterion("go_dept_airport_name not in", values, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameBetween(String value1, String value2) {
            addCriterion("go_dept_airport_name between", value1, value2, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptAirportNameNotBetween(String value1, String value2) {
            addCriterion("go_dept_airport_name not between", value1, value2, "goDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameIsNull() {
            addCriterion("go_arri_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameIsNotNull() {
            addCriterion("go_arri_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameEqualTo(String value) {
            addCriterion("go_arri_airport_name =", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameNotEqualTo(String value) {
            addCriterion("go_arri_airport_name <>", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameGreaterThan(String value) {
            addCriterion("go_arri_airport_name >", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("go_arri_airport_name >=", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameLessThan(String value) {
            addCriterion("go_arri_airport_name <", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameLessThanOrEqualTo(String value) {
            addCriterion("go_arri_airport_name <=", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameLike(String value) {
            addCriterion("go_arri_airport_name like", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameNotLike(String value) {
            addCriterion("go_arri_airport_name not like", value, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameIn(List<String> values) {
            addCriterion("go_arri_airport_name in", values, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameNotIn(List<String> values) {
            addCriterion("go_arri_airport_name not in", values, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameBetween(String value1, String value2) {
            addCriterion("go_arri_airport_name between", value1, value2, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoArriAirportNameNotBetween(String value1, String value2) {
            addCriterion("go_arri_airport_name not between", value1, value2, "goArriAirportName");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalIsNull() {
            addCriterion("go_dept_terminal is null");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalIsNotNull() {
            addCriterion("go_dept_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalEqualTo(String value) {
            addCriterion("go_dept_terminal =", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalNotEqualTo(String value) {
            addCriterion("go_dept_terminal <>", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalGreaterThan(String value) {
            addCriterion("go_dept_terminal >", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("go_dept_terminal >=", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalLessThan(String value) {
            addCriterion("go_dept_terminal <", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalLessThanOrEqualTo(String value) {
            addCriterion("go_dept_terminal <=", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalLike(String value) {
            addCriterion("go_dept_terminal like", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalNotLike(String value) {
            addCriterion("go_dept_terminal not like", value, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalIn(List<String> values) {
            addCriterion("go_dept_terminal in", values, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalNotIn(List<String> values) {
            addCriterion("go_dept_terminal not in", values, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalBetween(String value1, String value2) {
            addCriterion("go_dept_terminal between", value1, value2, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptTerminalNotBetween(String value1, String value2) {
            addCriterion("go_dept_terminal not between", value1, value2, "goDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalIsNull() {
            addCriterion("go_arri_terminal is null");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalIsNotNull() {
            addCriterion("go_arri_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalEqualTo(String value) {
            addCriterion("go_arri_terminal =", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalNotEqualTo(String value) {
            addCriterion("go_arri_terminal <>", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalGreaterThan(String value) {
            addCriterion("go_arri_terminal >", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("go_arri_terminal >=", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalLessThan(String value) {
            addCriterion("go_arri_terminal <", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalLessThanOrEqualTo(String value) {
            addCriterion("go_arri_terminal <=", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalLike(String value) {
            addCriterion("go_arri_terminal like", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalNotLike(String value) {
            addCriterion("go_arri_terminal not like", value, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalIn(List<String> values) {
            addCriterion("go_arri_terminal in", values, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalNotIn(List<String> values) {
            addCriterion("go_arri_terminal not in", values, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalBetween(String value1, String value2) {
            addCriterion("go_arri_terminal between", value1, value2, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoArriTerminalNotBetween(String value1, String value2) {
            addCriterion("go_arri_terminal not between", value1, value2, "goArriTerminal");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateIsNull() {
            addCriterion("go_dept_date is null");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateIsNotNull() {
            addCriterion("go_dept_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateEqualTo(String value) {
            addCriterion("go_dept_date =", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateNotEqualTo(String value) {
            addCriterion("go_dept_date <>", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateGreaterThan(String value) {
            addCriterion("go_dept_date >", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateGreaterThanOrEqualTo(String value) {
            addCriterion("go_dept_date >=", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateLessThan(String value) {
            addCriterion("go_dept_date <", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateLessThanOrEqualTo(String value) {
            addCriterion("go_dept_date <=", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateLike(String value) {
            addCriterion("go_dept_date like", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateNotLike(String value) {
            addCriterion("go_dept_date not like", value, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateIn(List<String> values) {
            addCriterion("go_dept_date in", values, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateNotIn(List<String> values) {
            addCriterion("go_dept_date not in", values, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateBetween(String value1, String value2) {
            addCriterion("go_dept_date between", value1, value2, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptDateNotBetween(String value1, String value2) {
            addCriterion("go_dept_date not between", value1, value2, "goDeptDate");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeIsNull() {
            addCriterion("go_dept_time is null");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeIsNotNull() {
            addCriterion("go_dept_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeEqualTo(String value) {
            addCriterion("go_dept_time =", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeNotEqualTo(String value) {
            addCriterion("go_dept_time <>", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeGreaterThan(String value) {
            addCriterion("go_dept_time >", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("go_dept_time >=", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeLessThan(String value) {
            addCriterion("go_dept_time <", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeLessThanOrEqualTo(String value) {
            addCriterion("go_dept_time <=", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeLike(String value) {
            addCriterion("go_dept_time like", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeNotLike(String value) {
            addCriterion("go_dept_time not like", value, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeIn(List<String> values) {
            addCriterion("go_dept_time in", values, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeNotIn(List<String> values) {
            addCriterion("go_dept_time not in", values, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeBetween(String value1, String value2) {
            addCriterion("go_dept_time between", value1, value2, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoDeptTimeNotBetween(String value1, String value2) {
            addCriterion("go_dept_time not between", value1, value2, "goDeptTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeIsNull() {
            addCriterion("go_arri_time is null");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeIsNotNull() {
            addCriterion("go_arri_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeEqualTo(String value) {
            addCriterion("go_arri_time =", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeNotEqualTo(String value) {
            addCriterion("go_arri_time <>", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeGreaterThan(String value) {
            addCriterion("go_arri_time >", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeGreaterThanOrEqualTo(String value) {
            addCriterion("go_arri_time >=", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeLessThan(String value) {
            addCriterion("go_arri_time <", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeLessThanOrEqualTo(String value) {
            addCriterion("go_arri_time <=", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeLike(String value) {
            addCriterion("go_arri_time like", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeNotLike(String value) {
            addCriterion("go_arri_time not like", value, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeIn(List<String> values) {
            addCriterion("go_arri_time in", values, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeNotIn(List<String> values) {
            addCriterion("go_arri_time not in", values, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeBetween(String value1, String value2) {
            addCriterion("go_arri_time between", value1, value2, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andGoArriTimeNotBetween(String value1, String value2) {
            addCriterion("go_arri_time not between", value1, value2, "goArriTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumIsNull() {
            addCriterion("back_flight_num is null");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumIsNotNull() {
            addCriterion("back_flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumEqualTo(String value) {
            addCriterion("back_flight_num =", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumNotEqualTo(String value) {
            addCriterion("back_flight_num <>", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumGreaterThan(String value) {
            addCriterion("back_flight_num >", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("back_flight_num >=", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumLessThan(String value) {
            addCriterion("back_flight_num <", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumLessThanOrEqualTo(String value) {
            addCriterion("back_flight_num <=", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumLike(String value) {
            addCriterion("back_flight_num like", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumNotLike(String value) {
            addCriterion("back_flight_num not like", value, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumIn(List<String> values) {
            addCriterion("back_flight_num in", values, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumNotIn(List<String> values) {
            addCriterion("back_flight_num not in", values, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumBetween(String value1, String value2) {
            addCriterion("back_flight_num between", value1, value2, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightNumNotBetween(String value1, String value2) {
            addCriterion("back_flight_num not between", value1, value2, "backFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumIsNull() {
            addCriterion("back_act_flight_num is null");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumIsNotNull() {
            addCriterion("back_act_flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumEqualTo(String value) {
            addCriterion("back_act_flight_num =", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumNotEqualTo(String value) {
            addCriterion("back_act_flight_num <>", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumGreaterThan(String value) {
            addCriterion("back_act_flight_num >", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("back_act_flight_num >=", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumLessThan(String value) {
            addCriterion("back_act_flight_num <", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumLessThanOrEqualTo(String value) {
            addCriterion("back_act_flight_num <=", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumLike(String value) {
            addCriterion("back_act_flight_num like", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumNotLike(String value) {
            addCriterion("back_act_flight_num not like", value, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumIn(List<String> values) {
            addCriterion("back_act_flight_num in", values, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumNotIn(List<String> values) {
            addCriterion("back_act_flight_num not in", values, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumBetween(String value1, String value2) {
            addCriterion("back_act_flight_num between", value1, value2, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackActFlightNumNotBetween(String value1, String value2) {
            addCriterion("back_act_flight_num not between", value1, value2, "backActFlightNum");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeIsNull() {
            addCriterion("back_flight_time is null");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeIsNotNull() {
            addCriterion("back_flight_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeEqualTo(String value) {
            addCriterion("back_flight_time =", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeNotEqualTo(String value) {
            addCriterion("back_flight_time <>", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeGreaterThan(String value) {
            addCriterion("back_flight_time >", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeGreaterThanOrEqualTo(String value) {
            addCriterion("back_flight_time >=", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeLessThan(String value) {
            addCriterion("back_flight_time <", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeLessThanOrEqualTo(String value) {
            addCriterion("back_flight_time <=", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeLike(String value) {
            addCriterion("back_flight_time like", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeNotLike(String value) {
            addCriterion("back_flight_time not like", value, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeIn(List<String> values) {
            addCriterion("back_flight_time in", values, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeNotIn(List<String> values) {
            addCriterion("back_flight_time not in", values, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeBetween(String value1, String value2) {
            addCriterion("back_flight_time between", value1, value2, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackFlightTimeNotBetween(String value1, String value2) {
            addCriterion("back_flight_time not between", value1, value2, "backFlightTime");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeIsNull() {
            addCriterion("back_carrier_code is null");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeIsNotNull() {
            addCriterion("back_carrier_code is not null");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeEqualTo(String value) {
            addCriterion("back_carrier_code =", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeNotEqualTo(String value) {
            addCriterion("back_carrier_code <>", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeGreaterThan(String value) {
            addCriterion("back_carrier_code >", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("back_carrier_code >=", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeLessThan(String value) {
            addCriterion("back_carrier_code <", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeLessThanOrEqualTo(String value) {
            addCriterion("back_carrier_code <=", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeLike(String value) {
            addCriterion("back_carrier_code like", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeNotLike(String value) {
            addCriterion("back_carrier_code not like", value, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeIn(List<String> values) {
            addCriterion("back_carrier_code in", values, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeNotIn(List<String> values) {
            addCriterion("back_carrier_code not in", values, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeBetween(String value1, String value2) {
            addCriterion("back_carrier_code between", value1, value2, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierCodeNotBetween(String value1, String value2) {
            addCriterion("back_carrier_code not between", value1, value2, "backCarrierCode");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameIsNull() {
            addCriterion("back_carrier_name is null");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameIsNotNull() {
            addCriterion("back_carrier_name is not null");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameEqualTo(String value) {
            addCriterion("back_carrier_name =", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameNotEqualTo(String value) {
            addCriterion("back_carrier_name <>", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameGreaterThan(String value) {
            addCriterion("back_carrier_name >", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameGreaterThanOrEqualTo(String value) {
            addCriterion("back_carrier_name >=", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameLessThan(String value) {
            addCriterion("back_carrier_name <", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameLessThanOrEqualTo(String value) {
            addCriterion("back_carrier_name <=", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameLike(String value) {
            addCriterion("back_carrier_name like", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameNotLike(String value) {
            addCriterion("back_carrier_name not like", value, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameIn(List<String> values) {
            addCriterion("back_carrier_name in", values, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameNotIn(List<String> values) {
            addCriterion("back_carrier_name not in", values, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameBetween(String value1, String value2) {
            addCriterion("back_carrier_name between", value1, value2, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackCarrierNameNotBetween(String value1, String value2) {
            addCriterion("back_carrier_name not between", value1, value2, "backCarrierName");
            return (Criteria) this;
        }

        public Criteria andBackStopCntIsNull() {
            addCriterion("back_stop_cnt is null");
            return (Criteria) this;
        }

        public Criteria andBackStopCntIsNotNull() {
            addCriterion("back_stop_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andBackStopCntEqualTo(Integer value) {
            addCriterion("back_stop_cnt =", value, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntNotEqualTo(Integer value) {
            addCriterion("back_stop_cnt <>", value, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntGreaterThan(Integer value) {
            addCriterion("back_stop_cnt >", value, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("back_stop_cnt >=", value, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntLessThan(Integer value) {
            addCriterion("back_stop_cnt <", value, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntLessThanOrEqualTo(Integer value) {
            addCriterion("back_stop_cnt <=", value, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntIn(List<Integer> values) {
            addCriterion("back_stop_cnt in", values, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntNotIn(List<Integer> values) {
            addCriterion("back_stop_cnt not in", values, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntBetween(Integer value1, Integer value2) {
            addCriterion("back_stop_cnt between", value1, value2, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackStopCntNotBetween(Integer value1, Integer value2) {
            addCriterion("back_stop_cnt not between", value1, value2, "backStopCnt");
            return (Criteria) this;
        }

        public Criteria andBackCabinIsNull() {
            addCriterion("back_cabin is null");
            return (Criteria) this;
        }

        public Criteria andBackCabinIsNotNull() {
            addCriterion("back_cabin is not null");
            return (Criteria) this;
        }

        public Criteria andBackCabinEqualTo(String value) {
            addCriterion("back_cabin =", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinNotEqualTo(String value) {
            addCriterion("back_cabin <>", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinGreaterThan(String value) {
            addCriterion("back_cabin >", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinGreaterThanOrEqualTo(String value) {
            addCriterion("back_cabin >=", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinLessThan(String value) {
            addCriterion("back_cabin <", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinLessThanOrEqualTo(String value) {
            addCriterion("back_cabin <=", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinLike(String value) {
            addCriterion("back_cabin like", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinNotLike(String value) {
            addCriterion("back_cabin not like", value, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinIn(List<String> values) {
            addCriterion("back_cabin in", values, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinNotIn(List<String> values) {
            addCriterion("back_cabin not in", values, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinBetween(String value1, String value2) {
            addCriterion("back_cabin between", value1, value2, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackCabinNotBetween(String value1, String value2) {
            addCriterion("back_cabin not between", value1, value2, "backCabin");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityIsNull() {
            addCriterion("back_dept_city is null");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityIsNotNull() {
            addCriterion("back_dept_city is not null");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityEqualTo(String value) {
            addCriterion("back_dept_city =", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityNotEqualTo(String value) {
            addCriterion("back_dept_city <>", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityGreaterThan(String value) {
            addCriterion("back_dept_city >", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityGreaterThanOrEqualTo(String value) {
            addCriterion("back_dept_city >=", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityLessThan(String value) {
            addCriterion("back_dept_city <", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityLessThanOrEqualTo(String value) {
            addCriterion("back_dept_city <=", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityLike(String value) {
            addCriterion("back_dept_city like", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityNotLike(String value) {
            addCriterion("back_dept_city not like", value, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityIn(List<String> values) {
            addCriterion("back_dept_city in", values, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityNotIn(List<String> values) {
            addCriterion("back_dept_city not in", values, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityBetween(String value1, String value2) {
            addCriterion("back_dept_city between", value1, value2, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptCityNotBetween(String value1, String value2) {
            addCriterion("back_dept_city not between", value1, value2, "backDeptCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityIsNull() {
            addCriterion("back_arri_city is null");
            return (Criteria) this;
        }

        public Criteria andBackArriCityIsNotNull() {
            addCriterion("back_arri_city is not null");
            return (Criteria) this;
        }

        public Criteria andBackArriCityEqualTo(String value) {
            addCriterion("back_arri_city =", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityNotEqualTo(String value) {
            addCriterion("back_arri_city <>", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityGreaterThan(String value) {
            addCriterion("back_arri_city >", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityGreaterThanOrEqualTo(String value) {
            addCriterion("back_arri_city >=", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityLessThan(String value) {
            addCriterion("back_arri_city <", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityLessThanOrEqualTo(String value) {
            addCriterion("back_arri_city <=", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityLike(String value) {
            addCriterion("back_arri_city like", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityNotLike(String value) {
            addCriterion("back_arri_city not like", value, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityIn(List<String> values) {
            addCriterion("back_arri_city in", values, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityNotIn(List<String> values) {
            addCriterion("back_arri_city not in", values, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityBetween(String value1, String value2) {
            addCriterion("back_arri_city between", value1, value2, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackArriCityNotBetween(String value1, String value2) {
            addCriterion("back_arri_city not between", value1, value2, "backArriCity");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeIsNull() {
            addCriterion("back_dept_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeIsNotNull() {
            addCriterion("back_dept_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeEqualTo(String value) {
            addCriterion("back_dept_airport_code =", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeNotEqualTo(String value) {
            addCriterion("back_dept_airport_code <>", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeGreaterThan(String value) {
            addCriterion("back_dept_airport_code >", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("back_dept_airport_code >=", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeLessThan(String value) {
            addCriterion("back_dept_airport_code <", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("back_dept_airport_code <=", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeLike(String value) {
            addCriterion("back_dept_airport_code like", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeNotLike(String value) {
            addCriterion("back_dept_airport_code not like", value, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeIn(List<String> values) {
            addCriterion("back_dept_airport_code in", values, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeNotIn(List<String> values) {
            addCriterion("back_dept_airport_code not in", values, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeBetween(String value1, String value2) {
            addCriterion("back_dept_airport_code between", value1, value2, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportCodeNotBetween(String value1, String value2) {
            addCriterion("back_dept_airport_code not between", value1, value2, "backDeptAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeIsNull() {
            addCriterion("back_arri_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeIsNotNull() {
            addCriterion("back_arri_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeEqualTo(String value) {
            addCriterion("back_arri_airport_code =", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeNotEqualTo(String value) {
            addCriterion("back_arri_airport_code <>", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeGreaterThan(String value) {
            addCriterion("back_arri_airport_code >", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("back_arri_airport_code >=", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeLessThan(String value) {
            addCriterion("back_arri_airport_code <", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("back_arri_airport_code <=", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeLike(String value) {
            addCriterion("back_arri_airport_code like", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeNotLike(String value) {
            addCriterion("back_arri_airport_code not like", value, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeIn(List<String> values) {
            addCriterion("back_arri_airport_code in", values, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeNotIn(List<String> values) {
            addCriterion("back_arri_airport_code not in", values, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeBetween(String value1, String value2) {
            addCriterion("back_arri_airport_code between", value1, value2, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportCodeNotBetween(String value1, String value2) {
            addCriterion("back_arri_airport_code not between", value1, value2, "backArriAirportCode");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameIsNull() {
            addCriterion("back_dept_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameIsNotNull() {
            addCriterion("back_dept_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameEqualTo(String value) {
            addCriterion("back_dept_airport_name =", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameNotEqualTo(String value) {
            addCriterion("back_dept_airport_name <>", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameGreaterThan(String value) {
            addCriterion("back_dept_airport_name >", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("back_dept_airport_name >=", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameLessThan(String value) {
            addCriterion("back_dept_airport_name <", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameLessThanOrEqualTo(String value) {
            addCriterion("back_dept_airport_name <=", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameLike(String value) {
            addCriterion("back_dept_airport_name like", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameNotLike(String value) {
            addCriterion("back_dept_airport_name not like", value, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameIn(List<String> values) {
            addCriterion("back_dept_airport_name in", values, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameNotIn(List<String> values) {
            addCriterion("back_dept_airport_name not in", values, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameBetween(String value1, String value2) {
            addCriterion("back_dept_airport_name between", value1, value2, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptAirportNameNotBetween(String value1, String value2) {
            addCriterion("back_dept_airport_name not between", value1, value2, "backDeptAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameIsNull() {
            addCriterion("back_arri_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameIsNotNull() {
            addCriterion("back_arri_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameEqualTo(String value) {
            addCriterion("back_arri_airport_name =", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameNotEqualTo(String value) {
            addCriterion("back_arri_airport_name <>", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameGreaterThan(String value) {
            addCriterion("back_arri_airport_name >", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("back_arri_airport_name >=", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameLessThan(String value) {
            addCriterion("back_arri_airport_name <", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameLessThanOrEqualTo(String value) {
            addCriterion("back_arri_airport_name <=", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameLike(String value) {
            addCriterion("back_arri_airport_name like", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameNotLike(String value) {
            addCriterion("back_arri_airport_name not like", value, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameIn(List<String> values) {
            addCriterion("back_arri_airport_name in", values, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameNotIn(List<String> values) {
            addCriterion("back_arri_airport_name not in", values, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameBetween(String value1, String value2) {
            addCriterion("back_arri_airport_name between", value1, value2, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackArriAirportNameNotBetween(String value1, String value2) {
            addCriterion("back_arri_airport_name not between", value1, value2, "backArriAirportName");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalIsNull() {
            addCriterion("back_dept_terminal is null");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalIsNotNull() {
            addCriterion("back_dept_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalEqualTo(String value) {
            addCriterion("back_dept_terminal =", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalNotEqualTo(String value) {
            addCriterion("back_dept_terminal <>", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalGreaterThan(String value) {
            addCriterion("back_dept_terminal >", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("back_dept_terminal >=", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalLessThan(String value) {
            addCriterion("back_dept_terminal <", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalLessThanOrEqualTo(String value) {
            addCriterion("back_dept_terminal <=", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalLike(String value) {
            addCriterion("back_dept_terminal like", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalNotLike(String value) {
            addCriterion("back_dept_terminal not like", value, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalIn(List<String> values) {
            addCriterion("back_dept_terminal in", values, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalNotIn(List<String> values) {
            addCriterion("back_dept_terminal not in", values, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalBetween(String value1, String value2) {
            addCriterion("back_dept_terminal between", value1, value2, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptTerminalNotBetween(String value1, String value2) {
            addCriterion("back_dept_terminal not between", value1, value2, "backDeptTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalIsNull() {
            addCriterion("back_arri_terminal is null");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalIsNotNull() {
            addCriterion("back_arri_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalEqualTo(String value) {
            addCriterion("back_arri_terminal =", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalNotEqualTo(String value) {
            addCriterion("back_arri_terminal <>", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalGreaterThan(String value) {
            addCriterion("back_arri_terminal >", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("back_arri_terminal >=", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalLessThan(String value) {
            addCriterion("back_arri_terminal <", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalLessThanOrEqualTo(String value) {
            addCriterion("back_arri_terminal <=", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalLike(String value) {
            addCriterion("back_arri_terminal like", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalNotLike(String value) {
            addCriterion("back_arri_terminal not like", value, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalIn(List<String> values) {
            addCriterion("back_arri_terminal in", values, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalNotIn(List<String> values) {
            addCriterion("back_arri_terminal not in", values, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalBetween(String value1, String value2) {
            addCriterion("back_arri_terminal between", value1, value2, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackArriTerminalNotBetween(String value1, String value2) {
            addCriterion("back_arri_terminal not between", value1, value2, "backArriTerminal");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateIsNull() {
            addCriterion("back_dept_date is null");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateIsNotNull() {
            addCriterion("back_dept_date is not null");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateEqualTo(String value) {
            addCriterion("back_dept_date =", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateNotEqualTo(String value) {
            addCriterion("back_dept_date <>", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateGreaterThan(String value) {
            addCriterion("back_dept_date >", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateGreaterThanOrEqualTo(String value) {
            addCriterion("back_dept_date >=", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateLessThan(String value) {
            addCriterion("back_dept_date <", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateLessThanOrEqualTo(String value) {
            addCriterion("back_dept_date <=", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateLike(String value) {
            addCriterion("back_dept_date like", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateNotLike(String value) {
            addCriterion("back_dept_date not like", value, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateIn(List<String> values) {
            addCriterion("back_dept_date in", values, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateNotIn(List<String> values) {
            addCriterion("back_dept_date not in", values, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateBetween(String value1, String value2) {
            addCriterion("back_dept_date between", value1, value2, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptDateNotBetween(String value1, String value2) {
            addCriterion("back_dept_date not between", value1, value2, "backDeptDate");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeIsNull() {
            addCriterion("back_dept_time is null");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeIsNotNull() {
            addCriterion("back_dept_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeEqualTo(String value) {
            addCriterion("back_dept_time =", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeNotEqualTo(String value) {
            addCriterion("back_dept_time <>", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeGreaterThan(String value) {
            addCriterion("back_dept_time >", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("back_dept_time >=", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeLessThan(String value) {
            addCriterion("back_dept_time <", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeLessThanOrEqualTo(String value) {
            addCriterion("back_dept_time <=", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeLike(String value) {
            addCriterion("back_dept_time like", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeNotLike(String value) {
            addCriterion("back_dept_time not like", value, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeIn(List<String> values) {
            addCriterion("back_dept_time in", values, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeNotIn(List<String> values) {
            addCriterion("back_dept_time not in", values, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeBetween(String value1, String value2) {
            addCriterion("back_dept_time between", value1, value2, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackDeptTimeNotBetween(String value1, String value2) {
            addCriterion("back_dept_time not between", value1, value2, "backDeptTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeIsNull() {
            addCriterion("back_arri_time is null");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeIsNotNull() {
            addCriterion("back_arri_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeEqualTo(String value) {
            addCriterion("back_arri_time =", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeNotEqualTo(String value) {
            addCriterion("back_arri_time <>", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeGreaterThan(String value) {
            addCriterion("back_arri_time >", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeGreaterThanOrEqualTo(String value) {
            addCriterion("back_arri_time >=", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeLessThan(String value) {
            addCriterion("back_arri_time <", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeLessThanOrEqualTo(String value) {
            addCriterion("back_arri_time <=", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeLike(String value) {
            addCriterion("back_arri_time like", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeNotLike(String value) {
            addCriterion("back_arri_time not like", value, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeIn(List<String> values) {
            addCriterion("back_arri_time in", values, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeNotIn(List<String> values) {
            addCriterion("back_arri_time not in", values, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeBetween(String value1, String value2) {
            addCriterion("back_arri_time between", value1, value2, "backArriTime");
            return (Criteria) this;
        }

        public Criteria andBackArriTimeNotBetween(String value1, String value2) {
            addCriterion("back_arri_time not between", value1, value2, "backArriTime");
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

        public Criteria andReturnTextIsNull() {
            addCriterion("return_text is null");
            return (Criteria) this;
        }

        public Criteria andReturnTextIsNotNull() {
            addCriterion("return_text is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTextEqualTo(String value) {
            addCriterion("return_text =", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextNotEqualTo(String value) {
            addCriterion("return_text <>", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextGreaterThan(String value) {
            addCriterion("return_text >", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextGreaterThanOrEqualTo(String value) {
            addCriterion("return_text >=", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextLessThan(String value) {
            addCriterion("return_text <", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextLessThanOrEqualTo(String value) {
            addCriterion("return_text <=", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextLike(String value) {
            addCriterion("return_text like", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextNotLike(String value) {
            addCriterion("return_text not like", value, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextIn(List<String> values) {
            addCriterion("return_text in", values, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextNotIn(List<String> values) {
            addCriterion("return_text not in", values, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextBetween(String value1, String value2) {
            addCriterion("return_text between", value1, value2, "returnText");
            return (Criteria) this;
        }

        public Criteria andReturnTextNotBetween(String value1, String value2) {
            addCriterion("return_text not between", value1, value2, "returnText");
            return (Criteria) this;
        }

        public Criteria andChangeFeeIsNull() {
            addCriterion("change_fee is null");
            return (Criteria) this;
        }

        public Criteria andChangeFeeIsNotNull() {
            addCriterion("change_fee is not null");
            return (Criteria) this;
        }

        public Criteria andChangeFeeEqualTo(Integer value) {
            addCriterion("change_fee =", value, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeNotEqualTo(Integer value) {
            addCriterion("change_fee <>", value, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeGreaterThan(Integer value) {
            addCriterion("change_fee >", value, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_fee >=", value, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeLessThan(Integer value) {
            addCriterion("change_fee <", value, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeLessThanOrEqualTo(Integer value) {
            addCriterion("change_fee <=", value, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeIn(List<Integer> values) {
            addCriterion("change_fee in", values, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeNotIn(List<Integer> values) {
            addCriterion("change_fee not in", values, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeBetween(Integer value1, Integer value2) {
            addCriterion("change_fee between", value1, value2, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("change_fee not between", value1, value2, "changeFee");
            return (Criteria) this;
        }

        public Criteria andChangeTextIsNull() {
            addCriterion("change_text is null");
            return (Criteria) this;
        }

        public Criteria andChangeTextIsNotNull() {
            addCriterion("change_text is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTextEqualTo(String value) {
            addCriterion("change_text =", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextNotEqualTo(String value) {
            addCriterion("change_text <>", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextGreaterThan(String value) {
            addCriterion("change_text >", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextGreaterThanOrEqualTo(String value) {
            addCriterion("change_text >=", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextLessThan(String value) {
            addCriterion("change_text <", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextLessThanOrEqualTo(String value) {
            addCriterion("change_text <=", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextLike(String value) {
            addCriterion("change_text like", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextNotLike(String value) {
            addCriterion("change_text not like", value, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextIn(List<String> values) {
            addCriterion("change_text in", values, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextNotIn(List<String> values) {
            addCriterion("change_text not in", values, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextBetween(String value1, String value2) {
            addCriterion("change_text between", value1, value2, "changeText");
            return (Criteria) this;
        }

        public Criteria andChangeTextNotBetween(String value1, String value2) {
            addCriterion("change_text not between", value1, value2, "changeText");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(String value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(String value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(String value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(String value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(String value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLike(String value) {
            addCriterion("pay_id like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotLike(String value) {
            addCriterion("pay_id not like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<String> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<String> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(String value1, String value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(String value1, String value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Integer value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Integer value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Integer value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Integer value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Integer> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Integer> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(String value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(String value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(String value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(String value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(String value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLike(String value) {
            addCriterion("pay_time like", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotLike(String value) {
            addCriterion("pay_time not like", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<String> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<String> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(String value1, String value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(String value1, String value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineIsNull() {
            addCriterion("pay_deadline is null");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineIsNotNull() {
            addCriterion("pay_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineEqualTo(String value) {
            addCriterion("pay_deadline =", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineNotEqualTo(String value) {
            addCriterion("pay_deadline <>", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineGreaterThan(String value) {
            addCriterion("pay_deadline >", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("pay_deadline >=", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineLessThan(String value) {
            addCriterion("pay_deadline <", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineLessThanOrEqualTo(String value) {
            addCriterion("pay_deadline <=", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineLike(String value) {
            addCriterion("pay_deadline like", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineNotLike(String value) {
            addCriterion("pay_deadline not like", value, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineIn(List<String> values) {
            addCriterion("pay_deadline in", values, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineNotIn(List<String> values) {
            addCriterion("pay_deadline not in", values, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineBetween(String value1, String value2) {
            addCriterion("pay_deadline between", value1, value2, "payDeadline");
            return (Criteria) this;
        }

        public Criteria andPayDeadlineNotBetween(String value1, String value2) {
            addCriterion("pay_deadline not between", value1, value2, "payDeadline");
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

        public Criteria andContactNumIsNull() {
            addCriterion("contact_num is null");
            return (Criteria) this;
        }

        public Criteria andContactNumIsNotNull() {
            addCriterion("contact_num is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumEqualTo(String value) {
            addCriterion("contact_num =", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumNotEqualTo(String value) {
            addCriterion("contact_num <>", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumGreaterThan(String value) {
            addCriterion("contact_num >", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumGreaterThanOrEqualTo(String value) {
            addCriterion("contact_num >=", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumLessThan(String value) {
            addCriterion("contact_num <", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumLessThanOrEqualTo(String value) {
            addCriterion("contact_num <=", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumLike(String value) {
            addCriterion("contact_num like", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumNotLike(String value) {
            addCriterion("contact_num not like", value, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumIn(List<String> values) {
            addCriterion("contact_num in", values, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumNotIn(List<String> values) {
            addCriterion("contact_num not in", values, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumBetween(String value1, String value2) {
            addCriterion("contact_num between", value1, value2, "contactNum");
            return (Criteria) this;
        }

        public Criteria andContactNumNotBetween(String value1, String value2) {
            addCriterion("contact_num not between", value1, value2, "contactNum");
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

        public Criteria andHasShowIsNull() {
            addCriterion("has_show is null");
            return (Criteria) this;
        }

        public Criteria andHasShowIsNotNull() {
            addCriterion("has_show is not null");
            return (Criteria) this;
        }

        public Criteria andHasShowEqualTo(Integer value) {
            addCriterion("has_show =", value, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowNotEqualTo(Integer value) {
            addCriterion("has_show <>", value, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowGreaterThan(Integer value) {
            addCriterion("has_show >", value, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_show >=", value, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowLessThan(Integer value) {
            addCriterion("has_show <", value, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowLessThanOrEqualTo(Integer value) {
            addCriterion("has_show <=", value, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowIn(List<Integer> values) {
            addCriterion("has_show in", values, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowNotIn(List<Integer> values) {
            addCriterion("has_show not in", values, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowBetween(Integer value1, Integer value2) {
            addCriterion("has_show between", value1, value2, "hasShow");
            return (Criteria) this;
        }

        public Criteria andHasShowNotBetween(Integer value1, Integer value2) {
            addCriterion("has_show not between", value1, value2, "hasShow");
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

        public Criteria andPackNameLikeInsensitive(String value) {
            addCriterion("upper(pack_name) like", value.toUpperCase(), "packName");
            return this;
        }

        public Criteria andGoFlightNumLikeInsensitive(String value) {
            addCriterion("upper(go_flight_num) like", value.toUpperCase(), "goFlightNum");
            return this;
        }

        public Criteria andGoActFlightNumLikeInsensitive(String value) {
            addCriterion("upper(go_act_flight_num) like", value.toUpperCase(), "goActFlightNum");
            return this;
        }

        public Criteria andGoFlightTimeLikeInsensitive(String value) {
            addCriterion("upper(go_flight_time) like", value.toUpperCase(), "goFlightTime");
            return this;
        }

        public Criteria andGoCarrierCodeLikeInsensitive(String value) {
            addCriterion("upper(go_carrier_code) like", value.toUpperCase(), "goCarrierCode");
            return this;
        }

        public Criteria andGoCarrierNameLikeInsensitive(String value) {
            addCriterion("upper(go_carrier_name) like", value.toUpperCase(), "goCarrierName");
            return this;
        }

        public Criteria andGoCabinLikeInsensitive(String value) {
            addCriterion("upper(go_cabin) like", value.toUpperCase(), "goCabin");
            return this;
        }

        public Criteria andGoDeptCityLikeInsensitive(String value) {
            addCriterion("upper(go_dept_city) like", value.toUpperCase(), "goDeptCity");
            return this;
        }

        public Criteria andGoArriCityLikeInsensitive(String value) {
            addCriterion("upper(go_arri_city) like", value.toUpperCase(), "goArriCity");
            return this;
        }

        public Criteria andGoDeptAirportCodeLikeInsensitive(String value) {
            addCriterion("upper(go_dept_airport_code) like", value.toUpperCase(), "goDeptAirportCode");
            return this;
        }

        public Criteria andGoArriAirportCodeLikeInsensitive(String value) {
            addCriterion("upper(go_arri_airport_code) like", value.toUpperCase(), "goArriAirportCode");
            return this;
        }

        public Criteria andGoDeptAirportNameLikeInsensitive(String value) {
            addCriterion("upper(go_dept_airport_name) like", value.toUpperCase(), "goDeptAirportName");
            return this;
        }

        public Criteria andGoArriAirportNameLikeInsensitive(String value) {
            addCriterion("upper(go_arri_airport_name) like", value.toUpperCase(), "goArriAirportName");
            return this;
        }

        public Criteria andGoDeptTerminalLikeInsensitive(String value) {
            addCriterion("upper(go_dept_terminal) like", value.toUpperCase(), "goDeptTerminal");
            return this;
        }

        public Criteria andGoArriTerminalLikeInsensitive(String value) {
            addCriterion("upper(go_arri_terminal) like", value.toUpperCase(), "goArriTerminal");
            return this;
        }

        public Criteria andGoDeptDateLikeInsensitive(String value) {
            addCriterion("upper(go_dept_date) like", value.toUpperCase(), "goDeptDate");
            return this;
        }

        public Criteria andGoDeptTimeLikeInsensitive(String value) {
            addCriterion("upper(go_dept_time) like", value.toUpperCase(), "goDeptTime");
            return this;
        }

        public Criteria andGoArriTimeLikeInsensitive(String value) {
            addCriterion("upper(go_arri_time) like", value.toUpperCase(), "goArriTime");
            return this;
        }

        public Criteria andBackFlightNumLikeInsensitive(String value) {
            addCriterion("upper(back_flight_num) like", value.toUpperCase(), "backFlightNum");
            return this;
        }

        public Criteria andBackActFlightNumLikeInsensitive(String value) {
            addCriterion("upper(back_act_flight_num) like", value.toUpperCase(), "backActFlightNum");
            return this;
        }

        public Criteria andBackFlightTimeLikeInsensitive(String value) {
            addCriterion("upper(back_flight_time) like", value.toUpperCase(), "backFlightTime");
            return this;
        }

        public Criteria andBackCarrierCodeLikeInsensitive(String value) {
            addCriterion("upper(back_carrier_code) like", value.toUpperCase(), "backCarrierCode");
            return this;
        }

        public Criteria andBackCarrierNameLikeInsensitive(String value) {
            addCriterion("upper(back_carrier_name) like", value.toUpperCase(), "backCarrierName");
            return this;
        }

        public Criteria andBackCabinLikeInsensitive(String value) {
            addCriterion("upper(back_cabin) like", value.toUpperCase(), "backCabin");
            return this;
        }

        public Criteria andBackDeptCityLikeInsensitive(String value) {
            addCriterion("upper(back_dept_city) like", value.toUpperCase(), "backDeptCity");
            return this;
        }

        public Criteria andBackArriCityLikeInsensitive(String value) {
            addCriterion("upper(back_arri_city) like", value.toUpperCase(), "backArriCity");
            return this;
        }

        public Criteria andBackDeptAirportCodeLikeInsensitive(String value) {
            addCriterion("upper(back_dept_airport_code) like", value.toUpperCase(), "backDeptAirportCode");
            return this;
        }

        public Criteria andBackArriAirportCodeLikeInsensitive(String value) {
            addCriterion("upper(back_arri_airport_code) like", value.toUpperCase(), "backArriAirportCode");
            return this;
        }

        public Criteria andBackDeptAirportNameLikeInsensitive(String value) {
            addCriterion("upper(back_dept_airport_name) like", value.toUpperCase(), "backDeptAirportName");
            return this;
        }

        public Criteria andBackArriAirportNameLikeInsensitive(String value) {
            addCriterion("upper(back_arri_airport_name) like", value.toUpperCase(), "backArriAirportName");
            return this;
        }

        public Criteria andBackDeptTerminalLikeInsensitive(String value) {
            addCriterion("upper(back_dept_terminal) like", value.toUpperCase(), "backDeptTerminal");
            return this;
        }

        public Criteria andBackArriTerminalLikeInsensitive(String value) {
            addCriterion("upper(back_arri_terminal) like", value.toUpperCase(), "backArriTerminal");
            return this;
        }

        public Criteria andBackDeptDateLikeInsensitive(String value) {
            addCriterion("upper(back_dept_date) like", value.toUpperCase(), "backDeptDate");
            return this;
        }

        public Criteria andBackDeptTimeLikeInsensitive(String value) {
            addCriterion("upper(back_dept_time) like", value.toUpperCase(), "backDeptTime");
            return this;
        }

        public Criteria andBackArriTimeLikeInsensitive(String value) {
            addCriterion("upper(back_arri_time) like", value.toUpperCase(), "backArriTime");
            return this;
        }

        public Criteria andReturnTextLikeInsensitive(String value) {
            addCriterion("upper(return_text) like", value.toUpperCase(), "returnText");
            return this;
        }

        public Criteria andChangeTextLikeInsensitive(String value) {
            addCriterion("upper(change_text) like", value.toUpperCase(), "changeText");
            return this;
        }

        public Criteria andPayIdLikeInsensitive(String value) {
            addCriterion("upper(pay_id) like", value.toUpperCase(), "payId");
            return this;
        }

        public Criteria andPayTimeLikeInsensitive(String value) {
            addCriterion("upper(pay_time) like", value.toUpperCase(), "payTime");
            return this;
        }

        public Criteria andPayDeadlineLikeInsensitive(String value) {
            addCriterion("upper(pay_deadline) like", value.toUpperCase(), "payDeadline");
            return this;
        }

        public Criteria andContactNameLikeInsensitive(String value) {
            addCriterion("upper(contact_name) like", value.toUpperCase(), "contactName");
            return this;
        }

        public Criteria andContactNumLikeInsensitive(String value) {
            addCriterion("upper(contact_num) like", value.toUpperCase(), "contactNum");
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