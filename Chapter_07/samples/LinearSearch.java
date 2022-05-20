package chapter_seven.samples;

/**
 * Listing 7.6 LinearSearch.java
 */
public class LinearSearch
{
    /**
     * The method for finding a key in the list
     */
    public static int linearSearch(int[] list, int key)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (key == list[i])
                return i;
        }
        return -1;
    }
}
