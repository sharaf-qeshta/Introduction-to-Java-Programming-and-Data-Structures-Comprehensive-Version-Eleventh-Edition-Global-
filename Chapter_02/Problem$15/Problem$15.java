package chapter_two;

import java.util.*;

/**
 * 2.15 (Geometry: distance of two points) Write a program that prompts the user to enter
 * two points (x1, y1) and (x2, y2) and displays their distance. The formula for
 * computing the distance is √[(x2-x1)² + (y2-y1)²]
 * Note you can use Math.pow(a, 0.5) to compute √a. Here is a sample run:
 *          Enter x1 and y1: 1.5 -3.4
 *          Enter x2 and y2: 4 5
 *          The distance between the two points is 8.764131445842194
 *
 * @author Sharaf Qeshta
 * */

public class Problem$15
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter x1 and y1 : ");
        double xOne = scan.nextDouble();
        double yOne = scan.nextDouble();

        System.out.print("Enter x2 and y2 : ");
        double xTwo = scan.nextDouble();
        double yTwo = scan.nextDouble();

        double deltaX = Math.pow(xTwo - xOne, 2);
        double deltaY = Math.pow(yTwo - yOne, 2);

        double distance = Math.pow(deltaX + deltaY, 0.5);

        System.out.println("The distance between the two points is " + distance);
    }
}
