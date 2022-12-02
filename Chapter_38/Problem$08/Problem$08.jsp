<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/2/2022
  Time: 5:31 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$08</title>
</head>
<body>
    <%
      Cookie color = new Cookie("color", "red");
      color.setMaxAge(172_800); // 2 days

      Cookie radius = new Cookie("radius", "5.5");
      radius.setMaxAge(172_800);

      Cookie count = new Cookie("count", "2");
      count.setMaxAge(172_800);

      response.addCookie(color);
      response.addCookie(radius);
      response.addCookie(count);
    %>

    <h1>Cookies added</h1>
</body>
</html>
