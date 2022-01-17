<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="authorizationCommand" value="/controller?command=authorization"/>

<html>
<head>
    <title>Authorization</title>
    <c:import url="header.jsp"/>
    <c:if test="${isUserRegistered == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Registration is successfully!</strong> Log in your account.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isUserRegistered"); %>
    </c:if>

    <c:if test="${isUserAuthorized == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>Invalid data!</strong> Try again.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isUserAuthorized"); %>
    </c:if>

    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${authorizationCommand}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="email">Email</label>
                        <input id="email" class="form-control" tabindex="1" placeholder="Email" type="text" name="email"/>
                    </div>
                    <br>
                    <div>
                        <label for="password">Password</label>
                        <input id="password" class="form-control" tabindex="2" placeholder="Password" type="password" name="password"/><br>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning">SIGN IN</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>