package chapter_thirty_one;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *31.14 (Scale and rotate graphics) Write a program that enables the user to scale and rotate
 * the STOP sign, as shown in Figure 31.53. The user can press the UP/DOWN arrow
 * key to increase/decrease the size and press the RIGHT/LEFT arrow key to rotate
 * left or right
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14 extends Application
{
    @Override
    public void start(Stage stage)
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
        stage.setTitle("Problem$14");
        stage.setScene(scene);
        stage.show();

        stackPane.requestFocus();

        stackPane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.UP)
            {
                polygon.setScaleX(polygon.getScaleX() + 1);
                polygon.setScaleY(polygon.getScaleY() + 1);
                text.setScaleX(text.getScaleX() + 1);
                text.setScaleY(text.getScaleY() + 1);
            }
            else if (e.getCode() == KeyCode.DOWN)
            {
                polygon.setScaleX(polygon.getScaleX() - 1);
                polygon.setScaleY(polygon.getScaleY() - 1);
                text.setScaleX(text.getScaleX() - 1);
                text.setScaleY(text.getScaleY() - 1);
            }
            else if (e.getCode() == KeyCode.LEFT)
            {
                // go anticlockwise
                polygon.setRotate(polygon.getRotate() - 1);
                text.setRotate(text.getRotate() - 1);
            }
            else if (e.getCode() == KeyCode.RIGHT)
            {
                // go clockwise
                polygon.setRotate(polygon.getRotate() + 1);
                text.setRotate(text.getRotate() + 1);
            }
        });
    }
}
