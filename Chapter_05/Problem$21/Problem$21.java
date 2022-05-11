package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * **5.21 (Financial application: compare loans with various interest rates) Write a program
 * that lets the user enter the loan amount and loan period in number of years and
 * displays the monthly and total payments for each interest rate starting from 5% to
 * 10%, with an increment of 1/4. Here is a sample run:
 *
 *
 *          Loan Amount: 10000
 *          Number of Years: 5
 *
 *          Interest Rate       Monthly Payment         Total Payment
 *          5.000%              188.71                  11322.74
 *          5.250%              189.86                  11391.59
 *          5.500%              191.01                  11460.70
 *                                  ...
 *          9.750%              211.24                  12674.55
 *          10.000%             212.47                  12748.23
 *
 * For the formula to compute monthly payment, see Listing 2.9, ComputeLoan.java
 *
 *
 * @author Sharaf Qeshta
 * */

public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Loan Amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Number of Years: ");
        int years = scanner.nextInt();


        System.out.print("\nInterest Rate\t\tMonthly Payment\t\tTotal Payment\n");
        for (double i = 5.0;i < 10.250; i+= 0.250)
        {
            String interestRate = String.format("%.3f", i);

            double monthlyPayment =  amount * (i/1200) / (1 - 1 / Math.pow(1 + i/1200, years * 12));

            double totalCost = monthlyPayment * 12 * years;

            System.out.println(interestRate + "%\t\t\t\t\t" + String.format("%.2f", monthlyPayment)
                    + "\t\t\t\t" + String.format("%.2f", totalCost));
        }
    }
}
