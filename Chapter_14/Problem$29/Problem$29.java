package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **14.29 (Game: bean machine) Write a program that displays a bean machine introduced
 * in Programming Exercise 7.37, as shown in Figure 14.52c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$29 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        BeanMachine pane = new BeanMachine();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$29");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
