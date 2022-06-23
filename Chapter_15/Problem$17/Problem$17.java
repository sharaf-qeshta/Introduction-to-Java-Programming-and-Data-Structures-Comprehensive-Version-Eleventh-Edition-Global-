package chapter_fifteen;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * **15.17 (Geometry: find the bounding rectangle) Write a program that enables the user
 * to add and remove points in a two-dimensional plane dynamically, as shown
 * in Figure 15.31a. A minimum bounding rectangle is updated as the points are
 * added and removed. Assume the radius of each point is 10 pixels.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17 extends Application
{
    private static double maxX = 150;
    private static double maxY = 100;
    private static double minX = 80;
    private static double minY = 50;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(80, 50, 150, 100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        pane.getChildren().add(rectangle);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$17");
        primaryStage.setScene(scene);
        primaryStage.show();


        pane.setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY)
            {
                Circle circle = new Circle(e.getX(), e.getY(), 10);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                Point2D center = new Point2D(e.getX(), e.getY());
                pane.getChildren().add(circle);

                if (!rectangle.contains(center))
                    addCircle(rectangle, circle);
                circle.setOnMousePressed(e2 ->
                {
                    if (e2.getButton() == MouseButton.SECONDARY)
                        if (rectangle.contains(center))
                            removeCircle(pane, circle, rectangle);
                });
            }
        });
    }

    private void updateRectangle(Rectangle rectangle)
    {
        rectangle.setX(minX);
        rectangle.setY(minY);
        rectangle.setWidth(maxX-minX);
        rectangle.setHeight(maxY-minY);
    }

    private void addCircle(Rectangle rectangle, Circle circle)
    {
        if (circle.getCenterX()-10 < minX)
            minX = circle.getCenterX()-10;
        if (circle.getCenterY()-10 < minY)
            minY = circle.getCenterY()-10;
        if (circle.getCenterX()+10 > maxX)
            maxX = circle.getCenterX()+10;
        if (circle.getCenterY()+10 > maxY)
            maxY = circle.getCenterY()+10;
        updateRectangle(rectangle);

    }

    private void removeCircle(Pane pane, Circle circle, Rectangle rectangle)
    {
        pane.getChildren().remove(circle);

        maxX = getMaxX(pane);
        maxY = getMaxY(pane);
        minX = getMinX(pane);
        minY = getMinY(pane);

        updateRectangle(rectangle);
    }

    private double getMaxX(Pane pane)
    {
        double maxX_ = 0;
        for (int i = 0; i < pane.getChildren().size(); i++)
        {
            if (pane.getChildren().get(i) instanceof Circle)
            {
                Circle circle = (Circle) pane.getChildren().get(i);
                if (circle.getCenterX()+10 > maxX_)
                    maxX_ = circle.getCenterX()+10;
            }
        }
        return maxX_;
    }

    private double getMaxY(Pane pane)
    {
        double maxY_ = 0;
        for (int i = 0; i < pane.getChildren().size(); i++)
        {
            if (pane.getChildren().get(i) instanceof Circle)
            {
                Circle circle = (Circle) pane.getChildren().get(i);
                if (circle.getCenterY()+10 > maxY_)
                    maxY_ = circle.getCenterY()+10;
            }
        }
        return maxY_;
    }


    private double getMinX(Pane pane)
    {
        double minX_ = maxX;
        for (int i = 0; i < pane.getChildren().size(); i++)
        {
            if (pane.getChildren().get(i) instanceof Circle)
            {
                Circle circle = (Circle) pane.getChildren().get(i);
                if (circle.getCenterX()-10 < minX_)
                    minX_ = circle.getCenterX()-10;
            }
        }
        return minX_;
    }


    private double getMinY(Pane pane)
    {
        double minY_ = maxY;
        for (int i = 0; i < pane.getChildren().size(); i++)
        {
            if (pane.getChildren().get(i) instanceof Circle)
            {
                Circle circle = (Circle) pane.getChildren().get(i);
                if (circle.getCenterY()-10 < minY_)
                    minY_ = circle.getCenterY()-10;
            }
        }
        return minY_;
    }
}
