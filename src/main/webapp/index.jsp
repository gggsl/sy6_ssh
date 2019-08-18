<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<style>
    .abc {margin:0 auto;width:720px;text-align:center;}
</style>
<div align="center" >
    <h2>简单图片管理系统!</h2>
    <div class="abc">

        <form action="user/loginCheck" method="post">
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
            没有账号？<a href="user/goRegister">点击注册</a>
        </form>
    </div>
</div>

<form id="myForm" action="/user/aaaa" method="post" enctype="multipart/form-data">
    <input type="file" id="u_photo" name="u_photo" />
</form>
<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="jquery/jquery.form.js"></script>
<script>
    $('#u_photo').on('change', function() {

        var file[0] = this.files[0];

        if (file.size > 1024*1000) {

            alert('文件最大1M！')

        }

        savePro()


    });
    function savePro() {
        $("#myForm").ajaxSubmit(function (message) {
            console.log(message);

        });
        return false;
    }

</script>

</body>
</html>
