package chapter_thirty_seven;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;


/**
 * ***37.14 (Opinion poll) Create an HTML form that prompts the user to answer a question
 * such as “Are you a CS major?”, as shown in Figure 37.35a. When the Submit
 * button is clicked, the servlet increases the Yes or No count in a database and
 * displays the current Yes and No counts, as shown in Figure 37.35b.
 * Create a table named Poll, as follows:
 * create table Poll (
 *  question varchar(40) primary key,
 *  yesCount int,
 *  noCount int);
 * Insert one row into the table, as follows:
 * insert into Poll values ('Are you a CS major? ', 0, 0);
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14 extends HttpServlet
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book?useSSL=false";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String GET_YES_NO_COUNT = "select * from Poll";
    public static final String UPDATE_YES_NO =
            "update Poll set yesCount = ?, noCount = ? where question = 'Are you a CS major? '";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String choice = request.getParameter("choice");

        int intChoice = -1;
        if (choice != null)
            intChoice = (choice.equals("yes")) ? 1 : 0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
            int yes = 0, no = 0;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_YES_NO_COUNT);
            if (rs.next())
            {
                yes = rs.getInt(2);
                no = rs.getInt(3);
            }

            PreparedStatement ps = connection.prepareStatement(UPDATE_YES_NO);
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
    }
}
