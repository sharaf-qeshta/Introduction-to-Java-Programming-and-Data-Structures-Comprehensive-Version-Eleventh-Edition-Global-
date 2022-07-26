package chapter_twenty_one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 21.2 (Display nonduplicate names in ascending order) Given one or more text files,
 * each representing a day’s attendance in a course and containing the names of the
 * students who attended the course on that particular day, write a program that displays,
 * in ascending order, the names of those students who have attended at least
 * one day of the course. The text file(s) is/are passed as command-line argument(s).
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$02
{
    public static void main(String[] args)
            throws FileNotFoundException
    {
        HashSet<File> files = new HashSet<>();

        for (String arg : args)
        {
            File file = new File(arg);
            if (file.exists())
                files.add(file);
        }

        HashSet<String> names = getAllNames(files);
        sort(names).forEach(System.out::println);
    }

    public static ArrayList<String> sort(HashSet<String> set)
    {
        ArrayList<String> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++)
        {
            int min = i;
            for (int j = i +1; j < list.size(); j++)
                if (list.get(min).compareTo(list.get(j)) < 0)
                    min = j;
            String temp = list.get(min);
            list.set(min, list.get(i));
            list.set(i, temp);
        }
        return list;
    }


    private static HashSet<String> getAllNames(HashSet<File> files)
            throws FileNotFoundException
    {
        HashSet<String> names = new HashSet<>();
        for (File file: files)
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
                names.add(scanner.nextLine().trim());
        }
        return names;
    }
}


class Test
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Problem$02.main(new String[] {"src/chapter_twenty_one/files/day1.txt", "src/chapter_twenty_one/files/day2.txt"
                , "src/chapter_twenty_one/files/day3.txt", "src/chapter_twenty_one/files/day4.txt",
                "src/chapter_twenty_one/files/day5.txt"});
    }
}