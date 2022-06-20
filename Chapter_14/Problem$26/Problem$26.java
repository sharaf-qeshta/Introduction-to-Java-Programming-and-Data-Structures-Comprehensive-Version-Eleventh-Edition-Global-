package chapter_fourteen;

import javafx.application.Application;
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 14.26 (Use the ClockPane class) Write a program that displays two clocks. The hour,
 * minute, and second values are 4, 20, 45 for the first clock, and 22, 46, 15 for the
 * second clock, as shown in Figure 14.51c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$26 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        pane.setPrefWidth(500); pane.setPrefHeight(500);

        ClockPane clock = new ClockPane(4, 20, 45);
        String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        BorderPane pane1 = new BorderPane();
        pane1.setPrefWidth(250); pane1.setPrefHeight(250);
        pane1.setCenter(clock);
        pane1.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);


        ClockPane clock2 = new ClockPane(22, 46, 15);
        String timeString2 = clock2.getHour() + ":" + clock2.getMinute() + ":" + clock2.getSecond();
        Label lblCurrentTime2 = new Label(timeString2);

        BorderPane pane2 = new BorderPane();
        pane2.setPrefWidth(250); pane2.setPrefHeight(250);
        pane2.setCenter(clock2);
        pane2.setBottom(lblCurrentTime2);
        BorderPane.setAlignment(lblCurrentTime2, Pos.TOP_CENTER);

        pane.getChildren().addAll(pane1, pane2);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$26");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
