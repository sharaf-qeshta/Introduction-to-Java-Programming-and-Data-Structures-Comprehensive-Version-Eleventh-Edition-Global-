package chapter_four;


import java.util.Locale;
import java.util.Scanner;

/**
 * *4.23 (Financial application: payroll) Write a program that reads the following
 * information and prints a payroll statement:
 * Employee’s name (e.g., Smith)
 * Number of hours worked in a week (e.g., 10)
 * Hourly pay rate (e.g., 9.75)
 * Federal tax withholding rate (e.g., 20%)
 * State tax withholding rate (e.g., 9%)
 * A sample run is as follows:
 *
 *          Enter employee’s name: Smith
 *          Enter number of hours worked in a week: 10
 *          Enter hourly pay rate: 9.75
 *          Enter federal tax withholding rate: 0.20
 *          Enter state tax withholding rate: 0.09
 *
 *          Employee Name: Smith
 *          Hours Worked: 10.0
 *          Pay Rate: $9.75
 *          Gross Pay: $97.5
 *          Deductions:
 *              Federal Withholding (20.0%): $19.5
 *              State Withholding (9.0%): $8.77
 *              Total Deduction: $28.27
 *          Net Pay: $69.22
 *
 * @author Sharaf Qeshta
 * */

public class Problem$23
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter employee’s name: ");
        String name = scanner.next();

        System.out.print("Enter number of hours worked in a week: ");
        double hoursPerWeek = scanner.nextDouble();

        System.out.print("Enter hourly pay rate: ");
        double hourlyPayRate = scanner.nextDouble();

        System.out.print("Enter federal tax withholding rate: ");
        double federalTaxRate = scanner.nextDouble();

        System.out.print("Enter state tax withholding rate: ");
        double stateTaxRate = scanner.nextDouble();

        double wholeSalary = hourlyPayRate * hoursPerWeek;
        double totalDeduction = (wholeSalary * stateTaxRate) + (wholeSalary * federalTaxRate);


        // payroll statement
        System.out.println("\n");

        System.out.println("Employee Name: " + name);
        System.out.println("Hours Worked: " + hoursPerWeek);
        System.out.println("Pay Rate: $" + hourlyPayRate);
        System.out.println("Gross Pay: $" + wholeSalary);
        System.out.println("Deductions: ");
        System.out.println("\tFederal Withholding (" + (federalTaxRate * 100) + "%): "
                + "$" +  (wholeSalary * federalTaxRate));
        System.out.println("\tState Withholding (" + (stateTaxRate * 100) + "%):"
                +"$" +  (wholeSalary * stateTaxRate));
        System.out.println("\tTotal Deduction: $" + totalDeduction);
        System.out.println("Net Pay: " + (wholeSalary - totalDeduction));
    }
}
