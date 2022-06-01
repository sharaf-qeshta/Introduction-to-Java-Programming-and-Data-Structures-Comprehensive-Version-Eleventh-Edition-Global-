package chapter_ten;

/**
 * **10.27 (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following methods
 * (name the new class MyStringBuilder1):
 * public MyStringBuilder1(String s);
 * public MyStringBuilder1 append(MyStringBuilder1 s);
 * public MyStringBuilder1 append(int i);
 * public int length();
 * public char charAt(int index);
 * public MyStringBuilder1 toLowerCase();
 * public MyStringBuilder1 substring(int begin, int end);
 * public String toString();
 *
 * @author Sharaf Qeshta
 * */

public class Problem$27
{
    public static void main(String[] args)
    {
        MyStringBuilder1 string1 = new MyStringBuilder1("Sharaf");
        MyStringBuilder1 string2 = new MyStringBuilder1(" Qeshta");

        System.out.println(string1.append(string2)); // Sharaf Qeshta

        System.out.println(string1); // Sharaf Qeshta
        System.out.println(string1.length()); // 13

        System.out.println(string1.charAt(0)); // S
        System.out.println(string1.toLowerCase()); // sharaf qeshta

        System.out.println(string1.substring(0, 6)); // sharaf

        System.out.println(string1.toString()); // sharaf qeshta
    }
}

