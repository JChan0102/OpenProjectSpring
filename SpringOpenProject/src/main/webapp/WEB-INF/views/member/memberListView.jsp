<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/default.css">
    <link rel="stylesheet" href="../css/memberList.css">
</head>
<body>
<div style="width: 750px; margin: auto">
<%@include file="/WEB-INF/views/header/menu.jsp" %>
<h2>회원리스트</h2>
<table>
    <tr class="tablehead">
        <td>
            Id
        </td>
        <td>
            pwd
        </td>
        <td>
            name
        </td>
        <td>
            photo
        </td>
        <td>
            수정 / 삭제
        </td>
    </tr>
    <%-- List의 값 하나씩 출력.--%>
<c:choose>
    <c:when test="${members.size()!=0}">
  <c:forEach items="${members}" var="member">
      <tr>
          <td>
              ${member.userId}
          </td>
          <td>${member.userPwd}
          </td>
          <td>${member.userName}
          </td>
          <td ><img style="width: 160px" alt="회원사진" src="${pageContext.request.contextPath}/uploadFile/userphoto/${member.userPhoto}">
          </td>
          <%--수정 버튼 클릭시 modiid라는 키에 userID값을 get형식으로 보내줌
              삭제 버튼 클릭시 removeid라는 키에 userID값을 get형식으로 보내줌--%>
          <td>
              <c:if test="${sessionScope.user.userId eq member.userId}">
                  <a href="/member/modify?modiid=${member.userId}"><button>수정</button></a> / <a href="/member/remove?removeid=${member.userId}"><button>삭제</button></a>
              </c:if>
          </td>
      </tr>

  </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td colspan="5">등록된 회원 정보가 없습니다.</td>
        </tr>
    </c:otherwise>
</c:choose>
</table>

</div>
</body>

</html>
