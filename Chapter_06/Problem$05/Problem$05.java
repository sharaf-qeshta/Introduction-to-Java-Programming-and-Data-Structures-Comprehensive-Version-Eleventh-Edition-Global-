package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * *6.5 (Sort three numbers) Write a method with the following header to display three
 * numbers in decreasing order:
 * public static void displaySortedNumbers(
 *  double num1, double num2, double num3)
 * Write a test program that prompts the user to enter three numbers and invokes the
 * method to display them in decreasing order.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter Three Integers: ");
        double num1 = scanner.nextDouble(), num2 = scanner.nextDouble()
                , num3 = scanner.nextDouble();

        displaySortedNumbers(num1, num2, num3);
    }

    public static void displaySortedNumbers(
            double number1, double number2, double number3)
    {
        double temp;
        if (number2 < number1 || number3 < number1)
        {
            if (number2 < number1)
            {
                temp = number1;
                number1 = number2;
                number2 = temp;
            }
            if (number3 < number1)
            {
                temp = number1;
                number1 = number3;
                number3 = temp;
            }
        }
        if (number3 < number2)
        {
            temp = number2;
            number2 = number3;
            number3 = temp;
        }

        System.out.println(number1 +", " + number2 + ", " + number3);
    }

}
