package com.mai.tcm.model;

import java.util.ArrayList;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andNewsIDIsNull() {
            addCriterion("newsID is null");
            return (Criteria) this;
        }

        public Criteria andNewsIDIsNotNull() {
            addCriterion("newsID is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIDEqualTo(String value) {
            addCriterion("newsID =", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDNotEqualTo(String value) {
            addCriterion("newsID <>", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDGreaterThan(String value) {
            addCriterion("newsID >", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDGreaterThanOrEqualTo(String value) {
            addCriterion("newsID >=", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDLessThan(String value) {
            addCriterion("newsID <", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDLessThanOrEqualTo(String value) {
            addCriterion("newsID <=", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDLike(String value) {
            addCriterion("newsID like", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDNotLike(String value) {
            addCriterion("newsID not like", value, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDIn(List<String> values) {
            addCriterion("newsID in", values, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDNotIn(List<String> values) {
            addCriterion("newsID not in", values, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDBetween(String value1, String value2) {
            addCriterion("newsID between", value1, value2, "newsID");
            return (Criteria) this;
        }

        public Criteria andNewsIDNotBetween(String value1, String value2) {
            addCriterion("newsID not between", value1, value2, "newsID");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("targetType is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("targetType is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(Integer value) {
            addCriterion("targetType =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(Integer value) {
            addCriterion("targetType <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(Integer value) {
            addCriterion("targetType >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("targetType >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(Integer value) {
            addCriterion("targetType <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("targetType <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<Integer> values) {
            addCriterion("targetType in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<Integer> values) {
            addCriterion("targetType not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(Integer value1, Integer value2) {
            addCriterion("targetType between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("targetType not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetParameterIsNull() {
            addCriterion("targetParameter is null");
            return (Criteria) this;
        }

        public Criteria andTargetParameterIsNotNull() {
            addCriterion("targetParameter is not null");
            return (Criteria) this;
        }

        public Criteria andTargetParameterEqualTo(String value) {
            addCriterion("targetParameter =", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterNotEqualTo(String value) {
            addCriterion("targetParameter <>", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterGreaterThan(String value) {
            addCriterion("targetParameter >", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterGreaterThanOrEqualTo(String value) {
            addCriterion("targetParameter >=", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterLessThan(String value) {
            addCriterion("targetParameter <", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterLessThanOrEqualTo(String value) {
            addCriterion("targetParameter <=", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterLike(String value) {
            addCriterion("targetParameter like", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterNotLike(String value) {
            addCriterion("targetParameter not like", value, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterIn(List<String> values) {
            addCriterion("targetParameter in", values, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterNotIn(List<String> values) {
            addCriterion("targetParameter not in", values, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterBetween(String value1, String value2) {
            addCriterion("targetParameter between", value1, value2, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andTargetParameterNotBetween(String value1, String value2) {
            addCriterion("targetParameter not between", value1, value2, "targetParameter");
            return (Criteria) this;
        }

        public Criteria andAbstractsIsNull() {
            addCriterion("abstracts is null");
            return (Criteria) this;
        }

        public Criteria andAbstractsIsNotNull() {
            addCriterion("abstracts is not null");
            return (Criteria) this;
        }

        public Criteria andAbstractsEqualTo(String value) {
            addCriterion("abstracts =", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsNotEqualTo(String value) {
            addCriterion("abstracts <>", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsGreaterThan(String value) {
            addCriterion("abstracts >", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsGreaterThanOrEqualTo(String value) {
            addCriterion("abstracts >=", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsLessThan(String value) {
            addCriterion("abstracts <", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsLessThanOrEqualTo(String value) {
            addCriterion("abstracts <=", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsLike(String value) {
            addCriterion("abstracts like", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsNotLike(String value) {
            addCriterion("abstracts not like", value, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsIn(List<String> values) {
            addCriterion("abstracts in", values, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsNotIn(List<String> values) {
            addCriterion("abstracts not in", values, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsBetween(String value1, String value2) {
            addCriterion("abstracts between", value1, value2, "abstracts");
            return (Criteria) this;
        }

        public Criteria andAbstractsNotBetween(String value1, String value2) {
            addCriterion("abstracts not between", value1, value2, "abstracts");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDIsNull() {
            addCriterion("createPersonID is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDIsNotNull() {
            addCriterion("createPersonID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDEqualTo(String value) {
            addCriterion("createPersonID =", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDNotEqualTo(String value) {
            addCriterion("createPersonID <>", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDGreaterThan(String value) {
            addCriterion("createPersonID >", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDGreaterThanOrEqualTo(String value) {
            addCriterion("createPersonID >=", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDLessThan(String value) {
            addCriterion("createPersonID <", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDLessThanOrEqualTo(String value) {
            addCriterion("createPersonID <=", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDLike(String value) {
            addCriterion("createPersonID like", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDNotLike(String value) {
            addCriterion("createPersonID not like", value, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDIn(List<String> values) {
            addCriterion("createPersonID in", values, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDNotIn(List<String> values) {
            addCriterion("createPersonID not in", values, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDBetween(String value1, String value2) {
            addCriterion("createPersonID between", value1, value2, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIDNotBetween(String value1, String value2) {
            addCriterion("createPersonID not between", value1, value2, "createPersonID");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameIsNull() {
            addCriterion("createPersonName is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameIsNotNull() {
            addCriterion("createPersonName is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameEqualTo(String value) {
            addCriterion("createPersonName =", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotEqualTo(String value) {
            addCriterion("createPersonName <>", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameGreaterThan(String value) {
            addCriterion("createPersonName >", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("createPersonName >=", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameLessThan(String value) {
            addCriterion("createPersonName <", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameLessThanOrEqualTo(String value) {
            addCriterion("createPersonName <=", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameLike(String value) {
            addCriterion("createPersonName like", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotLike(String value) {
            addCriterion("createPersonName not like", value, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameIn(List<String> values) {
            addCriterion("createPersonName in", values, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotIn(List<String> values) {
            addCriterion("createPersonName not in", values, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameBetween(String value1, String value2) {
            addCriterion("createPersonName between", value1, value2, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNameNotBetween(String value1, String value2) {
            addCriterion("createPersonName not between", value1, value2, "createPersonName");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSortNOIsNull() {
            addCriterion("sortNO is null");
            return (Criteria) this;
        }

        public Criteria andSortNOIsNotNull() {
            addCriterion("sortNO is not null");
            return (Criteria) this;
        }

        public Criteria andSortNOEqualTo(Integer value) {
            addCriterion("sortNO =", value, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNONotEqualTo(Integer value) {
            addCriterion("sortNO <>", value, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNOGreaterThan(Integer value) {
            addCriterion("sortNO >", value, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNOGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortNO >=", value, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNOLessThan(Integer value) {
            addCriterion("sortNO <", value, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNOLessThanOrEqualTo(Integer value) {
            addCriterion("sortNO <=", value, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNOIn(List<Integer> values) {
            addCriterion("sortNO in", values, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNONotIn(List<Integer> values) {
            addCriterion("sortNO not in", values, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNOBetween(Integer value1, Integer value2) {
            addCriterion("sortNO between", value1, value2, "sortNO");
            return (Criteria) this;
        }

        public Criteria andSortNONotBetween(Integer value1, Integer value2) {
            addCriterion("sortNO not between", value1, value2, "sortNO");
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