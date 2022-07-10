package chapter_eighteen;


/**
 * **18.12 (Print the characters in a string reversely) Rewrite Programming Exercise 18.9
 * using a helper method to pass the substring high index to the method. The
 * helper method header is
 * public static void reverseDisplay(String value, int high)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$12
{
    public static void main(String[] args)
    {
        reverseDisplay("Welcome", "Welcome".length()-1); // emocleW
    }

    public static void reverseDisplay(String value, int high)
    {
        if (high > -1)
        {
            System.out.print(value.charAt(high));
            reverseDisplay(value, high-1);
        }
    }
}
