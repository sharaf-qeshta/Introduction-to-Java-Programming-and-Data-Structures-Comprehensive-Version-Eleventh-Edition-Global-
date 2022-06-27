package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


/**
 * **16.3 (Traffic lights) Write a program that simulates a traffic light.
 * The program lets
 * the user select one of three lights: red, yellow, or green. When a radio
 * button is selected, the light is turned on. Only one light can be on at a time (see
 * Figure 16.37a). No light is on when the program starts.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03 extends Application
{
    private final Circle circle1 = new Circle(250, 250, 10, Color.WHITE);
    private final Circle circle2 = new Circle(250, 250, 10, Color.WHITE);
    private final Circle circle3 = new Circle(250, 250, 10, Color.WHITE);
    private Shape currentShape = circle1;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // strokes
        circle1.setStroke(Color.BLACK);
        circle2.setStroke(Color.BLACK);
        circle3.setStroke(Color.BLACK);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton green = new RadioButton("Green");

        red.setToggleGroup(toggleGroup);
        yellow.setToggleGroup(toggleGroup);
        green.setToggleGroup(toggleGroup);

        red.setOnAction(e ->
        {
            currentShape.setFill(Color.WHITE);
            currentShape = circle1;
            currentShape.setFill(Color.RED);
        });

        yellow.setOnAction(e ->
        {
            currentShape.setFill(Color.WHITE);
            currentShape = circle2;
            currentShape.setFill(Color.YELLOW);
        });

        green.setOnAction(e ->
        {
            currentShape.setFill(Color.WHITE);
            currentShape = circle3;
            currentShape.setFill(Color.GREEN);
        });

        HBox lights = new HBox(10, circle1, circle2, circle3);
        lights.setAlignment(Pos.CENTER);
        lights.setStyle("-fx-border-color:black");
        lights.setMaxSize(50, 50);

        HBox colors = new HBox(10, red, yellow, green);
        colors.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(lights);
        pane.setBottom(colors);

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
