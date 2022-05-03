package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.8 (Sort three integers) Write a program that prompts the user to enter three integers
 * and display the integers in non-decreasing order.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter three integers : ");

        int number1 = scan.nextInt(),
                number2 = scan.nextInt(),
                number3 = scan.nextInt(),
                temp;

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
        System.out.println(number1 + " " + number2 + " " + number3);
    }
}
