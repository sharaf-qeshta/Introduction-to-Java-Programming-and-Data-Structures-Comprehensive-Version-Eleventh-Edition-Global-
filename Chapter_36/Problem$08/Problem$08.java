package chapter_thirty_six;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 36.8 (Use the DecimalFormat class) Rewrite Exercise 5.8 to display at most two digits
 * after the decimal point for the temperature using the DecimalFormat class.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter the number of students: ");
        int numberOfStudent = scanner.nextInt();

        String maxName = ""; double maxScore = 0;

        for (int i = 0; i < numberOfStudent; i++)
        {
            System.out.print("enter the name of the student: ");
            String name = scanner.next();

            System.out.print("enter  " + name + " scores : ");
            double scores = scanner.nextDouble();

            if (scores > maxScore)
            {
                maxName = name;
                maxScore = scores;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(maxName + " have the highest score : " + df.format(maxScore));
    }
}
