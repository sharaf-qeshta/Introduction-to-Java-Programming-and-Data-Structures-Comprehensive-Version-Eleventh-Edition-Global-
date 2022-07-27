package chapter_twenty_one;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * *21.6 (Count the occurrences of words/names) Given a problem that is identical to
 * Programming Exercises 21.2 and 21.3, write a program that will count the number
 * of courses each student attended. In descending order of the number of days
 * attended, display the names of students and the number of courses each student
 * has attended. If the number of days attended by any two students is the same,
 * display their names in ascending order. For example, if both Billy and John
 * attended classes for 2 days, display Billy: 2 first, and then John: 2.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args) throws FileNotFoundException
    {
        HashSet<File> files = new HashSet<>();

        for (String arg : args)
        {
            File file = new File(arg);
            if (file.exists())
                files.add(file);
        }

        Map<String, Integer> names = getAllNames(files);

        Object[] keys = sort(names);
        for (Object key : keys)
            System.out.println(key + "\t" + names.get(key));

    }

    public static Object[] sort(Map<String, Integer> map)
    {
        Object[] keys = map.keySet().toArray();
        for (int i = 0; i < keys.length; i++)
        {
            int min = i;
            for (int j = i +1; j < keys.length; j++)
            {
                if (map.get(keys[min]) < map.get(keys[j]))
                    min = j;
                else if (map.get(keys[min]) == map.get(keys[j]))
                {
                    String key1 = (String) keys[min];
                    String key2 = (String) keys[j];
                    if (key1.compareTo(key2) > 0)
                        min = j;
                }
            }
            String temp = (String) keys[min];
            keys[min] = keys[i];
            keys[i] = temp;
        }

        return keys;
    }


    private static Map<String, Integer> getAllNames(HashSet<File> files)
            throws FileNotFoundException
    {
        Map<String, Integer> names = new HashMap<>();
        for (File file: files)
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                String name = scanner.nextLine();
                if (names.containsKey(name))
                    names.put(name, names.get(name)+1);
                else
                    names.put(name, 1);
            }
        }
        return names;
    }
}


class Test
{
    public static void main(String[] args) throws FileNotFoundException
    {
        /*
        * Addie Livingston	2
        * Ailish Pitt	2
        * Alfie Sinclair	2
        * Alysia Mansell	2
        * Amanpreet Wilson	2
        * Amba Barclay	2
        * Angela Haworth	2
        * .....
        * Aaran Bowler	1
        * Aayan Mcneill	1
        * Aayat Gilbert	1
        * Abdul Bernard	1
        * Agata Rivers	1
        * */
        Problem$06.main(new String[] {"src/chapter_twenty_one/files/day1.txt", "src/chapter_twenty_one/files/day2.txt"
                , "src/chapter_twenty_one/files/day3.txt", "src/chapter_twenty_one/files/day4.txt",
                "src/chapter_twenty_one/files/day5.txt"});
    }
}
