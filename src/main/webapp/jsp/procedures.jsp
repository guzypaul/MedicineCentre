<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="procedurePage" value="/controller?command=procedure_page&procedureId="/>
<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="imgPath" value="/download/"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title>Procedures</title>
    <c:import url="header.jsp"/>
    <main>
        <c:if test="${isUserAuthorized == true && role == 'USER'}">
            <div class="container-fluid alert-indents">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Authorization is successfully!</strong> You can make appointments now.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </div>
            <% request.getSession().removeAttribute("isUserAuthorized"); %>
        </c:if>
        <c:if test="${isUserLogout == true}">
            <div class="container-fluid alert-indents">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>You logout successfully!</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </div>
            <% request.getSession().removeAttribute("isUserLogout"); %>
        </c:if>
        <div class="container-fluid">
            <div class="col-xl-2">
                <h1 class="procedures"><fmt:message key="procedures"/>:</h1>
                <br>
            </div>
            <div class="row">
                    <c:forEach items="${procedureList}" var="procedure">
                        <div class="col-lg-4">
                            <h2><c:out value="${procedure.name}"/></h2>
                            <p><a href="${procedurePage}${procedure.id}">
                                <img src="${imgPath}${procedure.imageName}" class="img-fluid procedure-img"
                                     alt="<c:out value="${procedure.name}"/>"></a></p>
                        </div>
                    </c:forEach>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>

