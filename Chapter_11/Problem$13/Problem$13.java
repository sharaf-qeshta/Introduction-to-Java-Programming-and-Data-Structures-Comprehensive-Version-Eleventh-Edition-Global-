package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * *11.13 (Remove duplicates) Write a method that removes the duplicate elements from
 * an array list of integers using the following header:
 * public static void removeDuplicate(ArrayList<Integer> list)
 * Write a test program that prompts the user to enter 10 integers to a list and
 * displays the distinct integers in their input order and separated by exactly one space.
 * Here is a sample run:
 *
 *          Enter 10 integers: 34 5 3 5 6 4 33 2 2 4
 *          The distinct integers are 34 5 3 6 4 33 2
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("enter 10 integers: ");
        for (int i = 0; i < 10;i++)
            list.add(scanner.nextInt());

        removeDuplicate(list);
        System.out.print("The distinct integers are ");
        for (int x: list)
            System.out.print(x + " ");
    }

    public static void removeDuplicate(ArrayList<Integer> list)
    {
        ArrayList<Integer> newList = new ArrayList<>();

        for (Integer integer : list)
            if (!newList.contains(integer))
                newList.add(integer);

        list.clear();
        list.addAll(newList);
    }
}
