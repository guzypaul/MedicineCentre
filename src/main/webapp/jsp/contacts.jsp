<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="contacts"/></title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1><fmt:message key="contacts"/></h1>
        <h3>г. Минск, Независимости, 58А
            <p>Call-центр(запись на прием):</p>
            <p>+375 (29) 638-30-03</p>
            <p>+375 (29) 270-10-03</p>
            <p>+375 (17) 293-98-00</p>
            <br>
            <p>Корпоративным клиентам:</p>
            <p>+375 (29) 676 09 84</p>
            <p>dogovor@clinic.by (http://tel:dogovor@clinic.by/)</p>
            <p>Время обращения ПН-ПТ: с 9.00 до 17.00</p>
            <p>Отдел маркетинга:</p>
            <p>marketing@clinic.by (http://tel:marketing@clinic.by/)</p>
            <p>Договорной отдел (взрослые):</p>
            <p>+375 (17) 293 90 00</p>
            <br>
            <p>3 этаж, кабинет 331</p>
            <p>Время работы центра:</p>
            <p>ПН-ПТ:</p>
            <p>с 7:30 до 21:00</p>
            <p>Суббота:</p>
            <p>с 8:00 до 21:00</p>
            <p>Воскресенье:</p>
            <p>с 8:00 до 21:00</p>
        </h3>
    </div>
<c:import url="footer.jsp"/>