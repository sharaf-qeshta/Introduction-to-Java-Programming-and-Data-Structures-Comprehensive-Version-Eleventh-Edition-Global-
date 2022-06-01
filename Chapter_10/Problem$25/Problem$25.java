package chapter_ten;

import java.util.Arrays;

/**
 * **10.25 (New string split method) The split method in the String class returns an
 * array of strings consisting of the substrings split by the delimiters. However, the
 * delimiters are not returned. Implement the following new method that returns
 * an array of strings consisting of the substrings split by the matching delimiters,
 * including the matching delimiters.
 * public static String[] split(String s, String regex)
 * For example, split("ab#12#453", "#") returns ab, #, 12, #, and 453 in
 * an array of String and split("a?b?gf#e", "[?#]") returns a, ?, b, ?, gf,
 * #, and e in an array of String.
 *
 * @author Sharaf Qeshta
 * */

public class Problem$25
{
    public static void main(String[] args)
    {
        /* [ab, #, 12, #, 453] */
        System.out.println(Arrays.toString(split("ab#12#453", "#")));

        /* [a, ?, b, ?, gf, #, e] */
        System.out.println(Arrays.toString(split("a?b?gf#e", "[?#]")));

        /* [s, !, h, @, a, #, r, $, a, %, f, ^, q, &, e, (, s, ), h, ~, t, /, a] */
        System.out.println(Arrays.toString(split("s!h@a#r$a%f^q&e(s)h~t/a",
                "[!@#$%^&()~/]")));
    }

    public static String[] split(String s, String regex)
    {
        String[] elements = new String[s.length()];
        int i;
        String element = "";
        int j = 0;
        for (i = 0; i < s.length(); i++)
        {
            char x = s.charAt(i);
            if (isIn(x, regex))
            {
                elements[j++] = element;
                elements[j++] = x + "";
                element = "";
            }
            else
                element += x;
        }
        elements[j] = element;

        String[] trimmed = new String[j+1];
        System.arraycopy(elements, 0, trimmed, 0, trimmed.length);
        return trimmed;
    }

    public static boolean isIn(char child, String parent)
    {
        if (child == '[' || child == ']')
            return false;
        for (int i = 0; i < parent.length(); i++)
            if (parent.charAt(i) == child)
                return true;
        return false;
    }
}

