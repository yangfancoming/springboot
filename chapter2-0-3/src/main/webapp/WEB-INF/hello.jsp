
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

hello  22222
<hr>
<input type=checkbox id="fuck1" name="kk1">
<hr>
<input type=checkbox id="fuck2"name="kk2">
<hr>

<h1 > get 表单</h1>
<form action="/secondServlet" method="get">
    <input id="username" name="username" type="text" placeholder="用户名"  />
    <input id="password" name="password" type="text" placeholder="密码"  />
    <button type="submit">提交</button>
</form>

<hr>

<h1 > post 表单</h1>
<form action="/secondServlet" method="post">
    <input id="username1" name="username" type="text" placeholder="用户名"  />
    <input id="password1" name="password" type="text" placeholder="密码"  />
    <button type="submit">提交</button>
</form>



</body>
</html>
