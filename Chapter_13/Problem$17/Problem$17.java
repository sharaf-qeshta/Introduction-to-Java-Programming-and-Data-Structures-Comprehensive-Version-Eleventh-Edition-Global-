package chapter_thirteen;

import java.util.Locale;
import java.util.Scanner;

/**
 * *13.17 (Math: The Complex class) A complex number is a number in the form a + bi,
 * where a and b are real numbers and i is 2-1. The numbers a and b are known
 * as the real part and imaginary part of the complex number, respectively. You can
 * perform addition, subtraction, multiplication, and division for complex numbers
 * using the following formulas:
 *   a + bi + c + di = (a + c) + (b + d)i
 *   a + bi - (c + di) = (a - c) + (b - d)i
 *  (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
 *  (a + bi)/(c + di) = (ac + bd)/(c² + d²) + (bc - ad)i/(c² + d²)
 *  You can also obtain the absolute value for a complex number using the following
 * formula:
 *
 *          | a + bi | = √(a² + b²)
 *
 * (A complex number can be interpreted as a point on a plane by identifying the
 * (a,b) values as the coordinates of the point. The absolute value of the complex
 * number corresponds to the distance of the point to the origin, as shown
 * in Figure 13.10.)
 * Design a class named Complex for representing complex numbers and the
 * methods add, subtract, multiply, divide, and abs for performing complex-number
 * operations, and override toString method for returning a string
 * representation for a complex number. The toString method returns (a + bi)
 * as a string. If b is 0, it simply returns a. Your Complex class should also implement
 * Cloneable and Comparable. Compare two complex numbers using their
 * absolute values.
 * Provide three constructors Complex(a, b), Complex(a), and Complex().
 * Complex() creates a Complex object for number 0, and Complex(a) creates a
 * Complex object with 0 for b. Also provide the getRealPart() and
 * getImaginaryPart() methods for returning the real part and the imaginary part
 * of the complex number, respectively.
 * Draw the UML class diagram and implement the class. Write a test program
 * that prompts the user to enter two complex numbers and displays the result of
 *
 * their addition, subtraction, multiplication, division, and absolute value. Here is
 * a sample run:
 *
 *              Enter the first complex number: 3.5 5.5
 *              Enter the second complex number: –3.5 1
 *              (3.5 + 5.5i) + (–3.5 + 1.0i) = 0.0 + 6.5i
 *              (3.5 + 5.5i) – (–3.5 + 1.0i) = 7.0 + 4.5i
 *              (3.5 + 5.5i) * (–3.5 + 1.0i) = –17.75 + –15.75i
 *              (3.5 + 5.5i) / (–3.5 + 1.0i) = –0.5094 + –1.7i
 *              |(3.5 + 5.5i)| = 6.519202405202649
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the first complex number: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        Complex c2 = new Complex(a, b);

        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));

        System.out.println("| " + c1 + " | = " + c1.abs());
    }
}


