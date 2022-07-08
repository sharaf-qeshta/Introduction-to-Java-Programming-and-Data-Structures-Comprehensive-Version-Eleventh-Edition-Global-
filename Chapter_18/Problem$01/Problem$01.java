package chapter_eighteen;

/**
 * *18.1 (Identifying anagrams) Two words are anagrams of each other if they contain the
 * same letters that are arranged in different orders. Write a recursive method that
 * can identify if two given words are anagrams of each other.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        System.out.println(isAnagrams("anagram", "nagaram")); // true
        System.out.println(isAnagrams("below", "elbow")); // true
        System.out.println(isAnagrams("study", "dusty")); // true
        System.out.println(isAnagrams("night", "thing")); // true
        System.out.println(isAnagrams("act", "cat")); // true
        System.out.println(isAnagrams("hello", "world")); // false
        System.out.println(isAnagrams("Sharaf", "Qeshta")); // false
    }

    public static boolean isAnagrams(String s1, String s2)
    {
        if (!s2.contains(s1.charAt(0) + ""))
            return false;
        if (s1.length() <= 1)
            return true;
        return isAnagrams(s1.substring(1), s2);
    }
}
