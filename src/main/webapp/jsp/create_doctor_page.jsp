<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="createDoctor" value="/controller?command=create_doctor"/>

<html>
<head>
  <title>Create doctor</title>
  <c:import url="header.jsp"/>
  <div class="container-fluid">
    <h2>Add new doctor</h2>
  </div>
  <div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
      <form class="registration-inputs" action="${createDoctor}" method="post">
        <div class="container-fluid">
          <div>
            <label for="qualification">Qualification</label>
            <input id="qualification" class="form-control" tabindex="1" placeholder="Qualification" type="text" name="qualification"/>
          </div>
          <br>
          <div>
            <label for="rank">Rank</label>
            <input id="rank" class="form-control" tabindex="2" placeholder="Rank" type="text" name="rank"/>
          </div>
          <br>
          <div>
            <label for="userId">User Id</label>
            <input id="userId" class="form-control" tabindex="3" placeholder="User Id" type="text" name="userId"/>
          </div>
          <br>
          <div>
            <label for="photoName">Photo name</label>
            <input id="photoName" class="form-control" tabindex="4" placeholder="Photo name" type="text" name="photoName"/>
          </div>
          <br>
          <div>
            <label for="startTime">Start time (hh:mm:ss)</label>
            <input id="startTime" class="form-control" tabindex="5" placeholder="Start time" type="text" name="startTime"/>
          </div>
          <br>
          <div>
            <label for="endTime">End time (hh:mm:ss)</label>
            <input id="endTime" class="form-control" tabindex="6" placeholder="End time" type="text" name="endTime"/>
          </div>
          <br>
          <div>
            <label for="info">Days of week</label>
            <input id="info" class="form-control" tabindex="7" placeholder="Days of week" type="text" name="info"/>
          </div>
          <br>
          <div>
            <button type="submit" class="btn btn-warning">Create</button>
          </div>
        </div>
      </form>
    </div>
  </div>
<c:import url="footer.jsp"/>