<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/5/2022
  Time: 10:28 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem$20</title>
</head>
<body>
    <%!
        int guess = (int) (((Math.random() * 2000) % 1000) + 1);
    %>
    <form action="">
        Enter your guess
        <input type="text" name="guess">
        <input type="submit" value="Submit">
    </form>

    <%
        if (request.getParameter("guess") != null
                && !request.getParameter("guess").isEmpty())
        {
            int userGuess = Integer.parseInt(request.getParameter("guess"));
            if (guess == userGuess)
            {
                out.println("correct you get it");
                guess = (int) (((Math.random() * 2000) % 1000) + 1);
            }
            else if (guess > userGuess)
                out.println("your guess is too low");
            else
                out.println("your guess is too high");
        }
    %>
</body>
</html>
