package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * 15.2 (Rotate a Ellipse) Write a program that rotates a Ellipse when the Rotate
 * button is clicked, as shown in Figure 15.26b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02 extends Application
{
    private static final double ROTATION = 10.0;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);

        Ellipse ellipse = new Ellipse(50, 100, 50, 100);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);

        Button rotate = new Button("Rotate");

        rotate.setOnAction(e -> ellipse.setRotate(ellipse.getRotate() + ROTATION));

        pane.getChildren().addAll(ellipse, rotate);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
