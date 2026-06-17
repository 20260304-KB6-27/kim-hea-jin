<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    if("clear".equals(request.getParameter("action"))) {--%>
<%--      session.invalidate(); // 세션 초기화(jstl에서는 사용불가)--%>
<%--      response.sendRedirect("scope2.jsp");  // 리다이렉트--%>
<%--      return;--%>
<%--    }--%>
<%--%>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--세션초기화 버튼 클릭--%>
<c:if test="${param.action eq 'clear'}">
    <%--session의 scopeName 삭제--%>
    <c:remove var="scopeName" scope="session"/>
    <%--scope2로 이동--%>
    <c:redirect url="scope2.jsp" />
</c:if>

<html>
<head>
    <title>Scope</title>
</head>
<body>
<h1>scope 데이터 보기 </h1>

pageScope의 속성값은 : ${pageScope.scopeName}<br>
requestScope의 속성값은 : ${requestScope.scopeName}<br>
sessionScope의 속성값은 : ${sessionScope.scopeName}<br>
applicationScope의 속성값은 : ${applicationScope.scopeName}<br>

member: ${member.name}(${member.userid})<br>
탐색한 결과의 속성값은 : ${scopeName}<br>

<a href="scope2.jsp?action=clear">
    <button>세션초기화</button>
</a>
</body>
</html>