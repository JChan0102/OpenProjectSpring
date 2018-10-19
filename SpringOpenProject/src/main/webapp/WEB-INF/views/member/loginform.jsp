<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <title>$Title$</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
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
    <h2>Login</h2>
    <hr>
    <%--로그인 실패시 저장한 msg값 출력--%>
    <p style="color: red">${msg}</p>
    <form method="post">
        <table>
            <tr>
                <td>아이디(이메일)</td>

                <%--cookie에 저장된 이전 아이디값 출력, 혹은 없으면 빈 문자열 출력--%>
                <td><input type="text" required name="userId" value="${cookie.preId.value}">
                    <input type="checkbox"
                    <%--cookie가 있으면 체크를 했던것이기 때문에 checked 설정--%>
                    <c:if test="${cookie.containsKey('preId')}">
                           checked
                    </c:if>
                           name="idck">
                </td>
            </tr>

            <tr>
                <td>비밀번호</td>
                <td><input type="password" required name="userPwd"></td>
            </tr>

            <tr>
                <td colspan="2" style="text-align: center"><input type="submit" value="로그인"></td>
            </tr>
        </table>
    </form>
</div>
</div>
</body>
</html>