package chapter_twelve;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * *12.3 (InputMismatchException) The previous program works well as  long
 * as the user enters an integer. Otherwise, you may get another kind of
 * exception. For instance, if you use nextInt() of Scanner, you could have an
 * InputMismatchException. Modify it to prevent users entering anything
 * other than an integer.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        String[] months = {"January", "February", "March", "April",
                "May", "June","July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        try
        {
            System.out.print("enter month number: ");
            int monthNumber = scanner.nextInt();
            System.out.println(months[monthNumber-1] + ": " + dom[monthNumber-1]);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Invalid Month Number :(");
        }
        catch (InputMismatchException e)
        {
            System.out.println("insert only integers :)");
        }
    }
}
