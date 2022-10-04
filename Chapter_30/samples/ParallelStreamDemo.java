package chapter_thirty.samples;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Listing 30.3 ParallelStreamDemo.java
 * */
public class ParallelStreamDemo
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int[] list = random.ints(200_000_000).toArray();

        System.out.println("Number of processors: " +
                Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list).filter(e -> e > 0).sorted()
                .limit(5).toArray();
        System.out.println(Arrays.toString(list1));
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential execution time is " +
                (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        int[] list2 = IntStream.of(list).parallel().filter(e -> e > 0)
                .sorted().limit(5).toArray();
        System.out.println(Arrays.toString(list2));
        endTime = System.currentTimeMillis();
        System.out.println("Parallel execution time is " +
                (endTime - startTime) + " milliseconds");
    }
}

