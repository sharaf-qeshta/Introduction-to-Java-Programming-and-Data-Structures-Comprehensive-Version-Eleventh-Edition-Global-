package chapter_sixteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * *16.20 (Count-up stopwatch) Write a program that simulates a stopwatch, as shown
 * in Figure 16.45a. When the user clicks the Start button, the button’s label is
 * changed to Pause, as shown in Figure 16.45b. When the user clicks the Pause
 * button, the button’s label is changed to Resume, as shown in Figure 16.45c. The
 * Clear button resets the count to 0 and resets the button’s label to Start.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
{
    private static final int MAX_HOURS = 99;
    private static final int MAX_MINUTES = 59;
    private static final int MAX_SECONDS = 59;

    private int currentHours = 0;
    private int currentMinutes = 0;
    private int currentSecond = 0;
    @Override
    public void start(Stage primaryStage)
    {
        Label time = new Label("00:00:00");

        Button control = new Button("Stop");
        Button clear = new Button("Clear");

        HBox buttonsContainer = new HBox(5, control, clear);
        buttonsContainer.setAlignment(Pos.CENTER);

        VBox pane = new VBox(10, time, buttonsContainer);
        pane.setAlignment(Pos.CENTER);


        Scene scene = new Scene(pane, 100, 100);
        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e ->
                {
                    currentSecond++;
                    modifyTime(time);
                })
        );

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        control.setOnAction(e ->
        {
            if (control.getText().equals("Stop"))
            {
                control.setText("Resume");
                animation.pause();
            }
            else if (control.getText().equals("Resume"))
            {
                control.setText("Stop");
                animation.play();
            }
        });

        clear.setOnAction(e ->
        {
            currentHours = 0; currentMinutes = 0; currentSecond = 0;
            modifyTime(time);
        });
    }


    private void modifyTime(Label label)
    {
        if (currentSecond > MAX_SECONDS)
        {
            currentMinutes++;
            currentSecond = 0;
        }

        if (currentMinutes > MAX_MINUTES)
        {
            currentHours++;
            currentMinutes = 0;
        }

        if (currentHours > MAX_HOURS)
            System.exit(0);

        String time;

        if (currentHours == 0)
        {
            time = "00:" +  String.format("%02d", currentMinutes)
                    + ":" +  String.format("%02d", currentSecond);
        }
        else
        {
            time = String.format("%02d", currentHours) +  String.format("%02d", currentMinutes)
                    + ":" +  String.format("%02d", currentSecond);
        }

        label.setText(time);
    }
}
