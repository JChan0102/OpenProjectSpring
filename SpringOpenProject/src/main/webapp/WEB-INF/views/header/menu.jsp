<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>
   
<h1 class="headtitle"><a class="navia" href="/">OpenProject</a></h1>
<ul id="gnd">
    <li><a class="navia" href="/">HOME</a></li>
    <li><a class="navia" href="/member/signup">회원가입</a></li>
    <c:choose>
        <c:when test="${sessionScope.containsKey('user')}">
            <li><a class="navia" href="/member/logout">로그아웃</a></li>
        </c:when>
        <c:otherwise>
            <li><a class="navia" href="/member/signin">회원로그인</a></li>

        </c:otherwise>

    </c:choose>


    <li><a class="navia" href="${pageContext.request.contextPath}/member/mypage">마이페이지</a></li>
    <li><a class="navia" href="${pageContext.request.contextPath}/member/memberList">회원리스트</a></li>
    <li><a class="navia" href="${pageContext.request.contextPath}/member/JSONXMLList">회원리스트(json, XML)</a></li>
    <li><a class="navia" href="${pageContext.request.contextPath}/view/visitorMessage.jsp">방명록</a></li>

</ul>