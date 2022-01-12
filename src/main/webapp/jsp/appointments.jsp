<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>AppointmentList</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <c:if test="${appointmentList == null}">
            <h3>No appointments</h3>
        </c:if>
        <c:if test="${appointmentList != null}">
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
    </div>
    <c:import url="footer.jsp"/>
