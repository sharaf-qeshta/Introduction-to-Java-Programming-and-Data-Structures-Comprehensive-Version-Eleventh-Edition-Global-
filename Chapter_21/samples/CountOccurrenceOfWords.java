package chapter_twentyone.samples;

import java.util.Map;
import java.util.TreeMap;

/**Listing 21.9 CountOccurrenceOfWords.java*/
public class CountOccurrenceOfWords
{
    public static void main(String[] args)
    {
        String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[\\s+\\p{P}]");

        for (int i = 0; i < words.length; i++)
        {
            String key = words[i].toLowerCase();
            if (key.length() > 0)
            {
                if (!map.containsKey(key))
                {
                    map.put(key, 1);
                }else
                {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        map.forEach((k, v) -> System.out.println(k + "\t" + v));

    }
}
