package chapter_thirty_four;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *34.5 (Display table contents) Write a program that displays the content for a given table.
 * As shown in Figure 34.30a, you enter a table and click the Show Contents button
 * to display the table contents in the text area.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("Problem$05.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem$05");
        stage.show();
    }
}
