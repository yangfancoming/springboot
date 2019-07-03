
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" content="#">
    <title>学生信息管理页面</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/demo.css">
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/validateExtends.js"></script>


    <script type="text/javascript">
        //DOM加载完成后执行的回调函数
        $(function () {

            //信息添加按钮事件
            $("#add").click(function () {
                table = $("#addTable");
                $("#addTable").form("clear");//清空表单数据
                $("#addDialog").dialog("open");//打开添加窗口
            });

            //设置添加学生信息窗口
            $("#addDialog").dialog({
                title: "添加学生信息窗口",
                width: 660,
                height: 530,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '添加',
                        plain: true,
                        iconCls: 'icon-add',
                        handler: function () {
                            var validate = $("#addForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                            } else {
                                var data = $("#addForm").serialize();//序列化表单信息
                                $.ajax({
                                    type: "post",
                                    url: "addStudent?t" + new Date().getTime(),
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            $("#addDialog").dialog("close"); //关闭窗口
                                            $('#dataList').datagrid("reload");//重新刷新页面数据
                                            $.messager.alert("消息提醒", "添加成功啦!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#add_sno").textbox('setValue', "");
                            $("#add_name").textbox('setValue', "");
                            $("#add_gender").textbox('setValue', "男");
                            $("#add_password").textbox('setValue', "");
                            $("#add_email").textbox('setValue', "");
                            $("#add_telephone").textbox('setValue', "");
                            $("#add_address").textbox('setValue', "");
                            $("#add_introducation").textbox('setValue', "");
                        }
                    }
                ]
            });

            //学生与班级名搜索按钮的监听事件(将其值返回给Controller)
            $("#search-btn").click(function () {
                $('#dataList').datagrid('load', {
                    studentname: $('#search-studentname').val(),//获取学生名称
                    clazzname: $('#search-clazzname').combobox('getValue')//获取年级名称
                });
            });

            //添加信息窗口中上传头像的按钮事件
            $("#add-upload-btn").click(function () {
                if ($("#choose-portrait").filebox("getValue") === '') {
                    $.messager.alert("提示", "请选择图片!", "warning");
                    return;
                }
                $("#add-uploadForm").submit();//提交表单

            });

        });

    </script>
</head>
<body>


<!-- 添加信息窗口 -->
<div id="addDialog" style="padding: 15px 0 0 55px;">
    <!-- 设置添加头像功能 -->
    <div style="float: right; margin: 15px 40px 0 0; width: 250px; border: 1px solid #EEF4FF" id="add-photo">
        <img id="add-portrait" alt="照片" style="max-width: 250px; max-height: 300px;" title="照片"
             src="${pageContext.request.contextPath}/image/portrait/default_student_portrait.png"/>
        <!-- 设置上传图片按钮 -->
        <form id="add-uploadForm" method="post" enctype="multipart/form-data" action="uploadPhoto" target="photo_target">

            <input id="choose-portrait" class="easyui-filebox" name="photo" data-options="prompt:'选择照片'"
                   style="width:200px;">
            <input id="add-upload-btn" class="easyui-linkbutton" style="width: 50px; height: 24px;;float:right;"
                   type="button" value="上传"/>
        </form>
    </div>
    <!-- 学生信息表单 -->
    <form id="addForm" method="post" action="#">
        <table id="addTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <!-- 存储所上传的头像路径 -->
            <input id="add_portrait-path" type="hidden" name="portrait_path"/>
            <tr>
                <td>班级</td>
                <td colspan="1">
                    <select id="add_clazz_name" style="width: 200px; height: 30px;" class="easyui-combobox"  name="clazz_name" data-options="required:true, missingMessage:'请选择所属班级哟~'">
                        <c:forEach items="${clazzList}" var="clazz">
                            <option value="${clazz.name}">${clazz.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td colspan="1">
                    <input id="add_name" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="name" data-options="required:true, missingMessage:'请填写姓名哟~'"/>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select id="add_gender" class="easyui-combobox" data-options="editable: false, panelHeight: 50, width: 60, height: 30, required:true, missingMessage:'请选择性别哟~'" name="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>学号</td>
                <td colspan="1">
                    <input id="add_sno" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="sno" data-options="required:true, missingMessage:'请填写学号哟~'"/>

                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1">
                    <input id="add_password" style="width: 200px; height: 30px;" class="easyui-textbox" type="password" name="password" data-options="required:true, missingMessage:'请填写自定义密码哟~'"/>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td colspan="1"><input id="add_email" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="email" validType="email"
                                       data-options="required:true, missingMessage:'请填写邮箱地址哟~'"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="4"><input id="add_telephone" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="telephone" validType="mobile"
                                       data-options="required:true, missingMessage:'请填写联系方式哟~'"/>
                </td>
            </tr>
            <tr>
                <td>住址</td>
                <td colspan="1">
                    <input id="add_address" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="address" data-options="required:true, missingMessage:'请填写家庭住址哟~'"/>
                </td>
            </tr>
            <tr>
                <td>简介</td>
                <td colspan="4"><input id="add_introducation" style="width: 200px; height: 60px;" class="easyui-textbox"
                                       type="text" name="introducation"
                                       data-options="multiline:true,required:true, missingMessage:'记得填写个人简介呦~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>



<!-- 表单处理 -->
<iframe id="photo_target" name="photo_target" onload="uploaded(this)"></iframe>

</body>
</html>