<%--
  Created by IntelliJ IDEA.
  User: enter
  Date: 2018/12/21
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人空间</title>
</head>
<body>

<form action="/user/uploadHead" method="post" enctype="multipart/form-data">
    <img src="${path}" border="1" height="50" width="50" >
    <label>上传头像</label><input type="file" name="file" /><br/>
    <input type="submit" value="提交">
</form>
用户名：${user.username}    <a href="changeInformation.jsp">修改个人信息</a> <a href="changePassword.jsp"> 修改密码</a><br>
    ${user.province} ${user.city}
    <textarea name="intro" id="intro" cols="30" rows="10">
        <c:if test="${user.intro ==null}">
            这家伙很懒，什么都没留下！
        </c:if>
        ${user.intro}
    </textarea>  <button id="change" value="修改签名"/>
<div>
    <button href="/picture/upload">上传图片</button>
</div>
</body>
</html>
