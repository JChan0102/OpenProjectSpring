<%--
  Created by IntelliJ IDEA.
  User: JChan
  Date: 2018-10-21
  Time: 오후 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/default.css">
    <style>
        .btn{
            width: 130px;
            height: 60px;
            margin-right: 5px;
            margin-bottom: 10px;
            background-color: white;
            border-radius: 5px;
            border: 1px solid gray;
            font-size: 1.2em;
        }
        .btn:hover{
            background-color: gray;
            color: white;
        }
    </style>
</head>
<body>
<div style="width: 750px; margin: auto">
    <%@include file="/WEB-INF/views/header/menu.jsp" %>

<c:choose>
    <c:when test="${equalmessage}">
        <a href="/visitormessage/del/${messageId}"><button class="btn">삭제하기</button></a>
        <a href="/visitormessage/list"><button class="btn">돌아가기</button></a>
    </c:when>
    <c:otherwise>
        회원님께서 작성하신 메세지가 아닙니다.
        <a href="/visitormessage/list">돌아가기</a>
    </c:otherwise>
</c:choose>

</div>
</body>
</html>
