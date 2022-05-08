package chapter_four;


import java.util.Locale;
import java.util.Scanner;

/**
 * *4.21 (Check SSN) Write a program that prompts the user to enter a Social Security
 * number in the format DDD-DD-DDDD, where D is a digit. Your program should
 * check whether the input is valid. Here are sample runs:
 *
 *          Enter a SSN: 232−23−5435
 *          232−23−5435 is a valid social security number
 *
 *          Enter a SSN: 23−23−5435
 *          23−23−5435 is an invalid social security number
 *
 * @author Sharaf Qeshta
 * */

public class Problem$21
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a SSN: ");
        String input = scanner.next();

        if (input.length() == 11)
        {
            String firstSection = input.substring(0, 3);  // (start index inclusive, end index exclusive)
            String secondSection = input.substring(4, 6);
            String thirdSection = input.substring(7, 10);

            String digitsRegex = "^[0-9]+$";

            boolean valid = firstSection.matches(digitsRegex)
                    || secondSection.matches(digitsRegex)
                    || thirdSection.matches(digitsRegex);

            if (valid)
                System.out.println(input + " is a valid social security number");
            else
                System.out.println(input + " is an invalid social security number");
        }
        else
            System.out.println(input + "is an invalid social security number");
    }
}
