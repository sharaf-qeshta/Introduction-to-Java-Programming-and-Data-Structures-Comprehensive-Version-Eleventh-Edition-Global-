package chapter_ten;

/**
 * **10.22 (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new class MyString1):
 * public MyString1(char[] chars);
 * public char charAt(int index);
 * public int length();
 * public MyString1 substring(int begin, int end);
 * public MyString1 toLowerCase();
 * public boolean equals(MyString1 s);
 * public static MyString1 valueOf(int i);
 *
 * @author Sharaf Qeshta
 * */

public class Problem$22
{
    public static void main(String[] args)
    {
        MyString1 myString1 = new MyString1(new char[] {'a', 'B', 'C'});
        System.out.println(myString1.charAt(0)); // a
        System.out.println(myString1.length()); // 3
        System.out.println(myString1.substring(0, 2).getStr()); // aB
        myString1.toLowerCase();
        System.out.println(myString1.getStr()); // abc
        System.out.println(myString1.equals(new MyString1(new char[] {'a', 'B', 'C'}) )); // false
        System.out.println(MyString1.valueOf(10).getStr()); // 10
    }
}

