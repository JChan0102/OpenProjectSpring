<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="members" class="java.util.HashMap" scope="application"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/default.css">

    <style>
        h2, td {
            padding-bottom: 10px;
            padding-top: 10px;
        }

        td {
            text-align: center;
            border: 1px solid black;
            width: 100px;
        }


    </style>
</head>
<body>
<div style="width: 750px; margin: auto">
<%--멤버리스트 페이지로 modi라는 키에 userId값을 get형식으로 보내줌--%>
<form method="post" enctype="multipart/form-data">
    <%@include file="/WEB-INF/views/header/menu.jsp" %>
    <h2> 회원 수정</h2>
    <table>
        <tr>
            <td class="tablehead">
                id
            </td>
            <td>
                <input type="text" readonly name="userId" value="${requestScope.member.userId}">
            </td>

        </tr>
        <tr>
            <td class="tablehead">
                pwd
            </td>
            <td>
                <input type="text" name="userPwd" value="${requestScope.member.userPwd}">
            </td>
        </tr>
        <tr>
            <td class="tablehead">
                name
            </td>
            <td>
                <input type="text" name="userName" value="${requestScope.member.userName}">
            </td>

        </tr>
        <tr>
            <td class="tablehead">
                photo
            </td>
            <td>
                <input type="file" name="photoFile">
                <%--사진을 수정안할 수 있기 때문에 이전값으로 저장해서 보내줌 --%>
                <input type="hidden" name="preuserPhoto" value="${requestScope.member.userPhoto}" >

            </td>

        </tr>
        <tr>
            <td colspan="2" style="padding: 0; height: 70px">
                <input class="summm" type="submit" value="수 정">
            </td>

        </tr>
    </table>
</form>
</div>
</body>
</html>

