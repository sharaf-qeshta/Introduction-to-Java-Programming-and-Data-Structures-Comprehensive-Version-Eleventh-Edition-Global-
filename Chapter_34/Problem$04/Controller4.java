package chapter_thirty_four;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Controller4
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String QUERY =
            " select s.firstName, s.lastName, c.title, e.grade " +
            " from Course c, Student s, Enrollment e " +
            " where s.ssn = ? and e.ssn = s.ssn and c.courseId = e.courseId; ";

    @FXML
    TextField tfSsn;

    @FXML
    TextArea taData;

    @FXML
    Text status;

    Connection connection;
    public Controller4()
    {
        try
        {
            connection =
                    DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }
    }

    @FXML
    public void showGrades()
    {
        taData.setText("");
        status.setText("");
        try
        {
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, tfSsn.getText().trim());
            ResultSet resultSet = statement.executeQuery();
            int i = 0;
            while (resultSet.next())
            {
                String line = resultSet.getString(1)
                        + " " + resultSet.getString(2)
                        + " grade on course " + resultSet.getString(3)
                        + " is " + resultSet.getString(4);
                taData.appendText(line + "\n");
                i++;
            }

            if (i != 0)
                status.setText(i + " courses found");
            else
                status.setText("no courses found for this SSN");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
