<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="createDoctor" value="/controller?command=create_doctor"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="create"/> <fmt:message key="doctor"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isDoctorCreated == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="invalid.data"/></strong> <fmt:message key="try.again"/>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isDoctorCreated"); %>
    </c:if>
    <div class="container-fluid">
        <h2><fmt:message key="add.new.doctor"/></h2>
    </div>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${createDoctor}" method="post" enctype="multipart/form-data">
                <div class="container-fluid">
                    <div>
                        <label for="qualification"><fmt:message key="qualification"/></label>
                        <select id="qualification" class="form-select" aria-label="Disabled select example" name="qualification">
                            <c:forEach items="${qualificationList}" var="doctorQualification">
                                <option value="${doctorQualification}">${doctorQualification}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label for="rank"><fmt:message key="rank"/></label>
                        <input id="rank" class="form-control" tabindex="2" placeholder="<fmt:message key="rank"/>" type="text" name="rank"/>
                    </div>
                    <br>
                    <div>
                        <label for="userId"><fmt:message key="user"/> <fmt:message key="id"/></label>
                        <input id="userId" class="form-control" tabindex="3" placeholder="<fmt:message key="user"/> <fmt:message key="id"/>" type="text"
                               name="userId"/>
                    </div>
                    <br>
                    <div class="mb-3">
                        <label for="formFileSm" class="form-label"><fmt:message key="picture"/></label>
                        <input class="form-control form-control-sm" id="formFileSm" type="file" name="doctor-picture">
                    </div>
                    <br>
                    <div>
                        <label for="startTime"><fmt:message key="start.time"/></label>
                        <input id="startTime" class="form-control" type="time" name="startTime">
                    </div>
                    <br>
                    <div>
                        <label for="endTime"><fmt:message key="end.time"/></label>
                        <input id="endTime" class="form-control" type="time" name="endTime"/>
                    </div>
                    <br>
                    <div>
                        <label for="info"><fmt:message key="days"/></label>
                        <input id="info" class="form-control" tabindex="7" placeholder="<fmt:message key="days"/>" type="text"
                               name="info"/>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning"><fmt:message key="create"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>