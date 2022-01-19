<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeDoctorSchedule" value="/controller?command=change_doctor_schedule"/>

<html>
<head>
    <title>Change user</title>
    <c:import url="header.jsp"/>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeDoctorSchedule}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="doctorScheduleId">Doctor Schedule id=${doctorSchedule.id} </label>
                        <input id="doctorScheduleId" class="form-control" value="${doctorSchedule.id}" type="hidden"
                               name="doctorScheduleId"/>
                        <input id="doctorId" class="form-control" value="${doctorSchedule.doctor.id}" type="hidden"
                               name="doctorId"/>
                    </div>
                    <br>
                    <div>
                        <label for="startTime">Start time</label>
                        <input id="startTime" class="form-control" tabindex="1" value="${doctorSchedule.startTime}" type="text"
                               name="startTime"/>
                    </div>
                    <br>
                    <div>
                        <label for="endTime">End time</label>
                        <input id="endTime" class="form-control" tabindex="2" value="${doctorSchedule.endTime}" type="text"
                               name="endTime"/>
                    </div>
                    <br>
                    <div>
                        <label for="info">Days of week</label>
                        <input id="info" class="form-control" tabindex="3" value="${doctorSchedule.info}" type="text"
                               name="info"/>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning">CHANGE</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>