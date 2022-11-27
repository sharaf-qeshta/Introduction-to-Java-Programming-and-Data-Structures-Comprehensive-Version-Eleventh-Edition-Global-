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

/**
 * *37.8 (Change the password) Write a servlet that enables the user to change the password
 * from an HTML form, as shown in Figure 37.30a. Suppose the user information is
 * stored in a database table named Account with three columns: username, password,
 * and name, where name is the real name of the user. The servlet performs the following tasks:
 * a. Verify that the username and old password are in the table. If not, report the
 * error and redisplay the HTML form.
 * b. Verify that the new password and the confirmed password are the same. If
 * not, report this error and redisplay the HTML form.
 * c. If the user information is entered correctly, update the password and report
 * the status of the update to the user, as shown in Figure 37.30b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08 extends HttpServlet
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book?useSSL=false";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String QUERY =
            "update Account set password = ? where username = ? and password = ?";
    public static final String GET_NAME_QUERY =
            "select name from Account where username = ? and password = ?";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPassword2 = request.getParameter("newPassword2");

        if (!newPassword.equals(newPassword2))
        {
            out.println("Make sure that you enter the same password in both fields");
        }
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager
                        .getConnection(LINK, USER_NAME, PASSWORD);
                PreparedStatement ps = connection.prepareStatement(QUERY);
                ps.setString(1, newPassword);
                ps.setString(2, username);
                ps.setString(3, oldPassword);

                int result = ps.executeUpdate();

                if (result == 1)
                {
                    PreparedStatement nameStatement = connection.prepareStatement(GET_NAME_QUERY);
                    nameStatement.setString(1, username);
                    nameStatement.setString(2, newPassword);
                    ResultSet rs = nameStatement.executeQuery();

                    if (rs.next())
                    {
                        out.println("<h1> " + rs.getString(1) + ", your password has been updated!</h1>");
                    }
                }
                else
                    out.println("<h1>make sure that the username and the old password is correct</h1>");
                connection.close();
            }
            catch(Exception exception)
            {
                out.println("<h1> " + exception.toString() + " </h1>");
            }
        }
    }
}
