package chapter_four;

import java.util.Locale;
import java.util.Scanner;

/**
 * *4.26 (Financial application: monetary units) Rewrite Listing 2.10, ComputeChange.java,
 * to fix the possible loss of accuracy when converting a float value to an int value.
 * Read the input as a string such as "11.56". Your program should extract the dollar
 * amount before the decimal point, and the cents after the decimal amount using the
 * indexOf and substring methods.
 *
 * @author Sharaf Qeshta*/

public class Problem$26
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("enter an amount: ");
        String amount = scanner.next();

        int decimalPointIndex = amount.indexOf(".");

        int dollar = Integer.parseInt(amount.substring(0, decimalPointIndex));
        int cents = Integer.parseInt(amount.substring(decimalPointIndex+1));

        System.out.println("the dollars: $" + dollar);
        System.out.println("the cents: ¢" + cents);
    }
}
