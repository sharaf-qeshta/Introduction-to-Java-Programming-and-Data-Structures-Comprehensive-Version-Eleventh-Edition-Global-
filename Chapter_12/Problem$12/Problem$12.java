package chapter_twelve;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **12.12 (Reformat Java source code) Write a program that converts the Java source
 * code from the next-line brace style to the end-of-line brace style. For example,
 * the following Java source in (a) uses the next-line brace style. Your program
 * converts it to the end-of-line brace style in (b).
 *
 *      public class Test
 *      {
 *          public static void main(String[] args)
 *          {
 *              // Some statements
 *          }
 *      }
 *
 *      public class Test {
 *          public static void main(String[] args) {
 *          // Some statements
 *          }
 *      }
 *
 *
 * Your program can be invoked from the command line with the Java source-code
 * file as the argument. It converts the Java source code to a new format. For example,
 * the following command converts the Java source-code file Test.java to
 * the end-of-line brace style.
 * java Exercise12_12 Test.java
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
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
            {
                String str = input.nextLine();
                if (str.contains("{"))
                    lines.set(lines.size()-1, lines.get(lines.size()-1) + " " + str.trim());
                else
                    lines.add(str);
            }

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
