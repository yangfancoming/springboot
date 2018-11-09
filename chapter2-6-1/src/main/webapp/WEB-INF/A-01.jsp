
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
</head>


<body>
<div id="one"></div>

<button type="button" onclick="test()">点我!</button>
</body>
</html>

<script>
    function test(){
        $('#one').append("<p id='two'>test1</p>");
    }

    // 这种方法  是不会弹出窗口的!
    $("#two").on("click",function(data){
        alert(data);
    });

    // 这种方法  是可以弹出窗口的!
//    $("body").on("click","#two",function(data){
//        alert(data);
//    });

    $("#one").on("click","#two",function(data){
        alert(data);
    });
</script>