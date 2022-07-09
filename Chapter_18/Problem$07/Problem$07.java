package chapter_eighteen;

/**
 * *18.7 (Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java, so that the program
 * finds the number of times the fib method is called. (Hint: Use a static
 * variable and increment it every time the method is called.)
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$07
{
    public static int numberOfInvokes = 0;

    public static void main(String[] args)
    {
        System.out.println(calculateFibonacci(6)); // 8
        System.out.println(numberOfInvokes); // 25
    }

    public static long calculateFibonacci(int index)
    {
        numberOfInvokes++;
        if (index == 0 || index == 1)
            return index;
        return calculateFibonacci(index - 1) + calculateFibonacci(index - 2);
    }
}
