layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;
    //监听提交
    form.on('submit(demo1)', function (data) {
        //layer.alert(JSON.stringify(data.field), {
        // title: '最终的提交信息'
        // })
        console.log($('#collegeName').val());
        $.ajax({
            url: 'http://localhost:8080/major/updatemajors',
            type: "post",
            data: {
                id: $('#id').val(),
                majorName: $('#majorName').val(),
                majorCollegeid: $('#collegeName').val(),
                majorDisciplinecategories: $('#majorDisciplinecategories').val(),
                majorEducation: $('#majorEducation').val(),
                schoolsystem: $('#schoolsystem').val()
            }, success: function (data) {
                layer.msg("更新成功");
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //实时更新
                window.parent.location.reload();
                //关闭当前frame
                parent.layer.close(index);
            }, error: function (data) {
                layer.msg('更新失败', {icon: 5, time: 1000});
            }
        })
        return false;
    });
});