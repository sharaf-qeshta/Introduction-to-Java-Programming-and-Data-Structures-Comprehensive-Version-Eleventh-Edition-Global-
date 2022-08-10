package chapter_twenty_three;

public class SortingAlgorithms
{
    /**
     * selection sort algorithm
     * time complexity: O(n²)
     * space complexity: O(1)
     * */
    public static void selectionSort(int[] array)
    {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
        {
            int index = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[index])
                    index = j;
            int t = array[index];
            array[index] = array[i];
            array[i] = t;
        }
    }


    /**
     * bubble sort Algorithm
     * time complexity: O(n²)
     * space complexity: O(1)
     * */
    public static void bubbleSort(int[] list)
    {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++)
        {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++)
            {
                if (list[i] > list[i + 1])
                {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }


    /**
     * merge sort algorithm
     * time complexity: O(n log n)
     * space complexity: O(n)
     * */
    public static void mergeSort(int[] list)
    {
        if (list.length > 1)
        {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * for merge sort
     */
    private static void merge(int[] list1, int[] list2, int[] temp)
    {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length)
        {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }


    /**
     * quick sort algorithm
     * time complexity: O(n log n)
     * space complexity: O(n log n)
     * */
    public static void quickSort(int[] array, int l, int h)
    {
        int[] stack = new int[h - l + 1];

        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0)
        {
            h = stack[top--];
            l = stack[top--];

            int p = partition(array, l, h);

            if (p - 1 > l)
            {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h)
            {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    /**
     * for quick sort
     * */
    private static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * heap sort algorithm
     * time complexity: O(n log n)
     * space complexity: O(1)
     * */
    public static void heapSort(Integer[] list)
    {
        Heap<Integer> heap = new Heap<>();

        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    /**
     * radix sort algorithm
     * time complexity: O(n)
     * space complexity: O(n)
     * */
    public static void radixSort(int[] array)
    {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(array, exp);
    }

    /**
     * for radix sort
     * */
    private static void countSort(int[] array, int exp)
    {
        int[] output = new int[array.length];
        int i;
        int[] count = new int[10]; // ten buckets

        for (i = 0; i < array.length; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];


        for (i = array.length - 1; i >= 0; i--)
        {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < array.length; i++)
            array[i] = output[i];
    }
}
