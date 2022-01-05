<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>ERROR!</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1>ERROR!</h1>
        <br>
        <div>
            <c:choose>
                <c:when test="${!empty errorMessage}">
                    <h2>
                        <c:out value="${errorMessage}"/>
                    </h2>
                    <% request.getSession().removeAttribute("errorMessage"); %>
                </c:when>
                <c:when test="${empty errorMessage}">
                    <h2>Something went wrong!</h2>
                </c:when>
            </c:choose>
            <h5>Try to find out another clinic.</h5>
            <h5>Maybe it will be better for you health.</h5>
        </div>
    </div>
<c:import url="footer.jsp"/>