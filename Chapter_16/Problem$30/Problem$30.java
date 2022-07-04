package chapter_sixteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * **16.30 (Pattern recognition: consecutive four equal numbers) Write a GUI program
 * for Programming Exercise 8.19, as shown in Figures 16.49a–b. Let the user
 * enter the numbers in the text fields in a grid of 6 rows and 7 columns. The user
 * can click the Solve button to highlight a sequence of four equal numbers, if it
 * exists. Initially, the values in the text fields are randomly filled with numbers
 * from 0 to 9.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$30 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        NumberPane pane = new NumberPane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$30");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
