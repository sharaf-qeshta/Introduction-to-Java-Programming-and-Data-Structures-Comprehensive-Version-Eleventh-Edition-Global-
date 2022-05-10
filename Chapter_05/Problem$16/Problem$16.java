package chapter_five;

import java.util.Locale;
import java.util.Scanner;

/**
 * *5.16 (Find the factors of an integer) Write a program that reads an integer and displays
 * all its smallest factors in an increasing order. For example, if the input integer is
 * 120, the output should be as follows: 2, 2, 2, 3, 5.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$16
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int index = 2;

        while (number != index)
        {
            if (number % index  == 0)
            {
                System.out.print(index + ", ");
                number /= index;
            }
            else
                index++;
        }
        System.out.println(number);
    }
}
