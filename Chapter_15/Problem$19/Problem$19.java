package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **15.19 (Game: eye–hand coordination) Write a program that displays a circle of
 * radius 10 pixels filled with a random color at a random location on a pane, as
 * shown in Figure 15.31b. When you click the circle, it disappears and a new
 * random-color circle is displayed at another random location. After 20 circles
 * are clicked, display the time spent in the pane, as shown in Figure 15.31c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    private static double randomX = (Math.random() * 1000) % 500;
    private static double randomY = (Math.random() * 1000) % 500;
    private static double randomRed = Math.random();
    private static double randomGreen = Math.random();
    private static double randomBlue = Math.random();

    private final static double RADIUS = 10;

    private static long startTime;
    private static long endTime;

    private static int numberOfRounds = 0;

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Circle circle = new Circle(randomX, randomY, RADIUS);
        Color color = new Color(randomRed, randomGreen, randomBlue, Math.random());
        circle.setFill(color);

        Text text = new Text(250, 250, "");
        text.setVisible(false);

        pane.getChildren().addAll(circle, text);

        circle.setOnMousePressed(e ->
        {
            generateNewRandomValues();
            circle.setCenterX(randomX);
            circle.setCenterY(randomY);
            Color color_ = new Color(randomRed, randomGreen, randomBlue, Math.random());
            circle.setFill(color_);
            numberOfRounds++;

            if (numberOfRounds == 20)
            {
                pane.getChildren().remove(circle);
                endTime = System.currentTimeMillis();
                text.setText("time spent " + (endTime - startTime) + " milliseconds");
                text.setVisible(true);
            }

        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();
        startTime = System.currentTimeMillis();
    }

    private void generateNewRandomValues()
    {
        randomX = (Math.random() * 1000) % 500;
        randomY = (Math.random() * 1000) % 500;
        randomRed = Math.random();
        randomGreen = Math.random();
        randomBlue = Math.random();
    }

}
