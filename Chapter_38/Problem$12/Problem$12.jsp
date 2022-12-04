<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/3/2022
  Time: 7:53 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="chapter38.Problem$12" %>
<html>
<head>
    <title>Problem$12</title>
</head>
<body>
    <%
        String choice = request.getParameter("choice");

        int intChoice = -1;
        if (choice != null)
            intChoice = (choice.equals("yes")) ? 1 : 0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(Problem$12.LINK, Problem$12.USER_NAME, Problem$12.PASSWORD);
            int yes = 0, no = 0;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Problem$12.GET_YES_NO_COUNT);
            if (rs.next())
            {
                yes = rs.getInt(2);
                no = rs.getInt(3);
            }

            PreparedStatement ps = connection.prepareStatement(Problem$12.UPDATE_YES_NO);
            if (intChoice == 1)
            {
                ps.setInt(1, ++yes);
                ps.setInt(2, no);
            }
            else if (intChoice == 0)
            {
                ps.setInt(1, yes);
                ps.setInt(2, ++no);
            }

            ps.executeUpdate();

            out.println("the current yes count is " + yes + "<br>");
            out.println("the current no count is " + no);
        }
        catch(Exception exception)
        {
            out.println("Error: " + exception.getMessage());
        }
    %>
</body>
</html>
