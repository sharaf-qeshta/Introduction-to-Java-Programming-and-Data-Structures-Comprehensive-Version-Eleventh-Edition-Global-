package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * **37.9 (Display database tables) Write an HTML form that prompts the user to enter
 * or select a JDBC driver, database URL, username, password, and table name, as
 * shown in Figure 37.31a. Clicking the Submit button displays the table content, as
 * shown in Figure 37.31b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09 extends HttpServlet
{
    public static final String QUERY = "select * from ?";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = request.getParameter("url");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String table = request.getParameter("table");

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(QUERY.replace("?", table));
            ResultSetMetaData metaData = rs.getMetaData();

            out.println("<table border=\"5\" width = 20% height = 20%><tr>");
            for (int i = 1; i <= metaData.getColumnCount(); i++)
                out.println("<td> " + metaData.getColumnName(i) + "</td>");
            out.println("</tr>");

            while(rs.next())
            {
                out.println("<tr>");
                for (int i = 1; i <= metaData.getColumnCount(); i++)
                    out.println("<td>" + rs.getString(i) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
        catch(Exception exception)
        {
            out.println("<h1>something went wrong</h1>");
        }
    }
}
