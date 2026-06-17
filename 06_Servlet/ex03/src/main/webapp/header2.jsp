<%-- import 지시어 --%>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // main2.jsp에서 nickName 받아옴
        String nickName = request.getParameter("nickName");

        // page scope: jsp 파일 안에서만 사용가능
        // request scope: 요청부터 응답까지 사용가능
        // session: 브라우저 세션 유지동안 사용가능
        // application scope: 어플리케이션 동작동안 사용가능
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
    %>
    <%-- 표현식 --%>
    <br>안녕하세요 <%= nickName %>님, <br>
    현재 시간은 <%= hour %>시 <%= minute %>분 입니다.
</body>
</html>
