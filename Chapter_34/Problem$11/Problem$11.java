package chapter_thirty_four;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * *34.11 (Baby names) Create the following table:
 * create table Babyname (
 *  year integer,
 *  name varchar(50),
 *  gender char(1),
 *  count integer,
 *  constraint pkBabyname primary key (year, name, gender)
 * );
 * The baby name ranking data was described in Programming Exercise 12.31. Write
 * a program to read data from the following URL and store into the Babyname table.
 * https://liveexample.pearsoncmg.com/data/babynamesranking2001.txt,
 * . . .
 * https://liveexample.pearsoncmg.com/data/babynamesranking2010.txt.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static final String DB_LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String INSERT_QUERY =
            "insert into Babyname (year, name, gender, count)" +
                    " values (!, '@', '#', $);";
    public static final String DATA_LINK = "https://liveexample.pearsoncmg.com/data/babynamesranking%.txt";

    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection(DB_LINK, USER_NAME, PASSWORD);
            for (int i = 2001; i < 2011; i++)
            {
                String link = DATA_LINK.replace("%", i + "");
                Scanner scanner = new Scanner(new URL(link).openStream());
                while (scanner.hasNext())
                {
                    String line = scanner.nextLine();
                    StringTokenizer tokenizer = new StringTokenizer(line);
                    // insert male
                    tokenizer.nextToken();
                    String query = INSERT_QUERY.replace("!", i+ "");
                    query = query.replace("@", tokenizer.nextToken().trim());
                    query = query.replace("#", "M");
                    query = query.replace("$", tokenizer.nextToken().trim());
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);

                    // insert female
                    String femaleQuery = INSERT_QUERY.replace("!", i+"");
                    femaleQuery = femaleQuery.replace("@", tokenizer.nextToken().trim());
                    femaleQuery = femaleQuery.replace("#", "F");
                    femaleQuery = femaleQuery.replace("$", tokenizer.nextToken().trim());

                    Statement statement1 = connection.createStatement();
                    statement1.executeUpdate(femaleQuery);
                }
                scanner.close();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
