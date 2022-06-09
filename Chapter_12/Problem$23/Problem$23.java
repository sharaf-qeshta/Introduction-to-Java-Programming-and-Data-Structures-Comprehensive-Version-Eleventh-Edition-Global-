package chapter_twelve;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * **12.23 (Process scores in a text file on the Web) Suppose the text file on the Web
 * http://liveexample.pearsoncmg.com/data/Scores.txt contains an unspecified
 * number of scores separated by spaces. Write a program that reads the scores
 * from the file and displays their total and average.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$23
{
    public static final String LINK = "http://liveexample.pearsoncmg.com/data/Scores.txt";

    public static void main(String[] args) throws MalformedURLException
    {
        URL url = new URL(LINK);
        int sum = 0;
        List<Integer> numbers = getAllContent(url);

        for (int element: numbers)
            sum += element;

        /* the average is: 33 */
        System.out.println("the average is: " + (sum / numbers.size()));
    }

    public static List<Integer> getAllContent(URL url)
    {
        List<Integer> elements = new ArrayList<>();
        try (Scanner scanner = new Scanner(url.openStream()))
        {
            while (scanner.hasNext())
                elements.add(scanner.nextInt());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return elements;
    }
}
