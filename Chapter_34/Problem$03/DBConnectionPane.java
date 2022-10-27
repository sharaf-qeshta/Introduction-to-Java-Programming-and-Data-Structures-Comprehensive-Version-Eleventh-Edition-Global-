package chapter_thirty_four;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionPane extends BorderPane
{
    public DBConnectionPane()
    {
        draw();
    }

    public void draw()
    {
        Label status = new Label("No connection");
        setTop(status);
        BorderPane.setAlignment(status, Pos.CENTER);

        GridPane center = new GridPane();

        center.add(new Label("JDBC Drive "), 0, 0);
        TextField tfJDBC = new TextField();
        tfJDBC.setPrefColumnCount(20);
        center.add(tfJDBC, 1, 0);

        center.add(new Label("Database URL "), 0, 1);
        TextField tfURL = new TextField();
        tfURL.setPrefColumnCount(20);
        center.add(tfURL, 1, 1);

        center.add(new Label("Username "), 0, 2);
        TextField tfUsername = new TextField();
        tfUsername.setPrefColumnCount(20);
        center.add(tfUsername, 1, 2);

        center.add(new Label("Password "), 0, 3);
        TextField tfPassword = new PasswordField();
        tfPassword.setPrefColumnCount(20);
        center.add(tfPassword, 1, 3);

        setCenter(center);

        Button btnConnectToDB = new Button("Connect to DB");
        BorderPane.setAlignment(btnConnectToDB, Pos.TOP_RIGHT);
        setBottom(btnConnectToDB);

        btnConnectToDB.setOnAction(e ->
        {
            try
            {
                Class.forName(tfJDBC.getText().trim());
                String url = tfURL.getText().trim();
                String username = tfUsername.getText().trim();
                String password = tfPassword.getText().trim();

                Connection connection = DriverManager.getConnection(url,
                        username, password);
                status.setText("Connected to " + url);
            }
            catch (Exception exception)
            {
                status.setText(exception.getMessage());
            }
        });
    }
}
