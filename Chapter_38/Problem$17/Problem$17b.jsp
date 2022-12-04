<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/4/2022
  Time: 12:27 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$17" %>
<html>
<head>
    <title>Problem$17b</title>
</head>
<body>
    <%
        int index = Integer.parseInt(request.getParameter("index"));
        String capital = request.getParameter("capital");
        if (Problem$17.DATA[index][1].equals(capital))
            out.println("Correct");
        else
            out.println("No. The capital of " + Problem$17.DATA[index][0] + " is " + Problem$17.DATA[index][1]);
        if (index < 50)
            index++;
    %>
    <form action="Problem$17a.jsp">
        <input hidden type="text" name="index" value="<%= index %>">
        <br>
        <input type="submit" value="Next">
    </form>
</body>
</html>
