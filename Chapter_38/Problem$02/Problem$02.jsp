<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 11/30/2022
  Time: 2:23 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$02</title>
</head>
<body>
    <table border="5" width=80%>

    <%  for (int i = 1; i < 10; i++) {%>
        <tr>
            <% if (i == 1)
                out.println("<td></td>");
               else
                   out.println("<td>" + i + "</td>");
            %>

            <% for (int j = 1; j < 10; j++) {%>
                <td><%= i * j%></td>
            <%}%>
        </tr>
        <% if (i == 1) {%>
        <tr>
        <td>1</td>
         <% for (int j = 1; j < 10; j++) {%>
            <td><%= j %></td>
            <%}%>
        </tr>
        <%}}%>
    </table>
</body>
</html>
