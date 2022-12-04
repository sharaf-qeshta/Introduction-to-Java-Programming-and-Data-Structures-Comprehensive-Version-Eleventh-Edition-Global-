<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/4/2022
  Time: 12:23 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$17" %>
<html>
<head>
    <title>Problem$17a</title>
</head>
<body>
    <%
        int index = 0;
        if (request.getParameter("index") == null)
            Problem$17.shuffle();
        else
            index = Integer.parseInt(request.getParameter("index"));
    %>
    <form action="Problem$17b.jsp">
        what is the capital of <%= Problem$17.DATA[index][0] %>?
        <input type="text" name="capital">
        <input hidden type="text" name="index" value="<%= index %>">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
