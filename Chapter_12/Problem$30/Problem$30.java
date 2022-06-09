package chapter_twelve;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * **12.30 (Occurrences of each letter) Write a program that prompts the user to enter a
 * file name and displays the occurrences of each letter in the file. Letters are case
 * insensitive. Here is a sample run:
 *
 *      Enter a filename: Lincoln.txt
 *      Number of As: 56
 *      Number of Bs: 134
 *      ...
 *      Number of Zs: 9
 *
 * @author Sharaf Qeshta
 * */
public class Problem$30
{
    public static final int[] OCCURRENCES = new int[26];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a filename: ");
        String fileName = scanner.next();

        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("the file is not exist :[");
            System.exit(-1);
        }

        List<String> lines = getAllLines(file);

        for (String line: lines)
        {
            char[] chars = line.toCharArray();
            for (char x: chars)
                increment(x);
        }

        for (int i = 0; i < OCCURRENCES.length; i++)
            System.out.println("Number of " + ((char) (i + 65)) + "s: " + OCCURRENCES[i]);
    }

    public static List<String> getAllLines(File file)
    {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                lines.add(scanner.nextLine().trim());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return lines;
    }


    public static void increment(char x)
    {
        char newX = Character.toUpperCase(x);
        if (newX > 64 & newX < 91)
            OCCURRENCES[(int) newX - 65]++;
    }
}
