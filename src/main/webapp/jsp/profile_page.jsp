<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="photoPath" value="/photo/"/>
<c:url var="appointments" value="/controller?command=appointments"/>

<html>
<head>
    <title>Profile</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1>WELCOME in your PERSONAL AREA with ${role} rights !</h1>
        <br>
        <h2>Your personal information</h2>
        <br>
        <div class="row">
            <div class="col-lg-4">
                <h4>Name: <c:out value="${user.name}"/></h4>
                <h4>Surname: <c:out value="${user.surname}"/></h4>
                <h4>Email: <c:out value="${user.email}"/></h4>
                <h4>Phone number: <c:out value="${user.phone}"/></h4>
                <br/>
            </div>
            <c:if test="${role == 'DOCTOR'}">
                <div class="col-lg-4">
                    <h4>Qualification: <c:out value="${doctor.qualification}"/></h4>
                    <h4>Rank: <c:out value="${doctor.rank}"/></h4>
                    <h4>Schedule</h4>
                    <h4>Start time: <c:out value="${schedule.startTime}"/></h4>
                    <h4>End time: <c:out value="${schedule.endTime}"/></h4>
                    <h4>Days: <c:out value="${schedule.info}"/></h4>
                </div>
                <div class="col-lg-4">
                    <img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-small-photo"
                         alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>">
                </div>
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active" aria-current="page">My appointments</a>
                </div>
            </c:if>
            <c:if test="${role == 'USER'}">
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active">My appointments</a>
                </div>
            </c:if>
            <c:if test="${role == 'MODERATOR'}">
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active">Appointments</a>
                    <a href="#" class="btn btn-primary active">Clients</a>
                    <a href="#" class="btn btn-primary active">Doctors</a>
                </div>
            </c:if>
            <c:if test="${role == 'ADMIN'}">
                <div class="col-lg-4">
                    <a href="${appointments}" class="btn btn-primary active">Appointments</a>
                    <a href="#" class="btn btn-primary active">Clients</a>
                    <a href="#" class="btn btn-primary active">Doctors</a>
                    <a href="#" class="btn btn-primary active">Procedures</a>
                </div>
            </c:if>
        </div>
    </div>
<c:import url="footer.jsp"/>