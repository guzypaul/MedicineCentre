<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="procedurePage" value="/controller?command=procedure_page&procedureId="/>

<html>
<head>
    <title>Procedures</title>
</head>
<body>
    <h1>Procedures</h1>
    <br/>
    <c:forEach items="${procedureList}" var="procedure">
        <a href="${procedurePage}${procedure.id}"><p><c:out value="${procedure.name}"/></p></a>
    </c:forEach>
</body>
</html>
