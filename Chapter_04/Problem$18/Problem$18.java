package chapter_four;


import java.util.Locale;
import java.util.Scanner;

/**
 * *4.18 (Student major and status) Write a program that prompts the user to enter two
 * characters and displays the major and status represented in the characters. The first
 * character indicates the major and the second is number character 1, 2, 3, 4, which
 * indicates whether a student is a freshman, sophomore, junior, or senior. Suppose
 * the following characters are used to denote the majors:
 * I: Information Management
 * C: Computer Science
 * A: Accounting
 * Here is a sample run:
 *
 *          Enter two characters: I1
 *          Information Management Freshman
 *
 *          Enter two characters: A3
 *          Accounting Junior
 *
 *          Enter two characters: T3
 *          Invalid input
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter two characters: ");
        String input = scanner.next();

        char code1 = input.charAt(0);
        char code2 = input.charAt(1);

        String major = switch (code1)
        {
            case 'I' -> "Information Management";
            case 'C' -> "Computer Science";
            case 'A' -> "Accounting";
            default -> "Undefined";
        };

        String status = switch (code2)
        {
            case '1' -> "Freshman";
            case '2' -> "Sophomore";
            case '3' -> "Junior";
            case '4' -> "Senior";
            default -> "Undefined";
        };

        if (major.equals("Undefined") || status.equals("Undefined"))
            System.out.println("Invalid Input");
        else
            System.out.println(major + " " + status);
    }
}
