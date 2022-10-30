package chapter_thirty_four;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

public class Controller5
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String QUERY =
            "select * from ?";

    private Connection connection;

    public Controller5()
    {
        try
        {
            connection = DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }
    }


    @FXML
    TextField tfTableName;

    @FXML
    TextArea tableContent;

    public void showContent()
    {
        tableContent.setText("");

        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY.replace("?", tfTableName.getText().trim()));
            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++)
                tableContent.appendText( String.format("%-18s", metaData.getColumnName(i)));
            tableContent.appendText("\n");
            while (resultSet.next())
            {
                for (int i = 1; i <= metaData.getColumnCount(); i++)
                    tableContent.appendText( String.format("%-18s", resultSet.getString(i)));
                tableContent.appendText("\n");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
