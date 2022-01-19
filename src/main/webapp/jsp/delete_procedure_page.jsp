<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="deleteProcedure" value="/controller?command=delete_procedure"/>

<html>
<head>
    <title>Delete appointment</title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <form action="${deleteProcedure}" method="post">
            <div>
                <label for="procedureId">Are you sure that you want to delete procedure id= ${procedureId}?</label>
                <input id="procedureId" class="form-control" value="${procedureId}" type="hidden"
                       name="procedureId"/>
            </div>
            <div>
                <button type="submit" class="btn btn-warning">DELETE</button>
            </div>
        </form>
    </div>

<c:import url="footer.jsp"/>