<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeAppointmentPage" value="/controller?command=change_appointment_page&appointmentId="/>
<c:url var="deleteAppointment" value="/controller?command=delete_appointment_page&appointmentId="/>


<html>
<head>
    <title>AppointmentList</title>
    <c:import url="header.jsp"/>
    <c:if test="${isAppointmentChanged == true}">
        <div class="container-fluid alert-indents">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>The appointment was changed!</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </div>
            <% request.getSession().removeAttribute("isAppointmentChanged"); %>
    </c:if>
    <c:if test="${isAppointmentCreated == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>The appointment was added!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isAppointmentCreated"); %>
    </c:if>
    <c:if test="${isAppointmentDeleted == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>The appointment was deleted!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isAppointmentDeleted"); %>
    </c:if>
    <div class="container-fluid">
        <c:if test="${appointmentList == null}">
            <h3>No appointments</h3>
        </c:if>

        <c:if test="${appointmentList != null}">
            <c:if test="${role == 'DOCTOR'}">
                <h1>AppointmentList</h1>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Start Time</th>
                        <th scope="col">End Time</th>
                        <th scope="col">Procedure</th>
                        <th scope="col">Price</th>
                        <th scope="col">Client Name</th>
                        <th scope="col">Client Surname</th>
                        <th scope="col">Client e-mail</th>
                        <th scope="col">Client phone number</th>
                        <th scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${appointmentList}" var="appointment">
                        <tr>
                            <th scope="row"><c:out value="${appointment.id}"/></th>
                            <td><c:out value="${appointment.date}"/></td>
                            <td><c:out value="${appointment.startTime}"/></td>
                            <td><c:out value="${appointment.endTime}"/></td>
                            <td><c:out value="${appointment.procedure.name}"/></td>
                            <td><c:out value="${appointment.procedure.price}"/></td>
                            <td><c:out value="${appointment.userClient.name}"/></td>
                            <td><c:out value="${appointment.userClient.surname}"/></td>
                            <td><c:out value="${appointment.userClient.email}"/></td>
                            <td><c:out value="${appointment.userClient.phone}"/></td>
                            <td><c:out value="${appointment.status}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${role == 'USER'}">
                <h1>AppointmentList</h1>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Start Time</th>
                        <th scope="col">End Time</th>
                        <th scope="col">Procedure</th>
                        <th scope="col">Price</th>
                        <th scope="col">Doctor Name</th>
                        <th scope="col">Doctor Surname</th>
                        <th scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${appointmentList}" var="appointment">
                        <tr>
                            <th scope="row"><c:out value="${appointment.id}"/></th>
                            <td><c:out value="${appointment.date}"/></td>
                            <td><c:out value="${appointment.startTime}"/></td>
                            <td><c:out value="${appointment.endTime}"/></td>
                            <td><c:out value="${appointment.procedure.name}"/></td>
                            <td><c:out value="${appointment.procedure.price}"/></td>
                            <td><c:out value="${appointment.doctor.doctorInfo.name}"/></td>
                            <td><c:out value="${appointment.doctor.doctorInfo.surname}"/></td>
                            <td><c:out value="${appointment.status}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${role == 'MODERATOR' || role == 'ADMIN'}">
                <h1>AppointmentList</h1>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Client Id</th>
                        <th scope="col">Doctor Id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Start Time</th>
                        <th scope="col">End Time</th>
                        <th scope="col">Procedure Id</th>
                        <th scope="col">Procedure name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Client Name</th>
                        <th scope="col">Client Surname</th>
                        <th scope="col">Client e-mail</th>
                        <th scope="col">Client phone number</th>
                        <th scope="col">Doctor Name</th>
                        <th scope="col">Doctor Surname</th>
                        <th scope="col">Doctor e-mail</th>
                        <th scope="col">Doctor phone number</th>
                        <th scope="col">Doctor qualification</th>
                        <th scope="col">Doctor rank</th>
                        <th scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${appointmentList}" var="appointment">
                        <tr>
                            <th scope="row"><c:out value="${appointment.id}"/></th>
                            <td><c:out value="${appointment.userClient.id}"/></td>
                            <td><c:out value="${appointment.doctor.id}"/></td>
                            <td><c:out value="${appointment.date}"/></td>
                            <td><c:out value="${appointment.startTime}"/></td>
                            <td><c:out value="${appointment.endTime}"/></td>
                            <td><c:out value="${appointment.procedure.id}"/></td>
                            <td><c:out value="${appointment.procedure.name}"/></td>
                            <td><c:out value="${appointment.procedure.price}"/></td>
                            <td><c:out value="${appointment.procedure.duration}"/></td>
                            <td><c:out value="${appointment.userClient.name}"/></td>
                            <td><c:out value="${appointment.userClient.surname}"/></td>
                            <td><c:out value="${appointment.userClient.email}"/></td>
                            <td><c:out value="${appointment.userClient.phone}"/></td>
                            <td><c:out value="${appointment.doctor.doctorInfo.name}"/></td>
                            <td><c:out value="${appointment.doctor.doctorInfo.surname}"/></td>
                            <td><c:out value="${appointment.doctor.doctorInfo.email}"/></td>
                            <td><c:out value="${appointment.doctor.doctorInfo.phone}"/></td>
                            <td><c:out value="${appointment.doctor.qualification}"/></td>
                            <td><c:out value="${appointment.doctor.rank}"/></td>
                            <td><c:out value="${appointment.status}"/></td>
                            <td><a href="${changeAppointmentPage}${appointment.id}" class="btn btn-primary active">Change</a>
                            </td>
                            <td><a href="${deleteAppointment}${appointment.id}"
                                   class="btn btn-primary active">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>
    </div>
    <c:import url="footer.jsp"/>
