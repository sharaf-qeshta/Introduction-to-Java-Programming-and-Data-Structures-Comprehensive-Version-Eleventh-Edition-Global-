package chapter_twenty_one;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


/**
 * **21.12 (Name for both genders) Write a program that prompts the user to enter one of the
 * filenames described in Programming Exercise 12.31 and displays the names that
 * are used for both genders in the file. Use sets to store names and find common
 * names in two sets. Here is a sample run:
 *
 *          Enter a file name for baby name ranking: babynamesranking2001.txt
 *          69 names used for both genders
 *          They are Tyler Ryan Christian ...
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args) throws MalformedURLException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a file name for baby name ranking: ");
        String fileName = scanner.next();

        HashSet<String> commonNames = getNames(fileName);
        System.out.println(commonNames.size() + " names used for both genders");
        System.out.println("They are: ");

        commonNames.forEach(s -> System.out.print(s + " "));
    }

    public static ArrayList<String> getAllContent(URL url)
    {
        ArrayList<String> elements = new ArrayList<>();
        try (Scanner scanner = new Scanner(url.openStream()))
        {
            while (scanner.hasNext())
            {
                String x = scanner.nextLine();
                elements.add(x);
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return elements;
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


    public static HashSet<String> getNames(String fileName) throws MalformedURLException
    {
        URL url = new URL("http://liveexample.pearsoncmg.com/data/" + fileName);
        ArrayList<String> lines = getAllContent(url);
        HashSet<String> boys = new HashSet<>();
        HashSet<String> girls = new HashSet<>();
        for (String line: lines)
        {
            ArrayList<String> words = getAllWords(line);
            boys.add(words.get(1));
            girls.add(words.get(3));
        }
        boys.retainAll(girls);
        return boys;
    }
}
