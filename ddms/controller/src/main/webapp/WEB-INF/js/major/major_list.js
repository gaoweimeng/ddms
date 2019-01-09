layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#major' //指定原始表格元素选择器（推荐id选择器）
        , url: 'http://localhost:8080/major/selmajor'

        , id: 'majorReload'
        , cols: [[{
            field: 'id', title: '编号', sort: true
        }, {
            field: 'majorName', title: '专业名称'
        }, {
            field: 'collegeName', title: '学院'
        }, {
            field: 'majorDisciplinecategories', title: '学科门类'
        }, {
            field: 'majorEducation', title: '学历'
        }, {
            field: 'schoolsystem', title: '学制'
        }, {
            fixed: 'right', align: 'center', title: '状态', toolbar: '#barDemo'
        }]],
        page: true
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                console.log(obj.data);
                //console.log($('#id').val());
                obj.del();
                layer.close(index);
                $.ajax({
                    url: 'http://localhost:8080/major/delemajor',
                    type: "post",
                    data: {
                        id: obj.data.id
                    }, success: function (data) {
                        layer.msg("删除成功");
                    }, error: function (data) {
                        layer.msg("删除失败");
                    }
                })
            });
        } else if (obj.event === 'edit') {
        // layer.prompt({
        //         formType: 2
        //         ,value: data.email
        //     }, function(value, index){
        //         obj.update({
        //             email: value
        //         });
        //         layer.close(index);
        //     });
            var ids = obj.data.id;
            //var thisid = parseInt(ids);
            console.log(ids);
            layer.open({
                type: 2,
                content: 'http://localhost:8080/major/selectMajorAccrodingtoid?id=' + ids,
                area: ['500px', '460px'],
                offset: ['0px', '250px']
            });
        }
    })

    $("#search").click(function () {
        reload();
    });
    $('#addmajor').click(function () {
        layer.open({
            type: 2,
            content: 'http://localhost:8080/major/selcollege',
            area: ['500px', '460px'],
            offset: ['0px', '250px']
        })
    });
    $('#download').on('click', function () {
        //下载模板
        var sheetName;
        var formData = new FormData();
        formData.append("sheetName", 1);
        var url = "http://localhost:8080/major/updataDownLoad";
        var xhr = new XMLHttpRequest();
        xhr.open("post", url, true);
        xhr.responseType = "blob";
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
    });
    $('#exportAll').click(function () {
        $.ajax({
            url: 'http://localhost:8080/major/selByEduOrName',
            type: "post",
            data: {
                majorName: $('#selmajorName').val(),
                majorEducation: $('#selmajorEducation').val()
            },
            success: function (data) {
                //定义一个数组
                var x = [];
                console.log(data.data);
                for (var i = 0; i < data.data.length; i++) {
                    //定义一个数组的数组
                    x[i] = [];
                    x[i] = [data.data[i].id, data.data[i].majorName, data.data[i].collegeName,
                        data.data[i].majorDisciplinecategories, data.data[i].majorEducation, data.data[i].schoolsystem];
                }
                console.log(x[i]);
                table.exportFile(['编号', '专业名称', '学院', '学科门类', '学历', '学制'], x, 'xls');
            }, error: function (data) {
                layer.msg("导出失败");
            }
        })
    })

});

function reload() {
    var table = layui.table;
    //console.log(table);
    //执行重载
    table.reload('majorReload', {
        url: 'http://localhost:8080/major/selectByEducationOrName'
        , where: { //设定异步数据接口的额外参数，任意设
            majorName: $('#selmajorName').val(),
            majorEducation: $('#selmajorEducation').val()
        }
        , page: true
    });
}

layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;
    //指定允许上传的文件类型
    upload.render({
        elem: '#filePath'
        , url: 'http://localhost:8080/major/readExcelData'
        , field: 'filePath'
        , accept: 'file' //普通文件
        ,done: function(res, index, upload){
            layer.msg("上传成功");
            //实时更新
            window.location.reload();
        }
        , error: function (data) {
            layer.msg("上传失败");
        }
    });
    console.log(upload);
})