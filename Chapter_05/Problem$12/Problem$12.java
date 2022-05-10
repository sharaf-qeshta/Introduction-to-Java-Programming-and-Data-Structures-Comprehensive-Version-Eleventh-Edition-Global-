package chapter_five;

/**
 * 5.12 (Find the smallest n such that n3 7 12,000) Use a while loop to find the smallest
 * integer n such that n3 is greater than 12,000
 *
 * @author Sharaf Qeshta
 * */

public class Problem$12
{
    public static void main(String[] args)
    {
        int i = 0;
        while ( i * i * i < 12000)
            i++;
        System.out.println(i + " is the desired number! :]");  // 23
    }
}
