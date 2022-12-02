<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/2/2022
  Time: 4:42 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.DatabaseSearcher" %>
<html>
<head>
    <title>Problem$06</title>
</head>
<body>
    <%
        DatabaseSearcher ds = new DatabaseSearcher(request.getParameter("course"),
                request.getParameter("ssn"));
    %>
    <h1><%= ds.getName()%> : <%= ds.getGrade()%></h1>
</body>
</html>
