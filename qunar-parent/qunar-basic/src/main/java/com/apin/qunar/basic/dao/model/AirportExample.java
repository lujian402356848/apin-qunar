package com.apin.qunar.basic.dao.model;

import java.util.ArrayList;
import java.util.List;

public class AirportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public AirportExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andAirportNameIsNull() {
            addCriterion("airport_name is null");
            return (Criteria) this;
        }

        public Criteria andAirportNameIsNotNull() {
            addCriterion("airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andAirportNameEqualTo(String value) {
            addCriterion("airport_name =", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotEqualTo(String value) {
            addCriterion("airport_name <>", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameGreaterThan(String value) {
            addCriterion("airport_name >", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("airport_name >=", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameLessThan(String value) {
            addCriterion("airport_name <", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameLessThanOrEqualTo(String value) {
            addCriterion("airport_name <=", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameLike(String value) {
            addCriterion("airport_name like", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotLike(String value) {
            addCriterion("airport_name not like", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameIn(List<String> values) {
            addCriterion("airport_name in", values, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotIn(List<String> values) {
            addCriterion("airport_name not in", values, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameBetween(String value1, String value2) {
            addCriterion("airport_name between", value1, value2, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotBetween(String value1, String value2) {
            addCriterion("airport_name not between", value1, value2, "airportName");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellIsNull() {
            addCriterion("complete_spell is null");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellIsNotNull() {
            addCriterion("complete_spell is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellEqualTo(String value) {
            addCriterion("complete_spell =", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellNotEqualTo(String value) {
            addCriterion("complete_spell <>", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellGreaterThan(String value) {
            addCriterion("complete_spell >", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellGreaterThanOrEqualTo(String value) {
            addCriterion("complete_spell >=", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellLessThan(String value) {
            addCriterion("complete_spell <", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellLessThanOrEqualTo(String value) {
            addCriterion("complete_spell <=", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellLike(String value) {
            addCriterion("complete_spell like", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellNotLike(String value) {
            addCriterion("complete_spell not like", value, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellIn(List<String> values) {
            addCriterion("complete_spell in", values, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellNotIn(List<String> values) {
            addCriterion("complete_spell not in", values, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellBetween(String value1, String value2) {
            addCriterion("complete_spell between", value1, value2, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andCompleteSpellNotBetween(String value1, String value2) {
            addCriterion("complete_spell not between", value1, value2, "completeSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellIsNull() {
            addCriterion("short_spell is null");
            return (Criteria) this;
        }

        public Criteria andShortSpellIsNotNull() {
            addCriterion("short_spell is not null");
            return (Criteria) this;
        }

        public Criteria andShortSpellEqualTo(String value) {
            addCriterion("short_spell =", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellNotEqualTo(String value) {
            addCriterion("short_spell <>", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellGreaterThan(String value) {
            addCriterion("short_spell >", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellGreaterThanOrEqualTo(String value) {
            addCriterion("short_spell >=", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellLessThan(String value) {
            addCriterion("short_spell <", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellLessThanOrEqualTo(String value) {
            addCriterion("short_spell <=", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellLike(String value) {
            addCriterion("short_spell like", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellNotLike(String value) {
            addCriterion("short_spell not like", value, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellIn(List<String> values) {
            addCriterion("short_spell in", values, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellNotIn(List<String> values) {
            addCriterion("short_spell not in", values, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellBetween(String value1, String value2) {
            addCriterion("short_spell between", value1, value2, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andShortSpellNotBetween(String value1, String value2) {
            addCriterion("short_spell not between", value1, value2, "shortSpell");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNull() {
            addCriterion("country_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNotNull() {
            addCriterion("country_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeEqualTo(String value) {
            addCriterion("country_code =", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotEqualTo(String value) {
            addCriterion("country_code <>", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThan(String value) {
            addCriterion("country_code >", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_code >=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThan(String value) {
            addCriterion("country_code <", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("country_code <=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLike(String value) {
            addCriterion("country_code like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotLike(String value) {
            addCriterion("country_code not like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIn(List<String> values) {
            addCriterion("country_code in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotIn(List<String> values) {
            addCriterion("country_code not in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeBetween(String value1, String value2) {
            addCriterion("country_code between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotBetween(String value1, String value2) {
            addCriterion("country_code not between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNull() {
            addCriterion("country_name is null");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNotNull() {
            addCriterion("country_name is not null");
            return (Criteria) this;
        }

        public Criteria andCountryNameEqualTo(String value) {
            addCriterion("country_name =", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotEqualTo(String value) {
            addCriterion("country_name <>", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThan(String value) {
            addCriterion("country_name >", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThanOrEqualTo(String value) {
            addCriterion("country_name >=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThan(String value) {
            addCriterion("country_name <", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThanOrEqualTo(String value) {
            addCriterion("country_name <=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLike(String value) {
            addCriterion("country_name like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotLike(String value) {
            addCriterion("country_name not like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameIn(List<String> values) {
            addCriterion("country_name in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotIn(List<String> values) {
            addCriterion("country_name not in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameBetween(String value1, String value2) {
            addCriterion("country_name between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotBetween(String value1, String value2) {
            addCriterion("country_name not between", value1, value2, "countryName");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andAirportCodeLikeInsensitive(String value) {
            addCriterion("upper(airport_code) like", value.toUpperCase(), "airportCode");
            return this;
        }

        public Criteria andAirportNameLikeInsensitive(String value) {
            addCriterion("upper(airport_name) like", value.toUpperCase(), "airportName");
            return this;
        }

        public Criteria andCompleteSpellLikeInsensitive(String value) {
            addCriterion("upper(complete_spell) like", value.toUpperCase(), "completeSpell");
            return this;
        }

        public Criteria andShortSpellLikeInsensitive(String value) {
            addCriterion("upper(short_spell) like", value.toUpperCase(), "shortSpell");
            return this;
        }

        public Criteria andCityNameLikeInsensitive(String value) {
            addCriterion("upper(city_name) like", value.toUpperCase(), "cityName");
            return this;
        }

        public Criteria andCountryCodeLikeInsensitive(String value) {
            addCriterion("upper(country_code) like", value.toUpperCase(), "countryCode");
            return this;
        }

        public Criteria andCountryNameLikeInsensitive(String value) {
            addCriterion("upper(country_name) like", value.toUpperCase(), "countryName");
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