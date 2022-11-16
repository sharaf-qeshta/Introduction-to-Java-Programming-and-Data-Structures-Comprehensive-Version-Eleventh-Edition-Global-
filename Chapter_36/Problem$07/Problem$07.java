package chapter_thirty_six;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * 36.7 (Compute loan payments) Rewrite Listing 2.8, ComputeLoan.java, to display the
 * monthly payment and total payment in currency.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter annual interest rate, e.g., 7.25: ");
        double annualInterestRate = input.nextDouble();

        double monthlyInterestRate = annualInterestRate / 1200;

        System.out.print("Enter number of years as an integer, e.g., 5: ");
        int numberOfYears = input.nextInt();

        System.out.print("Enter loan amount, e.g., 120000.95: ");
        double loanAmount = input.nextDouble();

        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("The monthly payment is " + numberFormat.format
                ((int) (monthlyPayment * 100) / 100.0));
        System.out.println("The total payment is " + numberFormat.format
                ((int)(totalPayment * 100) / 100.0));
    }
}
