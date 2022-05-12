package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.31 (Financial application: compute CD value) Suppose you put $10,000 into a CD
 * with an annual percentage yield of 6.15%. After one month, the CD is worth
 * 10000 + 10000 * 6.15 / 1200 = 10051.25
 *  After two months, the CD is worth
 * 10051.25 + 10051.25 * 6.15 / 1200 = 10102.76
 *  After three months, the CD is worth
 * 10102.76 + 10102.76 * 6.15 / 1200 = 10154.53
 *  and so on.
 * Write a program that prompts the user to enter an amount (e.g., 10000), the annual
 * percentage yield (e.g., 6.15), and the number of months (e.g., 18) and displays a
 * table as shown in the sample run
 *
 *              Enter the initial deposit amount: 10000
 *              Enter annual percentage yield: 6.15
 *              Enter maturity period (number of months): 18
 *
 *              Month   CD Value
 *              1       10051.25
 *              2       10102.76
 *                  ...
 *              17      10907.90
 *              18      10963.81
 *
 * @author Sharaf Qeshta
 * */

public class Problem$31
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the initial deposit amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter annual percentage yield: ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter maturity period (number of months):");
        int months = scanner.nextInt();

        double total = amount;
        System.out.println("month \t CD value");
        for (int i = 0; i < months; i++)
        {
            total = total + total * annualInterestRate / 1200;

            String formattedAmount = String.format("%.2f", total);
            System.out.println((i+1)+ " \t\t " + formattedAmount );
        }
    }
}

