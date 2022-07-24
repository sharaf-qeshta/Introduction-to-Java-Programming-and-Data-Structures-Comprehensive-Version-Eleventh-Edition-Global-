package chapter_twenty;


import java.util.Comparator;

/**
 * *20.19 (Use Comparator) Write the following generic method using selection sort
 * and a comparator:
 * public static <E> void selectionSort(E[] list,
 *  Comparator<? super E> comparator)
 * Write a test program that creates an array of 10 GeometricObjects and
 * invokes this method using the GeometricObjectComparator introduced in
 * Listing 20.4 to sort the elements. Display the sorted elements. Use the following
 * statement to create the array:
 * GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
 *  new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
 *  new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
 *  new Circle(6.5), new Rectangle(4, 5)};
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$19
{
    public static void main(String[] args)
    {
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        selectionSort(list1, (e1, e2) -> new GeometricObjectComparator().compare(e1, e2));

        /*
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false, Circle, Created: Sun Jul 24 00:21:58 PDT 2022, Radius: 0.5
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false Rectangle, Created: Sun Jul 24 00:21:58 PDT 2022, Width: 4.4, Height: 1.0
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false Rectangle, Created: Sun Jul 24 00:21:58 PDT 2022, Width: 2.4, Height: 5.0
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false Rectangle, Created: Sun Jul 24 00:21:58 PDT 2022, Width: 4.0, Height: 5.0
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false Rectangle, Created: Sun Jul 24 00:21:58 PDT 2022, Width: 4.0, Height: 5.0
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false, Circle, Created: Sun Jul 24 00:21:58 PDT 2022, Radius: 4.5
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false, Circle, Created: Sun Jul 24 00:21:58 PDT 2022, Radius: 5.0
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false, Circle, Created: Sun Jul 24 00:21:58 PDT 2022, Radius: 5.5
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false, Circle, Created: Sun Jul 24 00:21:58 PDT 2022, Radius: 6.5
        *
        * created on Sun Jul 24 00:21:58 PDT 2022
        * color: white and filled: false Rectangle, Created: Sun Jul 24 00:21:58 PDT 2022, Width: 4.0, Height: 65.0
        * */
        for (GeometricObject object: list1)
            System.out.println(object);
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
