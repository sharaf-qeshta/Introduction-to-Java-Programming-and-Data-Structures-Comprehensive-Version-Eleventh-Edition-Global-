package chapter_thirty_four;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * *34.8 (Populate Salary table) Create a table named Salary as follows:
 * create table Salary(
 *  firstName varchar(100),
 *  lastName varchar(100),
 *  rank varchar(15),
 *  salary float);
 * Obtain the data for salary from http://cs.armstrong.edu/liang/data/Salary.txt and
 * populate it into the Salary table in the database.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static final String LINK = "http://cs.armstrong.edu/liang/data/Salary.txt";
    public static final String QUERY =
            "insert into Salary (firstName, lastName, rank2, salary) " +
                    "values ('?', '!', '`', @)";
    public static final String DB_LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(new URL(LINK).openStream()))
        {
            Connection connection = DriverManager.getConnection(DB_LINK, USER_NAME, PASSWORD);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line);
                String query = QUERY.replace("?", tokenizer.nextToken());
                query = query.replace("!", tokenizer.nextToken());
                query = query.replace("`", tokenizer.nextToken());
                query = query.replace("@", tokenizer.nextToken());
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
