package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***15.33 (Game: bean-machine animation) Write a program that animates the bean
 * machine introduced in Programming Exercise 7.37. The animation terminates
 * after 10 balls are dropped, as shown in Figures 15.38b and c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$33 extends Application
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
        primaryStage.setTitle("Problem$33");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
