package chapter_twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * *12.15 (Writing in a sorted file) Write a method public static int
 * writeInFile(String name, File file) that writes name at its correct
 * position in file so that it fulfills the assumptions given in Programming Exercise
 * 12.14. The method returns the line position of the name.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$15
{
    public static void main(String[] args)
    {
        File file = new File("src/chapter_twelve/test.txt");

        System.out.println(writeInFile("Sharaf Qeshta", file)); // 0
        System.out.println(writeInFile("John Smith", file)); // 0
        System.out.println(writeInFile("Noah", file)); // 1
        System.out.println(writeInFile("Adam", file)); // 0
    }


    public static int writeInFile(String name, File file)
    {
        ArrayList<String> lines = getAllLines(file);
        lines.add(name);
        sort(lines);
        int position = 0;
        try (PrintWriter output = new PrintWriter(file))
        {
            for (int i = 0; i < lines.size(); i++)
            {
                output.println(lines.get(i));
                if (lines.get(i).equals(name))
                    position = i;
            }
            return position;
        }catch (FileNotFoundException e)
        {
            return -1;
        }
    }

    public static ArrayList<String> getAllLines(File file)
    {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                lines.add(scanner.nextLine());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return lines;
    }


    public static void sort(ArrayList<String> lines)
    {
        for (int i = 1; i < lines.size(); i++)
        {
            String key = lines.get(i);
            int j = i -1;
            while (j > -1 && lines.get(j).compareTo(key) > 0)
                lines.set(j+1, lines.get(j--));
            lines.set(j+1, key);
        }
    }
}