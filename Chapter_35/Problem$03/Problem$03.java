package chapter_thirty_five;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *35.3 (Display table contents) Write a program that displays the content for a given table.
 * As shown in Figure 35.7a, you enter a table and click the Show Contents button to
 * display the table contents in a table view.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("Problem$03.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem$03");
        stage.show();
    }
}
