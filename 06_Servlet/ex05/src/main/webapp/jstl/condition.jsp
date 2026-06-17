<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Condition</title>
</head>
<body>
<%--session의 testResult에 조건식(score>=60)의 참/거짓 값 담김--%>
<c:if test="${score >= 60}" var="testResult" scope="session">
    <p>합격입니다 ^0^</p>
</c:if>
<c:if test="${score < 60}">
    <p>불합격입니다 ㅠ0ㅠ</p>
</c:if>
</body>
</html>
