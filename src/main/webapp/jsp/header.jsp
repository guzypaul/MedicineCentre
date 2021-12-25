<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="cssFilePath" value="/css/style.css"/>
<c:url var="procedureListPath" value="/controller?command=procedures"/>
<c:url var="procedurePage" value="/controller?command=procedure_page&procedureId="/>
<c:url var="contacts" value="/controller?command=contacts"/>
<c:url var="aboutUs" value="/controller?command=about_us"/>
<c:url var="registrationPage" value="/controller?command=registration_page"/>
<c:url var="authorizationPage" value="/controller?command=authorization_page"/>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${cssFilePath}"/>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-color">
    <div class="container-fluid">
        <a class="navbar-brand" href="${procedureListPath}">StartUP CLINIC</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${procedureListPath}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${contacts}">Contacts</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="${aboutUs}">About Us</a>
                </li>
                <span class="registration-indents">
                    <ul class="navbar-nav mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="${registrationPage}">Registration</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${authorizationPage}">SIGN IN</a>
                        </li>
                    </ul>
                </span>
            </ul>
        </div>
    </div>
</nav>