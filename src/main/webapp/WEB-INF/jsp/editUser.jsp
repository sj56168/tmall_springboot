<%--
  Created by IntelliJ IDEA.
  User: 我不管我最帅
  Date: 2019/2/26
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin:0px auto; width:500px">

    <form action="/user/${user.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        name: <input name="name" value="${user.name}"> <br>
        password:<input name="password" value="${user.password}"> <br>
        <button type="submit">提交</button>

    </form>
</div>
</body>
</html>
