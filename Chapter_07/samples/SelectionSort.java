package chapter_seven.samples;

/**
 * Listing 7.8 SelectionSort.java
 * */
public class SelectionSort
{
    /**
     * The method for sorting the numbers
     */
    public static void selectionSort(double[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            // Find the minimum in the list[i..list.length−1]
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++)
            {
                if (currentMin > list[j])
                {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i)
            {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
