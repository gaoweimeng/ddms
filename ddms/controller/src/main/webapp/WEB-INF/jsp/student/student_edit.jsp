<%--
  Created by IntelliJ IDEA.
  User: 84261
  Date: 2018/9/24
  Time: 11:26
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
    <title>编辑</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/layui/css/layui.css">
    <script type="text/javascript" src="${ctx}/js/jquery-2.2.4-min.js"></script>
</head>
<body>
<div class="layui-upload" style="position: fixed;top: 20px;right: 20px;z-index: 999">
    <div class="layui-upload-list">
        <img src="${oneStudent.data.stuPicture}" class="layui-upload-img" id="stuImg" width="93px" height="125px"
             style="border: 1px solid red">
    </div>
    <button type="button" class="layui-btn" id="selectImg">选择图片</button>
</div>
<form action="" method="post" id="form1" class="layui-form">
    <input type="text" name="stuPicture" id="stuPicture" hidden>
    <input type="text" value="${oneStudent.data.id}" id="id" name="id" hidden>
    <input type="text" value="0" id="stuDelflag" name="stuDelflag" hidden>
    <div class="layui-inline" style="position: fixed;top: 220px;right: 40px;z-index: 999">
        <button class="layui-btn" lay-submit lay-filter="editForm">修改</button>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="stuName" id="stuName" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuName}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>性别</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuSex" id="stuSex" autocomplete="off" lay-verify="required"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuSex" id="stuSex">
                    <option value="男" <c:if test="${oneStudent.data.stuSex == '男'}">selected</c:if>>男</option>
                    <option value="女" <c:if test="${oneStudent.data.stuSex == '女'}">selected</c:if>>女</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>政治面貌</label>
            <div class="layui-input-inline">
                <input type="text" name="stuPoliticalface" id="stuPoliticalface" autocomplete="off"
                       lay-verify="required" class="layui-input" value="${oneStudent.data.stuPoliticalface}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>出生日期</label>
            <div class="layui-input-inline">
                <input type="text" name="stuBirthday" id="stuBirthday" autocomplete="off" lay-verify="required"
                       class="layui-input" value="<fmt:formatDate value='${oneStudent.data.stuBirthday}' pattern='yyyy-MM-dd' />">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>民族</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuNational" id="stuNational" autocomplete="off" lay-verify="required"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuNational" id="stuNational">
                    <c:forEach items="${nation}" var="x">
                        <option value="${x.name}" <c:if test="${oneStudent.data.stuSex == x.name}">selected</c:if>>${x.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>所属专业</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="clazzName" id="clazzName" autocomplete="off" class="layui-input" value="${oneStudent.clazzName}">--%>
                <select name="stuMajorId" id="stuMajorId">
                    <c:forEach items="${allMajors}" var="x">
                        <option value="${x.id}" <c:if test="${oneStudent.data.stuSex == x.id}">selected</c:if>>${x.majorName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>入学时间</label>
            <div class="layui-input-inline">
                <input type="text" name="stuEntranceTime" id="stuEntranceTime" autocomplete="off" lay-verify="required"
                       class="layui-input" value="<fmt:formatDate value='${oneStudent.data.stuEntranceTime}' pattern='yyyy-MM-dd' />">
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
            <div class="layui-input-inline">
                <input type="text" name="stuFamilynumber" id="stuFamilynumber" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuFamilynumber}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>家庭住址</label>
            <div class="layui-input-inline">
                <input type="text" name="stuAddress" id="stuAddress" autocomplete="off" lay-verify="required"
                       class="layui-input" value="${oneStudent.data.stuAddress}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="stuPhone" id="stuPhone" autocomplete="off" lay-verify="required|phone"
                       class="layui-input" value="${oneStudent.data.stuPhone}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>身份证</label>
            <div class="layui-input-inline">
                <input type="text" name="stuIdcard" id="stuIdcard" autocomplete="off" lay-verify="required|idCard"
                       class="layui-input" value="${oneStudent.data.stuIdcard}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label"><span style="color: red">*</span>状态</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="clazzName" id="clazzName" autocomplete="off" class="layui-input" value="${oneStudent.clazzName}">--%>
                <select name="stuStatus" id="stuStatus">
                    <c:forEach items="${stuStatus}" var="status">
                        <option value="${status.name}" <c:if test="${oneStudent.data.stuSex == status.name}">selected</c:if>>${status.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <fieldset class="layui-elem-field layui-field-title">
        <legend>以下为非必填项</legend>
    </fieldset>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">籍贯</label>
            <div class="layui-input-inline">
                <input type="text" name="stuNative" id="stuNative" autocomplete="off"
                       class="layui-input" value="${oneStudent.data.stuNative}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">QQ帐号</label>
            <div class="layui-input-inline">
                <input type="text" name="stuQq" id="stuQq" autocomplete="off"
                       class="layui-input" value="${oneStudent.data.stuQq}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">生源省份</label>
            <div class="layui-input-inline">
                <input type="text" name="stuProvince" id="stuProvince" autocomplete="off"
                       class="layui-input" value="${oneStudent.data.stuProvince}">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">生源地区</label>
            <div class="layui-input-inline">
                <input type="text" name="stuSource" id="stuSource" autocomplete="off"
                       class="layui-input" value="${oneStudent.data.stuSource}">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">培养对象</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuCulobject" id="stuCulobject" autocomplete="off"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuCulobject" id="stuCulobject">
                    <option value="无" selected>请选择</option>
                    <c:forEach items="${stuCulObjects}" var="x">
                        <option value="${x.name}" <c:if test="${oneStudent.data.stuSex == x.name}">selected</c:if>>${x.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">培养类别</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuCulcategory" id="stuCulcategory" autocomplete="off"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuCulcategory" id="stuCulcategory">
                    <option value="无" selected>请选择</option>
                    <c:forEach items="${stuCulCategory}" var="x">
                        <option value="${x.name}" <c:if test="${oneStudent.data.stuSex == x.name}">selected</c:if>>${x.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">毕业类别</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuGradcategory" id="stuGradcategory" autocomplete="off"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuGradcategory" id="stuGradcategory">
                    <option value="无" selected>请选择</option>
                    <c:forEach items="${stuGradCategory}" var="x">
                        <option value="${x.name}" <c:if test="${oneStudent.data.stuSex == x.name}">selected</c:if>>${x.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">考生类别</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuCandidatetype" id="stuCandidatetype" autocomplete="off"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuCandidatetype" id="stuCandidatetype">
                    <option value="无" selected>请选择</option>
                    <c:forEach items="${candidateType}" var="x">
                        <option value="${x.name}" <c:if test="${oneStudent.data.stuSex == x.name}">selected</c:if>>${x.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">办学类型</label>
            <div class="layui-input-inline">
                <%--<input type="text" name="stuSchooltype" id="stuSchooltype" autocomplete="off"--%>
                <%--class="layui-input" value="">--%>
                <select name="stuSchooltype" id="stuSchooltype">
                    <option value="无" selected>请选择</option>
                    <c:forEach items="${schoolType}" var="x">
                        <option value="${x.name}" <c:if test="${oneStudent.data.stuSex == x.name}">selected</c:if>>${x.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
</form>
</body>
<script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layDate = layui.laydate;

        layDate.render({
            elem: '#stuBirthdate'
        });
        layDate.render({
            elem: '#stuEntranceTime'
            , done: function (value, date) {
                // console.log(value); //得到日期生成的值，如：2017-08-18
                // console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                var majorId = $('#stuMajorId').val();
                if (majorId == 0) {
                    layer.msg('请先选择专业之后再添写本项！', {icon: 6});
                    $('#stuEntranceTime').val("");
                    date = null;
                }
                $.ajax({
                    type: 'GET',
                    url: '${ctx}/student/selectSchoolSystem?majorId=' + majorId,
                    success: function (msg) {
                        if (date != null) {
                            var newYear = Number(date.year) + Number(msg.data.data);
                            // console.log(newYear);
                            var newTime = newYear + "-" + value.substring(5, 7) + "-" + value.substring(8, 10);
                            $('#stuGraduationTime').val(newTime);
                        }
                    },
                    error: function () {
                        layer.msg('程序猿偷懒了，没写好接口 (⊙ˍ⊙)', {icon: 5});
                    }
                })
            }
        });

        //监听提交
        form.on('submit(editForm)', function (data) {
            console.log(data);
            $.ajax({
                type: 'POST',
                url: '${ctx}/student/updateStudent',
                dataType: 'json',
                data: {
                    student: JSON.stringify(data.field)
                },
                success: function (msg) {
                    if (msg.data === 1) {
                        // layer.alert('修改成功了哦！ (*^v^*)', {
                        //     icon: 6,
                        //     skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                        // });
                        layer.alert('修改成功了哦！ (*^v^*)', {
                            icon: 6,
                            skin: 'layer-ext-moon'
                        }, function (index) {
                            //do something
                            window.parent.location.reload();
                            layer.close(index);
                        });
                    } else {
                        layer.alert('修改失败了。 つ﹏⊂', {
                            icon: 5,
                            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                        });
                    }
                },
                error: function () {
                    layer.msg('程序猿偷懒了，没写好接口 (⊙ˍ⊙)', {icon: 5});
                }
            });
            return false;
        });
    });
    layui.use('upload', function () {
        var upload = layui.upload;
        //上传照片
        upload.render({
            elem: '#selectImg'
            , auto: false
            //,multiple: true
            //,bindAction: '#test9'
            , choose: function (obj) {
                // console.log(obj);
                //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
                obj.preview(function (index, file, result) {
                    // console.log(index); //得到文件索引
                    // console.log(file); //得到文件对象
                    // console.log(result); //得到文件base64编码，比如图片
                    $('#stuImg').attr('src', result);
                    $('#stuPicture').val(result);
                });
            }
        });
    })
</script>
</html>
