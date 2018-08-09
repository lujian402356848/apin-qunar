package com.apin.qunar.order.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NationalPayFailOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public NationalPayFailOrderExample() {
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

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
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

        public Criteria andPayChannelIsNull() {
            addCriterion("pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNotNull() {
            addCriterion("pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelEqualTo(Integer value) {
            addCriterion("pay_channel =", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotEqualTo(Integer value) {
            addCriterion("pay_channel <>", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThan(Integer value) {
            addCriterion("pay_channel >", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_channel >=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThan(Integer value) {
            addCriterion("pay_channel <", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThanOrEqualTo(Integer value) {
            addCriterion("pay_channel <=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIn(List<Integer> values) {
            addCriterion("pay_channel in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotIn(List<Integer> values) {
            addCriterion("pay_channel not in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelBetween(Integer value1, Integer value2) {
            addCriterion("pay_channel between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_channel not between", value1, value2, "payChannel");
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

        public Criteria andProcessDepartmentIsNull() {
            addCriterion("process_department is null");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentIsNotNull() {
            addCriterion("process_department is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentEqualTo(String value) {
            addCriterion("process_department =", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentNotEqualTo(String value) {
            addCriterion("process_department <>", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentGreaterThan(String value) {
            addCriterion("process_department >", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("process_department >=", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentLessThan(String value) {
            addCriterion("process_department <", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentLessThanOrEqualTo(String value) {
            addCriterion("process_department <=", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentLike(String value) {
            addCriterion("process_department like", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentNotLike(String value) {
            addCriterion("process_department not like", value, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentIn(List<String> values) {
            addCriterion("process_department in", values, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentNotIn(List<String> values) {
            addCriterion("process_department not in", values, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentBetween(String value1, String value2) {
            addCriterion("process_department between", value1, value2, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessDepartmentNotBetween(String value1, String value2) {
            addCriterion("process_department not between", value1, value2, "processDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountIsNull() {
            addCriterion("process_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountIsNotNull() {
            addCriterion("process_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountEqualTo(Integer value) {
            addCriterion("process_pay_amount =", value, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountNotEqualTo(Integer value) {
            addCriterion("process_pay_amount <>", value, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountGreaterThan(Integer value) {
            addCriterion("process_pay_amount >", value, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_pay_amount >=", value, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountLessThan(Integer value) {
            addCriterion("process_pay_amount <", value, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountLessThanOrEqualTo(Integer value) {
            addCriterion("process_pay_amount <=", value, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountIn(List<Integer> values) {
            addCriterion("process_pay_amount in", values, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountNotIn(List<Integer> values) {
            addCriterion("process_pay_amount not in", values, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountBetween(Integer value1, Integer value2) {
            addCriterion("process_pay_amount between", value1, value2, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPayAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("process_pay_amount not between", value1, value2, "processPayAmount");
            return (Criteria) this;
        }

        public Criteria andProcessPersonIsNull() {
            addCriterion("process_person is null");
            return (Criteria) this;
        }

        public Criteria andProcessPersonIsNotNull() {
            addCriterion("process_person is not null");
            return (Criteria) this;
        }

        public Criteria andProcessPersonEqualTo(String value) {
            addCriterion("process_person =", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonNotEqualTo(String value) {
            addCriterion("process_person <>", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonGreaterThan(String value) {
            addCriterion("process_person >", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonGreaterThanOrEqualTo(String value) {
            addCriterion("process_person >=", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonLessThan(String value) {
            addCriterion("process_person <", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonLessThanOrEqualTo(String value) {
            addCriterion("process_person <=", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonLike(String value) {
            addCriterion("process_person like", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonNotLike(String value) {
            addCriterion("process_person not like", value, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonIn(List<String> values) {
            addCriterion("process_person in", values, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonNotIn(List<String> values) {
            addCriterion("process_person not in", values, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonBetween(String value1, String value2) {
            addCriterion("process_person between", value1, value2, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessPersonNotBetween(String value1, String value2) {
            addCriterion("process_person not between", value1, value2, "processPerson");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("process_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("process_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(Integer value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(Integer value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(Integer value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(Integer value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(Integer value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<Integer> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<Integer> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(Integer value1, Integer value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("process_status not between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNull() {
            addCriterion("process_desc is null");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNotNull() {
            addCriterion("process_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDescEqualTo(String value) {
            addCriterion("process_desc =", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotEqualTo(String value) {
            addCriterion("process_desc <>", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThan(String value) {
            addCriterion("process_desc >", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThanOrEqualTo(String value) {
            addCriterion("process_desc >=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThan(String value) {
            addCriterion("process_desc <", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThanOrEqualTo(String value) {
            addCriterion("process_desc <=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLike(String value) {
            addCriterion("process_desc like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotLike(String value) {
            addCriterion("process_desc not like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescIn(List<String> values) {
            addCriterion("process_desc in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotIn(List<String> values) {
            addCriterion("process_desc not in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescBetween(String value1, String value2) {
            addCriterion("process_desc between", value1, value2, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotBetween(String value1, String value2) {
            addCriterion("process_desc not between", value1, value2, "processDesc");
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

        public Criteria andFlightNumLikeInsensitive(String value) {
            addCriterion("upper(flight_num) like", value.toUpperCase(), "flightNum");
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

        public Criteria andDeptDateLikeInsensitive(String value) {
            addCriterion("upper(dept_date) like", value.toUpperCase(), "deptDate");
            return this;
        }

        public Criteria andDeptTimeLikeInsensitive(String value) {
            addCriterion("upper(dept_time) like", value.toUpperCase(), "deptTime");
            return this;
        }

        public Criteria andPayTimeLikeInsensitive(String value) {
            addCriterion("upper(pay_time) like", value.toUpperCase(), "payTime");
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

        public Criteria andProcessDepartmentLikeInsensitive(String value) {
            addCriterion("upper(process_department) like", value.toUpperCase(), "processDepartment");
            return this;
        }

        public Criteria andProcessPersonLikeInsensitive(String value) {
            addCriterion("upper(process_person) like", value.toUpperCase(), "processPerson");
            return this;
        }

        public Criteria andProcessDescLikeInsensitive(String value) {
            addCriterion("upper(process_desc) like", value.toUpperCase(), "processDesc");
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