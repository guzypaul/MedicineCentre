<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="contacts"/></title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1><fmt:message key="contacts"/></h1>
        <h3>“StartUP CLINIC” Medical Center
            <p>1200 Memorial Drive</p>
            <p>Dalton, GA 30722-1168</p>
            <p>706.272.6000</p>
            <p>706.272.6001 (TTY)</p>
            <br>
            <p>“StartUP CLINIC” Health Care System</p>
            <p>+375 (29) 676 09 84</p>
            <p>dogovor@clinic.by (http://tel:dogovor@clinic.by/)</p>
            <p>PO Box 1900</p>
            <p>Dalton, GA 30720-1900</p>
            <p>706.272.6000</p>
            <p>hamiltonhealth@hhcs.org</p>
            <p>+375 (17) 293 90 00</p>
            <br>
        </h3>
    </div>
<c:import url="footer.jsp"/>