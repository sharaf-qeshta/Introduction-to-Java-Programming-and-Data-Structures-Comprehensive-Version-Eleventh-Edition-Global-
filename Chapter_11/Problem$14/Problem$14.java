package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.lang.System;

/**
 * 11.14 (Combine two lists) Write a method that returns the union of two array lists of
 * integers using the following header:
 * public static ArrayList<Integer> union(
 *  ArrayList<Integer> list1, ArrayList<Integer> list2)
 *  For example, the addition of two array lists {2, 3, 1, 5} and {3, 4, 6} is
 * {2, 3, 1, 5, 3, 4, 6}. Write a test program that prompts the user to enter two lists,
 * each with five integers, and displays their union. The numbers are separated by
 * exactly one space. Here is a sample run:
 *
 *              Enter five integers for list1: 3 5 45 4 3
 *              Enter five integers for list2: 33 51 5 4 13
 *              The combined list is 3 5 45 4 3 33 51 5 4 13
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.print("Enter five integers for list1: ");
        for (int i = 0; i < 5;i++)
            list1.add(scanner.nextInt());

        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.print("Enter five integers for list2: ");
        for (int i = 0; i < 5;i++)
            list2.add(scanner.nextInt());

        ArrayList<Integer> union = union(list1, list2);
        System.out.print("The combined list is ");
        for (int x: union)
            System.out.print(x + " ");
    }

    public static ArrayList<Integer> union(
            ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);
        return union;
    }
}
