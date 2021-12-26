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
            <img src="${photoPath}${doctor.photoName}" class="img-fluid"
                 alt="<c:out value="${doctor.doctorInfo.name}
                                 ${doctor.doctorInfo.surname}"/>"></a></p>
            <p>
            <h2><c:out value="${doctor.doctorInfo.name}${doctor.doctorInfo.surname}"/></h2>
            <h4>Qualification: <c:out value="${doctor.qualification}"/></h4><br/>
            <h4><c:out value="rank: ${doctor.rank}"/></h4><br/>
            <h4><c:out value="email: ${doctor.doctorInfo.email}"/></h4><br/>
        </div>
    </main>
    <c:import url="footer.jsp"/>
