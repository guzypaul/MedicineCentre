<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="photoPath" value="/download/"/>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="languages.locale"/>

<html>
<head>
    <title><fmt:message key="about.us"/></title>
    <c:import url="header.jsp"/>
    <div class="container-fluid">
        <h1><fmt:message key="about.us"/></h1>
        <div>
            <h4>
                <p>     “StartUP CLINIC” is a not-for-profit, fully united system of care
                    serving the northwest Georgia region. The Dalton-based flagship of the system, Hamilton Medical
                    Center, is a 255-bed regional acute-care hospital that offers major medical, surgical and diagnostic
                    services, including award-winning, accredited stroke and chest pain centers.</p>
                <p>     Known for its advanced care and personalized service, Hamilton Health Care System offers innovative
                    treatment options in state-of-the-art facilities while maintaining a compassionate, friendly, and
                    tranquil healing environment.</p>
                <p>     “StartUP CLINIC” History
                    In the winter of 1919, an influenza epidemic swept the world. For north Georgia residents, the trip
                    to Chattanooga for health care services was long and difficult at best. Under the listing for
                    “Hospitals,” the Dalton city directory stated three simple words: “We need one.”</p>
                <p>     In the type of cooperative partnership that would be repeated time and again in the years to come,
                    the area’s largest employers, local doctors, and area citizens came together to fill a community
                    need. Crown Cotton Mills, Elk Mills, and several physicians donated property and funds for a new
                    $75,000 hospital. Individuals and organizations furnished rooms.</p>
                <div>
                    <img src="${photoPath}hospital-1921.jpg" class="img-fluid"
                         alt="hospital-1921.jpg"/>
                </div>
                <p>     The long-awaited Hamilton Memorial Hospital, named for Crown Cotton Mills founder George W.
                    Hamilton, Sr., was dedicated May 12, 1921, on National Hospital Day. It remained there until 1956
                    when Hamilton relocated from downtown Dalton to its present-day location on Memorial Drive.</p>
                <p>     Throughout the subsequent decades, Hamilton has grown in size and sophistication to become, not only
                    a source of pride for the region but a reputable, regional healthcare system offering advanced
                    facilities, equipment, and programming to the growing communities it serves.</p>
                <p>     Today, Hamilton Health Care System is still making history. It has thrived through challenging and
                    unpredictable shifts in the healthcare environment without losing sight of its charitable mission to
                    advance the quality and dignity of life for all residents.</p>
            </h4>
        </div>
    </div>
<c:import url="footer.jsp"/>