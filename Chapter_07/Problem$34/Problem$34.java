package chapter_seven;


/**
 * **7.34 (Sort characters in a string) Write a method that returns a sorted string using the
 * following header:
 * public static String sort(String s)
 * For example, sort("acb") returns abc.
 * Write a test program that prompts the user to enter a string and displays the sorted
 * string.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$34
{
    public static void main(String[] args)
    {
        System.out.println(sort("acb")); // abc
        System.out.println(sort("sharaf")); // aafhrs
    }


    public static String sort(String s)
    {
        char[] out = s.toCharArray();
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for (int i = 0; i < out.length-1;i++)
            {
                if (Character.toLowerCase(out[i]) > Character.toLowerCase(out[i+1]))
                {
                    char temp = out[i];
                    out[i] = out[i+1];
                    out[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return String.valueOf(out);
    }
}
