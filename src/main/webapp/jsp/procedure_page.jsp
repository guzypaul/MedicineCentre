<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="imgPath" value="/download/"/>

<html>
<head>
    <title><c:out value="${procedure.name}"/></title>
    <c:import url="header.jsp"/>
    <main>
        <div class="container-fluid">
            <h1><c:out value="${procedure.name}"/></h1>
            <img src="${imgPath}${procedure.imageName}" class="img-fluid procedure-big-img"
                 alt="<c:out value="${procedure.name}"/>">
            <br/>
            <h4>Описание: <c:out value="${procedure.description}"/></h4><br/>
            <h4>Длительность: <c:out value="${procedure.duration}"/></h4><br/>
            <h4>Стоимость: <c:out value="${procedure.price}"/></h4><br/>
        </div>
    </main>
    <c:import url="footer.jsp"/>


