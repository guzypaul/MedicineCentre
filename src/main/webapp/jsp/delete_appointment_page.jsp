<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="deleteAppointment" value="/controller?command=delete_appointment"/>

<html>
<head>
    <title>Delete appointment</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <form action="${deleteAppointment}" method="post">
            <div>
                <label for="appointmentId">Are you sure that you want to delete appointment with id= ${appointmentId}?</label>
                <input id="appointmentId" class="form-control" value="${appointmentId}" type="hidden"
                       name="appointmentId"/>
            </div>
            <div>
                <button type="submit" class="btn btn-warning">DELETE</button>
            </div>
        </form>
    </div>

<c:import url="footer.jsp"/>