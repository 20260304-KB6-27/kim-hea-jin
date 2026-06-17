<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloView</title>
</head>
<body>
<%--
EL (Expression Language)
- JSP 자바 코드를 직접 작성하지 않고 속성 출력가능하도록 돕는 표현식 문법
- 주로 jsp에서 scope에 저장된 데이터를 꺼낼 때 사용
--%>

<%--WEB_INF 내부에 있을 경우 forward로만 접근가능--%>

<%--EL 문법 사용--%>
<p>안녕하세요. ${username}</p>

<%--EL 문법 미사용--%>
<p>안녕하세요. <%= request.getAttribute("username")%></p>
</body>
</html>
