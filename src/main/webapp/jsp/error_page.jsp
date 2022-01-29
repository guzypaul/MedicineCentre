<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="error"/>!</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1><fmt:message key="error"/>!</h1>
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
                    <h2><fmt:message key="something.went.wrong"/>!</h2>
                </c:when>
            </c:choose>
            <h5><fmt:message key="try.to.find.out.another.clinic"/></h5>
            <h5><fmt:message key="maybe.it.will.be.better.for.you.health"/></h5>
        </div>
    </div>
<c:import url="footer.jsp"/>