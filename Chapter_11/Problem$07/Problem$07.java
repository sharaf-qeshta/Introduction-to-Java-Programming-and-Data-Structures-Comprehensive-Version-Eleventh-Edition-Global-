package chapter_eleven;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 11.7 (Shuffle ArrayList) Write the following method that shuffles the elements in
 * an ArrayList of integers:
 * public static void shuffle(ArrayList<Integer> list)
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        shuffle(list);

        /*
        * first run: [6, 9, 5, 2, 8, 3, 1, 7, 10, 4]
        * second run: [7, 5, 1, 9, 6, 4, 2, 3, 10, 8]
        * third run: [5, 4, 3, 7, 6, 9, 8, 2, 10, 1]
        * */
        System.out.println(list);
    }

    public static void shuffle(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            int randomIndex = (int) ((Math.random() * 10) % list.size());
            int temp = list.get(randomIndex);
            list.set(randomIndex, list.get(i));
            list.set(i, temp);
        }
    }
}
