package com.fendo.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;




/**   
 * @Title: BaseExample.java 
 * @Package com.fendo.mapper 
 * @Description: TODO
 * @author fendo
 * @date 2017年12月2日 下午6:30:47 
 * @version V1.0   
*/
public class BaseExample<T> {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    public BaseExample() {
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
    
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsridIsNull() {
            addCriterion("USRID is null");
            return (Criteria) this;
        }

        public Criteria andUsridIsNotNull() {
            addCriterion("USRID is not null");
            return (Criteria) this;
        }

        public Criteria andUsridEqualTo(String value) {
            addCriterion("USRID =", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotEqualTo(String value) {
            addCriterion("USRID <>", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThan(String value) {
            addCriterion("USRID >", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThanOrEqualTo(String value) {
            addCriterion("USRID >=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThan(String value) {
            addCriterion("USRID <", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThanOrEqualTo(String value) {
            addCriterion("USRID <=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLike(String value) {
            addCriterion("USRID like", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotLike(String value) {
            addCriterion("USRID not like", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridIn(List<String> values) {
            addCriterion("USRID in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotIn(List<String> values) {
            addCriterion("USRID not in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridBetween(String value1, String value2) {
            addCriterion("USRID between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotBetween(String value1, String value2) {
            addCriterion("USRID not between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andModulcodeIsNull() {
            addCriterion("MODULCODE is null");
            return (Criteria) this;
        }

        public Criteria andModulcodeIsNotNull() {
            addCriterion("MODULCODE is not null");
            return (Criteria) this;
        }

        public Criteria andModulcodeEqualTo(String value) {
            addCriterion("MODULCODE =", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeNotEqualTo(String value) {
            addCriterion("MODULCODE <>", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeGreaterThan(String value) {
            addCriterion("MODULCODE >", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeGreaterThanOrEqualTo(String value) {
            addCriterion("MODULCODE >=", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeLessThan(String value) {
            addCriterion("MODULCODE <", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeLessThanOrEqualTo(String value) {
            addCriterion("MODULCODE <=", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeLike(String value) {
            addCriterion("MODULCODE like", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeNotLike(String value) {
            addCriterion("MODULCODE not like", value, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeIn(List<String> values) {
            addCriterion("MODULCODE in", values, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeNotIn(List<String> values) {
            addCriterion("MODULCODE not in", values, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeBetween(String value1, String value2) {
            addCriterion("MODULCODE between", value1, value2, "modulcode");
            return (Criteria) this;
        }

        public Criteria andModulcodeNotBetween(String value1, String value2) {
            addCriterion("MODULCODE not between", value1, value2, "modulcode");
            return (Criteria) this;
        }

        public Criteria andDocidIsNull() {
            addCriterion("DOCID is null");
            return (Criteria) this;
        }

        public Criteria andDocidIsNotNull() {
            addCriterion("DOCID is not null");
            return (Criteria) this;
        }

        public Criteria andDocidEqualTo(String value) {
            addCriterion("DOCID =", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotEqualTo(String value) {
            addCriterion("DOCID <>", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidGreaterThan(String value) {
            addCriterion("DOCID >", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidGreaterThanOrEqualTo(String value) {
            addCriterion("DOCID >=", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidLessThan(String value) {
            addCriterion("DOCID <", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidLessThanOrEqualTo(String value) {
            addCriterion("DOCID <=", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidLike(String value) {
            addCriterion("DOCID like", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotLike(String value) {
            addCriterion("DOCID not like", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidIn(List<String> values) {
            addCriterion("DOCID in", values, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotIn(List<String> values) {
            addCriterion("DOCID not in", values, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidBetween(String value1, String value2) {
            addCriterion("DOCID between", value1, value2, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotBetween(String value1, String value2) {
            addCriterion("DOCID not between", value1, value2, "docid");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNull() {
            addCriterion("CREATENAME is null");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNotNull() {
            addCriterion("CREATENAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatenameEqualTo(String value) {
            addCriterion("CREATENAME =", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotEqualTo(String value) {
            addCriterion("CREATENAME <>", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThan(String value) {
            addCriterion("CREATENAME >", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATENAME >=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThan(String value) {
            addCriterion("CREATENAME <", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThanOrEqualTo(String value) {
            addCriterion("CREATENAME <=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLike(String value) {
            addCriterion("CREATENAME like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotLike(String value) {
            addCriterion("CREATENAME not like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameIn(List<String> values) {
            addCriterion("CREATENAME in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotIn(List<String> values) {
            addCriterion("CREATENAME not in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameBetween(String value1, String value2) {
            addCriterion("CREATENAME between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotBetween(String value1, String value2) {
            addCriterion("CREATENAME not between", value1, value2, "createname");
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

        private String typeHandler;

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

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

}
