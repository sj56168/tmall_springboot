<%--
  Created by IntelliJ IDEA.
  User: 我不管我最帅
  Date: 2019/2/23
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../statics/css/style.css"/>
</head>
<body>
<div class="workingroom">

    <div class="errorInfo">${error}</div>
    <form action="login" method="post">
        账号： <input type="text" name="name"> <br>
        密码： <input type="password" name="password"> <br>
        <br>
        <input type="submit" value="登录">
        <br>
        <br>
        <div>
            <span class="desc">账号:zhang3 密码:12345 角色:admin</span><br>
            <span class="desc">账号:li4 密码:abcde 角色:productManager</span><br>
        </div>

    </form>
</div>

</body>
</html>
