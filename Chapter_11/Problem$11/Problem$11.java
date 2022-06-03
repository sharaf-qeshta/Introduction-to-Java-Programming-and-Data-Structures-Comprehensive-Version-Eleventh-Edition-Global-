package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 11.11 (Sort ArrayList) Write the following method that sorts an ArrayList of numbers:
 * public static void sort(ArrayList<Integer> list)
 * Write a test program that prompts the user to enter five numbers, stores them in
 * an array list, and displays them in increasing order.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$11
{
    public static void main(String[] args)
    {
        /*
        * sample runs:
        *
        *   enter five numbers: 7 5 4 9 11
        *   [4, 5, 7, 9, 11]
        *
        *   enter five numbers: 5 4 3 2 1
        *   [1, 2, 3, 4, 5]
        *
        *   enter five numbers: 12 11 32 56 587
        *   [11, 12, 32, 56, 587]
        * */
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("enter five numbers: ");
        for (int i = 0; i < 5;i++)
            list.add( scanner.nextInt());

        sort(list);
        System.out.println(list);

    }

    public static void sort(ArrayList<Integer> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            int key = list.get(i);
            int j = i - 1;
            while (j > -1 && list.get(j) > key)
                list.set(j+1, list.get(j--));
            list.set(j+1, key);
        }
    }
}
