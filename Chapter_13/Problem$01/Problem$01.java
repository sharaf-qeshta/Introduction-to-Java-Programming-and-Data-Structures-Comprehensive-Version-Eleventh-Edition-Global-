package chapter_thirteen;

import java.util.Locale;
import java.util.Scanner;

/**
 * **13.1 (Triangle class) Design a new Triangle class that extends the abstract
 * GeometricObject class. Draw the UML diagram for the classes Triangle and
 * GeometricObject then implement the Triangle class. Write a test program
 * that prompts the user to enter three sides of the triangle, a color, and a Boolean
 * value to indicate whether the triangle is filled. The program should create a Triangle
 * object with these sides, and set the color and filled properties using the
 * input. The program should display the area, perimeter, color, and true or false to
 * indicate whether it is filled or not.
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
