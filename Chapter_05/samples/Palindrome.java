package chapter_five.samples;

import java.util.Scanner;

/** Listing 5.14 Palindrome.java */
public class Palindrome
{
    /** Main method */
    public static void main(String[] args)
    {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        // The index of the first character in the string
        int low = 0;

        // The index of the last character in the string
        int high = s.length() - 1;

        boolean isPalindrome = true;

        while (low < high)
        {
            if (s.charAt(low) != s.charAt(high))
            {
                isPalindrome = false;
                break;
            }

            low++; high--;
        }

        if (isPalindrome)
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is not a palindrome");
    }
}
