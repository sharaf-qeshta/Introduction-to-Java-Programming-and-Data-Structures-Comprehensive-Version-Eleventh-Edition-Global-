package chapter_twenty_two;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * **22.9 (Geometry: gift-wrapping algorithm for finding a convex hull) Section 22.10.1
 * introduced the gift-wrapping algorithm for finding a convex hull for a set of
 * points. Assume Java’s coordinate system is used for the points. Implement the
 * algorithm using the following method:
 *          public static ArrayList<Point2D> getConvexHull(double[][] s)
 * Point2D is defined in Section 9.6.3.
 * Write a test program that prompts the user to enter the set size and the points,
 * and displays the points that form a convex hull. Here is a sample run:
 *
 *          How many points are in the set? 6
 *          Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
 *          The convex hull is
 *                  (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
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
        getConvexHull(points).forEach(e -> System.out.print("(" + e.getX() + ", " + e.getY() + ") "));
    }

    public static ArrayList<Point2D> getConvexHull(double[][] s)
    {
        /*
        * Step 1: Given a list of points S, let the points in S be labeled
        * s0, s1, . . . , sk. Select the rightmost lowest point S. As shown in
        * Figure 22.9a, h0 is such a point. Add h0 to list H. (H is initially
        * empty. H will hold all points in the convex hull after the algorithm is
        * finished.) Let t0 be h0.
        * */
        ArrayList<Point2D> convexHull = new ArrayList<>();
        double[] h0 = getRightMostLowestPoint(s);
        convexHull.add(new Point2D(h0[0], h0[1]));
        double[] t0 = h0;

        /*
         * Step 2: Let t1 be s0.
         * For every point p in S,
         *   if p is on the right side of the direct line from t0 to t1, then
         * let t1 be p.
         * (After Step 2, no points lie on the right side of the direct line from t0
         * to t1, as shown in Figure 22.9b.)
         *
         * */
        /*
         * Step 3: If t1 is h0 (see Figure 22.9d), the points in H form a convex
         * hull for S. Otherwise, add t1 to H, let t0 be t1, and go back to Step 2
         * (see Figure 22.9c).
         */
        while (true)
        {
            double[] t1 = s[0];
            for (double[] point : s)
                if (toTheRight(t1[0], t1[1], t0[0], t0[1], point[0], point[1]))
                    t1 = point;


            if (t1[0] != h0[0] || t1[1] != h0[1])
            {
                if (t1[0] == t0[0] && t1[1] == t0[1])
                    break;

                Point2D point = new Point2D(t1[0], t1[1]);
                convexHull.add(point);
                t0 = t1;
            }
            else
                break;
        }
        return convexHull;
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

    public static boolean toTheRight(double x0, double y0,
                                       double x1, double y1,
                                       double x2, double y2)
    {
        return (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0) < 0;
    }
}
