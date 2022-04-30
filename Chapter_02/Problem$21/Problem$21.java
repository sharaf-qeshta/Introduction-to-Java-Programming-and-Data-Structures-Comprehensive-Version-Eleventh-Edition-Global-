package chapter_two;


import java.util.Locale;
import java.util.Scanner;

/**
 * *2.21 (Financial application: calculate future investment value) Write a program that
 * reads in investment amount, annual interest rate, and number of years and displays
 * the future investment value using the following formula:
 * futureInvestmentValue =
 *          investmentAmount * (1 + monthlyInterestRate) ^ numberOfYears*12
 *  For example, if you enter amount 1000, annual interest rate 3.25%, and number
 * of years 1, the future investment value is 1032.98.
 * Here is a sample run:
 *          Enter investment amount: 1000.56
 *          Enter annual interest rate in percentage: 4.25
 *          Enter number of years: 1
 *          Future value is $1043.92
 *
 * @author Sharaf Qeshta
 * */

public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter investment amount: ");
        double investmentAmount = scan.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double monthlyInterestRate = scan.nextDouble() / 1200;

        System.out.print("Enter number of years: ");
        int years = scan.nextInt();

        double futureInvestmentValue =
                investmentAmount * Math.pow((1 + monthlyInterestRate)
                        ,years * 12);

        System.out.println("Future value is $" + futureInvestmentValue);
    }
}
