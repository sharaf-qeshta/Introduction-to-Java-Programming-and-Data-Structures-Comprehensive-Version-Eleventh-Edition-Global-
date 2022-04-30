package chapter_two;


import java.util.Locale;
import java.util.Scanner;

/**
 * *2.19 (Geometry: area of a triangle) Write a program that prompts the user to enter three
 * points, (x1, y1), (x2, y2), and (x3, y3), of a triangle then displays its area.
 * The formula for computing the area of a triangle is
 * s = (side1 + side2 + side3)/2;
 * area = √[s(s - side1)(s - side2)(s - side3)]
 * Here is a sample run:
 *      Enter the coordinates of three points separated by spaces
 *      like x1 y1 x2 y2 x3 y3: 1.5 -3.4 4.6 5 9.5 -3.4
 *      The area of the triangle is 33.6
 *
 * @author Sharaf Qeshta
 *  */

public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the coordinates of three points separated by spaces \n" +
                "like x1 y1 x2 y2 x3 y3:");
        double x1 = scan.nextDouble(),
                y1 = scan.nextDouble(),
                x2 = scan.nextDouble(),
                y2 = scan.nextDouble(),
                x3 = scan.nextDouble(),
                y3 = scan.nextDouble();

        // according to https://mathisfun.com the distance between
        // two points is
        // the square root of ((x2 - x1) ** 2) + ((y2 - y1) ** 2)

        // side 1
        double sideOne = Math.sqrt(Math.pow(x2 - x1, 2)
                + Math.pow(y2 - y1, 2));

        // side 2
        double sideTwo = Math.sqrt(Math.pow(x3 - x2, 2)
                + Math.pow(y3 - y2, 2));

        // side 3
        double sideThree = Math.sqrt(Math.pow(x1 - x3, 2)
                + Math.pow(y1 - y3, 2));

        double s = (sideOne + sideTwo + sideThree) / 2;

        double euclideanArea = Math.sqrt(s * (s - sideOne)
                * (s - sideTwo) * (s - sideThree));

        System.out.println("The area of the triangle is " + euclideanArea);
    }
}
