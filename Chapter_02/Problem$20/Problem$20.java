package chapter_two;


import java.util.Locale;
import java.util.Scanner;

/**
 * *2.20 (Financial application: calculate interest) If you know the balance and the annual
 * percentage interest rate, you can compute the interest on the next monthly
 * payment using the following formula:
 * interest = balance * (annualInterestRate/1200)
 * Write a program that reads the balance and the annual percentage interest rate and
 * displays the interest for the next month. Here is a sample run:
 *      Enter balance and interest rate (e.g., 3 for 3%): 1000 3.5
 *      The interest is 2.91667
 *
 * @author Sharaf Qeshta
 * */

public class Problem$20
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        // interest = balance * (annualInterestRate/1200)
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%):");
        double balance = scan.nextDouble();
        double annualInterestRate = scan.nextDouble();

        double interest = balance * (annualInterestRate / 1200);
        System.out.println("The interest is " + interest );
    }
}
