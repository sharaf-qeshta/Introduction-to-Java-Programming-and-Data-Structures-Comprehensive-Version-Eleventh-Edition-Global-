package chapter_eleven;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 11.4 (Maximum element in ArrayList) Write the following method that returns the
 * maximum value in an ArrayList of integers. The method returns null if the
 * list is null or the list size is 0.
 * public static Integer max(ArrayList<Integer> list)
 * Write a test program that prompts the user to enter a sequence of numbers ending
 * with 0 and invokes this method to return the largest number in the input.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("enter numbers: ");
        while (true)
        {
            int input = scanner.nextInt();
            if (input == 0)
                break;
            list.add(input);
        }
        System.out.println("max number is: " + max(list));
    }

    public static Integer max(ArrayList<Integer> list)
    {
        if (list == null)
            return null;
        if (list.size() == 0)
            return 0;
        int max = list.get(0);

        for (int i = 1; i < list.size();i++)
            if (list.get(i) > max)
                max = list.get(i);
        return max;
    }
}
