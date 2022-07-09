package chapter_eighteen;


/**
 * *18.10 (Occurrences of a specified character in a string) Write a recursive method that
 * finds the number of occurrences of a specified letter in a string using the following method header:
 * public static int count(String str, char a)
 * For example, count("Welcome", 'e') returns 2. Write a test program that
 * prompts the user to enter a string and a character, and displays the number of
 * occurrences for the character in the string.
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$10
{
    public static int occurrences = 0;

    public static void main(String[] args)
    {
        System.out.println(count("welcome", 'e')); // 2

        occurrences = 0;
        System.out.println(count("Sharaf", 'a')); // 2

        occurrences = 0;
        System.out.println(count("Qeshta", 'Q')); // 1

        occurrences = 0;
        System.out.println(count("Java", 'v')); // 1
    }

    public static int count(String str, char a)
    {
        if (str.contains(a + ""))
        {
            occurrences++;
            return count(str.substring(0, str.lastIndexOf(a)), a);
        }
        return occurrences;
    }
}
