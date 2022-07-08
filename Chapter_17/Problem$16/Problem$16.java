package chapter_seventeen;

import java.io.*;
import java.util.Scanner;

/**
 * 17.16 (Frequency of characters) Write a program that prompts the user to enter the
 * name of an ASCII text file and displays the frequency of the characters in the file.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    private static final int[] lettersOccurrences = new int[26]; // -65

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a text file: ");
        String fileName = scanner.next();

        countLetters(fileName);
        display();
    }

    private static void countLetters(String fileName)
    {
        try (Scanner file = new Scanner(new File(fileName)))
        {
            while (file.hasNext())
            {
                char[] lineChars = file.nextLine().toCharArray();
                for (char x : lineChars)
                    if (Character.isLetter(x))
                        lettersOccurrences[Character.toUpperCase(x) - 65]++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File is not exist");
        }
    }


    private static void display()
    {
        for (int i = 0; i < lettersOccurrences.length; i++)
        {
            char x = (char) (i + 65);
            System.out.println(x + ": " + lettersOccurrences[i]);
        }
    }
}