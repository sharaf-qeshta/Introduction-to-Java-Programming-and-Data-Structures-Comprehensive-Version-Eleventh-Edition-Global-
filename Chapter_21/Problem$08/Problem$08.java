package chapter_twenty_one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * **21.8 (Count the occurrences of words in a text file) Rewrite Listing 21.9 to read the
 * text from a text file. The text file is passed as a command-line argument. Words
 * are delimited by whitespace characters, punctuation marks (,;.:?), quotation
 * marks ('"), and parentheses. Count words in case-insensitive fashion (e.g.,
 * consider Good and good to be the same word). The words must start with a letter.
 * Display the output in alphabetical order of words, with each word preceded
 * by its occurrence count.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length < 1)
        {
            System.out.println("Invalid Input");
            System.exit(-1);
        }
        Map<String, Integer> map = new TreeMap<>();

        File file = new File(args[0]);
        Scanner reader = new Scanner(file);
        while (reader.hasNext())
        {
            String line = reader.nextLine();
            String[] words = line.split("[\\s+\\p{P}\\p{Pf}]");
            for (String word : words)
            {
                String key = word.toLowerCase();
                if (key.length() > 0)
                {
                    if (!map.containsKey(key))
                        map.put(key, 1);
                    else
                    {
                        int value = map.get(key);
                        value++;
                        map.put(key, value);
                    }
                }
            }
        }

        Object[] sortedKeys = sort(map);
        for (Object sortedKey : sortedKeys)
            System.out.println(String.format("%-15s", sortedKey) + map.get(sortedKey));
    }

    public static Object[] sort(Map<String, Integer> map)
    {
        Object[] keys = map.keySet().toArray();
        for (int i = 0; i < keys.length; i++)
        {
            int min = i;
            for (int j = i +1; j < keys.length; j++)
            {
                String key1 = (String) keys[min];
                String key2 = (String) keys[j];
                if (key1.compareTo(key2) > 0)
                    min = j;
            }
            String temp = (String) keys[min];
            keys[min] = keys[i];
            keys[i] = temp;
        }

        return keys;
    }
}



class Test
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Problem$08.main(new String[] {"src/chapter_twenty_one/words.txt"});
    }
}