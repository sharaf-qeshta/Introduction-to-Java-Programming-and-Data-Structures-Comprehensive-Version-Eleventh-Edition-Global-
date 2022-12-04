<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/3/2022
  Time: 8:08 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$13" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<html>
<head>
    <title>Problem$13b</title>
</head>
<body>
    <%
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(Problem$13.LINK, Problem$13.USER_NAME, Problem$13.PASSWORD);
            int count = Integer.parseInt(request.getParameter("count"));
            for (int i = 1; i < count; i++)
            {
                String question = request.getParameter("question" + i);
                String choice = request.getParameter("choice"+ i);
                int yesCount = Integer.parseInt(request.getParameter("yesCount"+i));
                int noCount = Integer.parseInt(request.getParameter("noCount"+i));

                int intChoice = -1;
                if (choice != null)
                    intChoice = (choice.equals("yes")) ? 1 : 0;

                PreparedStatement ps = connection.prepareStatement(Problem$13.UPDATE_YES_NO);
                if (intChoice == 1)
                {
                    ps.setInt(1, ++yesCount);
                    ps.setInt(2, noCount);
                }
                else if (intChoice == 0)
                {
                    ps.setInt(1, yesCount);
                    ps.setInt(2, ++noCount);
                }
                ps.setString(3, question);
                ps.executeUpdate();

                out.println(question + ":<br>");
                out.println("the current yes count is " + yesCount + "<br>");
                out.println("the current no count is " + noCount + "<br><br>");
            }
        }
        catch (Exception exception)
        {
            out.println("Error: " + exception.getMessage());
        }
    %>
</body>
</html>
