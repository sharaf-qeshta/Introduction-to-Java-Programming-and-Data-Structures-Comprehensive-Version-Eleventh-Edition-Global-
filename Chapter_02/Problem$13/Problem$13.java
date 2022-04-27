package chapter_two;

import java.util.*;

/**
 * **2.13 (Financial application: compound value) Suppose you save $100 each month in a
 * savings account with annual interest rate 3.75%. Thus, the monthly interest rate is
 * 0.0375/12 = 0.003125. After the first month, the value in the account becomes
 * 100 * (1 + 0.003125) = 100.3125
 *  After the second month, the value in the account becomes
 *  (100 + 100.3125) * (1 + 0.003125) = 200.938
 *  After the third month, the value in the account becomes
 *  (100 + 200.938) * (1 + 0.003125) = 301.878
 *  and so on.
 * Write a program that prompts the user to enter a monthly saving amount and
 * displays the account value after the sixth month. (In Exercise 5.30, you will use
 * a loop to simplify the code and display the account value for any month.)
 * sample run:
 *      Enter the monthly saving amount: 100
 *      After the first month, the account value is 100.3125
 *      After the second month, the account value is 200.9384765625
 *      After the third month, the account value is 301.8789093017578
 *      After the sixth month, the account value is 606.5967866995037
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter speed and acceleration: ");
        double savings = scan.nextDouble();
        double monthlyInterest = 0.003125;
        double first_month = savings * (1 + monthlyInterest);
        double second_month = (savings + first_month) * (1 + monthlyInterest);
        double third_month = (savings + second_month) * (1 + monthlyInterest);
        double fourth_month = (savings + third_month) * (1 + monthlyInterest);
        double fifth_month = (savings + fourth_month) * (1 + monthlyInterest);
        double sixth_month = (savings + fifth_month) * (1 + monthlyInterest);

        System.out.println("After the first month, the account value is " + first_month);
        System.out.println("After the second month, the account value is " + second_month);
        System.out.println("After the third month, the account value is " + third_month);
        System.out.println("After the sixth month, the account value is " + sixth_month);
    }
}
