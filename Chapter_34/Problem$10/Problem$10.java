package chapter_thirty_four;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * *34.10 (Record unsubmitted exercises) The following three tables store information on
 * students, assigned exercises, and exercise submission in LiveLab. LiveLab is an
 * automatic grading system for grading programming exercises.
 * create table AGSStudent (
 *  username varchar(50) not null,
 *  password varchar(50) not null,
 *  fullname varchar(200) not null,
 *  instructorEmail varchar(100) not null,
 *  constraint pkAGSStudent primary key (username)
 * );
 * create table ExerciseAssigned (
 *  instructorEmail varchar(100),
 *  exerciseName varchar(100),
 *  maxscore double default 10,
 *  constraint pkCustomExercise primary key
 *  (instructorEmail, exerciseName)
 * );
 * create table AGSLog (
 *  username varchar(50),
 * exerciseName varchar(100),
 * score double default null,
 * submitted bit default 0,
 * constraint pkLog primary key(username,exerciseName)
 * );
 * The AGSStudent table stores the student information.The ExerciseAssigned
 * table assigns the exercises by an instructor.The AGSLog table stores the grading
 * results.When a student submits an exercise,a record is stored in the AGSLog table.
 * However,there is no record in AGSLog if a student did not submit the exercise.
 * Write a program that adds a new record for each student and an assigned exercise
 * to the student in the AGSLog table if a student has not submitted the exercise.The
 * record should have 0on score and submitted.For example,if the tables contain
 * the following data in AGSLog before you run this program,the AGSLog table now
 * contains the new records after the program runs.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$10
{
    public static final String SEARCH_QUERY = " select s.username, e.exerciseName " +
            " from AGSStudent s, ExerciseAssigned e " +
            " where s.instructorEmail = e.instructorEmail " +
            " and (s.username, e.exerciseName) " +
            " not in (select username, exerciseName from AGSLog); ";
    public static String INSERT_QUERY = "insert into AGSLog (username, exerciseName, submitted) " +
            " values ('?', '!', 0);";

    public static final String DB_LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";


    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection(DB_LINK, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SEARCH_QUERY);
            while (resultSet.next())
            {
                String username = resultSet.getString(1);
                String exerciseName = resultSet.getString(2);
                String query = INSERT_QUERY.replace("?", username);
                query = query.replace("!", exerciseName);
                Statement insertStatement = connection.createStatement();
                insertStatement.executeUpdate(query);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
