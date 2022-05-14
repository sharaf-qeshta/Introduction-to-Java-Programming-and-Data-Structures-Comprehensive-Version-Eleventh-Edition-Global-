package chapter_six;

import java.util.Scanner;

/**
 * **6.18 (Check password) Some websites impose certain rules for passwords. Write a
 * method that checks whether a string is a valid password. Suppose the password
 * rules are as follows:
 * ■■ A password must have at least ten characters.
 * ■■ A password consists of only letters and digits.
 * ■■ A password must contain at least three digits.
 * Write a program that prompts the user to enter a password and displays Valid
 * Password if the rules are followed or Invalid Password otherwise.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a password: ");
        String pass = scanner.next();

        System.out.println(checkPassword(pass));
    }

    public static boolean checkPassword(String pass)
    {
        /* A password must have at least ten characters. */
        boolean c1 = pass.length() >= 10;

        /* A password consists of only letters and digits. */
        boolean c2 = true;

        int digits = 0;

        for (int i = 0; i < pass.length(); i++)
        {
            char c = pass.charAt(i);

            if (Character.isDigit(c))
                digits++;
            else if (Character.isLetter(c));
            else
                c2 = false;
        }

        return c1 & c2 & digits >= 3;
    }
}
