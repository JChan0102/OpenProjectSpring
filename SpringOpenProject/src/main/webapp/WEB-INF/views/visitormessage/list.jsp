<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
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

    <a href="/visitormessage/write"> <button class="btn">방명록 남기기</button></a>
    <c:choose>
        <c:when test="${viewData.isEmpty() }">
            등록된 메세지가 없습니다.
        </c:when>
        <c:otherwise>
            <table border="1">
                <c:forEach var="message" items="${viewData.messageList }">
                    <tr>
                        <td>메시지 번호: ${message.visitormessage_id } <br />
                            손님 이름: ${message.userName }	<br />
                            메시지:${message.message } <br />
                            <a href="/visitormessage/del?messageId=${message.visitormessage_id }">[삭제하기]</a>
                            <a href="/visitormessage/view/${message.visitormessage_id }">상세보기</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:forEach var="i" begin="1" end="${viewData.pageTotalCount }">

                <a href="/visitormessage/list?page=${i}">[${i}]</a>
            </c:forEach>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
