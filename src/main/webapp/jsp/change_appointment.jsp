<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeAppointment" value="/controller?command=change_appointment"/>

<html>
<head>
    <title>Change appointment</title>
    <c:import url="header.jsp"/>
    <c:if test="${isAppointmentChanged == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Invalid data!</strong> Try again.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isAppointmentChanged"); %>
    </c:if>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeAppointment}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="appointmentId">Appointment Id ${appointment.id}</label>
                        <input id="appointmentId" class="form-control" value="${appointment.id}"
                               type="hidden" name="appointmentId"/>
                    </div>
                    <div>
                        <label for="clientId">Client Id ${appointment.userClient.id}</label>
                        <input id="clientId" class="form-control" value="${appointment.userClient.id}"
                               type="hidden" name="clientId"/>
                    </div>
                    <div>
                        <label for="doctorId">Doctor Id ${appointment.doctor.id}</label>
                        <input id="doctorId" class="form-control" value="${appointment.doctor.id}"
                               type="hidden" name="doctorId"/>
                    </div>
                    <div>
                        <label for="procedureId">Procedure id ${appointment.procedure.id}</label>
                        <input id="procedureId" class="form-control" value="${appointment.procedure.id}"
                               type="hidden" name="procedureId"/>
                    </div>
                    <br>
                    <div>
                        <label for="date">Date (has been set ${appointment.date}</label>
                        <input id="date" class="form-control" type="date" name="date">
                    </div>
                    <br>
                    <div>
                        <label for="startTime" >Start time (has been set ${appointment.startTime})</label>
                        <input id="startTime" class="form-control" type="time" name="startTime" >
                    </div>
                    <br>
                    <div>
                        <label for="status">Status</label>
                        <select id="status" class="form-select" aria-label="Disabled select example" name="status">
                            <option selected>${appointment.status}</option>
                            <c:forEach items="${statusList}" var="appointmentStatus">
                                <option value="${appointmentStatus}">${appointmentStatus}</option>
                            </c:forEach>
                        </select>
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