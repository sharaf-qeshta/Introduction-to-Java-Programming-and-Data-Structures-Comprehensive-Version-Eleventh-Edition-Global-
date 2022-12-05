<%--
  Created by IntelliJ IDEA.
  User: Sharaf Qeshta
  Date: 12/5/2022
  Time: 10:05 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="chapter38.Problem$19" %>
<%@ page import="java.sql.Connection" %>
<html>
<head>
    <title>Problem$19</title>
</head>
<body>
    <%
        String id = request.getParameter("id");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String telephone = request.getParameter("telephone");

        try(Connection connection = Problem$19.createConnection())
        {
            if (request.getParameter("view") != null)
                out.println(Problem$19.view(id, connection));
            else if (request.getParameter("update") != null)
                out.println(Problem$19.update(connection, id, lastName, firstName, mi, address, city, state, telephone));
            else if (request.getParameter("insert") != null)
                out.println(Problem$19.insert(connection, id, lastName, firstName, mi, address, city, state, telephone));
        }
        catch (Exception exception)
        {
            out.println("something went wrong");
        }
    %>
</body>
</html>
