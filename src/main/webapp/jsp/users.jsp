
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeUser" value="/controller?command=change_user_page&userId="/>

<html>
<head>
    <title><fmt:message key="client"/> <fmt:message key="list"/></title>
    <c:import url="header.jsp"/>
    <c:if test="${isUserChanged == true}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><fmt:message key="the.user.was.updated"/>!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isUserChanged"); %>
    </c:if>
    <div class="container-fluid">
        <c:if test="${userList != null}">
                <h1>ClientList</h1>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col"><fmt:message key="id"/></th>
                        <th scope="col"><fmt:message key="name"/></th>
                        <th scope="col"><fmt:message key="surname"/></th>
                        <th scope="col"><fmt:message key="email"/></th>
                        <th scope="col"><fmt:message key="phone.number"/></th>
                        <th scope="col"><fmt:message key="role"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <th scope="row"><c:out value="${user.id}"/></th>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.phone}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td><a href="${changeUser}${user.id}" class="btn btn-primary active"><fmt:message key="change"/></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </c:if>
    </div>
    <c:import url="footer.jsp"/>
