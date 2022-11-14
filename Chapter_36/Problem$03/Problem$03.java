package chapter_thirty_six;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 36.3 (Place the calendar and clock in a panel) Write a program that displays the current
 * date in a calendar and current time in a clock, as shown in Figure 36.15. Enable the
 * program to run standalone.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    @Override
    public void start(Stage stage)
    {
        HBox pane = new HBox(10, new CalendarPane(), new ClockPane());
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane, 650, 250);
        stage.setScene(scene);
        stage.setTitle("Problem$03");
        stage.show();
    }
}
