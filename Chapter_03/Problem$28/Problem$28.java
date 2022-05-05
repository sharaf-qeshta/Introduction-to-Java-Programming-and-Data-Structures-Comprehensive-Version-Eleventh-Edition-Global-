package chapter_three;

import java.util.Scanner;

/**
 * **3.28 (Geometry: two rectangles) Write a program that prompts the user to enter the
 * center x-, y-coordinates, width, and height of two rectangles and determines
 * whether the second rectangle is inside the first or overlaps with the first, as shown
 * in Figure 3.9. Test your program to cover all cases.
 * Here are the sample runs:
 *
 *          Enter r1’s center x-, y-coordinates, width, and height: 2.5 4 2.5 43
 *          Enter r2’s center x-, y-coordinates, width, and height: 1.5 5 0.5 3
 *          r2 is inside r1
 *
 *          Enter r1’s center x-, y-coordinates, width, and height: 1 2 3 5.5
 *          Enter r2’s center x-, y-coordinates, width, and height: 3 4 4.5 5
 *          r2 overlaps r1
 *
 *          Enter r1’s center x-, y-coordinates, width, and height: 1 2 3 3
 *          Enter r2’s center x-, y-coordinates, width, and height: 40 45 3 2
 *          r2 does not overlap r1
 *
 * @author Sharaf Qeshta
 * */

public class Problem$28
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter r1's center x-, y-coordinates, width and height: ");
        double r1x = input.nextDouble();
        double r1y = input.nextDouble();
        double r1Width = input.nextDouble();
        double r1Height = input.nextDouble();

        System.out.print("Enter r2's center x-, y-coordinates, width and height: ");
        double r2x = input.nextDouble();
        double r2y = input.nextDouble();
        double r2Width = input.nextDouble();
        double r2Height = input.nextDouble();

        // Determine whether the second rectangle is inside the first
        if
        (
                (Math.pow(Math.pow(r2y - r1y, 2), .05) + r2Height / 2 <= r1Height / 2) &&
                (Math.pow(Math.pow(r2x - r1x, 2), .05) + r2Width / 2 <= r1Width / 2) &&
                (r1Height / 2 + r2Height / 2 <= r1Height) &&
                (r1Width / 2 + r2Width / 2 <= r1Width)
        )
            System.out.println("r2 is inside r1");

        else if
        (
                (r1x + r1Width / 2 > r2x - r2Width) ||
                (r1y + r1Height / 2 > r2y - r2Height)
        )
            System.out.println("r2 overlaps r1");

        else
            System.out.println("r2 does not overlap r1");
    }
}

