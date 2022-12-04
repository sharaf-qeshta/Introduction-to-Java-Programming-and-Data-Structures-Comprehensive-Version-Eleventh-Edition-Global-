<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/4/2022
  Time: 5:59 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$14a</title>
</head>
<body>
  <form action="Problem$14b.jsp">
    <%
      for (int i = 0; i < 10; i++)
      {
          int x = (int) ((Math.random() * 100) % 10);
          int y = (int) ((Math.random() * 100) % 10);
          out.println(x + " + " + y + " = ");
          out.println("<input type='text' name='answer"+i+"'> <br>");
          out.println("<input hidden type='text' name='x"+i+"' value='"+ x + "'>");
          out.println("<input hidden type='text' name='y"+i+"' value='" + y + "'>");
      }
    %>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
