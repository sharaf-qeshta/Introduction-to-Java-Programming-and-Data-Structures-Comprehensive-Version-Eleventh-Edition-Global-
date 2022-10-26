package chapter_thirty_four;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static final String VIEW_QUERY =
            "select * from Staff where id = ?";
    public static final String INSERT_STATEMENT =
            "insert into Staff (id, lastName, firstName, mi, address, city, state, telephone)" +
                    " value (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_STATEMENT =
            "update Staff set id = ?, lastName = ?, firstName = ?," +
                    " mi = ?, address = ?, city = ?, state = ?, telephone = ?"
                    + " where id = ?";

    private Connection connection;
    public Controller()
    {
        try
        {
            // Class.forName("com.mysql.jdbc.Driver"); -- This is deprecated --
            connection = DriverManager.getConnection(
                    LINK, USER_NAME, PASSWORD);
        }
        catch (Exception exception)
        {
            status.setText("Error while connecting to the database");
            System.exit(-1);
        }
    }

    @FXML
    private Text status;

    @FXML
    private TextField tfId, tfFirstName,
            tfLastName, tfMI, tfAddress,
            tfCity, tfState, tfTelephone;

    @FXML
    public void view()
    {
        status.setText("");
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_QUERY);
            preparedStatement.setString(1, tfId.getText().trim());
            ResultSet result = preparedStatement.executeQuery();

            if (result.next())
            {
                tfLastName.setText(result.getString(2));
                tfFirstName.setText(result.getString(3));
                tfMI.setText(result.getString(4));
                tfAddress.setText(result.getString(5));
                tfCity.setText(result.getString(6));
                tfState.setText(result.getString(7));
                tfTelephone.setText(result.getString(8));
            }
            else
                status.setText("Record not found");
        }
        catch (Exception exception)
        {
            status.setText(exception.getMessage());
        }
    }

    @FXML
    public void insert()
    {
        status.setText("");
        try
        {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(INSERT_STATEMENT);
            preparedStatement.setString(1, tfId.getText().trim());
            preparedStatement.setString(2, tfLastName.getText().trim());
            preparedStatement.setString(3, tfFirstName.getText().trim());
            preparedStatement.setString(4, tfMI.getText().trim());
            preparedStatement.setString(5, tfAddress.getText().trim());
            preparedStatement.setString(6, tfCity.getText().trim());
            preparedStatement.setString(7,tfState.getText().trim());
            preparedStatement.setString(8, tfTelephone.getText().trim());

            preparedStatement.executeUpdate();
        }
        catch (Exception exception)
        {
            status.setText(exception.getMessage());
        }
    }

    @FXML
    public void update()
    {
        status.setText("");
        try
        {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(UPDATE_STATEMENT);
            preparedStatement.setString(1, tfId.getText().trim());
            preparedStatement.setString(2, tfLastName.getText().trim());
            preparedStatement.setString(3, tfFirstName.getText().trim());
            preparedStatement.setString(4, tfMI.getText().trim());
            preparedStatement.setString(5, tfAddress.getText().trim());
            preparedStatement.setString(6, tfCity.getText().trim());
            preparedStatement.setString(7,tfState.getText().trim());
            preparedStatement.setString(8, tfTelephone.getText().trim());
            preparedStatement.setString(9, tfId.getText().trim());

            preparedStatement.executeUpdate();
        }
        catch (Exception exception)
        {
            status.setText(exception.getMessage());
        }
    }

    @FXML
    public void clear()
    {
        status.setText("");
        tfId.setText("");
        tfLastName.setText("");
        tfFirstName.setText("");
        tfAddress.setText("");
        tfCity.setText("");
        tfState.setText("");
        tfTelephone.setText("");
        tfMI.setText("");
    }
}
