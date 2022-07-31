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
import java.util.Scanner;
import java.util.Stack;


/**
 * *22.13 (Geometry: convex hull animation) Programming Exercise 22.11 finds a convex
 * hull for a set of points entered from the console. Write a program that enables
 * the user to add or remove points by clicking the left or right mouse button and
 * displays a convex hull, as shown in Figure 22.8c.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13 extends Application
{
    private static final ArrayList<MyPoint> POINTS = new ArrayList<>();

    @Override
    public void start(Stage primaryStage)
    {
        // read points from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many points are in the set? ");
        int pointsNumber = scanner.nextInt();


        System.out.print("Enter " + pointsNumber + " points: ");
        for (int i = 0; i < pointsNumber; i++)
            POINTS.add(new MyPoint(scanner.nextDouble(), scanner.nextDouble()));


        Pane pane = new Pane();
        Polyline hull = new Polyline();
        pane.getChildren().add(hull);

        for (MyPoint point: POINTS)
            pane.getChildren().add(new MyCircle(point.x, point.y, 5));

        ArrayList<MyPoint> convexHull_ = getConvexHull();
        hull.getPoints().clear();
        for (MyPoint hullPoint: convexHull_)
        {
            hull.getPoints().add(hullPoint.x);
            hull.getPoints().add(hullPoint.y);
        }

        hull.getPoints().add(convexHull_.get(0).x);
        hull.getPoints().add(convexHull_.get(0).y);

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
                POINTS.remove(point);
                pane.getChildren().remove(circle);
            }
            ArrayList<MyPoint> convexHull = getConvexHull();
            hull.getPoints().clear();
            for (MyPoint hullPoint: convexHull)
            {
                hull.getPoints().add(hullPoint.x);
                hull.getPoints().add(hullPoint.y);
            }

            hull.getPoints().add(convexHull.get(0).x);
            hull.getPoints().add(convexHull.get(0).y);
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$13");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static ArrayList<MyPoint> getConvexHull()
    {
        double[][] s = new double[POINTS.size()][2];
        for (int i = 0; i < POINTS.size(); i++)
            s[i] = new double[] {POINTS.get(i).x, POINTS.get(i).y};

        double[] p0 = getRightMostLowestPoint(s);


        ArrayList<MyPoint> points = new ArrayList<>();
        MyPoint rightMost = new MyPoint(p0[0], p0[1]);
        for (double[] point: s)
        {
            MyPoint myPoint = new MyPoint(point[0], point[1]);
            myPoint.setRightMostLowestPoint(rightMost);
            points.add(myPoint);
        }
        Collections.sort(points);


        Stack<MyPoint> convexHull = new Stack<>();
        convexHull.push(points.get(0));
        convexHull.push(points.get(1));
        convexHull.push(points.get(2));


        int i = 3;
        while (i < points.size())
        {
            MyPoint t1 = convexHull.pop();
            MyPoint t2 = convexHull.get(convexHull.size()-1);
            convexHull.add(t1);
            MyPoint p =  points.get(i);
            if (isLeft(p, t1, t2))
            {
                convexHull.add(p);
                i++;
            }
            else
                convexHull.pop();
        }

        return new ArrayList<>(convexHull);
    }


    public static double[] getRightMostLowestPoint(double[][] p)
    {
        boolean sorted = false;
        double[][] s = p.clone();
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < s.length-1; i++)
            {
                if (s[i][1] > s[i+1][1])
                {
                    double[] temp = s[i].clone();
                    s[i] = s[i+1];
                    s[i+1] = temp;
                    sorted = false;
                }
                else if (s[i][1] == s[i+1][1])
                {
                    if (s[i][0] > s[i+1][0])
                    {
                        double[] temp = s[i].clone();
                        s[i] = s[i+1];
                        s[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        return s[s.length-1];
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
