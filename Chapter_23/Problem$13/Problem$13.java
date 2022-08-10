package chapter_twenty_three;

/**
 * *23.13 (Execution time for sorting) Write a program that obtains the execution time of
 * selection sort, bubble sort, merge sort, quick sort, heap sort, and radix sort for
 * input size 60,000, 120,000, 180,000, 240,000, 300,000, and 360,000.
 * Your program should create data randomly and print a table like this:
 * (Hint: You can use the following code template to obtain the execution time.)
 * long startTime = System.currentTimeMillis();
 * perform the task;
 * long endTime = System.currentTimeMillis();
 * long executionTime = endTime − startTime;
 * The text gives a recursive quick sort. Write a nonrecursive version in this exercise.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static final int[] RANGES = {60_000, 120_000, 180_000, 240_000, 300_000, 360_000};
    public static final String[] ALGORITHMS = {"Array", "Selection", "Bubble", "Merge", "Quick", "Heap", "Radix"};

    public static void main(String[] args)
    {
        /*
        * result =>
        * Array             Selection         Bubble            Merge             Quick             Heap              Radix
        * size              Sort              Sort              Sort              Sort              Sort              Sort
        * 60000             2764198800        5860937700        10426900          20709300          55926800          8543900
        * 120000            9593362800        28096101000       42801900          37320100          117388600         11847700
        * 180000            10293881300       51497312600       58980200          49629000          79236400          6566700
        * 240000            21165355400       111865735700      74421100          83394200          193656600         20902100
        * 300000            33712243300       159201461600      104954600         112893500         304887300         11855800
        * 360000            49984525400       228760035400      88391600          74116400          189869000         14279800
        * */
        for (int i = 0; i < ALGORITHMS.length; i++)
            System.out.printf("%-18s", ALGORITHMS[i]);

        System.out.println();
        System.out.printf("%-18s", "size");

        for (int i = 1; i < ALGORITHMS.length; i++)
            System.out.printf("%-18s", "Sort");

        System.out.println();

        for (int i = 0; i < RANGES.length; i++)
        {
            System.out.printf("%-18s", RANGES[i] + "");
            for (int j = 1; j < ALGORITHMS.length; j++)
                System.out.printf("%-18s", test(j, RANGES[i]) + "");
            System.out.println();
        }
    }

    public static long test(int algorithm, int dataSize)
    {
        if (algorithm == 1)
            return testSelectionSort(dataSize);
        if (algorithm == 2)
            return testBubbleSort(dataSize);
        if (algorithm == 3)
            return testMergeSort(dataSize);
        if (algorithm == 4)
            return testQuickSort(dataSize);
        if (algorithm == 5)
            return testHeapSort(dataSize);
        if (algorithm == 6)
            return testRadixSort(dataSize);
        return 0;
    }

    public static long testSelectionSort(int dataSize)
    {
        int[] array = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(array);
        long end = System.nanoTime();
        return end - start;
    }

    public static long testBubbleSort(int dataSize)
    {
        int[] array = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        long start = System.nanoTime();
        SortingAlgorithms.bubbleSort(array);
        long end = System.nanoTime();
        return end - start;
    }


    public static long testMergeSort(int dataSize)
    {
        int[] array = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        long start = System.nanoTime();
        SortingAlgorithms.mergeSort(array);
        long end = System.nanoTime();
        return end - start;
    }


    public static long testQuickSort(int dataSize)
    {
        int[] array = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        long start = System.nanoTime();
        SortingAlgorithms.quickSort(array, 0, dataSize-1);
        long end = System.nanoTime();
        return end - start;
    }

    public static long testHeapSort(int dataSize)
    {
        Integer[] array = new Integer[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        long start = System.nanoTime();
        SortingAlgorithms.heapSort(array);
        long end = System.nanoTime();
        return end - start;
    }


    public static long testRadixSort(int dataSize)
    {
        int[] array = new int[dataSize];
        for (int i = 0; i < dataSize; i++)
            array[i] = (int) (Math.random() * 1000); // 0 => 1000
        long start = System.nanoTime();
        SortingAlgorithms.radixSort(array);
        long end = System.nanoTime();
        return end - start;
    }
}
