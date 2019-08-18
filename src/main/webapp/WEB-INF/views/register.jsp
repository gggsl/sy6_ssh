<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<style>
    .abc {margin:0 auto;width:720px;text-align:center;}
</style>
<head>
    <title>register</title>
</head>

<body class="abc">
<h2>用户注册</h2>

<form action="handleRegister" method="post">
    <label>用户名&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="username">
    </label>
    <br>
    <label>真实姓名
        <input type="text" name="name">
    </label>
    <br>
    <label>密码&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="password">
    </label>
    <br>
    <label>简介
        <input type="text" name="intro">
    </label>
    <br>
    <label>省份&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="province">
    </label>
    <br>
    <label>
        城市&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="city">
    </label>
    <br>
    <label>
        类型&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="type">
    </label>
    <br>
    <label>
        email&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="email">
    </label>
    <br>
    <label>
        QQ&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="QQ">
    </label>
    <br>
    <label>
        电话&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="mobile">
    </label>
    <br>
    <label>
        身份&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="status">
    </label>
    <input type="submit" value="注册">
</form>

</body>
</html>
