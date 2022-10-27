package chapter_thirty_four;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *34.3 (Connection dialog) Develop a subclass of BorderPane named DBConnectionPane
 * that enables the user to select or enter a JDBC driver and a URL and to enter
 * a username and password, as shown in Figure 34.28. When the Connect to DB button
 * is clicked, a Connection object for the database is stored in the connection
 * property. You can then use the getConnection() method to return the connection.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    @Override
    public void start(Stage stage)
    {
        DBConnectionPane pane = new DBConnectionPane();
        Scene scene = new Scene(pane, 350, 150);
        stage.setScene(scene);
        stage.setTitle("Problem$03");
        stage.show();
    }
}
