package chapter_thirty_five;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * *35.6 (Populate Salary table) Rewrite Programming Exercise 34.8 using a batch mode
 * to improve performance.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
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
            Statement statement = connection.createStatement();
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line);
                String query = QUERY.replace("?", tokenizer.nextToken());
                query = query.replace("!", tokenizer.nextToken());
                query = query.replace("`", tokenizer.nextToken());
                query = query.replace("@", tokenizer.nextToken());
                statement.addBatch(query);
            }
            statement.executeBatch();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

