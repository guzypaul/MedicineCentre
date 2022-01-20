<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="createAppointment" value="/controller?command=create_appointment"/>

<html>
<head>
    <title>Make appointment</title>
    <c:import url="header.jsp"/>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${createAppointment}" method="post">
                <div class="container-fluid">
                    <div>
                        <input class="form-control" value="${userId}" type="hidden" name="userId"/>
                        <input class="form-control" value="${procedureId}" type="hidden" name="procedureId"/>
                        <input class="form-control" value="CLAIMED" type="hidden" name="status"/>
                    </div>
                    <br>
                    <div>
                        <label for="doctorId">Doctor id</label>
                        <input id="doctorId" class="form-control" tabindex="1" placeholder="Doctor Id" type="text" name="doctorId"/>
                    </div>
                    <br>
                    <div>
                        <label for="date">Date</label>
                        <input id="date" class="form-control" tabindex="2" placeholder="yyyy-mm-dd" type="text" name="date"/>
                    </div>
                    <br>
                    <div>
                        <label for="startTime">Start time</label>
                        <input id="startTime" class="form-control" tabindex="3" placeholder="hh:mm:ss" type="text" name="startTime"/>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning">Make appointment</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>