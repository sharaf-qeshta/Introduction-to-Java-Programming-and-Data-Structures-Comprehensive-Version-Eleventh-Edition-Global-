package chapter_three;

import java.util.Scanner;

/**
 * *3.18 (Cost of shipping) A shipping company uses the following function to calculate the
 * cost (in dollars) of shipping based on the weight of the package (in pounds).
 * c(w) =
 *          2.5, if 0 < w <= 2
 *          4.5, if 2 < w <= 4
 *          7.5, if 4 < w <= 10
 *          10.5, if 10 < w <= 20
 *  Write a program that prompts the user to enter the weight of the package and
 * display the shipping cost. If the weight is greater than 20, display a message “the
 * package cannot be shipped.”
 *
 * @author Sharaf Qeshta
 * */

public class Problem$18
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the weight : ");
        double weight = scanner.nextDouble();

        String output;
        if (weight <= 2)
            output = "2.5";
        else if (weight <= 4)
            output = "4.5";
        else if (weight <= 10)
            output = "7.5";
        else if (weight <= 20)
            output = "10.5";
        else
            output = "the package cannot be shipped";

        System.out.println(output);
    }
}
