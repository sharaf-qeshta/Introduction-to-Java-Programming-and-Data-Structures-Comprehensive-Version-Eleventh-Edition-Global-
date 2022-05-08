package chapter_four;

import java.util.Locale;
import java.util.Scanner;


/**
 * *4.14 (Convert letter grade to number) Write a program that prompts the user to enter a
 * letter grade A, B, C, D, or F and displays its corresponding numeric value 4, 3, 2,
 * 1, or 0. For other input, display invalid grade. Here is a sample run:
 *
 *          Enter a letter grade: B
 *          The numeric value for grade B is 3
 *
 *          Enter a letter grade: T
 *          T is an invalid grade
 *
 * @author Sharaf Qeshta
 * */

public class Problem$14
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a letter grade: ");
        String input = scanner.next();


        char grade = Character.toUpperCase(input.charAt(0));
        int numericalGrade = Math.abs((int) grade - 69);

        if (grade == 'F')
            --numericalGrade;

        if (grade < 65 | grade > 70)
            System.out.println(grade + " is an invalid grade");
        else
            System.out.println("The numeric value for grade " + grade + " is " + numericalGrade);
    }
}
