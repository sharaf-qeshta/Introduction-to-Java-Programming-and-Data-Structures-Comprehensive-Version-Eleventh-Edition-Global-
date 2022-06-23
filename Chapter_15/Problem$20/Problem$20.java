package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * **15.20 (Geometry: display angles) Write a program that enables the user to drag the
 * vertices of a triangle and displays the angles dynamically as the triangle shape
 * changes, as shown in Figure 15.32a. The formula to compute angles is given in
 * Listing 4.1.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$20 extends Application
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
        primaryStage.setTitle("Problem$20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
