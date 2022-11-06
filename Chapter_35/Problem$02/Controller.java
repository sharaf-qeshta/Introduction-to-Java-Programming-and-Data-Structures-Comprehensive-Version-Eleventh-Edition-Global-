package chapter_thirty_five;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;


public class Controller
{
    public static final String LINK = "jdbc:mysql://localhost:3307/java_book";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    ResultSet scrollable;
    private int currentRow = 1;

    public Controller()
    {
        try
        {
            Connection connection = DriverManager.getConnection(LINK,
                    USER_NAME, PASSWORD);
            connection.setAutoCommit(true);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            scrollable = statement.executeQuery("select * from Address;");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    TextField tfLastName, tfFirstName, tfMI,
            tfStreet, tfCity, tfState, tfZIP,
            tfTelephone, tfEmail;

    @FXML
    Text txRowCount;

    @FXML
    public void first()
    {
        try
        {
            scrollable.absolute(1);
            currentRow = 1;
            tfFirstName.setText(scrollable.getString("firstname"));
            tfLastName.setText(scrollable.getString("lastname"));
            tfMI.setText(scrollable.getString("mi"));
            tfStreet.setText(scrollable.getString("street"));
            tfCity.setText(scrollable.getString("city"));
            tfState.setText(scrollable.getString("state"));
            tfZIP.setText(scrollable.getString("zip"));
            tfTelephone.setText(scrollable.getString("telephone"));
            tfEmail.setText(scrollable.getString("email"));
            txRowCount.setText("current row number : "+ currentRow);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    public void next()
    {
        try
        {
            if (scrollable.next())
            {
                currentRow++;
                tfFirstName.setText(scrollable.getString("firstname"));
                tfLastName.setText(scrollable.getString("lastname"));
                tfMI.setText(scrollable.getString("mi"));
                tfStreet.setText(scrollable.getString("street"));
                tfCity.setText(scrollable.getString("city"));
                tfState.setText(scrollable.getString("state"));
                tfZIP.setText(scrollable.getString("zip"));
                tfTelephone.setText(scrollable.getString("telephone"));
                tfEmail.setText(scrollable.getString("email"));
                txRowCount.setText("current row number : "+ currentRow);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    public void prior()
    {
        try
        {
            if (currentRow > 1)
            {
                currentRow--;
                scrollable.absolute(currentRow);
                tfFirstName.setText(scrollable.getString("firstname"));
                tfLastName.setText(scrollable.getString("lastname"));
                tfMI.setText(scrollable.getString("mi"));
                tfStreet.setText(scrollable.getString("street"));
                tfCity.setText(scrollable.getString("city"));
                tfState.setText(scrollable.getString("state"));
                tfZIP.setText(scrollable.getString("zip"));
                tfTelephone.setText(scrollable.getString("telephone"));
                tfEmail.setText(scrollable.getString("email"));
                txRowCount.setText("current row number : "+ currentRow);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    public void last()
    {
        try
        {
            if (scrollable.last())
            {
                currentRow = scrollable.getRow();
                tfFirstName.setText(scrollable.getString("firstname"));
                tfLastName.setText(scrollable.getString("lastname"));
                tfMI.setText(scrollable.getString("mi"));
                tfStreet.setText(scrollable.getString("street"));
                tfCity.setText(scrollable.getString("city"));
                tfState.setText(scrollable.getString("state"));
                tfZIP.setText(scrollable.getString("zip"));
                tfTelephone.setText(scrollable.getString("telephone"));
                tfEmail.setText(scrollable.getString("email"));
                txRowCount.setText("current row number : "+ currentRow);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    public void insert()
    {
        try
        {
            scrollable.last();
            scrollable.moveToInsertRow();
            scrollable.updateString("firstname", tfFirstName.getText().trim());
            scrollable.updateString("lastname", tfLastName.getText().trim());
            scrollable.updateString("mi", tfMI.getText().trim());
            scrollable.updateString("street", tfStreet.getText().trim());
            scrollable.updateString("city", tfCity.getText().trim());
            scrollable.updateString("state", tfState.getText().trim());
            scrollable.updateString("zip", tfZIP.getText().trim());
            scrollable.updateString("telephone", tfTelephone.getText().trim());
            scrollable.updateString("email", tfEmail.getText().trim());
            scrollable.insertRow();
            scrollable.moveToCurrentRow();
            currentRow = scrollable.getRow();
            txRowCount.setText("current row number : "+ currentRow);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    public void delete()
    {
        try
        {
            if (currentRow == 1)
            {
                scrollable.deleteRow();
                currentRow++;
                scrollable.absolute(currentRow);
                tfFirstName.setText(scrollable.getString("firstname"));
                tfLastName.setText(scrollable.getString("lastname"));
                tfMI.setText(scrollable.getString("mi"));
                tfStreet.setText(scrollable.getString("street"));
                tfCity.setText(scrollable.getString("city"));
                tfState.setText(scrollable.getString("state"));
                tfZIP.setText(scrollable.getString("zip"));
                tfTelephone.setText(scrollable.getString("telephone"));
                tfEmail.setText(scrollable.getString("email"));
                txRowCount.setText("current row number : "+ currentRow);
            }
            else
            {
                scrollable.deleteRow();
                currentRow--;
                scrollable.absolute(currentRow);
                tfFirstName.setText(scrollable.getString("firstname"));
                tfLastName.setText(scrollable.getString("lastname"));
                tfMI.setText(scrollable.getString("mi"));
                tfStreet.setText(scrollable.getString("street"));
                tfCity.setText(scrollable.getString("city"));
                tfState.setText(scrollable.getString("state"));
                tfZIP.setText(scrollable.getString("zip"));
                tfTelephone.setText(scrollable.getString("telephone"));
                tfEmail.setText(scrollable.getString("email"));
                txRowCount.setText("current row number : "+ currentRow);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @FXML
    public void update()
    {
        try
        {
            scrollable.updateString("firstname", tfFirstName.getText().trim());
            scrollable.updateString("lastname", tfLastName.getText().trim());
            scrollable.updateString("mi", tfMI.getText().trim());
            scrollable.updateString("street", tfStreet.getText().trim());
            scrollable.updateString("city", tfCity.getText().trim());
            scrollable.updateString("state", tfState.getText().trim());
            scrollable.updateString("zip", tfZIP.getText().trim());
            scrollable.updateString("telephone", tfTelephone.getText().trim());
            scrollable.updateString("email", tfEmail.getText().trim());
            scrollable.updateRow();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
