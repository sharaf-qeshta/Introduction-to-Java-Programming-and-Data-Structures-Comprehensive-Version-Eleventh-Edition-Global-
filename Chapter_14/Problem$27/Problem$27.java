package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * *14.27 (Draw a detailed clock) Modify the ClockPane class in Section 14.12 to draw
 * the clock with more details on the hours and minutes, as shown in Figure 14.52a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$27 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        ClockPane clock = new ClockPane(4, 20, 45);
        String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
