
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <%--引入 Bootstrap 对话框 插件--%>
    <script src="${ctx}/plugins/dialog/js/bootstrap-dialog.js"></script>
</head>
<body>

<button type="button" class="btn btn-lg btn-primary" onclick="showMsg2(123)">Primary</button>

123123123123

</body>
</html>

<script>
    function showMsg2(info) {
        BootstrapDialog.show({
            title: "提示",
            message: info.msg,
            buttons: [{
                label: '确定',
                cssClass: 'btn-primary',
                action: function (dialog) {
                    alert(1111111);
                    // info.success();
                    dialog.close();
                }
            }, {
                label: '取消',
                action: function (dialog) {
                    alert(222222222);
                    dialog.close();
                }
            }]
        });
    }


</script>