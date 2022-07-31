package chapter_twenty_two;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * **22.15 (Geometry: noncrossed polygon) Write a program that enables the user to add
 * or remove points by clicking the left or right mouse button and displays a noncrossed
 * polygon that links all the points, as shown in Figure 22.11a. A polygon
 * is crossed if two or more sides intersect, as shown in Figure 22.11b. Use the
 * following algorithm to construct a polygon from a set of points:
 *
 * Step 1: Given a set of points S, select the rightmost lowest
 * point p0 in the set S.
 * Step 2: Sort the points in S angularly along the x-axis
 * with p0 as the center. If there is a tie and two points have
 * the same angle, the one that is closer to p0 is considered
 * greater. The points in S are now sorted as p0, p1, p2, ...,
 * pn−1.
 * Step 3: The sorted points form a noncrossed polygon.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15 extends Application
{
    private static final ArrayList<MyPoint> POINTS = new ArrayList<>();

    @Override
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        Polyline nonCrossedPolygon = new Polyline();
        pane.getChildren().add(nonCrossedPolygon);

        pane.setOnMousePressed(e ->
        {
            MyPoint point = new MyPoint(e.getX(), e.getY());
            MyCircle circle = new MyCircle(e.getX(), e.getY(), 5);

            if (e.getButton() == MouseButton.PRIMARY)
            {
                POINTS.add(point);
                pane.getChildren().add(circle);
            }
            else
            {
                // delete circle
                int i;
                for (i = 0; i < pane.getChildren().size(); i++)
                {
                    if (pane.getChildren().get(i) instanceof MyCircle)
                    {
                         if (pane.getChildren().get(i).contains(e.getX(), e.getY()))
                         {
                             pane.getChildren().remove(pane.getChildren().get(i));
                             break;
                         }
                    }
                }
                POINTS.remove(i-1);
            }

            ArrayList<MyPoint> points = getNonCrossedPolygon();
            nonCrossedPolygon.getPoints().clear();
            for (MyPoint polygonPoint: points)
            {
                nonCrossedPolygon.getPoints().add(polygonPoint.x);
                nonCrossedPolygon.getPoints().add(polygonPoint.y);
            }

            nonCrossedPolygon.getPoints().add(points.get(0).x);
            nonCrossedPolygon.getPoints().add(points.get(0).y);
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$15");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }


    public static ArrayList<MyPoint> getNonCrossedPolygon()
    {
        /*
        * Step 1: Given a set of points S, select the rightmost lowest
        * point p0 in the set S.
        * */
        MyPoint rightMost = getRightMostLowestPoint(POINTS);

        /*
        * Step 2: Sort the points in S angularly along the x-axis
        * with p0 as the center. If there is a tie and two points have
        * the same angle, the one that is closer to p0 is considered
        * greater. The points in S are now sorted as p0, p1, p2, ...,
        * pn−1.
        * */
        ArrayList<MyPoint> nonCrossedPolygon = (ArrayList<MyPoint>) POINTS.clone();
        for (MyPoint point: nonCrossedPolygon)
            point.setRightMostLowestPoint(rightMost);
        Collections.sort(nonCrossedPolygon);

        /*
        * Step 3: The sorted points form a noncrossed polygon.
        * */
        return nonCrossedPolygon;
    }

    public static MyPoint getRightMostLowestPoint(ArrayList<MyPoint> points)
    {
        boolean sorted = false;
        ArrayList<MyPoint> s = (ArrayList<MyPoint>) points.clone();
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < s.size()-1; i++)
            {
                if (s.get(i).y > s.get(i+1).y)
                {
                    MyPoint temp = s.get(i);
                    s.set(i, s.get(i+1));
                    s.set(i+1, temp);
                    sorted = false;
                }
                else if (s.get(i).y == s.get(i+1).y)
                {
                    if (s.get(i).x > s.get(i+1).x)
                    {
                        MyPoint temp = s.get(i);
                        s.set(i, s.get(i+1));
                        s.set(i+1, temp);
                        sorted = false;
                    }
                }
            }
        }
        return s.get(s.size()-1);
    }


    public static double getAngle(MyPoint p1, MyPoint p2, MyPoint p3)
    {
        double a = getSide(p2, p3);
        double b = getSide(p1, p3);
        double c = getSide(p1, p2);
        return Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
    }

    public static boolean isLeft(MyPoint p0, MyPoint p1, MyPoint p2)
    {
        double position = (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
        return position > 0;
    }

    public static double getSide(MyPoint p1, MyPoint p2)
    {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    private static class MyPoint implements Comparable<MyPoint>
    {
        double x, y;
        MyPoint rightMostLowestPoint;
        MyPoint(double x, double y)
        {
            this.x = x; this.y = y;
        }

        public void setRightMostLowestPoint(MyPoint p)
        {
            rightMostLowestPoint = p;
        }

        @Override
        public int compareTo(MyPoint o)
        {
            MyPoint virtualPoint = new MyPoint(rightMostLowestPoint.x + 1, rightMostLowestPoint.y);
            double a1 = getAngle(rightMostLowestPoint, virtualPoint, o);
            double a2 = getAngle(rightMostLowestPoint, virtualPoint, this);

            if(a1 > a2)
                return -1;
            else if(a2 > a1)
                return 1;
            else
            {
                double l1 = getSide(rightMostLowestPoint, o);
                double l2 = getSide(rightMostLowestPoint, this);
                return Double.compare(l2, l1);
            }
        }
    }


    private static class MyCircle extends Circle
    {
        public MyCircle(double x, double y, double radius)
        {
            super(x, y, radius);
            setFill(Color.BLACK);
        }
    }
}
