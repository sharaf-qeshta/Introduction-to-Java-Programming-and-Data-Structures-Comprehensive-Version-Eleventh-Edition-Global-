package chapter_two;

import java.util.*;

/**
 * *2.5 (Financial application: calculate tips) Write a program that reads the subtotal
 * and the gratuity rate and then computes the gratuity and total. For example, if the
 * user enters 10 for subtotal and 12% for gratuity rate, the program displays $1.2
 * as gratuity and $11.2 as total. Here is a sample run:
 *          Enter the subtotal and a gratuity rate: 10 12
 *          The gratuity is $1.2 and total is $11.2
 *
 * @author Sharaf Qeshtta*/

public class Problem$05
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subtotal = scan.nextDouble();
        double gratuity = scan.nextDouble();

        double TotalGratuity = subtotal * (gratuity / 100);
        double Total = subtotal + TotalGratuity;
        System.out.println("The gratuity is $" + TotalGratuity + " and total is $" + Total );
    }
}
