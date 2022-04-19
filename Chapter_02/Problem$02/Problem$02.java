package chapter_two;

import java.util.*;

/**
 * 2.2 (Compute the volume of a triangle) Write a program that reads in the length of
 * sides of an equilateral triangle and computes the area and volume using the
 * following formulas:
 *  area = (√3/4) * (length of sides)2
 *  volume = area * length
 *
 *  Here is a sample run:
 *      Enter length of the sides and height of the Equilateral
 *      triangle: 3.5
 *      The area is 3.89
 *      The volume of the Triangular prism is 19.48
 *
 * @author Sharaf Qeshta
 * */

public class Problem$02
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter length of the sides and height of the Equilateral triangle : ");
        double length = scan.nextDouble();
        double area = (Math.sqrt(3) / 4) * Math.pow(length , 2);
        double volume = area * length;
        System.out.println("the area : "+ area);
        System.out.println("The volume of the Triangular prism is "+ volume);
    }
}
