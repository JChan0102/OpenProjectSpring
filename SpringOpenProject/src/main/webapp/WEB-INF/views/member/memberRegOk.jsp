<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../css/default.css">
    <style>
        h2, td {
            padding-bottom: 10px;
            padding-top: 10px;
        }

    </style>
</head>
<body>
<div style="width: 750px; margin: auto">
    <%@include file="/WEB-INF/views/header/menu.jsp" %>
    <div class="content">
          Id : ${requestScope.member.userId}<br>
          PW : ${requestScope.member.userPwd}<br>
          NAME : ${requestScope.member.userName}<br>
          PhotoName : ${requestScope.member.userPhoto}<br>
        <a href="/member/signin"><button>로그인하기</button></a>
    </div>
</div>
</body>
</html>
