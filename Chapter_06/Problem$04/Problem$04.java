package chapter_six;

import java.util.Locale;
import java.util.Scanner;

/**
 * *6.4 (Display an integer reversed) Write a method with the following header to display
 * an integer in reverse order:
 * public static void reverse(int number)
 * For example, reverse(3456) displays 6543. Write a test program that prompts
 * the user to enter an integer then displays its reversal.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter an Integer: ");
        int x = scanner.nextInt();

        System.out.println(reverse(x));
    }

    public static int reverse(int number)
    {
        String numberString = number + "";
        String reversed = "";
        for (int i = numberString.length()-1;
             i > -1; i--)
            reversed += numberString.charAt(i);
        return Integer.parseInt(reversed);
    }
}
