package chapter_fourteen;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * *14.18 (Plot the cube function) Write a program that draws a diagram for the function
 * f(x) = x3
 *  (see Figure 14.48b).
 * Hint: Add points to a polyline using the following code:
 *  Polyline polyline = new Polyline();
 *  ObservableList<Double> list = polyline.getPoints();
 *  double scaleFactor = 0.0125;
 *  for (int x = –100; x <= 100; x++) {
 *  list.add(x + 200.0);
 *  list.add(scaleFactor * x * x * x);
 *  }
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for (int x = -100; x <= 100; x++)
        {
            list.add(x + 250.0);
            list.add(scaleFactor * x * x * x + 250.0);
        }
        reflectAcrossYAxis(list);

        // cartesian plane lines
        // line 1 (horizontal)
        Line line1 = new Line();
        line1.setStartX(0);
        line1.startYProperty().bind(pane.heightProperty().divide(2));
        line1.endXProperty().bind(pane.widthProperty());
        line1.endYProperty().bind(pane.heightProperty().divide(2));


        // line 2 (vertical)
        Line line2 = new Line();
        line2.setStartY(0);
        line2.startXProperty().bind(pane.widthProperty().divide(2));
        line2.endYProperty().bind(pane.heightProperty());
        line2.endXProperty().bind(pane.widthProperty().divide(2));

        pane.getChildren().addAll(polyline, line1, line2);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void reflectAcrossYAxis(ObservableList<Double> list)
    {
        for (int i = 0; i < list.size(); i += 2)
            list.set(i, list.get(i) * -1 + 500);
    }
}
