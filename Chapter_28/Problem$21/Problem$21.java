package chapter_twenty_eight;


import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.List;

/**
 * **28.21 (Display sets of connected circles) Modify Listing 28.10, ConnectedCircles.
 * java to display sets of connected circles in different colors. That is, if two
 * circles are connected, they are displayed using the same color; otherwise,
 * they are not in same color, as shown in Figure 28.25. (Hint: See Programming
 * Exercise 28.4.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(new CirclePane(), 450, 350);
        primaryStage.setTitle("Problem$21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Pane for displaying circles
     */
    static class CirclePane extends Pane
    {
        private static final Color[] COLORS = {Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.BLUE, Color.VIOLET};

        public CirclePane()
        {
            this.setOnMouseClicked(e ->
            {
                if (!isInsideACircle(new Point2D(e.getX(), e.getY())))
                {
                    Circle circle = new Circle(e.getX(), e.getY(), 20);
                    circle.setFill(Color.WHITE); circle.setStroke(Color.BLACK);
                    getChildren().add(circle);
                    colorIfConnected();
                }
            });
        }

        /**
         * Returns true if the point is inside an existing circle
         */
        private boolean isInsideACircle(Point2D p)
        {
            for (Node circle : this.getChildren())
                if (circle.contains(p))
                    return true;

            return false;
        }

        /**
         * Color all circles if they are connected
         */
        private void colorIfConnected()
        {
            if (getChildren().size() == 0)
                return; // No circles in the pane

            // Build the edges
            java.util.List<Edge> edges
                    = new java.util.ArrayList<>();
            for (int i = 0; i < getChildren().size(); i++)
                for (int j = i + 1; j < getChildren().size(); j++)
                    if (overlaps((Circle) (getChildren().get(i)),
                            (Circle) (getChildren().get(j))))
                    {
                        edges.add(new Edge(i, j));
                        edges.add(new Edge(j, i));
                    }

            // Create a graph with circles as vertices
            UnweightedGraph<Node> graph = new UnweightedGraph<>(getChildren(), edges);
            List<List<Integer>> connectedComponents = graph.getConnectedComponents();

            int j = 0;
            for (List<Integer> list: connectedComponents)
            {
                if (list.size() <= 1)
                    continue;
                if (j >= 6)
                    j = 0;

                Color color = COLORS[(j++)];
                for (int i : list)
                {
                    ((Circle) getChildren().get(i)).setFill(color);
                }
            }
        }
    }

    public static boolean overlaps(Circle circle1, Circle circle2)
    {
        return new Point2D(circle1.getCenterX(), circle1.getCenterY()).
                distance(circle2.getCenterX(), circle2.getCenterY())
                <= circle1.getRadius() + circle2.getRadius();
    }
}
