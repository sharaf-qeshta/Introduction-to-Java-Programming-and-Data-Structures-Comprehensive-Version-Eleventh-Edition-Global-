package chapter_six;

/**
 * *6.23 (Occurrences of a specified character) Write a method that finds the number of
 * occurrences of a specified character in a string using the following header:
 * public static int count(String str, char a)
 * For example, count("Welcome", 'e') returns 2. Write a test program that
 * prompts the user to enter a string followed by a character then displays the number
 * of occurrences of the character in the string.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$23
{
    public static void main(String[] args)
    {
        System.out.println(count("Welcome", 'e')); // 2
    }

    public static int count(String str, char a)
    {
        int occurrences = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == a)
                occurrences++;
        }
        return occurrences;
    }
}
