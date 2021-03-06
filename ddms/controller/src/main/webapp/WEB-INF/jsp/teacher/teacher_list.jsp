<%--
  User: 刘玉龙
  Date: 2018/9/19
  Time: 20:37
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>教师管理</title>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <script type="text/javascript" src="/js/jquery-2.2.4-min.js"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <div class="demoTable" style="text-align: center;margin-top: 15px;">
        请搜索：
        <div class="layui-inline">
            <input class="layui-input" id="search" autocomplete="off">
        </div>
        <button class="layui-btn" id="searchbtn" data-type="reload">搜索</button>
    </div>
</div>
<xblock>
    <button class="layui-btn layui-btn-sm" onclick="x_admin_show('添加教师','/teacher/add',1000,500)"><i class="layui-icon"></i>添加
    </button>
    <button class="layui-btn layui-btn-sm" id="importExcel">批量导入</button>
    <button class="layui-btn layui-btn-sm" id="downloadTheTemplate">下载模板</button>
    <button class="layui-btn layui-btn-sm" id="exportAll">导出</button>
</xblock>

<table class="layui-hide" id="teacher" lay-filter="test"></table>

</div>
</body>

<script type="text/javascript" src="/js/layui/layui.js"></script>

<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
</script>

<script src="/js/Base64.js"></script>

<script src="/js/teacher/teacher_list.js"></script>

</html>
