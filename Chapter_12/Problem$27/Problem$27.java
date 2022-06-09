package chapter_twelve;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * **12.27 (Replace words) Suppose you have a lot of files in a directory that contain
 * words Exercisei_j, where i and j are digits. Write a program that pads a 0
 * before i if i is a single digit and 0 before j if j is a single digit. For example, the
 * word Exercise2_1 in a file will be replaced by Exercise02_01. In Java, when
 * you pass the symbol * from the command line, it refers to all files in the directory
 * (see Supplement III.V). Use the following command to run your program:
 * java Exercise12_27 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$27
{
    public static void main(String[] args)
    {
        String path = args[0];
        if (path.equals("*"))
            // current directory
            path = System.getProperty("user.dir");

        File directory = new File(path);

        if (!directory.exists())
        {
            System.out.println("the directory is not exist :[");
            System.exit(-1);
        }

        File[] files = getAllFiles(directory);

        for (File file: files)
            replace(file);
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
                writer.write(line + "\n");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static File[] getAllFiles(File file)
    {
        if (file.isDirectory())
            return file.listFiles();
        return new File[]{file};
    }


    public static void replace(File file)
    {
        List<String> lines = getAllLines(file);

        for (String line: lines)
        {
            if (line.contains("Exercise"))
            {
                String[] component = line.split("_");
                String modifiedLine = "Exercise";

                String i = component[0].replace("Exercise", ""), j = component[1];

                if (i.length() < 2)
                    i = 0 + i;
                if (j.length() < 2)
                    j = 0 + j;

                lines.set(lines.indexOf(line), modifiedLine + i + "_" + j);
            }
        }
        writeLines(file, lines);
    }
}


class Drive
{
    public static void main(String[] args)
    {
        Problem$27.main(new String[] {"*"});
    }
}
