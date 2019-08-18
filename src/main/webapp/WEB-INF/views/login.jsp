<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<style>
    .abc {margin:0 auto;width:720px;text-align:center;}
</style>
<div align="center" >
    ${err}
<h2>简单图片管理系统!</h2>
<div class="abc">

    <form action="loginCheck" method="post">
        <label>用户名
            <input type="text" name="username"/>
        </label>
        <br>
        <br>
        <label> 密&nbsp&nbsp&nbsp码
            <input type="text" name="password"/>
        </label>
        <br>
        <br>
        <input type="submit" value="登陆">
        <br>
        <br>
        没有账号？<a href="/user/goRegister">点击注册</a>
    </form>
</div>
</div>
</body>
</html>
