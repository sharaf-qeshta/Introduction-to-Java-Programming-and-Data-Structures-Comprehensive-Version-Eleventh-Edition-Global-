package chapter_eighteen;


/**
 * *18.15 (Occurrences of a specified character in a string) Rewrite Programming Exercise
 * 18.10 using a helper method to pass the substring high index to the method.
 * The helper method header is
 * public static int count(String str, char a, int high)
 *
 *
 * @author Sharaf Qeshta
 */
public class Problem$15
{
    public static int occurrences = 0;

    public static void main(String[] args)
    {
        System.out.println(count("Welcome", 'e')); // 2
        occurrences = 0;

        System.out.println(count("Sharaf", 'a')); // 2
        occurrences = 0;

        System.out.println(count("Qeshta", 'h')); // 1
        occurrences = 0;

        System.out.println(count("Well", 'l')); // 2
    }

    public static int count(String str, char a)
    {
        if (str.contains(a + ""))
            return count(str, a, str.lastIndexOf(a));
        return occurrences;
    }

    public static int count(String str, char a, int high)
    {
        if (str.contains(a + ""))
        {
            occurrences++;
            return count(str.substring(0, high), a);
        }
        return occurrences;
    }
}
