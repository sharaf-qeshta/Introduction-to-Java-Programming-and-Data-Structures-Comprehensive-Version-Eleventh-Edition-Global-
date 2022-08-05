package chapter_twenty_two;

/**
 * *22.24 (Find the smallest number) Write a method that uses the divide-and-conquer
 * approach to find the smallest number in a list.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$24
{
    public static void main(String[] args)
    {
        int[] integers = {15, 100, -9, -99, 88, 45, 0, -1};
        System.out.println(min(integers)); // -99
    }


    public static int min(int[] list)
    {
        int middle = list.length/2;
        int min1 = min(list, 0, middle, list[0]);
        int min2 = min(list, middle+1, list.length-1, list[middle+1]);
        return Math.min(min1, min2);
    }


    public static int min(int[] list, int start, int end, int min)
    {
        if (start == end)
            return min;
        if (list[start] < min)
            min = list[start];
        if (list[end] < min)
            min = list[end];
        return min(list, start+1, end-1, min);
    }
}
