package chapter_twenty_eight;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * **28.23 (Connected rectangles) Listing 28.10, ConnectedCircles.java, allows the user
 * to create circles and determine whether they are connected. Rewrite the program
 * for rectangles. The program lets the user create a rectangle by clicking a
 * mouse in a blank area that is not currently covered by a rectangle. As the rectangles
 * are added, the rectangles are repainted as filled if they are connected or
 * are unfilled otherwise, as shown in Figure 28.25b–c
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$23 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(new RectanglePane(), 450, 350);
        primaryStage.setTitle("Problem$23");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Pane for displaying rectangles
     */
    static class RectanglePane extends Pane
    {
        public RectanglePane()
        {
            this.setOnMouseClicked(e ->
            {
                if (!isInsideARectangle(new Point2D(e.getX(), e.getY())))
                {
                    getChildren().add( new Rectangle(e.getX(), e.getY(), 50, 50));
                    colorIfConnected();
                }
            });
        }

        /**
         * Returns true if the point is inside an existing rectangle
         */
        private boolean isInsideARectangle(Point2D p)
        {
            for (Node rectangle : this.getChildren())
                if (rectangle.contains(p))
                    return true;

            return false;
        }

        /**
         * Color all rectangles if they are connected
         */
        private void colorIfConnected()
        {
            if (getChildren().size() == 0)
                return; // No rectangles in the pane

            // Build the edges
            java.util.List<Edge> edges
                    = new java.util.ArrayList<>();
            for (int i = 0; i < getChildren().size(); i++)
                for (int j = i + 1; j < getChildren().size(); j++)
                    if (overlaps((Rectangle) (getChildren().get(i)), (Rectangle) (getChildren().get(j))))
                    {
                        edges.add(new Edge(i, j));
                        edges.add(new Edge(j, i));
                    }

            // Create a graph with rectangles as vertices
            UnweightedGraph<Node> graph = new UnweightedGraph<>(getChildren(), edges);
            UnweightedGraph<Node>.SearchTree tree = graph.dfs(0);
            boolean isAllRectanglesConnected = getChildren().size() == tree
                    .getNumberOfVerticesFound();

            for (Node rectangle : getChildren())
            {
                if (isAllRectanglesConnected)
                {
                    // All rectangles are connected
                    ((Rectangle) rectangle).setFill(Color.RED);
                }
                else
                {
                    ((Rectangle) rectangle).setStroke(Color.BLACK);
                    ((Rectangle) rectangle).setFill(Color.WHITE);
                }
            }
        }
    }

    public static boolean overlaps(Rectangle rectangle1, Rectangle rectangle2)
    {
        return (50 >= Math.abs(rectangle1.getX() - rectangle2.getX()))
                && (50 >= Math.abs(rectangle1.getY() - rectangle2.getY()));
    }
}
