<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="imgPath" value="/download/"/>
<c:url var="changeProcedure" value="/controller?command=change_procedure_page&procedureId="/>
<c:url var="deleteProcedure" value="/controller?command=delete_procedure_page&procedureId="/>

<html>
<head>
    <title><c:out value="${procedure.name}"/></title>
    <c:import url="header.jsp"/>
    <main>
        <div class="row">
            <div class="col-lg-8">
                <div class="container-fluid">
                    <h1><c:out value="${procedure.name}"/></h1>
                    <img src="${imgPath}${procedure.imageName}" class="img-fluid procedure-big-img"
                         alt="<c:out value="${procedure.name}"/>">
                    <br/>
                    <h4>Описание: <c:out value="${procedure.description}"/></h4><br/>
                    <h4>Длительность: <c:out value="${procedure.duration}"/></h4><br/>
                    <h4>Стоимость: <c:out value="${procedure.price}"/></h4><br/>
                </div>
            </div>
            <c:if test="${role == 'ADMIN'}">
                <div class="col-lg-4">
                    <br>
                    <br>
                    <ul>
                        <li>
                            <a href="${changeProcedure}<c:out value="${procedure.id}"/>" class="btn btn-primary active">Change
                                procedure</a>
                        </li>
                        <br>
                        <li>
                            <a href="${deleteProcedure}<c:out value="${procedure.id}"/>" class="btn btn-danger active">Delete
                                procedure!</a>
                        </li>
                    </ul>
                </div>
            </c:if>
        </div>
    </main>
    <c:import url="footer.jsp"/>


