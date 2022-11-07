package chapter_thirty_five;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller4
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String QUERY = "select * from ?";

    @FXML
    ComboBox<String> cbTables;

    @FXML
    TableView<Map> tvContent;

    Connection connection;
    ArrayList<String> cbTablesItems = new ArrayList<>();

    public Controller4()
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
        tvContent.getColumns().clear();
        tvContent.getItems().clear();

        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY.replace("?", cbTables.getValue()));
            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                TableColumn<Map, String> column =
                        new TableColumn<>(metaData.getColumnName(i));
                column.setCellValueFactory(
                        new MapValueFactory<>(metaData.getColumnName(i)));
                tvContent.getColumns().add(column);
            }

            ObservableList<Map<String, String>> items =
                    FXCollections.observableArrayList();
            while (resultSet.next())
            {
                HashMap<String, String> row = new HashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++)
                    row.put(metaData.getColumnName(i),
                            resultSet.getString(i));
                items.add(row);
            }
            tvContent.getItems().addAll(items);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
