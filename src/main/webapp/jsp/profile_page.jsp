<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="photoPath" value="/download/"/>
<c:url var="appointments" value="/controller?command=appointments"/>
<c:url var="users" value="/controller?command=users"/>
<c:url var="changeUser" value="/controller?command=change_user_page&userId="/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="profile"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isUserChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="your.information.was.updated"/>!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isUserChanged"); %>
    </c:if>
    <div class="container-fluid">
        <h1><fmt:message key="welcome.in.your.personal.area.with"/> ${role} <fmt:message key="rights"/>!</h1>
        <br>
        <h2><fmt:message key="your.personal.information"/></h2>
        <br>
        <div class="row">
            <div class="col-lg-4">
                <h4><fmt:message key="name"/>: <c:out value="${user.name}"/></h4>
                <h4><fmt:message key="surname"/>: <c:out value="${user.surname}"/></h4>
                <h4><fmt:message key="email"/>: <c:out value="${user.email}"/></h4>
                <h4><fmt:message key="phone.number"/>: <c:out value="${user.phone}"/></h4>
                <br/>
            </div>
            <c:if test="${role == 'DOCTOR'}">
                <div class="col-lg-4">
                    <h4><fmt:message key="qualification"/>: <c:out value="${doctor.qualification.getName()}"/></h4>
                    <h4><fmt:message key="rank"/>: <c:out value="${doctor.rank}"/></h4>
                    <h4><fmt:message key="schedule"/></h4>
                    <h4><fmt:message key="start.time"/>: <c:out value="${schedule.startTime}"/></h4>
                    <h4><fmt:message key="end.time"/>: <c:out value="${schedule.endTime}"/></h4>
                    <h4><fmt:message key="days"/>: <c:out value="${schedule.info}"/></h4>
                </div>
                <div class="col-lg-4">
                    <img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-small-photo"
                         alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>">
                </div>
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active" aria-current="page"><fmt:message key="my"/>
                        <fmt:message key="appointments"/></a>
                </div>
            </c:if>
            <c:if test="${role == 'USER'}">
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active"><fmt:message key="my"/>
                        <fmt:message key="appointments"/></a>
                    <a href="${changeUser}<c:out value="${user.id}"/>" class="btn btn-primary active">
                        <fmt:message key="change"/> <fmt:message key="my"/> <fmt:message key="information"/></a>
                </div>
            </c:if>
            <c:if test="${role == 'MODERATOR' || role == 'ADMIN'}">
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active"><fmt:message key="appointments"/></a>
                    <a href="${users}" class="btn btn-primary active"><fmt:message key="users"/></a>
                </div>
            </c:if>
        </div>
    </div>
<c:import url="footer.jsp"/>