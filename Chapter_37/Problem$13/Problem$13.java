package chapter_thirty_seven;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;


/**
 * **37.13 (Access and update a Staff table) Write a Java servlet for Exercise 33.1, as shown
 * in Figure 37.34.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends HttpServlet
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book?useSSL=false";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String VIEW_QUERY = "select * from Staff where id = ?";
    public static final String INSERT_QUERY = "insert into Staff (id, lastName, "
            + " firstName, mi, address, city, state, telephone) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_QUERY = "update Staff set lastName = ?, firstName = ?, mi = ?"
            + ", address = ?, city = ?, state = ?, telephone = ? where id = ?";
    private Connection connection;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String telephone = request.getParameter("telephone");

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
            if (request.getParameter("view") != null)
                view(id, out);
            else if (request.getParameter("update") != null)
                update(out, id, lastName, firstName, mi, address, city, state, telephone);
            else if (request.getParameter("insert") != null)
                insert(out, id, lastName, firstName, mi, address, city, state, telephone);
        }
        catch(Exception exception)
        {
            out.println("Error: " + exception.getMessage());
        }

        out.close();
    }

    public void insert(PrintWriter out, String... data)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);

            if (ps.executeUpdate() == 1)
                out.println("row inserted correctly");
            else
                out.println("something went wrong");
        }
        catch(SQLException exception)
        {
            out.println("Error: " + exception.getMessage());
        }
    }


    public void update(PrintWriter out, String... data)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
            ps.setString(1, data[1]);
            ps.setString(2, data[2]);
            ps.setString(3, data[3]);
            ps.setString(4, data[4]);
            ps.setString(5, data[5]);
            ps.setString(6, data[6]);
            ps.setString(7, data[7]);
            ps.setString(8, data[0]);

            if (ps.executeUpdate() == 1)
                out.println("row updated successfully");
            else
                out.println("something went wrong");

        }
        catch(SQLException exception)
        {
            out.println("Error: " + exception.getMessage());
        }
    }

    public void view(String id, PrintWriter out)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(VIEW_QUERY);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                out.println("<h2> id : " + rs.getString(1) + "</h2>");
                out.println("<h2> last name : " + rs.getString(2) + "</h2>");
                out.println("<h2> first name : " + rs.getString(3) + "</h2>");
                out.println("<h2> mi : " + rs.getString(4) + "</h2>");
                out.println("<h2> address : " + rs.getString(5) + "</h2>");
                out.println("<h2> city : " + rs.getString(6) + "</h2>");
                out.println("<h2> state : " + rs.getString(7) + "</h2>");
                out.println("<h2> telephone : " + rs.getString(8) + "</h2>");
            }
        }
        catch(SQLException exception)
        {
            out.println("Error: " + exception.getMessage());
        }
    }
}

