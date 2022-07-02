package chapter_sixteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.util.ArrayList;

/**
 * **16.19 (Control a group of fans) Write a program that displays three fans in a group
 * with control buttons to start and stop all of them, as shown in Figure 16.44.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19 extends Application
{
    public static final ArrayList<Timeline> ANIMATIONS = new ArrayList<>();

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(5);
        HBox fans = new HBox(5);
        HBox settings = new HBox(5);

        Button startAll = new Button("Start All");
        Button stopAll = new Button("Stop All");
        settings.getChildren().addAll(startAll, stopAll);
        settings.setAlignment(Pos.CENTER);

        stopAll.setOnAction(e -> stopAll());
        startAll.setOnAction(e -> startAll());

        pane.getChildren().addAll(fans, settings);

        Scene scene = new Scene(pane, 600, 250);
        fans.getChildren().addAll(getFan(scene), getFan(scene), getFan(scene));
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static BorderPane getFan(Scene scene)
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


        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(100), e -> fan.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        ANIMATIONS.add(animation);

        scene.widthProperty().addListener(e -> fan.setW(fan.getWidth()));
        scene.heightProperty().addListener(e -> fan.setH(fan.getHeight()));

        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fan.reverse());

        slSpeed.setMax(20);
        animation.rateProperty().bind(slSpeed.valueProperty());
        pane.setStyle("-fx-border-color: black");

        return pane;
    }

    public static void stopAll()
    {
        for (Timeline animation : ANIMATIONS)
            animation.pause();
    }

    public static void startAll()
    {
        for (Timeline animation : ANIMATIONS)
            animation.play();
    }
}
