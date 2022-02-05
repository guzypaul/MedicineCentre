<%@ page import="java.awt.image.PixelGrabber" %>
<%@ page import="by.guzypaul.medicinecentre.entity.Qualification" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="createProcedure" value="/controller?command=create_procedure"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="create"/> <fmt:message key="procedure"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isProcedureCreated == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong><fmt:message key="invalid.data"/></strong> <fmt:message key="try.again"/>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isProcedureCreated"); %>
    </c:if>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${createProcedure}" method="post" enctype="multipart/form-data">
                <div class="container-fluid">
                    <div>
                        <label for="name"><fmt:message key="name"/></label>
                        <input id="name" class="form-control" tabindex="1" placeholder="Name" type="text" name="name" required/>
                    </div>
                    <br>
                    <div class="mb-3">
                        <label for="formFileSm" class="form-label"><fmt:message key="picture"/></label>
                        <input class="form-control form-control-sm" id="formFileSm" type="file" name="procedure-picture" required>
                    </div>
                    <br>
                    <div>
                        <label for="price"><fmt:message key="price"/> $</label>
                        <input id="price" class="form-control" tabindex="3" placeholder="<fmt:message key="price"/>" type="text" name="price" required/>
                    </div>
                    <br>
                    <div>
                        <label for="description"><fmt:message key="description"/></label>
                        <input id="description" class="form-control" tabindex="4" placeholder="<fmt:message key="description"/>" type="text" name="description" required/>
                    </div>
                    <br>
                    <div>
                        <label for="duration"><fmt:message key="duration"/> (<fmt:message key="minutes"/>)</label>
                        <input id="duration" class="form-control" tabindex="5" placeholder="<fmt:message key="minutes"/>" type="text" name="duration" required/>
                    </div>
                    <br>
                    <div>
                        <label for="qualification"><fmt:message key="doctor"/> <fmt:message key="qualification"/></label>
                        <select id="qualification" class="form-select" aria-label="Disabled select example" name="doctorQualification">
                            <c:forEach items="${qualificationList}" var="doctorQualification">
                                <option value="${doctorQualification}">${doctorQualification}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning btn-block"><fmt:message key="create"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>