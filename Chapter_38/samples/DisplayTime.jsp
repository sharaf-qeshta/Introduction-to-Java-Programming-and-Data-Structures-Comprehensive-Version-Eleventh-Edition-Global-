<!-- DisplayTime.jsp -->
<%@page pageEncoding="GB18030" %>
<%@ page import="chapter38.TimeBean" %>
<jsp:useBean id="timeBeanId"
             class="chapter38.TimeBean" scope="application">
</jsp:useBean>
<jsp:setProperty name="timeBeanId" property="*"/>

<html>
<head>
    <title>
        Display Time
    </title>
</head>
<body>
<h3>Choose locale and time zone</h3>
Current time is
<%= timeBeanId.currentTimeString(timeBeanId.getLocaleIndex(),
        timeBeanId.getTimeZoneIndex()) %>
</body>
</html>