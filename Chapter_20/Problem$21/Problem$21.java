package chapter_twenty;

import java.util.Arrays;
import java.util.Comparator;

/**
 * *20.21 (Use Comparator) Write the following generic method using selection sort
 * and a comparator:
 * public static <E> void selectionSort(E[] list,
 *  Comparator<? super E> comparator)
 * Write a test program that creates an array of 10 GeometricObjects and
 * invokes this method using the GeometricObjectComparator introduced in
 *
 * Listing 20.5 to sort the elements. Display the sorted elements. Use the following
 * statement to create the array:
 * GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
 *  new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
 *  new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
 *  new Circle(6.5), new Rectangle(4, 5)};
 * Also in the same program, write the code that sorts six strings by their last
 * character. Use the following statement to create the array:
 * String[] list2 = {"red", "blue", "green", "yellow", "orange",
 *  "pink"};
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$21
{
    public static void main(String[] args)
    {
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        selectionSort(list1, (e1, e2) -> new GeometricObjectComparator().compare(e1, e2));

        System.out.println(Arrays.toString(list1));

        String[] list2 = {"red", "blue", "green", "yellow", "orange", "pink"};
        selectionSort(list2, Comparator.comparingInt(s -> s.charAt(s.length()-1)));

        /* [red, blue, orange, pink, green, yellow] */
        System.out.println(Arrays.toString(list2));
    }

    public static <E> void selectionSort(E[] list,
                                         Comparator<? super E> comparator)
    {
        for (int i = 0; i < list.length; i++)
        {
            int min = i;
            for (int j = i+1; j < list.length; j++)
            {
                if (comparator.compare(list[min], list[j]) > 0)
                    min = j;
            }
            E temp = list[min];
            list[min] = list[i];
            list[i] = temp;
        }
    }
}
