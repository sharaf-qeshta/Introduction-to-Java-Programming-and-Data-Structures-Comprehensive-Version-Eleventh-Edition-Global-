package chapter_thirty_seven.samples;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * Listing 37.7 SimpleRegistration.java
 * */
public class SimpleRegistration extends HttpServlet
{
    // Use a prepared statement to store a student into the database
    private PreparedStatement pstmt;

    /**
     * Initialize variables
     */
    public void init() throws ServletException
    {
        initializeJdbc();
    }

    /**
     * Process the HTTP Post request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain parameters from the client
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String phone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        try
        {
            if (lastName.length() == 0 || firstName.length() == 0)
            {
                out.println("Last Name and First Name are required");
            }
            else
            {
                storeStudent(lastName, firstName, mi, phone, email,
                        address, city, state, zip);

                out.println(firstName + " " + lastName +
                        " is now registered in the database");
            }
        }
        catch (Exception ex)
        {
            out.println("Error: " + ex.getMessage());
        }
        finally
        {
            out.close(); // Close stream
        }
    }

    /**
     * Initialize database connection
     */
    private void initializeJdbc()
    {
        try
        {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost/javabook", "scott", "tiger");
            System.out.println("Database connected");

            // Create a Statement
            pstmt = conn.prepareStatement("insert into Address " +
                    "(lastName, firstName, mi, telephone, email, street, city, "
                    + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Store a student record to the database
     */
    private void storeStudent(String lastName, String firstName,
                              String mi, String phone, String email, String address,
                              String city, String state, String zip) throws SQLException
    {
        pstmt.setString(1, lastName);
        pstmt.setString(2, firstName);
        pstmt.setString(3, mi);
        pstmt.setString(4, phone);
        pstmt.setString(5, email);
        pstmt.setString(6, address);
        pstmt.setString(7, city);
        pstmt.setString(8, state);
        pstmt.setString(9, zip);
        pstmt.executeUpdate();
    }
}