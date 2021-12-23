<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title><c:out value="${procedure.name}"/></title>
    </head>
    <body>
        <h1><c:out value="${procedure.name}"/></h1>
        <br/>
        <h4>Описание: <c:out value="${procedure.description}"/></h4><br/>
        <h4>Длительность: <c:out value="${procedure.duration}"/></h4><br/>
        <h4>Стоимость: <c:out value="${procedure.price}"/></h4><br/>
    </body>
</html>
