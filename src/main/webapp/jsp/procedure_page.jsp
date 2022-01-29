<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="imgPath" value="/download/"/>
<c:url var="changeProcedure" value="/controller?command=change_procedure_page&procedureId="/>
<c:url var="deleteProcedure" value="/controller?command=delete_procedure_page&procedureId="/>
<c:url var="makeAppointment" value="/controller?command=create_appointment_page&procedureId="/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><c:out value="${procedure.name}"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isProcedureChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="the.procedure.was.updated"/></strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isProcedureChanged"); %>
    </c:if>
    <main>
        <div class="row">
            <div class="col-lg-8">
                <div class="container-fluid">
                    <h1><c:out value="${procedure.name}"/></h1>
                    <img src="${imgPath}${procedure.imageName}" class="img-fluid procedure-big-img"
                         alt="<c:out value="${procedure.name}"/>">
                    <br/>
                    <h4><fmt:message key="description"/>: <c:out value="${procedure.description}"/></h4><br/>
                    <h4><fmt:message key="duration"/>: <c:out value="${procedure.duration}"/> minutes</h4><br/>
                    <h4><fmt:message key="price"/>: <c:out value="${procedure.price}"/></h4><br/>
                </div>
            </div>
            <c:if test="${role == 'ADMIN'}">
                <div class="col-lg-4">
                    <br>
                    <br>
                    <ul>
                        <li>
                            <a href="${changeProcedure}<c:out value="${procedure.id}"/>" class="btn btn-primary active">
                                <fmt:message key="change"/> <fmt:message key="procedure"/></a>
                        </li>
                        <br>
                        <li>
                            <a href="${deleteProcedure}<c:out value="${procedure.id}"/>" class="btn btn-danger active">
                                <fmt:message key="delete"/> <fmt:message key="procedure"/>!</a>
                        </li>
                    </ul>
                </div>
            </c:if>
            <c:if test="${role == 'USER'}">
                <div class="col-lg-4">
                    <br>
                    <br>
                    <ul>
                        <li>
                            <a href="${makeAppointment}<c:out value="${procedure.id}"/>" class="btn btn-primary active">
                                <fmt:message key="make"/> <fmt:message key="appointment"/></a>
                        </li>
                    </ul>
                </div>
            </c:if>
        </div>
    </main>
    <c:import url="footer.jsp"/>


