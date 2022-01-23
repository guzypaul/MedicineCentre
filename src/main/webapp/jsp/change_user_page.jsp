<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeUser" value="/controller?command=change_user"/>

<html>
<head>
    <title>Change user</title>
    <c:import url="header.jsp"/>
    <c:if test="${isUserChanged == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Invalid data!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isUserChanged"); %>
    </c:if>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeUser}" method="post">
                <div class="container-fluid">
                    <div>
                        <input class="form-control" value="${user.id}" type="hidden" name="userId"/>
                    </div>
                    <br>
                    <div>
                        <label for="name">Name</label>
                        <input id="name" class="form-control" tabindex="1" value="${user.name}" type="text"
                               name="name"/>
                    </div>
                    <br>
                    <div>
                        <label for="surname">Surname</label>
                        <input id="surname" class="form-control" tabindex="2" value="${user.surname}" type="text"
                               name="surname"/>
                    </div>
                    <br>
                    <div>
                        <label for="phone">Phone number</label>
                        <input id="phone" class="form-control" tabindex="3" value="${user.phone}" type="text"
                               name="phone"/>
                    </div>
                    <br>
                    <div>
                        <label for="email">E-mail</label>
                        <input id="email" class="form-control" tabindex="4" value="${user.email}"
                               type="text" name="email"/>
                    </div>
                    <br>
                    <c:if test="${role == 'ADMIN' || role == 'MODERATOR'}">
                        <div>
                            <label for="role">Role</label>
                            <select id="role" class="form-select" aria-label="Disabled select example" name="role">
                                <option selected>${user.role}</option>
                                <c:forEach items="${roleList}" var="userRole">
                                    <c:if test="${userRole != user.role}">
                                        <option value="${userRole}">${userRole}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                    </c:if>
                    <c:if test="${role == 'USER'}">
                        <div>
                            <input class="form-control" value="${user.role}"
                                   type="hidden" name="role"/>
                        </div>
                        <br>
                    </c:if>
                    <div>
                        <button type="submit" class="btn btn-warning">CHANGE</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>