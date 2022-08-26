package chapter_twenty_four;

/**
 * *24.13 (Fibonacci number iterator) Define an iterator class named Fibonacci
 * Iterator for iterating Fibonacci numbers. The constructor takes an argument
 * that specifies the limit of the maximum Fibonacci number. For example, new
 * FibonacciIterator(23302) creates an iterator that iterates Fibonacci numbers
 * less than or equal to 23302. Write a test program that uses this iterator to
 * display all Fibonacci numbers less than or equal to 120000.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$13
{
    public static void main(String[] args)
    {
        FibonacciIterator iterator = new FibonacciIterator(12_000);

        /* 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 */
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
