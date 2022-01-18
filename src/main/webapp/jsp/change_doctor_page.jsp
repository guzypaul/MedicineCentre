<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="changeDoctor" value="/controller?command=change_doctor"/>

<html>
<head>
    <title>Change user</title>
    <c:import url="header.jsp"/>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form class="registration-inputs" action="${changeDoctor}" method="post">
                <div class="container-fluid">
                    <div>
                        <label for="doctorId">Doctor id=${doctor.id} ${doctor.doctorInfo.name} ${doctor.doctorInfo.surname}</label>
                        <input id="doctorId" class="form-control" value="${doctor.id}" type="hidden"
                               name="doctorId"/>
                    </div>
                    <br>
                    <div>
                        <label for="qualification">Qualification</label>
                        <input id="qualification" class="form-control" tabindex="2" value="${doctor.qualification}" type="text"
                               name="qualification"/>
                    </div>
                    <br>
                    <div>
                        <label for="rank">Rank</label>
                        <input id="rank" class="form-control" tabindex="2" value="${doctor.rank}" type="text"
                               name="rank"/>
                    </div>
                    <br>
                    <div>
                        <label for="photoName">Photo name</label>
                        <input id="photoName" class="form-control" tabindex="2" value="${doctor.photoName}" type="text"
                               name="photoName"/>
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