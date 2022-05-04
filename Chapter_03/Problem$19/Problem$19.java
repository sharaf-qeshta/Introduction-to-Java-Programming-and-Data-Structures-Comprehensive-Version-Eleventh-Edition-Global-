package chapter_three;

import java.util.Scanner;

/**
 * **3.19 (Compute the perimeter of a triangle) Write a program that reads three edges for a
 * triangle and computes the perimeter if the input is valid. Otherwise, display that the
 * input is invalid. The input is valid if the sum of every pair of two edges is greater
 * than the remaining edge.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$19
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Edge 1 : ");
        int edge1 = scanner.nextInt();

        System.out.print("Enter Edge 2 : ");
        int edge2 = scanner.nextInt();

        System.out.print("Enter Edge 3 : ");
        int edge3 = scanner.nextInt();


        boolean valid = edge1+edge2 > edge3;
        valid = valid && edge2+edge3 > edge1;
        valid = valid && edge1+edge3 > edge2;

        if (valid)
            System.out.println("The Perimeter is " + (edge1 + edge2 + edge3));
        else
            System.out.println("Invalid Input");
    }
}
