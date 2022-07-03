package chapter_sixteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***16.29 (Display a calendar) Write a program that displays the calendar for the current
 * month. You can use the Prior and Next buttons to show the calendar of the
 * previous or next month. Display the dates in the current month in black and
 * display the dates in the previous month and next month in gray, as shown in
 * Figure 16.48.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$29 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        MonthPane pane = new MonthPane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$29");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
