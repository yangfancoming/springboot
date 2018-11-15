
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>前后台交互总结</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
</head>

<body>

<%--前后台交互 数组 传参--%>
<input type="button" value="传递数组"  />

<%--前后台交互 字符串  传参--%>
<input type="button" value="传递字符串" />


<a href="<%=basePath%>a/test1">a标签跳controller</a>


</body>
</html>
<script type="text/javascript">

</script>