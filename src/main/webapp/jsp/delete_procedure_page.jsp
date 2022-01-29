<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="deleteProcedure" value="/controller?command=delete_procedure"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="delete"/> <fmt:message key="appointment"/></title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <form action="${deleteProcedure}" method="post">
            <div>
                <label for="procedureId"><fmt:message key="are.you.sure.that.you.want.to.delete"/> <fmt:message key="procedure"/> <fmt:message key="id"/>= ${procedureId}?</label>
                <input id="procedureId" class="form-control" value="${procedureId}" type="hidden"
                       name="procedureId"/>
            </div>
            <div>
                <button type="submit" class="btn btn-warning"><fmt:message key="delete"/></button>
            </div>
        </form>
    </div>

<c:import url="footer.jsp"/>