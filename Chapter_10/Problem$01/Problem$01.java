package chapter_ten;

/**
 * *10.1 (The Time class) Design a class named Time. The class contains:
 * ■■ The data fields hour, minute, and second that represent a time.
 * ■■ A no-arg constructor that creates a Time object for the current time. (The
 * values of the data fields will represent the current time.)
 * ■■ A constructor that constructs a Time object with a specified elapsed time
 * since midnight, January 1, 1970, in milliseconds. (The values of the data
 * fields will represent this time.)
 * ■■ A constructor that constructs a Time object with the specified hour, minute,
 * and second.
 * ■■ Three getter methods for the data fields hour, minute, and second,
 * respectively.
 * ■■ A method named setTime(long elapseTime) that sets a new time for the
 * object using the elapsed time. For example, if the elapsed time is 555550000
 * milliseconds, the hour is 10, the minute is 19, and the second is 10.
 * Draw the UML diagram for the class then implement the class. Write a
 * test program that creates three Time objects (using new Time(), new
 * Time(555550000), and new Time(5, 23, 55)) and displays their hour,
 * minute, and second in the format hour:minute:second.
 * (Hint: The first two constructors will extract the hour, minute, and second
 * from the elapsed time. For the no-arg constructor, the current time can be
 * obtained using System.currentTimeMillis(), as shown in Listing 2.7,
 * ShowCurrentTime.java. Assume the time is in GMT.)
 *
 *
 * @author Sharaf Qeshta
 * */

public class Problem$01
{
    public static void main(String[] args)
    {
        Time t1 = new Time();
        Time t2 = new Time(555550000);
        Time t3 = new Time(5, 23, 55);

        System.out.println(t1.getString()); // 12:14:8
        System.out.println(t2.getString()); // 10:19:10
        System.out.println(t3.getString()); // 5:23:55
    }
}
