<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeAppointment" value="/controller?command=change_appointment"/>

<html>
<head>
    <title>Change appointment</title>
    <c:import url="header.jsp"/>

    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeAppointment}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="clientId">Client Id</label>
                        <input id="clientId" class="form-control" tabindex="1" placeholder="${appointment.userClient.id}" type="text" name="clientId"/>
                    </div>
                    <br>
                    <div>
                        <label for="doctorId">Doctor Id</label>
                        <input id="doctorId" class="form-control" tabindex="2" placeholder="${appointment.doctor.id}" type="text" name="doctorId"/>
                    </div>
                    <br>
                    <div>
                        <label for="date">Date</label>
                        <input id="date" class="form-control" tabindex="3" placeholder="${appointment.date}" type="text" name="date" />
                    </div>
                    <br>
                    <div>
                        <label for="startTime">Start time</label>
                        <input id="startTime" class="form-control" tabindex="4" placeholder="${appointment.startTime}" type="text" name="startTime" />
                    </div>
                    <br>
                    <div>
                        <label for="endTime">End time</label>
                        <input id="endTime" class="form-control" tabindex="5" placeholder="${appointment.endTime}" type="text" name="endTime" />
                    </div>
                    <br>
                    <div>
                        <label for="procedureId">Procedure id</label>
                        <input id="procedureId" class="form-control" tabindex="6" placeholder="${appointment.procedure.id}" type="text" name="procedureId" />
                    </div>
                    <br>
                    <div>
                        <label for="status">Status</label>
                        <input id="status" class="form-control" tabindex="7" placeholder="${appointment.status}" type="text" name="status" />
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