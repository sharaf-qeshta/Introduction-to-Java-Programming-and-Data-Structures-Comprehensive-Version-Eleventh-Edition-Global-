package chapter_thirty_two;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 32.5 (Display a running fan) Rewrite Programming Exercise 15.28 using a thread to
 * control the fan animation.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    @Override
    public void start(Stage stage)
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


        Scene scene = new Scene(pane, 200, 250);
        stage.setTitle("Problem$05");
        stage.setScene(scene);
        stage.show();

        new Thread(() ->
        {
            Timeline animation = new Timeline(
                    new KeyFrame(Duration.millis(100), e -> fan.move()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();

            scene.widthProperty().addListener(e -> Platform.runLater(() -> fan.setW(fan.getWidth())));
            scene.heightProperty().addListener(e -> Platform.runLater(() -> fan.setH(fan.getHeight())));

            btPause.setOnAction(e -> Platform.runLater(animation::pause));
            btResume.setOnAction(e -> Platform.runLater(animation::play));
            btReverse.setOnAction(e -> Platform.runLater(fan::reverse));

            slSpeed.setMax(20);
            animation.rateProperty().bind(slSpeed.valueProperty());
        }).start();
    }
}
