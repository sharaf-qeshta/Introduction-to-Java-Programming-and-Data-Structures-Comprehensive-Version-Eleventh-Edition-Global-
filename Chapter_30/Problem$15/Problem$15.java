package chapter_thirty;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 30.15 (Display words in ascending alphabetical order) Rewrite Programming
 * Exercise 20.1 using streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    /**
     * sample run =>
     * Enter file path: src/chapter_thirty/words.txt
     * I I I Involve Show Tell and and and forget. me me me remember. understand.
     * */
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        File file = new File(scanner.next());

        Files.lines(file.toPath()).parallel().forEach(line ->
                Stream.of(line.split("[\\s++]")).sorted().forEach(e -> System.out.print(e + " ")));
    }
}
