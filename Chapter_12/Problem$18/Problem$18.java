package chapter_twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **12.18 (Add package statement) Suppose you have Java source files under the directories
 * chapter1, chapter2, . . . , chapter34. Write a program to insert the
 * statement package chapteri; as the first line for each Java source file under
 * the directory chapteri. Suppose chapter1, chapter2, . . . , chapter34
 * are under the root directory srcRootDirectory. The root directory and
 * chapteri directory may contain other folders and files. Use the following
 * command to run the program:
 * java Exercise12_18 srcRootDirectory
 *
 * @author Sharaf Qeshta
 * */
public class Problem$18
{
    public static void main(String[] args)
    {
        File directory = new File(args[0]);
        File[] files = getAllFiles(directory);

        for (int i = 0; i < files.length; i++)
        {
            File[] subFiles = getAllFiles(files[i]);
            for (File subFile : subFiles)
            {
                ArrayList<String> lines = getAllLines(subFile);
                boolean empty = lines.size() == 0;
                String add = "package chapter_" + (i + 1) + ";\n\n" + ((empty)? "" : lines.get(0));

                if (empty)
                    lines.add(add);
                else
                    lines.set(0, add);

                writeIn(subFile, lines);
            }
        }
    }

    public static File[] getAllFiles(File file)
    {
        if (file.isDirectory())
            return file.listFiles();
        else
            return new File[] {file};
    }


    public static ArrayList<String> getAllLines(File file)
    {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
            {
                String string = scanner.nextLine();
                string = string.trim();
                lines.add(string);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeIn(File file, ArrayList<String> lines)
    {
        try (PrintWriter printWriter = new PrintWriter(file))
        {
            for (String line: lines)
                printWriter.println(line);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

class Drive
{
    public static void main(String[] args)
    {
        Problem$18.main(new String[] {"src/chapter_twelve/test"});
    }
}