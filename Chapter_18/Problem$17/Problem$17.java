package chapter_eighteen;

import java.util.Arrays;

/**
 * *18.17 Write a recursive method that finds the kth-smallest value of a given array. Use
 * the method pos of Programming Exercise 18.16.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17
{
    public static void main(String[] args)
    {
        int[] a = {8,7,4,1,9,6,2,5,3,0};
        System.out.println(findKthSmallestValue(a.clone(),1, false)); // 0
        System.out.println(findKthSmallestValue(a.clone(),2, false)); // 1
        System.out.println(findKthSmallestValue(a.clone(),3, false)); // 2
        System.out.println(findKthSmallestValue(a.clone(),4, false)); // 3
    }

    public static int findKthSmallestValue(int[] a, int k, boolean sorted)
    {
        if (sorted)
            return a[k-1];
        sorted = true;
        for (int i = 0; i < a.length-1; i++)
        {
            if (a[i] > a[i+1])
            {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                sorted = false;
            }
        }
        return findKthSmallestValue(a,k, sorted);
    }

}
