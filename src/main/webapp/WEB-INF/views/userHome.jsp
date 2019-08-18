<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<style>
    .abc {margin:0 auto;width:80%;text-align:center;}
    #PageBody{width:100%;}
    #left{float:left;width: 60%;}
    #right{float:right;width: 40%;}
    #show{float: right}

</style>
<body >
<div>
    <h4>欢迎 ${sessionScope.user.real_name}</h4>
</div>

<div id="PagebBody">
<div id="left" >
    搜索用户
    <form action="searchUser" method="post">
        <input type="text" name="key" >
        <input type="submit" value="搜索">
    </form>
    <br>
    搜索照片
    <form action="searchPicture" method="post">
        <input type="text" name="key" >
        <input type="submit" value="搜索">
    </form>
</div>
<div id="right">
    <img src="/picture/${user.id}.jpg" border="1" height="100" width="100" >
    <a href="myHome">我的空间</a>
</div>
</div>
<%--<div class="abc">

    <form action="add" method="post">
        <table  >
            <caption>添加设备</caption>
            <tr>
                <td >
                    名称 <input type="text" name="name"/>  编码<input type="text" name="code"/>  价格<input type="text" name="price">
                </td>
            </tr>
            <tr colspan="3">
                <td >
                    描述：<textarea name="description" cols="82" rows="3"></textarea>"
                </td>
            </tr>
            <tr>
                <td >
                    领用人id<input type="text" name="user_id"> 存放地点<input type="text" name="place"> <input type="submit" value="添加设备">
                </td>
            </tr>
        </table>
    </form>
</div>--%>



<p>关注用户照片</p>

<c:forEach var="pictures" items="${pictures}">
    <div id="show">
        <img src="/picture/${pictures.name}">
        图片名称：${pictures.name}
        上传时间：${pictures.upload_time}
        上传人：${pictures.user_id}
    </div>
</c:forEach>
<%--<script src="../../jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

    $("#pre").click(function(){
        var param = $("#page").val();
        if (param>0) {
            --param;
            $.ajax({
                type: "post",
                url: "page",
                contentType: 'application/json;charset=UTF-8',
                data: {"para": param},
                dataType: "json",
                success:function(){
                    $("#page").val(param);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("请求失败！");
                }
            });
        }
    });
    $("#next").click(function(){
        var param = $("#page").val();
        ++param;
        $.ajax({
            type: "post",
            url: "page",
            contentType: 'application/json;charset=UTF-8',
            data: {"para":param},
            dataType: "json",
            success:function(){
                $("#page").val(param);
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    });
</script>--%>
</body>
</html>
