package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * *6.19 (Triangles) Implement the following two methods:
 *
 * public static boolean isValid(
 *  double side1, double side2, double side3)
 *
 *  public static double area(
 *  double side1, double side2, double side3)
 *
 *  Write a test program that reads three sides for a triangle and uses the isValid
 * method to test if the input is valid and uses the area method to obtain the area.
 * The program displays the area if the input is valid. Otherwise, it displays that
 * the input is invalid. The formula for computing the area of a triangle is given in
 * Programming Exercise 2.19.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter the three sides:  ");
        double side1 = scanner.nextDouble(),
               side2 = scanner.nextDouble(),
               side3 = scanner.nextDouble();

        if (isValid(side1, side2, side3))
            System.out.println(area(side1, side2, side3));
        else
            System.out.println("invalid measures");
    }

    public static boolean isValid(
            double side1, double side2, double side3)
    {
        return side1 + side2 > side3 & side2 + side3 > side1 & side1 + side3 > side2;
    }


    public static double area(
            double side1, double side2, double side3)
    {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1)
                * (s - side2) * (s - side3));
    }
}
