package chapter_thirty_five;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *35.4 (Find tables and showing their contents) Write a program that fills in table names
 * in a combo box, as shown in Figure 35.7b. You can select a table from the combo
 * box to display its contents in a table view.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04 extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("Problem$04.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem$04");
        stage.show();
    }
}
