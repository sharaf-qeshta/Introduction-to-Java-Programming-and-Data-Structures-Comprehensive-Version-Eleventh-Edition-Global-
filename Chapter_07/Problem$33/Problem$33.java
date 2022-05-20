package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * *7.33 (Month name) Write a program that prompts the user to enter an integer between
 * 1 and 12 and then displays the name of the month that corresponds to the integer
 * entered by the user. For example, if the user enters three, the program should
 * display March.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$33
{
    public static final String[] MONTHS = {"January", "February", "March"
            , "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December"};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter month number: ");
        int index = scanner.nextInt();
        System.out.println(MONTHS[index-1]);
    }
}
