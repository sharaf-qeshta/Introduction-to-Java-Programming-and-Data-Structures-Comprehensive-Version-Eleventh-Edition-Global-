package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * *15.32 (Control a clock) Modify Listing 14.21, ClockPane.java, to add the animation
 * into this class and add two methods start() and stop() to start and stop the
 * clock, respectively. Write a program that lets the user control the clock with the
 * Start and Stop buttons, as shown in Figure 15.38a.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$32 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane pane = new BorderPane();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Button stop = new Button("Stop");
        Button start = new Button("Start");

        ClockPane clock = new ClockPane();

        stop.setOnAction(e -> clock.stop());
        start.setOnAction(e -> clock.play());

        hBox.getChildren().addAll(stop, start);

        pane.setCenter(clock);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$32");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }
}
