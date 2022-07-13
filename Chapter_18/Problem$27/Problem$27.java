package chapter_eighteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **18.27 (Koch snowflake fractal) The text presented the Sierpinski triangle fractal. In
 * this exercise, you will write a program to display another fractal, called the Koch
 * snowflake, named after a famous Swedish mathematician. A Koch snowflake is
 * created as follows:
 * 1. Begin with an equilateral triangle, which is considered to be the Koch fractal
 * of order (or level) 0, as shown in Figure 18.14a.
 * 2. Divide each line in the shape into three equal line segments and draw an outward
 * equilateral triangle with the middle line segment as the base to create a
 * Koch fractal of order 1, as shown in Figure 18.14b.
 * 3. Repeat Step 2 to create a Koch fractal of order 2, 3, . . . , and so on, as shown
 * in Figures 18.14c and d.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$27 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        KochSnowflakePane pane = new KochSnowflakePane();
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Problem$27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
