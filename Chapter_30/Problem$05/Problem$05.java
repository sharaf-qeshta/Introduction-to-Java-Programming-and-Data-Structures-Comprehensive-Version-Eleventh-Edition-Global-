package chapter_thirty;

import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 30.5 (Count single digits) Rewrite Programming Exercise 7.7 using streams.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$05
{
    public static void main(String[] args)
    {
        new Random().ints(200, 0, 10).mapToObj(e -> e)
                .collect(Collectors.groupingBy(e -> e,
                        TreeMap::new, Collectors.counting())).forEach((k, v) -> System.out.println(k + " count: " + v));
    }
}
