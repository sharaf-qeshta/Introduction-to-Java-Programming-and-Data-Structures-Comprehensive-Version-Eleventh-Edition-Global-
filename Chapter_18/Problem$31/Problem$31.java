package chapter_eighteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **18.31 (Replace words) Write a program that replaces all occurrences of a word with a
 * new word in all the files under a directory, recursively. Pass the parameters from
 * the command line as follows:
 * java Exercise18_31 dirName oldWord newWord
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$31
{
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        replace(file, args[1], args[2]);
    }

    public static void replace(File file, String oldWord, String newWord)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++)
                replace(files[i], oldWord, newWord);
        }
        else
            replaceInFile(file, oldWord, newWord);
    }

    public static void replaceInFile(File file, String oldWord, String newWord)
    {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner input = new Scanner(file))
        {
            while (input.hasNext())
            {
                String line = input.nextLine();
                line = line.replace(oldWord, newWord);
                lines.add(line);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        try (PrintWriter output = new PrintWriter(file))
        {
            for (String line: lines)
                output.append(line).append("\n");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}


class Test
{
    public static void main(String[] args)
    {
        Problem$31.main(new String[] {"src/test", "class", "test"});
    }
}
