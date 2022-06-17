package chapter_fourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * *14.16 (Display a 4 * 4 grid) Write a program that displays a 4 * 4 grid, as shown in
 * Figure 14.47c. Use red color for vertical lines and blue for horizontals. The lines
 * are automatically resized when the window is resized.
 *
 * @author Sharaf Qeshta
 */
public class Problem$16 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        // line 1
        Line line1 = new Line();
        line1.setStartX(0);
        line1.startYProperty().bind(pane.heightProperty().divide(3));
        line1.setStroke(Color.BLUE);
        line1.endXProperty().bind(pane.widthProperty());
        line1.endYProperty().bind(pane.heightProperty().divide(3));


        // line 2
        Line line2 = new Line();
        line2.setStartX(0);
        line2.startYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        line2.setStroke(Color.BLUE);
        line2.endXProperty().bind(pane.widthProperty());
        line2.endYProperty().bind(pane.heightProperty().divide(3).multiply(2));


        // line 3
        Line line3 = new Line();
        line3.setStartY(0);
        line3.startXProperty().bind(pane.widthProperty().divide(3));
        line3.setStroke(Color.RED);
        line3.endYProperty().bind(pane.heightProperty());
        line3.endXProperty().bind(pane.widthProperty().divide(3));


        // line 4
        Line line4 = new Line();
        line4.setStartY(0);
        line4.startXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        line4.setStroke(Color.RED);
        line4.endYProperty().bind(pane.heightProperty());
        line4.endXProperty().bind(pane.widthProperty().divide(3).multiply(2));

        pane.getChildren().addAll(line1, line2, line3, line4);


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
