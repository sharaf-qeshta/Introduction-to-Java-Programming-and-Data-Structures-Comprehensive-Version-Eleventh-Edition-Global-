package chapter_seven;

/**
 * 7.16 (Execution time) Write a program that creates an array of numbers from 1 to
 * 100,000,000 in ascending order. Display the execution time of invoking the
 * linearSearch method and the binarySearch method in Listings 7.6 and
 * 7.7 respectively. Display the execution time of invoking both searches for the
 * following numbers: 1; 25,000,000; 50,000,000; 75,000,000; 100,000,000. You can
 * use the following code template to obtain the execution time:
 * long startTime = System.nanoTime();
 * perform the task;
 * long endTime = System.nanoTime();
 * long executionTime = endTime − startTime;
 *
 * @author Sharaf Qeshta
 * */


public class Problem$16
{
    public static void main(String[] args)
    {

        /*
        * it takes 17000 nano seconds for binary search to find 1
        * it takes 3600 nano seconds for linear search to find 1
        * it takes 2600 nano seconds for binary search to find 25000000
        * it takes 31398700 nano seconds for linear search to find 25000000
        * it takes 2100 nano seconds for binary search to find 50000000
        * it takes 42306400 nano seconds for linear search to find 50000000
        * it takes 2600 nano seconds for binary search to find 75000000
        * it takes 69614100 nano seconds for linear search to find 75000000
        * it takes 7700 nano seconds for binary search to find 100000000
        * it takes 79754400 nano seconds for linear search to find 100000000
        * */
        int[] list = new int[100_000_000];

        for (int i = 1; i < list.length;i++)
            list[i-1] = i;

        int number = 1;
        for (int i = 0; i < 5; i++, number = (i * 25_000_000))
        {
            long start = System.nanoTime();
            binarySearch(list, 0, list.length-1, number);
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("it takes "  + time + " nano seconds for binary search to find " + number);

            start = System.nanoTime();
            linearSearch(list,  number);
            end = System.nanoTime();
            time = end - start;
            System.out.println("it takes "  + time + " nano seconds for linear search to find " + number);
        }
    }

    public static void binarySearch(int[] arr, int first, int last, int key)
    {
        if (first > last)
        {
            System.out.println("Enter A Valid Range!");
        }

        int mid = (first + last) / 2;
        while (first <= last)
        {
            if (arr[mid] < key)
                first = mid + 1;
            else if (arr[mid] == key)
                return;
            else
                last = mid - 1;
            mid = (first + last) / 2;
        }
    }

    public static void linearSearch(int[] array, int element)
    {
        for (int x: array)
        {
            if (x == element)
                return;
        }
    }
}
