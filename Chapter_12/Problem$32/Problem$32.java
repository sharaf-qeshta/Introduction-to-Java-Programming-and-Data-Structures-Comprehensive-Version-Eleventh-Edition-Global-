package chapter_twelve;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * *12.32 (Ranking summary) Write a program that uses the files described in Programming
 * Exercise 12.31 and displays a ranking summary table for the first five
 * girl’s and boy’s names as follows:
 *
 * Year Rank 1   Rank 2  Rank 3 Rank 4  Rank 5  Rank 1  Rank 2 Rank 3  Rank 4    Rank 5
 * 2010 Isabella Sophia  Emma   Olivia  Ava     Jacob   Ethan  Michael Jayden    William
 * 2009 Isabella Emma   Olivia  Sophia  Ava     Jacob   Ethan  Michael Alexander William
 * ...
 * 2001 Emily    Madison  Hannah Ashley Alexis Jacob Michael Matthew Joshua Christopher
 *
 * @author Sharaf Qeshta
 * */
public class Problem$32
{
    public static void main(String[] args)
            throws MalformedURLException
    {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                "Year ", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1"
                , "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        System.out.println();

        for (int i = 2010; i > 2000; i--)
        {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + i + ".txt");
            List<String> line = getFirstFive(url, i);

            for (String segment: line)
                System.out.printf("%-15s", segment);
            System.out.println();
        }
    }

    public static List<String> getFirstFive(URL url, int year)
    {
        List<String> content = getAllContent(url);
        ArrayList<String> girls = new ArrayList<>();
        ArrayList<String> boys = new ArrayList<>();
        girls.add(year + " ");

        for (int i = 0; i < 5; i++)
        {
            ArrayList<String> words = getAllWords(content.get(i));
            girls.add(words.get(3));
            boys.add(words.get(1));
        }
        girls.addAll(boys);
        return girls;
    }

    public static ArrayList<String> getAllWords(String line)
    {
        ArrayList<String> words = new ArrayList<>();

        try ( Scanner scanner = new Scanner(line))
        {
            while (scanner.hasNext())
                words.add(scanner.next());
            return words;
        }
    }


    public static List<String> getAllContent(URL url)
    {
        List<String> elements = new ArrayList<>();
        try ( Scanner scanner = new Scanner(url.openStream()) )
        {
            while (scanner.hasNext())
                elements.add(scanner.nextLine());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return elements;
    }
}
