package chapter_thirty_four;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * *34.9 (Copy table) Suppose the database contains a student table defined as follows:
 * create table Student1 (
 *  username varchar(50) not null,
 *  password varchar(50) not null,
 *  fullname varchar(200) not null,
 *  constraint pkStudent primary key (username)
 * );
 * Create a new table named Student2 as follows:
 * create table Student2 (
 *  username varchar(50) not null,
 *  password varchar(50) not null,
 *  firstname varchar(100),
 *  lastname varchar(100),
 *  constraint pkStudent primary key (username)
 * );
 * A full name is in the form of firstname mi lastname or firstname lastname.
 * For example, John K Smith is a full name. Write a program that copies
 *
 * table Student1 into Student2. Your task is to split a full name into firstname,
 * mi, and lastname for each record in Student1 and store a new record
 * into Student2.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String INSERT_QUERY =
            "insert into Student2 (username, password, firstName, lastName)" +
                    " values ('!', '@', '$', '%');";

    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Student1;");
            while (resultSet.next())
            {
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                String fullName = resultSet.getString(3);
                String[] fullNameParts = fullName.split(" ");
                String firstName = fullNameParts[0];
                String lastName = fullNameParts[2];

                String query = INSERT_QUERY.replace("!", username);
                query = query.replace("@", password);
                query = query.replace("$", firstName);
                query = query.replace("%", lastName);

                Statement statement1 = connection.createStatement();
                statement1.executeUpdate(query);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
