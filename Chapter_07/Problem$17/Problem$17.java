package chapter_seven;

import java.util.Locale;
import java.util.Scanner;

/**
 * **7.17 (Sort students) Write a program that prompts the user to enter the number of
 * students, the students’ names, and their scores and prints student names in decreasing
 * order of their scores. Assume the name is a string without spaces, use the
 * Scanner’s next() method to read a name.
 *
 * @author Sharaf Qeshta
 * */


public class Problem$17
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter the Number of Students: ");
        int size = scanner.nextInt();
        String[] names = new String[size];
        int[] scores = new int[size];

        for (int i = 0; i < size; i++)
        {
            System.out.print("enter [student score]: ");
            names[i] = scanner.next();
            scores[i] = scanner.nextInt();
        }

        sortTwoLists(names, scores);

        for (int i = 0;i < names.length && names[i] != null;i++)
            System.out.println(names[i] +": " + scores[i]);
    }

    public static void sortTwoLists(String[] l1, int[] l2)
    {
        // descending
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for (int j = 0; j < l2.length-1;j++)
            {
                if (l2[j] < l2[j+1])
                {
                    int temp = l2[j];
                    String temp_ = l1[j];
                    l2[j]  = l2[j+1];
                    l1[j] = l1[j+1];
                    l2[j+1] = temp;
                    l1[j+1] = temp_;
                    sorted = false;
                }
            }
        }
    }
}
