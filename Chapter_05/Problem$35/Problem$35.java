package chapter_five;

/**
 * *5.35 (Summation) Write a program to compute the following summation:
 *  1/(1 + √2) + 1/(√2 + √3) + 1/(√3 + √4) + ... + 1/(√999 + √1000)
 *
 * @author Sharaf Qeshta
 *  */

public class Problem$35
{
    public static void main(String[] args)
    {
        double total = 0.0;

        for (int i = 1; i < 1000; i++)
            total += 1.0/(Math.sqrt(i) + Math.sqrt(i+1));

        System.out.println(total);
    }
}

