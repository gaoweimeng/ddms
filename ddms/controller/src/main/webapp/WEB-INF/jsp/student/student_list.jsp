<%--
  Created by IntelliJ IDEA.
  User: 84261
  Date: 2018/9/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学院管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx }/js/layui/css/layui.css">
    <script type="text/javascript" src="${ctx }/js/jquery-2.2.4-min.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <div class="listStudentTable layui-form" style="text-align: center;margin-top: 15px;">
        <div class="layui-inline">
            <input class="layui-input" id="myId" autocomplete="off" placeholder="请输入学号">
        </div>
        <div class="layui-inline">
            <input class="layui-input" id="myName" autocomplete="off" placeholder="请输入姓名">
        </div>
        <div class="layui-inline">
            <select name="myMajor" id="myMajor">
                <option value="" selected="selected">请选择专业</option>
                <c:forEach var="x" items="${allMajor}">
                    <option value="${x.id}">${x.majorName}</option>
                </c:forEach>
            </select>
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
    <div class="layui-btn-container" style="margin-top: 20px;">
        <button class="layui-btn layui-btn-sm" id="importExcel">批量导入</button>
        <button class="layui-btn layui-btn-sm" id="downloadTheTemplate">下载模板</button>
        <button class="layui-btn layui-btn-sm" id="theBatchExport">批量导出</button>
        <button class="layui-btn layui-btn-sm" id="dataRecovery">数据恢复</button>
        <button class="layui-btn layui-btn-sm" id="addStudent"><i class="layui-icon">&#xe61f;</i>添加</button>
    </div>
    <table id="student" lay-filter="test"></table>
