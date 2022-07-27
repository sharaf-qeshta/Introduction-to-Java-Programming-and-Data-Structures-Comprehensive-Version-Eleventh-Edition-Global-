package chapter_twenty_one;


import java.util.Map;
import java.util.TreeMap;

/**
 * **21.7 (Revise Listing 21.9, CountOccurrenceOfWords.java) Rewrite Listing 21.9 to
 * display the words in ascending order of occurrence counts.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[\\s+\\p{P}]");

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

        Object[] sortedKeys = sort(map);
        /*
        * class      1
        * fun        1
        * morning    1
        * visit      1
        * a          2
        * have       3
        * good       3
        * */
        for (Object sortedKey : sortedKeys)
            System.out.println(String.format("%-10s", sortedKey) + " " + map.get(sortedKey));

    }

    public static Object[] sort(Map<String, Integer> map)
    {
        Object[] keys = map.keySet().toArray();
        for (int i = 0; i < keys.length; i++)
        {
            int min = i;
            for (int j = i +1; j < keys.length; j++)
                if (map.get(keys[min]) > map.get(keys[j]))
                    min = j;
            String temp = (String) keys[min];
            keys[min] = keys[i];
            keys[i] = temp;
        }

        return keys;
    }
}
