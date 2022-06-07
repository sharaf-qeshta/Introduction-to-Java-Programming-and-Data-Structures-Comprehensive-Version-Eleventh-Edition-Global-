package chapter_twelve;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * *12.13 (Count characters, words, and lines in a file) Write a program that will count
 * the number of characters, words, and lines in a file. Words are separated by
 * whitespace characters. The file name should be passed as a command-line
 * argument, as shown in Figure 12.13.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        File file = new File(args[0]);

        if (!file.exists())
        {
            System.out.println("the file is not exist.");
            System.exit(-1);
        }

        ArrayList<String> lines = new ArrayList<>();

        try (Scanner input = new Scanner(file))
        {
            while (input.hasNext())
                lines.add(input.nextLine());

            System.out.println("File " + args[0] + " has: ");
            System.out.println(countChars(lines) + " characters");
            System.out.println(countWords(lines) + " words");
            System.out.println(lines.size() + " lines");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static int countChars(ArrayList<String> lines)
    {
        int total = 0;
        for (String x: lines)
            total += x.length();
        return total;
    }


    public static int countWords(ArrayList<String> lines)
    {
        int total = 0;
        for (String x: lines)
            total += x.split(" ").length;
        return total;
    }
}

class Drive
{
    public static void main(String[] args)
    {
        /*
        * File src/chapter_twelve/Loan.java has:
        * 2352 characters
        * 710 words
        * 93 lines
        * */
        Problem$13.main(new String[] {"src/chapter_twelve/Loan.java"});
    }
}