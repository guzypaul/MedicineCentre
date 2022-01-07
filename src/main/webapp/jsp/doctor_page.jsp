<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="photoPath" value="/photo/"/>

<html>
<head>
    <title><c:out value="${doctor.doctorInfo.name}${doctor.doctorInfo.surname}"/></title>
    <c:import url="header.jsp"/>
    <main>
        <div class="container-fluid">
            <br>
            <div class="row">
                <div class="col-lg-4">
                    <img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-normal-photo"
                         alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>">
                </div>
                <div class="col-lg-8">
                    <h2><c:out value="${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}"/></h2>
                    <br>
                    <h4>Qualification: <c:out value="${doctor.qualification}"/></h4><br/>
                    <h4><c:out value="rank: ${doctor.rank}"/></h4><br/>
                    <h4><c:out value="email: ${doctor.doctorInfo.email}"/></h4><br/>
                    <h3>Schedule of doctor</h3>
                    <h4>Start time: <c:out value="${schedule.startTime}"/></h4>
                    <h4>End time: <c:out value="${schedule.endTime}"/></h4>
                    <h4>Days: <c:out value="${schedule.info}"/></h4>
                </div>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>
