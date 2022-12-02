<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/2/2022
  Time: 5:16 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$07" %>
<html>
<head>
    <title>Problem$07</title>
</head>
<body>
    <%
        Problem$07 p = new Problem$07(request.getParameter("username"),
                request.getParameter("oldPassword"), request.getParameter("newPassword"),
                request.getParameter("newPassword2"));
    %>

    <h1><%= p.updatePassword() %></h1>
</body>
</html>
