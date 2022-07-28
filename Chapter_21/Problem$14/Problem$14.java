package chapter_twenty_one;

import java.util.*;

/**
 * **21.14 (Web crawler) Rewrite Listing 12.18, WebCrawler.java, to improve the performance
 * by using appropriate new data structures for listOfPendingURLs and
 * listofTraversedURLs.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();

        crawler(url);
    }

    public static void crawler(String startingURL)
    {
        HashSet<String> urls = new HashSet<>();

        urls.add(startingURL);
        while (!urls.isEmpty() &&
                urls.size() <= 100)
        {
            String urlString = (String) urls.toArray()[0];
            urls.add(urlString);
            System.out.println("Crawl " + urlString);

            urls.addAll(getSubURLs(urlString));
            urls.remove(urlString);
        }
    }


    public static ArrayList<String> getSubURLs(String urlString)
    {
        ArrayList<String> list = new ArrayList<>();

        try
        {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext())
            {
                String line = input.nextLine();
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
