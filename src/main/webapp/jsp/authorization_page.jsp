<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Authorization</title>
    <c:import url="header.jsp"/>
    <form action="controller" method="post" enctype="multipart/form-data">
        <div class="container-fluid">
            <div>
                <h4>Email</h4>
                <input tabindex="4" placeholder="Email" type="text" name="email" value=""/><br>
            </div>
            <br>
            <div>
                <h4>Password</h4>
                <input tabindex="5" placeholder="Password" type="password" name="password" value=""/><br>
            </div>
            <br>
            <div>
                <button type="submit">SIGN IN</button>
                <button type="reset">RESET</button>
            </div>
        </div>
    </form>
<c:import url="footer.jsp"/>