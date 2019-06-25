
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

index  111111
<hr>
<input type=checkbox id="fuck1" name="kk1">
<hr>
<input type=checkbox id="fuck2"name="kk2">
<hr>

<form action="/secondServlet" method="post">
    <input id="username" name="username" type="text" placeholder="用户名"  />
    <button type="submit">提交</button>
</form>

<hr>

<form action="/test" method="post">
    <input type="checkbox" value="1" name="hobby"> 篮球</input>
    <input type="checkbox" value="2" name="hobby"> 足球</input>
    <button type="submit">提交</button>
</form>

</body>
</html>

