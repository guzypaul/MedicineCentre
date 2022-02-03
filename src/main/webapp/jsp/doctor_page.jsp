<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="photoPath" value="/download/"/>
<c:url var="changeDoctor" value="/controller?command=change_doctor_page&doctorId="/>
<c:url var="changeDoctorSchedule" value="/controller?command=change_doctor_schedule_page&doctorScheduleId="/>
<c:url var="deleteDoctorAndSchedule" value="/controller?command=delete_doctor_and_schedule_page&doctorId="/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><c:out value="${doctor.doctorInfo.name}${doctor.doctorInfo.surname}"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isDoctorChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="doctor.information.was.updated"/></strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isDoctorChanged"); %>
    </c:if>
    <c:if test="${isScheduleChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="schedule.was.updated"/></strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isScheduleChanged"); %>
    </c:if>
    <c:if test="${isDoctorCreated == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="the.doctor.was.added"/></strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
        <% request.getSession().removeAttribute("isDoctorCreated"); %>
    </c:if>
    <main>
        <div class="container-fluid">
            <br>
            <div class="row">
                <div class="col-lg-4">
                    <img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-normal-photo"
                         alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>">
                    <br>
                    <c:if test="${role == 'ADMIN'}">
                        <br>
                        <a href="${changeDoctor}<c:out value="${doctor.id}"/>" class="btn btn-primary active"><fmt:message key="change.doctor.information"/></a>
                        <br>
                        <a href="${changeDoctorSchedule}<c:out value="${schedule.id}"/>" class="btn btn-primary active"><fmt:message key="change.doctor.schedule"/></a>
                        <br>
                        <a href="${deleteDoctorAndSchedule}<c:out value="${doctor.id}"/>" class="btn btn-danger active"><fmt:message key="delete.doctor.with.his.schedule"/></a>
                        <br>
                    </c:if>
                </div>
                <div class="col-lg-8">
                    <h2><c:out value="${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}"/></h2>
                    <br>
                    <h4><fmt:message key="qualification"/>: <c:out value="${doctor.qualification.getName()}"/></h4>
                    <h4><fmt:message key="rank"/>: <c:out value="${doctor.rank}"/></h4>
                    <h4><fmt:message key="email"/>: <c:out value="${doctor.doctorInfo.email}"/></h4>
                    <c:if test="${role == 'MODERATOR' || role == 'ADMIN'}">
                        <h4><fmt:message key="phone.number"/>: <c:out value="${doctor.doctorInfo.phone}"/></h4>
                    </c:if>
                    <br/>
                    <h3><fmt:message key="schedule.of.doctor"/></h3>
                    <h4><fmt:message key="start.time"/>: <c:out value="${schedule.startTime}"/></h4>
                    <h4><fmt:message key="end.time"/>: <c:out value="${schedule.endTime}"/></h4>
                    <h4><fmt:message key="days"/>: <c:out value="${schedule.info}"/></h4>
                </div>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>
