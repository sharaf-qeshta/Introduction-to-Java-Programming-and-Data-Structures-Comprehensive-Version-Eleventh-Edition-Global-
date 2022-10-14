package chapter_thirty_two;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 32.7 (Control a clock) Rewrite Programming Exercise 15.32 using a thread to control
 * the clock animation.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends Application
{
    @Override
    public void start(Stage stage)
    {
        BorderPane pane = new BorderPane();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Button stop = new Button("Stop");
        Button start = new Button("Start");

        ClockPane clock = new ClockPane();

        stop.setOnAction(e -> new Thread(clock::stop).start());
        start.setOnAction(e -> new Thread(clock::play).start());

        hBox.getChildren().addAll(stop, start);

        pane.setCenter(clock);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Problem$07");
        stage.setScene(scene);
        stage.show();

        pane.requestFocus();
    }
}
