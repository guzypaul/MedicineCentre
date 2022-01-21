<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="photoPath" value="/photo/"/>
<c:url var="createAppointment" value="/controller?command=create_appointment"/>
<c:url var="doctorPage" value="/controller?command=doctor_page&doctorId="/>

<html>
<head>
    <title>Make appointment</title>
    <c:import url="header.jsp"/>
    <div>
        <h1>${procedureName}</h1>
        <h2>Choose doctor please!</h2>
    </div>
    <div class="row">
        <form class="registration-inputs" action="${createAppointment}" method="post">
            <div class="container-fluid">
                <div class="row">
                    <br>
                    <c:forEach items="${doctorList}" var="doctor">
                        <div class="col-lg-3">
                            <div class="form-check">
                                <input value="${doctor.id}" class="form-check-input" type="radio" name="doctorId"
                                       id="flexRadioDefault1">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    <h5><c:out value="${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}"/></h5>
                                </label>
                                <p><img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-small-photo"
                                        alt="<c:out value="${doctor.doctorInfo.name}
                                            ${doctor.doctorInfo.surname}"/>"></p>
                                <div>
                                    <h5><c:out value="${doctor.qualification}"/></h5>
                                    <h5><c:out value="rank: ${doctor.rank}"/></h5>
                                    <h5><a href="${doctorPage}${doctor.id}">See more info</a></h5>
                                </div>
                                <br>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div>
                            <input class="form-control" value="${userId}" type="hidden" name="userId"/>
                            <input class="form-control" value="${procedureId}" type="hidden" name="procedureId"/>
                            <input class="form-control" value="CLAIMED" type="hidden" name="status"/>
                        </div>
                        <br>
                        <div>
                            <label for="date">Date</label>
                            <input id="date" class="form-control" tabindex="2" placeholder="yyyy-mm-dd" type="text"
                                   name="date"/>
                        </div>
                        <br>
                        <div>
                            <label for="startTime">Start time</label>
                            <input id="startTime" class="form-control" tabindex="3" placeholder="hh:mm:ss" type="text"
                                   name="startTime"/>
                        </div>
                        <br>
                        <div>
                            <button type="submit" class="btn btn-warning">Make appointment</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
<c:import url="footer.jsp"/>