package chapter_twenty_seven;



/**
 * *27.13 (The Date class) Design a class named Date that meets the following
 * requirements:
 * ■■ Three data fields year, month, and day for representing a date
 * ■■ A constructor that constructs a date with the specified year, month, and day
 * ■■ Override the equals method
 * ■■ Override the hashCode method. (For reference, see the implementation of the
 * Date class in the Java API)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        Date d1 = new Date(2022, 9, 10);
        Date d2 = new Date(2022, 9, 10);
        Date d3 = new Date(2022, 9, 11);

        System.out.println(d1.hashCode()); // 2022910
        System.out.println(d2.hashCode()); // 2022910
        System.out.println(d3.hashCode()); // 2022911

        System.out.println(d1.equals(d2)); // true
        System.out.println(d1.equals(d3)); // false
    }
}
