package chapter_eighteen;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * **18.30 (Find words) Write a program that finds all occurrences of a word in all the files
 * under a directory, recursively. Pass the parameters from the command line as
 * follows:
 * java Exercise18_30 dirName word
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$30
{
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        searchFor(file, args[1]);
    }


    public static void searchFor(File file, String word)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++)
                searchFor(files[i], word);
        }
        else
        {
            try (Scanner scanner = new Scanner(file))
            {
                int i = 1;
                while (scanner.hasNext())
                {
                    String input = scanner.nextLine();
                    if (input.contains(word))
                        System.out.println("found " + word + " in " + file.getName() + " line " + i);
                    i++;
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}


class Test
{
    public static void main(String[] args)
    {
        Problem$30.main(new String[] {"src/chapter_eighteen", "chapter_eighteen"});
    }
}
