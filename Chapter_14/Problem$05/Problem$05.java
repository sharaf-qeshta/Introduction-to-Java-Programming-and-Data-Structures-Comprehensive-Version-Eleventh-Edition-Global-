package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 14.5 (Characters around circle) Write a program that displays a string Learning
 * JavaFX around the circle, as shown in Figure 14.44b. Hint: You need to display
 * each character in the right location with appropriate rotation using a loop.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$05 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        pane.setPrefSize(600, 600);

        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 35);

        String welcome = "JavaFX Learning";
        double rotation = 210;
        double offset = pane.getPrefWidth() / 2;
        double radius = 100;
        double x;
        double y;
        double characterRotation = 300;

        for (int i = 0; i < welcome.length(); i++)
        {
            x = offset + Math.cos(Math.toRadians(rotation)) * radius;
            y = offset + Math.sin(Math.toRadians(rotation)) * radius;
            Text text = new Text(x, y, welcome.charAt(i) + "");

            text.setRotate(characterRotation);
            text.setFont(font);
            text.setStrokeWidth(10);
            pane.getChildren().add(text);
            rotation += 22.5;
            characterRotation += 22.5;
        }

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
