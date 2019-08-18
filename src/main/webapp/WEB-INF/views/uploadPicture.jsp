<%--
  Created by IntelliJ IDEA.
  User: enter
  Date: 2018/12/23
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
    <form action="/picture/uploadPicture" method="post" enctype="multipart/form-data">
        图片名<input type="text" name="name"><br>
        简介<textarea name="intro"></textarea><br>
        标签<input type="text" name="tags"><br>
        上传图片<input type="file" name="file"><br>
        <input type="submit" value="提交">

    </form>

</body>
</html>
