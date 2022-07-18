package chapter_twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * *20.1 (Display words in descending alphabetical order) Write a program that reads
 * words from a text file and displays all the words (duplicates allowed) in
 * descending alphabetical order. The words must start with a letter. The text file
 * is passed as a command-line argument.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        display(args[0]);
    }


    public static void display(String fileName)
    {
        ArrayList<String> words = new ArrayList<>();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNext())
                words.add(scanner.next());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not read the file :)");
            return;
        }

        words.sort((s1, s2) -> s2.compareTo(s1));
        System.out.println(words);
    }
}


class Test
{
    public static void main(String[] args)
    {
        /* [should, programmer, powerful, learn, language, java, it, is, every, a] */
        Problem$01.main(new String[] {"src/chapter_twenty/words.txt"});
    }
}
