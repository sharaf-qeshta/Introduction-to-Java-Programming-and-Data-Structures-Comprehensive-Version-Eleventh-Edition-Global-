package chapter_twenty_one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * **21.3 (Checking whether a key exists in a set) Given a problem that is identical to the previous
 * Programming Exercise 21.2, write a program that displays, in ascending order,
 * the first names of those students who have attended more than one day of the course.
 * If there are students with the same first name, display their first and last names.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
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
        getFirstNames(sort(names)).forEach(System.out::println);
    }

    public static ArrayList<String> sort(HashSet<String> set)
    {
        ArrayList<String> array = new ArrayList<>(set);
        for (int i = 0; i < array.size(); i++)
        {
            int min = i;
            for (int j = i +1; j < array.size(); j++)
            {
                if (array.get(min).compareTo(array.get(j)) < 0)
                    min = j;
            }
            String temp = array.get(min);
            array.set(min, array.get(i));
            array.set(i, temp);
        }
        return array;
    }


    private static HashSet<String> getAllNames(HashSet<File> files) throws FileNotFoundException
    {
        HashSet<String> tempNames = new HashSet<>();
        HashSet<String> names = new HashSet<>();
        for (File file: files)
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                String name = scanner.nextLine();
                if (tempNames.contains(name))
                    names.add(name);
                tempNames.add(name);
            }
        }
        return names;
    }


    public static ArrayList<String> getFirstNames(ArrayList<String> list)
    {
        ArrayList<String> firstNames = new ArrayList<>();
        for (String name: list)
        {
            String[] nameArray = name.split(" ");
            if (firstNames.contains(nameArray[0]))
                firstNames.add(name);
            else
                firstNames.add(nameArray[0]);
        }
        return firstNames;
    }
}

class Test
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Problem$03.main(new String[] {"src/chapter_twenty_one/files/day1.txt", "src/chapter_twenty_one/files/day2.txt"
                , "src/chapter_twenty_one/files/day3.txt", "src/chapter_twenty_one/files/day4.txt",
                "src/chapter_twenty_one/files/day5.txt"});
    }
}