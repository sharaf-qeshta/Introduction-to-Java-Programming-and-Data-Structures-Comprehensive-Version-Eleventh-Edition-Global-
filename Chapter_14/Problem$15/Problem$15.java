package chapter_fourteen;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *14.15 (Display a SLOW sign) Write a program that displays a SLOW sign, as shown in
 * Figure 14.47b. The octagon is in red and the sign is in white. (Hint: Place an
 * octagon and a text in a stack pane.)
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
        StackPane stackPane = new StackPane();

        Polygon polygon = new Polygon();
        stackPane.getChildren().add(polygon);
        polygon.setFill(Color.RED);
        polygon.setRotate(20);
        ObservableList<Double> list = polygon.getPoints();

        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;

        for (int i = 0; i < 8; i++)
        {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }


        Text text = new Text("STOP");
        text.setFont(Font.font("Times new Roman", FontWeight.BOLD, 40));
        text.setFill(Color.WHITE);
        stackPane.getChildren().add(text);


        Scene scene = new Scene(stackPane, 500, 500);
        primaryStage.setTitle("Problem$15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
