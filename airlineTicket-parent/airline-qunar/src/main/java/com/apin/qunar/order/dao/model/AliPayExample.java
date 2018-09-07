package com.apin.qunar.order.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AliPayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public AliPayExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderIsNull() {
            addCriterion("has_inland_order is null");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderIsNotNull() {
            addCriterion("has_inland_order is not null");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderEqualTo(Integer value) {
            addCriterion("has_inland_order =", value, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderNotEqualTo(Integer value) {
            addCriterion("has_inland_order <>", value, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderGreaterThan(Integer value) {
            addCriterion("has_inland_order >", value, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_inland_order >=", value, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderLessThan(Integer value) {
            addCriterion("has_inland_order <", value, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderLessThanOrEqualTo(Integer value) {
            addCriterion("has_inland_order <=", value, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderIn(List<Integer> values) {
            addCriterion("has_inland_order in", values, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderNotIn(List<Integer> values) {
            addCriterion("has_inland_order not in", values, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderBetween(Integer value1, Integer value2) {
            addCriterion("has_inland_order between", value1, value2, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andHasInlandOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("has_inland_order not between", value1, value2, "hasInlandOrder");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoIsNull() {
            addCriterion("alipay_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoIsNotNull() {
            addCriterion("alipay_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoEqualTo(String value) {
            addCriterion("alipay_trade_no =", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotEqualTo(String value) {
            addCriterion("alipay_trade_no <>", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoGreaterThan(String value) {
            addCriterion("alipay_trade_no >", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_trade_no >=", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoLessThan(String value) {
            addCriterion("alipay_trade_no <", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoLessThanOrEqualTo(String value) {
            addCriterion("alipay_trade_no <=", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoLike(String value) {
            addCriterion("alipay_trade_no like", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotLike(String value) {
            addCriterion("alipay_trade_no not like", value, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoIn(List<String> values) {
            addCriterion("alipay_trade_no in", values, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotIn(List<String> values) {
            addCriterion("alipay_trade_no not in", values, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoBetween(String value1, String value2) {
            addCriterion("alipay_trade_no between", value1, value2, "alipayTradeNo");
            return (Criteria) this;
        }

        public Criteria andAlipayTradeNoNotBetween(String value1, String value2) {
            addCriterion("alipay_trade_no not between", value1, value2, "alipayTradeNo");
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

        public Criteria andAliPayStatusIsNull() {
            addCriterion("ali_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusIsNotNull() {
            addCriterion("ali_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusEqualTo(Integer value) {
            addCriterion("ali_pay_status =", value, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusNotEqualTo(Integer value) {
            addCriterion("ali_pay_status <>", value, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusGreaterThan(Integer value) {
            addCriterion("ali_pay_status >", value, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ali_pay_status >=", value, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusLessThan(Integer value) {
            addCriterion("ali_pay_status <", value, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ali_pay_status <=", value, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusIn(List<Integer> values) {
            addCriterion("ali_pay_status in", values, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusNotIn(List<Integer> values) {
            addCriterion("ali_pay_status not in", values, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("ali_pay_status between", value1, value2, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ali_pay_status not between", value1, value2, "aliPayStatus");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeIsNull() {
            addCriterion("ali_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeIsNotNull() {
            addCriterion("ali_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeEqualTo(String value) {
            addCriterion("ali_pay_time =", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeNotEqualTo(String value) {
            addCriterion("ali_pay_time <>", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeGreaterThan(String value) {
            addCriterion("ali_pay_time >", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ali_pay_time >=", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeLessThan(String value) {
            addCriterion("ali_pay_time <", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeLessThanOrEqualTo(String value) {
            addCriterion("ali_pay_time <=", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeLike(String value) {
            addCriterion("ali_pay_time like", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeNotLike(String value) {
            addCriterion("ali_pay_time not like", value, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeIn(List<String> values) {
            addCriterion("ali_pay_time in", values, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeNotIn(List<String> values) {
            addCriterion("ali_pay_time not in", values, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeBetween(String value1, String value2) {
            addCriterion("ali_pay_time between", value1, value2, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andAliPayTimeNotBetween(String value1, String value2) {
            addCriterion("ali_pay_time not between", value1, value2, "aliPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusIsNull() {
            addCriterion("qunar_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusIsNotNull() {
            addCriterion("qunar_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusEqualTo(Integer value) {
            addCriterion("qunar_pay_status =", value, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusNotEqualTo(Integer value) {
            addCriterion("qunar_pay_status <>", value, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusGreaterThan(Integer value) {
            addCriterion("qunar_pay_status >", value, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("qunar_pay_status >=", value, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusLessThan(Integer value) {
            addCriterion("qunar_pay_status <", value, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("qunar_pay_status <=", value, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusIn(List<Integer> values) {
            addCriterion("qunar_pay_status in", values, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusNotIn(List<Integer> values) {
            addCriterion("qunar_pay_status not in", values, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("qunar_pay_status between", value1, value2, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("qunar_pay_status not between", value1, value2, "qunarPayStatus");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeIsNull() {
            addCriterion("qunar_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeIsNotNull() {
            addCriterion("qunar_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeEqualTo(String value) {
            addCriterion("qunar_pay_time =", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeNotEqualTo(String value) {
            addCriterion("qunar_pay_time <>", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeGreaterThan(String value) {
            addCriterion("qunar_pay_time >", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("qunar_pay_time >=", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeLessThan(String value) {
            addCriterion("qunar_pay_time <", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeLessThanOrEqualTo(String value) {
            addCriterion("qunar_pay_time <=", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeLike(String value) {
            addCriterion("qunar_pay_time like", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeNotLike(String value) {
            addCriterion("qunar_pay_time not like", value, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeIn(List<String> values) {
            addCriterion("qunar_pay_time in", values, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeNotIn(List<String> values) {
            addCriterion("qunar_pay_time not in", values, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeBetween(String value1, String value2) {
            addCriterion("qunar_pay_time between", value1, value2, "qunarPayTime");
            return (Criteria) this;
        }

        public Criteria andQunarPayTimeNotBetween(String value1, String value2) {
            addCriterion("qunar_pay_time not between", value1, value2, "qunarPayTime");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return this;
        }

        public Criteria andMerchantNoLikeInsensitive(String value) {
            addCriterion("upper(merchant_no) like", value.toUpperCase(), "merchantNo");
            return this;
        }

        public Criteria andOrderNoLikeInsensitive(String value) {
            addCriterion("upper(order_no) like", value.toUpperCase(), "orderNo");
            return this;
        }

        public Criteria andAlipayTradeNoLikeInsensitive(String value) {
            addCriterion("upper(alipay_trade_no) like", value.toUpperCase(), "alipayTradeNo");
            return this;
        }

        public Criteria andAliPayTimeLikeInsensitive(String value) {
            addCriterion("upper(ali_pay_time) like", value.toUpperCase(), "aliPayTime");
            return this;
        }

        public Criteria andQunarPayTimeLikeInsensitive(String value) {
            addCriterion("upper(qunar_pay_time) like", value.toUpperCase(), "qunarPayTime");
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