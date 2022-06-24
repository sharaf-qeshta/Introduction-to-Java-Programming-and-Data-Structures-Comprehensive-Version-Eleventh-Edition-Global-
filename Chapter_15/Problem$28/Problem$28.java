package chapter_fifteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.28 (Display a running fan) Write a program that displays a running fan, as shown
 * in Figure 15.35c. Use the Pause, Resume, Reverse buttons to pause, resume,
 * and reverse fan running.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$28 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        FanPane fan = new FanPane();

        HBox hBox = new HBox(5);
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPause, btResume, btReverse);

        BorderPane pane = new BorderPane();
        BorderPane.setAlignment(fan, Pos.CENTER);
        pane.setCenter(fan);
        pane.setTop(hBox);

        Slider slSpeed = new Slider();
        slSpeed.setValue(10);
        pane.setBottom(slSpeed);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$28");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(100), e -> fan.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        scene.widthProperty().addListener(e -> fan.setW(fan.getWidth()));
        scene.heightProperty().addListener(e -> fan.setH(fan.getHeight()));

        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fan.reverse());

        slSpeed.setMax(20);
        animation.rateProperty().bind(slSpeed.valueProperty());
    }
}
