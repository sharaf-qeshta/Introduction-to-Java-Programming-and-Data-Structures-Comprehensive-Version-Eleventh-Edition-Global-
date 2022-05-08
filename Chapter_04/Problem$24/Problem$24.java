package chapter_four;

import java.util.Locale;
import java.util.Scanner;

/**
 * *4.24 (Enter three countries) Write a program that prompts the user to enter three
 * countries and displays them in descending order. Here is a sample run:
 *
 *          Enter the first country: Germany
 *          Enter the second country: France
 *          Enter the third country: Switzerland
 *          The three countries in descending order are Switzerland
 *          Germany France
 *
 * @author Sharaf Qeshta
 * */

public class Problem$24
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


        System.out.print("Enter the first country: ");
        String country1 = scanner.nextLine();
        System.out.print("Enter the second country: ");
        String country2 = scanner.nextLine();
        System.out.print("Enter the third country: ");
        String country3 = scanner.nextLine();

        String temp;
        if ((country2.compareTo(country1) > 0) && (country2.compareTo(country3) > 0))
        {
            temp = country1;
            country1 = country2;
            country2 = temp;
        }
        else if ((country3.compareTo(country1) > 0) && (country3.compareTo(country2) > 0))
        {
            temp = country1;
            country1 = country3;
            country3 = temp;

        }

        if (country3.compareTo(country2) > 0)
        {
            temp = country2;
            country2 = country3;
            country3 = temp;
        }

        System.out.println("The three cities in alphabetical order are " +
                country1 + " " + country2 + " " + country3);
    }
}
