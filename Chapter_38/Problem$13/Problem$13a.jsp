<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/3/2022
  Time: 8:03 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$13" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Problem$13a</title>
</head>
<body>
    <form action="Problem$13b.jsp">
    <%
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(Problem$13.LINK, Problem$13.USER_NAME, Problem$13.PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Problem$13.GET_ALL_QUESTIONS);
            int count = 1;
            while (rs.next())
            {
                out.println(rs.getString(1)
                        + "Yes <input type='radio' name='choice" + count + "' value='yes'>"
                        + "No <input type='radio' name='choice" + count + "' value='no'> <br>");
                out.println("<input hidden name='question" + count + "' value='" + rs.getString(1) + "'>");
                out.println("<input hidden name='yesCount" + count + "' value='" + rs.getInt(2) + "'>");
                out.println("<input hidden name='noCount" + count + "' value='" + rs.getInt(3) + "'>");
                count++;
            }
            out.println("<input hidden name='count' value='" + count + "'>");
            connection.close();
        }
        catch (Exception exception)
        {
            out.println("Error: " + exception.getMessage());
        }
    %>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
