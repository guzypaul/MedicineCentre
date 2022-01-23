<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="procedureListPath" value="/controller?command=procedures"/>
<c:url var="contacts" value="/controller?command=contacts"/>
<c:url var="aboutUs" value="/controller?command=about_us"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<div class="container">
  <footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
      <li class="nav-item"><a href="${procedureListPath}" class="nav-link px-2 text-muted"><fmt:message key="home"/></a></li>
      <li class="nav-item"><a href="${contacts}" class="nav-link px-2 text-muted"><fmt:message key="contacts"/></a></li>
      <li class="nav-item"><a href="${aboutUs}" class="nav-link px-2 text-muted"><fmt:message key="about.us"/></a></li>
    </ul>
    <p class="text-center text-muted">&copy; 2022 <fmt:message key="startup.clinic"/></p>
  </footer>
</div>
</body>
</html>
