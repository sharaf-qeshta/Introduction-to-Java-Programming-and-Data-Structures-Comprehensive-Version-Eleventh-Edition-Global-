package chapter_four;

import java.util.Locale;
import java.util.Scanner;

/**
 * 4.1 (Geometry: area of a pentagon) Write a program that prompts the user to enter
 * the length from the center of a pentagon to a vertex and computes the area of the
 * pentagon, as shown in the following figure.
 * The formula for computing the area of a pentagon is Area = (5 * s²) / [4 * tan(π/5)]
 * , where
 *  s is the length of a side. The side can be computed using the formula s = 2r sin(π/5)
 * ,
 * where r is the length from the center of a pentagon to a vertex. Round up two digits
 * after the decimal point. Here is a sample run:
 *
 *          Enter the length from the center to a vertex: 5.5
 *          The area of the pentagon is 71.92
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the length from the center to a vertex: ");
        double r = scanner.nextDouble();

        double s = 2 * r * Math.sin(Math.PI / 5);

        double A = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));

        A = Math.round(A);

        System.out.println("The area of the pentagon is " + A);
    }
}
