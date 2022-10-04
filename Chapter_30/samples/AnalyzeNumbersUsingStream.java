package chapter_thirty.samples;

import java.util.stream.*;

/**
 * Listing 30.7 AnalyzeNumbersUsingStream.java
 * */
public class AnalyzeNumbersUsingStream
{
    public static void main(String[] args)
    {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = input.nextInt();
        double[] numbers = new double[n];
        double sum = 0;
        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++)
        {
            numbers[i] = input.nextDouble();
        }

        double average = DoubleStream.of(numbers).average().getAsDouble();
        System.out.println("Average is " + average);
        System.out.println("Number of elements above the average is "
                + DoubleStream.of(numbers).filter(e -> e > average).count());
    }
}
