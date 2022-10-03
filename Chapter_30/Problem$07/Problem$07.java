package chapter_thirty;

import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * 30.7 (Find the smallest element) Rewrite Programming Exercise 7.9 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ten numbers: ");

        double[] array = new double[10];
        double max = DoubleStream.of(array).map(e -> e = scanner.nextDouble()).max().getAsDouble();
        System.out.println("The maximum number is " + max);
    }
}
