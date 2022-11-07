package chapter_thirty_five;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * **35.5 (Revise SQLClient.java) Rewrite Listing 35.1, SQLClient.java, to display the query
 * result in a TableView, as shown in Figure 35.8.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    // Connection to the database
    private Connection connection;

    // Statement to execute SQL commands
    private Statement statement;

    // Text area to enter SQL commands
    private final TextArea taSQLCommand = new TextArea();

    // TableView to display results from SQL commands
    private final TableView<Map> tvSQLResult = new TableView<>();
    private final Label executionStatus = new Label();

    // DBC info for a database connection
    private final TextField tfUsername = new TextField();
    private final PasswordField pfPassword = new PasswordField();
    private final ComboBox<String> cboURL = new ComboBox<>();
    private final ComboBox<String> cboDriver = new ComboBox<>();

    private final Button btExecuteSQL = new Button("Execute SQL Command");
    private final Button btClearSQLCommand = new Button("Clear");
    private final Button btConnectDB = new Button("Connect to Database");
    private final Button btClearSQLResult = new Button("Clear Result");
    private final Label lblConnectionStatus
            = new Label("No connection now");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        tvSQLResult.setMinWidth(800);
        cboURL.getItems().addAll(FXCollections.observableArrayList(
                "jdbc:mysql://localhost/javabook",
                "jdbc:mysql://liang.armstrong.edu/javabook",
                "jdbc:odbc:exampleMDBDataSource",
                "jdbc:mysql://localhost:3307/java_book",
                "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl"));
        cboURL.getSelectionModel().selectFirst();

        cboDriver.getItems().addAll(FXCollections.observableArrayList(
                "com.mysql.jdbc.Driver", "sun.jdbc.odbc.dbcOdbcDriver",
                "oracle.jdbc.driver.OracleDriver"));
        cboDriver.getSelectionModel().selectFirst();

        // Create UI for connecting to the database
        GridPane gridPane = new GridPane();
        gridPane.add(cboURL, 1, 0);
        gridPane.add(cboDriver, 1, 1);
        gridPane.add(tfUsername, 1, 2);
        gridPane.add(pfPassword, 1, 3);
        gridPane.add(new Label("JDBC Driver"), 0, 0);
        gridPane.add(new Label("Database URL"), 0, 1);
        gridPane.add(new Label("Username"), 0, 2);
        gridPane.add(new Label("Password"), 0, 3);

        HBox hBoxConnection = new HBox();
        hBoxConnection.getChildren().addAll(
                lblConnectionStatus, btConnectDB);
        hBoxConnection.setAlignment(Pos.CENTER_RIGHT);

        VBox vBoxConnection = new VBox(5);
        vBoxConnection.getChildren().addAll(
                new Label("Enter Database Information"),
                gridPane, hBoxConnection);

        gridPane.setStyle("-fx-border-color: black;");

        HBox hBoxSQLCommand = new HBox(5);
        hBoxSQLCommand.getChildren().addAll(
                btClearSQLCommand, btExecuteSQL);
        hBoxSQLCommand.setAlignment(Pos.CENTER_RIGHT);

        BorderPane borderPaneSqlCommand = new BorderPane();
        borderPaneSqlCommand.setTop(
                new Label("Enter an SQL Command"));
        borderPaneSqlCommand.setCenter(
                new ScrollPane(taSQLCommand));
        borderPaneSqlCommand.setBottom(
                hBoxSQLCommand);

        HBox hBoxConnectionCommand = new HBox(10);
        hBoxConnectionCommand.getChildren().addAll(
                vBoxConnection, borderPaneSqlCommand);

        BorderPane borderPaneExecutionResult = new BorderPane();
        borderPaneExecutionResult.setTop(
                new Label("SQL Execution Result"));
        borderPaneExecutionResult.setCenter(new VBox(5, executionStatus, tvSQLResult));
        borderPaneExecutionResult.setBottom(btClearSQLResult);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBoxConnectionCommand);
        borderPane.setCenter(borderPaneExecutionResult);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 900, 500);
        primaryStage.setTitle("Problem$05"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        btConnectDB.setOnAction(e -> connectToDB());
        btExecuteSQL.setOnAction(e -> executeSQL());
        btClearSQLCommand.setOnAction(e -> taSQLCommand.setText(null));
        btClearSQLResult.setOnAction(e ->
        {
            tvSQLResult.getColumns().clear();
            tvSQLResult.getItems().clear();
        });
    }

    /**
     * Connect to DB
     */
    private void connectToDB()
    {
        // Get database information from the user input
        String driver = cboDriver
                .getSelectionModel().getSelectedItem();
        String url = cboURL.getSelectionModel().getSelectedItem();
        String username = tfUsername.getText().trim();
        String password = pfPassword.getText().trim();

        // Connection to the database
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(
                    url, username, password);
            lblConnectionStatus.setText("Connected to " + url);
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Execute SQL commands
     */
    private void executeSQL()
    {
        executionStatus.setText("");
        if (connection == null)
        {
            executionStatus.setText("Please connect to a database first");
        }
        else
        {
            String sqlCommands = taSQLCommand.getText().trim();
            String[] commands = sqlCommands.replace('\n', ' ').split(";");

            for (String aCommand : commands)
            {
                if (aCommand.trim().toUpperCase().startsWith("SELECT"))
                {
                    processSQLSelect(aCommand);
                }
                else
                {
                    processSQLNonSelect(aCommand);
                }
            }
        }
    }

    /**
     * Execute SQL SELECT commands
     */
    private void processSQLSelect(String sqlCommand)
    {
        try
        {
            // Get a new statement for the current connection
            statement = connection.createStatement();

            // Execute a SELECT SQL command
            ResultSet resultSet = statement.executeQuery(sqlCommand);

            tvSQLResult.getColumns().clear();
            tvSQLResult.getItems().clear();

            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                TableColumn<Map, String> column =
                        new TableColumn<>(metaData.getColumnName(i));
                column.setCellValueFactory(
                        new MapValueFactory<>(metaData.getColumnName(i)));
                tvSQLResult.getColumns().add(column);
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
            tvSQLResult.getItems().addAll(items);
        }
        catch (SQLException ex)
        {
            executionStatus.setText(ex.toString());
        }
    }

    /**
     * Execute SQL DDL, and modification commands
     */
    private void processSQLNonSelect(String sqlCommand)
    {
        try
        {
            // Get a new statement for the current connection
            statement = connection.createStatement();

            // Execute a non-SELECT SQL command
            statement.executeUpdate(sqlCommand);

            executionStatus.setText("SQL command executed");
        }
        catch (SQLException ex)
        {
            executionStatus.setText(ex.toString());
        }
    }
}
