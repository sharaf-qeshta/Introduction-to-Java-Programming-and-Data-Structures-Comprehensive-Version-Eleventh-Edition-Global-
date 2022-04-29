package chapter_two;

import java.util.*;

/**
 * 2.16 (Geometry: area of a hexagon) Write a program that prompts the user to enter the
 * side of a hexagon and displays its area. The formula for computing the area of a
 * hexagon is
 * Area = (3√3/2) s²
 *  where s is the length of a side. Here is a sample run:
 *          Enter the length of the side: 5.5
 *          The area of the hexagon is 78.5918
 *
 * @author Sharaf Qeshta
 *  */

public class Problem$16
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the length of the side : ");
        double side = scan.nextDouble();

        double area = ((3 * Math.pow(3, 0.5)) / 2) * Math.pow(side, 2);
        System.out.println("The area of the hexagon is " + area);
    }
}
