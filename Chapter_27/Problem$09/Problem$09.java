package chapter_twenty_seven;

/**
 * **27.9 (Implement hashCode for string) Write a method that returns a hash code for string
 * using the approach described in Section 27.3.2 with b value 31. The function
 * header is as follows:
 * public static int hashCodeForString(String s)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$09
{
    public static final int B = 31;

    public static void main(String[] args)
    {
        System.out.println("Java".hashCode()); // 2301506
        System.out.println(hashCodeForString("Java")); // 2301506

        System.out.println("Programming".hashCode()); // -1615787847
        System.out.println(hashCodeForString("Programming")); // -1615787847

        System.out.println("sharaf".hashCode()); // -903566357
        System.out.println(hashCodeForString("sharaf")); // -903566357
    }

    public static int hashCodeForString(String s)
    {
        int hashCode = 0;
        for (int i = 0; i < s.length(); i++)
            hashCode = hashCode * B + s.charAt(i);
        return hashCode;
    }
}
