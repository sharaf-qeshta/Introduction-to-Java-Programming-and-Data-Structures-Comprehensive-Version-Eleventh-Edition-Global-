package chapter_twelve;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * *12.22 (Replace text) Revise Programming Exercise 12.16 to replace a string in a file with
 * a new string for all files in the specified directory using the following command:
 * java Exercise12_22 dir oldString newString
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22
{
    public static void main(String[] args)
    {
        File[] files = getAllFiles(new File(args[0]));
        for (File file: files)
        {
            List<String> lines = getAllLines(file);
            replace(lines, args[1], args[2]);
            writeLines(file, lines);
        }
    }

    public static File[] getAllFiles(File file)
    {
        if (file.isDirectory())
            return file.listFiles();
        return new File[]{file};
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

    public static void writeLines(File file, List<String> lines)
    {
        try (PrintWriter writer = new PrintWriter(file))
        {
            for (String line: lines)
                writer.write(line);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void replace(List<String> lines, String... args)
    {
        // i just learn from reading the source code of Scanner class
        Objects.requireNonNull(lines, "Lines Cannot be Null");

        for (int i = 0; i < lines.size(); i++)
            lines.set(i, lines.get(i).replace(args[0], args[1]));
    }
}

class Drive
{
    public static void main(String[] args)
    {
        Problem$22.main(new String[] {"src/chapter_twelve/test", "hello", "welcome"});
    }
}