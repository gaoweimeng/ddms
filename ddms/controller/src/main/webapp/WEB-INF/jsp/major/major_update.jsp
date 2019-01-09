<%--
  Created by eclipse.
  User: songjunwei
  Date: 2018/9/21
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>专业数据更新管理</title>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <script type="text/javascript" src="/js/jquery-2.2.4-min.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <form class="layui-form" action="">
        <c:forEach items="${majorresult}" var="major">
            <input type="hidden" id="id" value="${major.id}"></input>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">专业名称</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="majorname" id="majorName" autocomplete="off"
                               class="layui-input" value="${major.majorName}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学院</label>
                    <div class="layui-input-inline">
                        <select name="collegeName" id="collegeName">
                            <c:forEach items="${collegename}" var="list">
                                <c:choose>
                                    <c:when test="${major.majorCollegeid==list.id}">
                                        <option value="${list.id}" selected>${list.collegeName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${list.id}">${list.collegeName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学科门类</label>
                    <div class="layui-input-inline">
                        <select name="majorDisciplinecategories" id="majorDisciplinecategories">
                        <c:forEach items="${subject}" var="sub">
                            <c:choose>
                                <c:when test="${major.majorDisciplinecategories==sub.name}">
                                    <option value="${sub.name}" selected>${sub.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${sub.name}">${sub.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学历</label>
                    <div class="layui-input-inline">
                        <select name="majorEducation" id="majorEducation" lay-verify="">
                            <c:forEach items="${education}" var="edu">
                                <c:choose>
                                    <c:when test="${major.majorEducation==edu.name}">
                                        <option value="${edu.name}">${edu.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${edu.name}">${edu.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学制</label>
                    <div class="layui-input-inline">
                        <select name="schoolsystem" id="schoolsystem" lay-verify="">
                            <option value="${major.schoolsystem}" selected>${major.schoolsystem}</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="8">8</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                    </div>
                </div>
        </c:forEach>
    </form>
</div>
</body>
<script type="text/javascript" src="/js/layui/layui.js"></script>
<script type="text/javascript" src="/js/major/major_update.js"></script>
</html>
