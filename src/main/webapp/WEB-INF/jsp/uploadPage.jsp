<%--
  Created by IntelliJ IDEA.
  User: 我不管我最帅
  Date: 2019/2/25
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
<input type="submit" value="上传">
</form>
</body>
</html>
