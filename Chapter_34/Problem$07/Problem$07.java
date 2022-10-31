package chapter_thirty_four;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * **34.7 (Populate Quiz table) Create a table named Quiz as follows:
 * create table Quiz(
 *  questionId int,
 *  question varchar(4000),
 *  choicea varchar(1000),
 *  choiceb varchar(1000),
 *  choicec varchar(1000),
 *  choiced varchar(1000),
 *  answer varchar(5));
 * The Quiz table stores multiple-choice questions. Suppose the multiple-choice
 * questions are stored in a text file accessible from http://www.cs.armstrong.edu/
 * liang/data/Quiz.txt in the following format:
 * 1. question1
 * a. choice a
 * b. choice b
 * c. choice c
 * d. choice d
 * Answer:cd
 * 2. question2
 * a. choice a
 * b. choice b
 * c. choice c
 * d. choice d
 * Answer:a
 * ...
 * Write a program that reads the data from the file and populate it into the Quiz
 * table.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static final String QUERY =
            "insert into Quiz (questionId, question, choicea, choiceb, choicec, choiced, answer)" +
                    " values (?, ?, ?, ?, ?, ?, ?)";
    public static final String FILE_PATH = "src/chapter_thirty_four/Quiz.txt";

    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";


    public static void main(String[] args)
    {
        try (Scanner reader = new Scanner(new File(FILE_PATH)))
        {
            Connection connection = DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
            int questionId = 0;
            while (reader.hasNext())
            {
                String question = reader.nextLine();
                String choiceA = reader.nextLine();
                String choiceB = reader.nextLine();
                String choiceC = reader.nextLine();
                String choiceD = reader.nextLine();
                String answer = reader.nextLine();
                answer = answer.replace("Answer:", "");

                PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
                preparedStatement.setInt(1, questionId);
                preparedStatement.setString(2, question);
                preparedStatement.setString(3, choiceA);
                preparedStatement.setString(4, choiceB);
                preparedStatement.setString(5, choiceC);
                preparedStatement.setString(6, choiceD);
                preparedStatement.setString(7, answer);
                preparedStatement.executeUpdate();
                questionId++;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
