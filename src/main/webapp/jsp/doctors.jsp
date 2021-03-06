<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="doctorPage" value="/controller?command=doctor_page&doctorId="/>
<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="photoPath" value="/download/"/>
<c:url var="createDoctor" value="/controller?command=create_doctor_page"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="doctors"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isDoctorAndScheduleDeleted == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="the.doctor.page.and.his.schedule.were.deleted"/>
                <fmt:message key="also.role.was.changed.to.user"/></strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isDoctorAndScheduleDeleted"); %>
    </c:if>
    <main>
        <div class="container-fluid">
            <div class="col-xl-2">
                <h1><fmt:message key="doctors"/>:</h1>
            </div>
            <div class="row">
                <br>
                <c:forEach items="${doctorList}" var="doctor">
                    <div class="col-lg-4">
                        <p><a href="${doctorPage}${doctor.id}">
                            <img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-small-photo"
                                 alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>"></a></p>
                        <div><p>
                            <h3><c:out value="${doctor.qualification.getName()}"/></h3></p>
                            <p><c:out value="${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}"/></p>
                            <p><fmt:message key="rank"/>: <c:out value="${doctor.rank}"/></p>
                        </div>
                        <br>
                    </div>
                </c:forEach>
                <c:if test="${role == 'ADMIN'}">
                    <div class="col-lg-4">
                        <br>
                        <br>
                        <a href="${createDoctor}" class="btn btn-primary active"><fmt:message key="add"/> <fmt:message key="doctor"/></a><br>
                    </div>
                </c:if>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>
