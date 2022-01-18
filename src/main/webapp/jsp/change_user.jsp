<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeUser" value="/controller?command=change_user"/>

<html>
<head>
    <title>Change user</title>
    <c:import url="header.jsp"/>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeUser}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="userID">User Id ${user.id}</label>
                        <input id="userID" class="form-control" value="${user.id}" type="hidden"
                               name="userId"/>
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
                        <input id="phone" class="form-control" tabindex="5" value="${user.phone}" type="text"
                               name="phone"/>
                    </div>
                    <br>
                    <div>
                        <label for="email">E-mail</label>
                        <input id="email" class="form-control" tabindex="3" value="${user.email}"
                               type="text" name="email"/>
                    </div>
                    <br>
                    <c:if test="${role == 'ADMIN' || role == 'MODERATOR'}">
                        <div>
                            <label for="clientPassword">Client password</label>
                            <input disabled id="clientPassword" class="form-control" value="${user.password}"
                                   type="password"/>
                            <input class="form-control" value="${user.password}"
                                   type="hidden" name="password"/>
                        </div>
                        <br>
                        <div>
                            <label for="role">Role</label>
                            <input id="role" class="form-control" tabindex="6" value="${user.role}"
                                   type="text" name="role"/>
                        </div>
                        <br>
                    </c:if>
                    <c:if test="${role == 'USER'}">
                        <div>
                            <label for="password">Password</label>
                            <input id="password" class="form-control" tabindex="4" value="${user.password}"
                                   type="text" name="password"/>
                        </div>
                        <div>
                            <input class="form-control"  value="${user.role}"
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