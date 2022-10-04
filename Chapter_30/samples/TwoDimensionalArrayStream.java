package chapter_thirty.samples;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Listing 30.10 TwoDimensionalArrayStream.java
 * */
public class TwoDimensionalArrayStream
{
    private static int i = 0;

    public static void main(String[] args)
    {
        int[][] m = {{1, 2}, {3, 4}, {4, 5}, {1, 3}};

        int[] list = Stream.of(m).map(e -> IntStream.of(e)).
                reduce((e1, e2) -> IntStream.concat(e1, e2)).get().toArray();

        IntSummaryStatistics stats =
                IntStream.of(list).summaryStatistics();
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());

        System.out.println("Sum of row ");
        Stream.of(m).mapToInt(e -> IntStream.of(e).sum())
                .forEach(e ->
                        System.out.println("Sum of row " + i++ + ": " + e));
    }
}

