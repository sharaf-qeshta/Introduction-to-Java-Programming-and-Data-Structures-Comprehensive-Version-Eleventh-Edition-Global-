package chapter_four;

import java.util.Locale;
import java.util.Scanner;

/**
 * *4.7 (Corner point coordinates) Suppose a pentagon is centered at (0, 0) with one point
 * at the 0 o’clock position, as shown in Figure 4.4c. Write a program that prompts
 * the user to enter the radius of the bounding circle of a pentagon and displays the
 * coordinates of the five corner points on the pentagon from p1 to p5 in this order.
 * Use console format to display two digits after the decimal point. Here is a sample
 * run:
 *
 *          Enter the radius of the bounding circle: 100.52
 *          The coordinates of five points on the pentagon are
 *          (95.60, 31.06)
 *          (0.00, 100.52)
 *          (−95.60, 31.06)
 *          (−58.08, −81.32)
 *          (59.08, −81.32)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$07
{
    public static void main(String[] args)
    {
        // 5 points form the pentagon
        // so divide 360/5 will give you 72 degree
        // point 1 at 72 degrees
        // point 2 at 144 degrees
        // point 3 at 216 degrees
        // point 4 at 288 degrees
        // point 5 at 360 or 0 degrees
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the radius of the bounding circle: ");
        double radius = scanner.nextDouble();

        // points of the pentagon
        double x1 = radius * Math.sin(Math.PI * 2 / 5.0);
        double y1 = radius * Math.cos(Math.PI * 2 / 5.0);

        double x2 = 0; // since cos(90) = 1
        double x3 = x1 * -1;

        double x4 = radius * Math.sin(Math.PI * 4 / 5.0) * -1;
        double y4 = radius * Math.cos(Math.PI / 5.0) * -1;

        double x5 = x4 * -1;

        String output = "The coordinates of five points on the pentagon are\n"
                + "("  + String.format("%.2f", x1) + ", " + String.format("%.2f", y1) + ")\n"
                + "("  + String.format("%.2f", x2) + ", " + String.format("%.2f", radius) + ")\n"
                + "("  + String.format("%.2f", x3) + ", " + String.format("%.2f", y1) + ")\n"
                + "("  + String.format("%.2f", x4) + ", " + String.format("%.2f", y4) + ")\n"
                + "("  + String.format("%.2f", x5) + ", " + String.format("%.2f", y4) + ")\n";

        System.out.println(output);
    }
}
