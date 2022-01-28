<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="registrationCommand" value="/controller?command=registration"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="registration"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isUserRegistered == false}">
        <div class="container-fluid alert-indents">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong><fmt:message key="invalid.data"/></strong> <fmt:message key="try.again"/>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </div>
        <% request.getSession().removeAttribute("isUserRegistered"); %>
    </c:if>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${registrationCommand}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="name"><fmt:message key="name"/></label>
                        <input id="name" class="form-control" tabindex="1" placeholder="<fmt:message key="name"/>" type="text" name="name"/>
                    </div>
                    <br>
                    <div>
                        <label for="surname"> <fmt:message key="surname"/></label>
                        <input id="surname" class="form-control" tabindex="2" placeholder=" <fmt:message key="surname"/>" type="text" name="surname"/>
                    </div>
                    <br>
                    <div>
                        <label for="phone-number"><fmt:message key="phone.number"/></label>
                        <input id="phone-number" class="form-control" tabindex="3" placeholder="<fmt:message key="phone.number"/>" type="tel" name="phone"/>
                    </div>
                    <br>
                    <div>
                        <label for="email"><fmt:message key="email"/></label>
                        <input id="email" class="form-control" tabindex="4" placeholder="<fmt:message key="email"/>" type="text" name="email"/>
                    </div>
                    <br>
                    <div>
                        <label for="password"> <fmt:message key="password"/></label>
                        <input id="password" class="form-control" tabindex="5" placeholder=" <fmt:message key="password"/>" type="password" name="password" value=""/><br>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning"><fmt:message key="register"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>