package chapter_nine;

import java.util.Locale;
import java.util.Scanner;

/**
 * *9.11 (Algebra: 2 * 2 linear equations) Design a class named LinearEquation for a
 * 2 * 2 system of linear equations:
 *
 *          ax + by = e    x = (ed - bf) / (ad - bc)
 *          cx + dy = f    y = (af - ec) / (ad - bc)
 * The class contains:
 * ■ Private data fields a, b, c, d, e, and f.
 * ■■ A constructor with the arguments for a, b, c, d, e, and f.
 * ■■ Six getter methods for a, b, c, d, e, and f.
 * ■■ A method named isSolvable() that returns true if ad - bc is not 0.
 * ■■ Methods getX() and getY() that return the solution for the equation.
 * Draw the UML diagram for the class then implement the class. Write a test program
 * that prompts the user to enter a, b, c, d, e, and f and displays the result. If
 * ad - bc is 0, report that “The equation has no solution.” See Programming Exercise 3.3 for sample runs.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter a, b, c, d, e, f: ");
        double[] values = new double[6];
        for (int i = 0; i < 6; i++)
            values[i] = scanner.nextDouble();

        LinearEquation linearEquation = new LinearEquation(values[0], values[1], values[2],
                values[3], values[4], values[5]);

        if (!linearEquation.isSolvable())
            System.out.println("The equation has no solution.");
        else
            System.out.println("x: " + linearEquation.getX() + ", y:" + linearEquation.getY());
    }
}
