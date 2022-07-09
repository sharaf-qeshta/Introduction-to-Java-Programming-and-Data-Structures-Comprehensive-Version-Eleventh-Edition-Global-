package chapter_eighteen;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * *18.6 Write a recursive method public static void randomFillSortedArray
 * (int[] x, int l, int r, int a, int b) that fills the array x between l
 * and r with random values between a and b such that x is sorted. Here is a sample
 * run:
 *
 *      Enter the array size: 10
 *      Enter the limits: 0 1000
 *      [235, 280, 382, 428, 458, 462, 484, 495, 536, 850]
 *      Enter the array size: 10
 *      Enter the limits: 0 9
 *      [0, 0, 3, 3, 4, 6, 6, 8, 8, 9]
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter the array size: ");
            int arraySize = scanner.nextInt();

            System.out.print("Enter the limits: ");
            int a = scanner.nextInt(), b = scanner.nextInt();

            int[] x = new int[arraySize];
            randomFillSortedArray(x, 0, x.length-1, a, b);
            System.out.println(Arrays.toString(x));
        }
    }


    public static void randomFillSortedArray(int[] x, int l,
                                             int r, int a, int b)
    {
        if (l == r)
           sort(x);
        else
        {
            int random = new Random().nextInt(b - a) + a;
            x[l] = random;
            randomFillSortedArray(x, l+1, r, a, b);
        }
    }

    public static void sort(int[] x)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < x.length-1; i++)
            {
                if (x[i] > x[i+1])
                {
                    int temp = x[i];
                    x[i] = x[i+1];
                    x[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
