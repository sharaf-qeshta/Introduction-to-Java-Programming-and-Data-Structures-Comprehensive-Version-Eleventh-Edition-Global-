package chapter_thirty_four;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.util.ArrayList;

public class Controller6
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String QUERY = "select * from ?";

    @FXML
    ComboBox<String> cbTables;

    @FXML
    TextArea taContent;

    Connection connection;
    ArrayList<String> cbTablesItems = new ArrayList<>();
    public Controller6()
    {
        try
        {
            connection = DriverManager.getConnection(LINK, USER_NAME, PASSWORD);
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet rsTables = dbMetaData.getTables(null, null, null,
                    new String[]{"TABLE"});
            while (rsTables.next())
                cbTablesItems.add(rsTables.getString("TABLE_NAME"));

            new Thread( () ->
            {
                try
                {
                    Thread.sleep(100);
                    Platform.runLater( () -> cbTables.getItems().addAll(cbTablesItems));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }).start();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.exit(-1);
        }
    }


    public void showContent()
    {
        taContent.setText("");

        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY.replace("?", cbTables.getValue()));
            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++)
                taContent.appendText( String.format("%-18s", metaData.getColumnName(i)));
            taContent.appendText("\n");
            while (resultSet.next())
            {
                for (int i = 1; i <= metaData.getColumnCount(); i++)
                    taContent.appendText( String.format("%-18s", resultSet.getString(i)));
                taContent.appendText("\n");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
