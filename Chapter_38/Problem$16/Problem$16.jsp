<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/4/2022
  Time: 11:49 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$16</title>
</head>
<body>
    <%
        int birthDate = 0;
        if (request.getParameter("set1") != null)
            birthDate += 1;
        if (request.getParameter("set2") != null)
            birthDate += 2;
        if (request.getParameter("set3") != null)
            birthDate += 4;
        if (request.getParameter("set4") != null)
            birthDate += 8;
        if (request.getParameter("set5") != null)
            birthDate += 16;
    %>

    <h1>Your birthdate is <%= birthDate %></h1>
</body>
</html>
