package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * **15.15 (Geometry: add and remove points) Write a program that lets the user click on
 * a pane to dynamically create and remove points (see Figure 15.30a). When the
 * user left-clicks the mouse (primary button), a point is created and displayed
 * at the mouse point. The user can remove a point by pointing to it and right clicking
 * the mouse (secondary button).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$15");
        primaryStage.setScene(scene);
        primaryStage.show();


        pane.setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY)
            {
                Circle circle = new Circle(e.getX(), e.getY(), 5);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                pane.getChildren().add(circle);

                circle.setOnMousePressed(e2 ->
                {
                    if (e2.getButton() == MouseButton.SECONDARY)
                        pane.getChildren().remove(circle);
                });
            }
        });
    }
}
