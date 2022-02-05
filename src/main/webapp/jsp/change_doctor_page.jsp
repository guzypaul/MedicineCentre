<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeDoctor" value="/controller?command=change_doctor"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="change"/> <fmt:message key="user"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isDoctorChanged == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong><fmt:message key="invalid.data"/></strong> <fmt:message key="try.again"/>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isDoctorChanged"); %>
    </c:if>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeDoctor}" method="post" enctype="multipart/form-data">
                <div class="container-fluid">
                    <div>
                        <label for="doctorId">Doctor
                            id=${doctor.id} ${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}</label>
                        <input id="doctorId" class="form-control" value="${doctor.id}" type="hidden"
                               name="doctorId"/>
                        <input id="photoName" class="form-control" value="${doctor.photoName}" type="hidden"
                               name="photoName"/>
                    </div>
                    <br>
                    <div>
                        <label for="qualification"><fmt:message key="doctor"/> <fmt:message key="qualification"/></label>
                        <select id="qualification" class="form-select" aria-label="Disabled select example"
                                name="qualification">
                            <option selected>${doctor.qualification.getName()}</option>
                            <c:forEach items="${qualificationList}" var="doctorQualification">
                                <c:if test="${doctorQualification != doctor.qualification.getName()}">
                                    <option value="${doctorQualification}">${doctorQualification}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label for="rank"><fmt:message key="rank"/></label>
                        <input id="rank" class="form-control" tabindex="2" value="${doctor.rank}" type="text"
                               name="rank" required/>
                    </div>
                    <br>
                    <div class="mb-3">
                        <label for="formFileSm" class="form-label"><fmt:message key="photo.don't.choose.anything.if.you.not.needed"/></label>
                        <input class="form-control form-control-sm" id="formFileSm" type="file"
                               name="doctor-picture">
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning btn-block"><fmt:message key="change"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>