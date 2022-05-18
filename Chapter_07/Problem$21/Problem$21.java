package chapter_seven;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * *7.21 (Normalizing integers) Write a program that prompts the user to enter 10 integers,
 * and normalizes the integers to be in the range of 0 to 1 by dividing every integer
 * with the largest integer. Display the 10 normalized real-valued numbers
 *
 * @author Sharaf Qeshta
 * */


public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("enter 10 Integers: ");

        double[] values = new double[10];

        for (int i = 0; i < 10; i++)
        {
            double value = scanner.nextDouble();
            values[i] = value;
        }

        normalize(values);
        System.out.println(Arrays.toString(values));
    }


    public static void normalize(double[] list)
    {
        double max = max(list);
        for (int i = 0; i < list.length;i++)
            list[i] /= max;
    }


    public static double max(double[] list)
    {
        double max = list[0];
        for (int i = 1;i < list.length;i++)
            if (list[i] > max)
                max = list[i];
        return max;
    }



}
