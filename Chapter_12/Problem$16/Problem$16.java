package chapter_twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **12.16 (Replace text) Listing 12.16, ReplaceText.java, gives a program that replaces
 * text in a source file and saves the change into a new file. Revise the program to
 * save the change into the original file. For example, invoking
 * java Exercise12_16 file oldString newString
 * replaces oldString in the source file with newString.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        writeInFile(file, args[1], args[2]);
    }

    public static void writeInFile(File file, String oldString, String newString)
    {
        ArrayList<String> lines = getAllLines(file);
        try (PrintWriter output = new PrintWriter(file))
        {
            for (String line: lines)
                output.println(line.replace(oldString, newString));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
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
}

class Drive
{
    public static void main(String[] args)
    {
        Problem$16.main(new String[] {"src/chapter_twelve/test.txt", "John", "Jack"});
    }
}