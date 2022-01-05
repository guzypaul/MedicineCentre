
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Profile</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1>WELCOME <c:out value="${user.name} ${user.surname}"/> in your PERSONAL AREA with ${role} rights !</h1>
        <br>
        <div class="row">
            <div class="col-lg-8">
                <h2>Your personal information</h2>
                <br>
                <h4>Email: <c:out value="${user.email}"/></h4><br/>
                <h4>Phone number: <c:out value="${user.phone}"/></h4><br/>
            </div>
        </div>
    </div>
<c:import url="footer.jsp"/>