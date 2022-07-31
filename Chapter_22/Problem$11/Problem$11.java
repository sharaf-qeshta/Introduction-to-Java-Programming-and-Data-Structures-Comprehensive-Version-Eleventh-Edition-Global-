package chapter_twenty_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * **22.11 (Geometry: Graham’s algorithm for finding a convex hull) Section 22.10.2
 * introduced Graham’s algorithm for finding a convex hull for a set of points.
 * Assume Java’s coordinate system is used for the points. Implement the algorithm using the following method:
 *  public static ArrayList<MyPoint> getConvexHull(double[][] s)
 *
 *  MyPoint is a static inner class defined as follows:
 *  private static class MyPoint implements Comparable<MyPoint> {
 *  double x, y;
 *  MyPoint rightMostLowestPoint;
 *  MyPoint(double x, double y) {
 *  this.x = x; this.y = y;
 *  }
 *  public void setRightMostLowestPoint(MyPoint p) {
 *  rightMostLowestPoint = p;
 *  }
 *  @Override
 *  public int compareTo(MyPoint o) {
 *  // Implement it to compare this point with point o
 *  // angularly along the x-axis with rightMostLowestPoint
 *  // as the center, as shown in Figure 22.10b. By implementing
 *  // the Comparable interface, you can use the Array.sort
 *  // method to sort the points to simplify coding.
 *  }
 *  }
 * Write a test program that prompts the user to enter the set size and the points,
 * and displays the points that form a convex hull. Here is a sample run:
 *
 *          How many points are in the set? 6
 *          Enter six points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
 *          The convex hull is
 *              (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many points are in the set? ");
        int pointsNumber = scanner.nextInt();

        double[][] points = new double[pointsNumber][2];
        System.out.print("Enter " + pointsNumber + " points: ");
        for (int i = 0; i < pointsNumber; i++)
        {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }
        System.out.println("The convex hull is");
        getConvexHull(points).forEach(e -> System.out.print(e + " "));
    }


    /** Return the points that form a convex hull */
    public static ArrayList<MyPoint> getConvexHull(double[][] s)
    {
        /*
        * Step 1: Given a list of points S, select the rightmost lowest point and
        * name it p0. As shown in Figure 22.10a, p0 is such a point.
        * */

        double[] p0 = getRightMostLowestPoint(s);

        /*
        * Step 2: Sort the points in S angularly along the x-axis with p0 as the
        * center, as shown in Figure 22.10b. If there is a tie and two points have
        * the same angle, discard the one that is closer to p0. The points in S are
        * now sorted as p0, p1, p2, . . . , pn−1.
        */

        // convert double[][] to ArrayList<MyPoint>
        ArrayList<MyPoint> points = new ArrayList<>();
        MyPoint rightMost = new MyPoint(p0[0], p0[1]);
        for (double[] point: s)
        {
            MyPoint myPoint = new MyPoint(point[0], point[1]);
            myPoint.setRightMostLowestPoint(rightMost);
            points.add(myPoint);
        }
        Collections.sort(points);

        /*
        * Step 3: Push p0, p1, and p2 into stack H. (After the algorithm finishes,
        * H contains all the points in the convex hull.)
        * */
        Stack<MyPoint> convexHull = new Stack<>();
        convexHull.push(points.get(0));
        convexHull.push(points.get(1));
        convexHull.push(points.get(2));


        /*
        * Step 4:
        * i = 3;
        * while (i < n) {
        * Let t1 and t2 be the top first and second element in stack H;
        * if (pi is on the left side of the direct line from t2 to t1) {
        * Push pi to H;
        * i++; // Consider the next point in S.
        * }
        * else
        * Pop the top element off stack H.
        *  }
        * */
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

        /*
        * Step 5: The points in H form a convex hull.
        * */
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

        @Override
        public String toString()
        {
            return "(" + x + ", " + y + ")";
        }
    }
}


