package chapter_twenty_two;

import java.util.Scanner;

/**
 * *22.3 (Pattern matching) Write an O(n) time program that prompts the user to enter
 * two strings and tests whether the second string is a substring of the first string.
 * Suppose the neighboring characters in the string are distinct. (Don’t use the
 * indexOf method in the String class.) Here is a sample run of the program:
 *
 *          Enter a string s1: Welcome to Java
 *          Enter a string s2: come
 *          matched at index 3
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string s1: ");
        String phrase = scanner.nextLine();

        System.out.print("Enter a string s2: ");
        String pattern = scanner.nextLine();

        System.out.println("matched at index " + getIndex(phrase, pattern));
    }


    public static int getIndex(String string, String pattern)
    {
        int currentIndex = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (pattern.charAt(currentIndex) == string.charAt(i))
            {
                if (currentIndex == pattern.length()-1)
                    return i - (pattern.length()-1);
                currentIndex++;
            }
            else
                currentIndex = 0;
        }
        return -1;
    }
}
