package chapter_thirty;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 30.17 (Count consonants and vowels) Rewrite Programming Exercise 21.4 using
 * streams.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    public static final HashSet<Character> VOWELS = new HashSet<>
            (Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
    public static int vowelsCount = 0;
    public static int consonantsCount = 0;

    /**
     * sample run =>
     * Enter File Name: src/chapter_thirty/words.txt
     * There are 12 vowels
     * There are 17 consonants
     * */
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter File Name: ");


        Files.lines(new File(scanner.next()).toPath()).parallel()
                .forEach(line -> line.chars().forEach(character ->
        {
            if (VOWELS.contains((char) character))
                vowelsCount++;
            else if (Character.isLetter((char) character))
                consonantsCount++;
        }));

        System.out.println("There are " + vowelsCount + " vowels");
        System.out.println("There are " + consonantsCount + " consonants");
    }
}
