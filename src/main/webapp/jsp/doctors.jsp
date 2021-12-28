<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="doctorPage" value="/controller?command=doctor_page&doctorId="/>
<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="photoPath" value="/photo/"/>

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
                <div class="col-xl-6">
                    <c:forEach items="${doctorList}" var="doctor">
                        <p><a href="${doctorPage}${doctor.id}">
                            <img src="${photoPath}${doctor.photoName}" class="img-fluid doctor-img"
                                 alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>"></a></p>
                        <div><p><c:out value="${doctor.qualification}"/></p>
                            <p><c:out value="${doctor.doctorInfo.name}${doctor.doctorInfo.surname}"/></p>
                            <p><c:out value="rank: ${doctor.rank}"/></p>
                        </div>
                        <br>
                    </c:forEach>
                </div>
            </div>
        </div>
    </main>
    <c:import url="footer.jsp"/>
