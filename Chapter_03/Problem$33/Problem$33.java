package chapter_three;

import java.util.Locale;
import java.util.Scanner;

/**
 * *3.33 (Financial: compare costs) Suppose you shop for rice in two different packages.
 * You would like to write a program to compare the cost. The program prompts the
 * user to enter the weight and price of each package and displays the one with the
 * better price. Here is a sample run:
 *
 *          Enter weight and price for package 1: 50 24.59
 *          Enter weight and price for package 2: 25 11.99
 *          Package 2 has a better price.
 *
 *          Enter weight and price for package 1: 50 25
 *          Enter weight and price for package 2: 25 12.5
 *          Two packages have the same price.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$33
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter weight and price for package 1: ");
        double weight1 = scanner.nextDouble();
        double price1 = scanner.nextDouble();

        System.out.print("Enter weight and price for package 2: ");
        double weight2 = scanner.nextDouble();
        double price2 = scanner.nextDouble();

        double firstRatio = weight1 / price1;
        double secondRatio = weight2 / price2;

        if (firstRatio > secondRatio)
            System.out.println("Package 1 has a better price.");
        else if (secondRatio > firstRatio)
            System.out.println("Package 2 has a better price.");
        else
            System.out.println("Two packages have the same price.");
    }
}

