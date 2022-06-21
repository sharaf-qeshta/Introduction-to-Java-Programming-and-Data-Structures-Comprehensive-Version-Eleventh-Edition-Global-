package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * *15.3 (Move the rectangle) Write a program that moves the rectangle in a pane.
 * You should define a pane class for displaying the ball and provide the methods
 * for moving the Rectangle left, right, up, and down, as shown in Figure 15.26c.
 * Check the boundary to prevent the ball from moving out of sight completely.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
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

        Rectangle rectangle = new Rectangle(200, 100, 50, 50);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);

        Pane pane1 = new Pane();
        pane1.getChildren().add(rectangle);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Button left = new Button("Left");
        Button right = new Button("Right");
        Button up = new Button("Up");
        Button down = new Button("Down");

        hBox.getChildren().addAll(left, right, up, down);

        pane.getChildren().addAll(pane1, hBox);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$03");
        primaryStage.setScene(scene);
        primaryStage.show();

        left.setOnAction(e -> rectangle.setX(rectangle.getX()-2 > 0? rectangle.getX()-2 : 0));

        right.setOnAction(e -> rectangle.setX(Math.min(rectangle.getX() + 2, scene.getWidth())));

        up.setOnAction(e -> rectangle.setY(rectangle.getY()-2 > 0? rectangle.getY()-2 : 0));

        down.setOnAction(e -> rectangle.setY(Math.min(rectangle.getY() + 2, scene.getWidth())));
    }
}
