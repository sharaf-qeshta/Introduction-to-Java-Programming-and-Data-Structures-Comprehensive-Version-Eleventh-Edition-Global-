package chapter_twelve;

import java.util.Locale;
import java.util.Scanner;

/**
 * *12.2 (ArrayIndexOutOfBoundsException) Using the two arrays shown below,
 * write a program that prompts the user to enter an integer between 1 and 12 and
 * then displays the months and its number of days corresponding to the integer
 * entered. Your program should display “wrong number” if the user enters a
 * wrong number by catching ArrayIndexOutOfBoundsException.
 *
 *          String[] months = {"January", "February", "March", "April",
 *                  "May", "June","July", "August", "September", "October",
 *                  "November", "December"};
 *          int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
    {
        String[] months = {"January", "February", "March", "April",
                "May", "June","July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter month number: ");
        int monthNumber = scanner.nextInt();

        try
        {
            System.out.println(months[monthNumber-1] + ": " + dom[monthNumber-1]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Input :(");
        }
    }
}
