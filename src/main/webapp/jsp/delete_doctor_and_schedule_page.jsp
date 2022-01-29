<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="deleteDoctorAndSchedule" value="/controller?command=delete_doctor_and_schedule"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="delete"/> <fmt:message key="doctor"/> <fmt:message key="and"/> <fmt:message
            key="schedule"/>!!!</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <form action="${deleteDoctorAndSchedule}" method="post">
            <div>
                <label for="doctorId"><fmt:message key="are.you.sure.that.you.want.to.delete"/> <fmt:message
                        key="doctor"/> (<fmt:message key="id"/>=${doctorId}) <fmt:message key="and"/> <fmt:message
                        key="his"/> <fmt:message key="schedule"/>
                    (<fmt:message key="id"/>=${doctorScheduleId})?</label>
                <input id="doctorId" class="form-control" value="${doctorId}" type="hidden"
                       name="doctorId"/>
                <input class="form-control" value="${doctorScheduleId}" type="hidden"
                       name="doctorScheduleId"/>
            </div>
            <div>
                <button type="submit" class="btn btn-warning inactive"><fmt:message key="delete"/></button>
            </div>
        </form>
    </div>

<c:import url="footer.jsp"/>