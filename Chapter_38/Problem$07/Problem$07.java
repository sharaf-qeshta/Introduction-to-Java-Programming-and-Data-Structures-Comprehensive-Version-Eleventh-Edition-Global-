package chapter38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * **38.7 (Change the password) Rewrite Exercise 37.8 using servlets.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    // see Problem$07.html and Problem$07.jsp
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book?useSSL=false";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String QUERY =
            "update Account set password = ? where username = ? and password = ?";
    public static final String GET_NAME_QUERY =
            "select name from Account where username = ? and password = ?";

    private String username, oldPassword, newPassword1, newPassword2;

    public Problem$07(String username, String oldPassword, String newPassword1, String newPassword2)
    {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword1 = newPassword1;
        this.newPassword2 = newPassword2;
    }

    public String updatePassword()
    {
        if (!newPassword1.equals(newPassword2))
            return "Make sure that you enter the same password in both fields";
        else
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager
                        .getConnection(LINK, USER_NAME, PASSWORD);
                PreparedStatement ps = connection.prepareStatement(QUERY);
                ps.setString(1, newPassword1);
                ps.setString(2, username);
                ps.setString(3, oldPassword);

                int result = ps.executeUpdate();

                if (result == 1)
                {
                    PreparedStatement nameStatement = connection.prepareStatement(GET_NAME_QUERY);
                    nameStatement.setString(1, username);
                    nameStatement.setString(2, newPassword1);
                    ResultSet rs = nameStatement.executeQuery();

                    if (rs.next())
                        return rs.getString(1) + ", your password has been updated!";
                }
                else
                    return "make sure that the username and the old password is correct";
                connection.close();
            }
            catch(Exception exception)
            {
                return exception.toString();
            }
        }
        return null;
    }
}
