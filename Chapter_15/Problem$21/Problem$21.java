package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * *15.21 (Drag points) Draw a circle with three random points on the circle. Connect
 * the points to form a triangle. Display the angles in the triangle. Use the mouse
 * to drag a point along the perimeter of the circle. As you drag it, the triangle and
 * angles are redisplayed dynamically, as shown in Figure 15.32b. For computing
 * angles in a triangle, see Listing 4.1.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TrianglePane pane = new TrianglePane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
