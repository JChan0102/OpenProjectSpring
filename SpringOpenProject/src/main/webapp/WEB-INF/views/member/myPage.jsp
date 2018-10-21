<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <style>
        h2, td {
            padding-bottom: 10px;
            padding-top: 10px;
        }

        #memberPhoto>img {
            width: 150px;
            height: 150px;
            border: 1px solid gray;
            border-radius: 50%;
        }

    </style>
    <link rel="stylesheet" href="../css/default.css">
</head>
<body>
<div style="width: 750px; margin: auto">
<%@include file="/WEB-INF/views/header/menu.jsp" %>
<div class="content">
    <h2>회원정보</h2>
    <div id="memberPhoto"><img alt="회원사진" src="${pageContext.request.contextPath}/uploadFile/userphoto/${user.userPhoto}">  </div>
    <hr>
    <table>
        <table>
            <tr>
                <%--session에 저장된 member객체 user를 통해 id값, name값 가져옴--%>
                <td>id : ${user.userId}
                </td>
            </tr>
            <tr>
                <td>이름 : ${user.userName}
                </td>
            </tr>
        </table>


    </table>

</div>
</div>
</body>
</html>
