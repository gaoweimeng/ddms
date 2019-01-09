<%--
  Created by IntelliJ IDEA.
  User: 84261
  Date: 2018/9/22
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%@include file="/taglibs.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>查看</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/layui/css/layui.css">
    <script type="text/javascript" src="${ctx}/js/jquery-2.2.4-min.js"></script>
</head>
<body>
<div>
    <div class="layui-upload" style="position: fixed;top: 20px;right: 20px;z-index: 999">
        <label class="layui-form-label" style="text-align: left">照片</label>
        <div class="layui-upload-list">
            <img class="layui-upload-img" src="${oneStudent.data.stuPicture}" id="stuImg" width="92.7px" height="125px"
                 style="border: 1px solid red">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>学号</label>
            <div class="layui-input-block">
                <input type="text" name="id" id="id" autocomplete="off" lay-verify="required" class="layui-input"
                       value="${oneStudent.data.id}" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="stuName" id="stuName" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuName}" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>性别</label>
            <div class="layui-input-block">
                <input type="text" name="stuSex" id="stuSex" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuSex}" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>出生日期</label>
            <div class="layui-input-inline">
                <input type="text" name="stuBirthday" id="stuBirthday" autocomplete="off" lay-verify="required"
                       class="layui-input" value="<fmt:formatDate value='${oneStudent.data.stuBirthday}' pattern='yyyy-MM-dd' />" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>政治面貌</label>
            <div class="layui-input-block">
                <input type="text" name="stuPoliticalface" id="stuPoliticalface" autocomplete="off"
                       lay-verify="required" class="layui-input" value="${oneStudent.data.stuPoliticalface}" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>所属专业</label>
            <div class="layui-input-inline">
                <input type="text" name="majorName" id="majorName" autocomplete="off" class="layui-input"
                       value="${oneStudent.data.majorName}" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>入学时间</label>
            <div class="layui-input-block">
                <input type="text" name="stuEntranceTime" id="stuEntranceTime" autocomplete="off" lay-verify="required"
                       class="layui-input" value="<fmt:formatDate value='${oneStudent.data.stuEntranceTime}' pattern='yyyy-MM-dd' />" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>毕业时间</label>
            <div class="layui-input-inline">
                <input type="text" name="stuGraduationTime" id="stuGraduationTime" autocomplete="off" disabled
                       class="layui-input" value="<fmt:formatDate value='${oneStudent.data.stuGraduationTime}' pattern='yyyy-MM-dd' />">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>家庭电话</label>
            <div class="layui-input-block">
                <input type="text" name="stuFamilynumber" id="stuFamilynumber" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuFamilynumber}" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>家庭住址</label>
            <div class="layui-input-inline">
                <input type="text" name="stuAddress" id="stuAddress" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuAddress}" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>手机号</label>
            <div class="layui-input-block">
                <input type="text" name="stuPhone" id="stuPhone" autocomplete="off" lay-verify="required|phone"
                       class="layui-input" value="${oneStudent.data.stuPhone}" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>身份证</label>
            <div class="layui-input-inline">
                <input type="text" name="stuIdcard" id="stuIdcard" autocomplete="off" lay-verify="required|idCard"
                       class="layui-input" value="${oneStudent.data.stuIdcard}" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>民族</label>
            <div class="layui-input-block">
                <input type="text" name="stuNational" id="stuNational" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuNational}" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>状态</label>
            <div class="layui-input-inline">
                <input type="text" name="stuStatus" id="stuStatus" autocomplete="off" class="layui-input"
                       value="${oneStudent.data.stuStatus}" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">籍贯</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuNative == null}">
                    <input type="text" name="stuNative" id="stuNative" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuNative != null}">
                    <input type="text" name="stuNative" id="stuNative" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuNative}" disabled>
                </c:if>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">QQ帐号</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuQq == null}">
                    <input type="text" name="stuQq" id="stuQq" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuQq != null}">
                    <input type="text" name="stuQq" id="stuQq" autocomplete="off"
                    class="layui-input" value="${oneStudent.data.stuQq}" disabled>
                </c:if>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">生源省份</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuProvince == null}">
                    <input type="text" name="stuProvince" id="stuProvince" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuProvince != null}">
                    <input type="text" name="stuProvince" id="stuProvince" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuProvince}" disabled>
                </c:if>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">生源地区</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuSource == null}">
                    <input type="text" name="stuSource" id="stuSource" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuSource != null}">
                    <input type="text" name="stuSource" id="stuSource" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuSource}" disabled>
                </c:if>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">培养对象</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuCulobject == null}">
                    <input type="text" name="stuCulobject" id="stuCulobject" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuCulobject != null}">
                    <input type="text" name="stuCulobject" id="stuCulobject" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuCulobject}" disabled>
                </c:if>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">培养类别</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuCulcategory == null}">
                    <input type="text" name="stuCulcategory" id="stuCulcategory" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuCulcategory != null}">
                    <input type="text" name="stuCulcategory" id="stuCulcategory" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuCulcategory}" disabled>
                </c:if>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">毕业类别</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuGradcategory == null}">
                    <input type="text" name="stuGradcategory" id="stuGradcategory" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuGradcategory != null}">
                    <input type="text" name="stuGradcategory" id="stuGradcategory" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuGradcategory}" disabled>
                </c:if>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">考生类别</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuCandidatetype == null}">
                    <input type="text" name="stuCandidatetype" id="stuCandidatetype" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuCandidatetype != null}">
                    <input type="text" name="stuCandidatetype" id="stuCandidatetype" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuCandidatetype}" disabled>
                </c:if>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">办学类型</label>
            <div class="layui-input-block">
                <c:if test="${oneStudent.data.stuSchooltype == null}">
                    <input type="text" name="stuSchooltype" id="stuSchooltype" autocomplete="off"
                           class="layui-input" value="未添加" disabled>
                </c:if>
                <c:if test="${oneStudent.data.stuSchooltype != null}">
                    <input type="text" name="stuSchooltype" id="stuSchooltype" autocomplete="off"
                           class="layui-input" value="${oneStudent.data.stuSchooltype}" disabled>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
