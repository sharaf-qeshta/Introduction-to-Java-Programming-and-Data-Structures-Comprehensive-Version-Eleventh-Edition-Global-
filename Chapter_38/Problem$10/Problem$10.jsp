<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/3/2022
  Time: 11:07 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.io.File" %>
<html>
<head>
    <title>Problem$10</title>
</head>
<body>
    <%
        String countryCode = request.getParameter("countryCode");
        String description = "";
        try (Scanner scanner = new Scanner(new File(countryCode + ".txt")))
        {
            while (scanner.hasNext())
                description += scanner.nextLine() + "\n";
        }
        catch (Exception exception)
        {
            description = "something went wrong";
        }
    %>
    <img src="<%=countryCode%>.gif" alt="" />
    <h2><%= description %></h2>
</body>
</html>
