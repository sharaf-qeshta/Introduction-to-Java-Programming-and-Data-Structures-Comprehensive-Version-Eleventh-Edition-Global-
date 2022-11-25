package chapter_thirty_seven;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * **37.7 (Find scores from database tables) Rewrite the preceding servlet. Assume for each
 * class, a table is used to store the student name, ssn, and score. The table name is
 * the same as the class ID. For instance, if the class ID were csci1301, the table name
 * would be csci1301.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends HttpServlet
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String QUERY =
            "select name, grade from ? where ssn = ?";
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String ssn = request.getParameter("ssn");
        String course = request.getParameter("course");

        try
        {
            Connection connection = DriverManager
                    .getConnection(LINK, USER_NAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, course);
            statement.setString(2, ssn);
            ResultSet rs = statement.executeQuery();

            String name = rs.getString(1);
            String grade = rs.getString(2);

            out.println(name + " : " + grade);
        }
        catch (SQLException exception)
        {
            out.println("<h1> something went wrong </h1>");
        }
    }
}