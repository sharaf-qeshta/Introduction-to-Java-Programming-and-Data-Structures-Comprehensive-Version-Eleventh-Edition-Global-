package chapter38;

import java.sql.*;

/**
 * **38.19 (Access and update a Staff table) Write a JSP for Exercise 33.1, as shown in
 * Figure 38.17.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String VIEW_QUERY = "select * from Staff where id = ?";
    public static final String INSERT_QUERY = "insert into Staff (id, lastName, "
            + " firstName, mi, address, city, state, telephone) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_QUERY = "update Staff set lastName = ?, firstName = ?, mi = ?"
            + ", address = ?, city = ?, state = ?, telephone = ? where id = ?";

    public static Connection createConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
        }
        catch (Exception exception)
        {
            return null;
        }
    }

    public static String insert(Connection connection, String... data)
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
                return "row inserted correctly";
            else
                return "something went wrong";
        }
        catch(SQLException exception)
        {
            return "Error: " + exception.getMessage();
        }
    }


    public static String update(Connection connection, String... data)
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
                return "row updated successfully";
            else
                return "something went wrong";
        }
        catch(SQLException exception)
        {
            return "Error: " + exception.getMessage();
        }
    }


    public static String view(String id, Connection connection)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement(VIEW_QUERY);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return "<h2> id : " + rs.getString(1) + "</h2><br>"
                        + "<h2> last name : " + rs.getString(2) + "</h2><br>"
                        + "<h2> first name : " + rs.getString(3) + "</h2><br>"
                        + "<h2> mi : " + rs.getString(4) + "</h2><br>"
                        + "<h2> address : " + rs.getString(5) + "</h2><br>"
                        + "<h2> city : " + rs.getString(6) + "</h2><br>"
                        + "<h2> state : " + rs.getString(7) + "</h2><br>"
                        + "<h2> telephone : " + rs.getString(8) + "</h2>";
            }
            else
                return "something went wrong";
        }
        catch(SQLException exception)
        {
            return "Error: " + exception.getMessage();
        }
    }
}
