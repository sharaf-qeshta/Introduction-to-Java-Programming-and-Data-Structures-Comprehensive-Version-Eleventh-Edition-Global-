package chapter_eighteen;


import java.util.Scanner;

/**
 * **18.25 (String permutation) Write a recursive method to print all the permutations of a
 * string. For example, for the string abc, the permutation is
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * (Hint: Define the following two methods. The second is a helper method.)
 * public static void displayPermutation(String s)
 * public static void displayPermutation(String s1, String s2)
 * The first method simply invokes displayPermutation(" ", s). The second
 * method uses a loop to move a character from s2 to s1 and recursively invokes
 * it with new s1 and s2. The base case is that s2 is empty and prints s1 to the
 * console.
 * Write a test program that prompts the user to enter a string and displays all its
 * permutations.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$25
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.next();
        displayPermutation(s);
    }

    public static void displayPermutation(String s)
    {
        displayPermutation(s, 0);
    }

    public static void displayPermutation(String s, int index)
    {
        char[] array = s.toCharArray();
        for(int i = index; i < array.length; i++)
        {
            char temp = array[i];
            array[i] = array[index];
            array[index] = temp;

            displayPermutation(String.valueOf(array), index+1);

            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        if (index == array.length - 1)
            System.out.println(String.valueOf(array));
    }
}
