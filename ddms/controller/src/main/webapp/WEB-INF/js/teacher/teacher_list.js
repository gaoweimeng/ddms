layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#teacher' //指定原始表格元素选择器（推荐id选择器）
        , url: 'http://localhost:8080/teacher/queryallpage'
       // , title: '教师信息'
       //  , height: 'full-150'
        , id : 'teacherTable'
        , page: true
        , cols: [[
            {type: 'checkbox', fixed: 'left'}  //选择框
            , {field: 'worknumber', title: '工号', sort: true}
            , {field: 'teaName', title: '教师姓名'}
            , {field: 'teaSex', title: '性别'}
            , {field: 'teaPhone', title: '手机号'}
            , {field: 'teaNation', title: '民族'}
            , {field: 'teaJobtitle', title: '职称'}
            , {field: 'teaRkzk', title: '任课状况'}
            , {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
        ]]
    });


    //监听工具栏事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'delete') {
            layer.confirm('真的删除数据吗', function (index) {
                obj.del();
                layer.close(index);
                $.ajax({
                    url: 'http://localhost:8080/teacher/del',
                    type: "post",
                    data: {
                        id: obj.data.worknumber
                    }, success: function (data) {
                        layer.msg("删除成功");
                    }, error: function (data) {
                        layer.msg("删除失败");
                    }
                })
            });
        } else if (obj.event === 'update') {
            //var thisid = parseInt(ids);
            //将字符转义
            s = encodeURI("http://localhost:8080/teacher/update/" + obj.data.worknumber);
            layer.open({
                type: 2,
                content: s,
                area: ['1000px', '500px'],
                offset: 'auto'
            });
        }
    });

    //监听复选框事件
    table.on('checkbox(test)', function (obj) {
        console.log(obj);
        console.log(table.checkStatus('teacher'));
        console.log(table.checkStatus('teacher').data);
    });

    // var $ = layui.jquery, active = {
    //     //搜索
    //     reload: function () {
    //         table.reload('teacher', {
    //             url: 'http://localhost:8080/teacher/queryconditionpage'
    //             , where: {
    //                 condition: $('#search').val()
    //             }
    //             , page: {
    //                 curr: 1 //重新从第 1 页开始
    //             }
    //         });
    //     }
    // };
function reload() {
    var table = layui.table;
    //console.log(table);
    //console.log($('#search').val());
    table.reload('teacherTable', {
        url: 'http://localhost:8080/teacher/queryconditionpage'
        , where: {
            condition: $('#search').val()
        }
        // , page: {
        //     curr: 1 //重新从第 1 页开始
        // }
    });
};
    //搜索时间
    $('#searchbtn').on('click', function () {
        // var type = $(this).data('type');
        // active[type] ? active[type].call(this) : '';
        reload();
    });

    $('#exportAll').on('click', function () {
        layui.use('table', function () {
            var table = layui.table;
            var checkStatus = table.checkStatus('teacherTable');
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
                    ids[i] = data[i].worknumber;
                }
                var formData = new FormData();
                formData.append("id", ids);
                var url = "http://localhost:8080/teacher/exportExcel";
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
});

layui.use('upload', function () {
    var upload = layui.upload;

    //执行实例
    upload.render({
        elem: '#importExcel'
        , url: 'http://localhost:8080/teacher/importExcel'
        , field: 'excelFile'
        , accept: 'file'
        , auto: true //选择文件后不自动上传
        , done: function (res) {
            if (res.status == 200) {
                layer.msg("上传成功");
            } else {
                layer.msg(res.msg);
            }
        }, error: function (res) {
            layer.msg(res.msg);
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
            var url = "http://localhost:8080/teacher/download";
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