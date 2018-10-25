<%--
  Created by IntelliJ IDEA.
  User: JChan
  Date: 2018-10-21
  Time: 오후 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/default.css">
</head>
<body>
<div style="width: 750px; margin: auto">
    <%@include file="/WEB-INF/views/header/menu.jsp" %>

id : ${message.visitormessage_id}<br/>
userName : ${message.userName}<br/>
userId : ${message.userId}<br/>
message : ${message.message}<br/>

<a href="/visitormessage/list"> 돌아가기 </a>

</div>
</body>
</html>
