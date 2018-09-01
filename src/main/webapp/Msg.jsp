<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.entity.Message" %><%--
  Created by IntelliJ IDEA.
  User: 18735
  Date: 2018/8/24
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言板</title>

    <link href="css/myCss.css" type="text/css" rel="stylesheet"/>
    <style>
        .error{
            color: red;
        }
    </style>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_cn.js"></script>
    <script>
        $(function () {
            // 0. 表单验证
            $("#msgForm").validate({
                // onsubmit:true,// 是否在提交是验证
                // onfocusout:false,// 是否在获取焦点时验证
                // onkeyup :false,// 是否在敲击键盘时验证
                rules:{
                    username: {
                        required: true
                    },
                    message: {
                        required: true,
                        maxLength: 100
                    }
                }
            });
        })
    </script>
</head>
<body>
<div class="User">
    <c:if test="$(num=='1')">
        <c:out value="发布成功"></c:out>
    </c:if>
    <form action="/addMsg" method="post" id="msgForm">
        用户：<input type="text" name="username"><br><br>
        留言：<textarea cols="40" rows="5" name="message" class="comment"></textarea>
        <input type="submit" value="提交">
        <input type="reset" value="清除"/>
    </form>
</div>
<div class="page">
    <input class="btn1" type="button" value="上一页" onClick="">
    <input class="btn2" type="button" value="下一页" onClick="">
</div><br>
<div class="messageShow">
    <%--<%--%>
        <%--List<Message> list = (List<Message>) request.getAttribute("list");--%>
        <%--for (int i=0; i<list.size(); i++){--%>
    <%--%>--%>
    <c:>
        for()
    </c:>
    <div class="info">
        <p class="user">
            用户名：<span class="userName"><%=list.get(i).getUsername()%></span>
            <span class="userId"><%=list.get(i).getId()%></span>
        </p>
        <p class="infoText"><%=list.get(i).getMessage()%></p>
        <p class="infoOpen">
            <span class="infoTime"><%=list.get(i).getTime()%></span>
            <span>发表于：</span>
        </p>
    </div>
    <%--<%}%>--%>
</div>
</body>
</html>