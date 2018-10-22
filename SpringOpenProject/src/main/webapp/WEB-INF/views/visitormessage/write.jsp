
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../css/default.css">
</head>
<body>
<div style="width: 750px; margin: auto">
    <%@include file="/WEB-INF/views/header/menu.jsp" %>
    <form  method="post">
        <table style="border: 1px solid gray">
            <tr>
                <td>name </td>
                <td><input name="userName" value=" ${sessionScope.get('user').getUserName()}" readonly >
                    <input name="userId" type="hidden" value=" ${sessionScope.get('user').getUserId()}" readonly ></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="message" cols="22" row="4"></textarea></td>

            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input type="submit"></td>
            </tr>
        </table>
    </form>


</div>
</body>
</html>
