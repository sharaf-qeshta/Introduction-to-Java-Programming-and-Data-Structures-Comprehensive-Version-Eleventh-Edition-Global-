package chapter38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSearcher
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String QUERY =
            "select name, grade from @ where ssn = ?";

    private String grade, name;

    public DatabaseSearcher(String course, String ssn)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
            PreparedStatement ps = connection.prepareStatement(QUERY.replace("@", course));
            ps.setString(1, ssn);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                name = rs.getString(1);
                grade = rs.getString(2);
            }
            else
            {
                name = "Not Found";
                grade = "Not Found";
            }
            connection.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            name = exception.getMessage();
            grade = "Not Found";
        }
    }

    public String getGrade()
    {
        return grade;
    }

    public String getName()
    {
        return name;
    }
}
