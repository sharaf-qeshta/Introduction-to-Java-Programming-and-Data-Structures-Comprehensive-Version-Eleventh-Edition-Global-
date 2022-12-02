<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/2/2022
  Time: 5:35 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$09</title>
</head>
<body>
    <h1> here are the cookies from your browser </h1>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies)
        {
            switch (cookie.getName())
            {
                case "color" : out.println("<h2>color`s value is " + cookie.getValue() + "</h2><br>"); break;
                case "radius" : out.println("<h2>radius`s value is " + cookie.getValue() + "</h2><br>"); break;
                case "count" : out.println("<h2>count`s value is " + cookie.getValue() + "</h2><br>"); break;
                case "JSESSIONID" : out.println("<h2>JSESSIONID`s value is " + cookie.getValue() + "</h2>"); break;
            }
        }
    %>
</body>
</html>
