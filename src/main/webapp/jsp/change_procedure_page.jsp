<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeProcedure" value="/controller?command=change_procedure"/>

<html>
<head>
    <title>Change procedure</title>
    <c:import url="header.jsp"/>
    <c:if test="${isProcedureChanged == false}">
    <div class="container-fluid alert-indents">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Invalid data!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </div>
            <% request.getSession().removeAttribute("isProcedureChanged"); %>
    </c:if>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeProcedure}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="procedureId">Procedure id=${procedure.id}</label>
                        <input id="procedureId" class="form-control" value="${procedure.id}" type="hidden"
                               name="procedureId"/>
                        <input class="form-control" value="${procedure.imageName}" type="hidden"
                               name="currentImageName"/>
                    </div>
                    <br>
                    <div>
                        <label for="name">Name</label>
                        <input id="name" class="form-control" tabindex="1" value="${procedure.name}" type="text"
                               name="name"/>
                    </div>
                    <br>
                    <div class="mb-3">
                        <label for="formFileSm" class="form-label">Picture (don't choose anything if you not needed)</label>
                        <input class="form-control form-control-sm" id="formFileSm" type="file" name="procedure-picture">
                    </div>
                    <br>
                    <div>
                        <label for="price">Price $</label>
                        <input id="price" class="form-control" tabindex="3" value="${procedure.price}" type="text"
                               name="price"/>
                    </div>
                    <br>
                     <div>
                         <label for="description">Description</label>
                         <input id="description" class="form-control" tabindex="4" value="${procedure.description}" type="text"
                                name="description"/>
                     </div>
                     <br>
                     <div>
                         <label for="duration">Duration (minutes)</label>
                         <input id="duration" class="form-control" tabindex="5" value="${procedure.duration}" type="text"
                                name="duration"/>
                     </div>
                     <br>
                    <div>
                        <label for="doctorQualification">Doctor qualification</label>
                        <input id="doctorQualification" class="form-control" tabindex="7" value="${procedure.doctorQualification}"
                               type="text" name="doctorQualification"/>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-warning">CHANGE</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<c:import url="footer.jsp"/>