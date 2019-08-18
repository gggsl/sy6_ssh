<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索用户页面</title>
</head>
<style>
    .abc {margin:0 auto;width:800px;text-align:center;}
</style>
<body class="abc">
    ${requestScope.user.name}   <button id="concern" value="关注"></button>
    <input type="text" id="tu" value="${user.name}" hidden>
    <br>
    ${requestScope.user.province} ${user.city} <br>
    ${requestScope.user.gender}
    <br>
    ${user.intro}
    <c:if test="${user.intro ==null}">
        这家伙很懒，什么都没留下！
    </c:if>

    <a href="user/concerner">关注了${count_er}人</a>  <a href="user/concerned">有${count_ed}个粉丝</a>
   <%-- <div>
        <p>您的设备</p>
        <table border="1">
            <tr>
                <td>设备id</td>
                <td>设备名称</td>
                <td>描述</td>
                <td>编号</td>
                <td>加入时间</td>
                <td>价格</td>
                <td>存放地点</td>
                <td>使用者id</td>
            </tr>
             <c:forEach var="equipment" items="${userEquipmentList}">
                 <tr>
                     <td><c:out value="${equipment.id}"/> </td>
                     <td><c:out value="${equipment.name}"/></td>
                     <td><c:out value="${equipment.description}"/> </td>
                     <td><c:out value="${equipment.code}"/> </td>
                     <td><c:out value="${equipment.add_time}"/> </td>
                     <td><c:out value="${equipment.price}"/> </td>
                     <td><c:out value="${equipment.place}"/> </td>
                     <td><c:out value="${equipment.user_id}"/> </td>
                 </tr>
             </c:forEach>
        </table>
    </div>--%>
<script src="../../jquery/jquery-3.3.1.min.js"></script>
<script>
    $(function(){
        $('#concern').click(function(){
            $.ajax({
                type: "GET",
                url: "concern/handleConcern",
                data: {username: $("#tu").val()},
                dataType: "json",
                success: function () {
                    alert("关注成功");
                    $("#concern").val("已关注");
                }
            });
        });
    });
</script>

</body>
</html>
