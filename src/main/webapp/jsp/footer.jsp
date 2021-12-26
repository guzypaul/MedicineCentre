<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="procedureListPath" value="/controller?command=procedures"/>
<c:url var="contacts" value="/controller?command=contacts"/>
<c:url var="aboutUs" value="/controller?command=about_us"/>

<div class="container">
  <footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
      <li class="nav-item"><a href="${procedureListPath}" class="nav-link px-2 text-muted">Home</a></li>
      <li class="nav-item"><a href="${contacts}" class="nav-link px-2 text-muted">Contacts</a></li>
      <li class="nav-item"><a href="${aboutUs}" class="nav-link px-2 text-muted">About Us</a></li>
    </ul>
    <p class="text-center text-muted">&copy; 2022 StartUP CLINIC</p>
  </footer>
</div>
</body>
</html>
