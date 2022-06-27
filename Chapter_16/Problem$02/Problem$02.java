package chapter_sixteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * *16.2 (Select geometric figures) Write a program that draws various figures, as shown
 * in Figure 16.36b. The user selects a figure from a radio button and uses a check
 * box to specify whether it is filled.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    private final Circle circle_ = new Circle(250, 250, 50);
    private final Rectangle rectangle_ = new Rectangle(250, 250, 100, 100);
    private final Ellipse ellipse_ = new Ellipse(250, 250, 100, 50);
    private Shape currentShape = circle_;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // default settings
        circle_.setFill(Color.WHITE);
        circle_.setStroke(Color.BLACK);
        rectangle_.setFill(Color.WHITE);
        rectangle_.setStroke(Color.BLACK);
        ellipse_.setFill(Color.WHITE);
        ellipse_.setStroke(Color.BLACK);


        HBox settings = new HBox();
        settings.setSpacing(10);
        settings.setAlignment(Pos.CENTER);

        RadioButton circle = new RadioButton("Circle");
        RadioButton square = new RadioButton("Square");
        RadioButton ellipse = new RadioButton("Ellipse");
        CheckBox fill = new CheckBox("Fill"); // with black

        settings.getChildren().addAll(circle, square, ellipse, fill);

        // combine the buttons
        ToggleGroup group = new ToggleGroup();
        circle.setToggleGroup(group);
        square.setToggleGroup(group);
        ellipse.setToggleGroup(group);

        StackPane graphicPane = new StackPane();
        graphicPane.getChildren().add(currentShape);

        circle.setOnAction(e ->
        {
            currentShape = circle_;
            graphicPane.getChildren().set(0, currentShape);
        });

        square.setOnAction(e ->
        {
            currentShape = rectangle_;
            graphicPane.getChildren().set(0, currentShape);
        });

        ellipse.setOnAction(e ->
        {
            currentShape = ellipse_;
            graphicPane.getChildren().set(0, currentShape);
        });

        fill.setOnAction(e ->
        {
            if (currentShape.getFill().equals(Color.BLACK))
                currentShape.setFill(Color.WHITE);
            else
                currentShape.setFill(Color.BLACK);
        });


        BorderPane pane = new BorderPane();
        pane.setCenter(graphicPane);
        pane.setBottom(settings);


        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Problem$02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
