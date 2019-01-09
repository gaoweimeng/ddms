package cn.wisdsoft.ddms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNull() {
            addCriterion("stu_sex is null");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNotNull() {
            addCriterion("stu_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStuSexEqualTo(String value) {
            addCriterion("stu_sex =", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotEqualTo(String value) {
            addCriterion("stu_sex <>", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThan(String value) {
            addCriterion("stu_sex >", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThanOrEqualTo(String value) {
            addCriterion("stu_sex >=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThan(String value) {
            addCriterion("stu_sex <", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThanOrEqualTo(String value) {
            addCriterion("stu_sex <=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLike(String value) {
            addCriterion("stu_sex like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotLike(String value) {
            addCriterion("stu_sex not like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexIn(List<String> values) {
            addCriterion("stu_sex in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotIn(List<String> values) {
            addCriterion("stu_sex not in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexBetween(String value1, String value2) {
            addCriterion("stu_sex between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotBetween(String value1, String value2) {
            addCriterion("stu_sex not between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNull() {
            addCriterion("stu_birthday is null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNotNull() {
            addCriterion("stu_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday =", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday <>", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_birthday >", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday >=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("stu_birthday <", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday <=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("stu_birthday in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_birthday not in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_birthday between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_birthday not between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuNativeIsNull() {
            addCriterion("stu_native is null");
            return (Criteria) this;
        }

        public Criteria andStuNativeIsNotNull() {
            addCriterion("stu_native is not null");
            return (Criteria) this;
        }

        public Criteria andStuNativeEqualTo(String value) {
            addCriterion("stu_native =", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeNotEqualTo(String value) {
            addCriterion("stu_native <>", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeGreaterThan(String value) {
            addCriterion("stu_native >", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeGreaterThanOrEqualTo(String value) {
            addCriterion("stu_native >=", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeLessThan(String value) {
            addCriterion("stu_native <", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeLessThanOrEqualTo(String value) {
            addCriterion("stu_native <=", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeLike(String value) {
            addCriterion("stu_native like", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeNotLike(String value) {
            addCriterion("stu_native not like", value, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeIn(List<String> values) {
            addCriterion("stu_native in", values, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeNotIn(List<String> values) {
            addCriterion("stu_native not in", values, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeBetween(String value1, String value2) {
            addCriterion("stu_native between", value1, value2, "stuNative");
            return (Criteria) this;
        }

        public Criteria andStuNativeNotBetween(String value1, String value2) {
            addCriterion("stu_native not between", value1, value2, "stuNative");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeIsNull() {
            addCriterion("stu_entranceTime is null");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeIsNotNull() {
            addCriterion("stu_entranceTime is not null");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeEqualTo(Date value) {
            addCriterionForJDBCDate("stu_entranceTime =", value, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_entranceTime <>", value, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_entranceTime >", value, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_entranceTime >=", value, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeLessThan(Date value) {
            addCriterionForJDBCDate("stu_entranceTime <", value, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_entranceTime <=", value, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeIn(List<Date> values) {
            addCriterionForJDBCDate("stu_entranceTime in", values, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_entranceTime not in", values, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_entranceTime between", value1, value2, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuEntranceTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_entranceTime not between", value1, value2, "stuEntranceTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeIsNull() {
            addCriterion("stu_graduationTime is null");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeIsNotNull() {
            addCriterion("stu_graduationTime is not null");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeEqualTo(Date value) {
            addCriterionForJDBCDate("stu_graduationTime =", value, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_graduationTime <>", value, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_graduationTime >", value, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_graduationTime >=", value, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeLessThan(Date value) {
            addCriterionForJDBCDate("stu_graduationTime <", value, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_graduationTime <=", value, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeIn(List<Date> values) {
            addCriterionForJDBCDate("stu_graduationTime in", values, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_graduationTime not in", values, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_graduationTime between", value1, value2, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andstuGraduationTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_graduationTime not between", value1, value2, "stuGraduationTime");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceIsNull() {
            addCriterion("stu_politicalFace is null");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceIsNotNull() {
            addCriterion("stu_politicalFace is not null");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceEqualTo(String value) {
            addCriterion("stu_politicalFace =", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceNotEqualTo(String value) {
            addCriterion("stu_politicalFace <>", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceGreaterThan(String value) {
            addCriterion("stu_politicalFace >", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceGreaterThanOrEqualTo(String value) {
            addCriterion("stu_politicalFace >=", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceLessThan(String value) {
            addCriterion("stu_politicalFace <", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceLessThanOrEqualTo(String value) {
            addCriterion("stu_politicalFace <=", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceLike(String value) {
            addCriterion("stu_politicalFace like", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceNotLike(String value) {
            addCriterion("stu_politicalFace not like", value, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceIn(List<String> values) {
            addCriterion("stu_politicalFace in", values, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceNotIn(List<String> values) {
            addCriterion("stu_politicalFace not in", values, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceBetween(String value1, String value2) {
            addCriterion("stu_politicalFace between", value1, value2, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuPoliticalfaceNotBetween(String value1, String value2) {
            addCriterion("stu_politicalFace not between", value1, value2, "stuPoliticalface");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberIsNull() {
            addCriterion("stu_familyNumber is null");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberIsNotNull() {
            addCriterion("stu_familyNumber is not null");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberEqualTo(String value) {
            addCriterion("stu_familyNumber =", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberNotEqualTo(String value) {
            addCriterion("stu_familyNumber <>", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberGreaterThan(String value) {
            addCriterion("stu_familyNumber >", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberGreaterThanOrEqualTo(String value) {
            addCriterion("stu_familyNumber >=", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberLessThan(String value) {
            addCriterion("stu_familyNumber <", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberLessThanOrEqualTo(String value) {
            addCriterion("stu_familyNumber <=", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberLike(String value) {
            addCriterion("stu_familyNumber like", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberNotLike(String value) {
            addCriterion("stu_familyNumber not like", value, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberIn(List<String> values) {
            addCriterion("stu_familyNumber in", values, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberNotIn(List<String> values) {
            addCriterion("stu_familyNumber not in", values, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberBetween(String value1, String value2) {
            addCriterion("stu_familyNumber between", value1, value2, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuFamilynumberNotBetween(String value1, String value2) {
            addCriterion("stu_familyNumber not between", value1, value2, "stuFamilynumber");
            return (Criteria) this;
        }

        public Criteria andStuAddressIsNull() {
            addCriterion("stu_address is null");
            return (Criteria) this;
        }

        public Criteria andStuAddressIsNotNull() {
            addCriterion("stu_address is not null");
            return (Criteria) this;
        }

        public Criteria andStuAddressEqualTo(String value) {
            addCriterion("stu_address =", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotEqualTo(String value) {
            addCriterion("stu_address <>", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressGreaterThan(String value) {
            addCriterion("stu_address >", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressGreaterThanOrEqualTo(String value) {
            addCriterion("stu_address >=", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLessThan(String value) {
            addCriterion("stu_address <", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLessThanOrEqualTo(String value) {
            addCriterion("stu_address <=", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLike(String value) {
            addCriterion("stu_address like", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotLike(String value) {
            addCriterion("stu_address not like", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressIn(List<String> values) {
            addCriterion("stu_address in", values, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotIn(List<String> values) {
            addCriterion("stu_address not in", values, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressBetween(String value1, String value2) {
            addCriterion("stu_address between", value1, value2, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotBetween(String value1, String value2) {
            addCriterion("stu_address not between", value1, value2, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNull() {
            addCriterion("stu_phone is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("stu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("stu_phone =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("stu_phone <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("stu_phone >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("stu_phone <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("stu_phone <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("stu_phone like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("stu_phone not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("stu_phone in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("stu_phone not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("stu_phone between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("stu_phone not between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuIdcardIsNull() {
            addCriterion("stu_idCard is null");
            return (Criteria) this;
        }

        public Criteria andStuIdcardIsNotNull() {
            addCriterion("stu_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdcardEqualTo(String value) {
            addCriterion("stu_idCard =", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotEqualTo(String value) {
            addCriterion("stu_idCard <>", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardGreaterThan(String value) {
            addCriterion("stu_idCard >", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("stu_idCard >=", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardLessThan(String value) {
            addCriterion("stu_idCard <", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardLessThanOrEqualTo(String value) {
            addCriterion("stu_idCard <=", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardLike(String value) {
            addCriterion("stu_idCard like", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotLike(String value) {
            addCriterion("stu_idCard not like", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardIn(List<String> values) {
            addCriterion("stu_idCard in", values, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotIn(List<String> values) {
            addCriterion("stu_idCard not in", values, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardBetween(String value1, String value2) {
            addCriterion("stu_idCard between", value1, value2, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotBetween(String value1, String value2) {
            addCriterion("stu_idCard not between", value1, value2, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdIsNull() {
            addCriterion("stu_majorId is null");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdIsNotNull() {
            addCriterion("stu_majorId is not null");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdEqualTo(String value) {
            addCriterion("stu_majorId =", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdNotEqualTo(String value) {
            addCriterion("stu_majorId <>", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdGreaterThan(String value) {
            addCriterion("stu_majorId >", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_majorId >=", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdLessThan(String value) {
            addCriterion("stu_majorId <", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdLessThanOrEqualTo(String value) {
            addCriterion("stu_majorId <=", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdLike(String value) {
            addCriterion("stu_majorId like", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdNotLike(String value) {
            addCriterion("stu_majorId not like", value, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdIn(List<String> values) {
            addCriterion("stu_majorId in", values, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdNotIn(List<String> values) {
            addCriterion("stu_majorId not in", values, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdBetween(String value1, String value2) {
            addCriterion("stu_majorId between", value1, value2, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andstuMajorIdNotBetween(String value1, String value2) {
            addCriterion("stu_majorId not between", value1, value2, "stuMajorId");
            return (Criteria) this;
        }

        public Criteria andStuNationalIsNull() {
            addCriterion("stu_national is null");
            return (Criteria) this;
        }

        public Criteria andStuNationalIsNotNull() {
            addCriterion("stu_national is not null");
            return (Criteria) this;
        }

        public Criteria andStuNationalEqualTo(String value) {
            addCriterion("stu_national =", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalNotEqualTo(String value) {
            addCriterion("stu_national <>", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalGreaterThan(String value) {
            addCriterion("stu_national >", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalGreaterThanOrEqualTo(String value) {
            addCriterion("stu_national >=", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalLessThan(String value) {
            addCriterion("stu_national <", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalLessThanOrEqualTo(String value) {
            addCriterion("stu_national <=", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalLike(String value) {
            addCriterion("stu_national like", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalNotLike(String value) {
            addCriterion("stu_national not like", value, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalIn(List<String> values) {
            addCriterion("stu_national in", values, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalNotIn(List<String> values) {
            addCriterion("stu_national not in", values, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalBetween(String value1, String value2) {
            addCriterion("stu_national between", value1, value2, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuNationalNotBetween(String value1, String value2) {
            addCriterion("stu_national not between", value1, value2, "stuNational");
            return (Criteria) this;
        }

        public Criteria andStuDelflagIsNull() {
            addCriterion("stu_delFlag is null");
            return (Criteria) this;
        }

        public Criteria andStuDelflagIsNotNull() {
            addCriterion("stu_delFlag is not null");
            return (Criteria) this;
        }

        public Criteria andStuDelflagEqualTo(Integer value) {
            addCriterion("stu_delFlag =", value, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagNotEqualTo(Integer value) {
            addCriterion("stu_delFlag <>", value, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagGreaterThan(Integer value) {
            addCriterion("stu_delFlag >", value, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_delFlag >=", value, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagLessThan(Integer value) {
            addCriterion("stu_delFlag <", value, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagLessThanOrEqualTo(Integer value) {
            addCriterion("stu_delFlag <=", value, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagIn(List<Integer> values) {
            addCriterion("stu_delFlag in", values, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagNotIn(List<Integer> values) {
            addCriterion("stu_delFlag not in", values, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagBetween(Integer value1, Integer value2) {
            addCriterion("stu_delFlag between", value1, value2, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuDelflagNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_delFlag not between", value1, value2, "stuDelflag");
            return (Criteria) this;
        }

        public Criteria andStuStatusIsNull() {
            addCriterion("stu_status is null");
            return (Criteria) this;
        }

        public Criteria andStuStatusIsNotNull() {
            addCriterion("stu_status is not null");
            return (Criteria) this;
        }

        public Criteria andStuStatusEqualTo(String value) {
            addCriterion("stu_status =", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotEqualTo(String value) {
            addCriterion("stu_status <>", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusGreaterThan(String value) {
            addCriterion("stu_status >", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusGreaterThanOrEqualTo(String value) {
            addCriterion("stu_status >=", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLessThan(String value) {
            addCriterion("stu_status <", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLessThanOrEqualTo(String value) {
            addCriterion("stu_status <=", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLike(String value) {
            addCriterion("stu_status like", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotLike(String value) {
            addCriterion("stu_status not like", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusIn(List<String> values) {
            addCriterion("stu_status in", values, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotIn(List<String> values) {
            addCriterion("stu_status not in", values, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusBetween(String value1, String value2) {
            addCriterion("stu_status between", value1, value2, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotBetween(String value1, String value2) {
            addCriterion("stu_status not between", value1, value2, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuProvinceIsNull() {
            addCriterion("stu_province is null");
            return (Criteria) this;
        }

        public Criteria andStuProvinceIsNotNull() {
            addCriterion("stu_province is not null");
            return (Criteria) this;
        }

        public Criteria andStuProvinceEqualTo(String value) {
            addCriterion("stu_province =", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceNotEqualTo(String value) {
            addCriterion("stu_province <>", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceGreaterThan(String value) {
            addCriterion("stu_province >", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("stu_province >=", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceLessThan(String value) {
            addCriterion("stu_province <", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceLessThanOrEqualTo(String value) {
            addCriterion("stu_province <=", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceLike(String value) {
            addCriterion("stu_province like", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceNotLike(String value) {
            addCriterion("stu_province not like", value, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceIn(List<String> values) {
            addCriterion("stu_province in", values, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceNotIn(List<String> values) {
            addCriterion("stu_province not in", values, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceBetween(String value1, String value2) {
            addCriterion("stu_province between", value1, value2, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuProvinceNotBetween(String value1, String value2) {
            addCriterion("stu_province not between", value1, value2, "stuProvince");
            return (Criteria) this;
        }

        public Criteria andStuSourceIsNull() {
            addCriterion("stu_source is null");
            return (Criteria) this;
        }

        public Criteria andStuSourceIsNotNull() {
            addCriterion("stu_source is not null");
            return (Criteria) this;
        }

        public Criteria andStuSourceEqualTo(String value) {
            addCriterion("stu_source =", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceNotEqualTo(String value) {
            addCriterion("stu_source <>", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceGreaterThan(String value) {
            addCriterion("stu_source >", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceGreaterThanOrEqualTo(String value) {
            addCriterion("stu_source >=", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceLessThan(String value) {
            addCriterion("stu_source <", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceLessThanOrEqualTo(String value) {
            addCriterion("stu_source <=", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceLike(String value) {
            addCriterion("stu_source like", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceNotLike(String value) {
            addCriterion("stu_source not like", value, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceIn(List<String> values) {
            addCriterion("stu_source in", values, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceNotIn(List<String> values) {
            addCriterion("stu_source not in", values, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceBetween(String value1, String value2) {
            addCriterion("stu_source between", value1, value2, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuSourceNotBetween(String value1, String value2) {
            addCriterion("stu_source not between", value1, value2, "stuSource");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectIsNull() {
            addCriterion("stu_culObject is null");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectIsNotNull() {
            addCriterion("stu_culObject is not null");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectEqualTo(String value) {
            addCriterion("stu_culObject =", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectNotEqualTo(String value) {
            addCriterion("stu_culObject <>", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectGreaterThan(String value) {
            addCriterion("stu_culObject >", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectGreaterThanOrEqualTo(String value) {
            addCriterion("stu_culObject >=", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectLessThan(String value) {
            addCriterion("stu_culObject <", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectLessThanOrEqualTo(String value) {
            addCriterion("stu_culObject <=", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectLike(String value) {
            addCriterion("stu_culObject like", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectNotLike(String value) {
            addCriterion("stu_culObject not like", value, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectIn(List<String> values) {
            addCriterion("stu_culObject in", values, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectNotIn(List<String> values) {
            addCriterion("stu_culObject not in", values, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectBetween(String value1, String value2) {
            addCriterion("stu_culObject between", value1, value2, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulobjectNotBetween(String value1, String value2) {
            addCriterion("stu_culObject not between", value1, value2, "stuCulobject");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryIsNull() {
            addCriterion("stu_culCategory is null");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryIsNotNull() {
            addCriterion("stu_culCategory is not null");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryEqualTo(String value) {
            addCriterion("stu_culCategory =", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryNotEqualTo(String value) {
            addCriterion("stu_culCategory <>", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryGreaterThan(String value) {
            addCriterion("stu_culCategory >", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("stu_culCategory >=", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryLessThan(String value) {
            addCriterion("stu_culCategory <", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryLessThanOrEqualTo(String value) {
            addCriterion("stu_culCategory <=", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryLike(String value) {
            addCriterion("stu_culCategory like", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryNotLike(String value) {
            addCriterion("stu_culCategory not like", value, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryIn(List<String> values) {
            addCriterion("stu_culCategory in", values, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryNotIn(List<String> values) {
            addCriterion("stu_culCategory not in", values, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryBetween(String value1, String value2) {
            addCriterion("stu_culCategory between", value1, value2, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuCulcategoryNotBetween(String value1, String value2) {
            addCriterion("stu_culCategory not between", value1, value2, "stuCulcategory");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeIsNull() {
            addCriterion("stu_schoolType is null");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeIsNotNull() {
            addCriterion("stu_schoolType is not null");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeEqualTo(String value) {
            addCriterion("stu_schoolType =", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeNotEqualTo(String value) {
            addCriterion("stu_schoolType <>", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeGreaterThan(String value) {
            addCriterion("stu_schoolType >", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeGreaterThanOrEqualTo(String value) {
            addCriterion("stu_schoolType >=", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeLessThan(String value) {
            addCriterion("stu_schoolType <", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeLessThanOrEqualTo(String value) {
            addCriterion("stu_schoolType <=", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeLike(String value) {
            addCriterion("stu_schoolType like", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeNotLike(String value) {
            addCriterion("stu_schoolType not like", value, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeIn(List<String> values) {
            addCriterion("stu_schoolType in", values, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeNotIn(List<String> values) {
            addCriterion("stu_schoolType not in", values, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeBetween(String value1, String value2) {
            addCriterion("stu_schoolType between", value1, value2, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuSchooltypeNotBetween(String value1, String value2) {
            addCriterion("stu_schoolType not between", value1, value2, "stuSchooltype");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryIsNull() {
            addCriterion("stu_gradCategory is null");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryIsNotNull() {
            addCriterion("stu_gradCategory is not null");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryEqualTo(String value) {
            addCriterion("stu_gradCategory =", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryNotEqualTo(String value) {
            addCriterion("stu_gradCategory <>", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryGreaterThan(String value) {
            addCriterion("stu_gradCategory >", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("stu_gradCategory >=", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryLessThan(String value) {
            addCriterion("stu_gradCategory <", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryLessThanOrEqualTo(String value) {
            addCriterion("stu_gradCategory <=", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryLike(String value) {
            addCriterion("stu_gradCategory like", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryNotLike(String value) {
            addCriterion("stu_gradCategory not like", value, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryIn(List<String> values) {
            addCriterion("stu_gradCategory in", values, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryNotIn(List<String> values) {
            addCriterion("stu_gradCategory not in", values, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryBetween(String value1, String value2) {
            addCriterion("stu_gradCategory between", value1, value2, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuGradcategoryNotBetween(String value1, String value2) {
            addCriterion("stu_gradCategory not between", value1, value2, "stuGradcategory");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeIsNull() {
            addCriterion("stu_candidateType is null");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeIsNotNull() {
            addCriterion("stu_candidateType is not null");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeEqualTo(String value) {
            addCriterion("stu_candidateType =", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeNotEqualTo(String value) {
            addCriterion("stu_candidateType <>", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeGreaterThan(String value) {
            addCriterion("stu_candidateType >", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("stu_candidateType >=", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeLessThan(String value) {
            addCriterion("stu_candidateType <", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeLessThanOrEqualTo(String value) {
            addCriterion("stu_candidateType <=", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeLike(String value) {
            addCriterion("stu_candidateType like", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeNotLike(String value) {
            addCriterion("stu_candidateType not like", value, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeIn(List<String> values) {
            addCriterion("stu_candidateType in", values, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeNotIn(List<String> values) {
            addCriterion("stu_candidateType not in", values, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeBetween(String value1, String value2) {
            addCriterion("stu_candidateType between", value1, value2, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuCandidatetypeNotBetween(String value1, String value2) {
            addCriterion("stu_candidateType not between", value1, value2, "stuCandidatetype");
            return (Criteria) this;
        }

        public Criteria andStuQqIsNull() {
            addCriterion("stu_QQ is null");
            return (Criteria) this;
        }

        public Criteria andStuQqIsNotNull() {
            addCriterion("stu_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andStuQqEqualTo(String value) {
            addCriterion("stu_QQ =", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotEqualTo(String value) {
            addCriterion("stu_QQ <>", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqGreaterThan(String value) {
            addCriterion("stu_QQ >", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqGreaterThanOrEqualTo(String value) {
            addCriterion("stu_QQ >=", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqLessThan(String value) {
            addCriterion("stu_QQ <", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqLessThanOrEqualTo(String value) {
            addCriterion("stu_QQ <=", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqLike(String value) {
            addCriterion("stu_QQ like", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotLike(String value) {
            addCriterion("stu_QQ not like", value, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqIn(List<String> values) {
            addCriterion("stu_QQ in", values, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotIn(List<String> values) {
            addCriterion("stu_QQ not in", values, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqBetween(String value1, String value2) {
            addCriterion("stu_QQ between", value1, value2, "stuQq");
            return (Criteria) this;
        }

        public Criteria andStuQqNotBetween(String value1, String value2) {
            addCriterion("stu_QQ not between", value1, value2, "stuQq");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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