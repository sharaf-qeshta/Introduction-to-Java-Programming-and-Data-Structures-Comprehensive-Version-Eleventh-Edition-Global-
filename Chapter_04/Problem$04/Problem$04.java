package chapter_four;

import java.util.Locale;
import java.util.Scanner;

/**
 * 4.4 (Geometry: area of a hexagon) The area of a hexagon can be computed using the
 * following formula (s is the length of a side):
 * Area = (6 * s²) / [4 * tan(π/6)]
 *  Write a program that prompts the user to enter the side of a hexagon and displays
 * its area. Here is a sample run:
 *
 *          Enter the side: 5.5
 *          The area of the hexagon is 78.59
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the side: ");
        double side = scanner.nextDouble();

        double area = (6 * Math.pow(side, 2)) / (4 * (Math.tan(Math.PI/6)));

        System.out.println("The area of the hexagon is " + area);
    }
}
