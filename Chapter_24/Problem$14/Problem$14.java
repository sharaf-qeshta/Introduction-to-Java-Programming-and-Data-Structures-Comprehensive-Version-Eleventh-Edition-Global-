package chapter_twenty_four;

/**
 * *24.14 (Prime number iterator) Define an iterator class named PrimeIterator for
 * iterating prime numbers. The constructor takes an argument that specifies the limit
 * of the maximum prime number. For example, new PrimeIterator(23302)
 * creates an iterator that iterates prime numbers less than or equal to 23302. Write
 * a test program that uses this iterator to display all prime numbers less than or
 * equal to 120000. 
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$14
{
    public static void main(String[] args)
    {
        PrimeIterator iterator = new PrimeIterator(12_000);

        /* 2 3 5 7 11 13 17 19 23 29 31 37 41 ........ 11953 11959 11969 11971 11981 11987 */
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
