<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="photoPath" value="/download/"/>
<c:url var="createAppointment" value="/controller?command=create_appointment"/>
<c:url var="doctorPage" value="/controller?command=doctor_page&doctorId="/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="make"/> <fmt:message key="appointment"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isAppointmentCreated == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong><fmt:message key="invalid.data"/></strong> <fmt:message key="try.again"/>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isAppointmentCreated"); %>
    </c:if>
    <div>
        <h1>${procedureName}</h1>
        <h2><fmt:message key="choose.doctor.please"/></h2>
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
                                    <h5><c:out value="${doctor.qualification.getName()}"/></h5>
                                    <h5><fmt:message key="rank"/>: <c:out value="${doctor.rank}"/></h5>
                                    <h5><a href="${doctorPage}${doctor.id}"><fmt:message key="see.more.info"/></a></h5>
                                </div>
                                <br>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-5"></div>
                    <div class="col-lg-2">
                        <div>
                            <input class="form-control" value="${userId}" type="hidden" name="userId"/>
                            <input class="form-control" value="${procedureId}" type="hidden" name="procedureId"/>
                            <input class="form-control" value="${status}" type="hidden" name="status"/>
                        </div>
                        <br>
                        <div>
                            <label for="date"><fmt:message key="date"/></label>
                            <input id="date" class="form-control" type="date" name="date">
                        </div>
                        <br>
                        <div>
                            <label for="startTime"><fmt:message key="start.time"/></label>
                            <input id="startTime" class="form-control" type="time" name="startTime">
                        </div>
                        <br>
                        <div>
                            <button type="submit" class="btn btn-warning"><fmt:message key="make"/> <fmt:message key="appointment"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
<c:import url="footer.jsp"/>