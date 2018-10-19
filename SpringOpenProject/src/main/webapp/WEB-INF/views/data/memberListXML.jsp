<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<members>
    <c:forEach items="${members}" var="member">
        <member>
            <userId>
                    ${member.userId}
            </userId>
            <userPwd>
                    ${member.userPwd}
            </userPwd>
            <userName>
                    ${member.userName}
            </userName>
            <userPhoto>
                    ${member.userPhoto}
            </userPhoto>
        </member>
    </c:forEach>
</members>