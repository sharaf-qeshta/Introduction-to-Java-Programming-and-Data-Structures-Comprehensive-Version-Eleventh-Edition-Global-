package chapter_five;

/**
 * 5.13 (Find the largest n such that n² < 12,000) Use a while loop to find the largest
 * integer n such that n² is less than 12,000.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$13
{
    public static void main(String[] args)
    {
        int i = 200; // since (200 * 200) => 40,000
        while (i * i >= 12_000)
            i--;
        System.out.println(i + " is the desired number! :]");  // 109
    }
}
