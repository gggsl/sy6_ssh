<%--
  Created by IntelliJ IDEA.
  User: enter
  Date: 2018/12/21
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
    <form action="changePassword" method="post" onsubmit="return checkPassword()">
        <input type="text" name="password"id="password">
        <input type="text" name="newpasswprd" id="newpassword">
        <input type="text" name="sure" id="sure">
        <button type="submit">提交</button>
    </form>
<script>
    function checkPassword() {
        var pas = document.getElementById('newpassword').valueOf();
        var sure = document.getElementById('sure').valueOf();
        alert(pas+sure);
        if (pas == sure){
            return true;
        }
        else
            alert('密码不一致');
    }
</script>
</body>
</html>
