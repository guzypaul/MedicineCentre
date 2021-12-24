<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="procedurePage" value="/controller?command=procedure_page&procedureId="/>
<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="imgPath" value="/download/"/>

<html>
<head>
    <title>Procedures</title>
    <c:import url="header.jsp"/>
    <main>
        <div class="container-fluid">
            <div class="col-xl-2">
                <h1 class="procedures">Procedures:</h1>
            </div>
            <div class="row">
                <div class="col-xl-3">
                    <c:forEach items="${procedureList}" var="procedure">
                        <c:out value="${procedure.name}"/>
                        <a href="${procedurePage}${procedure.id}">
                        <img src="${imgPath}${procedure.imageName}" class="img-fluid"
                             alt="<c:out value="${procedure.name}"/>"></a></p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>

