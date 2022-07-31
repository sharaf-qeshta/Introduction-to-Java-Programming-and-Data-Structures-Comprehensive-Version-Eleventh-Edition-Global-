package chapter_twenty_two;

import java.util.ArrayList;


/** Listing 22.6 EfficientPrimeNumbers.java */
public class EfficientPrimeNumbers
{
    public static void efficientPrimeNumbers(int n)
    {
        int number = 2;

        int squareRoot = 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (number <= n)
        {
            boolean isPrime = true;
            if (squareRoot * squareRoot < number) squareRoot++;

            for (int k = 0; k < list.size()
                    && list.get(k) <= squareRoot; k++)
            {
                if (number % list.get(k) == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                list.add(number);
            }
            number++;
        }
    }
}
