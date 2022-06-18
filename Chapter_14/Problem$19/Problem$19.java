package chapter_fourteen;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **14.19 (Plot the sine and tangent functions) Write a program that plots the sine function
 * in red and tangent in blue, as shown in Figure 14.48c.
 * Hint: The Unicode for p is \u03c0. To display -2p, use Text(x, y, "–2\u03c0").
 * For a trigonometric function like sin(x), x is in radians. Use the following loop
 * to add the points to a polyline:
 *  Polyline polyline = new Polyline();
 *  ObservableList<Double> list = polyline.getPoints();
 *  double scaleFactor = 50;
 *  for (int x = −170; x <= 170; x++) {
 *  list.add(x + 200.0);
 *  list.add(100 – 50 * Math.sin((x / 100.0) * 2 * Math.PI));
 *  }
 *
 *
 * @author Sharaf Qeshta
 *  */
public class Problem$19 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();

        Polyline polyline1 = new Polyline();
        ObservableList<Double> list1 = polyline1.getPoints();
        double scaleFactor = 50;
        for (int x = -170; x <= 170; x++)
        {
            list1.add(x + 250.0);
            list1.add(100 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI) + 150.0);
        }

        Polyline polyline2 = new Polyline();
        ObservableList<Double> list2 = polyline2.getPoints();
        double scaleFactor2 = 50;
        for (int x = -170; x <= 170; x++)
        {
            list2.add(x + 250.0);
            list2.add(100 - scaleFactor2 * Math.cos((x / 100.0) * 2 * Math.PI) + 150.0);
        }

        polyline1.setStroke(Color.RED);
        polyline2.setStroke(Color.BLUE);

        Text zero = new Text(250, 250, "0");
        zero.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text minusPI = new Text(200, 250, "-\u03c0");
        minusPI.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text minus2PI = new Text(150, 250, "-2\u03c0");
        minus2PI.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text pi = new Text(300, 250, "\u03c0");
        pi.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));

        Text pi2 = new Text(350, 250, "2\u03c0");
        pi2.setFont(Font.font(Font.getFontNames().get(0), FontWeight.BOLD, 15));


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

        pane.getChildren().addAll(polyline1, polyline2, line1, line2, zero, minusPI, minus2PI, pi, pi2);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
