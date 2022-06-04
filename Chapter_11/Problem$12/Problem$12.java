package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * 11.12 (Sum ArrayList) Write the following method that returns the sum of all numbers in an ArrayList:
 * public static double sum(ArrayList<Double> list)
 * Write a test program that prompts the user to enter five numbers, stores them in
 * an array list, and displays their sum
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        ArrayList<Double> list = new ArrayList<>();

        System.out.print("enter five numbers: ");
        for (int i = 0; i < 5;i++)
            list.add(scanner.nextDouble());

        System.out.println(sum(list));
    }

    public static double sum(ArrayList<Double> list)
    {
        double total = 0;
        for (Double value : list) total += value;
        return total;
    }
}
