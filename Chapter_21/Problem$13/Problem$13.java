package chapter_twenty_one;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * **21.13 (Baby name popularity ranking) Revise Programming Exercise 21.11 to
 * prompt the user to enter year, gender, and name and display the ranking for the
 * name. Prompt the user to enter another inquiry or exit the program. Here is a
 * sample run:
 *
 *          Enter the year: 2010
 *          Enter the gender: M
 *          Enter the name: Javier
 *          Boy name Javier is ranked #190 in year 2010
 *          Enter another inquiry? Y
 *          Enter the year: 2001
 *          Enter the gender: F
 *          Enter the name: Emily
 *          Girl name Emily is ranked #1 in year 2001
 *          Enter another inquiry? N
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    private static final Map<Integer, Map<String, Integer>>
            names = new HashMap<>();

    public static void main(String[] args) throws MalformedURLException
    {
        setNames();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter the year:");
            int year = scanner.nextInt();

            System.out.print("Enter the gender: ");
            char gender = scanner.next().trim().charAt(0);

            System.out.print("Enter the name: ");
            String name = scanner.next().trim();

            int rank = names.get(year).get(name);

            System.out.println(
                    ((gender == 'M')? "Boy" : "Girl") + " name " + name
                            + " is ranked #" + rank + " in year " + year
            );


            System.out.print("Enter another inquiry?");
            char response = scanner.next().trim().charAt(0);
            if (response == 'N')
                break;
        }

        scanner.close();
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
        } catch (IOException exception)
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


    public static void setNames() throws MalformedURLException
    {
        for (int i = 2001; i < 2011; i++)
        {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + i + ".txt");
            ArrayList<String> lines = getAllContent(url);
            Map<String, Integer> year = new HashMap<>();
            for (String line: lines)
            {
                ArrayList<String> words = getAllWords(line);
                int rank = Integer.parseInt(words.get(0));
                year.put(words.get(1), rank);
                year.put(words.get(3), rank);
            }
            names.put(i, year);
        }
    }
}
