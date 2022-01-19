<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="deleteDoctorAndSchedule" value="/controller?command=delete_doctor_and_schedule"/>

<html>
<head>
    <title>Delete doctor and schedule!!!</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <form action="${deleteDoctorAndSchedule}" method="post">
            <div>
                <label for="doctorId">Are you sure that you want to delete doctor (id=${doctorId}) and his schedule (id=${doctorScheduleId})?</label>
                <input id="doctorId" class="form-control" value="${doctorId}" type="hidden"
                       name="doctorId"/>
                <input class="form-control" value="${doctorScheduleId}" type="hidden"
                       name="doctorScheduleId"/>
            </div>
            <div>
                <button type="submit" class="btn btn-warning inactive">DELETE</button>
            </div>
        </form>
    </div>

<c:import url="footer.jsp"/>