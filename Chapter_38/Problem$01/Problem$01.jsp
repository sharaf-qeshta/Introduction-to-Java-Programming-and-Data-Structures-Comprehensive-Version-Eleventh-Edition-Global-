<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 11/30/2022
  Time: 2:12 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$01</title>
</head>
<body>
    <%!
        private long factorial(long n)
        {
            if (n == 0)
                return 1;
            else
                return n * factorial(n - 1);
        }
    %>
    <table border="5">


    <% for (int i = 1; i <= 10; i++) {%>
        <tr> <td><%=i + ": "%></td> <td><%= factorial(i)%></td></tr>
    <%}%>
    </table>
</body>
</html>
