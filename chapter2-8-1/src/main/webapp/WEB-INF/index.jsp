
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ECharts</title>
    <meta charset="utf-8">

    <%-- sos 这个引入jQuery 放在 页面最下面 jQuery 就无法引入 报错  Uncaught ReferenceError: $ is not defined --%>
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
</head>

<body>

<input type="text" name="id" id="id"  value="123"/>
<br>
<input type="button" onclick="set()" value="设置" />
<input type="button" onclick="myReset()" value="重置" />
</body>
</html>

<script type="text/javascript">
    $(function() {// 初始化内容
        console.log($("#id").val(),22222)
    });
    function set() {
        $("#id").val("00")
    }
    function myReset() {
        $("#id").val("")
    }
</script>

