package chapter_fifteen;


import javafx.geometry.Point2D;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * **15.36 (Simulation: self-avoiding random walk) Write a simulation program to show
 * that the chance of getting dead-end paths increases as the grid size increases.
 * Your program simulates lattices with size from 10 to 80 with increments of 5.
 * For each lattice size, simulate a self-avoiding random walk 10,000 times
 * and display the probability of the dead-end paths, as shown in the following
 * sample output:
 *
 *          For a lattice of size 10, the probability of dead-end paths is 10.6%
 *          For a lattice of size 15, the probability of dead-end paths is 14.0%
 *          ...
 *          For a lattice of size 80, the probability of dead-end paths is 99.5%
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$36
{
    public static void main(String[] args)
    {
        DecimalFormat df = new DecimalFormat("0.0");
        for (int i = 10; i < 81; i += 5)
        {
            int deadEnds = 0;
            for (int j = 0; j < 10_000; j++)
                deadEnds += (getPathStatus(i) == 0) ? 1 : 0;
            String probability = df.format((deadEnds/10_000.0) * 100) + "%";
            System.out.println("For a lattice of size " + i +
                    ", the probability of dead-end paths is " + probability);
        }
    }
    public static int getPathStatus(int size)
    {
        ArrayList<Point2D> visited = new ArrayList<>();
        int width = size * 5, height = size * 5;
        int verticalStep = 5, horizontalStep = 5;

        Point2D currentPoint = new Point2D(250, 250); // fixed center

        while (!hitTheBorder(currentPoint, width, height))
        {
            visited.add(currentPoint);
            int move = (int) ((Math.random() * 10) % 2);
            int direction = (int) ((Math.random() * 10) % 2);
            int factor = (direction == 0)? 1 : -1;
            Point2D nextPoint;
            if (move == 0)
                nextPoint = new Point2D(currentPoint.getX(),
                        currentPoint.getY() + (verticalStep*factor));
            else
                nextPoint = new Point2D(currentPoint.getX() + (horizontalStep*factor),
                        currentPoint.getY());

            if (visited.contains(nextPoint))
            {
                int lags = 0;
                nextPoint = new Point2D(currentPoint.getX(),
                        currentPoint.getY() + (verticalStep*factor*-1));
                if (visited.contains(nextPoint))
                    lags++;

                nextPoint = new Point2D(currentPoint.getX()
                        + (horizontalStep*factor*-1), currentPoint.getY());
                if (visited.contains(nextPoint))
                    lags++;

                nextPoint = new Point2D(currentPoint.getX(),
                        currentPoint.getY() + (verticalStep*factor));
                if (visited.contains(nextPoint))
                    lags++;

                nextPoint = new Point2D(currentPoint.getX()
                        + (horizontalStep*factor), currentPoint.getY());
                if (visited.contains(nextPoint))
                    lags++;

                if (lags == 4)
                    return 0; // dead end
            }

            currentPoint = nextPoint;
        }
        return 1;
    }

    public static boolean hitTheBorder(Point2D point, int width, int height)
    {
        if (point.getX() >= width || point.getX() <= 0)
            return true;
        return point.getY() >= height || point.getY() <= 0;
    }
}
