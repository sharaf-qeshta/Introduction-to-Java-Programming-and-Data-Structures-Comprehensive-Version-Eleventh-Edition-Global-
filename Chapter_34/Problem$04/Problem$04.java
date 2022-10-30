package chapter_thirty_four;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *34.4 (Find grades) Listing 34.2, FindGrade.java, presented a program that finds a student’s
 * grade for a specified course. Rewrite the program to find all the grades for
 * a specified student, as shown in Figure 34.29.
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
