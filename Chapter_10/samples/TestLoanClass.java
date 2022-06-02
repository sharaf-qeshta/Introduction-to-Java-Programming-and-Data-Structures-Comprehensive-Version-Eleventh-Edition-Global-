package chapter_ten.samples;

import java.util.Scanner;

/**
 * Listing 10.1 TestLoanClass.java
 * */
public class TestLoanClass
{
    /**
     * Main method
     */
    public static void main(String[] args)
    {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Enter annual interest rate
        System.out.print(
                "Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();

        // Enter number of years
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();

        // Enter loan amount
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();

        // Create a Loan object
        Loan loan =
                new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Display loan date, monthly payment, and total payment
        System.out.printf("The loan was created on %s\n" +
                        "The monthly payment is %.2f\nThe total payment is %.2f\n",
                loan.getLoanDate().toString(), loan.getMonthlyPayment(),
                loan.getTotalPayment());
    }
}
