package chapter_thirty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * 30.19 (Summary information) Suppose the file test.txt contains floating-point numbers
 * separated by spaces. Write a program to obtain the sum, average, maximum, and
 * minimum of the numbers.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file path: ");

        List<Double> doubles = new ArrayList<>();

        Files.lines(Paths.get(scanner.next())).map(line -> line.split(" "))
                .forEach(e ->
                {
                    for (String x : e)
                        doubles.add(Double.parseDouble(x));
                });

        double[] array = new double[doubles.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = doubles.get(i);

        DoubleSummaryStatistics statistics = DoubleStream.of(array).summaryStatistics();

        System.out.println("sum : " + statistics.getSum());
        System.out.println("average : " + statistics.getAverage());
        System.out.println("maximum : " + statistics.getMax());
        System.out.println("minimum : " + statistics.getMin());
    }
}
