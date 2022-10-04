package chapter_thirty;

import java.util.HashSet;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * 30.16 (Distinct scores) Use streams to write a program that displays the distinct scores
 * in the scores array in Section 8.8. Display the scores in increasing order,
 * separated by exactly one space, five numbers per line.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    public static int i = 1;

    /**
     * sample run =>
     * 12.5 17.5 18.5 19.9 22.5
     * 23.5 26.0 28.0 30.0 31.5
     * 32.5 34.5 35.0 37.0 37.5
     * 41.9 44.5 47.5 48.5 49.5
     * 51.9 61.9
     * */
    public static void main(String[] args)
    {
        double[][][] scores =
                {
                {{7.5, 20.5}, {9.0, 22.5}, {15, 33.5}, {13, 21.5}, {15, 2.5}},
                {{4.5, 21.5}, {9.0, 22.5}, {15, 34.5}, {12, 20.5}, {14, 9.5}},
                {{6.5, 30.5}, {9.4, 10.5}, {11, 33.5}, {11, 23.5}, {10, 2.5}},
                {{6.5, 23.5}, {9.4, 32.5}, {13, 34.5}, {11, 20.5}, {16, 7.5}},
                {{8.5, 26.5}, {9.4, 52.5}, {13, 36.5}, {13, 24.5}, {16, 2.5}},
                {{9.5, 20.5}, {9.4, 42.5}, {13, 31.5}, {12, 20.5}, {16, 6.5}}
                };

        HashSet<Double> set = new HashSet<>();
        Stream.of(scores).map(e -> Stream.of(e).mapToDouble(x -> DoubleStream.of(x).sum()))
                .forEach(output -> output.forEach(set::add));

        set.stream().sorted().forEach(e -> System.out.print(e + ((i++ % 5 == 0)? "\n" : " ")));
    }
}
