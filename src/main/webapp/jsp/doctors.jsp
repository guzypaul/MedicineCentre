<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="doctorPage" value="/controller?command=doctor_page&doctorId="/>
<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="photoPath" value="/photo/"/>
<c:url var="createDoctor" value="/controller?command=create_doctor_page"/>

<html>
<head>
    <title>Doctors</title>
    <c:import url="header.jsp"/>
    <main>
        <div class="container-fluid">
            <div class="col-xl-2">
                <h1>Doctors:</h1>
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
                            <h3><c:out value="${doctor.qualification}"/></h3></p>
                            <p><c:out value="${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}"/></p>
                            <p><c:out value="rank: ${doctor.rank}"/></p>
                        </div>
                        <br>
                    </div>
                </c:forEach>
                <c:if test="${role == 'ADMIN'}">
                    <div class="col-lg-4">
                        <br>
                        <a href="${createDoctor}" class="btn btn-primary active">Create doctor</a><br>
                    </div>
                </c:if>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>
