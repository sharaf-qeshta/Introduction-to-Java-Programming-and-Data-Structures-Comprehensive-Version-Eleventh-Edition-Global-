package chapter_twelve;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * **12.33 (Search Web) Modify Listing 12.18 WebCrawler.java to search for the word
 * (e.g., Computer Programming) starting from a URL (e.g., http://cs.armstrong
 * .edu/liang). Your program prompts the user to enter the word and the starting
 * URL and terminates once the word is found. Display the URL for the page that
 * contains the word.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$33
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A keyword to Search for: ");
        String keyword = scanner.nextLine();
        System.out.print("Enter a Starting URL: ");
        String url = scanner.nextLine();

        crawler(url, keyword);
    }

    public static void crawler(String startingURL, String keyword)
    {
        List<String> listOfPendingURLs = new ArrayList<>();
        List<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100)
        {
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString))
            {
                listOfTraversedURLs.add(urlString);
                for (String s: getSubURLs(urlString, keyword))
                {
                    if (!listOfTraversedURLs.contains(s))
                        listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static List<String> getSubURLs(String urlString, String keyword)
    {
        List<String> list = new ArrayList<>();

        try
        {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext())
            {
                String line = input.nextLine();
                if (line.contains(keyword))
                {
                    System.out.println("URL: " + urlString + " contains " + keyword);
                    System.exit(0);
                }
                current = line.indexOf("http:", current);
                while (current > 0)
                {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0)
                    {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
