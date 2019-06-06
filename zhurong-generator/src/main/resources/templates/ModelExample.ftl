package ${packageName};

import java.util.ArrayList;
import java.util.List;
<#if columnList?exists>
  <#list columnList as model>
    <#if model.type?? && model.type == "BigDecimal">
import java.math.BigDecimal;
      <#break>
    </#if>
  </#list>
</#if>
<#if columnList?exists>
  <#list columnList as model>
    <#if model.type??>
      <#if (model.type == "Timestamp" || model.type == "Time" || model.type == "Date")>
import java.util.Date;
        <#break>
      </#if>
    </#if>
  </#list>
</#if>

public class ${clazzName}Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ${clazzName}Example() {
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

        <#if columnList?exists>
          <#list columnList as model>

        public Criteria and${model.nameUp!}IsNull() {
            addCriterion("${model.originalName!} is null");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}IsNotNull() {
            addCriterion("${model.originalName!} is not null");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}EqualTo(${model.type!} value) {
            addCriterion("${model.originalName!} =", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}NotEqualTo(${model.type!} value) {
            addCriterion("${model.originalName!} <>", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}GreaterThan(${model.type!} value) {
            addCriterion("${model.originalName!} >", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}GreaterThanOrEqualTo(${model.type!} value) {
            addCriterion("${model.originalName!} >=", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}LessThan(${model.type!} value) {
            addCriterion("${model.originalName!} <", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}LessThanOrEqualTo(${model.type!} value) {
            addCriterion("${model.originalName!} <=", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}Like(${model.type!} value) {
            addCriterion("${model.originalName!} like", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}NotLike(${model.type!} value) {
            addCriterion("${model.originalName!} not like", value, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}In(List<${model.type!}> values) {
            addCriterion("${model.originalName!} in", values, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}NotIn(List<${model.type!}> values) {
            addCriterion("${model.originalName!} not in", values, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}Between(${model.type!} value1, ${model.type!} value2) {
            addCriterion("${model.originalName!} between", value1, value2, "${model.name!}");
            return (Criteria) this;
        }

        public Criteria and${model.nameUp!}NotBetween(${model.type!} value1, ${model.type!} value2) {
            addCriterion("${model.originalName!} not between", value1, value2, "${model.name!}");
            return (Criteria) this;
        }

          </#list>
        </#if>
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