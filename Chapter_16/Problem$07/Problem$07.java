package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * *16.7 (Set clock time) Write a program that displays a clock and sets the time with the
 * input from three text fields, as shown in Figure 16.38b. Use the ClockPane in
 * Listing 14.21. Resize the clock to the center of the pane.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends Application
{
    private static final TextField hourInput = new TextField();
    private static final TextField minuteInput = new TextField();
    private static final TextField secondInput = new TextField();


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        ClockPane clockPane = new ClockPane();

        Label hourLabel = new Label("Hour");
        hourInput.setPrefColumnCount(2);

        Label minuteLabel = new Label("Minutes");
        minuteInput.setPrefColumnCount(2);

        Label secondLabel = new Label("Seconds");
        secondInput.setPrefColumnCount(2);


        HBox settings = new HBox(10, hourLabel, hourInput,
                minuteLabel, minuteInput, secondLabel, secondInput);
        settings.setAlignment(Pos.CENTER);


        hourInput.setOnAction(e -> setTime(clockPane));
        minuteInput.setOnAction(e -> setTime(clockPane));
        secondInput.setOnAction(e -> setTime(clockPane));

        BorderPane pane = new BorderPane();
        pane.setCenter(clockPane);
        pane.setBottom(settings);


        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$07");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void setTime(ClockPane pane)
    {
        int hours, minutes, second;
        try
        {
            hours = Integer.parseInt(hourInput.getText());
            minutes = Integer.parseInt(minuteInput.getText());
            second = Integer.parseInt(secondInput.getText());
        }
        catch (Exception e)
        {
            System.out.println("Make sure that you fill all the fields");
            return;
        }

        pane.setHour(hours); pane.setMinute(minutes); pane.setSecond(second);
    }
}
