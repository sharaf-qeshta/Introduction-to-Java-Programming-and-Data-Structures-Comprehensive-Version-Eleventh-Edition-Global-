package chapter_thirty;

import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * 30.6 (Average an array) Rewrite Programming Exercise 7.8 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter 10 double values: ");

        double[] numbers = new double[10];

        double average = DoubleStream.of(numbers).map(e -> e = scanner.nextDouble()).average().getAsDouble();
        System.out.println("Average is " + average);
    }
}
