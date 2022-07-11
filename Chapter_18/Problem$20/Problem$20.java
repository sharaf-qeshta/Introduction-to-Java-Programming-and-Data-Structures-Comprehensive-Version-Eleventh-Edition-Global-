package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *18.20 (Display circles) Write a Java program that displays ovals, as shown in
 * Figure 18.12b. The circles are centered in the pane. The gap between two adjacent
 * circles is 10 pixels, and the gap between the border of the pane and the
 * largest circle is also 10.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        CircleFractal pane = new CircleFractal(20);
        pane.paint();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }
}
