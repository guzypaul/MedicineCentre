<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="photoPath" value="/download/"/>
<c:url var="changeDoctor" value="/controller?command=change_doctor_page&doctorId="/>
<c:url var="changeDoctorSchedule" value="/controller?command=change_doctor_schedule_page&doctorScheduleId="/>
<c:url var="deleteDoctorAndSchedule" value="/controller?command=delete_doctor_and_schedule_page&doctorId="/>

<html>
<head>
    <title><c:out value="${doctor.doctorInfo.name}${doctor.doctorInfo.surname}"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isDoctorChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Doctor information was updated!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isDoctorChanged"); %>
    </c:if>
    <c:if test="${isScheduleChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Schedule was updated!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isScheduleChanged"); %>
    </c:if>
    <c:if test="${isDoctorCreated == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>The doctor was added!</strong>
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
                        <a href="${changeDoctor}<c:out value="${doctor.id}"/>" class="btn btn-primary active">Change doctor information</a>
                        <br>
                        <a href="${changeDoctorSchedule}<c:out value="${schedule.id}"/>" class="btn btn-primary active">Change doctor schedule</a>
                        <br>
                        <a href="${deleteDoctorAndSchedule}<c:out value="${doctor.id}"/>" class="btn btn-danger active">Delete doctor with his schedule!</a>
                        <br>
                    </c:if>
                </div>
                <div class="col-lg-8">
                    <h2><c:out value="${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}"/></h2>
                    <br>
                    <h4>Qualification: <c:out value="${doctor.qualification}"/></h4>
                    <h4>Rank: <c:out value="${doctor.rank}"/></h4>
                    <h4>Email: <c:out value="${doctor.doctorInfo.email}"/></h4>
                    <c:if test="${role == 'MODERATOR' || role == 'ADMIN'}">
                        <h4>Phone number: <c:out value="${doctor.doctorInfo.phone}"/></h4>
                    </c:if>
                    <br/>
                    <h3>Schedule of doctor</h3>
                    <h4>Start time: <c:out value="${schedule.startTime}"/></h4>
                    <h4>End time: <c:out value="${schedule.endTime}"/></h4>
                    <h4>Days: <c:out value="${schedule.info}"/></h4>
                </div>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>
