package chapter_thirty_four;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *34.6 (Find tables and showing their contents) Write a program that fills in table names
 * in a combo box, as shown in Figure 34.30b. You can select a table from the combo
 * box to display its contents in the text area.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06 extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root =
                FXMLLoader.load(getClass().getResource("Problem$06.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Problem$06");
        stage.show();
    }
}
