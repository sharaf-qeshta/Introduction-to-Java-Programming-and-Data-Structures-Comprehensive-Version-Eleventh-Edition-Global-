package chapter_eighteen;

import java.io.File;

/**
 * *18.29 Write a program that prompts the
 * user for a path and displays the directory structure on the command tool
 * as follows:
 * testdir
 * +--f1
 * +--d2
 *      +--d22
 *          +--f221
 *      +--f21
 *      +--d21
 *          +--f212
 *          +--f211
 * +--f2
 * +--d1
 *      +--f12
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$29
{
    private static boolean first = true;


    public static void main(String[] args)
    {
        File file = new File("src/chapter_eighteen");
        printStructure(file, "\t");
    }


    public static void printStructure(File file, String regex)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            if (first)
            {
                System.out.println(regex + file.getName());
                first = false;
            }
            else
                System.out.println(regex + "+--" + file.getName());

            for (int i = 0; files != null && i < files.length; i++)
                printStructure(files[i], regex + "\t");
        }
        else
            System.out.println(regex + "+--" + file.getName());
    }
}
