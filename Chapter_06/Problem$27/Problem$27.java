package chapter_six;

/**
 * **6.27 (Emirp) An emirp (prime spelled backward) is a nonpalindromic prime number
 * whose reversal is also a prime. For example, 17 is a prime and 71 is a prime, so
 * 17 and 71 are emirps. Write a program that displays the first 120 emirps. Display
 * 10 numbers per line, separated by exactly one space, as follows:
 * 13 17 31 37 71 73 79 97 107 113
 * 149 157 167 179 199 311 337 347 359 389
 * ...
 *
 * @author Sharaf Qeshta
 * */

public class Problem$27
{
    public static void main(String[] args)
    {
        /*
        * 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
        * 73, 79, 97, 101, 107, 113, 131, 149, 151, 157,
        * 167, 179, 181, 191, 199, 311, 313, 337, 347, 353,
        * 359, 373, 383, 389, 701, 709, 727, 733, 739, 743,
        * 751, 757, 761, 769, 787, 797, 907, 919, 929, 937,
        * 941, 953, 967, 971, 983, 991, 1009, 1021, 1031, 1033,
        * 1061, 1069, 1091, 1097, 1103, 1109, 1151, 1153, 1181, 1193,
        * 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1279,
        * 1283, 1301, 1321, 1381, 1399, 1409, 1429, 1439, 1453, 1471,
        * 1487, 1499, 1511, 1523, 1559, 1583, 1597, 1601, 1619, 1657,
        * 1669, 1723, 1733, 1741, 1753, 1789, 1811, 1831, 1847, 1867,
        * 1879, 1901, 1913, 1933, 1949, 1979, 3011, 3019, 3023,
        * */
        int i = 0;
        int n = 2;
        while (i < 119)
        {
            if (isPrime(n) && isPrime(getPalindrome(n)))
            {
                i++;
                System.out.print(n + ", ");
                if (i % 10 == 0)
                    System.out.println();
            }
            n++;
        }
    }

    public static boolean isPrime(int n)
    {
        for (int i = 2; i < (n/2)+1; i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    public static int getPalindrome(int n)
    {
        String reverse = "";
        String newN = "" + n;
        for (int i = newN.length()-1; i > -1;i--)
            reverse +=  newN.charAt(i);
        return Integer.parseInt(reverse);
    }

}