</div>
</body>
<script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#student' //指定原始表格元素选择器（推荐id选择器）
            , url: 'http://localhost:8080/student/selectAllStudent?delFlag=0'
            , title: '学生表'
            , id: 'listTable'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}  //选择框i
                , {field: 'id', title: '学号', sort: true}
                , {field: 'stuName', title: '学生姓名'}
                , {field: 'stuSex', title: '性别'}
                , {field: 'stuFamilynumber', title: '家庭电话'}
                //,{field:'stu_majorid', title: '班级', minWidth: 150}
                //, {field: 'stuDormitoryid', title: '宿舍号'}
                , {field: 'stuStatus', title: '状态'}
                , {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
            ]]
            , page: true
        });
        //绑定行工具栏事件
        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if (layEvent === 'edit') {
                //编辑按钮
                console.log(data.id);
                layer.open({
                    type: 2,
                    area: ['900px', '500px'],
                    content: '${ ctx }/student/openEditPage?id=' + data.id //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                });
            } else if (layEvent === 'see') {
                //查看按钮
                console.log(data.id);
                layer.open({
                    type: 2,
                    area: ['800px', '500px'],
                    content: '${ ctx }/student/openSeePage?id=' + data.id //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                });
            } else if (layEvent === 'del') {
                //删除按钮
                layer.confirm('真的删除么？', {
                    btn: ['朕决定了', '算了吧'] //按钮
                }, function () {
                    $.ajax({
                        type: 'POST',
                        url: '${ctx}/student/deleteStudentFirst',
                        dataType: 'json',
                        data : {
                          id : data.id
                        },
                        success: function (msg) {
                            if (msg.data === 1) {
                                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                layer.alert('删除成功 (*^v^*)', {
                                    icon: 6,
                                    skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                                });
                            } else {
                                layer.alert('删除失败 つ﹏⊂', {
                                    icon: 5,
                                    skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                                });
                            }
                        },
                        error: function (msg) {
                            layer.msg('程序猿偷懒了，没写好接口 (⊙ˍ⊙)', {icon: 5});
                            console.log(msg);
                        }
                    });
                }, function () {
                    layer.msg('谢谢大哥不杀之恩 (*^v^*)', {icon: 6});
                });
            }
        });
    });

    $('#dataRecovery').on('click', function () {
        //数据恢复
        layer.open({
            type: 2,
            area: ['1100px', '600px'],
            content: '${ctx}/student/openDelPage', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            cancel: function () {
                location.reload();
            }
        });
    });

    $('#downloadTheTemplate').on('click', function () {
        //下载模板
        var sheetNum;
        var rows;
        layer.prompt({title: '请问您想下载几个工作簿（sheet）', formType: 0}, function (text, index) {
            sheetNum = text;
            layer.close(index);
            layer.prompt({title: '请输入您要下载多少行的模板', formType: 0}, function(text, index){
                rows = text;
                var formData = new FormData();
                formData.append("sheetNum", sheetNum);
                formData.append("rows", rows);
                var url = "${ctx}/student/downLoad";
                var xhr = new XMLHttpRequest();
                xhr.open("post", url, true);
                xhr.responseType = "blob";
                layer.msg('王尼玛来打个酱油', {icon: 4});
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var name = xhr.getResponseHeader("Content-disposition");
                        var fileName = name.substring(21, name.length);
                        var filename = decodeURIComponent(fileName);
                        var blob = new Blob([xhr.response], {type: 'text/xls'});
                        var csvUrl = URL.createObjectURL(blob);
                        var a = document.createElement('a');
                        a.href = csvUrl;
                        a.download = filename;
                        a.click();
                    }
                };
                xhr.send(formData);
                layer.close(index);
            });
        });
    });

    $('#theBatchExport').on('click',function (){
        //批量导出
        layui.use('table', function () {
            var table = layui.table;
            var checkStatus = table.checkStatus('listTable');
            console.log(checkStatus);
            var data = checkStatus.data;
            if (data.length === 0) {
                layer.alert('请大哥勾选数据之后在进行导出哦！！ (*^v^*)', {
                    icon: 6,
                    skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                });
            }else{
                var ids = new Array(data.length);
                for (var i in data) {
                    ids[i] = data[i].id;
                }
                var formData = new FormData();
                formData.append("id", ids);
                var url = "${ctx}/student/exportExcel";
                var xhr = new XMLHttpRequest();
                xhr.open("post", url, true);
                xhr.responseType = "blob";
                layer.msg('王尼玛来打个酱油', {icon: 4});
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var name = xhr.getResponseHeader("Content-disposition");
                        console.log();
                        var fileName = name.substring(21, name.length);
                        var filename = decodeURIComponent(fileName);
                        var blob = new Blob([xhr.response], {type: 'text/xls'});
                        var csvUrl = URL.createObjectURL(blob);
                        var a = document.createElement('a');
                        a.href = csvUrl;
                        a.download = filename;
                        a.click();
                    }
                };
                xhr.send(formData);
            }
        })
    });

    $('#addStudent').on('click', function () {
        //添加单条学生信息
        layer.open({
            type: 2,
            area: ['800px', '500px'],
            content: '${ctx}/student/openAddPage', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            cancel: function () {
                location.reload();
            }
        });
    });

    function reload() {
        var table = layui.table;
        table.reload('listTable', {
            url: '${ctx}/student/filterStudentList'
            , where: { //设定异步数据接口的额外参数，任意设
                stuId: $('#myId').val(),
                stuName: $('#myName').val(),
                stuMajor: $('#myMajor').val(),
                delFlag: 0
            }
            , page: true
        });
    }

    layui.use('upload', function () {
        var upload = layui.upload;
        upload.render({
            elem: '#importExcel',
            url: '${ctx}/student/importExcel',
            auto: 'true',
            accept: 'fileType',
            exts: 'xls|xlsx',
            field: 'fileType',
            done: function (msg) {
                if (msg.status == 200){
                    layer.msg('导入成功', {icon: 6});
                }else{
                    layer.msg('导入失败', {icon: 5});
                }
            }
        })
    });

    $('.listStudentTable .layui-btn').on('click', function () {
        reload();
    })

</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="see">查看</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
</html>
