package chapter_three;

import java.util.Scanner;

/**
 * **3.29 (Geometry: two circles) Write a program that prompts the user to enter the
 * center coordinates and radii of two circles and determines whether the second
 * circle is inside the first or overlaps with the first, as shown in Figure 3.10. (Hint:
 * circle2 is inside circle1 if the distance between the two centers 6 = r1 -
 * r2 and circle2 overlaps circle1 if the distance between the two centers 6 =
 * r1 + r2. Test your program to cover all cases.)
 * Here are the sample runs:
 *
 *          Enter circle1’s center x-, y-coordinates, and radius: 0.5 5.1 13
 *          Enter circle2’s center x-, y-coordinates, and radius: 1 1.7 4.5
 *          circle2 is inside circle1
 *
 *          Enter circle1’s center x-, y-coordinates, and radius: 3.4 5.7 5.5
 *          Enter circle2’s center x-, y-coordinates, and radius: 6.7 3.5 3
 *          circle2 overlaps circle1
 *
 *          Enter circle1’s center x-, y-coordinates, and radius: 3.4 5.5 1
 *          Enter circle2’s center x-, y-coordinates, and radius: 5.5 7.2 1
 *          circle2 does not overlap circle1
 *
 * @author Sharaf Qeshta
 * */

public class Problem$29
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();

        System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();

        double distancesSum = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);

        if ( distancesSum <= Math.abs(r1 - r2) )
            System.out.println("circle2 is inside circle1");

        else if ( distancesSum <= r1 + r2 )
            System.out.println("circle2 overlaps circle1");

        else
            System.out.println("circle2 does not overlap circle1");
    }
}

