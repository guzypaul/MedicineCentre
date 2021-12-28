<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="registrationCommand" value="/controller?command=registration"/>

<html>
<head>
    <title>Registration</title>
    <c:import url="header.jsp"/>
    <c:if test="${isUserRegistered == false}">
        <div class="container-fluid alert-indents">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Invalid data!</strong> Try again.
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
                        <label for="name">Name</label>
                        <input id="name" class="form-control" tabindex="1" placeholder="Name" type="text" name="name"/>
                    </div>
                    <br>
                    <div>
                        <label for="surname">Surname</label>
                        <input id="surname" class="form-control" tabindex="3" placeholder="Surname" type="text" name="surname"/>
                    </div>
                    <br>
                    <div>
                        <label for="phone-number">Phone number</label>
                        <input id="phone-number" class="form-control" tabindex="5" placeholder="Phone number" type="tel" name="phone"/>
                    </div>
                    <br>
                    <div>
                        <label for="email">Email</label>
                        <input id="email" class="form-control" tabindex="4" placeholder="Email" type="text" name="email"/>
                    </div>
                    <br>
                    <div>
                        <label for="password">Password</label>
                        <input id="password" class="form-control" tabindex="2" placeholder="Password" type="password" name="password" value=""/><br>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning">Register</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>