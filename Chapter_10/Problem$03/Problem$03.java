package chapter_ten;

/**
 * 10.3 (The MyInteger class) Design a class named MyInteger. The class contains:
 * ■■ An int data field named value that stores the int value represented by
 * this object.
 * ■■ A constructor that creates a MyInteger object for the specified int value.
 * ■■ A getter method that returns the int value.
 * ■■ The methods isEven(), isOdd(), and isPrime() that return true if the
 * value in this object is even, odd, or prime, respectively.
 * ■■ The static methods isEven(int), isOdd(int), and isPrime(int) that
 * return true if the specified value is even, odd, or prime, respectively.
 * ■■ The static methods isEven(MyInteger), isOdd(MyInteger), and
 * isPrime(MyInteger) that return true if the specified value is even, odd,
 * or prime, respectively.
 * ■■ The methods equals(int) and equals(MyInteger) that return true if
 * the value in this object is equal to the specified value.
 * ■■ A static method parseInt(char[]) that converts an array of numeric
 * characters to an int value.
 * ■■ A static method parseInt(String) that converts a string into an int value.
 * Draw the UML diagram for the class then implement the class. Write a client
 * program that tests all methods in the class.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    public static void main(String[] args)
    {
        MyInteger integer1 = new MyInteger(10);
        MyInteger integer2 = new MyInteger(11);

        System.out.println(integer1.isOdd()); // false
        System.out.println(integer1.isEven()); // true
        System.out.println(integer2.isPrime()); // true
        System.out.println(integer2.getValue()); // 11
        System.out.println(integer2.equals(integer1)); // false
        System.out.println(integer2.equals(10)); // false

        // static methods
        System.out.println(MyInteger.isOdd(10)); // false
        System.out.println(MyInteger.isOdd(integer2)); // true
        System.out.println(MyInteger.isEven(10)); // true
        System.out.println(MyInteger.isEven(integer1)); // true
        System.out.println(MyInteger.isPrime(integer1)); // false
        System.out.println(MyInteger.isPrime(13)); // true
        System.out.println(MyInteger.parseInt(new char[] {'1', '2', '3'}) + 10); // 133
        System.out.println(MyInteger.parseInt("584") + 10); // 594
    }
}
