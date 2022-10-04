package chapter_thirty;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


/**
 * 30.18 (Count the occurrences of words in a text file) Rewrite Programming Exercise
 * 21.8 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter File Name: ");

        Map<String, Integer> map = new TreeMap<>();
        Files.lines(new File(scanner.next()).toPath())
                .parallel()
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .forEach(word ->
                {
                    if (map.containsKey(word))
                        map.put(word, map.get(word)+1);
                    else
                        map.put(word, 1);
                });

        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
