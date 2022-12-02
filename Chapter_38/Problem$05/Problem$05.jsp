<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/2/2022
  Time: 4:12 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.SearchFile" %>
<html>
<head>
    <title>Problem$05</title>
</head>
<body>
    <%
        SearchFile searchFile = new SearchFile(request.getParameter("course"), request.getParameter("ssn"));
    %>
    <h1> <%= searchFile.getName()%> : <%= searchFile.getGrade()%></h1>
</body>
</html>
