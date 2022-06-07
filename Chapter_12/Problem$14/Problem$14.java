package chapter_twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * *12.14 (Reading in a sorted file) Write a method public static int
 * readInFile(String line, File file) that returns the position number
 * of a line in the file filename or −1 if there is no such line or file.
 * We assume that this file contains names of people with a name per line.
 * Names (and hence lines) are listed in ascending alphabetical order in the file.
 * We can not find the same line twice.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {

        File file = new File("src/chapter_twelve/test.txt");

        System.out.println(readInFile("hello world", file)); // 0
    }


    public static int readInFile(String line, File file)
    {
        try (Scanner scanner = new Scanner(file))
        {
            int index = 0;
            while (scanner.hasNext())
            {
                String string = scanner.nextLine();
                if (string.equals(line))
                    return index;
                index++;
            }
            return -1;
        }
        catch (FileNotFoundException e)
        {
            return -1;
        }
    }
}