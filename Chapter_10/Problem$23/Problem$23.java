package chapter_ten;

/**
 * **10.23 (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new class MyString2):
 * public MyString2(String s);
 * public int compare(String s);
 * public MyString2 substring(int begin);
 * public MyString2 toUpperCase();
 * public char[] toChars();
 * public static MyString2 valueOf(boolean b);
 *
 * @author Sharaf Qeshta
 * */

public class Problem$23
{
    public static void main(String[] args)
    {
        MyString2 myString2 = new MyString2("abc");

        System.out.println(myString2.compare("abc")); // 0
        System.out.println(myString2.substring(1).getStr()); // bc
        System.out.println(myString2.toUpperCase().getStr()); // ABC
        System.out.println(myString2.toChars()); // abc
        System.out.println(MyString2.valueOf(true).getStr()); // true
    }
}

