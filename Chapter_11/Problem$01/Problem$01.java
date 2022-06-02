package chapter_eleven;

import java.util.Locale;
import java.util.Scanner;

/**
 * 11.1 (The Triangle class) Design a class named Triangle that extends
 * GeometricObject. The class contains:
 * ■■ Three double data fields named side1, side2, and side3 with default
 * values 1.0 to denote three sides of a triangle.
 * ■■ A no-arg constructor that creates a default triangle.
 * ■■ A constructor that creates a triangle with the specified side1, side2, and
 * side3.
 * ■■ The accessor methods for all three data fields.
 * ■■ A method named getArea() that returns the area of this triangle.
 * ■■ A method named getPerimeter() that returns the perimeter of this triangle.
 * ■■ A method named toString() that returns a string description for the triangle.
 * For the formula to compute the area of a triangle, see Programming Exercise 2.19.
 * The toString() method is implemented as follows:
 * return "Triangle: side1 = " + side1 + " side2 = " + side2 +
 *  " side3 = " + side3;
 * Draw the UML diagrams for the classes Triangle and GeometricObject and
 * implement the classes. Write a test program that prompts the user to enter three
 * sides of the triangle, a color, and a Boolean value to indicate whether the triangle
 * is filled. The program should create a Triangle object with these sides and set
 * the color and filled properties using the input. The program should display
 * the area, perimeter, color, and true or false to indicate whether it is filled or not.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter 3 sides: ");
        double s1 = scanner.nextDouble();
        double s2 = scanner.nextDouble();
        double s3 = scanner.nextDouble();

        System.out.print("enter the color: ");
        String color = scanner.next();

        System.out.print("is the triangle filled: ");
        boolean isFilled = scanner.nextBoolean();

        Triangle triangle = new Triangle(s1, s2, s3);
        triangle.setColor(color);
        triangle.setFilled(isFilled);

        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getColor());
        System.out.println(triangle.isFilled());
    }
}
