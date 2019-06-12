
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>前后台交互总结</title>
    <meta charset="utf-8">
</head>

<body>

<button type="button" class="btn btn-primary" onclick="test()"> 查看 脚本 basePath 变量 </button>


</body>
</html>
<script type="text/javascript">

    function test(){
        let ctx = "<%=basePath%>";
        console.log(ctx,'ctx');
    }



</script>