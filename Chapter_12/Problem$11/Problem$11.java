package chapter_twelve;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **12.11 (Remove text) Write a program that removes all the occurrences of a specified
 * string from a text file. For example, invoking
 * java Exercise12_11 John filename
 * removes the string John from the specified file. Your program should get the
 * arguments from the command line.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        File file = new File(args[1]);

        if (!file.exists())
        {
            System.out.println("the file is not exist.");
            System.exit(-1);
        }

        ArrayList<String> lines = new ArrayList<>();

        try (Scanner input = new Scanner(file))
        {
            // read and replace
            while (input.hasNext())
            {
                String str = input.nextLine();
                String str_ = str.replace(args[0], "");
                lines.add(str_);
            }

            // write
            try (PrintWriter output = new PrintWriter(file))
            {
                for (String x: lines)
                    output.println(x);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class Test
{
    public static void main(String[] args)
    {
        Problem$11.main(new String[] {"john", "src/chapter_twelve/text.txt"});
    }
}
