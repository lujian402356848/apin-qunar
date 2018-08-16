package com.apin.qunar.order.dao.model;

import java.util.ArrayList;
import java.util.List;

public class NationalReimburseVoucherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public NationalReimburseVoucherExample() {
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

        public Criteria andReimburseTypeIsNull() {
            addCriterion("reimburse_type is null");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeIsNotNull() {
            addCriterion("reimburse_type is not null");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeEqualTo(Integer value) {
            addCriterion("reimburse_type =", value, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeNotEqualTo(Integer value) {
            addCriterion("reimburse_type <>", value, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeGreaterThan(Integer value) {
            addCriterion("reimburse_type >", value, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reimburse_type >=", value, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeLessThan(Integer value) {
            addCriterion("reimburse_type <", value, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reimburse_type <=", value, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeIn(List<Integer> values) {
            addCriterion("reimburse_type in", values, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeNotIn(List<Integer> values) {
            addCriterion("reimburse_type not in", values, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeBetween(Integer value1, Integer value2) {
            addCriterion("reimburse_type between", value1, value2, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andReimburseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reimburse_type not between", value1, value2, "reimburseType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeIsNull() {
            addCriterion("distribution_type is null");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeIsNotNull() {
            addCriterion("distribution_type is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeEqualTo(Integer value) {
            addCriterion("distribution_type =", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeNotEqualTo(Integer value) {
            addCriterion("distribution_type <>", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeGreaterThan(Integer value) {
            addCriterion("distribution_type >", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("distribution_type >=", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeLessThan(Integer value) {
            addCriterion("distribution_type <", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("distribution_type <=", value, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeIn(List<Integer> values) {
            addCriterion("distribution_type in", values, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeNotIn(List<Integer> values) {
            addCriterion("distribution_type not in", values, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeBetween(Integer value1, Integer value2) {
            addCriterion("distribution_type between", value1, value2, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("distribution_type not between", value1, value2, "distributionType");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountIsNull() {
            addCriterion("distribution_amount is null");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountIsNotNull() {
            addCriterion("distribution_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountEqualTo(Integer value) {
            addCriterion("distribution_amount =", value, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountNotEqualTo(Integer value) {
            addCriterion("distribution_amount <>", value, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountGreaterThan(Integer value) {
            addCriterion("distribution_amount >", value, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("distribution_amount >=", value, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountLessThan(Integer value) {
            addCriterion("distribution_amount <", value, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountLessThanOrEqualTo(Integer value) {
            addCriterion("distribution_amount <=", value, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountIn(List<Integer> values) {
            addCriterion("distribution_amount in", values, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountNotIn(List<Integer> values) {
            addCriterion("distribution_amount not in", values, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountBetween(Integer value1, Integer value2) {
            addCriterion("distribution_amount between", value1, value2, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andDistributionAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("distribution_amount not between", value1, value2, "distributionAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeIsNull() {
            addCriterion("invoice_title_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeIsNotNull() {
            addCriterion("invoice_title_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeEqualTo(Integer value) {
            addCriterion("invoice_title_type =", value, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeNotEqualTo(Integer value) {
            addCriterion("invoice_title_type <>", value, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeGreaterThan(Integer value) {
            addCriterion("invoice_title_type >", value, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_title_type >=", value, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeLessThan(Integer value) {
            addCriterion("invoice_title_type <", value, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_title_type <=", value, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeIn(List<Integer> values) {
            addCriterion("invoice_title_type in", values, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeNotIn(List<Integer> values) {
            addCriterion("invoice_title_type not in", values, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeBetween(Integer value1, Integer value2) {
            addCriterion("invoice_title_type between", value1, value2, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_title_type not between", value1, value2, "invoiceTitleType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentIsNull() {
            addCriterion("invoice_title_content is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentIsNotNull() {
            addCriterion("invoice_title_content is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentEqualTo(String value) {
            addCriterion("invoice_title_content =", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentNotEqualTo(String value) {
            addCriterion("invoice_title_content <>", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentGreaterThan(String value) {
            addCriterion("invoice_title_content >", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title_content >=", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentLessThan(String value) {
            addCriterion("invoice_title_content <", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentLessThanOrEqualTo(String value) {
            addCriterion("invoice_title_content <=", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentLike(String value) {
            addCriterion("invoice_title_content like", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentNotLike(String value) {
            addCriterion("invoice_title_content not like", value, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentIn(List<String> values) {
            addCriterion("invoice_title_content in", values, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentNotIn(List<String> values) {
            addCriterion("invoice_title_content not in", values, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentBetween(String value1, String value2) {
            addCriterion("invoice_title_content between", value1, value2, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleContentNotBetween(String value1, String value2) {
            addCriterion("invoice_title_content not between", value1, value2, "invoiceTitleContent");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoIsNull() {
            addCriterion("taxpayer_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoIsNotNull() {
            addCriterion("taxpayer_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoEqualTo(String value) {
            addCriterion("taxpayer_no =", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotEqualTo(String value) {
            addCriterion("taxpayer_no <>", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoGreaterThan(String value) {
            addCriterion("taxpayer_no >", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoGreaterThanOrEqualTo(String value) {
            addCriterion("taxpayer_no >=", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoLessThan(String value) {
            addCriterion("taxpayer_no <", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoLessThanOrEqualTo(String value) {
            addCriterion("taxpayer_no <=", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoLike(String value) {
            addCriterion("taxpayer_no like", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotLike(String value) {
            addCriterion("taxpayer_no not like", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoIn(List<String> values) {
            addCriterion("taxpayer_no in", values, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotIn(List<String> values) {
            addCriterion("taxpayer_no not in", values, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoBetween(String value1, String value2) {
            addCriterion("taxpayer_no between", value1, value2, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotBetween(String value1, String value2) {
            addCriterion("taxpayer_no not between", value1, value2, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoIsNull() {
            addCriterion("receiver_mobile_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoIsNotNull() {
            addCriterion("receiver_mobile_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoEqualTo(String value) {
            addCriterion("receiver_mobile_no =", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotEqualTo(String value) {
            addCriterion("receiver_mobile_no <>", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoGreaterThan(String value) {
            addCriterion("receiver_mobile_no >", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile_no >=", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoLessThan(String value) {
            addCriterion("receiver_mobile_no <", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile_no <=", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoLike(String value) {
            addCriterion("receiver_mobile_no like", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotLike(String value) {
            addCriterion("receiver_mobile_no not like", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoIn(List<String> values) {
            addCriterion("receiver_mobile_no in", values, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotIn(List<String> values) {
            addCriterion("receiver_mobile_no not in", values, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoBetween(String value1, String value2) {
            addCriterion("receiver_mobile_no between", value1, value2, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile_no not between", value1, value2, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("receive_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("receive_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("receive_address =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("receive_address <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("receive_address >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receive_address >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("receive_address <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("receive_address <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("receive_address like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("receive_address not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("receive_address in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("receive_address not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("receive_address between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("receive_address not between", value1, value2, "receiveAddress");
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

        public Criteria andInvoiceTitleContentLikeInsensitive(String value) {
            addCriterion("upper(invoice_title_content) like", value.toUpperCase(), "invoiceTitleContent");
            return this;
        }

        public Criteria andTaxpayerNoLikeInsensitive(String value) {
            addCriterion("upper(taxpayer_no) like", value.toUpperCase(), "taxpayerNo");
            return this;
        }

        public Criteria andReceiverNameLikeInsensitive(String value) {
            addCriterion("upper(receiver_name) like", value.toUpperCase(), "receiverName");
            return this;
        }

        public Criteria andReceiverMobileNoLikeInsensitive(String value) {
            addCriterion("upper(receiver_mobile_no) like", value.toUpperCase(), "receiverMobileNo");
            return this;
        }

        public Criteria andReceiveAddressLikeInsensitive(String value) {
            addCriterion("upper(receive_address) like", value.toUpperCase(), "receiveAddress");
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