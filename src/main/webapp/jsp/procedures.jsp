<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>procedures</h1>
    <br/>
    <c:forEach items="${procedureList}" var="procedure">
        <a href=""><p><c:out value="${procedure.name}"/></p></a>
    </c:forEach>
</body>
</html>
