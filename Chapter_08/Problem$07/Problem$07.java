package chapter_eight;

import java.util.Arrays;

/**
 * *8.7 (Points nearest to each other) Listing 8.3 gives a program that finds two points in
 * a two-dimensional space nearest to each other. Revise the program so it finds two
 * points in a three-dimensional space nearest to each other. Use a two-dimensional
 * array to represent the points. Test the program using the following points:
 * double[][] points = {{−1, 0, 3}, {−1, −1, −1}, {4, 1, 1},
 *  {2, 0.5, 9}, {3.5, 2, −1}, {3, 1.5, 3}, {−1.5, 4, 2},
 *  {5.5, 4, −0.5}};
 *
 *  The formula for computing the distance between two points (x1, y1, z1) and
 *  (x2, y2, z2) is √[(△x)² + (△y)² + (△z)²]
 *
 * @author Sharaf Qeshta
 * */

public class Problem$07
{
    public static void main(String[] args)
    {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
                {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
                {5.5, 4, -0.5}};

        /*
        * [4.0, 1.0, 1.0, 3.5, 2.0, -1.0, 2.29128784747792]
        * p1 = (4.0, 1.0, 1.0);
        * p2 = (3.5, 2.0, -1.0);
        * distance between p1 and p2 (the shortest) = 2.29128784747792
        * */
        System.out.println(Arrays.toString(findNearest(points)));
    }

    public static double[] findNearest(double[][] points)
    {
        double[] nearest = new double[7];
        nearest[0] = points[0][0]; nearest[1] = points[0][1];
        nearest[2] = points[0][2]; nearest[3] = points[1][0];
        nearest[4] = points[1][1]; nearest[5] = points[1][2];
        nearest[6] = getDistance(points[0][0], points[0][1], points[0][2]
                , points[1][0], points[1][1], points[1][2]);

        for (int i = 0; i < points.length;i++){
            double x1 = points[i][0]; double y1 = points[i][1];
            double z1 = points[i][2];
            for (int j = i + 1; j < points.length;j++)
            {
                double x2 = points[j][0]; double y2 = points[j][1];
                double z2 = points[j][2];
                double distance = getDistance(x1, y1, z1, x2, y2, z2);

                if (distance < nearest[6]) // since we store the distance in nearest[6]
                {
                    nearest[0] = x1; nearest[1] = y1;
                    nearest[2] = z1; nearest[3] = x2;
                    nearest[4] = y2; nearest[5] = z2;
                    nearest[6] = distance;
                }
            }
        }
        return nearest;
    }


    public static double getDistance(double... data)
    {
        return Math.sqrt(
                Math.pow(data[3] - data[0], 2)
                + Math.pow(data[4] - data[1], 2)
                + Math.pow(data[5] - data[2], 2));
    }
}
