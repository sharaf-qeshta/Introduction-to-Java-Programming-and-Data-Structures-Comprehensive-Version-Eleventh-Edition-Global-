package chapter_nine;

/**
 * *9.6 (Stopwatch) Design a class named StopWatch. The class contains:
 * ■■ Private data fields startTime and endTime with getter methods.
 * ■■ A no-arg constructor that initializes startTime with the current time.
 * ■■ A method named start() that resets the startTime to the current time.
 * ■■ A method named stop() that sets the endTime to the current time.
 * ■■ A method named getElapsedTime() that returns the elapsed time for the
 * stopwatch in milliseconds.
 * Draw the UML diagram for the class then implement the class. Write a test program
 * that measures the execution time of sorting 100,000 numbers using selection sort.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$06
{
    public static void main(String[] args)
    {
        int[] arr = new int[100_000];
        for (int i = 99_999; i > -1; i--)
            arr[i] = i;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        selectionSort(arr);

        stopWatch.stop();

        /* 6668 Milliseconds */
        System.out.println("Time Taken to Sort 100,000 elements is " + stopWatch.getElapsedTime() + " Milliseconds");
    }

    public static void selectionSort(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_index = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] > arr[min_index])
                    min_index = j;

            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
}
