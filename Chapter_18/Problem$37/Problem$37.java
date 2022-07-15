package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * **18.37 (Hilbert curve) The Hilbert curve, first described by German mathematician
 * David Hilbert in 1891, is a space-filling curve that visits every point in a square
 * grid with a size of 2 * 2, 4 * 4, 8 * 8, 16 * 16, or any other power of 2.
 * Write a program that displays a Hilbert curve for the specified order, as shown
 * in Figure 18.19.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$37 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        HilbertCurvePane pane = new HilbertCurvePane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$37");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
