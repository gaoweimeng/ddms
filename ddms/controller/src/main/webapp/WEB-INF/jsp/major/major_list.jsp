<%--
  Created by eclipse.
  User: songjunwei
  Date: 2018/9/20
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>专业管理</title>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <script type="text/javascript" src="/js/jquery-2.2.4-min.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <div class="demoTable" style="text-align: center; margin-top: 15px;">
        专业名称：
        <div class="layui-inline">
            <input class="layui-input" name="selmajorName" id="selmajorName" autocomplete="off">
        </div>
        学历：
        <div class="layui-inline">
            <input class="layui-input" name="selmajorEducation" id="selmajorEducation" autocomplete="off">
        </div>
        <button class="layui-btn" id="search" data-type="reload">搜索</button>
    </div>
    <div style="margin-top: 10px">
        <button class="layui-btn layui-btn-sm" id="filePath" name="filePath"><i class="layui-icon"></i>批量导入</button>
        <button class="layui-btn layui-btn-sm" id="exportAll">全部导出</button>
        <button class="layui-btn layui-btn-sm" id="download">下载模板</button>
        <button class="layui-btn layui-btn-sm" id="addmajor">增加</button>
    </div>
    <table id="major" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
</div>
</body>
<script type="text/javascript" src="/js/layui/layui.js"></script>
<script type="text/javascript" src="/js/major/major_list.js"></script>
</html>
