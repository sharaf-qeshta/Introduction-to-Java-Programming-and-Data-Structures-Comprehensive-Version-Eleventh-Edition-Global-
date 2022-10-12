package chapter_thirty_one.samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Listing 31.5 TranslationDemo.java
 * */
public class TranslationDemo extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        double x = 10;
        double y = 10;
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 10; i++)
        {
            Rectangle rectangle = new Rectangle(10, 10, 50, 60);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.color(random.nextDouble(),
                    random.nextDouble(), random.nextDouble()));
            rectangle.setTranslateX(x += 20);
            rectangle.setTranslateY(y += 5);
            pane.getChildren().add(rectangle);
        }

        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("TranslationDemo"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window
    }
}