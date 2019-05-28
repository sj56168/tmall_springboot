<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 我不管我最帅
  Date: 2019/2/24
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
<script>
    $(function () {
        $(".delete").click(function () {
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
</head>
<body>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${page.list}" var="curUser">
    <tr>
        <td>${curUser.id}</td>
        <td>${curUser.name}</td>
        <td>${curUser.password}</td>
        <td><a href="/user/${curUser.id}">编辑</a></td>
        <td><a class="delete" href="/user/${curUser.id}">删除</a></td>
    </tr>
    </c:forEach>
</table>
<div>
    <a href="?start=1">[首  页]</a>
    <a href="user?start=${page.pageNum-1}">[上一页]</a>
    <a href="user?start=${page.pageNum+1}">[下一页]</a>
    <a href="user?start=${page.pages}">[末  页]</a>
</div>
<%--增--%>
<form action="/user" method="post">
    name: <input name="name"> <br>
    password: <input name="password"> <br>
    <button type="submit">提交</button>

</form>


<form action="" method="post" id="formdelete">
    <input type="hidden" name="_method" value="delete">
</form>
</body>
</html>
