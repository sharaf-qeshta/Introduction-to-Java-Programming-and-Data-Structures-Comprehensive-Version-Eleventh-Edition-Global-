package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * *15.7 (Change color using a mouse) Write a program that displays the color of a circle
 * as red when the mouse button is pressed and as blue when the mouse button
 * is released
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);

        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        circle.setOnMousePressed(e -> circle.setFill(Color.RED));

        circle.setOnMouseReleased(e -> circle.setFill(Color.BLUE));

        pane.getChildren().add(circle);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$07");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
