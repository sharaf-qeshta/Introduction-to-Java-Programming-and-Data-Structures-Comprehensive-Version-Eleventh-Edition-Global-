<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/1/2022
  Time: 12:30 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$03</title>
</head>
<body>
    Last Name: <b> <%= request.getParameter("lastName") %></b> <br>
    First Name: <b> <%= request.getParameter("firstName")%></b> <br>
    MI: <b> <%= request.getParameter("mi") %></b> <br>
    Gender: <b> <%= request.getParameter("gender") %></b> <br>
    Major: <b> <%= request.getParameter("major") %></b> <br>
    <b>
    <%
        String[] minors = request.getParameterValues("minor");
        if (minors != null)
            for (String minor : minors) {
    %>
        <%= minor + " " %>
        <% }%>
    </b>
    <br>
    Tennis: <b><%= request.getParameter("tennis") %></b> <br>
    Golf: <b><%= request.getParameter("golf") %> </b> <br>
    PingPong: <b> <%= request.getParameter("pingPong")%></b> <br>
    Remarks: <b> <%= request.getParameter("remarks")%></b>
</body>
</html>
