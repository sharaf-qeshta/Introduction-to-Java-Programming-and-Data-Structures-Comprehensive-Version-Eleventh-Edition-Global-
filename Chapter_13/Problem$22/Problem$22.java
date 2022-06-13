package chapter_thirteen;


/**
 * *13.22 (The ComparableSquare class) Define a class named ComparableSquare that
 * extends Square and implements Comparable. Implement the compareTo method
 * to compare the Squares on the basis of area. Write a test class to find the larger of
 * two instances of ComparableSquareobjects.
 *
 * @author Sharaf Qeshta
 * */
public class Problem$22
{
    public static void main(String[] args)
    {
        ComparableSquare square1 = new ComparableSquare(5);
        ComparableSquare square2 = new ComparableSquare(8);

        /* 8.0 */
        System.out.println(
                (square1.compareTo(square2) > 0 ?
                        square1.getSideLength() : square2.getSideLength()));
    }
}


