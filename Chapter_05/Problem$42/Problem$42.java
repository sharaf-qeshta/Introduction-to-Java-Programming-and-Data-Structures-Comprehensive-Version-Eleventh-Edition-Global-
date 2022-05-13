package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.42 (Financial application: find the sales amount) Rewrite Programming Exercise 5.39
 * as follows:
 * ■■ Use a while loop instead of a do-while loop.
 * ■■ Let the user enter COMMISSION_SOUGHT instead of fixing it as a constant.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$42
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double commission = 0.0, balance, salesAmount;

        System.out.print("Enter the commission sought: ");
        double commissionSought = scanner.nextDouble();

        for (salesAmount = 0.01; commission < commissionSought;
             salesAmount += 0.01)
        {
            balance = commission = 0.0;

            if (salesAmount >= 10000.01)
                commission += (balance = salesAmount - 10000) * 0.12;

            if (salesAmount >= 5000.01)
                commission += (balance -= balance - 5000) * 0.10;

            if (salesAmount >= 0.01)
                commission += balance * 0.08;
        }

        System.out.printf(
                "Minimum sales to earn $%.0f: $%.0f\n", commissionSought, salesAmount);
    }
}

