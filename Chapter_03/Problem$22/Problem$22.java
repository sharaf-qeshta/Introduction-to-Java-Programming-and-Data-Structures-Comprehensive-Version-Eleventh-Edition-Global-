package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * **3.22 (Geometry: point in a circle?) Write a program that prompts the user to enter a
 * point (x, y) and checks whether the point is within the circle centered at (0, 0) with
 * radius 10. For example, (4, 5) is inside the circle and (9, 9) is outside the circle, as
 * shown in Figure 3.7a.
 * (Hint: A point is in the circle if its distance to (0, 0) is less than or equal to 10.
 * The formula for computing the distance is. Test your
 * program to cover all cases.) Two sample runs are shown below:
 *
 *      Enter a point with two coordinates: 4 5
 *      Point (4.0, 5.0) is in the circle
 *
 *      Enter a point with two coordinates: 9 9
 *      Point (9.0, 9.0) is not in the circle
 *
 * @author Sharaf Qeshta
 * */

public class Problem$22
{
    private static final int RADIUS = 10;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a point with two coordinates: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        double distanceFromOrigin = Math.sqrt(x*x + y*y);

        if (distanceFromOrigin <= RADIUS)
            System.out.println("Point (" + x + ", " + y + ") is in the circle.");
        else
            System.out.println("Point (" + x + ", " + y + ") is not in the circle.");
    }
}
